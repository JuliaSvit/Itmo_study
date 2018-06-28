package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PlayList implements Initializable {

    @FXML private ListView listView = new ListView();
    @FXML private Pane plPanel = new Pane();
    private List<MediaPlayer> players = Main.getPlayers();

    //заполнение списка аудиофайлов
    @Override
    public void initialize(URL location, ResourceBundle resources){
        ObservableList<String> items = listView.getItems();
        for(MediaPlayer mp : players){
            String source = mp.getMedia().getSource();
            String artist = (mp.getMedia().getMetadata().get("artist")!=null)?" - " + mp.getMedia().getMetadata().get("artist"):"";
            source = source.substring(0, source.length() - ".mp3".length());
            source = source.substring(source.lastIndexOf("/") + 1).replaceAll("%20", " ");
            items.add(source + artist + " " + millToMin(mp.getMedia().getDuration().toMillis()));
        }
    }

    private String millToMin(double millis) {
        double sec = millis / 1000;
        int sec2 = (int) sec % 60;
        if (sec2 / 10 == 0) return (int) sec / 60 + ":" + sec2 + "0";
        return (int) sec / 60 + ":" + sec2;
    }


    private double xOffset;
    private double yOffset;
    private static Stage stage;
    public void setOnMousePressed(MouseEvent mouseEvent) {
        stage = (Stage) plPanel.getScene().getWindow();
        xOffset = stage.getX() - mouseEvent.getScreenX();
        yOffset = stage.getY() - mouseEvent.getScreenY();
    }

    public void setOnMouseDragged(MouseEvent mouseEvent) {
        stage.setX(mouseEvent.getScreenX() + xOffset);
        stage.setY(mouseEvent.getScreenY() + yOffset);
    }
}
