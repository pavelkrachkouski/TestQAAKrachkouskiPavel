package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Task1Controller
{

    @FXML
    private TextField taNumber;

    @FXML
    private Button btnCheck;

    @FXML
    void initialize()
    {
        taNumber.setFocusTraversable(false);
        btnCheck.setOnAction(event -> btnCheckClick());
    }



    private void btnCheckClick()
    {
        taNumber.setText(taNumber.getText().replaceAll(",", ".").trim());
        if (taNumber.getText().trim().length() == 0)
        {
            showWarningAlert("Введите число :(", "Пожалуйста!");
            clearText();
        }
        else if (!isNumeric(taNumber.getText()))
        {
            showWarningAlert("Введенное значение не является числом :(", "Внимание!");
            clearText();
        }
        else if (Double.parseDouble(taNumber.getText()) <= 7)
        {
            showInformationAlert("Вы ввели число меньше либо равно 7\nПопробуйте еще раз :(", "Увы!");
            clearText();
        }
        else if (Double.parseDouble(taNumber.getText()) > 7)
        {
            showInformationAlert("Привет! :)", "Ура!");
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



    private void showInformationAlert(String str, String str2)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(str2);
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }



    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");
    }



    public void clearText()
    {
        taNumber.clear();
    }
}
