///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Order Queue Tester
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
 * This is a testing class for all of the methods from OrderIterator and OrderQueue classes
 * 
 * @author waizin
 *
 */
public class OrderQueueTester {

  /**
   * Test and make sure OrderIterator methods hasNext (checking for availability of next order) and
   * next(get next order in list) are working as intended
   * 
   * @return true if and only if all test methods succeed; false otherwise
   */
  public static boolean testOrderIterator() {

    // Creating new orders for LinkedOrder
    LinkedOrder noodle = new LinkedOrder(new Order("noodle", 7));
    LinkedOrder friedRice = new LinkedOrder(new Order("fried rice", 10));
    LinkedOrder dumplings = new LinkedOrder(new Order("dumplings", 8));
    LinkedOrder sushi = new LinkedOrder(new Order("sushi", 3));

    // creating a chain of LinkedOrder
    noodle.setNext(friedRice);
    friedRice.setNext(dumplings);
    dumplings.setNext(sushi);

    // initializing OrderIterator with chain of LinkedOrder
    OrderIterator f = new OrderIterator(noodle);

    // checking for 1st order hasNext()
    if (f.hasNext() != true) {
      return false;
    }

    // checking for 1st order next
    String result = "1001: noodle (7)";
    if (!f.next().toString().equals(result)) {
      return false;
    }

    // checking for 2nd order hasNext()
    if (f.hasNext() != true) {
      return false;
    }

    // checking for 2nd order next
    String result2 = "1002: fried rice (10)";
    if (!f.next().toString().equals(result2)) {
      return false;
    }

    // checking for 3rd order hasNext()
    if (f.hasNext() != true) {
      return false;
    }

    // checking for 3rd order next
    String result3 = "1003: dumplings (8)";
    if (!f.next().toString().equals(result3)) {
      return false;
    }

    // checking for 4th order hasNext()
    if (f.hasNext() != true) {
      return false;
    }

    // checking for 4th order next
    String result4 = "1004: sushi (3)";
    if (!f.next().toString().equals(result4)) {
      return false;
    }

    // no more order in the queue
    if (f.hasNext() != false) {
      return false;
    }

    // checking for NoSuchElementException for no order
    try {
      f.next();
      // will return false if exception is not caught
      return false;
    } catch (NoSuchElementException e) {
    }

    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Testing the iterator method of OrderQueue class
   * 
   * @return true if and only if all test are passed; false otherwise
   */
  public static boolean testIterator() {

    // creating new orders for LinkedOrder
    LinkedOrder pepsi = new LinkedOrder(new Order("pepsi", 1));
    LinkedOrder hamburger = new LinkedOrder(new Order("hamburger", 3));
    LinkedOrder hotdog = new LinkedOrder(new Order("hotdog", 2));

    // adding the orders into OrderQueue
    OrderQueue v = new OrderQueue();
    v.enqueue(pepsi.getOrder());
    v.enqueue(hamburger.getOrder());
    v.enqueue(hotdog.getOrder());

    // putting the queue into iterator
    Iterator<Order> i = v.iterator();

    // initializing the counter
    int count = 0;
    // initializing order k
    Order k = null;

    // checking if the queue is empty or not
    while (i.hasNext()) {
      // looping through elements
      k = i.next();
      // checking for 1st element of array to be pepsi
      if (count == 0) {
        // first result
        String result = "1005: pepsi (1)";
        // increment the counter to move to 2nd element
        count++;
        // checking first result and k to be same
        if (!k.toString().equals(result)) {
          return false;
        }
        // checking for 2nd element of array to be hamburger
      } else if (count == 1) {
        // second result
        String result2 = "1006: hamburger (3)";
        // increment the counter to move to 3rd element
        count++;
        // checking second result and k to be same
        if (!k.toString().equals(result2)) {
          return false;
        }
        // checking for last element of array to be hotdog
      } else {
        // final result
        String result3 = "1007: hotdog (2)";
        // checking last result and k to be same
        if (!k.toString().equals(result3)) {
          return false;
        }
      }
    }

    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Testing the Enqueue method of OrderQueue class
   * 
   * @return true if and only if all test are passed; false otherwise
   */
  public static boolean testEnqueue() {
    // creating new orders for LinkedOrder
    LinkedOrder salad = new LinkedOrder(new Order("salad", 2));

    // adding the orders into OrderQueue
    OrderQueue u = new OrderQueue();
    u.enqueue(salad.getOrder());

    // checking for enqueuing when only 1 element
    String result = "1008: salad (2) -> END";
    if (!u.toString().equals(result)) {
      return false;
    }

    // testing for 5 orders

    // creating 5 new orders for LinkedOrder
    LinkedOrder sushi = new LinkedOrder(new Order("sushi", 2));
    LinkedOrder fries = new LinkedOrder(new Order("pepsi", 2));
    LinkedOrder hamburger = new LinkedOrder(new Order("hamburger", 3));
    LinkedOrder hotdog = new LinkedOrder(new Order("hotdog", 2));
    LinkedOrder steak = new LinkedOrder(new Order("steak", 3));

    // adding the orders into OrderQueue
    OrderQueue g = new OrderQueue();
    g.enqueue(sushi.getOrder());
    g.enqueue(fries.getOrder());
    g.enqueue(hamburger.getOrder());
    g.enqueue(hotdog.getOrder());
    g.enqueue(steak.getOrder());

    // checking for enqueuing when only 1 element
    String result2 =
        "1009: sushi (2) -> 1010: pepsi (2) -> 1011: hamburger (3) -> 1012: hotdog (2) -> 1013: steak (3) -> END";
    if (!g.toString().equals(result2)) {
      return false;
    }

    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Testing the Dequeue method of OrderQueue class
   * 
   * @return true if and only if all test are passed; false otherwise
   */
  public static boolean testDequeue() {
    // removing only 1 order

    // creating new orders for LinkedOrder
    LinkedOrder salad = new LinkedOrder(new Order("salad", 2));

    // adding the orders into OrderQueue
    OrderQueue u = new OrderQueue();
    u.enqueue(salad.getOrder());
    u.dequeue();

    // checking if result is same for given
    String result = "";
    if (!u.toString().equals(result)) {
      return false;
    }

    // removing 3 orders

    // creating new orders for LinkedOrder
    LinkedOrder fries = new LinkedOrder(new Order("salad", 2));
    LinkedOrder hotdog = new LinkedOrder(new Order("hotdog", 2));
    LinkedOrder pancake = new LinkedOrder(new Order("pancake", 3));
    LinkedOrder noodle = new LinkedOrder(new Order("salad", 4));

    // adding the orders into OrderQueue
    OrderQueue p = new OrderQueue();
    p.enqueue(fries.getOrder());
    p.enqueue(hotdog.getOrder());
    p.enqueue(pancake.getOrder());
    p.enqueue(noodle.getOrder());
    p.dequeue();
    p.dequeue();
    p.dequeue();

    // checking if after 3 dequeue, the result is the same
    String result2 = "1018: salad (4) -> END";
    if (!p.toString().equals(result2)) {
      return false;
    }

    // removing one last element
    p.dequeue();

    // checking for NoSuchElementException is thrown when dequeue empty list
    try {
      p.dequeue();
      // return false if exception is not caught
      return false;
    } catch (NoSuchElementException e) {
    }

    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Testing the Peek method of OrderQueue class
   * 
   * @return true if and only if all test are passed; false otherwise
   */
  public static boolean testPeek() {
    // checking the front of the queue

    // creating new orders for LinkedOrder
    LinkedOrder noodle = new LinkedOrder(new Order("noodle", 5));

    // adding the orders into OrderQueue
    OrderQueue w = new OrderQueue();
    w.enqueue(noodle.getOrder());

    // checking if peek return the intended result
    String result = "1019: noodle (5)";
    // calling the peek
    Order g = w.peek();
    if (!g.toString().equals(result)) {
      return false;
    }

    // checking for peek method's NoSuchElementException

    // removing the only 1 element
    w.dequeue();

    // checking if NoSuchElementException is thrown
    try {
      w.peek();
      // return false if exception is not caught
      return false;
    } catch (NoSuchElementException e) {
    }

    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Testing the isEmpty method of OrderQueue class
   * 
   * @return true if and only if all test are passed; false otherwise
   */
  public static boolean testIsEmpty() {

    // creating an empty order queue
    OrderQueue nothing = new OrderQueue();

    // checking if queue is empty
    if (!nothing.isEmpty()) {
      return false;
    }

    // creating not an empty order queue
    OrderQueue smt = new OrderQueue();
    LinkedOrder fries = new LinkedOrder(new Order("hotdog", 2));
    LinkedOrder hotdog = new LinkedOrder(new Order("hotdog", 2));
    smt.enqueue(fries.getOrder());
    smt.enqueue(hotdog.getOrder());

    // checking if queue is empty
    if (smt.isEmpty()) {
      return false;
    }

    return true;
  }

  /**
   * Testing all of the test method stated above
   * 
   * @return true if and only if all test methods succeed; false otherwise
   */
  public static boolean runAllTests() {

    // checking if testOrderIterator is working as intended
    if (!testOrderIterator()) {
      return false;
    }

    // checking if testIterator is working as intended
    if (!testIterator()) {
      return false;
    }

    // checking if testEnqueue is working as intended
    if (!testEnqueue()) {
      return false;
    }

    // checking if testDequeue is working as intended
    if (!testDequeue()) {
      return false;
    }

    // checking if testPeek is working as intended
    if (!testPeek()) {
      return false;
    }

    // checking if testEmpty is working as intended
    if (!testIsEmpty()) {
      return false;
    }

    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Make sure all of the methods are running correctly from runAllTests
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("runAllTests: " + runAllTests());
  }

}
