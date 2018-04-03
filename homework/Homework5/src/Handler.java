
/*Pеализовать простое средство для считывания и записи информации из конфигурационных файлов.
Реализацию механизмов чтения/записи файла опустим, чтобы сосредоточить внимание на структере кода
Ханние данных в файле в формате ключ:значение

За работу с каждым типом файла будет отвечать отдельный класс (например, XmlHandler, JsonHandler и тд),
в родительском классе будет реализован метод getInstanse(), он, в зависимости от переданного в него имени файла,
будет определять, к какому типу он относится и возвращать объект! соответствующего класса
(например, return new XmlHandler(), return new JsonHandler() и тд). */

import java.util.HashMap;

interface  Handler {

    void setFilePath(String filePath);  // задать путь и название к файлу
    String getFilePath();               // полйчить путь и название к файлу
    void createFile();                  //создать файл
    void openFile();                    //открыть файл
    void closeFile();                   //закрыть файл
    void writeFile(HashMap<String, String> hashMap); //записать в файл
    String readFile();                  // считать из файла
    String[] parsString (String str);   // преобразовать строку в ключ:значение массив String

    static Handler getInstanse(Handler handler){
        int x = handler.getFilePath().lastIndexOf('.');
        String format = handler.getFilePath().substring(x);
        switch (format){
            case ".txt": return new TxtHandler(handler.getFilePath());
            case ".json": return new JsonHandler(handler.getFilePath());
            case ".xml": return new XmlHandler(handler.getFilePath());
        }
        return null;
    }
}
