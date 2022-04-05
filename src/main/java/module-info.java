module gumkaci.regexapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens gumkaci.regexapp to javafx.fxml;
    exports gumkaci.regexapp;
}