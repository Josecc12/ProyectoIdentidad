package com.proyectoidentidad;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Product> Product_Table;
    public static TableView<Product> Product_Table2;

    @FXML
    private TableColumn<Product, String> Id_Column;

    @FXML
    private TableColumn<Product, String> Code_Column;

    @FXML
    private TableColumn<Product, String> Description_Column;

    @FXML
    private TableColumn<Product, String> Stock_Column;

    @FXML
    private TableColumn<Product, String> Production_Column;

    @FXML
    private TableColumn<Product, Button> Action_Column;

    @FXML
    private TableColumn<Product, Button> Delete_Column;
    public static ObservableList<Product> table_product;

    Stage stage=null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Product_Table2=Product_Table;
        initTable();
        loadData();
    }

    private void initTable(){
        initCols();
    }

    private void initCols(){


        //id,code,description,stock,production
        Id_Column.setCellValueFactory(new PropertyValueFactory<>("id"));
        Code_Column.setCellValueFactory(new PropertyValueFactory<>("code"));
        Description_Column.setCellValueFactory(new PropertyValueFactory<>("description"));
        Stock_Column.setCellValueFactory(new PropertyValueFactory<>("stock"));
        Production_Column.setCellValueFactory(new PropertyValueFactory<>("production"));
        Action_Column.setCellValueFactory(new PropertyValueFactory<>("update"));
        Action_Column.setMinWidth(100);
        Action_Column.setMaxWidth(100);
        Delete_Column.setCellValueFactory(new PropertyValueFactory<>("delete"));
        Delete_Column.setMinWidth(70);
        Delete_Column.setMaxWidth(70);
        editCols();
    }

    private void editCols(){


    }

    public void prueba(){
        this.loadData();

    }

    private  void loadData(){
        table_product=FXCollections.observableArrayList();
        for(int i = 0; i<25; i++){
            Button ac=new  Button("Editar");
            Product aux= new Product(String.valueOf(i),"2","Des","11",
                    "11",ac,new Button("Eliminar"));
            table_product.add(aux);
            //System.out.println("Botton "+i+" B:"+ac+" B2:"+aux.getUpdate());
        }
        Product_Table.setItems(table_product);

    }

    @FXML
    void addProduct(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addProduct-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage=new Stage();
            stage.setTitle("Product Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}