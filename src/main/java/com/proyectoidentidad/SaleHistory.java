package com.proyectoidentidad;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;


public class SaleHistory {
    private dbConection conexion;
    private Statement state;
    private String id,usuario,cliente,total,fecha;
    private Button Detalles;
    private Button Eliminar;

    public SaleHistory(String id, String usuario, String cliente, String total, String fecha, Button Detalles, Button Eliminar){
        this.id = id;
        this.usuario = usuario;
        this.cliente = cliente;
        this.total = total;
        this.fecha = fecha;
        this.Detalles = Detalles;
        this.Eliminar = Eliminar;


        Eliminar.setTextAlignment(TextAlignment.CENTER);
        Eliminar.setTextFill(Color.web("ffff"));
        Eliminar.getStylesheets().add(getClass().getResource("dashboard.fxml").toExternalForm());
        Eliminar.getStyleClass().add("delete-button");
        Eliminar.setPadding(new Insets(5));
        Eliminar.setMinWidth(65);

        Detalles.setTextAlignment(TextAlignment.CENTER);
        Detalles.setTextFill(Color.web("ffff"));
        Detalles.getStylesheets().add(getClass().getResource("dashboard.fxml").toExternalForm());
        Detalles.getStyleClass().add("edit-button");
        Detalles.setPadding(new Insets(5));;
        Detalles.setMinWidth(95);

     Detalles.setOnAction(e->{
            for (int i = 0; i< dashboardController.salehistory.size(); i++){
                if(Detalles.hashCode()== dashboardController.salehistory.get(i).getSale_datail().hashCode()){

                    SaleHistory slected=dashboardController.salehistory.get(i);
                    SaleHolder holder = SaleHolder.getInstance();
                    holder.setSale(slected);

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("detailSale.fxml"));


                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage=new Stage();

                        stage.setTitle("Detail Sale");
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                }
            }
        });

        Eliminar.setOnAction(e->{
            for (int i = 0; i< dashboardController.salehistory.size(); i++){
                if(Detalles.hashCode()== dashboardController.salehistory.get(i).getSale_datail().hashCode()){

                    SaleHistory slected=dashboardController.salehistory.get(i);
                    SaleHolder holder = SaleHolder.getInstance();
                    holder.setSale(slected);

                    conexion = new dbConection();
                    FileWriter file=null;
                    PrintWriter writer=null;

                    File document = new File("\\\\DESKTOP-6382TQN\\Users\\Public\\mysqlBitacora");
                    if(!document.isDirectory()){
                        document.mkdir();
                    }
                    try {
                        String path = LocalDate.now().toString()+".txt";
                        file= new FileWriter(new File(document,path),true);
                        writer = new PrintWriter(file);
                    conexion.getConnection().setTransactionIsolation(conexion.getConnection().TRANSACTION_SERIALIZABLE);
                    conexion.getConnection().setAutoCommit(false);
                    state=conexion.getConnection().createStatement();
                    state.execute("START TRANSACTION");
                        writer.println("");
                        writer.println(LocalDate.now().toString());
                        writer.println(LocalTime.now().toString());
                        writer.println("START TRANSACTION");

                    Integer idDelete=Integer.valueOf(holder.getSale().getId());

                    String sentenciaSQL = String.format("DELETE FROM detalle_venta WHERE Venta_id='%S'",idDelete);
                    state.executeUpdate(sentenciaSQL);
                    writer.println("\t"+sentenciaSQL.toUpperCase());
                    sentenciaSQL = String.format("DELETE  FROM venta WHERE id='%S'",idDelete);
                    state.executeUpdate(sentenciaSQL);
                    writer.println("\t"+sentenciaSQL.toUpperCase());
                        state.execute("COMMIT");
                        writer.println("COMMIT");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        try {
                            state.execute("ROLLBACK ");
                            writer.println("COMMIT");
                        } catch (SQLException exc) {
                            exc.printStackTrace();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            conexion.getConnection().close();
                            file.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Button getSale_datail() {
        return Detalles;
    }

    public void setSale_datail(Button sale_datail) {
        this.Detalles = sale_datail;
    }

    public Button getDelete() {
        return Eliminar;
    }

    public void setDelete(Button delete) {
        this.Eliminar = delete;
    }

}
