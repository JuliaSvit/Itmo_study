import textInfo.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class homework6 {

    public static void main(String[]args) throws IOException {
        File txt = new File("src/Text.txt"); // короткий текст
//        File txt = new File("src/wp.txt"); // длинный текст
        List<String> lines = Files.readAllLines(txt.toPath());
        Word word = new Word(lines);
        for (Map.Entry entry : word.getAllWords().entrySet()) {
            System.out.println("Word: " + entry.getKey() + " - "
                    + entry.getValue());

        }

        String someWodr = "after";
        System.out.println(someWodr + " - " + word.getNumWord(someWodr));

        word.groupingWord();
        for (Map.Entry entry : word.getGroupWords().entrySet()) {
            System.out.print("* " + entry.getKey() + " - ");
            for(String str:(HashSet<String>)entry.getValue()) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

        word.topWords(10);

        word.filterGroupWord();
        for (Map.Entry entry : word.getFilterGroupWords().entrySet()) {
            System.out.print("* " + entry.getKey() + " - ");
            for(String str:(HashSet<String>)entry.getValue()) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

       Word.allLiteres(lines);

    }

}
