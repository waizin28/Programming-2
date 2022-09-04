///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Inventory List
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
 * This class models the singly linked list data structure that stores elements of type Box, which
 * contain method such as size (to get size of list), isEmpty (to check if list is empty), clear (to
 * clear up the list), addBrown (add brown box at end of list), addYellow(add at the front of the
 * list), addBlue (add after the yellow boxes), get (to get box at specified index), removeYellow
 * (remove yellow boxes from head), removeBrown (remove brown boxes from tail), removeBox (remove
 * box corresponding to inventoryNumber), getBrownCount (get count of brown boxes in the list),
 * getYellowCount (get count of yellow boxes in the list), getBlueCount (get count of blue boxes in
 * the list), toString (return string formatted of list)
 * 
 * @author waizin
 *
 */
public class InventoryList {

  private LinkedBox head; // represents the head of this list
  private LinkedBox tail; // represents tail of this list
  private int size; // keeps track of the total number of boxes stored in this list
  private int yellowCount; // keeps track of the total number of YELLOW boxes stored in this list
  private int blueCount; // keeps track of the total number of BLUE boxes stored in this list
  private int brownCount; // keeps track of the total number of BROWN boxes stored in this list

  /**
   * Get the size of this list
   * 
   * @return size of this list
   */
  public int size() {
    // return 0 if InventoryList is empty
    if (head == null && tail == null) {
      return 0;
    }
    // there will be at least one box if not empty thus 1
    size = 1;
    // initializing variable to start from the head
    LinkedBox curr = head;
    // start incrementing from head to tail
    while (curr.getNext() != null) {
      // increment the size if the list has not ended yet
      size++;
      // update the nodes in the list
      curr = curr.getNext();
    }
    // return the corresponding number in the list
    return size;
  }

  /**
   * Checks whether this LinkedBoxList is empty
   * 
   * @return true if LinkedBox is empty, false if not
   */
  public boolean isEmpty() {
    // checking head and tail to be null
    if (head == null && tail == null) {
      // if head and tail are null then the list have no nodes; hence empty
      return true;
    } else {
      // if head and tail are not null then the list have nodes; hence not empty
      return false;
    }
  }

  /**
   * Removes all of the elements from this list
   */
  public void clear() {
    // the head and tail will be null if empty
    head = null;
    tail = null;
    // all the size and count of yellow, blue and brown will be 0
    size = 0;
    yellowCount = 0;
    blueCount = 0;
    brownCount = 0;
  }

  /**
   * Adds a brown box at the end of this inventory list
   * 
   * @param brownBox new brown box to be added to this list
   * @throws an IllegalArgumentException if brownBox is null or if the color of the specific
   *            brownBox is not equal to Color.BROWN
   */
  public void addBrown(Box brownBox) {
    // checking for IllegalArgumentException when inputed brownBox is null or is not BROWN
    if (brownBox == null || !brownBox.getColor().equals(Color.BROWN)) {
      // throw IllegalArgumentException if conditions stated above match
      throw new IllegalArgumentException(
          "brownBox is null or if the color of the specific brownBox is not equal to Color.BROWN");
    }

    // initializing variable node with the brownBox to be added
    LinkedBox node = new LinkedBox(brownBox);
    // when the list is empty
    if (isEmpty()) {
      // the inputed node will be inputed at head and tail will point to head too
      head = node;
      tail = head;
    } else {
      // if there are nodes in the list, then the node will be place at the tail
      // setting the reference of node to null
      node.setNext(null);
      // setting the original tail reference to new node to be inputed in the list
      tail.setNext(node);
      // the new node will take the place of tail
      tail = node;
    }
    // increment brownCount and size if brownBox is added into list
    brownCount++;
    size++;
  }

  /**
   * Adds a new yellow box at the head of this list
   * 
   * @param yellowBox new box to be added to this list
   * @throws an IllegalArgumentException if yellowBox is null or if its color does not equal to
   *            Color.YELLOW
   */
  public void addYellow(Box yellowBox) {
    // checking for IllegalArgumentException when inputed yellowBox is null or is not YELLOW
    if (yellowBox == null || !yellowBox.getColor().equals(Color.YELLOW)) {
      // throw IllegalArgumentException if conditions stated above match
      throw new IllegalArgumentException(
          "yellowBox is null or if its color does not equal to Color.YELLOW");
    }

    // initializing variable node with the yellowBox to be added
    LinkedBox node = new LinkedBox(yellowBox);
    // when the list is empty
    if (isEmpty()) {
      // the inputed node will be inputed at head and tail will point to head too
      head = node;
      tail = head;
    } else {
      // the new node reference will be set to original head node
      node.setNext(head);
      // the new yellowBox node will take place of head
      head = node;
    }
    // increment yellowCount and size if yellowBox is added into list
    yellowCount++;
    size++;
  }

