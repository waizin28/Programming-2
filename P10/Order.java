///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Order
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
 * Basic object representing a food order at this restaurant.
 * 
 * This class contains no mutator methods, only accessors.
 * 
 * TODO: implement the Comparable<Order> interface
 * 
 * @author waizin
 */
public class Order implements Comparable<Order> {

  private static int idGenerator = 1001; // generator of unique order ID numbers

  private String dishName; // name of the food associated with this Order
  private int prepTime; // approximate number of minutes to prepare this Order
  private final int ORDER_ID; // unique order ID number

  /**
   * Constructor, initializes dish name and estimated prep time. Also sets this order's unique
   * identifier.
   * 
   * @param dishName the name of the dish contained in this order
   * @param prepTime the approximate number of minutes required to prepare this dish
   */
  public Order(String dishName, int prepTime) {
    // throw IllgegalArgumentException if prepTime is negative
    if (prepTime < 0)
      throw new IllegalArgumentException("Invalid prep time");
    // initializing the field variables
    this.ORDER_ID = idGenerator++;
    this.dishName = dishName;
    this.prepTime = prepTime;
  }

  /**
   * Returns the name of the food associated with this Order
   * 
   * @return the name of the food associated with this Order
   */
  public String getDishName() {
    return this.dishName;
  }

  /**
   * Returns the approximate number of minutes to prepare this Order
   * 
   * @return the approximate number of minutes to prepare this Order
   */
  public int getPrepTime() {
    return this.prepTime;
  }

  /**
   * Returns the unique ID number of this Order
   * 
   * @return the unique ID number of this Order
   */
  public int getID() {
    return this.ORDER_ID;
  }

  /**
   * Returns a String representation of this Order in the format "ID: dishname (prepTime)"
   * 
   * @return a String representation of this Order
   */
  @Override
  public String toString() {
    return this.ORDER_ID + ": " + this.dishName + " (" + this.prepTime + ")";
  }

  /**
   * This method resets the idGenerator to 1001. This method must be used in your tester methods
   * only.
   */
  public static void resetIDGenerator() {
    idGenerator = 1001;
  }

  // TODO: Implement the Comparable<Order> interface and any required methods such that two Orders
  // are equal if their prepTime values are equal, and an Order is "less than" another Order if its
  // prepTime is shorter than the other Order's.

  /**
   * Compares two order prepTime
   * 
   * @return 0 if two Orders have equal prepTime values, -1 if an Order is "less than" another
   *         Order, 1 if an Order is greater than other Order
   */
  @Override
  public int compareTo(Order o) {
    // if given order prep time and this prep time is equal, return 0
    if (o.getPrepTime() == this.prepTime) {
      return 0;
      // if this order prep time is less than given prep time, return -1
    } else if (this.prepTime < o.getPrepTime()) {
      return -1;
      // if this order prep time is greater than given prep time, return 1
    } else {
      return 1;
    }
  }

}
