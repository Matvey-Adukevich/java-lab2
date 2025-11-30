module org.example.examplejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.examplejavafx to javafx.fxml;
    exports org.example.examplejavafx;
}