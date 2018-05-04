import java.io.*;

public class Encrypt {

    private static void startEncode(File file, File newFile, byte[] password) throws IOException {
        byte[] txt = reader(file);
        byte[] res = new byte[txt.length];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte)
                    (txt[i] ^ password
                            [i % password.length]);
        }
        writer(res, newFile);
    }

    public static void startEncodeDecode(File file, File newFile, String password) throws IOException {
        byte[] pass = password.getBytes();
        startEncode(file, newFile, pass);
    }

    public static void startEncodeDecode(File file, File newFile, int password) throws IOException {
        byte[] pass = {(byte)password};
        startEncode(file, newFile, pass);
    }

    private static byte[] reader(File file) throws IOException {
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
        try(OutputStream out = new FileOutputStream(newFile)){
            out.write(str);
        }
    }

}