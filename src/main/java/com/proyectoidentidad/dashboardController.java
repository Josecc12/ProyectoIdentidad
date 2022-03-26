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

public class dashboardController implements Initializable{

    @FXML
    private TableView<Product> Product_Table;


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
    private TextField searchProduct;
    private FilteredList<Product> filterProduct;

    // Table User
    @FXML
    private TableView<User> table_user;
    public static ObservableList<User> table_User;
    @FXML
    private TableColumn<User, String> user_lastname;

    @FXML
    private TableColumn<User, String> user_id;

    @FXML
    private TableColumn<User, String> user_name;

    @FXML
    private TableColumn<User, String> user_password;

    @FXML
    private TableColumn<User, String> user_user;

    @FXML
    private TextField searchUser;
    private FilteredList<User> filterUser;

    @FXML
    private TableColumn<User, Button> user_update;

    @FXML
    private TableColumn<User, Button> user_delete;

    //TABLA PROVIDER
    @FXML
    private TableView<Provider> Provider_table;
    public static ObservableList<Provider> Provider_Table;

    @FXML
    private TableColumn<Provider, String> provider_address;

    @FXML
    private TableColumn<Provider, String> provider_id;

    @FXML
    private TableColumn<Provider, String> provider_name;

    @FXML
    private TableColumn<Provider, String> provider_nit;

    @FXML
    private TableColumn<Provider, String> provider_phone;

    @FXML
    private TextField search_provider;
    private FilteredList<Provider> filter_Provider;

    @FXML
    private TableColumn<Provider, Button> provider_action;

    @FXML
    private TableColumn<Provider, Button> provider_delete;

    ///Table Client
    @FXML
    private TableView<Client> table_Client;
    public static ObservableList<Client> table_client;
    @FXML
    private TableColumn<Client, String> client_id;

    @FXML
    private TableColumn<Client, String> client_name;

    @FXML
    private TableColumn<Client, String> client_address;

    @FXML
    private TableColumn<Client, String> client_phone;

    @FXML
    private TableColumn<Client, String> client_nit;

    @FXML
    private TextField searchClient;
    private FilteredList<Client> filterClient;

    @FXML
    private TableColumn<Client, Button> client_update;

    @FXML
    private TableColumn<Client, Button> client_delete;

    ///

    // Table Buys
    @FXML
    private TableView<Buy> table_buys;
    public static ObservableList<Buy> table_Buys;
    @FXML
    private TableColumn<User, String> buy_id;

    @FXML
    private TableColumn<User, String> buy_date;

    @FXML
    private TableColumn<User, String> buy_serie;

    @FXML
    private TableColumn<User, String> buy_NO;

    @FXML
    private TableColumn<User, String> buy_NIT;

    @FXML
    private TableColumn<User, String> buy_name;

    @FXML
    private TableColumn<User, String> buy_net;

    @FXML
    private TableColumn<User, String> buy_gross;

    @FXML
    private TableColumn<User, String> buy_IVA;

    @FXML
    private TextField searchBuy;
    private FilteredList<Buy> filterBuy;

    @FXML
    private TableColumn<User, Button> buy_action;

