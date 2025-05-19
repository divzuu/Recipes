package com.francis.recipe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class HelloController {


    @FXML
    void AboutUz() {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/francis/recipe/AboutUs.fxml"));
            Parent root = (Parent) loader.load();
            Stage window = new Stage();
            window.setTitle("About Us");
            window.setScene(new Scene(root));
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Regs() {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/francis/recipe/Register.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void logens() {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/francis/recipe/LogIn.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recipes() {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Login Required");
        alert.setHeaderText("Authentication Required");
        alert.setContentText("You must log in first to access recipes.");
        alert.showAndWait();


    }
}




