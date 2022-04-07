package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;


import java.net.URL;
import java.util.ResourceBundle;

public class productManagmentController implements Initializable  {



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
        ProductHolder holder = ProductHolder.getInstance();
        dbConection conexion = new dbConection();

        if (holder.getProduct() == null) {
            String sentenciaSQL = String.format("INSERT INTO producto (Nombre,Existencia,Produccion,Descripcion)" + "values ('%S','%S','%S','%S')",
                    this.codeField.getText(), Integer.valueOf(this.stockField.getText()), Integer.valueOf(this.productionField.getText()), this.descriptionField.getText());
            conexion.ejecutarSenctenciaSQL(sentenciaSQL);

        } else {
            String sentenciaSQL = String.format("UPDATE producto SET Nombre='%S',Existencia = '%S',Produccion = '%S',Descripcion = '%S' WHERE id = '%S'", this.codeField.getText(),
                    Integer.valueOf(this.stockField.getText()), Integer.valueOf(this.productionField.getText()),this.descriptionField.getText(),
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