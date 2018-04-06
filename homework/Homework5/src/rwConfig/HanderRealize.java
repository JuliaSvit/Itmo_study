package rwConfig;

import java.util.ArrayList;
import java.util.HashMap;

public class HanderRealize implements RWHandler, Tags {

    protected String filePath; //путь к файлу
    protected static ArrayList<String> tags = new ArrayList<>();

    public HanderRealize(String filePath){

        this.filePath = filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() {
        return this.filePath;
    }

    @Override
    public String readFile(String str){
        return null;
    }

    @Override
    public String[] parsString(String str) {
        String s = "";
        for (String tag: tags){
            if(str.contains(tag)){
                s = str.replaceAll(tag, "");
            }
        }
        return s.split(":");
    }


    @Override
    public void writeFile(HashMap<String, String> hashMap) {

    }

    @Override
    public ArrayList<String> getTags() {
        System.out.println("У меня есть тэги");
        return tags;
    }

    @Override
    public void setTags(ArrayList<String> tag) {

    }
}
