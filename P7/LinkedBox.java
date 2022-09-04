///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Linked Box
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
// None
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

/**
 * This class models a linked box node which can be used to create a singly linked list of boxes.
 * Contains LinkedBox constructors, getNext (get next linked box node), setNext (setting next linked
 * box node), getBox (get this box) and toString methods (return string representation of this
 * Linked box)
 * 
 * @author waizin
 *
 */
public class LinkedBox {
  private Box box; // represents the data carried by this linked box node
  private LinkedBox next; // represents the link to the next linkedBox

  /**
   * Creates a new LinkedBox node with given box and next fields
   * 
   * @param box  the box carried by this linked box
   * @param next reference to the next linked box in the list
   */
  public LinkedBox(Box box, LinkedBox next) {
    this.box = box;
    this.next = next;
  }

  /**
   * Creates a new LinkedBox with a specified box and null as next field
   * 
   * @param box the box carried by this linked box
   */
  public LinkedBox(Box box) {
    this.box = box;
    this.next = null;
  }

  /**
   * Get the next linked box node
   * 
   * @return the next linked box node
   */
  public LinkedBox getNext() {
    return this.next;
  }

  /**
   * Set the next linked box
   * 
   * @param next the next linked box to set
   */
  public void setNext(LinkedBox next) {
    this.next = next;
  }

  /**
   * Returns the data field box
   * 
   * @return data field box
   */
  public Box getBox() {
    return this.box;
  }

  /**
   * Returns a String representation of this Linked box
   */
  @Override
  public String toString() {
    String color = "";
    // if next field is not null
    // box.toString() + "-> "
    if (getNext() != null) {
      color += this.box.getColor() + " " + this.box.getInventoryNumber() + " -> ";
    } else {
      // if next field is null
      // box.toString() + "-> END"
      color += this.box.getColor() + " " + this.box.getInventoryNumber() + " -> END";
    }
    return color;
  }
}
