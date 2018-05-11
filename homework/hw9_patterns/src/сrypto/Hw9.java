package сrypto;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Hw9 {

    /*
1. Используя паттерн Decorator создать шифрующие с помощью XOR потоки ввода/вывода. 
    Они могут наследовать FilterInputStream и FilterOutputStream 
    (удобнее их наследовать, но можно и прямиком InputStream и OutputStream). 
    Т.о. конструктор этих потоков должен принимать пароль в виде массива байт и поток, который он декорирует.

    Использование должно выглядеть следующим образом:
    // Трафик автоматически шифрует и дешифруется:
    InputStream in = new CryptoInputStream(socket.getInputStream(), password);
    OutputStream out = new CryptoOutputStream(socket.getOutputStream(), password);

    // Сохраняем в шифрованный файл и читаем из шифрованного файла:
    InputStream in = new CryptoInputStream(new FileInputStream("test.bin"), password);
    OutputStream out = new CryptoOutputStream(new FileOutputStream("test.bin"), password);

    Для простоты можете начать имплементацию, где пароль - один байт.*/
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        byte[]arr;
        byte[] password = {(byte)12, (byte)100, (byte)64, (byte)120};
        try(InputStream in = new CryptoInputStream(new FileInputStream("src/сrypto/text.txt"), password);
        ByteArrayOutputStream bout = new ByteArrayOutputStream()) {

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0){
                bout.write(buf, 0, len);
            }
            arr = bout.toByteArray();
        }
        writer(arr,new File("src/сrypto/text2.txt"));
        try(OutputStream out = new CryptoOutputStream(new FileOutputStream("src/сrypto/text3.txt"),password)){
            out.write(arr);
        }

    }

    private static void writer(byte[] txt, File newFile) throws IOException{
        try(OutputStream out = new FileOutputStream(newFile)){
            out.write(txt);
        }
    }
    
}
