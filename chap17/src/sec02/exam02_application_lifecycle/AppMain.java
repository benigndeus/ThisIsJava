package sec02.exam02_application_lifecycle;

import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {
    public AppMain() {
        System.out.println(Thread.currentThread().getName() + ": AppMain() 호출");
    }

    @Override
    public void init() throws Exception { // UI를 생성하는 코드를 작성하면 안 된다.
        System.out.println(Thread.currentThread().getName() + ": init() 호출");
        Parameters params = this.getParameters();
        Map<String, String> map = params.getNamed();
        String ip = map.get("ip");
        String port = map.get("port");
        System.out.println("ip: " + ip);
        System.out.println("port: " + port);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Thread.currentThread().getName() + ": start() 호출");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": stop() 호출");
    }

    public static void main(String[] args) {
        launch(args);
    }
}