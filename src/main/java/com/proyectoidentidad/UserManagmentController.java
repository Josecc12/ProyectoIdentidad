package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserManagmentController implements Initializable {
    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserHolder holder = UserHolder.getInstance();
        if (holder.getUser()!=null){
            System.out.println(ProductHolder.getInstance());
            User user = holder.getUser();
            this.idField.setText(user.getId());
            this.nameField.setText(user.getName());
            this.passwordField.setText(user.getPassword());
            this.userField.setText(user.getUser());

        }
    }
}
