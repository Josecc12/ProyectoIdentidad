package com.proyectoidentidad;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class User{
    private String id,name,lastname,user,password;
    Button update;
    Button delete;

    public User(String id, String name, String lastname, String user, String password, Button update, Button delete) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.user = user;
        this.password = password;
        this.update = update;
        this.delete = delete;

        update.setTextAlignment(TextAlignment.CENTER);
        update.setTextFill(Color.web("ffff"));
        update.setStyle("-fx-background-color: #29CC97; ");
        update.setPadding(new Insets(5));
        update.setMinWidth(95);

        delete.setTextAlignment(TextAlignment.CENTER);
        delete.setTextFill(Color.web("ffff"));
        delete.setStyle("-fx-background-color: #e85555; ");
        delete.setPadding(new Insets(5));
        delete.setMinWidth(65);


        update.setOnAction(e->{


            for (int i = 0; i< dashboardController.table_User.size(); i++){
                if(update.hashCode()== dashboardController.table_User.get(i).getUpdate().hashCode()){
                    System.out.println("id"+ dashboardController.table_User.get(i).getId());
                    System.out.println("Name:"+ dashboardController.table_User.get(i).getName());
                    System.out.println("LastName"+ dashboardController.table_User.get(i).getLastname());
                    System.out.println("User"+ dashboardController.table_User.get(i).getUser());
                    System.out.println("Pasword"+ dashboardController.table_User.get(i).getPassword());
                    System.out.println("");


                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addUser-view.fxml"));
                        productManagmentController controller=fxmlLoader.getController();

                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage=new Stage();
                        stage.setTitle("User Management");
                        stage.setScene(scene);
                        //controller.setPrueba("Hola");
                        stage.show();

                    } catch (IOException ex) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
