package com.example.assigment1.view;

import com.example.assigment1.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory
{
  public static final String START = "start";
  public static final String LIST = "list";

  private final ViewHandler viewHandler;
  private final ViewModelFactory viewModelFactory;
  private StartViewController startViewController;
  private VinylListViewController vinylListViewController;

  public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    this.startViewController = null;
    this.vinylListViewController = null;
  }

  public Region loadStartView(){
    if (startViewController == null) {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("/com/example/assigment1/startView.fxml"));
      try {
        Region root = loader.load();
        startViewController = loader.getController();
        startViewController.init(viewHandler, viewModelFactory.getStartViewModel(), root);
      } catch (IOException e) {
        throw new IOError(e);
      }
    }
    startViewController.reset();
    return startViewController.getRoot();
  }

  public Region loadVinylsListView(){
    if(vinylListViewController == null){
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("/com/example/assigment1/vinylListView.fxml"));
      try {
        Region root = loader.load();
        vinylListViewController = loader.getController();
        vinylListViewController.init(viewHandler, viewModelFactory.getVinylListViewModel(), root);
      } catch (IOException e) {
        throw new IOError(e);
      }
    }
    vinylListViewController.reset();
    return vinylListViewController.getRoot();
  }

  public Region loadView(String id){
    return switch (id) {
      case START -> loadStartView();
      case LIST -> loadVinylsListView();

      default -> throw new IllegalArgumentException("Unknown view: " + id);
    };
  }
}
