module worldofzuul.sduworldofzuul {
    requires javafx.controls;
    requires javafx.fxml;


    opens worldofzuul.sduworldofzuul to javafx.fxml;
    exports worldofzuul.sduworldofzuul;
}