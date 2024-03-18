package com.example.assigment1.view;

import com.example.assigment1.viewmodel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
  private final Scene currentScene;
  private Stage primaryStage;
  private final ViewFactory viewFactory;
  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewFactory = new ViewFactory(this, viewModelFactory);
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    openView(ViewFactory.START);
  }
  public void openView(String id) {
    Region root = viewFactory.loadView(id);
    currentScene.setRoot(root);
    if (root.getUserData() == null) {
      primaryStage.setTitle("");
    } else {
      primaryStage.setTitle(root.getUserData().toString());
    }
    primaryStage.setScene(currentScene);
    primaryStage.sizeToScene();
    primaryStage.show();
  }
  public void closeView() {
    primaryStage.close();
  }

}
