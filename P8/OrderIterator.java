///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Order Iterator
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

import java.util.NoSuchElementException;

/**
 * This class contains a constructor for OrderIterator class, hasNext method (check if there are
 * more order in the list), and next method (get the next Order in the list)
 * 
 * @author waizin
 *
 */
public class OrderIterator implements java.util.Iterator<Order> {

  private LinkedOrder current; // the LinkedOrder that it’s currently using

  /**
   * Constructor for OrderIterator class
   * 
   * @param start inputed start order
   */
  public OrderIterator(LinkedOrder start) {
    // initializing the current variable with inputed start
    this.current = start;
  }

  /**
   * Check if there are more order in the list
   * 
   * @return true if and only if the iteration has more orders
   */
  @Override
  public boolean hasNext() {
    // if the current pointer is not null, return true, else false
    if (current != null) {
      return true;
    }
    return false;
  }

  /**
   * Get the next Order in the list
   * 
   * @return the next Order and updates the current field appropriately
   * @throws an NoSuchElementException if the iteration does not have more orders to return
   */
  @Override
  public Order next() {
    // checking the pointer of current to be not null (indicating there is no more order in queue)
    if (!hasNext()) {
      throw new NoSuchElementException("iteration does not have more orders to return");
    }

    // getting the first order (first pointer)
    Order p = current.getOrder();
    // then move to the next order
    current = current.getNext();
    // return the next Order
    return p;
  }

}
