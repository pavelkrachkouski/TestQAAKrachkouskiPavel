package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.Random;

public class Task3Controller
{

    @FXML
    private Button btnCheck;

    @FXML
    private TextArea taArray;

    @FXML
    private Button btnFill;

    @FXML
    private ComboBox<String> cbCount;

    @FXML
    void initialize()
    {
        taArray.setFocusTraversable(false);
        fillComboPoints();
        cbCount.getSelectionModel().select(50);
        btnCheck.setOnAction(event -> btnCheckClick());
        btnFill.setOnAction(event -> fillArray());
    }



    private void btnCheckClick()
    {
        if (taArray.getText().trim().equals(""))
        {
            showWarningAlert();
        }
        else
        {
            taArray.setText(taArray.getText().trim());
            String[] array = taArray.getText().split(" ");
            StringBuilder targetElements = new StringBuilder();
            taArray.clear();
            for (String s : array)
            {
                if (checkString(s))
                {
                    taArray.appendText(s + " ");
                    if (Integer.parseInt(s) % 3 == 0)
                    {
                        targetElements.append(s).append(" ");
                    }
                }
            }
            showInformationAlert(targetElements.toString());
            taArray.clear();
        }
    }



    private void showInformationAlert(String str)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Элементы массива кратные 3");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }



    public boolean checkString(String string)
    {
        try
        {
            Integer.parseInt(string);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }



    private void fillComboPoints()
    {
        ObservableList<String> points = FXCollections.observableArrayList();
        for (int i = 100; i >= 1; i--)
        {
            points.add(String.valueOf(i));
        }
        cbCount.setItems(points);
    }



    private void fillArray()
    {
        taArray.clear();
        Random random = new Random();
        for (int i = 0; i < Integer.parseInt(cbCount.getValue()); i++)
        {
            int num = 36 + random.nextInt(100 - 36);
            taArray.appendText(num + " ");
        }
    }



    private void showWarningAlert()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Внимание!");
        alert.setHeaderText(null);
        alert.setContentText("Вы не ввели ни одного элемента массива!");
        alert.showAndWait();
    }
}
