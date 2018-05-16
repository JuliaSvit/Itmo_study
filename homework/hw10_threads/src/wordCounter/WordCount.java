package wordCounter;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class WordCount {
    private static Map<String, Integer> result = new HashMap<>();
    private final static Object monitor = new Object();

    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream in = WordCount.class.getClassLoader().getResourceAsStream("wp.txt");

        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));

        List<String> lines = rdr.lines().collect(toList());

        int cpus = Runtime.getRuntime().availableProcessors();

        List<WordCountThread> workers = new ArrayList<>();

        int part = lines.size()/cpus+1;
        for (int i = 0; i < lines.size(); i+=part) {
            int endPart = i + part < lines.size()? i + part : lines.size()-1;
            WordCountThread wct = new WordCountThread(lines.subList(i, endPart));
            workers.add(wct);
            wct.start();
        }

        for (WordCountThread worker : workers)
            worker.join();

        // Выбрать топ 100 из result
        topWords(100);
    }

    private static void topWords(int top){
        ArrayList<Integer> t = new ArrayList<>();
        int count = 0;
        for (Map.Entry entry : WordCountThread.allWordCnt.entrySet()) {
            t.add((Integer) entry.getValue());
        }
        Collections.sort(t, Collections.reverseOrder());
        for (int i = 0; i < top; i++) {
            for (Map.Entry entry : WordCountThread.allWordCnt.entrySet()) {
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
        private List<String> words;
        private Map<String, Integer> wordCnt = new HashMap<>();
        private final static Map<String, Integer> allWordCnt = new HashMap<>();

        public WordCountThread(List<String> words) {
            this.words = words;
        }

        @Override
        public void run() {
            // Считаем в wordCnt
            for(String line: words){
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
            }
            // Сливаем в общую Map
            joinToAll(wordCnt);
        }

        private static void joinToAll(Map<String,Integer> map){
            synchronized (monitor){
                if(allWordCnt.size()==0){
                    allWordCnt.putAll(map);
                } else {
                    for (Map.Entry entry : map.entrySet()) {
                        String word = (String) entry.getKey();
                        int value = map.get(word);
                        if(allWordCnt.containsKey(word)){
                            int allValue = allWordCnt.get(word);
                            allWordCnt.put(word, allValue + value);
                        } else {
                            allWordCnt.put(word,value);
                        }
                    }
                }
            }

        }
    }
}
