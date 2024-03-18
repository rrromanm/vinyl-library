package com.example.assigment1.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ModelManager implements Model
{
  private List<Vinyl> vinyls;
  private final PropertyChangeSupport support;

  public ModelManager()
  {
    this.vinyls = new ArrayList<>();
    vinyls.add(new Vinyl("Thriller", "Michael Jackson", 1982));
    vinyls.add(new Vinyl("The Dark Side of the Moon", "Pink Floyd", 1973));
    vinyls.add(new Vinyl("Abbey Road", "The Beatles", 1969));
    vinyls.add(new Vinyl("Hotel California", "Eagles", 1976));
    vinyls.add(new Vinyl("Back in Black", "AC/DC", 1980));
    vinyls.add(new Vinyl("Rumours", "Fleetwood Mac", 1977));
    vinyls.add(new Vinyl("Led Zeppelin IV", "Led Zeppelin", 1971));
    vinyls.add(new Vinyl("The Wall", "Pink Floyd", 1979));
    vinyls.add(new Vinyl("Born to Run", "Bruce Springsteen", 1975));
    vinyls.add(new Vinyl("A Night at the Opera", "Queen", 1975));
    this.support = new PropertyChangeSupport(vinyls);
  }

  public List<Vinyl> getVinyls()
  {
    return vinyls;
  }

  @Override public synchronized  void borrow(Vinyl vinyl, Person person)
  {
    try {
      vinyl.borrow(person);
      support.firePropertyChange("Vinyls", null, vinyls);
    } catch (Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public synchronized  void reserve(Vinyl vinyl, Person person)
  {
    try {
      vinyl.reserve(person);
      support.firePropertyChange("Vinyls", null, vinyls);
    } catch (Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public synchronized  void returnVinyl(Vinyl vinyl, Person person)
  {
    try {
      vinyl.returnVinyl(person);
      support.firePropertyChange("Vinyls", null, vinyls);
    } catch (Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public synchronized  void remove(Vinyl vinyl)
  {
    try {
      if(vinyl.getState() instanceof AvailableState){
        vinyls.remove(vinyl);
      }
      support.firePropertyChange("Vinyls", null, vinyls);
    } catch (Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
