package com.proyectoidentidad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {

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
    @FXML
    private GridPane pgCharts;

    @FXML
    private GridPane pgClients;

    @FXML
    private GridPane pgProducts;

    @FXML
    private GridPane pgSales;

    @FXML
    private GridPane pgShopping;

    @FXML
    private GridPane pgUsers;
    @FXML
    private TextField searchProduct;
    private FilteredList<Product> filterProduct;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Product_Table2=Product_Table;
        initTable();
        loadData();
         this.filterProduct=new FilteredList<>(table_product,e->true);
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
        System.out.println("Hola");

    }

    private  void loadData(){
        table_product=FXCollections.observableArrayList();
        for(int i = 0; i<25; i++){
            Button ac=new  Button("Editar");
            Product aux= new Product(String.valueOf(i),"Code"+String.valueOf(i+2),
                    "Description"+String.valueOf(i+5),String.valueOf(i+8),
                    String.valueOf(i+15),ac,new Button("Eliminar"));
            table_product.add(aux);

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

    @FXML
    void showProductsPage(MouseEvent event) {
            pgProducts.toFront();
    }

    @FXML
    void showUsersPage(MouseEvent event) {
        pgUsers.toFront();

    }

    @FXML
    void showSellsPage(MouseEvent event) {
        pgSales.toFront();
    }


    @FXML
    void showChartsPage(MouseEvent event) {
     pgCharts.toFront();
    }

    @FXML
    void showClientsPage(MouseEvent event) {
      pgClients.toFront();
    }


    @FXML
    void showShoppingPage(MouseEvent event) {
    pgShopping.toFront();
    }

    @FXML
    void filterProduct(KeyEvent event) {
        searchProduct.textProperty().addListener((observable, oldValue, newValue) ->{
         filterProduct.setPredicate(product -> {

             if (newValue == null || newValue.isEmpty()) {
                 return true;
             }
             String lowerCaseFilter = newValue.toLowerCase();
             if (product.getId().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                 return true; // Filter matches first name.
             } else if (product.getCode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                 return true; // Filter matches last name.
             }else if (product.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                 return true; // Filter matches last name.
             }else if (product.getStock().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                 return true; // Filter matches last name.
             }else if (product.getProduction().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                 return true; // Filter matches last name.
             }else{
                 return false;
             }

         });
        } );
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Product> sortedData = new SortedList<>(filterProduct);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(Product_Table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        Product_Table.setItems(sortedData);
    }


}