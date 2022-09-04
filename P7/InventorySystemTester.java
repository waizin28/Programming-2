///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Inventory System Tester
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
 * This is a tester class that makes sure all the methods from InventoryList and LinkedBox class
 * work correctly.
 * 
 * @author waizin
 *
 */
public class InventorySystemTester {

  /**
   * Test and make use of at least one LinkedBox constructor, an accessor (getter) method, and a
   * mutator (setter) method
   * 
   * @return true if all tests are correct, false if not
   */
  public static boolean testLinkedBox() {
    // creating at least 1 linkedBox constructor
    LinkedBox box = new LinkedBox(new Box(Color.BLUE));
    LinkedBox box1 = new LinkedBox(new Box(Color.YELLOW), box);
    LinkedBox box2 = new LinkedBox(new Box(Color.BROWN), box1);

    // testing for getBox method
    String g = String.valueOf(box1.getBox());
    String check = "YELLOW 2";
    if (!g.equals(check)) {
      return false;
    }

    // null check for next when only 1 item in linkedBox
    if (box.getNext() != null) {
      return false;
    }

    // testing for getNext method for next null
    String g1 = String.valueOf(box1.getNext());
    String check1 = "BLUE 1 -> END";
    if (!g1.equals(check1)) {
      return false;
    }

    // testing for getNext method for not next null
    String g2 = String.valueOf(box2.getNext());
    String check2 = "YELLOW 2 -> ";
    if (!g2.equals(check2)) {
      return false;
    }

    // testing for getNext method for next next
    String g3 = String.valueOf(box2.getNext().getNext());
    String check3 = "BLUE 1 -> END";
    if (!g3.equals(check3)) {
      return false;
    }

    // testing for setNext value for 1 item in linkedBox
    box.setNext(new LinkedBox(new Box(Color.BROWN)));
    String g4 = String.valueOf(box.getNext());
    String check4 = "BROWN 4 -> END";
    if (!g4.equals(check4)) {
      return false;
    }

    // testing for setNext value for 2 items in linkedBox
    box1.setNext(new LinkedBox(new Box(Color.YELLOW)));
    String g5 = String.valueOf(box1.getNext());
    String check5 = "YELLOW 5 -> END";
    if (!g5.equals(check5)) {
      return false;
    }

    // return true if the tests are executed correctly, false if not
    return true;
  }

  /**
   * Checks for the correctness of the InventoryList.clear() method
   * 
   * @return true if all tests are correct, false if not
   */
  public static boolean testClear() {
    // creating InventoryList
    InventoryList l1 = new InventoryList();
    // adding boxes into InventoryList
    l1.addYellow(new Box(Color.YELLOW));
    l1.addBlue​(new Box(Color.BLUE));
    l1.addBrown(new Box(Color.BROWN));
    // clearing up the InventoryList
    l1.clear();

    // checking for size and count of all color to be 0 after clear method
    if (l1.size() != 0 || l1.getYellowCount() != 0
        || l1.getBrownCount() != 0 && l1.getBlueCount() != 0) {
      return false;
    }

    // creating a new InventoryList
    InventoryList l2 = new InventoryList();
    l2.clear();

    // checking for correct of clear method for empty InventoryList
    if (l2.size() != 0 || l2.getYellowCount() != 0 || l2.getBrownCount() != 0
        || l2.getBlueCount() != 0) {
      return false;
    }

    // return true if the tests are executed correctly, false if not
    return true;
  }

