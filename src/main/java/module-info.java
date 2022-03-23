module com.proyectoidentidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.proyectoidentidad to javafx.fxml;
    exports com.proyectoidentidad;
}