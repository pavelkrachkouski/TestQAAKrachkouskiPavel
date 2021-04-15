package sample;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller
{

    @FXML
    private Button btnTask1;

    @FXML
    private Button btnTask2;

    @FXML
    private Button btnTask3;

    @FXML
    void initialize()
    {
        btnTask1.setOnAction(event -> openNewScene("task1.fxml", "Задание 1"));
        btnTask2.setOnAction(event -> openNewScene("task2.fxml", "Задание 2"));
        btnTask3.setOnAction(event -> openNewScene("task3.fxml", "Задание 3"));
    }



    public void openNewScene(String window, String title)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }
}
