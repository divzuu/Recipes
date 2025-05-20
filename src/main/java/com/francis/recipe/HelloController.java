package com.francis.recipe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Constants.constants.*;



public class HelloController {

    public void Connection () throws Exception {
        try {
            Class.forName(DbDriver);
            Connection con = DriverManager.getConnection(DbUrl, accountName, accountPassword);
            Statement st = con.createStatement();
            System.out.println("Connection Successful.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void aboutUsDisplays() throws IOException {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/francis/recipe/AboutUs.fxml"));
            Parent root = loader.load();
            Stage window = new Stage();
            window.setTitle("About Us");
            window.setScene(new Scene(root));
            window.show();

    }

    @FXML
    private void registerDiplays() throws IOException {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/francis/recipe/Register.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(new Scene(root));
            stage.show();

    }


    @FXML
    private void loginDisplays() throws IOException {

            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/francis/recipe/LogIn.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Log In");
            stage.setScene(new Scene(root));
            stage.show();

            loginButtons();
    }

    private void registerOnLoginButton () {

    }

    private void showAlert () {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Login Required");
        alert.setHeaderText("Authentication Required");
        alert.setContentText("You must log in first to access recipes.");
        alert.showAndWait();

    }

    @FXML
    private void recipeDisplays() {
        showAlert();
    }
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmPasswordTextField;
    @FXML
    private CheckBox maleTextField;
    @FXML
    private CheckBox femaleTextField;
    @FXML
    private TextField monthTextField;
    @FXML
    private TextField dayTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private Label loginMessageLabel;



    private void loginButtons() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();



       }
    }





