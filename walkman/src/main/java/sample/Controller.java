package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.*;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller{

    @FXML private ImageView playImg = new ImageView();
    @FXML private ImageView muteImg = new ImageView();
    @FXML private ProgressBar progress = new ProgressBar(0);
    @FXML private Label audioInfo = new Label();
    @FXML private CheckBox plCheckBox = new CheckBox();
    @FXML private Label timeLabel = new Label();
    @FXML private Slider volumeSlider = new Slider();

    private MediaView mediaView;
    private List<MediaPlayer> players = Main.getPlayers();
    private ChangeListener<Duration> progressChangeListener;

    //Изображения кнопак (можно перенести в enum)
    private Image imagePlay = new Image("/Play.png");
    private Image imagePause = new Image("/Pause.png");
    private Image imageMute1 = new Image("/Mute_1.png");
    private Image imageMute2 = new Image("/Mute_2.png");

    private boolean startTrigger = true;

    private void addNewMediaInThread(MediaPlayer player, MediaPlayer nextPlayer){
        player.currentTimeProperty().removeListener(progressChangeListener);
        mediaView.setMediaPlayer(nextPlayer);
    }

    //Создание очереди аудиофайлов
    @FXML
    public void setMediaPlayer(List<MediaPlayer> players){
        mediaView = new MediaView(players.get(0));
        for (int i = 0; i < players.size(); i++) {
            MediaPlayer player = players.get(i);
            MediaPlayer nextPlayer = players.get((i + 1) % players.size());
            //для каждого аудиофайла создаётся свой поток
            player.setOnEndOfMedia(new Runnable() {
                @Override public void run() {
                    player.currentTimeProperty().removeListener(progressChangeListener);
                    mediaView.setMediaPlayer(nextPlayer);
                    nextPlayer.play();
                }});
        }
        mediaView.mediaPlayerProperty().addListener(new ChangeListener<MediaPlayer>() {
            @Override public void changed(ObservableValue<? extends MediaPlayer> observableValue, MediaPlayer oldPlayer, MediaPlayer newPlayer) {
                setCurrentlyPlaying(newPlayer);
            }
        });
        mediaView.getMediaPlayer().play();
        setCurrentlyPlaying(mediaView.getMediaPlayer());
        playImg.setImage(imagePause);
    }

    //Событие нажатие на кнопку play
    @FXML
    public void playAudioAction(ActionEvent actionEvent) throws Exception {
        if(startTrigger){
            setMediaPlayer(players);
            mediaView.getMediaPlayer().play();
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                public void invalidated(javafx.beans.Observable ov) {
                    if (volumeSlider.isValueChanging()) {
                        mediaView.getMediaPlayer().setVolume(volumeSlider.getValue() / 100.0);
                    }
                }
            });
            startTrigger = false;
        }else if(mediaView.getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
            mediaView.getMediaPlayer().pause();
            playImg.setImage(imagePlay);
        } else if(mediaView.getMediaPlayer().getStatus() == MediaPlayer.Status.PAUSED
                || mediaView.getMediaPlayer().getStatus() == MediaPlayer.Status.STOPPED) {
            mediaView.getMediaPlayer().play();
            playImg.setImage(imagePause);
        }
    }

    //Событие нажатие на кнопку next
    @FXML
    public void nextAudioAction(ActionEvent actionEvent) {
        final MediaPlayer curPlayer = mediaView.getMediaPlayer();
        MediaPlayer nextPlayer = players.get((players.indexOf(curPlayer) + 1) % players.size());
        mediaView.setMediaPlayer(nextPlayer);
        curPlayer.currentTimeProperty().removeListener(progressChangeListener);
        curPlayer.stop();
        nextPlayer.play();
        playImg.setImage(imagePause);
    }

    //Событие нажатие на кнопку stop
    @FXML
    public void stopAudioAction(ActionEvent actionEvent) {
    }

    // Событие нажатие на кнопку open file
    // открыть файл и добавить его в список
    @FXML
    private void hndlOpenFiles(ActionEvent event) {
        FileChooser file = new FileChooser();
        file.getExtensionFilters().add(new FileChooser.ExtensionFilter("mp3", "*.mp3"));
        File selectedFile = file.showOpenDialog(Main.getPrimary());
        if(selectedFile != null){
            List<MediaPlayer> newList = new ArrayList<MediaPlayer>(Collections.singleton(Main.createPlayer("file:///" + selectedFile.toString()
                    .replace("\\", "/").replaceAll(" ", "%20"))));
            setMediaPlayer(newList);
            players.addAll(newList);
        }
    }

    // Событие нажатие на кнопку open dir
    //открыть каталог и добавить в список все его содержимое
    @FXML
    private void hndlOpenDir(ActionEvent event) {
        DirectoryChooser dir = new DirectoryChooser();
        File selectedDir = dir.showDialog(Main.getPrimary());
        if(selectedDir != null){
            List<MediaPlayer> newList = new ArrayList<>(Main.createMediaPlayers(selectedDir));
            setMediaPlayer(newList);
            players.addAll(newList);
        }
    }

    //устанавливаем метаданные аудиотрека(полоса прогреса, время, название и автора)
    @FXML
    private void setCurrentlyPlaying(final MediaPlayer newPlayer) {
        progress.setProgress(0);
        progressChangeListener = new ChangeListener<Duration>() {
            @Override public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {
                progress.setProgress(1.0 * newPlayer.getCurrentTime().toMillis() / newPlayer.getTotalDuration().toMillis());
                timeLabel.setText(millToMin(newPlayer.getCurrentTime().toMillis()));
            }
        };
        newPlayer.currentTimeProperty().addListener(progressChangeListener);
        Media media = newPlayer.getMedia();
        String artist = (media.getMetadata().get("artist")!=null)?" - " + media.getMetadata().get("artist"):"";
        String source = newPlayer.getMedia().getSource();
        source = source.substring(0, source.length() - ".mp3".length());
        source = source.substring(source.lastIndexOf("/") + 1).replaceAll("%20", " ");
        audioInfo.setText(source + artist + " " + millToMin(media.getDuration().toMillis()));
    }

    // Переводит миллисекунды в минуты String
    private String millToMin(double millis) {
        double sec = millis / 1000;
        int sec2 = (int) sec % 60;
        if (sec2 / 10 == 0) return (int) sec / 60 + ":" + "0" +sec2 ;
        return (int) sec / 60 + ":" + sec2;
    }

    //окно с плейлистом
    private  Stage stage;
    @FXML
    private void playListWin(){
        if(plCheckBox.isSelected()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("playList.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
//                stage.initStyle(StageStyle.UNDECORATED); //убирает рамки окна
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setTitle("Play List");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            stage.close();
        }
    }

    //Выключение звука
    private double valume;
    public void muteButton(ActionEvent actionEvent) {
        if(mediaView.getMediaPlayer().getVolume()>0) {
            muteImg.setImage(imageMute2);
            valume = mediaView.getMediaPlayer().getVolume();
            mediaView.getMediaPlayer().setVolume(0);
        } else {
            muteImg.setImage(imageMute1);
            mediaView.getMediaPlayer().setVolume(valume);
        }
    }
}
