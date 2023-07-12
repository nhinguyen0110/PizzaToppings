/*
------------------------------------------------------------------------------
   Name:     NhiNguyen_IS221_Ch5_PP5_16
   Author:   Nhi Nguyen
   Date:     Mar 1, 2023
   Language: Java
   Purpose:  The purpose of this program is to write a JavaFX application that
             allows the user to pick a set of pizza toppings using a set of
             pizza toppings using a set of check boxes, and displays the cost of
             the pizza.
------------------------------------------------------------------------------
   ChangeLog:
   Who:      Nhi Nguyen            Date:     Mar 1, 2023
   Desc.:    This is the original version of the code.  
------------------------------------------------------------------------------
*/

package nhinguyen_is221_ch5_pp5_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NhiNguyen_IS221_Ch5_PP5_16 extends Application {
    private CheckBox pepperoniCheckBox;
    private CheckBox mushroomsCheckBox;
    private CheckBox onionsCheckBox;
    private CheckBox baconCheckBox;

    private Label totalPriceLabel;

    private final float BASE_PRICE = (float) 10.0;
    private final float TOPPING_PRICE = (float) 0.5;
    
    @Override
    public void start(Stage primaryStage) {
        
        // Create checkboxes for pizza toppings
        pepperoniCheckBox = new CheckBox("Pepperoni ($0.50)");
        mushroomsCheckBox = new CheckBox("Mushrooms ($0.50)");
        onionsCheckBox = new CheckBox("Onions ($0.50)");
        baconCheckBox = new CheckBox("Bacon ($0.50)");
        
        // Create label to display total price
        totalPriceLabel = new Label("Your pizza costs: $" + BASE_PRICE);
        
         // Create HBox to hold checkboxes
        HBox toppingsBox = new HBox(10, pepperoniCheckBox, mushroomsCheckBox, 
                onionsCheckBox, baconCheckBox);
        toppingsBox.setAlignment(Pos.CENTER);
        
        // Create VBox to hold toppings and total price
        VBox vbox = new VBox(20, toppingsBox, totalPriceLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        // Create grid pane to hold the VBox
        GridPane root = new GridPane();
        root.add(vbox, 0, 0);
        root.setAlignment(Pos.CENTER);
        
        // Add event handlers to the checkboxes
        pepperoniCheckBox.setOnAction(event -> updateTotalPrice());
        mushroomsCheckBox.setOnAction(event -> updateTotalPrice());
        onionsCheckBox.setOnAction(event -> updateTotalPrice());
        baconCheckBox.setOnAction(event -> updateTotalPrice());
        
        // Create and show the scene
        Scene scene = new Scene(root, 1000, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        primaryStage.show();
    }
    
    // Update the total price based on the checkboxes
    private void updateTotalPrice() {
        double totalPrice = BASE_PRICE;
        if (pepperoniCheckBox.isSelected()) {
            totalPrice += TOPPING_PRICE;
        }
        if (mushroomsCheckBox.isSelected()) {
            totalPrice += TOPPING_PRICE;
        }
        if (onionsCheckBox.isSelected()) {
            totalPrice += TOPPING_PRICE;
        }
        if (baconCheckBox.isSelected()) {
            totalPrice += TOPPING_PRICE;
        }
        totalPriceLabel.setText(String.format("Your pizza costs: $%.1f", totalPrice));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