  /**
   * Adds a new blue box at the top of blue boxes if the list contains any blue box. Blue boxes must
   * be added at the buttom of yellow boxes and at the top of all the brown boxes if any. This means
   * that a new blue box must be added at index yellowCount.
   * 
   * @param blueBox new box to be added to this list
   * @throws an IllegalArgumentException if blueBox is null or if it does not have a Color.BLUE
   *            color
   */
  public void addBlue​(Box blueBox) {
    // checking for IllegalArgumentException when inputed blueBox is null or is not BLUE
    if (blueBox == null || !blueBox.getColor().equals(Color.BLUE)) {
      // throw IllegalArgumentException if conditions stated above match
      throw new IllegalArgumentException(
          "yellowBox is null or if its color does not equal to Color.YELLOW");
    }

    // initializing variable node with the blueBox to be added
    LinkedBox node = new LinkedBox(blueBox);
    // handling the empty box scenario
    if (isEmpty()) {
      // head and tail will point to inputed blueBox
      head = node;
      tail = head;
    } else if (yellowCount == 0) {
      // when there are no yellow boxes, blue boxes will place at head
      // the new blue box reference to original head
      node.setNext(head);
      // new blue box take place of head
      head = node;
    } else {
      // yellow count present scenario
      LinkedBox curr = head;
      for (int j = 0; j < yellowCount - 1; j++) {
        // keep moving present node to next node till reach yellowCount
        curr = curr.getNext();
      }
      // scenario to put blue box at tail
      if (curr == tail) {
        // setting the next node of new blue box to null
        node.setNext(null);
        // setting the original tail next node to the new blue box
        tail.setNext(node);
        // the new blue box become the new tail
        tail = node;
      } else {
        // scenario to place new blue box at somewhere in middle
        // setting the next node of new blue box to currr's next node
        node.setNext(curr.getNext());
        // current reference point to new blue box
        curr.setNext(node);
      }
    }
    // increment blueCount and size if blueBox is added into list
    blueCount++;
    size++;
  }

  /**
   * Returns the element stored at position index of this list without removing it
   * 
   * @param index position within this list
   * @return the box stored at position index of this list
   * @throws an IndexOutOfBoundsException if the index is out of bounds (index < 0 || index >=
   *            size())
   */
  public Box get​(int index) {
    // checking for IndexOutOfBoundsException when index is negative or is equal to or greater than
    // size
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException(
          "Index must be greater than 0 or have number larger than size");
    }

