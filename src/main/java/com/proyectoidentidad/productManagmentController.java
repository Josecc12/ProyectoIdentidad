package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class productManagmentController {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField codeField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField idField;

    @FXML
    private TextField productionField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField stockField;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void  setPrueba(String pass){
        codeField.setText(pass);
    }

    @FXML
    void saveProduct(MouseEvent event) {

    }
}