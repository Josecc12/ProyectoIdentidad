package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;


import java.net.URL;
import java.util.ResourceBundle;

public class ClientManagmentController {
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

        if(holder == null){
            String sentenciaSQL = String.format("INSERT INTO clientes (Nombre,Direccion,Nit)" + "values (nombre,Direccion,Nit)",this.nameField.getText(),
                    this.addressField.getText(),this.nitField.getText());
            conexion.ejecutarSenctenciaSQL(sentenciaSQL);

        }else{
            System.out.println("Esto es un Update");
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
            System.out.println(ProductHolder.getInstance());
            Client client = holder.getClient();
            this.idField.setText(client.getId());
            this.nitField.setText(client.getNit());
            this.nameField.setText(client.getName());
            this.phoneField.setText(client.getPhone_number());
            this.addressField.setText(client.getAddress());

        }
    }
}