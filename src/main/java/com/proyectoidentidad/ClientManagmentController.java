package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;


import java.net.URL;
import java.util.ResourceBundle;

public class ClientManagmentController implements Initializable {
    @FXML
    private TextField idField;

    @FXML
    private TextField nitField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    ///@Override
    @FXML
    void save_client(MouseEvent event) {
        ClientHolder holder = ClientHolder.getInstance();
        dbConection conexion = new dbConection();

        if(holder.getClient() == null){

            String sentenciaSQL = String.format("INSERT INTO clientes (Nombre,Direccion,Nit,Telefono)" + "values ('%S','%S','%S','%S')",this.nameField.getText(),
                    this.addressField.getText(),Integer.valueOf(this.nitField.getText()),this.phoneField.getText());
            conexion.ejecutarSenctenciaSQL(sentenciaSQL);

        }else{
            String setenciaSQL = String.format("UPDATE clientes SET Nombre='%S',Direccion = '%S',Nit = '%S',Telefono = '%S' WHERE id = '%S'",this.nameField.getText(),
                    this.addressField.getText(),Integer.valueOf(this.nitField.getText()),this.phoneField.getText(),Integer.valueOf(this.idField.getText()));
            conexion.ejecutarSenctenciaSQL(setenciaSQL);
        }

        this.cerrarVentana(event);
    }

    private void cerrarVentana(MouseEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        ClientHolder holder = ClientHolder.getInstance();
        if (holder.getClient()!=null){
            Client client = holder.getClient();
            this.idField.setText(client.getId());
            this.nitField.setText(client.getNit());
            this.nameField.setText(client.getName());
            this.phoneField.setText(client.getPhone_number());
            this.addressField.setText(client.getAddress());

        }
    }
}