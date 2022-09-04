///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Order Queue
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class contains enqueue (adding order from back), dequeue (remove order from front of queue),
 * peek (get the first order), isEmpty (check if queue is empty or not), iterator (getting a new
 * OrderIterator beginning with the current value of front), toString method (returning a String
 * representation of the queue)
 * 
 * @author waizin
 *
 */
public class OrderQueue implements QueueADT<Order>, Iterable<Order> {

  private LinkedOrder front;// a reference to the LinkedOrder at the front of the queue
  private LinkedOrder back;// a reference to the LinkedOrder at the back of the queue
  private int size; // an integer variable tracking the number of Orders currently in the queue

  /**
   * Adds a new LinkedOrder containing newElement to the back of the queue, updating the size
   * variable and front/back references appropriately
   */
  @Override
  public void enqueue(Order newElement) {
    // creating a new LinearOrder
    LinkedOrder node = new LinkedOrder(newElement);
    // checking if order list is empty
    if (isEmpty()) {
      // insert at front position if queue is empty
      node.setNext(null);
      front = node;
      back = front;
    } else {
      // inserting at back: set the new node's next to null, set the original back node's next to
      // the new node, new node take place of back
      node.setNext(null);
      back.setNext(node);
      back = node;
    }
    // increment size after inserting new node into queue
    size++;
  }

  /**
   * Removes the next LinkedOrder from the front of the queue and returns its Order, updating the
   * size variable and front/back references appropriately
   * 
   * @return the order after removing the LinkedOrder at front of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order dequeue() {

    // throw NoSuchElementException if queue empty
    if (isEmpty()) {
      throw new NoSuchElementException("Empty Stack!");
    }

    Order f;
    // only no element in queue
    if (size == 1) {
      // get the order at front queue
      f = front.getOrder();
      // make the first order null to indicate empty queue
      front = null;
      // back point to same front
      back = front;
    } else {
      // when are more than 1 element in the queue
      f = front.getOrder();
      // the front element will be replace by next element in the queue
      front = front.getNext();
    }

    // decrementing size after removing node at front of the queue
    size--;
    // returning the front removed order from queue
    return f;
  }

  /**
   * Returns the Order from the LinkedOrder at the front of the queue without removing the
   * LinkedOrder from the queue
   * 
   * @return the order at front of the queue without removing it
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order peek() {

    // throw NoSuchElementException if queue empty
    if (isEmpty()) {
      throw new NoSuchElementException("Empty Stack Can't Peek!");
    }

    // else just return the order at front of queue
    return front.getOrder();
  }

  /**
   * Returns true if and only if the queue is empty
   * 
   * @return true if the queue is empty, false if not
   */
  @Override
  public boolean isEmpty() {
    // will return true if size is 0 meaning empty list, false if not meaning there are orders in
    // queue
    return size == 0;
  }


  /**
   * Creates and returns a new OrderIterator beginning with the current value of front
   * 
   * @return a new OrderIterator beginning with the current value of front
   */
  @Override
  public Iterator<Order> iterator() {
    // returning the new OrderIterator's front value
    return new OrderIterator(this.front);
  }

  /**
   * Creates and returns a String representation of this OrderQueue using an enhanced-for loop. For
   * example, a queue with three Orders * might look like this: 1001: fries (2) -> 1002: shake (1)
   * -> 1003: burger (3) -> END
   *
   * @return A String representation of the queue
   */
  @Override
  public String toString() {
    // checking if list is empty
    if (this.size == 0)
      // return "" if empty
      return "";

    String qString = "";
    for (Order o : this) {
      // the elements will from the list will be processed until end of the queue
      qString += o.toString();
      qString += " -> ";
    }
    qString += "END";
    return qString;
  }

}
