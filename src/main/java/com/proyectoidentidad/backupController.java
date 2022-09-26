package com.proyectoidentidad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class backupController implements Initializable{

    @FXML
    private Button btn_buscar;

    @FXML
    private Button btn_cancelar;

    @FXML
    private Button btn_guardar;

    @FXML
    private Label label_ubicacion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void saveBackup(ActionEvent event) {
        File file = new File("mysqlBackup");
        if (!file.isDirectory()) {
            file.mkdir();
        }
        File f = new File(file, LocalDate.now().toString()+".sql");
        String path = f.getPath();
        System.out.println(f.getAbsolutePath());
        System.out.println("sss");
        String username = "root";
        String password = "admin";
        String dbname = "identidad";
        String ruta = "";
        String executeCmd = "C:/Program Files/MySQL/MySQL Server 8.0/bin/mysqldump.exe -u" + username + " -p" + password
                + " --add-drop-database -B " + dbname + " -r " + path;
        Process runtimeProcess;
        try {
//            System.out.println(executeCmd);//this out put works in mysql shell
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            System.out.println(executeCmd);
//            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            System.out.println("processComplete" + processComplete);
            if (processComplete == 0) {
                System.out.println("Backup created successfully");

            } else {
                System.out.println("Could not create the backup");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}












