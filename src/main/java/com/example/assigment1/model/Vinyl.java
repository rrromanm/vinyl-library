package com.example.assigment1.model;

public class Vinyl
{
  private String title;
  private String artist;
  private int year;
  private LendingState state;
  private Person reservedBy;
  private Person borrowedBy;
  public Vinyl(String title, String artist, int year){
    this.title = title;
    this.artist = artist;
    this.year = year;
    state = new AvailableState();
    reservedBy = null;
    borrowedBy = null;
  }

  public LendingState getState()
  {
    return state;
  }
  public String getStateAsString() {
    return getState().toString(); // Assuming getState() returns an enum representing the state
  }

  public void setState(LendingState state)
  {
    this.state = state;
  }

  public String getTitle()
  {
    return title;
  }

  public String getArtist()
  {
    return artist;
  }

  public int getYear()
  {
    return year;
  }

  public Person getReservedBy()
  {
    return reservedBy;
  }

  public Person getBorrowedBy()
  {
    return borrowedBy;
  }

  public void setReservedBy(Person reservedBy)
  {
    this.reservedBy = reservedBy;
  }

  public void setBorrowedBy(Person borrowedBy)
  {
    this.borrowedBy = borrowedBy;
  }

  public void borrow(Person person){
    state.borrow(this, person);
  }
  public void reserve(Person person){
    state.reserve(this, person);
  }
  public void returnVinyl(Person person){
    state.returnVinyl(this, person);
  }

  @Override public String toString()
  {
    return title + " " + artist + " " + year;
  }
}
