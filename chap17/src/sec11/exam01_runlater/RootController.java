package sec11.exam01_runlater;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RootController implements Initializable {
    @FXML private Label lblTime;
    @FXML private Button btnStart;
    @FXML private Button btnStop;

    private boolean stop; // 플래그 변수

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnStart.setOnAction(event -> handleBtnStart(event));
        btnStop.setOnAction(event -> handleBtnStop(event));
    }

    public void handleBtnStart(ActionEvent e) {
        stop = false;

        Thread thread = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                while (!stop) {
                    String strTime = sdf.format(new Date());
                    Platform.runLater(()->lblTime.setText(strTime)); // ★★★
                    /* 원래 FX스레드만 UI를 변경할 수 있으나 이렇게 사용하면 다른 스레드에서도 UI 변경 가능 */
                    try { Thread.sleep(1000); } catch (InterruptedException e) {}
                }
            }
        };

        thread.setDaemon(true); // 호출한 스레드가 종료되면 호출된 스레드도 같이 종료...?
        thread.start();
    }

    public void handleBtnStop(ActionEvent e) {
        stop = true;
    }
}