<h1 align='center'>Assigmment 1, SDJ2 <br> (MVVM, Observer, State, Threads) </h1>
<h3>The system:</h3>
<p>
You must design and implement a simple application for a Vinyl lending library. A Vinyl has at least a title, artist, year, and a lending state. The Vinyl can be in different states depending on availability, reservation, borrowing or a combined borrowing and reservation.

You can borrow a Vinyl either if it is not reserved by someone else or are already borrowed or if it is reserved by you (reserved). You cannot reserve a Vinyl if it already contains a reservation (there is no reservation list, only one person at the time can reserve the Vinyl). However, you are allowed to reserve a Vinyl if it is available (no reservation and not borrowed) or if it is borrowed and do not have another reservation.

A Vinyl can be removed from the library if it has no reservation and are not borrowed (available). If the Vinyl is borrowed, reserved or both, then the removing sets a flag such that the Vinyl cannot be reserved any longer. The Vinyl is not fully removed until it has been returned and do not have a reservation (the person who may have reserved the Vinyl will still be able to borrow it, before it is finally removed)
</p>

<h3>The assignment:</h3>
<p>
o From a GUI with at least two windows: <br>
  - Show a list of Vinyls including their states. (To make it simple, you can assume that there are no more than 10 Vinyls.) <br>
  - Select one Vinyl and Reserve, Borrow or Return it. When reserving, also show to whom. <br>
  - Remove a Vinyl (mark it to be removed until its state allows it to be fully removed). Make sure that this is reflected in the GUI as soon as it has been removed from the model. <br>
  - Optionally, you can include the information that a Vinyl is about to be removed (before it is fully removed) <br>
  - Optionally, you can have a window to add a new Vinyl, but hard-coded values are also ok. <br>
o From two threads you simulate “Bob” and “Wendy” reserving, borrowing and returning a Vinyl (in the model). <br>
  - You can randomly choose the methods in a loop, with proper thread sleeping time. <br>
  - Make sure that the GUI updates automatically, to reflect the changed states for the Vinyl. <br>
</p>

<h3>Requirements: </h3>
<p>
- You must use MVVM with at least two windows. Further, you must use shared ViewState objects to access the selected Vinyl in another view than the view where it has been selected (do not give one ViewController or ViewModel direct access to another VierController/ViewModel). <br>
- You must use the Observer design pattern as part of the solution. <br>
- You must use the State design pattern for the different states of a Vinyl. It is required to make a state machine diagram for the Vinyl (in Astah). <br>
- It is required to make a class diagram for the full solution (in Astah). In the diagram you must be able clearly to identify the different MVVM parts, the Observer pattern, the State pattern and the classes related to the threads. <br>
- You must use threads for the simulation and still be able to manually use the system (in the GUI) <br>
</p>

