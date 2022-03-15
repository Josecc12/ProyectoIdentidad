package com.proyectoidentidad;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

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
