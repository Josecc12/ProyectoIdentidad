package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProviderManagmentController implements Initializable {

    @FXML
    private TextField NITField;

    @FXML
    private TextField adressField;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneFiled;

    @FXML
    void saveProvider(MouseEvent event) {
        ProviderHolder holder = ProviderHolder.getInstance();
        dbConection conexion = new dbConection();

        if(holder.getProvider() == null){
            String sentenciaSQL = String.format("INSERT INTO proveedores (Nombre,Direccion,Nit,Telefono)" + "values('%S','%S','%S','%S')",
                    this.nameField.getText(),this.adressField.getText(),Integer.valueOf(this.NITField.getText()),this.phoneFiled.getText());
            conexion.ejecutarSenctenciaSQL(sentenciaSQL);

        }else{
            String sentenciaSQL = String.format("UPDATE proveedores SET Nombre = '%S', Direccion ='%S',Nit = '%S',Telefono = '%S' WHERE id = '%S'",
                    this.nameField.getText(),this.adressField.getText(),Integer.valueOf(this.NITField.getText()),this.phoneFiled.getText(),Integer.valueOf(this.idField.getText()));
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
        ProviderHolder holder = ProviderHolder.getInstance();

        if (holder.getProvider()!=null){
            System.out.println(ProductHolder.getInstance());
            Provider provider = holder.getProvider();
            this.idField.setText(provider.getId());
            this.NITField.setText(provider.getNit());
            this.nameField.setText(provider.getName());
            this.phoneFiled.setText(provider.getPhone());
            this.adressField.setText(provider.getAddress());
        }

    }
}
