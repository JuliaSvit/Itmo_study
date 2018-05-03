import java.io.*;
import java.nio.charset.Charset;

public class Encrypt {

    public static void startEncode(File file, File newFile, String password) throws IOException {
//        String text = reader(file);
        byte[] txt = reader(file);
        byte[] pass = password.getBytes();
        byte[] res = new byte[txt.length];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte)
                    (txt[i] ^ pass
                    [i % pass.length]);
        }
        writer(res, newFile);
    }

    public static void startEncode(String file, String newFile, String password) throws IOException {
        startEncode(new File(file),new File(newFile),password);
    }

    private static byte[] reader(File file) throws IOException {
//        try(Reader reader = new FileReader(file)) {
//            StringBuilder sb = new StringBuilder();
//            char[] buf = new char[512];
//            int len;
//            while((len = reader.read(buf)) > 0){
//                sb.append(buf, 0, len);
//            }
//            return sb.toString();
//        }
            try(InputStream in = new BufferedInputStream(new FileInputStream(file));
                ByteArrayOutputStream bout = new ByteArrayOutputStream()) {

                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0){
                    bout.write(buf, 0, len);
                }
                return bout.toByteArray();
            }
    }

    private static void writer(byte[] str, File newFile) throws IOException{
//        try(Writer writer = new FileWriter(newFile)){
//            writer.write(str);
//        }
        try(OutputStream out = new FileOutputStream(newFile)){
            out.write(str);
        }
    }

    public static void startDecode(File file, File newFile, String password) throws IOException {
        byte[] text = reader(file);
        byte[] res = new byte[text.length];
        byte[] pass = password.getBytes();

        for (int i = 0; i < text.length; i++) {
            res[i] = (byte) (text[i] ^ pass[i % pass.length]);
        }
        writer(res,newFile);
    }

    public static void startDecode(String file, String newFile, String password) throws IOException {
        startDecode(new File(file), new File(newFile),password);
    }


}