  /**
   * Checks for the correctness of the InventoryList.addYellow(), InventoryList.addBlue(), and
   * InventoryList.addBrown() methods
   * 
   * @return true if all tests are correct, false if not
   */
  public static boolean testAddBoxes() {
    // creating InventoryList
    InventoryList l1 = new InventoryList();
    // adding boxes into InventoryList
    l1.addYellow(new Box(Color.YELLOW));
    l1.addBlue​(new Box(Color.BLUE));
    l1.addBrown(new Box(Color.BROWN));

    // checking for the counts and size
    if (l1.size() != 3 || l1.getYellowCount() != 1
        || l1.getBrownCount() != 0 && l1.getBlueCount() != 1) {
      return false;
    }

    // checking for the accuracy of the list
    String result = "YELLOW 9 -> BLUE 10 -> BROWN 11 -> END";
    if (!result.equals(l1.toString())) {
      return false;
    }

    // adding box Yellow to empty list
    InventoryList l2 = new InventoryList();
    l2.addYellow(new Box(Color.YELLOW));

    // checking for the counts and size
    if (l2.size() != 1 || l2.getYellowCount() != 1) {
      return false;
    }

    // checking for the accuracy of the list
    String result1 = "YELLOW 12 -> END";
    if (!result1.equals(l2.toString())) {
      return false;
    }

    // adding Brown box to empty list
    InventoryList l3 = new InventoryList();
    l3.addBrown(new Box(Color.BROWN));

    // checking for the counts and size
    if (l3.size() != 1 || l3.getBrownCount() != 1) {
      return false;
    }

    // checking for the accuracy of the list
    String result2 = "BROWN 13 -> END";
    if (!result2.equals(l3.toString())) {
      return false;
    }

    // adding Blue box to empty list
    InventoryList l4 = new InventoryList();
    l4.addBlue​(new Box(Color.BLUE));

    // checking for the counts and size
    if (l4.size() != 1 || l4.getBlueCount() != 1) {
      return false;
    }

    // checking for the accuracy of the list
    String result3 = "BLUE 14 -> END";
    if (!result3.equals(l4.toString())) {
      return false;
    }

    // checking for relationship between blue boxes and below yellow boxes
    InventoryList l5 = new InventoryList();
    l5.addBlue​(new Box(Color.BLUE));
    l5.addYellow(new Box(Color.YELLOW));
    l5.addBlue​(new Box(Color.BLUE));
    l5.addYellow(new Box(Color.YELLOW));

    // checking for the counts and size
    if (l5.size() != 4 || l5.getBlueCount() != 2 || l5.getYellowCount() != 2) {
      return false;
    }

    // checking for the accuracy of the list
    String result4 = "YELLOW 18 -> YELLOW 16 -> BLUE 17 -> BLUE 15 -> END";
    if (!result4.equals(l5.toString())) {
      return false;
    }

    // checking for relationship between blue boxes and below brown boxes
    InventoryList l6 = new InventoryList();
    l6.addBlue​(new Box(Color.BLUE));
    l6.addBrown(new Box(Color.BROWN));
    l6.addBlue​(new Box(Color.BLUE));
    l6.addBrown(new Box(Color.BROWN));
    l6.addBlue​(new Box(Color.BLUE));

    // checking for the counts and size
    if (l6.size() != 5 || l6.getBlueCount() != 3 || l6.getBrownCount() != 2) {
      return false;
    }

    // checking for the accuracy of the list
    String result5 = "BLUE 23 -> BLUE 21 -> BLUE 19 -> BROWN 20 -> BROWN 22 -> END";
    if (!result5.equals(l6.toString())) {
      return false;
    }

    // checking for relationship between yellow boxes and brown boxes
    InventoryList l7 = new InventoryList();
    l7.addBrown(new Box(Color.BROWN));
    l7.addYellow(new Box(Color.YELLOW));
    l7.addBrown(new Box(Color.BROWN));
    l7.addYellow(new Box(Color.YELLOW));
    l7.addBrown(new Box(Color.BROWN));

    // checking for the counts and size
    if (l7.size() != 5 || l7.getBrownCount() != 3 || l7.getYellowCount() != 2) {
      return false;
    }

    // checking for the accuracy of the list
    String result6 = "YELLOW 27 -> YELLOW 25 -> BROWN 24 -> BROWN 26 -> BROWN 28 -> END";
    if (!result6.equals(l7.toString())) {
      return false;
    }

    // checking for IllegalArgumentException of addBlue method
    InventoryList l8 = new InventoryList();
    try {
      l8.addBlue​(new Box(Color.BROWN));
      // will return false if fail to catch the IllegalArgumentException
      return false;
    } catch (IllegalArgumentException e) {
    }

    // checking for IllegalArgumentException of addBrown method
    InventoryList l9 = new InventoryList();
    try {
      l9.addBrown(new Box(Color.BLUE));
      // will return false if fail to catch the IllegalArgumentException
      return false;
    } catch (IllegalArgumentException e) {
    }

    // checking for IllegalArgumentException of addYellow method
    InventoryList l10 = new InventoryList();
    try {
      l10.addYellow(new Box(Color.BROWN));
      // will return false if fail to catch the IllegalArgumentException
      return false;
    } catch (IllegalArgumentException e) {
    }

    // return true if the tests are executed correctly, false if not
    return true;
  }

