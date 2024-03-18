package com.example.assigment1.model;

import java.util.List;

public class BorrowedState implements LendingState
{

  @Override public void borrow(Vinyl vinyl, Person person)
  {
    System.out.println(vinyl.getTitle() + " can't be borrowed because it's borrowed by " + vinyl.getBorrowedBy());
  }

  @Override public void reserve(Vinyl vinyl, Person person)
  {
    if(vinyl.getBorrowedBy().equals(person)){
    System.out.println(vinyl.getTitle() + " cannot be reserved because it's already borrowed to the person");
    }
    else{
      System.out.println(vinyl.getTitle() + " was reserved by " + person.getName());
      vinyl.setReservedBy(person);
      vinyl.setState(new CombinedState());
    }


  }

  @Override public void returnVinyl(Vinyl vinyl, Person person)
  {
    if(vinyl.getBorrowedBy() == person){
      vinyl.setBorrowedBy(null);
      System.out.println(vinyl.getTitle() + " was returned to the library");
      vinyl.setState(new AvailableState());
    }

  }

  @Override public String toString()
  {
    return "Borrowed";
  }
}
