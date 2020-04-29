package sec11.exam03_task_callback;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class RootController implements Initializable {
    @FXML private ProgressBar progrerssBar;
    @FXML private Label  lblWorkDone;
    @FXML private Label  lblResult;
    @FXML private Button btnStart;
    @FXML private Button btnStop;

    private Task<Integer> task;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnStart.setOnAction(event->handleBtnStart(event));
        btnStop.setOnAction(event->handleBtnStop(event));
    }

    public void handleBtnStart(ActionEvent e) {
        task  = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                int result = 0;
                for (int i = 1; i <= 100; i++) {
                    if(isCancelled()) {
                        updateMessage("취소됨");
                        break;
                    }
                    result += i;
                    updateProgress(i, 100); // i의 최댓값이 100
                    updateMessage(String.valueOf(i));

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        if(isCancelled()) { // isCancelled() 메소드는 interrupted 되어도 true를 반환함
                            updateMessage("취소됨");
                            break;
                        }
                    }
                    
                }
                return result;
            }

            // succeeded(), cancelled(), failed() 이 메소드들은 FX스레드가 실행하므로 UI 변경 가능
            @Override
            protected void succeeded() {
                lblResult.setText(String.valueOf(task.getValue()));
            }

            @Override
            protected void cancelled() {
                lblResult.setText("취소됨");
            }

            @Override
            protected void failed() {
                lblResult.setText("실패");
            }
        };

        // 속성 바인딩 작업 : task 객체에서 변한 값들이 progrerssBar와 lblWorkDone에 자동 적용
        progrerssBar.progressProperty().bind(task.progressProperty());
        lblWorkDone.textProperty().bind(task.messageProperty());

        // 초기화 작업
        lblResult.setText("");

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    public void handleBtnStop(ActionEvent e) {
        task.cancel();
    }
}