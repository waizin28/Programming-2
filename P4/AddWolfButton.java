///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Add Wolf Button
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
 * This class contains constructor of AddWolfButton (to draw AddWolfButton) and mousePressed method
 * (to add new wolves to carrot patch).
 * 
 * @author waizin
 *
 */
public class AddWolfButton extends Button {

  /**
   * Constructor for AddWolfButton class
   * 
   * @param x X position to add wolf button
   * @param y Y position to add Wolf button
   */
  public AddWolfButton(float x, float y) {
    super("Add Wolf", x, y);
  }

  /**
   * Add new wolves to carrot patch when clicked on the add wolf button
   */
  @Override
  public void mousePressed() {
    // check if mouse is over the Wolf button
    if (isMouseOver()) {
      // add new wolf to carrot patch
      Button.processing.objects.add(new Wolf());
      System.out.println("Add Wolf Button pressed.");
    }
  }

}
