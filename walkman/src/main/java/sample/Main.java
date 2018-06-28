package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private static List<MediaPlayer> players;
    private static Stage primary;
    private static List<String> params;

    public static List<MediaPlayer> getPlayers() { return players; }

    public static Stage getPrimary() { return primary; }

    public static List<String> getParams() { return params; }

    @Override
    public void start(Stage primaryStage) throws Exception{
//https://gist.github.com/jewelsea/1446612/6ee51cc02450dadd11a1c6c798b93fb14851275c
        primary = primaryStage;
        params = getParameters().getRaw();
        final File dir = getFile("C:\\Users\\Public\\Music\\Sample Music");
        players = createMediaPlayers(dir);
        Parent root = FXMLLoader.load(getClass().getResource("/win/sample.fxml"));
        primaryStage.setTitle("Angel");
        primaryStage.getIcons().add(new Image("/img/Angle.png"));
        primaryStage.setScene(new Scene(root, 600, 200));
        primaryStage.setMinHeight(200);
        primaryStage.setMinWidth(600);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        primaryStage.show();
    }

    public static MediaPlayer createPlayer(String aMediaSrc) {
        final MediaPlayer player = new MediaPlayer(new Media(aMediaSrc));
        player.setOnError(new Runnable() {
            @Override public void run() {
                System.out.println("Media error occurred: " + player.getError());
            }
        });
        return player;
    }

    public static List<MediaPlayer> createMediaPlayers(File dir) throws MediaPlayerException{
        List<MediaPlayer> players = new ArrayList<MediaPlayer>();
        for (String file : dir.list(new FilenameFilter() {
            @Override public boolean accept(File dir, String name) {
                return name.endsWith(".mp3");
            }
        })) players.add(createPlayer("file:///" + (dir + "\\" + file).replace("\\", "/")
                .replaceAll(" ", "%20")));
        if (players.isEmpty()) {
            new MediaPlayerException("No audio found in \" + dir");
        }
        return players;
    }

    public static File getFile(String fileName)throws MediaPlayerException{
        File dir = (params.size() > 0)
                ? new File(params.get(0))
                : new File(fileName);
        if (!dir.exists() && dir.isDirectory()) {
            new MediaPlayerException("Cannot find audio source: " + dir);
        }
        return dir;
    }

    public static void main(String[] args) throws Exception { launch(args); }

}