package rwConfig;
/*Pеализовать простое средство для считывания и записи информации из конфигурационных файлов.
Реализацию механизмов чтения/записи файла опустим, чтобы сосредоточить внимание на структере кода
Ханние данных в файле в формате ключ:значение

За работу с каждым типом файла будет отвечать отдельный класс (например, rwConfig.XmlRWHandler, rwConfig.JsonRWHandler и тд),
в родительском классе будет реализован метод getInstanse(), он, в зависимости от переданного в него имени файла,
будет определять, к какому типу он относится и возвращать объект! соответствующего класса
(например, return new rwConfig.XmlRWHandler(), return new rwConfig.JsonRWHandler() и тд). */

import java.util.HashMap;

public interface RWHandler {

    void setFilePath(String filePath);  // задать путь и название к файлу
    String getFilePath();               // полйчить путь и название к файлу
    void writeFile(HashMap<String, String> hashMap); //записать в файл
    String readFile(String str);                  // считать из файла
    String[] parsString (String str);   // преобразовать строку в ключ:значение массив String

    static RWHandler getInstanse(String file){
        int x = file.lastIndexOf('.');
        if (x >= 0) {
            String format = file.substring(x);
            switch (format) {
                case ".txt":
                    return new TxtRWHandler(file);
                case ".json":
                    return new JsonRWHandler(file);
                case ".xml":
                    return new XmlRWHandler(file);
            }
        }
        return null;
    }
}
