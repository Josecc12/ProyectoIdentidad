package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BuyManagmentController implements Initializable {
    private Statement state;
    private dbConection conexion;

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

    private String nit;
    private Integer id;
    private boolean providerExist;

    // Formato de fechas
    public static Date fechaObjeto;
    public static SimpleDateFormat formatoFecha_MDA;
    public static SimpleDateFormat formatoFecha_AMD;
    public static String Fecha_AMD = "yyyy-MM-dd";
    public static String Fecha_MDA = "MM/dd/yyyy";

    @FXML
    void saveBuy(MouseEvent event) throws ParseException {
        formatoFecha_MDA =  new SimpleDateFormat(Fecha_MDA);
        formatoFecha_AMD = new SimpleDateFormat(Fecha_AMD);

        BuyHolder holder = BuyHolder.getInstance();
        conexion = new dbConection();


        if(!this.providerExist){
            this.insertProvider();
        }
        this.nit=String.valueOf(this.nitFiled.getText());
        getNit();
        String fecha = cambiarFormatoFecha(this.dateField.getValue().toString());

        FileWriter file=null;
        PrintWriter writer=null;
        if(holder.getBuy() == null){

            try {
                file=new FileWriter("Bitacora"+LocalDate.now().toString()+".txt",true);
                writer = new PrintWriter(file);
                conexion.getConnection().setTransactionIsolation(conexion.getConnection().TRANSACTION_SERIALIZABLE);
                conexion.getConnection().setAutoCommit(false);
                state=conexion.getConnection().createStatement();
                state.execute("START TRANSACTION");
                state.execute("BEGIN");
                writer.println("");
                writer.println(LocalDate.now().toString());
                writer.println(LocalTime.now().toString());
                writer.println("START TRANSACTION");
            double mountNet=Integer.valueOf(this.mountField.getText());
            double moungGross=mountNet/1.12;
            double iva=moungGross*0.12;

            String sentenciaSQL = String.format("insert into Compra (Proveedores_id,Total_Neto,Total_Bruto,IVA,Serie,Factura,Usuario_id,Fecha)"
                            + "values('%S','%S','%S','%S','%S','%S','%S','%S')",
                    this.id,
                    mountNet,
                    moungGross,
                    iva,
                    this.serieField.getText(),
                    this.NoField.getText(),
                    LoginScreen.user_id,
                    fecha);
            state.executeUpdate(sentenciaSQL);
            writer.println("\t"+sentenciaSQL.toUpperCase());
            state.execute("COMMIT");
            writer.println("COMMIT");
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    state.execute("ROLLBACK");
                    writer.println("ROLLBACK");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.getConnection().close();
                    file.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }else{
            double mountNet=Double.valueOf(this.mountField.getText());;
            double moungGross=mountNet/1.12;
            double iva=moungGross*0.12;

            try {
                file=new FileWriter("Bitacora"+LocalDate.now().toString()+".txt",true);
                writer = new PrintWriter(file);
                conexion.getConnection().setTransactionIsolation(conexion.getConnection().TRANSACTION_SERIALIZABLE);

            conexion.getConnection().setAutoCommit(false);
            state=conexion.getConnection().createStatement();
            state.execute("START TRANSACTION");
            writer.println("");
            writer.println(LocalDate.now().toString());
            writer.println(LocalTime.now().toString());
            writer.println("START TRANSACTION");
            state.execute("BEGIN");
            String sentenciaSQL = String.format("update Compra set Proveedores_id = '%S', Total_Neto='%S',Total_Bruto ='%S',IVA='%S', Serie = '%S',Factura = '%S', Usuario_id = '%S',Fecha = '%S' where id = '%S'",
                    Integer.valueOf(this.id),
                    mountNet,
                    moungGross,
                    iva,
                    Integer.valueOf(this.serieField.getText()),
                    Integer.valueOf(this.NoField.getText()),
                    LoginScreen.user_id,
                    fecha,
                    Integer.valueOf(this.idField.getText()));
            state.executeUpdate(sentenciaSQL);
            writer.println("\t"+sentenciaSQL.toUpperCase());
            state.execute("COMMIT");
            writer.println("COMMIT");
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    state.execute("ROLLBACK ");
                    writer.println("ROLLBACK");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.getConnection().close();
                    file.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        this.cerrarVentana(event);

    }

    private void cerrarVentana(MouseEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void searchNit(KeyEvent event){
        if(!this.nitFiled.getText().equals("")){
            this.nit=String.valueOf(this.nitFiled.getText());
        }else this.nit="0";
        getNit();
    }

    private void insertProvider(){
        dbConection conexion = new dbConection();
        String sentenciaSQL = String.format("INSERT INTO proveedores (Nombre,Nit)" + "values('%S','%S')",
                this.providerField.getText(),String.valueOf(this.nitFiled.getText()));
        conexion.ejecutarSenctenciaSQL(sentenciaSQL);
    }

    public static String cambiarFormatoFecha(String fecha){
        try {
            fechaObjeto = new Date();
            fechaObjeto = formatoFecha_MDA.parse(fecha);
            fecha = formatoFecha_AMD.format(fechaObjeto);

        } catch (ParseException e) {
        }
        return fecha;
    }

   private void getNit() {
        try {
            dbConection conexion = new dbConection();
            String sentenciaSQL = String.format("SELECT id,Nombre from Proveedores WHERE nit= '%S'",this.nit);
            ResultSet resultado= conexion.consultarRegistros(sentenciaSQL);
            if(!resultado.next()){
                this.providerField.setText("");
                this.nit="";
                this.id=0;
                this.providerExist=false;
            }
            else{
                String provider=resultado.getString("Nombre");
                this.id= Integer.valueOf(resultado.getString("id"));
                this.providerField.setText(provider);
                this.providerExist=true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BuyHolder holder = BuyHolder.getInstance();
        this.nit="";
        this.id=0;
        this.providerExist=false;
        if (holder.getBuy()!=null){
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
            this.nit=String.valueOf(nitFiled.getText());

        }
    }
}
