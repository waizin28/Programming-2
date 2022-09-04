///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Add Rabbit Button
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

/**
 * This class contains constructor of AddRabbitButton (to draw AddRabbitButton) and mousePressed
 * method (to add new rabbit to carrot patch).
 * 
 * @author waizin
 *
 */
public class AddRabbitButton extends Button {

  /**
   * Constructor for AddRabbitButton class
   * 
   * @param x X position to add rabbit button
   * @param y Y position to add rabbit button
   */
  public AddRabbitButton(float x, float y) {
    super("Add Rabbit", x, y);
  }

  /**
   * Add new rabbits to carrot patch when clicked on the add rabbit button
   */
  @Override
  public void mousePressed() {
    // check if mouse is over the Wolf button
    if (isMouseOver()) {
      // add new rabbit to carrot patch
      Button.processing.objects.add(new Rabbit());
      System.out.println("Add Rabbit Button pressed.");
    }
  }
}
