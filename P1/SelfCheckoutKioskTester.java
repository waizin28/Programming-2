///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Self Checkout Kiosk Tester
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
 * This is a testing class for Self Checkout Kiosk class's methods
 * 
 * @author waizin
 *
 */

public class SelfCheckoutKioskTester {

  /**
   * Checks whether SelfCheckoutKisok.getItemName() and SelfCheckoutKisok.getItemPrice() method work
   * as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testItemNameAndPriceGetterMethods() {
    // consider all identifiers values as input arguments
    // GROCERY_ITEMS array is a perfect size array. So, its elements are stored
    // in the range of indezes from 0 .. GROCERY_ITEMS.length -1
    for (int i = 0; i < SelfCheckoutKiosk.GROCERY_ITEMS.length; i++) {
      // check first for the correctness of the getItemName(i) method
      if (!SelfCheckoutKiosk.getItemName(i).equals(SelfCheckoutKiosk.GROCERY_ITEMS[i][0])) {
        System.out.println("Problem detected: Called your getItemName() method with "
            + "input value " + i + ". But it did not return the expected output.");
        return false;
      }

      // Now, let's check for the correctness of the getItemPrice(i) method
      double expectedPriceOutput =
          Double.valueOf(SelfCheckoutKiosk.GROCERY_ITEMS[i][1].substring(1).trim());
      // We do not use == to compare floating-point numbers (double and float)
      // in java. Two variables a and b of type double are equal if the absolute
      // value of their difference is less or equal to a small threshold epsilon.
      // For instance, if Math.abs(a - b) <= 0.001, then a equals b
      if (Math.abs((SelfCheckoutKiosk.getItemPrice(i) - expectedPriceOutput)) > 0.001) {
        // you can print a descriptive error message before returning false
        System.out.println("Problem detected: The expected price is not same outputed price");
        return false;
      }
    }
    return true; // No defect detected -> The implementation passes this test
  }


  /**
   * Checks the correctness of SelfCheckoutKiosk.addItemToBaggingArea() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddItemToBaggingArea() {
    // Create an empty bagging area
    String[] items = new String[10];
    int size = 0;

    // Define the test scenarios:

    // (1) Add one item to an empty bagging area
    // try to add an apple (id: 0) to the bagging area
    size = SelfCheckoutKiosk.addItemToBaggingArea(0, items, size);
    if (size != 1) {
      System.out.println("Problem detected: Tried to add one item to an empty, "
          + "bagging area. The returned size must be 1. But your addItemToBaggingArea "
          + "method returned a different output.");
      return false;
    }
    if (!items[0].equals(SelfCheckoutKiosk.getItemName(0))) {
      // notice here the importance of checking for the correctness of your getItemName()
      // method before calling it above
      System.out.println("Problem detected: Tried to add only one item to an empty, "
          + "bagging area. But that item was not appropriately added to the contents "
          + "of the items array.");
      return false;
    }

    // (2) Consider a non-empty bagging area
    items = new String[] {"Milk", "Chocolate", "Onion", null, null, null, null};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(10, items, size);
    if (size != 4) {
      System.out.println("Problem detected: Tried to add only one item to an non-empty, "
          + "bagging area. The size must be incremented after the method returns. But "
          + "it was not the case");
      return false;
    }
    if (!items[3].equals(SelfCheckoutKiosk.getItemName(10))) {
      System.out.println("Problem detected: Tried to add one item to an non-empty, "
          + "bagging area. But that item was not appropriately added to the contents "
          + "of the items array.");
      return false;
    }

    // (3) Consider adding an item to a full bagging are
    items = new String[] {"Pizza", "Eggs", "Apples"};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(2, items, size);
    // TODO Complete the implementation of this test scenario
    // Check that the returned size is correct (must be 3), and that no
    // changes have been made to the content of items array {"Pizza", "Eggs", "Apples"}
    if (size != 3) {
      System.out.println("Problem detected: Added an item to full bagging area");
      return false;
    }
    if (!items[0].equals(SelfCheckoutKiosk.getItemName(21))) {
      System.out.println("Problem detected: There have been changes made to content of array");
      return false;
    }
    return true; // No defects detected by this unit test
  }

  /**
   * Check whether count method works as expected
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCount() {
    // Initializing an items array with items inside
    String[] items = {"Apple", "pear", "BanAna", "strawBerry", "grape", "apple", "blueberry"};
    int itemNum = 0;
    // (1) a bagging area (defined by the items array and its size) which contains 0 occurrences of
    // the item
    itemNum = SelfCheckoutKiosk.count("blueberry", items, 6);
    if (itemNum != 0) {
      System.out.println(
          "Problem detected: The number of occurrences of a given item in an oversize array of strings"
              + " isn't zero");
      return false;
    }

    // (2) a bagging area which contains at least 4 items and only one occurrence of the item to
    // count
    itemNum = SelfCheckoutKiosk.count("pear", items, 7);
    if (itemNum != 1) {
      System.out.println(
          "Problem detected: The number of occurrences of a given item in an oversize array of strings"
              + " isn't one");
      return false;
    }

    // (3) a bagging area which contains at least 5 items and 2 occurrences of the item to count.
    itemNum = SelfCheckoutKiosk.count("apple", items, 7);
    if (itemNum != 2) {
      System.out.println(
          "Problem detected: The number of occurrences of a given item in an oversize array of strings"
              + " isn't two");
      return false;
    }
    return true; // No defects detected by this unit test
  }

  /**
   * Check whether indexOf method works as expected
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIndexOf() {
    // Initializing an items array with items inside
    String[] items = {"Chicken", "Pear", "Watermelon", "Pear", "Grape", "Apple", "Beef"};
    int index = 0;

    // items array contains at least one match with the item to find
    index = SelfCheckoutKiosk.indexOf("Pear", items, 6);
    if (index != 1) {
      System.out.println(
          "Problem detected: The index of first occurance item for array containing at least one match"
              + "with item to find is wrong");
      return false;
    }

    // item was not stored in the array and the expected output is -1
    index = SelfCheckoutKiosk.indexOf("Noodle", items, 7);
    if (index != -1) {
      System.out.println(
          "Problem detected: The index isn't showing -1 for the array with no corresponding item stored"
              + "in the array");
      return false;
    }
    return true;
  }

  /**
   * Check whether remove method works as expected
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemove() {
    // Initializing an items array with items inside
    String[] items = {"egg", "banana", "Avocado", "Milk", "Potato", null, null, null};
    int size = 0;

    // items array contains at least one match with the item to find
    size = SelfCheckoutKiosk.remove("banana", items, 8);
    if (size != 7) {
      System.out.println("Problem detected: The remove method has removed more than one item or"
          + " hasn't removed any item");
      return false;
    }

    // removing the item not in the bag
    size = SelfCheckoutKiosk.remove("butter", items, 8);
    if (size != 8) {
      System.out.println("Problem detected: The remove method has removed the item that is"
          + " not in the shopping cart");
      return false;
    }

    // removing an item from an empty bagging area
    size = SelfCheckoutKiosk.remove("Milk", items, 0);
    if (size != 0) {
      System.out.println(
          "Problem detected: The remove method has removed the item from" + " empty bagging area");
      return false;
    }
    return true;
  }


  // Checks whether getSubTotalPrice method returns the correct output
  public static boolean testGetSubTotalPrice() {
    // Initializing an items array with items inside
    String[] items = {"eggs", "Banana", "Avocado", "Milk", "Potato"};
    double totalPrice = 0.0;

    // items array contains at least one match with the item to find
    totalPrice = SelfCheckoutKiosk.getSubTotalPrice(items, 5);
    if (Math.abs(totalPrice - 6.95) > 0.001) {
      System.out.println("Problem detected: The calculation for sub total is wrong");
      return false;
    }
    return true;
  }

  /**
   * Check whether getUniqueCheckedOutItems method works as expected
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetUniqueCheckedOutItems() {
    // Initializing an items array with items inside
    String[] items = {"eggs", "banana", "Avocado", "eggs", "Milk", "Potato", "Milk",  null, null};
    String[] itemsSet = new String[9];
    int numElement = SelfCheckoutKiosk.getUniqueCheckedOutItems(items, 9, itemsSet);
    if (numElement != 5) {
      System.out.println(
          "Problem detected: The output of number of elements unique to items array is wrong");
      return false;
    }
    return true;
  }

  /**
   * main method used to call the unit tests
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out
        .println("tesItemNameAndPriceGetterMethods(): " + testItemNameAndPriceGetterMethods());
    System.out.println("testAddItemToBaggingArea() : " + testAddItemToBaggingArea());
    System.out.println("testCount() : " + testCount());
    System.out.println("testIndexOf() : " + testIndexOf());
    System.out.println("testRemove() : " + testRemove());
    System.out.println("testGetSubTotalPrice() : " + testGetSubTotalPrice());
    System.out.println("testGetUniqueCheckedOutItems() : " + testGetUniqueCheckedOutItems());
  }
}

