module com.example.firstlevel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.firstlevel to javafx.fxml;
    exports com.example.firstlevel;
}