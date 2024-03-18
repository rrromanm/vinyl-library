package com.example.assigment1.viewmodel;

import com.example.assigment1.model.Model;
import com.example.assigment1.model.Person;
import com.example.assigment1.model.Vinyl;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class VinylListViewModel implements PropertyChangeListener
{
  private StringProperty message;
  private final ListProperty<Vinyl> vinyls;
  private SimpleObjectProperty<Vinyl> vinyl;
  private SimpleObjectProperty<Person> person;
  private Model model;

  public VinylListViewModel(Model model)
  {
    this.model = model;
    this.message = new SimpleStringProperty("");
    this.vinyls = new SimpleListProperty<>(FXCollections.observableArrayList(model.getVinyls()));
    this.vinyl = new SimpleObjectProperty<>();
    this.person = new SimpleObjectProperty<>(new Person("User"));
    model.addPropertyChangeListener(this);
  }

  public void borrow()
  {
    try
    {
      if (vinyl.get() != null)
      {
        model.borrow(vinyl.get(), person.get());
      }
    }
    catch (Error e)
    {
      message.set(e.getMessage());
    }
  }

  public void reserve()
  {
    try
    {
      if (vinyl.get() != null)
      {
        model.reserve(vinyl.get(), person.get());
      }
    }
    catch (Error e)
    {
      message.set(e.getMessage());
    }
  }

  public void returnVinyl()
  {
    try
    {
      if (vinyl.get() != null)
      {
        model.returnVinyl(vinyl.get(), person.get());
      }
    }
    catch (Error e)
    {
      message.set(e.getMessage());
    }
  }
  public void remove(){
    try
    {
      if (vinyl.get() != null)
      {
        model.remove(vinyl.get());
      }
    }
    catch (Error e)
    {
      message.set(e.getMessage());
    }
  }

  public void bindVinyls(ObjectProperty<ObservableList<Vinyl>> property)
  {
    property.bind(vinyls);
  }

  public void bindSelected(ReadOnlyObjectProperty<Vinyl> property)
  {
    vinyl.bind(property);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      if (evt.getPropertyName().equals("Vinyls"))
      {
        List<Vinyl> temp = ((List<Vinyl>) evt.getNewValue());
        vinyls.setAll(temp);
      }
    });
  }
}
