package com.example.assigment1;

import com.example.assigment1.model.Model;
import com.example.assigment1.model.ModelManager;
import com.example.assigment1.model.Person;
import com.example.assigment1.model.Vinyl;
import com.example.assigment1.view.ViewHandler;
import com.example.assigment1.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application
{
  @Override
  public void start(Stage stage) throws IOException
  {
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start(stage);

    Thread bobThread = new Thread(() -> performBobActions(model));
    Thread wendyThread = new Thread(() -> performWendyActions(model));

    // Start the threads
    bobThread.start();
    wendyThread.start();
  }

  private void performBobActions(Model model) {
    try {
      Person bob = new Person("Bob");
      Vinyl vinylToUse = model.getVinyls().get(0);
      Thread.sleep(3000);
      // Bob reserves a vinyl
      model.reserve(vinylToUse, bob);
      Thread.sleep(7000); // Bob waits for 2 seconds
      // Bob borrows the reserved vinyl
      model.borrow(vinylToUse, bob);
      Thread.sleep(2000); // Bob waits for 2 seconds
      // Add a delay after borrowing the vinyl
      Thread.sleep(4000); // Bob waits for 2 seconds
      // Bob returns the borrowed vinyl
      model.returnVinyl(vinylToUse, bob);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void performWendyActions(Model model) {
    try {
      Person wendy = new Person("Wendy");
      Vinyl vinylToUse = model.getVinyls().get(3);
      Thread.sleep(1500); // Wendy waits for 2 seconds
      // Wendy reserves the same vinyl
      model.reserve(vinylToUse, wendy);
      Thread.sleep(3500); // Wendy waits for 2 seconds
      // Wendy borrows the reserved vinyl
      model.borrow(vinylToUse, wendy);
      Thread.sleep(2000); // Wendy waits for 2 seconds
      // Wendy returns the borrowed vinyl
      Thread.sleep(5000);
      model.returnVinyl(vinylToUse, wendy);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
