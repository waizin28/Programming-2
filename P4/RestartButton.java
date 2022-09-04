///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Restart Button
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
 * This class contains constructor of RestartButton (to draw RestartButton) and mousePressed method
 * (to get rid of carrots and animals from Carrot Patch).
 * 
 * @author waizin
 *
 */
public class RestartButton extends Button {

  /**
   * Constructor for RestartButton class
   * 
   * @param x X position to add restart button
   * @param y Y position to add restart button
   */
  public RestartButton(float x, float y) {
    super("Restart", x, y);
  }

  /**
   * Clear off everything from carrot patch
   */
  @Override
  public void mousePressed() {
    // check if mouse is over the Restart button
    if (isMouseOver()) {
      // remove everything from carrot patch
      Button.processing.removeAll();
      System.out.println("Restart Button pressed.");
    }
  }

}
