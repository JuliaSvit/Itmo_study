
import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.util.stream.Collectors.toList;

public class WordCountQueue {
    private static Map<String, Integer> result = new HashMap<>();
    private static BlockingQueue<Map<String, Integer>> resultQueue = new LinkedBlockingQueue<>();

    private static final String STOP = new String();
    private static int stopCount = 0;

    // TODO
    // Задача №2
    // Результаты сложить в другую очередь для main,
    // а main сольет их вместе.

    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream in = WordCountQueue.class.getClassLoader().getResourceAsStream("wp.txt");
//        InputStream in = new BufferedInputStream(new FileInputStream(new File("src/wordcountqueue/text.txt")));
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));

        List<String> lines = rdr.lines().collect(toList());
        int cpus = Runtime.getRuntime().availableProcessors();

        List<WordCountThread> workers = new ArrayList<>();
        BlockingQueue<String> linesQueue = new LinkedBlockingQueue<>(lines);

        for (int i = 0; i < cpus; i++) {
            // TODO implement
            linesQueue.put(STOP);
            WordCountThread wct = new WordCountThread(linesQueue);
            workers.add(wct);
            wct.start();
        }

        // В добавить lines в linesQueue.

        joinToAll(cpus);

        // Выбрать топ 10 из result
        topWords(10);
    }

    private static void joinToAll(int cpus) throws InterruptedException{
        while (stopCount!=cpus) {
            Map<String,Integer> map = resultQueue.take();
            if(map.containsKey(STOP)){
                stopCount++;
                continue;
            }
            for(Map.Entry entry: map.entrySet()){
                String word = entry.getKey().toString();
                if(result.containsKey(word)){
                    int temp = map.get(word) + result.get(word);
                    result.put(word,temp);
                } else {
                    result.put(word,map.get(word));
                }
            }
        }
    }

    private static void topWords(int top){
        ArrayList<Integer> t = new ArrayList<>();
        int count = 0;
        for (Map.Entry entry : result.entrySet()) {
            t.add((Integer) entry.getValue());
        }
        Collections.sort(t, Collections.reverseOrder());
        for (int i = 0; i < top; i++) {
            for (Map.Entry entry : result.entrySet()) {
                int temp = (int) entry.getValue();
                if (t.get(i) == temp) {
                    System.out.println("* " + entry.getKey() + " - " + entry.getValue());
                    count++;
                }
                if(count >= top){break;}
            }
        }
    }

    private static class WordCountThread extends Thread {
        private final BlockingQueue<String> linesQueue;
        private Map<String, Integer> wordCnt = new HashMap<>();

        public WordCountThread(BlockingQueue<String> linesQueue) {
            this.linesQueue = linesQueue;
        }

        @Override
        public void run() {
            // Считаем в wordCnt
            while (!isInterrupted()) {
                try {
                    String line = linesQueue.take();
                    if (line == STOP){
                        wordCnt.put(STOP,0);
                        resultQueue.put(new HashMap<>(wordCnt));
                        wordCnt.clear();
                        break;
                    }
                    // Код обработки строки,
                    String line2 = line.toLowerCase().replaceAll("[^a-zA-Z_'-]", " ")
                            .replaceAll("--", " ");
                    if (!line2.isEmpty()){
                        String[] str = line2.split(" ");
                        for(String s: str){
                            s = s.replaceAll("^['-]|['-]$","");
                            if (!s.isEmpty()){
                                if (wordCnt.containsKey(s)) {
                                    wordCnt.put(s, wordCnt.get(s) + 1);
                                } else {
                                    wordCnt.put(s, 1);
                                }
                            }
                        }
                    }
                    // добавляем результат в очередь
                    if(!wordCnt.isEmpty()){
                        resultQueue.put(new HashMap<>(wordCnt));
                        wordCnt.clear();
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

}