  /**
   * Checks for the correctness of the InventoryList.removeBox() InventoryList.removeYellow(), and
   * InventoryList.remove Brown() methods
   * 
   * @return true if all tests are correct, false if not
   */
  public static boolean testRemoveBoxes() {
    // checking for accuracy of removeBrown method for 1 element
    InventoryList g = new InventoryList();
    g.addBrown(new Box(Color.BROWN));
    g.removeBrown();

    // checking for the counts and size
    if (g.size() != 0 || g.getBrownCount() != 0) {
      return false;
    }

    // checking for the accuracy of the result
    String result = "";
    if (!result.equals(g.toString())) {
      return false;
    }

    // checking for accuracy of removeBrown method for more than 1 element
    InventoryList g1 = new InventoryList();
    g1.addYellow(new Box(Color.YELLOW));
    g1.addBrown(new Box(Color.BROWN));
    g1.addBrown(new Box(Color.BROWN));
    g1.addBrown(new Box(Color.BROWN));
    g1.addYellow(new Box(Color.YELLOW));
    g1.addBlue​(new Box(Color.BLUE));
    g1.removeBrown();
    g1.removeBrown();

    // checking for the counts and size
    if (g1.size() != 4 || g1.getBrownCount() != 1) {
      return false;
    }

    // checking for accuracy of removeBrown method for 1 element
    String result2 = "YELLOW 37 -> YELLOW 33 -> BLUE 38 -> BROWN 34 -> END";
    if (!result2.equals(g1.toString())) {
      return false;
    }

    // checking for accuracy of removeYellow method for 1 element
    InventoryList g2 = new InventoryList();
    g2.addYellow(new Box(Color.YELLOW));
    g2.removeYellow();


    // checking for the counts and size
    if (g2.size() != 0 || g2.getYellowCount() != 0) {
      return false;
    }

    // checking for the accuracy of the result
    String result3 = "";
    if (!result3.equals(g2.toString())) {
      return false;
    }

    // checking for accuracy of removeYellow method for more than 1 element
    InventoryList g3 = new InventoryList();
    g3.addBlue​(new Box(Color.BLUE));
    g3.addYellow(new Box(Color.YELLOW));
    g3.addYellow(new Box(Color.YELLOW));
    g3.addBrown(new Box(Color.BROWN));
    g3.addBlue​(new Box(Color.BLUE));
    g3.addYellow(new Box(Color.YELLOW));
    g3.addBrown(new Box(Color.BROWN));
    g3.addBlue​(new Box(Color.BLUE));
    g3.removeYellow();
    g3.removeYellow();

    // checking for the counts and size
    if (g3.size() != 6 || g3.getYellowCount() != 1) {
      return false;
    }

    // checking for accuracy of removeBrown method for 1 element
    String result4 = "YELLOW 41 -> BLUE 47 -> BLUE 44 -> BLUE 40 -> BROWN 43 -> BROWN 46 -> END";
    if (!result4.equals(g3.toString())) {
      return false;
    }

    // checking for accuracy of removeBox method for 1 element
    InventoryList g4 = new InventoryList();
    LinkedBox r = new LinkedBox(new Box(Color.BLUE));
    g4.addBlue​(r.getBox());
    Box f = g4.removeBox(48);

    // checking for count of blue color and size
    if (g4.size() != 0 || g4.getBlueCount() != 0) {
      return false;
    }

    // checking for accuracy of removeBox method for 1 element
    if (f != r.getBox()) {
      return false;
    }

    // checking for accuracy of removeBox method for more than 1 element
    InventoryList g5 = new InventoryList();
    LinkedBox r1 = new LinkedBox(new Box(Color.BROWN));
    LinkedBox r2 = new LinkedBox(new Box(Color.YELLOW));
    g5.addBrown(r1.getBox());
    g5.addBlue​(new Box(Color.BLUE));
    g5.addYellow(r2.getBox());
    g5.addBlue​(new Box(Color.BLUE));
    Box f1 = g5.removeBox(49);
    Box f2 = g5.removeBox(50);

    // checking for count of blue color and size
    if (g5.size() != 2 || g5.getYellowCount() != 0 || g5.getBrownCount() != 0
        || g5.getBlueCount() != 2) {
      return false;
    }

    // checking for same reference as the brown box that has been added and remove
    if (f1 != r1.getBox()) {
      return false;
    }

    // checking for same reference as the blue box that has been added and remove
    if (f2 != r2.getBox()) {
      return false;
    }

    // checking for removeBox method NoSuchElementException
    InventoryList g6 = new InventoryList();

    // trying to remove from empty list
    try {
      g6.removeBox(1);
      // will return false if exception is not caught
      return false;
    } catch (NoSuchElementException e) {
    }

    // trying to remove the inventoryNumber that is not in the list
    g6.addBrown(new Box(Color.BROWN));
    g6.addBlue​(new Box(Color.BLUE));
    g6.addYellow(new Box(Color.YELLOW));
    g6.addYellow(new Box(Color.YELLOW));

    // trying to remove the inventoryNumber that is not in the list
    try {
      g6.removeBox(100);
      // will return false if exception is not caught
      return false;
    } catch (NoSuchElementException e) {
    }


    // return true if the tests are executed correctly, false if not
    return true;
  }

