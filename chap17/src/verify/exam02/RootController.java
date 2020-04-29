package verify.exam02;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
    private Stage primaryStage;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    /* sec09 참고 */
    public void handleBtnAdd(ActionEvent e) throws Exception {
        Stage addForm = new Stage(StageStyle.UTILITY);

        addForm.initModality(Modality.WINDOW_MODAL);
        addForm.initOwner(primaryStage);
        addForm.setTitle("추가");

        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));

        Scene scene = new Scene(root);

        addForm.setScene(scene);
        addForm.setResizable(false);
        addForm.show();
    }
}