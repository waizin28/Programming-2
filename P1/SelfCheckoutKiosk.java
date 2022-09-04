///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Self Checkout Kiosk
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
 * This class contains all methods to run Self Checkout Driver
 * 
 * @author waizin
 */
public class SelfCheckoutKiosk {

  public static final double TAX_RATE = 0.05; // sales tax
  // a perfect-size two-dimensional array that stores the available items in the grocery
  // GROCERY_ITEMS[i][0] refers to a String that represents the name of the item
  // identified by index i
  // GROCERY_ITMES[i][1] refers to a String that represents the unit price of the item
  // identified by index i in dollars
  public static final String[][] GROCERY_ITEMS = new String[][] {{"Apple", "$1.59"},
      {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
      {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
      {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
      {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
      {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
      {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};

  /**
   * Get the item name corresponding to its unique identifier
   * 
   * @param index unique identifier of an item
   * @return String the name of the item given its index
   */
  public static String getItemName(int index) {
    String productName = "";

    // look through the grocery list to find a matching identifier
    for (int i = 0; i < GROCERY_ITEMS.length; i++) {
      // if id matches then get corresponding product identifer's name
      if (i == index) {
        productName = GROCERY_ITEMS[i][0];
      }
    }
    // return the name of an item, corresponding to the inputed id
    return productName;
  }

  /**
   * Get the price item corresponding to its unique identifier
   * 
   * @param index unique identifier of an item
   * @return double the price of an item given its index (unique identifier)
   */
  public static double getItemPrice(int index) {
    double productPrice = 0.0;

    // look through the grocery list to find a matching identifier
    for (int i = 0; i < GROCERY_ITEMS.length; i++) {
      // if id matches then get corresponding product identifer's price
      if (i == index) {
        productPrice = Double.valueOf(GROCERY_ITEMS[i][1].substring(1).trim());
      }
    }
    // return the price of an item, corresponding to the inputed id
    return productPrice;
  }

  /**
   * Prints the Catalog of the grocery store (item identifiers, names, and prices)
   */
  public static void printCatalog() {
    // styling the id, name, and price to be align with its corresponding variables
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Item id \tName \t Price");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    // looping through the GROCERY_ITEM array to display name and price to its
    // corresponding id
    for (int i = 0; i < GROCERY_ITEMS.length; i++) {
      System.out.println(i + "\t\t" + getItemName(i) + " \t " + getItemPrice(i));
    }
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
  }

  /**
   * Adds the name of a grocery item given its identifier at the end of (the bagging area) 
   * 
   * @param id    identifier of the item to be added to the bagging area (index of the item in the
   *              GROCERY_ITEMS array)
   * @param items array storing the names of the items checked out and placed in the bagging area
   * @param size  number of elements stored in items before trying to add a new item
   * @return the number of elements stored in bagging area after the item with the provided
   *         identifier was added to the bagging area
   */
  public static int addItemToBaggingArea(int id, String[] items, int size) {
    // check whether the bagging area is full
    if (size >= items.length) {
      // return the original size without making any changes to content
      System.out.println("Error! No additional item can be scanned. Please wait for assistance.");
      return size;
      // otherwise store the name of the item corresponding to its id in item array
    } else {
      if (items[size] == null) {
        items[size] = getItemName(id);
        // increment the number of elements in items array after adding new item
        size++;
      }
    }
    // return the number of elements in items array
    return size;
  }

  /**
   * Count the number of times an item is in the items array
   * 
   * @param item  item to count its occurrences
   * @param items a bag of string items
   * @param size  number of items stored in items
   * @return the number of occurrences of a given item in an oversize array of strings. The
   *         comparison to find the occurrences of item is case insensitive.
   */
  public static int count(String item, String[] items, int size) {
    // Initialize the counter
    int count = 0;
    // search through the items array to find the item
    for (int i = 0; i < size; i++) {
      if (items[i] != null) {
        if (items[i].equalsIgnoreCase(item)) {
          // increment the counter if found
          count++;
        }
      }
    }
    // return the number of occurrences of item in items array
    return count;
  }

  /**
   * Find the first index of the item in items array, -1 if the item isn't found
   * 
   * @param item  element to search for
   * @param items an array of string elements
   * @param size  number of elements stored in items
   * @return the index of the first occurrence of item in items if found, and -1 if the item not
   *         found
   */
  public static int indexOf(String item, String[] items, int size) {
    // Create a variable to store index of first occurrence
    int position = -1;
    // search through the items array to find the item
    for (int i = 0; i < size; i++) {
      if (item.equalsIgnoreCase(items[i])) {
        // store the index in position variable if found and exit loop
        position = i;
        break;
      }
    }
    // return the index of first occurrence if found, otherwise -1
    return position;
  }

  /**
   * Removes the first occurrence of itemToRemove from the bagging area defined by the array items
   * and its size. 
   * 
   * @param itemToRemove item to remove from the bagging area
   * @param items        a bag of items
   * @param size         number of elements stored in the bag of items
   * @return the number of items present in the cart after the itemToRemove is removed from the cart
   */
  public static int remove(String itemToRemove, String[] items, int size) {
    // checking whether the item to remove is in the items array and
    // making sure the bag is not empty
    if (indexOf(itemToRemove, items, size) == -1 || size == 0) {
      // display warning message if item is not found and return original amount of items in the
      // cart
      System.out.println("WARNING: item not found.");
      return size;
      // otherwise proceed to remove the item
    } else {
      // finding the index of item to be remove
      int positionItem = indexOf(itemToRemove, items, size);
      for (int i = positionItem; i < items.length - 1; i++) {
        // replacing the index to be remove with the element next to it
        items[i] = items[i + 1];
      }
      // decrement the size after removing an item
      size--;
    }
    // return the number of items in cart after itemToRemove is removed
    return size;
  }

  /**
   * Gets a number of elements in items array that are not duplicates
   * 
   * @param items    list of items added to the bagging area
   * @param size     number of elements stored in items
   * @param itemsSet reference to an empty array which is going to contain the set of items checked
   *                 out (it does not contain duplicates)
   * @return the number of elements in items without accounting duplicates
   */
  public static int getUniqueCheckedOutItems(String[] items, int size, String[] itemsSet) {
    // Initialized the counter for number of unique items
    int counter = 0;
    for(int i = 0; i < size; i++) {
      //if no duplicates found, then add to itemsSet
        if(count(items[i],itemsSet,counter) == 0) {
          itemsSet[counter++] = items[i];
        }
       }
    //return number of elements without the duplicate
    return counter;
  }

  /**
   * Calculate the total amount of scanned items (without tax)
   * 
   * @param items an array which stores the items checked out
   * @param size  number of elements stored in the items array
   * @return the total value (price) of the scanned items at checkout without tax in $ (double)
   */
  public static double getSubTotalPrice(String[] items, int size) {
    // Initialized a variable to keep track of sums
    double totalPrice = 0.0;
    // loop through the items array, adding up the price of items in items list
    for (int i = 0; i < size; i++) {
      // comparing for same names at GROCERY_ITEMS array with items array
      for (int j = 0; j < GROCERY_ITEMS.length; j++) {
        if (items[i].equalsIgnoreCase(GROCERY_ITEMS[j][0])) {
          // if same name is found, add up the price of specified item
          totalPrice += getItemPrice(j);
        }
      }
    }
    // return the total amount of scanned items
    return totalPrice;
  }
}
