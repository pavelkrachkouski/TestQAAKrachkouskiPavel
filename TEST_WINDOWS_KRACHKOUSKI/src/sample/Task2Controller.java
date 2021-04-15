package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Task2Controller
{

    @FXML
    private TextField taName;

    @FXML
    private Button btnCheck;

    @FXML
    void initialize()
    {
        taName.setFocusTraversable(false);
        btnCheck.setOnAction(event -> btnCheckClick());
    }



    private void btnCheckClick()
    {
        taName.setText(taName.getText().trim());
        if (taName.getText().trim().length() == 0)
        {
            showWarningAlert("Введите имя :(", "Пожалуйста!");
            clearText();
        }
        else if (!taName.getText().equalsIgnoreCase("вячеслав"))
        {
            showWarningAlert("Нет такого имени :(", "Внимание!");
            clearText();
        }
        else
        {
            showInformationAlert();
            clearText();
        }
    }



    private void showWarningAlert(String str, String str2)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(str2);
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }



    private void showInformationAlert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ура!");
        alert.setHeaderText(null);
        alert.setContentText("Привет, Вячеслав! :)");
        alert.showAndWait();
    }



    public void clearText()
    {
        taName.clear();
    }
}
