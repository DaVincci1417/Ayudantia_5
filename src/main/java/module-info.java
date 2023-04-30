module com.example.ayudantia5 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ayudantia5 to javafx.fxml;
    exports com.example.ayudantia5;
}