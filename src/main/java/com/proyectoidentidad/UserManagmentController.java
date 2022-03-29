package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

    @FXML
    private TextField apellidofield;


    @FXML
    void save_user(MouseEvent event) {
        UserHolder holder = UserHolder.getInstance();
        dbConection conexion = new dbConection();

        if(holder.getUser()==null){
            String sentenciaSQL =  String.format("INSERT INTO usuario (Nombre,Apellido,Usuario,Contrasena)" + "values ('%S','%S','%S','%S')",
                    this.nameField.getText(),this.apellidofield.getText(),this.userField.getText(),this.passwordField.getText());
                    conexion.ejecutarSenctenciaSQL(sentenciaSQL);
        }else{
            String sentenciaSQL = String.format("UPDATE usuario SET Nombre='%S',Apellido = '%S',Usuario = '%S',Contrasena = '%S' WHERE id = '%S'",
                    this.nameField.getText(),this.apellidofield.getText(),this.userField.getText(),this.passwordField.getText(),
                    Integer.valueOf(this.idField.getText()));
            conexion.ejecutarSenctenciaSQL(sentenciaSQL);
        }

        this.cerrarVentana(event);

    }

    private void cerrarVentana(MouseEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }

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
