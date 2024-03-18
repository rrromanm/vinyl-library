package com.example.assigment1.view;

import com.example.assigment1.viewmodel.StartViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class StartViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private StartViewModel viewModel;

  public void init(ViewHandler viewHandler, StartViewModel viewModel, Region root) {
    this.root = root;
    this.viewHandler = viewHandler;
    this.viewModel =viewModel;

  }

  @FXML public void onSTART(){
    viewModel.start();
    viewHandler.openView(ViewFactory.LIST);
  }
  public void reset() {
  }

  public Region getRoot() {
    return root;
  }
}
