module com.example.assigment1 {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;

  opens com.example.assigment1.view to javafx.fxml; // Opens the view package to javafx.fxml
  opens com.example.assigment1.model to javafx.fxml, javafx.base, com.example.assigment1.viewmodel; // Opens the model package to javafx.base, javafx.fxml, and viewmodel
  opens com.example.assigment1.viewmodel to javafx.fxml;

  exports com.example.assigment1; // Export the main package
}
