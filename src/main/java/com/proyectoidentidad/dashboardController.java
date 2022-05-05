package com.proyectoidentidad;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    private TableColumn<User, String> type_user;

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

    //TABLA SALE DATAIL
    @FXML
    private TableView<SaleDetail> sale_Detail;
    @FXML
    private TableColumn<SaleDetail, String> code_sale;
    @FXML
    private TableColumn<SaleDetail, String> amount_sale;
    @FXML
    private TableColumn<SaleDetail, String> price_sale;
    @FXML
    private TableColumn<SaleDetail, String> product_sale;

    @FXML
    private TableColumn<SaleDetail, String> subtotal_sale;
    @FXML
    private TableColumn<SaleDetail, String> total_sale;

    // TABLA SALE HISTORY
    @FXML
    private TableView<SaleHistory> sale_history;
    public static ObservableList<SaleHistory> salehistory;
    @FXML
    private TableColumn<SaleHistory, String> client_saleh;
    @FXML
    private TableColumn<SaleHistory, String> user_saleh;

    @FXML
    private TableColumn<SaleHistory, String> date_saleh;

    @FXML
    private TableColumn<SaleHistory, String> total_saleh;

    @FXML
    private TableColumn<SaleHistory, String> id_saleh;
    @FXML
    private TableColumn<SaleHistory, Button> btndelete_saleh;

    @FXML
    private TableColumn<SaleHistory, Button> btndetail_saleh;


    boolean clientExist;
    private Integer nitClient;
    private Integer idClient;

    boolean productExist;
    private String codeProduct;
    private Integer idProduct;

    @FXML
    private TextField nitField;

    @FXML
    private TextField clientField;

    @FXML
    private TextField adressField;

    @FXML
    private TextField phoneField;
    @FXML
    private TextField codeField;

    @FXML
    private TextField productFiield;

    @FXML
    private TextField priceField;

    @FXML
    private TextField amountField;


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


    //CHARTS

    @FXML
    private LineChart productChar;
    @FXML
    private LineChart clientChart;
    @FXML
    private PieChart sellChart;

    @FXML
    private DatePicker fechaFinCliente;

    @FXML
    private DatePicker fechaFinProducto;

    @FXML
    private DatePicker fechaFinVentas;

    @FXML
    private DatePicker fechaInicioCliente;

    @FXML
    private DatePicker fechaInicioProducto;

    @FXML
    private DatePicker fechaInicioVentas;

    @FXML
    private TextField codigoConsulta;

    @FXML
    private TextField consultaNit;

    @FXML
    private Label totalLabel;
    @FXML
    private Label ivaLabel;
    @FXML
    private Label comprasLabel;

    @FXML
    void consultarCliente(MouseEvent event) throws SQLException {
        String inicio=fechaInicioCliente.getValue().toString();
        String fin=fechaFinCliente.getValue().toString();
        String nit=consultaNit.getText();
        dbConection conexion = new dbConection();
        String sentenciaSQL = String.format("SELECT sum(Total) as Total, month(fecha) as mes FROM venta JOIN clientes as C ON venta.Clientes_id=C.id WHERE C.Nit='%S'" +
                " and Fecha between '%S' AND '%S'\n" +
                "group by month(fecha);",nit,inicio,fin);
        ResultSet resultado = conexion.consultarRegistros(sentenciaSQL);

        XYChart.Series series=new XYChart.Series();
        series.setName("Ventas");

        while(resultado.next()){
            String mes=resultado.getString("mes");
            Float cantidad=Float.valueOf(resultado.getString("Total"));
            //Float ingreso=Float.valueOf(resultado.getString("ingreso"));

            series.getData().add(new XYChart.Data(mes,cantidad));

        }
        clientChart.getData().remove(0,clientChart.getData().size());
        clientChart.getData().add(series);

    }

    @FXML
    void consultarProducto(MouseEvent event) throws SQLException {
        String inicio=fechaInicioProducto.getValue().toString();
        String fin=fechaFinProducto.getValue().toString();
        String codigo=codigoConsulta.getText();
        dbConection conexion = new dbConection();
        String sentenciaSQL = String.format("SELECT sum(Cantidad) as cantidad,sum(SubTotal) as ingreso , month(fecha) as mes FROM identidad.detalle_venta AS DV JOIN producto AS P ON DV.Producto_id=P.id \n" +
                "JOIN venta AS V ON DV.Venta_id=V.id\n" +
                "WHERE P.Nombre='%S'  and Fecha between '%S' AND '%S' \n" +
                "group by month(fecha)",codigo,inicio,fin);
        ResultSet resultado = conexion.consultarRegistros(sentenciaSQL);

        XYChart.Series series=new XYChart.Series();
        series.setName("Cantidad de productos");

        while(resultado.next()){
            String mes=resultado.getString("mes");
            Integer cantidad=Integer.valueOf(resultado.getString("cantidad"));
            Float ingreso=Float.valueOf(resultado.getString("ingreso"));

            series.getData().add(new XYChart.Data(mes,cantidad));

        }
        productChar.getData().remove(0,productChar.getData().size());
        productChar.getData().add(series);


    }

    @FXML
    void consultarTotal(MouseEvent event) throws SQLException {
        String inicio=fechaInicioVentas.getValue().toString();
        String fin=fechaFinVentas.getValue().toString();
        String nit=consultaNit.getText();
        dbConection conexion = new dbConection();
        String sentenciaSQL = String.format("SELECT sum(DV.IVA) as iva FROM detalle_venta AS DV JOIN venta AS V ON DV.Venta_id=V.id \n" +
                "WHERE V.Fecha between '%S' AND '%S' ",inicio,fin);
        ResultSet resultado = conexion.consultarRegistros(sentenciaSQL);
        float iva=0;

        while(resultado.next()){
            iva=Float.valueOf(resultado.getString("iva")); //GET LASTA SELL
        }
        sentenciaSQL=String.format("SELECT SUM(Total) as Total FROM venta WHERE Fecha between '%S' AND '%S' ",inicio,fin);
        resultado=conexion.consultarRegistros(sentenciaSQL);
        float total=0;
        while(resultado.next()){
            total=Float.valueOf(resultado.getString("total")); //GET LASTA SELL
        }

        sentenciaSQL=String.format("SELECT SUM(Total_Neto) as compra FROM compra WHERE Fecha between '%S' AND '%S' ",inicio,fin);
        resultado=conexion.consultarRegistros(sentenciaSQL);
        float compra=0;
        while(resultado.next()){
            compra=Float.valueOf(resultado.getString("compra")); //GET LASTA SELL
        }

        System.out.println(iva);
        System.out.println(total);
        System.out.println(compra);
        float total2=iva+total+compra;
        float ventap=(total*100)/total2;
        float compraP=(compra*100)/total2;
        float ivaP=(iva*100)/total2;
        totalLabel.setText("Ventas: "+total);
        comprasLabel.setText("Compras: "+compra);
        ivaLabel.setText("IVA: "+iva);

        ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList(
                new PieChart.Data("Ventas",ventap),
                new PieChart.Data("Compras",compraP),
                new PieChart.Data("IVA",ivaP)

        );

        sellChart.setData(pieChartData);

    }
    @FXML
    void searchNit(KeyEvent event){
        if(!this.nitField.getText().equals("")){
            this.nitClient=Integer.valueOf(this.nitField.getText());
        }else this.nitClient=0;
        System.out.println(this.nitClient);
        getCliente();
    }
    @FXML
    void searchProduct(KeyEvent event){
        if(!this.codeField.getText().equals("")){
            this.codeProduct=this.codeField.getText();
            System.out.println(this.codeProduct);
            getProduct();
        }

    }

    public void getCliente(){
        try {

            dbConection conexion = new dbConection();
            String sentenciaSQL = String.format("SELECT id,Nombre,Direccion from clientes WHERE nit= '%S'",this.nitClient);
            ResultSet resultado= conexion.consultarRegistros(sentenciaSQL);
            if(!resultado.next()){
                this.clientField.setText("");
                this.adressField.setText("");
                this.nitClient=0;
                this.idClient=0;
                this.clientExist=false;
            }
            else{
                String client=resultado.getString("Nombre");
                this.idClient= Integer.valueOf(resultado.getString("id"));
                String adress=resultado.getString("Direccion");
               // String phone=resultado.getString("Nombre");
                this.clientField.setText(client);
                this.adressField.setText(adress);
                this.clientExist=true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getProduct(){
        try {

            dbConection conexion = new dbConection();
            String sentenciaSQL = String.format("SELECT * from producto WHERE Nombre= '%S'",this.codeProduct);
            ResultSet resultado= conexion.consultarRegistros(sentenciaSQL);
            if(!resultado.next()){
                //this.codeField.setText("");
                this.productFiield.setText("");
                this.codeProduct="";
                this.idProduct=0;
                this.clientExist=false;
            }
            else{
                String code=resultado.getString("Nombre");
                this.idProduct= Integer.valueOf(resultado.getString("id"));
                String descripcion=resultado.getString("Descripcion");
                System.out.println("Ecnontr");
                this.productFiield.setText(descripcion);
                this.clientExist=true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




        initTable();
        //loadData();
        loadProducts();
        loadUser();
        loadProvider();
        loadBuy();
        loadClient();
        load_salehistory();
        this.filterProduct=new FilteredList<>(table_product,e->true);
        this.filterUser=new FilteredList<>(table_User,e->true);
        this.filter_Provider = new FilteredList<>(Provider_Table, e-> true);
        this.filterBuy=new FilteredList<>(table_Buys,e->true);
        this.filterProduct=new FilteredList<>(table_product,e->true);
        this.filterUser=new FilteredList<>(table_User,e->true);
        this.filter_Provider = new FilteredList<>(Provider_Table, e-> true);
        this.filterClient = new FilteredList<>(table_client, e-> true);

        XYChart.Series series=new XYChart.Series();
        series.setName("Cantidad de productos");
        series.getData().add(new XYChart.Data("1",22));
        series.getData().add(new XYChart.Data("2",30));
        series.getData().add(new XYChart.Data("3",22));
        series.getData().add(new XYChart.Data("4",55));
        series.getData().add(new XYChart.Data("5",100));
        series.getData().add(new XYChart.Data("6",22));
        series.getData().add(new XYChart.Data("7",300));

        XYChart.Series series2=new XYChart.Series();
        series2.setName("Venta de Productos");
        series2.getData().add(new XYChart.Data("1",10));
        series2.getData().add(new XYChart.Data("2",5));
        series2.getData().add(new XYChart.Data("3",22));
        series2.getData().add(new XYChart.Data("4",13));
        series2.getData().add(new XYChart.Data("5",100));
        series2.getData().add(new XYChart.Data("6",22));
        series2.getData().add(new XYChart.Data("7",300));


        productChar.getData().add(series);
        productChar.getData().add(series2);
        clientChart.getData().add(series);

        ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList(
                new PieChart.Data("Total",50),
                new PieChart.Data("IVA",25),
                new PieChart.Data("Utilidad",25)

        );

        sellChart.setData(pieChartData);


    }

    private void initTable(){
        initCols();
        initUser();
        initProviders();
        initBuy();
        initClient();
        initsaleDetail();
        initsalehistory();
    }

    private void initUser(){
        user_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        user_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        user_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        user_user.setCellValueFactory(new PropertyValueFactory<>("user"));
        user_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        type_user.setCellValueFactory(new PropertyValueFactory<>("Type"));
        user_update.setCellValueFactory(new PropertyValueFactory<>("update"));
        user_delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        user_update.setMinWidth(100);
        user_update.setMaxWidth(100);
        user_delete.setMinWidth(70);
        user_delete.setMaxWidth(70);
    }

    public void initCols(){

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
        client_phone.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        client_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        client_update.setCellValueFactory(new PropertyValueFactory<>("update"));
        client_delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        client_update.setMinWidth(100);
        client_update.setMaxWidth(100);
        client_delete.setMinWidth(70);
        client_delete.setMaxWidth(70);
    }

    private void initsaleDetail(){
        //String id,sale_id,product_id,amount,price,iva,subtotal,total,code,product;
        code_sale.setCellValueFactory(new PropertyValueFactory<>("code"));
        amount_sale.setCellValueFactory(new PropertyValueFactory<>("amount"));
        price_sale.setCellValueFactory(new PropertyValueFactory<>("price"));
        product_sale.setCellValueFactory(new PropertyValueFactory<>("product"));
        subtotal_sale.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        total_sale.setCellValueFactory(new PropertyValueFactory<>("total"));

    }

    private void initsalehistory(){
        id_saleh.setCellValueFactory(new PropertyValueFactory<>("id"));
        user_saleh.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
        client_saleh.setCellValueFactory(new PropertyValueFactory<>("Cliente"));
        total_saleh.setCellValueFactory(new PropertyValueFactory<>("Total"));
        date_saleh.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
        btndetail_saleh.setCellValueFactory(new PropertyValueFactory<>("sale_datail"));
        btndelete_saleh.setCellValueFactory(new PropertyValueFactory<>("delete"));
        btndetail_saleh.setMinWidth(100);
        btndetail_saleh.setMaxWidth(100);
        btndelete_saleh.setMinWidth(70);
        btndelete_saleh.setMaxWidth(70);
    }

    @FXML
    void addSale(MouseEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        dbConection conexion = new dbConection();
        String id = this.codeProduct.toString();
        String sentenciaSQL = String.format("select Existencia from producto where Nombre = '%S'",id);
        ResultSet resultado = conexion.consultarRegistros(sentenciaSQL);
        Integer existencia;

        while(resultado.next()){
            System.out.println(resultado.getString("Existencia"));
            existencia = Integer.valueOf(resultado.getString("Existencia"));


            if((existencia - Integer.valueOf(this.amountField.getText() )< 0)){

                alert.setTitle("INVENTARIO");
                alert.setHeaderText("la cantidad que quieres vender no se encuentra disponible en el inventario");
                alert.setContentText("Cantidad Existentes: "+String.valueOf(existencia));

                alert.showAndWait();

            }else{

                String produtcid=String.valueOf(this.idProduct);
                String amount=this.amountField.getText();
                String price=this.priceField.getText();
                Integer amounInteger=Integer.valueOf(amount);
                Double priceDouble=Double.valueOf(price);
                Double total=amounInteger*priceDouble;
                String totalString=String.valueOf(total);
                Double iva=(total/1.12)*0.12;
                String code=codeField.getText();
                String product=productFiield.getText();

                sale_Detail.getItems().add(new SaleDetail(
                        null,null,produtcid,amount,price,
                        String.valueOf(iva),totalString,totalString,code,product
                ));
            }
        }




    }

    @FXML
    void sell(MouseEvent event) throws SQLException {

        if(!clientExist){
            //this.insertClient();
            this.nitClient=Integer.valueOf(this.nitField.getText());
            this.getCliente();
        }
       this.insertSell();
        this.insertSaleDetail();
        this.clearSale();

    }

    private void insertSell(){
        LocalDate localdate = LocalDate.now();

        double total=0;
        for (int i = 0; i <sale_Detail.getItems().size() ; i++) {
            total+= Double.valueOf(sale_Detail.getItems().get(i).getTotal());
        }
        System.out.println("Total: "+total);
        //  "INSERT INTO venta (Clientes_id,Usuario_id,Total,Fecha)" + "values('%S','%S')"
        dbConection conexion = new dbConection();
        String sentenciaSQL = String.format("INSERT INTO venta (Clientes_id,Usuario_id,Total,Fecha)" + "values('%S','%S','%S','%S')",
                this.idClient,1,total,localdate);
        conexion.ejecutarSenctenciaSQL(sentenciaSQL);

    }

    private void insertSaleDetail() throws SQLException {

        dbConection conexion = new dbConection();
        String sentenciaSQL = String.format("SELECT MAX( id ) AS idVenta FROM venta");
        ResultSet resultado= conexion.consultarRegistros(sentenciaSQL);
        Integer sale_id=0;
        while (resultado.next()){
             sale_id=Integer.valueOf(resultado.getString("idVenta")); //GET LASTA SELL
        }



        for (int i = 0; i <sale_Detail.getItems().size() ; i++) {
            String produtcid=String.valueOf(this.idProduct);
            Integer amount=Integer.valueOf(sale_Detail.getItems().get(i).getAmount());
            Double price=Double.valueOf(sale_Detail.getItems().get(i).getPrice());
            Double iva=Double.valueOf(sale_Detail.getItems().get(i).getIva());
            Double subTotal=Double.valueOf(sale_Detail.getItems().get(i).getSubtotal());
            //  "INSERT INTO detalle_venta (venta_id,producto_id,Cantidad,Precio,IVA,SubTotal)" + "values('%S','%S')"
            sentenciaSQL = String.format("INSERT INTO Detalle_Venta (venta_id,producto_id,Cantidad,Precio,IVA,SubTotal)" + "values('%S','%S','%S','%S','%S','%S')",
                    sale_id,produtcid,amount,price,iva,subTotal);
            conexion.ejecutarSenctenciaSQL(sentenciaSQL);
        }

    }

    private void clearSale(){

            sale_Detail.getItems().remove(0,sale_Detail.getItems().size() );


    }

    //FUNCION VENDER
    /*
    {
        1.CREAR VENTA
        2.OBTENER EL ID DE LA ULTIMA VENTA
        3.ACTUALIZAR CON UN FOR TODOS LOS DETALLE VENTAS PARA PONERLES EL ID
        4.CREAR DETALLES VENTAS
    }*/

    @FXML
    void deleteSaleItem(MouseEvent event) {
        sale_Detail.getItems().removeAll(sale_Detail.getSelectionModel().getSelectedItem());
        sale_Detail.getSelectionModel().clearSelection();
    }


    private void editCols(){


    }

    public void redoTable(){
        loadProducts();
        loadUser();
        loadProvider();
        loadBuy();
        loadClient();
        load_salehistory();

    }
    private void loadUser(){
        table_User = FXCollections.observableArrayList();
        try {
            dbConection conexion = new dbConection();
            ResultSet resultado = conexion.consultarRegistros("select * from usuario");
            while(resultado.next()){
                table_User.add(new User(resultado.getString("id"),resultado.getString("Nombre"),resultado.getString("Apellido"),
                        resultado.getString("Usuario"),resultado.getString("Contrasena"),
                        resultado.getString("Tipo"),
                        new Button("Editar"),
                        new Button("Eliminar")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_user.setItems(table_User);
    }

    public void loadProducts(){
        table_product = FXCollections.observableArrayList();

        try {

           dbConection conexion = new dbConection();
           ResultSet resultado = conexion.consultarRegistros("select * from producto");

           while(resultado.next()){
               table_product.add(new Product(resultado.getString("id"),resultado.getString("Nombre"),
                   resultado.getString("Descripcion"),resultado.getString("Existencia"),resultado.getString("Produccion"),
               new Button("Editar"),
               new Button("Eliminar")));

           }

        }catch (Exception e){
            System.out.println(e);
        }

        Product_Table.setItems(table_product);

    }

    private  void loadProvider() {
        Provider_Table = FXCollections.observableArrayList();
        dbConection conexion = new dbConection();
        ResultSet resultado = conexion.consultarRegistros("select * from proveedores");
        try {
            while(resultado.next()){
                Provider_Table.add(new Provider(resultado.getString("id"),resultado.getString("Nit"),resultado.getString("Nombre"),
                        resultado.getString("Telefono"),resultado.getString("Direccion"),
                        new Button("Editar"),
                        new Button("Eliminar")));
            }


        }catch (Exception e){
            System.out.println(e);
        }
        Provider_table.setItems(Provider_Table);
    }

    private void load_salehistory(){
        salehistory = FXCollections.observableArrayList();
        try{
            dbConection conexion = new dbConection();
            ResultSet resultado = conexion.consultarRegistros("select venta.id,usuario.Nombre as usuario,clientes.Nombre as cliente,venta.Total,venta.Fecha\n" +
                    "from venta\n" +
                    "inner join usuario\n" +
                    "on venta.Usuario_id = usuario.id\n" +
                    "inner join clientes\n" +
                    "on venta.Clientes_id = clientes.id");
            while(resultado.next()){
                salehistory.add(new SaleHistory(resultado.getString("id"),
                                resultado.getString("usuario"),
                                resultado.getString("cliente"),
                                resultado.getString("Total"),
                                resultado.getString("Fecha"),
                                new Button("Detalles"),
                                new Button("Eliminar")));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        sale_history.setItems(salehistory);
    }

    private void loadBuy(){
        table_Buys = FXCollections.observableArrayList();
        //private String id,date,serie,no,nit,name,mount_net,mount_gross,mount_IVA;
        try {
            dbConection conexion = new dbConection();
            ResultSet resultado = conexion.consultarRegistros("SELECT * FROM compra AS C JOIN proveedores AS  P ON C.Proveedores_id=P.id;");
            while(resultado.next()){
                table_Buys.add(new Buy(resultado.getString("id"),
                        resultado.getString("Fecha"),resultado.getString("Serie"),
                        resultado.getString("Factura"),resultado.getString("Nit"),
                        resultado.getString("Nombre"),resultado.getString("Total_Neto"),
                        resultado.getString("Total_Bruto"),resultado.getString("IVA"),
                        new Button("Editar"),new Button("Eliminar")));

            }

        }catch (Exception e){
            System.out.println(e);
        }
        table_buys.setItems(table_Buys);
    }
    private void loadClient(){
       table_client = FXCollections.observableArrayList();
       try {
           dbConection conexion = new dbConection();
           ResultSet resultado = conexion.consultarRegistros("select * from clientes");
           while(resultado.next()){
               table_client.add(new Client(resultado.getString("id"),resultado.getString("Nit"),resultado.getString("Nombre"),resultado.getString("Telefono"),
               resultado.getString("Direccion"),new Button("Editar"),new Button("Eliminar")));
           }

       }catch (Exception e){
           System.out.println(e);
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
    void addBuy(MouseEvent event) {
        try {
            BuyHolder holder = BuyHolder.getInstance();
            // Step 3
            holder.setBuy(null);

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addBuy-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Buy");
            stage.setScene(scene);
            stage.show();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    @FXML
    void showProductsPage(MouseEvent event) {
            this.loadProducts();
            pgProducts.toFront();
    }


    @FXML
    void showUsersPage(MouseEvent event) {
        pgUsers.toFront();
        this.loadUser();
    }

    @FXML
    void showSellsPage(MouseEvent event) {
        pgSales.toFront();
        this.load_salehistory();
    }


    @FXML
    void showChartsPage(MouseEvent event) {
     pgCharts.toFront();
    }

    @FXML
    void showClientsPage(MouseEvent event) {
      pgClients.toFront();
      this.loadClient();
    }


    @FXML
    void showShoppingPage(MouseEvent event) {
        pgShopping.toFront();
        this.loadBuy();
    }

    @FXML
    void showProvidersPage(MouseEvent event) {
        pgProviders.toFront();
        this.loadProvider();
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


    @FXML
    void filterBuy(KeyEvent event) {
        searchBuy.textProperty().addListener((observable, oldValue, newValue) ->{
            filterBuy.setPredicate(buy -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                //id,date,serie,no,nit,name,mount_net,mount_gross,mount_IVA;
                String lowerCaseFilter = newValue.toLowerCase();
                if (buy.getId().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (buy.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (buy.getSerie().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (buy.getNo().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (buy.getNit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } if (buy.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                if (buy.getMount_gross().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                if (buy.getMount_net().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                if (buy.getMount_IVA().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                else{
                    return false;
                }

            });
        } );
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Buy> sortedData = new SortedList<>(filterBuy);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(table_buys.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table_buys.setItems(sortedData);
    }

    ////TABLE PROVIDER

}