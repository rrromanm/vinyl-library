package com.example.assigment1.model;

import java.util.List;

public class AvailableState implements LendingState
{
  @Override public void borrow(Vinyl vinyl, Person person)
  {
    System.out.println("You can't borrow without reservation");
  }

  @Override public void reserve(Vinyl vinyl, Person person)
  {
    vinyl.setReservedBy(person);
    System.out.println(vinyl.getTitle() + " was reserved by " + person.getName());
    vinyl.setState(new ReservedState());
  }

  @Override public void returnVinyl(Vinyl vinyl, Person person)
  {
    // Nothing because it's not borrowed;
  }

  @Override public String toString()
  {
    return "Available";
  }
}
