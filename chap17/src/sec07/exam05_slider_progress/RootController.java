package sec07.exam05_slider_progress;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class RootController implements Initializable {
    @FXML private MediaView mediaView;
    @FXML private ImageView imageView;
    @FXML private Button btnPlay;
    @FXML private Button btnPause;
    @FXML private Button btnStop;

    @FXML private Label labelTime;
    @FXML private ProgressBar progressBar;
    @FXML private ProgressIndicator progressIndicator;
    @FXML private Slider sliderVolume;

    private boolean endOfMedia;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Media media = new Media(getClass().getResource("media/video.m4v").toString());
        /* Media media = new Media(getClass().getResource("media/audio.wav").toString()); */

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        /* MediaPlayer의 상태가 Ready 상태가 아닐 경우 예외가 발생
        mediaPlayer.play(); */

        // Ready 상태
        mediaPlayer.setOnReady(new Runnable(){
            @Override
            public void run() {
                btnPlay.setDisable(false);
                btnPause.setDisable(true);
                btnStop.setDisable(true);

                mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                    @Override
                    public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,
                            Duration newValue) {
                        double progress = mediaPlayer.getCurrentTime().toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
                        progressBar.setProgress(progress);
                        progressIndicator.setProgress(progress);
                        labelTime.setText(
                            (int) mediaPlayer.getCurrentTime().toSeconds() + "/"
                            + (int) mediaPlayer.getTotalDuration().toSeconds() + " sec"
                        );
                    }
                });
            }
        });

        // Play 상태
        mediaPlayer.setOnPlaying(()->{
            btnPlay.setDisable(true);
            btnPause.setDisable(false);
            btnStop.setDisable(false);
        });

        // Pause 상태
        mediaPlayer.setOnPaused(()->{
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(false);
        });

        // Stop 상태
        mediaPlayer.setOnStopped(()->{
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
        });

        // End of Media 상태
        mediaPlayer.setOnEndOfMedia(()->{
            endOfMedia = true;  // 비디오가 끝났을 때 비디오가 끝남을 알려주는 플래그 변수
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);

            // ProgressIndicator "Done" 표시 처리
            progressBar.setProgress(1.0);
            progressIndicator.setProgress(1.0);
        });

        // Slider Volume
        sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(newValue.doubleValue());
            }
        });

        sliderVolume.setValue(50.0);

        btnPlay.setOnAction(event->{
            if(endOfMedia) {    // 비디오가 끝난 상태(End Og Media)에서 다시 재생 버튼을 눌렀다면
                mediaPlayer.stop();
                mediaPlayer.seek(mediaPlayer.getStartTime());
            }
            mediaPlayer.play();
            endOfMedia = false;
        });

        btnPause.setOnAction(event->{
            mediaPlayer.pause();
        });

        btnStop.setOnAction(event->{
            mediaPlayer.stop();
        });
    }
}