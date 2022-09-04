///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Person
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
 * This class contains assessors, mutators, toggleWaiting, equals method of a Person class
 * 
 * @author waizin
 *
 */
public class Person {

  private String name; // name of representing Person
  private boolean isWaiting = true; // true if and only if Person is currently not in room

  /**
   * Constructor for Person's class
   * 
   * @param name a person's corresponding name
   */
  public Person(String name) {
    // initializing Person class's name with object name
    this.name = name;
  }

  /**
   * Get the name of the person
   * 
   * @return name of a corresponding person
   */
  public String getName() {
    // returning the Person class's name
    return this.name;
  }

  /**
   * Get the waiting status of person in room or not
   * 
   * @return waiting status true if person not in the room, false if person is in room
   */
  public boolean isWaiting() {
    // returning the Person class's isWaiting
    return this.isWaiting;
  }

  /**
   * Sets isWaiting to true if it is currently false, false if it is currently true
   */
  public void toggleWaiting() {
    // checking to see if isWaiting is false
    if (isWaiting == false) {
      // if false, make it true
      isWaiting = true;
    } else {
      // if true, make it false
      isWaiting = false;
    }
  }

  /**
   * Checking for whether a reference variable is containing a given type of object reference or not
   */
  public boolean equals(Object o) {
    // checking for inputted's object to be Person object
    if (o instanceof Person) {
      // return true if the object is the same
      return this.name.equals(((Person) o).name);
    }
    // return false if not same
    return false;
  }

}
