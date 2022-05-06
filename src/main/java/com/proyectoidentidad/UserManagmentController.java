package com.proyectoidentidad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserManagmentController implements Initializable {
    @FXML
    private CheckBox check_admin;

    @FXML
    private CheckBox check_empleado;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userField;

    @FXML

    private TextField lastNameField;


    @FXML
    void EmpleadoCheck(ActionEvent event) {
        if(check_empleado.isSelected()){
            check_admin.setDisable(true);
        }else{
            check_admin.setDisable(false);
        }
    }

    @FXML
    void adminCheck(ActionEvent event) {
        if(check_admin.isSelected()){
            check_empleado.setDisable(true);
        }else{
            check_empleado.setDisable(false);
        }
    }

    @FXML
    void save_user(MouseEvent event) {
        UserHolder holder = UserHolder.getInstance();
        dbConection conexion = new dbConection();
        String usuario_tipo;
        if(check_admin.isSelected()){
            usuario_tipo = "Administrador";
        }else{
            usuario_tipo = "Empleado";
        }


        if(holder.getUser()==null){
            String sentenciaSQL =  String.format("INSERT INTO usuario (Nombre,Apellido,Usuario,Contrasena,Tipo)" + "values ('%S','%S','%S','%S','%S')",
                    this.nameField.getText(),this.lastNameField.getText(),this.userField.getText(),this.passwordField.getText(),usuario_tipo);
                    conexion.ejecutarSenctenciaSQL(sentenciaSQL);
        }else{
            String sentenciaSQL = String.format("UPDATE usuario SET Nombre='%S',Apellido = '%S',Usuario = '%S',Contrasena = '%S', Tipo = '%S' WHERE id = '%S'",
                    this.nameField.getText(),this.lastNameField.getText(),this.userField.getText(),this.passwordField.getText(),usuario_tipo,
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
            User user = holder.getUser();
            this.idField.setText(user.getId());
            this.nameField.setText(user.getName());
            this.lastNameField.setText(user.getLastname());
            this.passwordField.setText(user.getPassword());
            this.userField.setText(user.getUser());

        }
    }


}
