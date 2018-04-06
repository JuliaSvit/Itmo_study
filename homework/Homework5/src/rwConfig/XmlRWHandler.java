package rwConfig;

import java.util.ArrayList;
import java.util.HashMap;

public class XmlRWHandler extends HanderRealize{

    private ArrayList<String> tags = new ArrayList<>();

    public XmlRWHandler(String filePath) {
        super(filePath);
        System.out.println("Это файл xml");
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
