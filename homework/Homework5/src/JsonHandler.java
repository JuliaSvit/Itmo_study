import java.util.ArrayList;
import java.util.HashMap;

public class JsonHandler extends HanderRealize implements Tags{

    private ArrayList<String> tags = new ArrayList<>();

    public JsonHandler(String filePath) {
        super(filePath);
        System.out.println("Это файл json");
    }

    @Override
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    @Override
    public ArrayList<String> getTags() {
        return this.tags;
    }

    @Override
    public void writeFile(HashMap<String, String> hashMap) {

    }

    @Override
    public String[] parsString(String str) {
        String s = "";
        for (String tag: this.tags){
            if(str.contains(tag)){
                s = str.replaceAll(tag, "");
            }
        }
        return s.split(":");
    }
}
