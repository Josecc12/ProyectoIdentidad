module com.proyectoidentidad {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.proyectoidentidad to javafx.fxml;
    exports com.proyectoidentidad;
}