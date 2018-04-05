package rwConfig;

import java.util.HashMap;

abstract class HanderRealize implements RWHandler {

    private String filePath; //путь к файлу

    public HanderRealize(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() {
        return this.filePath;
    }

    @Override
    public void createFile() {

    }

    @Override
    public void openFile() {

    }

    @Override
    public String readFile(){
        return null;
    }

    @Override
    public void closeFile() {
    }

}
