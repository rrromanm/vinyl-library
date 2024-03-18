package com.example.assigment1.view;

import com.example.assigment1.model.LendingState;
import com.example.assigment1.model.Person;
import com.example.assigment1.model.Vinyl;

import com.example.assigment1.viewmodel.VinylListViewModel;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

public class VinylListViewController
{
  @FXML private TableView<Vinyl> vinylTableView;
  @FXML private TableColumn<Vinyl, String> title;
  @FXML private TableColumn<Vinyl, String> artist;
  @FXML private TableColumn<Vinyl, Integer> year;
  @FXML private TableColumn<Vinyl, Person> borrowedBy;
  @FXML private TableColumn<Vinyl, Person> reservedBy;
  @FXML private TableColumn<Vinyl, String> stateColumn;


  @FXML private Button borrow;
  @FXML private Button reserve;
  @FXML private Button returnVinyl;
  @FXML private Button remove;

  private Region root;
  private ViewHandler viewHandler;
  private VinylListViewModel viewModel;
  private ReadOnlyObjectProperty<Vinyl> selected;

  public void init(ViewHandler viewHandler, VinylListViewModel viewModel, Region root){
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;
    
    viewModel.bindVinyls(vinylTableView.itemsProperty());

    this.title.setCellValueFactory(new PropertyValueFactory<>("title"));
    this.artist.setCellValueFactory(new PropertyValueFactory<>("artist"));
    this.year.setCellValueFactory(new PropertyValueFactory<>("year"));
    this.borrowedBy.setCellValueFactory(new PropertyValueFactory<>("borrowedBy"));
    this.reservedBy.setCellValueFactory(new PropertyValueFactory<>("reservedBy"));
    this.stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
    this.selected = vinylTableView.getSelectionModel().selectedItemProperty();

    this.viewModel.bindSelected(selected);
  }
  
  @FXML public void onBorrow(){
    viewModel.borrow();
  }
  @FXML public void onReserve(){
    viewModel.reserve();
  }
  @FXML public void onReturn(){
    viewModel.returnVinyl();
  }
  @FXML public void onRemove(){
    viewModel.remove();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
  }
}
