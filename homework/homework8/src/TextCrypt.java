import java.io.*;

public class TextCrypt{

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

    private static void codeText(File file, File codeFile, File newFile, boolean codeDecode) throws IOException {
        byte[] txt = reader(file);
        byte[] txtCode = reader(codeFile);
        byte[] res = new byte[txt.length];

        if(codeDecode) {
            for (int i = 0; i < txt.length; i++) {
                res[i] = (byte)(txt[i] + txtCode[i % txtCode.length]);
            }
        } else {
            for (int i = 0; i < txt.length; i++) {
                res[i] = (byte)(txt[i] - txtCode[i % txtCode.length]);
            }
        }
        writer(res, newFile);
    }

    public static void startCodeText(File file, File codeFile, File newFile) throws IOException{
        codeText(file,codeFile,newFile,true);
    }

    public static void startDecodeText(File file, File codeFile, File newFile) throws IOException{
        codeText(file,codeFile,newFile,false);
    }
}