    @FXML
    private TableColumn<User, Button> buy_delete;



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
    private GridPane pgProviders;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initTable();
        loadData();
        loadUser();
        loadProvider();
        loadBuy();
        this.filterProduct=new FilteredList<>(table_product,e->true);
        this.filterUser=new FilteredList<>(table_User,e->true);
        this.filter_Provider = new FilteredList<>(Provider_Table, e-> true);
        //this.filterBuy=new FilteredList<>(table_Buys,e->true);
        loadClient();
        this.filterProduct=new FilteredList<>(table_product,e->true);
        this.filterUser=new FilteredList<>(table_User,e->true);
        this.filter_Provider = new FilteredList<>(Provider_Table, e-> true);
        this.filterClient = new FilteredList<>(table_client, e-> true);
    }

    private void initTable(){
        initCols();
        initUser();
        initProviders();
        initBuy();
        initClient();
    }

    private void initUser(){
        user_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        user_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        user_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        user_user.setCellValueFactory(new PropertyValueFactory<>("user"));
        user_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        user_update.setCellValueFactory(new PropertyValueFactory<>("update"));
        user_delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        user_update.setMinWidth(100);
        user_update.setMaxWidth(100);
        user_delete.setMinWidth(70);
        user_delete.setMaxWidth(70);
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

    private void initProviders(){
        provider_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        provider_nit.setCellValueFactory(new PropertyValueFactory<>("Nit"));
        provider_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        provider_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        provider_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        provider_action.setCellValueFactory(new PropertyValueFactory<>("update"));
        provider_action.setMaxWidth(100);
        provider_action.setMinWidth(100);
        provider_delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        provider_delete.setMaxWidth(70);
        provider_delete.setMinWidth(70);
    }


    private void initBuy(){
        //id,date,serie,no,nit,name,mount_net,mount_gross,mount_IVA;
        buy_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        buy_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        buy_serie.setCellValueFactory(new PropertyValueFactory<>("serie"));
        buy_NO.setCellValueFactory(new PropertyValueFactory<>("no"));
        buy_NIT.setCellValueFactory(new PropertyValueFactory<>("nit"));
        buy_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        buy_net.setCellValueFactory(new PropertyValueFactory<>("mount_net"));
        buy_gross.setCellValueFactory(new PropertyValueFactory<>("mount_gross"));
        buy_IVA.setCellValueFactory(new PropertyValueFactory<>("mount_IVA"));
        buy_action.setCellValueFactory(new PropertyValueFactory<>("update"));
        buy_delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        buy_action.setMaxWidth(100);
        buy_action.setMinWidth(100);
        buy_delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        buy_delete.setMaxWidth(70);
        buy_delete.setMinWidth(70);
    }
    private void initClient(){
        client_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        client_nit.setCellValueFactory(new PropertyValueFactory<>("nit"));
        client_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        client_phone.setCellValueFactory(new PropertyValueFactory<>("phone number"));
        client_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        client_update.setCellValueFactory(new PropertyValueFactory<>("update"));
        client_delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        client_update.setMinWidth(100);
        client_update.setMaxWidth(100);
        client_delete.setMinWidth(70);
        client_delete.setMaxWidth(70);
    }

    private void editCols(){


    }

    public void prueba(){
        System.out.println("Hola");

    }
    private void loadUser(){
        table_User = FXCollections.observableArrayList();
        for (int i = 0; i < 7; i++) {
            table_User.add(new User(String.valueOf(i),
                    "name"+i,
                    "lastname"+i,
                    "user"+i,
                    "password"+i,
                    new Button("Actualizar"),
                    new Button("Eliminar")));
        }
        table_user.setItems(table_User);
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
    private  void loadProvider() {
        Provider_Table = FXCollections.observableArrayList();
        for(int i = 0; i<25; i++){
            Button ac=new  Button("Editar");
            Provider aux = new Provider(String.valueOf(i), "Nit" + String.valueOf(i+2),
                    "Name" + String.valueOf(i+5),"Phone" + String.valueOf(i+2),
                    String.valueOf(i+15),ac,new Button("Eliminar"));
            Provider_Table.add(aux);

        }
        Provider_table.setItems(Provider_Table);
    }



    private void loadBuy(){
        table_Buys = FXCollections.observableArrayList();
        for(int i = 0; i<25; i++){
            Button ac=new  Button("Editar");
            Buy aux = new Buy(String.valueOf(i),String.valueOf(i*2),String.valueOf(i+11),String.valueOf(i),
                    String.valueOf(i),String.valueOf(i),String.valueOf(i),String.valueOf(i/2),String.valueOf(i+16),
                    ac,new Button("Eliminar"));
            table_Buys.add(aux);

        }
        table_buys.setItems(table_Buys);
    }
    private void loadClient(){
        table_client = FXCollections.observableArrayList();
        for (int i = 0; i < 7; i++) {
            table_client.add(new Client(String.valueOf(i),
                    "NIT"+i,
                    "name"+i,
                    "Phone"+i,
                    "Adress"+i,
                    new Button("Actualizar"),
                    new Button("Eliminar")));
        }
        table_Client.setItems(table_client);
    }

    @FXML
    void addProduct(MouseEvent event) {
        try {
            ProductHolder holder = ProductHolder.getInstance();
            // Step 3
            holder.setProduct(null);

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
    void addUser(MouseEvent event) {
        try {
            UserHolder holder=UserHolder.getInstance();
            holder.setUser(null);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addUser-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage=new Stage();
            stage.setTitle("Product Management");
            stage.setScene(scene);
            stage.show();
            System.out.println("Se debe actuzalizar");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    @FXML
    void addProvider(MouseEvent event) {
        try {
            ProviderHolder holder = ProviderHolder.getInstance();
            // Step 3
            holder.setProvider(null);

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addProvider-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Provider");
            stage.setScene(scene);
            stage.show();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void addClient(MouseEvent event) {
        try {
            ClientHolder holder=ClientHolder.getInstance();
            holder.setClient(null);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addClient-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage=new Stage();
            stage.setTitle("Client Management");
            stage.setScene(scene);
            stage.show();
            System.out.println("Se debe actuzalizar");
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
    void showProvidersPage(MouseEvent event) {
        pgProviders.toFront();
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


    @FXML
    void filterUser(KeyEvent event) {
        searchUser.textProperty().addListener((observable, oldValue, newValue) ->{
            filterUser.setPredicate(user -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (user.getId().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (user.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (user.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (user.getUser().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (user.getPassword().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else{
                    return false;
                }

            });
        } );
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<User> sortedData = new SortedList<>(filterUser);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(table_user.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table_user.setItems(sortedData);
    }

    @FXML
    void filterProvider(KeyEvent event) {

        search_provider.textProperty().addListener((observable, oldValue, newValue) ->{

            filter_Provider.setPredicate(provider -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (provider.getId().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (provider.getNit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (provider.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (provider.getPhone().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (provider.getAddress().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else{
                    return false;
                }

            });
        } );
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Provider> sortedData = new SortedList<>(filter_Provider);
        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(Provider_table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        Provider_table.setItems(sortedData);
    }

    @FXML
    void filterClient(KeyEvent event) {
        searchClient.textProperty().addListener((observable, oldValue, newValue) ->{
            filterClient.setPredicate(client -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (client.getId().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (client.getNit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (client.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (client.getPhone_number().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (client.getAddress().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else{
                    return false;
                }

            });
        } );
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Client> sortedData = new SortedList<>(filterClient);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(table_Client.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table_Client.setItems(sortedData);
    }

    ////TABLE PROVIDER

}