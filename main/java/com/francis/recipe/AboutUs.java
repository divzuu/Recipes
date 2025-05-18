package com.francis.recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AboutUs {

    @FXML
    private void AboutUz() {
        try {
            Parent root = FXMLLoader.load(AboutUs.class.getResource("/com/francis/recipe/AboutUs.fxml"));
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("About Us");
            window.setScene(new Scene(root));
            window.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





