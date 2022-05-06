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
    private String id,name,lastname,user,password,Type;
    Button update;
    Button delete;

    public User(String id, String name, String lastname, String user, String password,String Type, Button update, Button delete) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.user = user;
        this.password = password;
        this.Type = Type;
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


            for (int i = 0; i< dashboardController.table_User.size(); i++){
                if(update.hashCode()== dashboardController.table_User.get(i).getUpdate().hashCode()){

                    User slected=dashboardController.table_User.get(i);
                    UserHolder holder = UserHolder.getInstance();
                    // Step 3
                    holder.setUser(slected);


                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addUser-view.fxml"));

                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage=new Stage();
                        stage.setResizable(false);
                        stage.setTitle("User Management");
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                }
            }


        });

        delete.setOnAction(e->{

            for (int i = 0; i< dashboardController.table_User.size(); i++){
                if(delete.hashCode()== dashboardController.table_User.get(i).getDelete().hashCode()){
                    ProductHolder holder = ProductHolder.getInstance();
                    dbConection conexion = new dbConection();
                    String sentenciaSQL = String.format("DELETE FROM usuario WHERE id = '%S'",
                            Integer.valueOf(dashboardController.table_User.get(i).getId()));
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
