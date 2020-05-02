package verify.exam04;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
    @FXML private Button btnAdd;
    @FXML private Button btnBarChart;
    @FXML private TableView<Student> tableView;

    // 계속 사용되어야 하므로 전역 변수로 선언
    ObservableList<Student> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAdd.setOnAction(event->handleBtnAddAction(event));
        btnBarChart.setOnAction(event->handleBtnBarChartAction(event));

        list = FXCollections.observableArrayList(); // 선언된 전역 변수를 initialize()에서 초기화

        TableColumn tc = tableView.getColumns().get(0);
        // Student의 어떤 Field가 저장될 것인가를 설정. Student Class의 변수명과 동일해야 함.
        tc.setCellValueFactory(new PropertyValueFactory("name"));
        tc.setStyle("-fx-alignment: CENTER"); // 저장될 데이터(엄밀히 말하면 0열)를 중앙 정렬 시킴.

        tc = tableView.getColumns().get(1);
        tc.setCellValueFactory(new PropertyValueFactory("kor"));
        tc.setStyle("-fx-alignment: CENTER");

        tc = tableView.getColumns().get(2);
        tc.setCellValueFactory(new PropertyValueFactory("math"));
        tc.setStyle("-fx-alignment: CENTER");

        tc = tableView.getColumns().get(3);
        tc.setCellValueFactory(new PropertyValueFactory("eng"));
        tc.setStyle("-fx-alignment: CENTER");

        // tableView의 데이터가 어떤 리스트(ObservableList)와 연결될 것인지 설정
        tableView.setItems(list);
    }

    /* sec09 참고 */
    public void handleBtnAddAction(ActionEvent event) {
        try {
            Stage formDialog = new Stage(StageStyle.UTILITY);
            formDialog.initModality(Modality.WINDOW_MODAL);
            formDialog.initOwner(btnAdd.getScene().getWindow());
            formDialog.setTitle("추가");

            Parent form = FXMLLoader.load(getClass().getResource("form.fxml"));

            // 저장 버튼 객체 받아오기
            Button btnFormSave = (Button) form.lookup("#btnFormSave");
            btnFormSave.setOnAction(e->{
                // 각 TextField 객체를 id로 읽어 옴
                TextField txtName = (TextField) form.lookup("#txtName");
                TextField txtKor  = (TextField) form.lookup("#txtKor");
                TextField txtMath = (TextField) form.lookup("#txtMath");
                TextField txtEng  = (TextField) form.lookup("#txtEng");

                // 입력 받은 내용을 객체로 생성
                Student student = new Student(
                    txtName.getText(),
                    Integer.parseInt(txtKor.getText()),
                    Integer.parseInt(txtMath.getText()),
                    Integer.parseInt(txtEng.getText())
                );

                // 생성된 객체를 ObservableList에 추가
                list.add(student);

                // Student 객체가 저장된 후 다이얼로그 닫음
                formDialog.close();
            });

            Button btnFormCancel = (Button) form.lookup("#btnFormCancel");
            btnFormCancel.setOnAction(e->formDialog.close());

            Scene scene = new Scene(form);
            formDialog.setScene(scene);
            formDialog.setResizable(false);
            formDialog.show();
        } catch (Exception e) { }
    }

    public void handleBtnBarChartAction(ActionEvent event) {
        try {
            Stage dialog = new Stage(StageStyle.UTILITY);
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.initOwner(btnAdd.getScene().getWindow());
            dialog.setTitle("막대 그래프");

            Parent parent = FXMLLoader.load(getClass().getResource("barchart.fxml"));

            BarChart barChart = (BarChart) parent.lookup("#barChart");

            XYChart.Series seriesKor = new XYChart.Series();
            seriesKor.setName("국어");
            ObservableList korList = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++) {
                korList.add(new XYChart.Data(list.get(i).getName(), list.get(i).getKor()));
            }
            seriesKor.setData(korList);
            barChart.getData().add(seriesKor);

            XYChart.Series seriesMath = new XYChart.Series();
            seriesMath.setName("수학");
            ObservableList mathList = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++) {
                mathList.add(new XYChart.Data(list.get(i).getName(), list.get(i).getMath()));
            }
            seriesMath.setData(mathList);
            barChart.getData().add(seriesMath);

            XYChart.Series seriesEng = new XYChart.Series();
            seriesEng.setName("수학");
            ObservableList engList = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++) {
                engList.add(new XYChart.Data(list.get(i).getName(), list.get(i).getEng()));
            }
            seriesEng.setData(engList);
            barChart.getData().add(seriesEng);

            Button btnClose = (Button) parent.lookup("#btnClose");
            btnClose.setOnAction(e->dialog.close());

            Scene scene = new Scene(parent);
            dialog.setScene(scene);
            dialog.show();
        } catch (Exception e) { }
    }
}