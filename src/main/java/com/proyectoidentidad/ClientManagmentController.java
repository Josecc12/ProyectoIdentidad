package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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