package com.proyectoidentidad;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class Client {
    private String id, name, address, phone_number, nit;
    Button update;
    Button delete;

    public Client(String id, String nit, String name, String phone_number, String address, Button update, Button delete) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
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


            for (int i = 0; i< dashboardController.table_client.size(); i++){
                if(update.hashCode()== dashboardController.table_client.get(i).getUpdate().hashCode()){
                    System.out.println("id"+ dashboardController.table_client.get(i).getId());
                    System.out.println("NIT"+ dashboardController.table_client.get(i).getNit());
                    System.out.println("Name:"+ dashboardController.table_client.get(i).getName());
                    System.out.println("Phone Number"+ dashboardController.table_client.get(i).getPhone_number());
                    System.out.println("Address"+ dashboardController.table_client.get(i).getAddress());
                    System.out.println("");

                    Client selected=dashboardController.table_client.get(i);
                    ClientHolder holder = ClientHolder.getInstance();
                    // Step 3
                    holder.setClient(selected);


                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addClient-view.fxml"));
                        ClientManagmentController controller = fxmlLoader.getController();
                        fxmlLoader.setController(controller);
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage=new Stage();
                        stage.setTitle("Client Management");
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                }
            }
        });

        delete.setOnAction(e->{

            for (int i = 0; i< dashboardController.table_client.size(); i++){
                if(delete.hashCode()== dashboardController.table_client.get(i).getDelete().hashCode()){
                    System.out.println("Delete");
                    System.out.println(dashboardController.table_client.get(i).getId());
                    ProductHolder holder = ProductHolder.getInstance();
                    dbConection conexion = new dbConection();
                    String sentenciaSQL = String.format("DELETE FROM clientes WHERE id = '%S'",
                            Integer.valueOf(dashboardController.table_client.get(i).getId()));
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

    public String getNit() { return nit; }

    public void setNit(String nit) { this.nit = nit; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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