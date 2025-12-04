open module org.example.cpu {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    requires org.hibernate.orm.core;

    requires jakarta.persistence;
    requires jakarta.transaction;
    requires jakarta.validation;
    requires jakarta.annotation;
    requires jakarta.inject;
    requires jakarta.interceptor;

    requires org.xerial.sqlitejdbc;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    exports org.example;
    exports org.example.cpu;
}