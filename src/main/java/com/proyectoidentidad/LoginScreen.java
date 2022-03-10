package com.proyectoidentidad;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class LoginScreen {
    private String username = "";
    private String password = "";

    @FXML
    private GridPane BackgroundPanel;

    @FXML
    private Button LoginButton;

    @FXML
    private Pane LoginPanel;

    @FXML
    private PasswordField PassvordTextfield;

    @FXML
    private Text PasswordLabel;

    @FXML
    private Text UsernameLabel;

    @FXML
    private TextField UsernameTextfield;

    @FXML
    void LoginButtonClicked(MouseEvent event) {
        username = UsernameTextfield.getText();
        password = PassvordTextfield.getText();

        System.out.println(username + "\n" + password);
    }

}