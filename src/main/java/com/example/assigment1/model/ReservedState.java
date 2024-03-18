package com.example.assigment1.model;

import java.util.List;

public class ReservedState implements LendingState
{
  @Override public void borrow(Vinyl vinyl, Person person)
  {
    if(vinyl.getReservedBy() == person){
      vinyl.setBorrowedBy(person);
      vinyl.setReservedBy(null);
      vinyl.setState(new BorrowedState());
    }
  }

  @Override public void reserve(Vinyl vinyl, Person person)
  {
    //Do nothing because it's already reserved.
  }

  @Override public void returnVinyl(Vinyl vinyl, Person person)
  {
    //Do nothing because no one is borrowing
  }

  @Override public String toString()
  {
    return "Reserved";
  }
}
