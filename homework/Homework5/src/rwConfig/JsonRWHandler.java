package rwConfig;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonRWHandler extends HanderRealize{

    private ArrayList<String> tags = new ArrayList<>();

    public JsonRWHandler(String filePath) {
        super(filePath);
        System.out.println("Это файл json");
    }

    @Override
    public void writeFile(HashMap<String, String> hashMap) {
    }

    @Override
    public String readFile(String str){
        this.parsString(str);
        ///
        return null;
    }
}
