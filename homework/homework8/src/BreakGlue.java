
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class BreakGlue {
    
    private static String reader(File file) throws IOException{
        try(Reader reader = new FileReader(file)) {
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[512];
            int len;
            while((len = reader.read(buf)) > 0){
                sb.append(buf, 0, len);
            }
            return sb.toString();
        }
    }
    
    public static void breakFiles(File file, final File newFile, int size) throws IOException{
        if(size <= 0){
            throw new IOException("Размер отрезков должен быть больше нуля");
        }
        int count = 1;
            char[] ch = reader(file).toCharArray();
            char[]text; 
            for(int i = 0; i < ch.length; i += size){
                if(ch.length - i < size){
                    text = new char[ch.length - i];
                } else {
                    text = new char[size];
                }
                System.arraycopy(ch, i, text, 0, text.length);
                writer(text,genName(newFile, count++),false);
            }
    }
    
    public static void breakFiles(String file, String newFile, int size) throws IOException {
        breakFiles(new File(file), new File(newFile), size);
    }
    
    private static File genName(File file, int count){
        String path = file.toString();
        String extension = path.substring(path.lastIndexOf("."));
        path = path.substring(0, path.lastIndexOf("."));
        return new File(path + "_" + count + extension);
    }
    
    private static void writer(char[]text, File newFile, boolean append) throws IOException{
        try(Writer writer = new FileWriter(newFile,append)){
            writer.write(text);
        }
    }
    
    public static void glueFile(File file) throws IOException {

        for(File fileName: findFile(file)){
            char[] ch = reader(fileName).toCharArray();
            writer(ch, file,true);
        }
    }

    public static void glueFile(String file)throws IOException{
        glueFile(new File(file));
    }
    
    private static List<File> findFile(File file){
        
        List<File> fileList = new ArrayList<>(Arrays.asList(file.getParentFile().listFiles() ));
        Iterator<File> iter = fileList.iterator();
        while(iter.hasNext()){
            String str = iter.next().getName();
            if (!validFileName(str,file.getName())) {
                iter.remove();
            }
        }

        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return compareTime(o1,o2);
            }
        });

        return fileList;
    }

    private static int compareTime(File file1,File file2 ){
        if (file1 == file2) return 0;
        if (file1.lastModified() == file2.lastModified()) return 0;
        if (file1.lastModified() > file2.lastModified()) return 1;
        return -1;

    }
    
    private static boolean validFileName(String name, String myFile){
        String str = myFile.substring(0, myFile.lastIndexOf("."));
        Pattern p = Pattern.compile("_\\d.+");//   содержит нумирацию файлов ( _x.  где х - число)
        Matcher m = p.matcher(name);
        return name.contains(str)&& m.find();
    }
    
}
