module worldofzuul.sduworldofzuul {
    requires javafx.controls;
    requires javafx.fxml;


    opens WorldOfZuul to javafx.fxml;
    exports WorldOfZuul;
}