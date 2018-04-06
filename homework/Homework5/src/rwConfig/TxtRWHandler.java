package rwConfig;

import java.util.ArrayList;
import java.util.HashMap;

public class TxtRWHandler extends HanderRealize{

    public TxtRWHandler(String filePath) {
        super(filePath);
        System.out.println("Это файл txt");
    }

    @Override
    public void writeFile(HashMap<String, String> hashMap) {

    }

    @Override
    public String[] parsString(String str) {
        String[] s = str.split(":");
        return s;
    }

    @Override
    public String readFile(String str){
        this.parsString(str);
        ///
        return null;
    }

    @Override
    public ArrayList<String> getTags() {
        System.out.println("У меня нет тегов");
        return this.tags;
    }
}
