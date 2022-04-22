package com.proyectoidentidad;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


public class LoginScreen {
    dbConection con;
    @FXML
    private GridPane BackgroundPanel;

    @FXML
    private Button LoginButton;

    @FXML
    private Pane LoginPanel;

    @FXML
    private PasswordField PasswordTextfield;

    @FXML
    private Text PasswordLabel;

    @FXML
    private Text UsernameLabel;

    @FXML
    private TextField UsernameTextfield;

    @FXML
    void LoginButtonClicked(MouseEvent event) {
        if (UsernameTextfield.getText().equals("admin") && PasswordTextfield.getText().equals("admin")) {
            System.out.println(UsernameTextfield.getText() + "\n" + PasswordTextfield.getText());
            con = new dbConection();
            con.getConnection();

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setMaximized(true);
                stage.setTitle("DASHBOARD");
                stage.setScene(scene);
                stage.show();


                Node source = (Node) event.getSource();
                Stage stage2 = (Stage) source.getScene().getWindow();
                stage2.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("Error");
            System.out.println(UsernameTextfield.getText() + "\n" + PasswordTextfield.getText());
        }
    }

}