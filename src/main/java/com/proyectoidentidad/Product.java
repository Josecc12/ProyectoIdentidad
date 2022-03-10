package com.proyectoidentidad;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class Product {
    private String id,code,description,stock,production;
    private Button update;
    private Button delete;


    public Product(String id, String code, String description, String stock, String production,Button update,Button delete) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.stock = stock;
        this.production = production;
        this.update = update;
        this.delete=delete;


        update.setTextAlignment(TextAlignment.CENTER);
        update.setTextFill(Color.web("ffff"));
        update.setStyle("-fx-background-color: #29CC97; ");
        //update.getStylesheets().add(getClass().getResource("dashboard.fxml").toExternalForm());
        //update.getStyleClass().add("red-border");
        update.setPadding(new Insets(5));
        //update.setAlignment(Pos.CENTER);
        update.setMinWidth(95);



        delete.setTextAlignment(TextAlignment.CENTER);
        delete.setTextFill(Color.web("ffff"));
        delete.setStyle("-fx-background-color: #e85555; ");
        delete.setPadding(new Insets(5));
        delete.setMinWidth(65);

        update.setOnAction(e->{


           for (int i = 0; i< dashboardController.table_product.size(); i++){
               if(update.hashCode()== dashboardController.table_product.get(i).getUpdate().hashCode()){
                   System.out.println("id"+ dashboardController.table_product.get(i).getId());
                   System.out.println("code"+ dashboardController.table_product.get(i).getCode());
                   System.out.println("stock"+ dashboardController.table_product.get(i).getStock());
                   System.out.println("production"+ dashboardController.table_product.get(i).getProduction());
                   System.out.println("");


                   try {
                       FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addProduct-view.fxml"));
                       productManagmentController controller=fxmlLoader.getController();

                       Scene scene = new Scene(fxmlLoader.load());
                       Stage stage=new Stage();
                       stage.setTitle("Product Management");
                       stage.setScene(scene);
                       //controller.setPrueba("Hola");
                       stage.show();




                   } catch (IOException ex) {
                       ex.printStackTrace();
                   }


               }
           }


        });






    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