  /**
   * Checks for the correctness of the InventoryList.get() method
   * 
   * @return true if all tests are correct, false if not
   */
  public static boolean testGetBoxes() {
    // creating a new InventoryList
    InventoryList list = new InventoryList();
    // initializing variable, first, with the reference to add into list position
    LinkedBox first = new LinkedBox(new Box(Color.YELLOW));
    // initializing variable, third, with the reference to add into list position
    LinkedBox third = new LinkedBox(new Box(Color.BLUE));
    // adding color boxes into the LinkedBox list
    list.addBlue​(third.getBox());
    list.addYellow(new Box(Color.YELLOW));
    list.addBlue​(new Box(Color.BLUE));
    list.addBrown(new Box(Color.BROWN));
    list.addYellow(first.getBox());

    // getting the box at index 0
    Box g = list.get​(0);

    // checking if the getBox and box specified at index 0 is same
    if (g != first.getBox()) {
      return false;
    }

    // getting the box at index 3
    Box g1 = list.get​(3);

    // checking if the getBox and box specified at index 3 is same
    if (g1 != third.getBox()) {
      return false;
    }

    // checking IndexOutOfBoundsException when index is equal to size
    try {
      Box g2 = list.get​(5);
      return false;
    } catch (IndexOutOfBoundsException e) {
    }

    // checking IndexOutOfBoundsException when index is greater size
    try {
      Box g3 = list.get​(10);
      return false;
    } catch (IndexOutOfBoundsException e) {
    }

    return true;
  }

  /**
   * A test suite method to run all your test methods
   * 
   * @return true if all tests are correct, false if not
   */
  public static boolean runAllTests() {

    // testing for methods from LinkedBox class
    if (!testLinkedBox()) {
      return false;
    }

    // testing for clear method from InventoryList class
    if (!testClear()) {
      return false;
    }


    // testing for add methods from InventoryList class
    if (!testAddBoxes()) {
      return false;
    }


    // testing for removeBoxes from InventoryList class
    if (!testRemoveBoxes()) {
      return false;
    }

    // testing for getBoxes from InventoryList class
    if (!testGetBoxes()) {
      return false;
    }


    // return true if the tests are executed correctly, false if not
    return true;
  }

  /**
   * Helper method to display the size and the count of different boxes stored in a list of boxes
   * 
   * @param list a reference to an InventoryList object
   * @throws NullPointerException if list is null
   */
  private static void displaySizeCounts(InventoryList list) {
    System.out.println(" Size: " + list.size() + ", yellowCount: " + list.getYellowCount()
        + ", blueCount: " + list.getBlueCount() + ", brownCount: " + list.getBrownCount());
  }


  /**
   * Demo method showing how to use the implemented classes in P07 Inventory Storage System
   * 
   * @param args input arguments
   */
  public static void demo() {
    // Create a new empty InventoryList object
    InventoryList list = new InventoryList();
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    // Add a blue box to an empty list
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 1
    System.out.println(list); // prints list’s content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 2 at the head of the list
    System.out.println(list); // prints list’s content
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 3
    System.out.println(list); // prints list’s content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 4
    System.out.println(list); // prints list’s content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 5 at the head of the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    // Add more boxes to list and display its contents
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 6 at the end of the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 7 at the end of the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.removeBrown(); // removes BROWN 7 from the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 8
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.removeBrown(); // removes BROWN 6 from the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.removeYellow(); // removes YELLOW 5
    System.out.println(list); // prints list’s content
    list.removeBox(3); // removes BLUE 3 from the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    try {
      list.removeBox(25); // tries to remove box #25
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    // remove all yellow boxes
    while (list.getYellowCount() != 0) {
      list.removeYellow();
    }
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.removeBox(1); // removes BLUE 1 from the list -> empty list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 9 to the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.removeBox(8); // removes BLUE 8 from the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.removeBrown(); // removes BROWN 9 from the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 10 to the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
    list.removeBox(10); // removes YELLOW 10 from the list
    System.out.println(list); // prints list’s content
    displaySizeCounts(list); // displays list’s size and counts
  }

  /**
   * Test the methods from InventoryList and LinkedBox are working perfectly
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("RunAllTests(): " + runAllTests());
    // demo();

  }

}
