package com.example.assigment1.viewmodel;

import com.example.assigment1.model.Model;

public class ViewModelFactory
{
  private StartViewModel startViewModel;
  private VinylListViewModel vinylListViewModel;
  public ViewModelFactory(Model model){
    this.startViewModel = new StartViewModel(model);
    this.vinylListViewModel = new VinylListViewModel(model);
  }
  public StartViewModel getStartViewModel(){
    return startViewModel;
  }

  public VinylListViewModel getVinylListViewModel()
  {
    return vinylListViewModel;
  }
}
