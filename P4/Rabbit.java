///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Rabbit
// Course: CS 300, Spring 2021
//
// Author: Wai Zin Linn
// Email: wlinn@wisc.edu
// Lecturer's Name: Hobbes
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
//
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.io.File;

/**
 * This class contain constructor for Rabbit class (to create a new rabbit object), getScanRange (to
 * get Rabbit.scanRange static field), getHopStep (to get Rabbit.hopStep static field),
 * hopTowardsCarrot (rabbit moving toward carrot and eating it), mousePressed (continuous method
 * call for rabbit to hop), watchOutForWolf method (to look for wolves within scanRange), action
 * method (watches out for a wolf and display a Warning message "WOLF!")
 * 
 * @author waizin
 *
 */
public class Rabbit extends Animal {
  private static final String RABBIT = "images" + File.separator + "rabbit.png";
  private static final String TYPE = "R"; // A String that represents the rabbit type
  private static int hopStep = 70; // one hop step
  private static int scanRange = 175; // scan range to watch out for threats
  private static int nextID = 1; // class variable that represents the identifier
  // of the next rabbit to be created
  private final int ID; // positive number that represents the order of this rabbit

  /**
   * Creates a new rabbit object located at a random position of the display window
   */
  public Rabbit() {
    // Set rabbit drawing parameters
    super(RABBIT);
    // Set rabbit identification fields
    ID = nextID;
    this.label = TYPE + ID; // String that identifies the current rabbit
    nextID++;
  }

  /**
   * Get Rabbit.scanRange static field
   * @return Rabbit.scanRange
   */
  public static int getScanRange() {
    return scanRange;
  }

  /**
   * Get Rabbit.hopStep static field
   * @return Rabbit.hopStep
   */
  public static int getHopStep() {
    return hopStep;
  }
  
  /**
   * Gets the first carrot in the patch. If the carrot is in the Rabbit hopStep range, the rabbit
   * eats it. It sets its position to the (x,y) position of the carrot and the carrot will be
   * removed from the Carrot Patch. Otherwise, the rabbit moves one hopStep towards that carrot. If
   * no carrot found (meaning Carrots.getFirstCarrot() returns false), the rabbit does nothing.
   */
  public void hopTowardsCarrot() {
    // get the first carrot
    int[] carrot = Carrots.getFirstCarrot();
    if (carrot != null) {
      //checking if carrots are close to rabbit
      if (this.isClose(carrot[1], carrot[2], hopStep)) {
        //move toward the carrot position
        this.setX(carrot[1]);
        this.setY(carrot[2]);
        //eat the carrot
        Carrots.remove(carrot[0]);
      } else {
        //calculation to find location of rabbit hop
        int dx = carrot[1] - this.getX();
        int dy = carrot[2] - this.getY();
        int d = (int) Math.sqrt(dx * dx + dy * dy);
        int newX = this.getX() + ((hopStep * dx) / d);
        int newY = this.getY() + ((hopStep * dy) / d);
        //set rabbit's previous location to new location
        this.setX(newX);
        this.setY(newY);
      }
    }

  }
  
  /**
   * Continuous method call for rabbit to hop
   */
  @Override
  public void mousePressed() {
    // TODO
    // call the mousePressed defined in the Animal super class
    super.mousePressed();
    // call hopTowardsCarrot() method
    hopTowardsCarrot();
  }
  
  /**
   * This method watches out for wolves. Checks if there is a wolf in the Rabbit.scanRange of this
   * Rabbit.
   *
   * @return true if the current rabbit is close to at least one wolf
   */
  public boolean watchOutForWolf() {
    // TODO complete the implementation of this method
    // Traverse the processing.objects arraylist checking
    // whether there is a wolf which is close by Rabbit.scanRange
    // of this rabbit.
    for (int i = 0; i < processing.objects.size(); i++) {
      if (processing.objects.get(i) instanceof Wolf) {
        //checking for wolf within scan range
        if (this.isClose((Wolf) processing.objects.get(i), Rabbit.scanRange)) {
          //true if wolves are spotted near rabbit's scan range
          return true;
        }
      }
    }
    //false when not within rabbit's scan range
    return false;
  }
  
  /**
   * Watches out for a wolf and display a Warning message "WOLF!"
   * if there is any wolf in its neighborhood.
   */
  @Override
  public void action() {
    if (watchOutForWolf()) {
     // this.setScaredImage();
     processing.fill(0); // specify font color: black
     processing.text("WOLF!", this.getX(), this.getY() - this.image.height / 2 - 6);
} }
  
}
