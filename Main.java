import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

/**
   Joe's Automotive
*/

public class Main extends Application
{
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
      // Named constants
      final double OIL = 35.0;
      final double LUBE = 25.0;
      final double RADIATOR = 50.0;
      final double TRANS = 120.0;
      final double INSPECTION = 35.0;
      final double MUFFLER = 200.0;
      final double TIRE = 20.0;
      final double HOURLY_LABOR = 60.0;

      // Create the Button controls.
      Button oil = new Button("Oil change $35");
      Button lube = new Button("Lube job $25");
      Button radiator = new Button("Radiator flush $50");
      Button trans = new Button("Transmission flush $120");
      Button inspection = new Button("Inspection $35");
      Button muffler = new Button("Muffler replacement $200");
      Button tire = new Button("Tire rotation $20");
      VBox vbox = new VBox(10, oil, lube, radiator, trans,
                               inspection, muffler, tire);
      vbox.setAlignment(Pos.CENTER);

      // Create the controls for parts charges.
      Label partsPrompt = new Label("Parts:");
      TextField partsTextField = new TextField("0.00");
      Button partsButton = new Button("Add Parts Charges");
      HBox partsHBox = new HBox(10, partsPrompt, partsTextField, partsButton);
      partsHBox.setAlignment(Pos.CENTER);

      // Create the controls for labor charges.
      Label laborPrompt = new Label("Hours labor:");
      TextField laborTextField = new TextField("0");
      Button laborButton = new Button("Add Labor Charges");
      HBox laborHBox = new HBox(10, laborPrompt, laborTextField, laborButton);
      laborHBox.setAlignment(Pos.CENTER);

      // Create the total output labels.
      Label totalDescriptor = new Label("Total:");
      Label totalOutputLabel = new Label("0.00");
      HBox totalHBox = new HBox(10, totalDescriptor, totalOutputLabel);
      totalHBox.setAlignment(Pos.CENTER_LEFT);

      // Register the event handlers
      oil.setOnAction(e ->
      {         
         double total = OIL + Double.parseDouble(totalOutputLabel.getText());
         totalOutputLabel.setText(String.format("%,.2f", total));
      });

      lube.setOnAction(e ->
      {         
         double total = LUBE + Double.parseDouble(totalOutputLabel.getText());
         totalOutputLabel.setText(String.format("%,.2f", total));
      });

      radiator.setOnAction(e ->
      {
         double total = RADIATOR + Double.parseDouble(totalOutputLabel.getText());
         totalOutputLabel.setText(String.format("%,.2f", total));
      });

      trans.setOnAction(e ->
      {         
         double total = TRANS + Double.parseDouble(totalOutputLabel.getText());
         totalOutputLabel.setText(String.format("%,.2f", total));
      });

      inspection.setOnAction(e ->
      {         
         double total = INSPECTION + Double.parseDouble(totalOutputLabel.getText());
         totalOutputLabel.setText(String.format("%,.2f", total));
      });

      muffler.setOnAction(e ->
      {         
         double total = MUFFLER + Double.parseDouble(totalOutputLabel.getText());
         totalOutputLabel.setText(String.format("%,.2f", total));
      });

      tire.setOnAction(e ->
      {         
         double total = TIRE + Double.parseDouble(totalOutputLabel.getText());
         totalOutputLabel.setText(String.format("%,.2f", total));
      });

      partsButton.setOnAction(e ->
      {         
         double total = Double.parseDouble(partsTextField.getText()) +
                        Double.parseDouble(totalOutputLabel.getText());
         totalOutputLabel.setText(String.format("%,.2f", total));
      });

      laborButton.setOnAction(e ->
      {         
         double total = (Double.parseDouble(laborTextField.getText()) * HOURLY_LABOR) +
                         Double.parseDouble(totalOutputLabel.getText());
         totalOutputLabel.setText(String.format("%,.2f", total));
      });

      // Put everything into a VBox
      VBox mainVBox = new VBox(10, vbox, partsHBox, laborHBox, totalHBox);
      mainVBox.setAlignment(Pos.CENTER);
      mainVBox.setPadding(new Insets(10));

      // Add the main VBox to a scene.
      Scene scene = new Scene(mainVBox);

      // Set the scene to the stage aand display it.
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}