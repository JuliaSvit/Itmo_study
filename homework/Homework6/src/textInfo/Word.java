package textInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


public class Word {
    private Map <String,Integer> words = new HashMap<>();
    private Map <Integer,Set> groupWords = new HashMap<>();
    private Map <Integer,Set> filterGroupWord = new HashMap<>();
    private Set <String> article = new HashSet<String>();

    /*слова через дефис пишет слитно*/
    public Word(List<String> lines) throws IOException {
        for(String line: lines){
            String line2 = line.toLowerCase().replaceAll("[^a-zA-Z]", " ").trim();
            if (!line2.isEmpty()){
                String[] str = line2.split(" ");
                for(String s: str){
                    if (!s.isEmpty()){
                        if (words.containsKey(s)) {
                            words.put(s, words.get(s) + 1);
                        } else {
                            words.put(s, 1);
                        }
                    }
                }
            }
        }

        File txt = new File("src/articles.txt");
        article.addAll(Files.readAllLines(txt.toPath()));

    }

    public Map<String,Integer> getAllWords(){
        return this.words;
    }

    public Map <Integer,Set> getGroupWords(){
        return this.groupWords;
    }

    public Map <Integer,Set> getFilterGroupWords(){
        return this.filterGroupWord;
    }

    /*1. Сосчитать частоту встречаемости слов в книге War and peace.*/


    public int getNumWord(String word){
        word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
        return this.words.containsKey(word)?this.words.get(word):0;
    }

/*2. Собрать все слова в группы по количеству букв:
например, в одну группу попадут слова: [the, war, jar, get, met...],
в другую [on, up, no, of...].*/
    public void groupingWord(){
        for (Map.Entry entry : words.entrySet()) {
            Set<String> list = new HashSet<>();
            String s = entry.getKey().toString();
            int length = s.length();
            if (groupWords.containsKey(length)){
                list.addAll(groupWords.get(length));
                list.add(s);
                groupWords.put(length, list);
            } else {
                list.add(s);
                groupWords.put(length, list);
            }
        }
    }

/*3. Вывести топ 10 самых частых слов и фраз.*/
    public void topWords(int top){
        ArrayList<Integer> t = new ArrayList<>();
        int count = 0;
        for (Map.Entry entry : this.words.entrySet()) {
            t.add((Integer) entry.getValue());
        }
        Collections.sort(t, Collections.reverseOrder());
        for (int i = 0; i < top; i++) {
            for (Map.Entry entry : this.words.entrySet()) {
                int temp = (int) entry.getValue();
                if (t.get(i) == temp) {
                    System.out.println("* " + entry.getKey() + " - " + entry.getValue());
                    count++;
                }
                if(count >= top){break;}

            }
        }

    }
/*4. Тоже, что и 2, но без артиклей, частиц и тп (без the, a, on, to...).*/

    public void filterGroupWord(){
        for (Map.Entry entry : groupWords.entrySet()) {
            Set<String> list = new HashSet<>();
            String s = entry.getKey().toString();
            list.addAll((Set<String>)entry.getValue());
            list.removeAll(article);
            if(!list.isEmpty()) {
                filterGroupWord.put((int) entry.getKey(), list);
            }
        }
    }

/*5. Вывести частоту встречаемости букв анг алфавита по этой книге.
Вывести в процентах для каждой буквы.*/

    public static void allLiteres(List <String> someText){
        Map<Character, Integer> charMap = new HashMap<>();
        int count = 0;
        for(String str: someText){
            char[]arrCh = str.toLowerCase().replaceAll("[^a-zA-Z]", "").toCharArray();  //убрать toLowerCase()
                                                                                            // если регистр важен
            for(char ch: arrCh){
                count++;
                if(charMap.containsKey(ch)){
                    charMap.put(ch,charMap.get(ch)+1);
                } else {
                    charMap.put(ch,1);
                }
            }
        }
        double pr = (double) 100/(double) count;
        for (Map.Entry entry : charMap.entrySet()) {
            int temp = (int) entry.getValue();
            String result = String.format("%.2f",(temp*pr));
            System.out.println("* " + entry.getKey() + " - " + result + "%" );
        }
    }

}



