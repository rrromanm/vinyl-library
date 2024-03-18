package com.example.assigment1.model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public interface Model
{
  void borrow(Vinyl vinyl, Person person);
  void reserve(Vinyl vinyl, Person person);
  void returnVinyl(Vinyl vinyl, Person person);
  List<Vinyl> getVinyls();
  void remove(Vinyl vinyl);
  void addPropertyChangeListener(PropertyChangeListener listener);
  void removePropertyChangeListener(PropertyChangeListener listener);
}
