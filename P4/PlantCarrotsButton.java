///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Plant Carrots Button
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
 * This class contains constructor of PlantCarrotsButton (to draw PlantCarrotsButton) and
 * mousePressed method (to plant carrots in carrot patch).
 * 
 * @author waizin
 *
 */
public class PlantCarrotsButton extends Button {

  /**
   * Constructor for AddWolfButton class
   * 
   * @param x X position to plant carrots button
   * @param y Y position to plant carrots button
   */
  public PlantCarrotsButton(float x, float y) {
    super("Plant Carrots", x, y);
  }

  /**
   * Plant carrots in carrot patch when clicked on the plant carrots button
   */
  @Override
  public void mousePressed() {
    // check if mouse is over the plant carrots button
    if (isMouseOver()) {
      // plants the carrots
      Carrots.plant();
    }

  }

}
