
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.toList;

public class WordCountPool {
    private static Map<String, Integer> result = new HashMap<>();
    
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException {
        InputStream in = WordCountPool.class.getClassLoader().getResourceAsStream("wp.txt");
//        InputStream in = new BufferedInputStream(new FileInputStream(new File("src/wordcountpool/text.txt")));

        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));

        List<String> lines = rdr.lines().collect(toList());

        int cpus = Runtime.getRuntime().availableProcessors();

        ExecutorService pool = Executors.newFixedThreadPool(cpus);

        List<Future<Map<String, Integer>>> futs = new ArrayList<>();

        int part = lines.size()/cpus+1;
        for (int i = 0; i < lines.size(); i+=part) {
            // TODO submit WordCountTask into pool, futures add to futs
            int endPart = i + part < lines.size()? i + part : lines.size()-1;
            Future<Map<String, Integer>> fut = pool.submit(new WordCountTask(lines.subList(i, endPart)));
            futs.add(fut);
        }

        for (Future<Map<String, Integer>> fut : futs) {
            // TODO collect results
            Map<String, Integer> map = new HashMap<>(fut.get());
            if(result.isEmpty()){
                result.putAll(map);
            }else{
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
        pool.shutdown();
        topWords(10);
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
    
    private static class WordCountTask implements Callable<Map<String, Integer>> {
        private final List<String> lines;

        public WordCountTask(List<String> lines) {
            this.lines = lines;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> res = new HashMap<>();
            // TODO count words
            for(String line: lines){
                    String line2 = line.toLowerCase().replaceAll("[^a-zA-Z_'-]", " ")
                            .replaceAll("--", " ");
                    if (!line2.isEmpty()){
                        String[] str = line2.split(" ");
                        for(String s: str){
                            s = s.replaceAll("^['-]|['-]$","");
                            if (!s.isEmpty()){
                                if (res.containsKey(s)) {
                                    res.put(s, res.get(s) + 1);
                                } else {
                                    res.put(s, 1);
                                }
                            }
                        }
                    }
            }
            return res;
        }
    }
}