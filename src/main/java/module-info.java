module com.francis.recipe {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jdk.jfr;
    requires java.desktop;
    requires java.sql;

    opens com.francis.recipe to javafx.fxml;
    exports com.francis.recipe;
}