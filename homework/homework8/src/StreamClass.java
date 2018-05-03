

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class StreamClass {
    
    public static void copyText(File file, File newFile) throws IOException{
        if(newFile.exists() && !newFile.canWrite()){
            throw new FileNotFoundException("Файл не доступен для записи");
        }
        for(String str: readFile(file)){
            writeFile(str + "\n", newFile);
        }
    }
    
    public static void copyText(String file, String newFile) throws IOException{
        copyText(new File(file), new File(newFile));
    }
    
    private static ArrayList<String> readFile(File file) throws IOException {
        ArrayList<String>text = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), Charset.forName("UTF-8")
                )
        )) {
            String str;
            while((str = reader.readLine()) != null){
                text.add(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
    
    private static void writeFile(String str, File newFile) throws IOException{
        try(Writer writer = new FileWriter(newFile,true)){
            writer.write(str);
        }
    }
    
}
