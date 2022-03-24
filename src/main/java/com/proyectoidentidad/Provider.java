package com.proyectoidentidad;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;


public class Provider {
    private String id,nit,name,phone,address;
    private Button update;
    private Button delete;


    public Provider(String id, String nit, String name, String phone, String address,Button update,Button delete) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.update = update;
        this.delete=delete;


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

            for(int i = 0; i< dashboardController.Provider_Table.size(); i++){
                if(update.hashCode() == dashboardController.Provider_Table.get(i).getUpdate().hashCode()){
                    System.out.println("id" + dashboardController.Provider_Table.get(i).getId());
                    System.out.println("nit" + dashboardController.Provider_Table.get(i).getNit());
                    System.out.println("name" + dashboardController.Provider_Table.get(i).getName());
                    System.out.println("phone" + dashboardController.Provider_Table.get(i).getPhone());
                    System.out.println("address" + dashboardController.Provider_Table.get(i).getAddress());

                    Provider selected = dashboardController.Provider_Table.get(i);
                    ProviderHolder holder = ProviderHolder.getInstance();

                    holder.setProvider(selected);

                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addProvider-view.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            Stage stage = new Stage();
                            stage.setTitle("Provider Management");
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex){
                            ex.printStackTrace();
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit){
        this.nit = nit;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return  phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
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
