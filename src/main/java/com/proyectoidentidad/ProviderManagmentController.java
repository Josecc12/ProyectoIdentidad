package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
