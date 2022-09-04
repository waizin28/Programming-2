///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Order Priority Queue Tester
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
 * This class checks the correctness of the implementation of the methods defined in the class
 * OrderPriorityQueue.
 * 
 * You MAY add additional public static boolean methods to this class if you like, and any private
 * static helper methods you need.
 * 
 * @author waizin
 */
public class OrderPriorityQueueTester {

  /**
   * Checks the correctness of the isEmpty method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue and verify that it is empty (2) add a
   * new Order to the queue and verify that it is NOT empty (3) remove that Order from the queue and
   * verify that it is empty again
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testIsEmpty() {
    try {
    // resting the ID of orders
    Order.resetIDGenerator();

    // TODO implement scenario 1, then go write the constructor and isEmpty methods in your
    // OrderPriorityQueue class so that they pass the tests

    // creating an new OrderPriorityQueue
    OrderPriorityQueue r = new OrderPriorityQueue(5);

    // checking if empty OrderPriorityQueue is empty, should return true
    if (r.isEmpty() != true) {
      return false;
    }

    // TODO implement scenario 2, then go write enough of insert() to pass the tests

    // inserting an order to OrderPriorityQueue
    r.insert(new Order("Sushi", 5));

    // checking if OrderPriorityQueue is empty after adding an order, should return false
    if (r.isEmpty() != false) {
      return false;
    }

    // TODO implement scenario 3, then go write enough of remove() to pass the tests

    // removing the only inserted order
    r.removeBest();

    // checking if OrderPriorityQueue is empty after removing the only order, should return true
    if (r.isEmpty() != true) {
      return false;
    }
    // catching for all exception
    } catch (Exception e) {
      return false;
    }
    // return true if and only if ALL tests pass
    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue and add a single order with a large
   * prepTime to it (2) use the OrderPriorityQueue toString method to verify that the queue's
   * internal structure is a valid heap (3) add at least three more orders with DECREASING prepTimes
   * to the queue and repeat step 2.
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertBasic() {
    try {
      // resting the ID of orders
      Order.resetIDGenerator();

      // creating a new OrderPriorityQueue
      OrderPriorityQueue w = new OrderPriorityQueue(5);

      // adding a single order with a large prepTime
      w.insert(new Order("Noodle", 8));

      // expected result
      String result = "1001(8)";

      // checking for size
      if (w.size() != 1) {
        return false;
      }

      // checking if actual result and expected result matches, return false if it doesn't
      if (!w.toString().equals(result)) {
        return false;
      }

      // adding at least 3 orders with decreasing prepTime
      w.insert(new Order("Burger", 5));
      w.insert(new Order("Hot Dog", 4));
      w.insert(new Order("Fries", 3));
      w.insert(new Order("Salad", 2));

      // expected result
      String result1 = "1001(8), 1002(5), 1003(4), 1004(3), 1005(2)";

      // checking for size
      if (w.size() != 5) {
        return false;
      }

      // checking if actual result and expected result matches, return false if it doesn't
      if (!w.toString().equals(result1)) {
        return false;
      }

      // creating a new OrderPriorityQueue
      OrderPriorityQueue g = new OrderPriorityQueue(7);
      g.insert(new Order("Burger", 5)); // this is 1006
      g.insert(new Order("Hot Dog", 5));
      g.insert(new Order("Fries", 5));
      g.insert(new Order("Salad", 5));
      g.insert(new Order("Dumpling", 5));
      g.insert(new Order("Curry", 5));
      System.out.print(g.toString());
      // catching for all exception
    } catch (Exception e) {
      return false;
    }
    // return true if and only if ALL tests pass
    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * (2) add a fifth order at the next available index that is NOT in a valid heap position (3) pass
   * this array to OrderPriorityQueue.percolateUp() (4) verify that the resulting array is a valid
   * heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateUp() {
    try {
      // resting the ID of orders
      Order.resetIDGenerator();

      // creating at least four Orders that represents a valid heap
      Order f1 = new Order("Burger", 5);
      Order f2 = new Order("Hot Dog", 4);
      Order f3 = new Order("Fries", 3);
      Order f4 = new Order("Salad", 2);

      // creating a NOT valid heap position
      Order f5 = new Order("Curry", 10);

      // array to be perlocated
      Order[] array = {f1, f2, f3, f4, f5};

      // perlocating last added index
      OrderPriorityQueue.percolateUp(array, 4);

      // expected result
      Order[] expected = {f5, f1, f3, f4, f2};

      // checking if array is perlocatedUp correctly, return false if it doesn't
      for (int i = 0; i < array.length; i++) {
        if (array[i] != expected[i]) {
          return false;
        }
      }
      // catching for all exception
    } catch (Exception e) {
      return false;
    }
    // return true if and only if ALL tests pass
    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue with at least 6 orders of varying
   * prepTimes, adding them to the queue OUT of order (2) use the OrderPriorityQueue toString method
   * to verify that the queue's internal structure is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertAdvanced() {
    try {
      // resting the ID of orders
      Order.resetIDGenerator();

      // creating a new OrderPriorityQueue with capacity of 7 orders
      OrderPriorityQueue t = new OrderPriorityQueue(7);

      // adding at least 6 orders with varying prepTimes
      t.insert(new Order("Burger", 5));
      t.insert(new Order("Hot Dog", 4));
      t.insert(new Order("Curry", 13));
      t.insert(new Order("Fries", 3));
      t.insert(new Order("Sushi", 8));
      t.insert(new Order("Salad", 2));
      t.insert(new Order("Hot Pot", 14));

      // expected result
      String result = "1007(14), 1005(8), 1003(13), 1004(3), 1002(4), 1006(2), 1001(5)";

      // checking for size
      if (t.size() != 7) {
        return false;
      }

      // checking for valid heap, return false if it doesn't
      if (!t.toString().equals(result)) {
        return false;
      }

      // adding an order exceeding capacity
      t.insert(new Order("Candy", 3));

      // expected result
      String result1 = "1007(14), 1005(8), 1003(13), 1008(3), 1002(4), 1006(2), 1001(5), 1004(3)";

      // checking for size since new order has been added
      if (t.size() != 8) {
        return false;
      }

      // checking for valid heap, return false if it doesn't
      if (!t.toString().equals(result1)) {
        return false;
      }
      // catching for all exception
    } catch (Exception e) {
      return false;
    }
    // return true if and only if ALL tests pass
    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create an array of at least five Orders where the Order at index 0 is
   * NOT in valid heap position (2) pass this array to OrderPriorityQueue.percolateDown() (3) verify
   * that the resulting array is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateDown() {


    try {
      // resting the ID of orders
      Order.resetIDGenerator();

      // creating at least five Orders where the Order at index 0 is NOT in valid heap position
      Order f1 = new Order("Candy", 1);
      Order f2 = new Order("Hot Dog", 4);
      Order f3 = new Order("Burger", 5);
      Order f4 = new Order("Salad", 2);
      Order f5 = new Order("Fries", 3);

      // array to be perlocated
      Order[] array = {f1, f2, f3, f4, f5};

      // perlocating the element at root
      OrderPriorityQueue.percolateDown(array, 0, 5);

      // expected result
      Order[] expected = {f3, f2, f1, f4, f5};

      // checking if array is perlocatedDown correctly, return false if it doesn't
      for (int i = 0; i < array.length; i++) {
        if (array[i] != expected[i]) {
          return false;
        }
      }
      // catching for all exception
    } catch (Exception e) {
      return false;
    }
    // return true if and only if ALL tests pass
    return true;
  }

  /**
   * Checks the correctness of the removeBest and peekBest methods of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue with at least 6 orders of varying
   * prepTimes, adding them to the queue in whatever order you like (2) remove all but one of the
   * orders, verifying that each order has a SHORTER prepTime than the previously-removed order (3)
   * peek to see that the only order left is the one with the SHORTEST prepTime (4) check isEmpty to
   * verify that the queue has NOT been emptied (5) remove the last order and check isEmpty to
   * verify that the queue HAS been emptied
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPeekRemove() {

    try {
      // resting the ID of orders
      Order.resetIDGenerator();

      // creating a new OrderPriorityQueue with capacity of 5 orders
      OrderPriorityQueue o = new OrderPriorityQueue(5);

      // inserting an order to OrderPriorityQueue
      o.insert(new Order("Fries", 3));

      // removing that order
      o.removeBest();

      // making sure size of OrderPriorityQueue is 0 removing
      if (o.size() != 0) {
        return false;
      }

      // making sure appropriate string is returned
      if (!o.toString().equals("")) {
        return false;
      }

      // creating at least 6 orders with varying prepTimes
      o.insert(new Order("Ramen", 15));
      o.insert(new Order("Hot Dog", 8));
      o.insert(new Order("Burger", 10));
      o.insert(new Order("Dim Sum", 3));
      o.insert(new Order("Dumpling", 7));
      o.insert(new Order("Candy", 1));
      o.insert(new Order("Fries", 2));

      // removing the order with highest prepTime
      o.removeBest();

      // making sure size is decremented after removing
      if (o.size() != 6) {
        return false;
      }

      // expected result after removing Best
      String result = "1004(10), 1003(8), 1008(2), 1005(3), 1006(7), 1007(1)";

      // checking for valid heap, return false if it doesn't, making sure least prepTime are only
      // left
      if (!o.toString().equals(result)) {
        return false;
      }

      // removing the order with highest prepTime
      o.removeBest();

      // making sure size is decremented after removing
      if (o.size() != 5) {
        return false;
      }

      // making sure longest prepTime are being remove, leaving shorter perpTime
      String result1 = "1003(8), 1006(7), 1008(2), 1005(3), 1007(1)";


      // checking for valid heap, return false if it doesn't, making sure least prepTime are only
      // left
      if (!o.toString().equals(result1)) {
        return false;
      }

      // removing the order with highest prepTime
      o.removeBest();

      // making sure size is decremented after removing
      if (o.size() != 4) {
        return false;
      }

      // making sure longest prepTime are being remove, leaving shorter perpTime
      String result2 = "1006(7), 1005(3), 1008(2), 1007(1)";


      // checking for valid heap, return false if it doesn't, making sure least prepTime are only
      // left
      if (!o.toString().equals(result2)) {
        return false;
      }

      // removing the order with highest prepTime
      o.removeBest();

      // making sure size is decremented after removing
      if (o.size() != 3) {
        return false;
      }

      // making sure longest prepTime are being remove, leaving shorter perpTime
      String result3 = "1005(3), 1007(1), 1008(2)";


      // checking for valid heap, return false if it doesn't, making sure least prepTime are only
      // left
      if (!o.toString().equals(result3)) {
        return false;
      }

      // removing the order with highest prepTime
      o.removeBest();

      // making sure size is decremented after removing
      if (o.size() != 2) {
        return false;
      }

      // making sure longest prepTime are being remove, leaving shorter perpTime
      String result4 = "1008(2), 1007(1)";

      // checking for valid heap, return false if it doesn't, making sure least prepTime are only
      // left
      if (!o.toString().equals(result4)) {
        return false;
      }

      // removing 2nd last order with highest prepTime, leaving only 1 order left
      o.removeBest();

      // expected peek result
      String result5 = "1007: Candy (1)";

      // peek to see that the only order left is the one with the SHORTEST prepTime
      if (!o.peekBest().toString().equals(result5)) {
        return false;
      }

      // check isEmpty to verify that the queue has NOT been emptied
      if (o.isEmpty() == true) {
        return false;
      }

      // remove the last order
      o.removeBest();

      // making sure queue HAS been emptied
      if (o.isEmpty() == false) {
        return false;
      }
      // catching for all exception
    } catch (Exception e) {
      return false;
    }
    // return true if and only if ALL tests pass
    return true;
  }

  /**
   * Checks the correctness of the removeBest and peekBest methods, as well as the constructor of
   * the OrderPriorityQueue class for erroneous inputs and/or states
   * 
   * You should, at least: (1) create a new OrderPriorityQueue with an invalid capacity argument,
   * and verify that the correct exception is thrown (2) call peekBest() on an OrderPriorityQueue
   * with an invalid state for peeking, and verify that the correct exception is thrown (3) call
   * removeBest() on an OrderPriorityQueue with an invalid state for removing, and verify that the
   * correct exception is thrown
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testErrors() {
    try {
      // resting the ID of orders
      Order.resetIDGenerator();

      // checking invalid capacity argument for OrderPriorityQueue
      try {
        // checking for IllegalArgumentException when input capacity is 0
        OrderPriorityQueue f = new OrderPriorityQueue(0);
        // return false when exception is not caught
        return false;
      } catch (IllegalArgumentException e) {
      }

      // checking invalid capacity argument for OrderPriorityQueue
      try {
        // checking for IllegalArgumentException when input capacity is negative
        OrderPriorityQueue f = new OrderPriorityQueue(-1);
        // return false when exception is not caught
        return false;
      } catch (IllegalArgumentException e) {
      }

      // creating an empty queue
      OrderPriorityQueue f = new OrderPriorityQueue(5);

      // checking for NoSuchElementException when peek in empty queue
      try {
        // peeking when queue is empty
        f.peekBest();
        // return false when exception is not caught
        return false;
      } catch (NoSuchElementException e) {
      }

      // checking for NoSuchElementException when removeBest() in empty queue
      try {
        // removeBest() when queue is empty
        f.removeBest();
        // return false when exception is not caught
        return false;
      } catch (NoSuchElementException e) {
      }
      //catching for all exception
    } catch (Exception e) {
      return false;
    }
    // return true if and only if ALL tests pass
    return true;
  }

  /**
   * Calls the test methods individually and displays their output
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("isEmpty: " + testIsEmpty());
    System.out.println("insert basic: " + testInsertBasic());
    System.out.println("percolate UP: " + testPercolateUp());
    System.out.println("insert advanced: " + testInsertAdvanced());
    System.out.println("percolate DOWN: " + testPercolateDown());
    System.out.println("peek/remove valid: " + testPeekRemove());
    System.out.println("error: " + testErrors());
  }

}
