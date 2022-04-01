package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BuyManagmentController implements Initializable {

    @FXML
    private TextField NoField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField idField;

    @FXML
    private TextField mountField;

    @FXML
    private TextField nitFiled;

    @FXML
    private TextField providerField;

    @FXML
    private TextField serieField;

    private Integer nit;
    private Integer id;

    @FXML
    void saveBuy(MouseEvent event) {
        BuyHolder holder = BuyHolder.getInstance();
        dbConection conexion = new dbConection();

        if(this.id == 0){
            this.insertProvider();
        }



    }

    private void cerrarVentana(MouseEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void searchNit(KeyEvent event){
        if(!this.nitFiled.getText().equals("")){
            this.nit=Integer.valueOf(this.nitFiled.getText());
        }else this.nit=0;
        getNit();
    }

    private void insertProvider(){
        dbConection conexion = new dbConection();
        String sentenciaSQL = String.format("INSERT INTO proveedores (Nombre,Nit)" + "values('%S','%S')",
                this.providerField.getText(),Integer.valueOf(this.nitFiled.getText()));
        conexion.ejecutarSenctenciaSQL(sentenciaSQL);
    }



   private void getNit() {
        try {
            System.out.println(this.nit);
            dbConection conexion = new dbConection();
            String sentenciaSQL = String.format("SELECT id,Nombre from Proveedores WHERE nit= '%S'",this.nit);
            ResultSet resultado= conexion.consultarRegistros(sentenciaSQL);
            if(!resultado.next()){
                this.providerField.setText("");
                this.nit=0;
                this.id=0;
            }
            else{
                String provider=resultado.getString("Nombre");
                this.id= Integer.valueOf(resultado.getString("id"));
                this.providerField.setText(provider);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BuyHolder holder = BuyHolder.getInstance();
        this.nit=0;
        this.id=0;
        if (holder.getBuy()!=null){
            System.out.println(ProductHolder.getInstance());
            Buy buy = holder.getBuy();
            this.idField.setText(buy.getId());
            LocalDate date = LocalDate.now();
            this.dateField.setValue(date);
            //this.dateField.set(buy.getDate());
            this.serieField.setText(buy.getSerie());
            this.NoField.setText(buy.getNo());
            this.nitFiled.setText(buy.getNit());
            this.providerField.setText(buy.getName());
            this.mountField.setText(buy.getMount_net());
            this.nit=Integer.valueOf(nitFiled.getText());

        }
    }
}
