package verify.exam02;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
    @FXML private Button btnAdd;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAdd.setOnAction(event->handleBtnAddAction(event));
    }

    /* sec09 참고 */
    public void handleBtnAddAction(ActionEvent event) {
        try {
            Stage formDialog = new Stage(StageStyle.UTILITY);
            formDialog.initModality(Modality.WINDOW_MODAL);
            formDialog.initOwner(btnAdd.getScene().getWindow());
            formDialog.setTitle("추가");

            Parent form = FXMLLoader.load(getClass().getResource("form.fxml"));

            Button btnFormCancel = (Button) form.lookup("#btnFormCancel");
            btnFormCancel.setOnAction(e->formDialog.close());

            Scene scene = new Scene(form);
            formDialog.setScene(scene);
            formDialog.setResizable(false);
            formDialog.show();
        } catch (Exception e) { }
    }
}