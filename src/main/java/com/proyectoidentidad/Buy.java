package com.proyectoidentidad;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class Buy {

    private String id,date,serie,no,nit,name,mount_net,mount_gross,mount_IVA;
    private Button update;
    private Button delete;

    public Buy(String id, String date, String serie, String no, String nit,
               String name, String mount_net, String mount_gross, String mount_IVA,
               Button update, Button delete) {
        this.id = id;
        this.date = date;
        this.serie = serie;
        this.no = no;
        this.nit = nit;
        this.name = name;
        this.mount_net = mount_net;
        this.mount_gross = mount_gross;
        this.mount_IVA = mount_IVA;
        this.update = update;
        this.delete = delete;

        update.setTextAlignment(TextAlignment.CENTER);
        update.setTextFill(Color.web("ffff"));
        update.getStylesheets().add(getClass().getResource("dashboard.fxml").toExternalForm());
        update.getStyleClass().add("edit-button");
        update.setPadding(new Insets(5));;
        update.setMinWidth(95);



        delete.setTextAlignment(TextAlignment.CENTER);
        delete.setTextFill(Color.web("ffff"));
        delete.getStylesheets().add(getClass().getResource("dashboard.fxml").toExternalForm());
        delete.getStyleClass().add("delete-button");
        delete.setPadding(new Insets(5));
        delete.setMinWidth(65);

        update.setOnAction(e->{

            for (int i = 0; i< dashboardController.table_Buys.size(); i++){
                if(update.hashCode()== dashboardController.table_Buys.get(i).getUpdate().hashCode()){
                    System.out.println("id"+ dashboardController.table_Buys.get(i).getId());
                    System.out.println("code"+ dashboardController.table_Buys.get(i).getDate());
                    System.out.println("stock"+ dashboardController.table_Buys.get(i).getName());
                    System.out.println("production"+ dashboardController.table_Buys.get(i).getMount_IVA());
                    System.out.println("");

                    Buy slected=dashboardController.table_Buys.get(i);
                    BuyHolder holder = BuyHolder.getInstance();
                    // Step 3
                    holder.setBuy(slected);



                    try {


                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addBuy-view.fxml"));
                        productManagmentController controller=fxmlLoader.getController();
                        //controller.setPrueba("Hola");admin


                        fxmlLoader.setController(controller);
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage=new Stage();
                        //fxmlLoader.getController().
                        stage.setTitle("Buy Management");
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        delete.setOnAction(e->{

            for (int i = 0; i< dashboardController.table_Buys.size(); i++){
                if(delete.hashCode()== dashboardController.table_Buys.get(i).getDelete().hashCode()){
                    System.out.println("Delete");
                    System.out.println(dashboardController.table_Buys.get(i).getId());
                    ProductHolder holder = ProductHolder.getInstance();
                    dbConection conexion = new dbConection();
                    String sentenciaSQL = String.format("DELETE FROM compra WHERE id = '%S'",
                            Integer.valueOf(dashboardController.table_Buys.get(i).getId()));
                    conexion.ejecutarSenctenciaSQL(sentenciaSQL);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMount_net() {
        return mount_net;
    }

    public void setMount_net(String mount_net) {
        this.mount_net = mount_net;
    }

    public String getMount_gross() {
        return mount_gross;
    }

    public void setMount_gross(String mount_gross) {
        this.mount_gross = mount_gross;
    }

    public String getMount_IVA() {
        return mount_IVA;
    }

    public void setMount_IVA(String mount_IVA) {
        this.mount_IVA = mount_IVA;
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
