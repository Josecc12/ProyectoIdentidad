package com.proyectoidentidad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class detailSaleController  implements Initializable {

    @FXML
    private TableView<SaleDetail> detailTable;

    @FXML
    private TableColumn<SaleDetail, String> amount;

    @FXML
    private TableColumn<SaleDetail, String> iva;

    @FXML
    private TableColumn<SaleDetail, String>price;

    @FXML
    private TableColumn<SaleDetail, String>product;

    @FXML
    private TableColumn<SaleDetail, String> subtotal;
    private static ObservableList<SaleDetail> aux;

    private void initTable(){
        //id,sale_id,product_id,amount,price,iva,subtotal,total,code,product
        product.setCellValueFactory(new PropertyValueFactory<>("product"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        iva.setCellValueFactory(new PropertyValueFactory<>("iva"));
        subtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

    }

    private void loadTable() throws SQLException {
         aux = FXCollections.observableArrayList();
        SaleHolder holder = SaleHolder.getInstance();
        dbConection conexion = new dbConection();
        Integer id=Integer.valueOf(holder.getSale().getId());
        String sentenciaSQL = String.format("SELECT Nombre,Cantidad,Precio,IVA,SubTotal FROM detalle_venta as D JOIN producto as P ON D.Producto_id=P.id WHERE D.Venta_id='%S'",id);
        ResultSet resultado= conexion.consultarRegistros(sentenciaSQL);
        while(resultado.next()){
            aux.add(new SaleDetail(resultado.getString("Cantidad"),resultado.getString("Precio"),
                    resultado.getString("IVA"),resultado.getString("SubTotal"),resultado.getString("SubTotal"),resultado.getString("Nombre")));
        }
        detailTable.setItems(aux);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initTable();
            loadTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
