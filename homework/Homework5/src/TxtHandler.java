import java.util.HashMap;

public class TxtHandler extends HanderRealize{

    public TxtHandler(String filePath) {
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
}
