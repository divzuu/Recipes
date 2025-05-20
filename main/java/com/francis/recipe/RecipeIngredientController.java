package com.francis.recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RecipeIngredientController implements Initializable {

    @FXML
    private FlowPane pantryFlowPane;

    @FXML
    private FlowPane meatFlowPane;

    @FXML
    private FlowPane pastaFlowPane;

    @FXML
    private ListView<String> selectedIngredientsListView;

    @FXML
    private Button addToRecipeButton;

    @FXML
    private Button backButton;

    private final ObservableList<String> selectedIngredients = FXCollections.observableArrayList();
    private final List<ToggleButton> allIngredientButtons = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setup the ListView to display selected ingredients
        selectedIngredientsListView.setItems(selectedIngredients);

        // Convert all buttons to ToggleButtons in your FXML or create them dynamically
        setupIngredientButtons();
    }

    private void setupIngredientButtons() {
        // Here you need to get all your ingredient buttons
        // For each flowpane, you can do:
        for (javafx.scene.Node node : pantryFlowPane.getChildren()) {
            if (node instanceof ToggleButton) {
                setupIngredientToggleButton((ToggleButton) node);
            }
        }

        for (javafx.scene.Node node : meatFlowPane.getChildren()) {
            if (node instanceof ToggleButton) {
                setupIngredientToggleButton((ToggleButton) node);
            }
        }

        for (javafx.scene.Node node : pastaFlowPane.getChildren()) {
            if (node instanceof ToggleButton) {
                setupIngredientToggleButton((ToggleButton) node);
            }
        }
    }

    private void setupIngredientToggleButton(ToggleButton button) {
        allIngredientButtons.add(button);

        // Set styling for selected state
        button.getStyleClass().add("ingredient-toggle-button");

        // Add listener for selection changes
        button.setOnAction(event -> {
            String ingredient = button.getText();
            if (button.isSelected()) {
                // Add to selected ingredients if not already there
                if (!selectedIngredients.contains(ingredient)) {
                    selectedIngredients.add(ingredient);
                    button.setStyle("-fx-background-color: #a0d6b4; -fx-border-color: #2e8b57;");
                }
            } else {
                // Remove from selected ingredients
                selectedIngredients.remove(ingredient);
                button.setStyle("");
            }
        });
    }

    @FXML
    private void handleAddToRecipe(ActionEvent event) {
        // Here you would save the selected ingredients to your recipe
        // This could involve passing data back to a parent controller
        // or saving to a database

        // Example of getting all selected ingredients
        System.out.println("Selected ingredients: " + selectedIngredients);

        // You might want to show a confirmation
        showConfirmation("Ingredients Added",
                selectedIngredients.size() + " ingredients added to your recipe!");

        // Optionally clear selections after adding
        clearSelections();
    }

    @FXML
    private void handleBack(ActionEvent event) {
        // Close this window and return to previous screen
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    private void showConfirmation(String title, String message) {
        // Show a confirmation dialog or label
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearSelections() {
        // Clear all selections
        selectedIngredients.clear();

        // Reset all toggle buttons
        for (ToggleButton button : allIngredientButtons) {
            button.setSelected(false);
            button.setStyle("");
        }
    }

    // Method to remove a single ingredient from selection
    @FXML
    private void handleRemoveIngredient(ActionEvent event) {
        String selected = selectedIngredientsListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selectedIngredients.remove(selected);

            // Also update the button state
            for (ToggleButton button : allIngredientButtons) {
                if (button.getText().equals(selected)) {
                    button.setSelected(false);
                    button.setStyle("");
                    break;
                }
            }
        }
    }
}
