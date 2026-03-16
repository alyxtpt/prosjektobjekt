module com.mm {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens com.mm to javafx.fxml;
    exports com.mm;
}
