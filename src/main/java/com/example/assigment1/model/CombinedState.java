package com.example.assigment1.model;

import java.util.List;

public class CombinedState implements LendingState
{

  @Override public void borrow(Vinyl vinyl, Person person)
  {
    System.out.println(vinyl.getTitle() + " it's already borrowed by " + vinyl.getBorrowedBy());
  }

  @Override public void reserve(Vinyl vinyl, Person person)
  {
    System.out.println(vinyl.getTitle() + " it's already reserved by " + vinyl.getReservedBy());
  }

  @Override public void returnVinyl(Vinyl vinyl, Person person)
  {
    if (vinyl.getBorrowedBy() == person){
      vinyl.setBorrowedBy(vinyl.getReservedBy());
      vinyl.setReservedBy(null);
      vinyl.setState(new BorrowedState());
    }
  }

  @Override public String toString()
  {
    return "Combined";
  }
}
