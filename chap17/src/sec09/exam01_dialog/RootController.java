package sec09.exam01_dialog;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.FileChooser.ExtensionFilter;

/* Controller가 AppMain 클래스에서 Scene 객체를 얻어야 Dialog를 띄울 수 있다.
    방법 1: fxml 파일에서 fx:id를 설정하고 컨트롤러에서 그 변수를 통해 Scene을 얻는다.
    방법 2: AppMain에서 컨트롤러에게 Scene(primaryStage)을 넘겨준다.  */

public class RootController implements Initializable {
    // 방법 1
    // @FXML private HBox hbox;

    // 방법 2
    private Stage primaryStage;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void handleOpenFileChooser(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("Text Files", "*.txt"),
            new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
            new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
            new ExtensionFilter("All Files", "*.*")
        );
        
        // 방법 1
        // File selectedFile = fileChooser.showOpenDialog(hbox.getScene().getWindow());
        
        // 방법 2
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        
        if(selectedFile != null) {
            System.out.println(selectedFile.getPath());
        }
    }

    public void handleSaveFileChooser(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showSaveDialog(primaryStage);
        if(selectedFile != null) {
            System.out.println(selectedFile.getPath());
        }
    }

    public void handleDirectoryChooser(ActionEvent e) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDir = directoryChooser.showDialog(primaryStage);
        if(selectedDir != null) {
            System.out.println(selectedDir.getPath());
        }
    }

    public void handlePopup(ActionEvent e) throws Exception {
        Popup popup = new Popup();

        Parent parent = FXMLLoader.load(getClass().getResource("popup.fxml"));
        ImageView imageView = (ImageView) parent.lookup("#imgMessage");
        imageView.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
        imageView.setOnMouseClicked(event->popup.hide());

        Label lblMessage = (Label) parent.lookup("#lblMessage");
        lblMessage.setText("메시지가 왔습니다.");

        popup.getContent().add(parent);
        popup.setAutoHide(true);
        popup.show(primaryStage);
    }

    public void handleCustom(ActionEvent e) throws Exception {
        Stage dialog = new Stage(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle("확인");

        Parent parent = FXMLLoader.load(getClass().getResource("custom_dialog.fxml"));
        
        Label txtTitle = (Label) parent.lookup("#txtTitle");
        txtTitle.setText("확인하셨습니까?");

        Button btnOk = (Button) parent.lookup("#btnOk");
        btnOk.setOnAction(event->dialog.close());

        Scene scene = new Scene(parent);

        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }
}