    // getting the index before tail
    if (index < size - 1) {
      LinkedBox curr = head;
      for (int j = 0; j < index; j++) {
        curr = curr.getNext();
      }
      // get the specified index box
      return curr.getBox();
    }
    // get the last index box otherwise
    return tail.getBox();
  }

  /**
   * Removes and returns the box at the head of this list if its color is yellow
   * 
   * @return a reference to the removed box
   * @throws an NoSuchElementException if this list does not contain any yellow boxes
   */
  public Box removeYellow() {
    // throw NoSuchElementException when there are no yellow boxes
    if (yellowCount == 0) {
      throw new NoSuchElementException("This list does not contain any yellow boxes");
    }

    // initialize the variable first with the head
    Box first = head.getBox();

    // when there are more than 1 boxes, move the head to another one
    if (head != tail) {
      head = head.getNext();
    } else {
      // if there is only 1 box in list, head will getNext element which is null then tail will be
      // head
      head = head.getNext();
      tail = head;
    }

    // decrement the yellowCount and size after removing
    yellowCount--;
    size--;

    // return the removed box
    return first;
  }

  /**
   * Removes and returns the element at the tail of this list if it has a brown color
   * 
   * @return a reference to the removed element
   * @throws NoSuchElementException if this list does not contain any brown box (brownCount == 0)
   */
  public Box removeBrown() {
    // throw NoSuchElementException when there are no brown boxes
    if (brownCount == 0) {
      throw new NoSuchElementException("This list does not contain any brown box");
    }

    // get the last tail box
    Box last = tail.getBox();
    // if contain more than one boxes
    if (head != tail) {
      // loop to get the node before tail
      LinkedBox curr = head;
      while (curr.getNext().getNext() != null) {
        curr = curr.getNext();
      }
      // put the node before tail as tail
      tail = curr;
      // set the new tail to null
      tail.setNext(null);
    } else {
      // if only 1 element head will be null, tail will point to head
      head = null;
      tail = head;
    }

    // decrement the brownCount and size after removing
    brownCount--;
    size--;

    // return the removed box
    return last;
  }

  /**
   * Removes and returns a box given its inventory number from this list
   * 
   * @return a reference to the removed element
   * @throws NoSuchElementException if no box is found with the provided inventory number in the
   *                                list
   */
  public Box removeBox(int inventoryNumber) {
    // checking to make sure inventoryNumber is valid and list is not empty, will throw
    // NoSuchElementException if not
    if (inventoryNumber < 1 || isEmpty()) {
      throw new NoSuchElementException(
          "Error to remove box. Box #" + inventoryNumber + " not found!");
    }

    // initializing check with head node
    LinkedBox check = head;
    // searching for inventoryNumber within the list
    while (check.getBox().getInventoryNumber() != inventoryNumber) {
      if (check.getNext() != null) {
        check = check.getNext();
      } else {
        // throw NoSuchElementException if not found
        throw new NoSuchElementException(
            "Error to remove box. Box #" + inventoryNumber + " not found!");
      }
    }

    // creating a variable call remove to store the remove box
    Box remove;

    // if the head contain inventoryNumber that we are searching
    if (head.getBox().getInventoryNumber() == inventoryNumber) {
      // store the head node's box into remove
      remove = head.getBox();

      // decrement the corresponding color count and size
      if (head.getBox().getColor().equals(Color.YELLOW)) {
        yellowCount--;
        size--;
      } else if (head.getBox().getColor().equals(Color.BLUE)) {
        blueCount--;
        size--;
      } else {
        brownCount--;
        size--;
      }

      // if there are more than 1 node in the list
      if (size > 1) {
        // a node after the head will replace the head
        head = head.getNext();
      } else {
        // if not the head will be null, and tail will be also null
        head = head.getNext();
        tail = head;
      }
      // if the tail contain inventoryNumber that we are searching
    } else if (inventoryNumber == tail.getBox().getInventoryNumber()) {

      // getting the node before the tail in curr variable
      LinkedBox curr = head;
      while (curr.getNext().getNext() != null) {
        curr = curr.getNext();
      }
      // decrement the corresponding color count and size
      if (tail.getBox().getColor().equals(Color.YELLOW)) {
        yellowCount--;
        size--;
      } else if (tail.getBox().getColor().equals(Color.BLUE)) {
        blueCount--;
        size--;
      } else {
        brownCount--;
        size--;
      }

      // put the tail node into the remove variable
      remove = tail.getBox();
      // put the second node before tail as tail
      tail = curr;
      // set the new tail to null
      tail.setNext(null);
    } else {
      // last scenario is when removing somewhere in middle
      // start from the head
      LinkedBox curr = head;
      // getting the node that matches the inventoryNumber
      while (curr.getBox().getInventoryNumber() != inventoryNumber) {
        curr = curr.getNext();
      }

      // getting the node that is before the node that matches the inventoryNumber
      LinkedBox prev = head;
      while (prev.getNext().getBox() != curr.getBox()) {
        prev = prev.getNext();
      }
      // decrement the corresponding color count and size
      if (curr.getBox().getColor().equals(Color.YELLOW)) {
        yellowCount--;
        size--;
      } else if (curr.getBox().getColor().equals(Color.BLUE)) {
        blueCount--;
        size--;
      } else {
        brownCount--;
        size--;
      }
      // store the node's box that matches the inventoryNumber that we are looking for
      remove = curr.getBox();
      // the node place will be replace by the next node
      curr = curr.getNext();
      // previous node will point to the new node that has replaced the node that has been removed
      prev.setNext(curr);

    }
    // return the box that has been removed
    return remove;
  }

  /**
   * Returns the number of brown boxes stored in this list
   * 
   * @return number of brown boxes stored in this list
   */
  public int getBrownCount() {
    // return the brownCount that list have
    return this.brownCount;
  }

  /**
   * Returns the number of yellow boxes stored in this list
   * 
   * @return number of yellow boxes stored in this list
   */
  public int getYellowCount() {
    // return the yellowCount that list have
    return this.yellowCount;
  }

  /**
   * Returns the number of blue boxes stored in this list
   * 
   * @return number of blue boxes stored in this list
   */
  public int getBlueCount() {
    // return the blueCount that list have
    return this.blueCount;
  }

  /**
   * Returns a String representation of the contents of this list
   */
  @Override
  public String toString() {
    // initializing color variable to concatenate boxes to
    String color = "";
    // will return empty string if there is no boxes in InventoryList
    if (size == 0) {
      return "";
    }

    // start from head box
    LinkedBox curr = head;

    // looping to get all boxes from head to a box before tail
    while (curr.getNext() != null) {
      color += curr.getBox().getColor() + " " + curr.getBox().getInventoryNumber() + " -> ";
      curr = curr.getNext();
    }

    // checking if next node is tail
    if (curr.getNext() == null) {
      // concatenate the tail and "end"
      color += curr.getBox().getColor() + " " + curr.getBox().getInventoryNumber() + " -> END";
    }

    // return the String representation of the contents of this list
    return color;
  }
}
