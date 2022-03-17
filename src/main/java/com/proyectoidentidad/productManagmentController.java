package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class productManagmentController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProductHolder holder = ProductHolder.getInstance();
        if (holder.getProduct()!=null){
            System.out.println(ProductHolder.getInstance());
            Product product = holder.getProduct();
            this.idField.setText(product.getId());
            this.codeField.setText(product.getCode());
            this.descriptionField.setText(product.getDescription());
            this.stockField.setText(product.getStock());
            this.productionField.setText(product.getProduction());
        }


    }
}