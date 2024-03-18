package com.example.assigment1.model;

import java.util.List;

public interface LendingState
{
  void borrow(Vinyl vinyl, Person person);
  void reserve(Vinyl vinyl, Person person);
  void returnVinyl(Vinyl vinyl, Person person);
}
