package com.francis.recipe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void LogIn() {
        welcomeText.setText("");
    }

    @FXML
    private void handleAboutUs() {
        AboutUs.display();
    }
}