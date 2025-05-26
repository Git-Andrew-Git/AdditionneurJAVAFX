module fr.andrew.additioneurjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.andrew.additioneurjavafx to javafx.fxml;
    exports fr.andrew.additioneurjavafx;
}