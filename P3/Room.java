///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Room
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

import java.util.ArrayList;

/**
 * This class contains assessors, mutators, checkIn, checkOut, and toString method of a Room class
 * 
 * @author waizin
 *
 */
public class Room {

  private static ArrayList<String> names = new ArrayList<String>(); // contain currently-used name
                                                                    // identifiers
  private String name; // name of room
  private Person[] occupants; // Persons currently in the room
  private static int currentOccupancy; // number of Persons in the room

  /**
   * Constructor to initialize instance variables for object
   * 
   * @param name     Name of the room
   * @param capacity Max number of Persons in room
   */
  public Room(String name, int capacity) {
    // checking to see validity of capacity and name
    if (names.contains(name) || capacity <= 0) {
      // throw IllegalArgumentException exception if the conditions don't match out
      throw new IllegalArgumentException("do not make any changes to the Room.names ArrayList");
    } else {
      // if conditions match, add the room name to names ArrayList
      names.add(name);
    }
    // initializing the instance variables for the object
    this.name = name;
    occupants = new Person[capacity];
    currentOccupancy = 0;
  }

  /**
   * Get room's name
   * 
   * @return name of the room
   */
  public String getName() {
    // returning the Room's name
    return this.name;
  }

  /**
   * Get number of people currently in room
   * 
   * @return current of people in room
   */
  public int getOccupancy() {
    // returning the number of people currently in room
    return this.currentOccupancy;
  }

  /**
   * Get number of people allow in Room under COVID rule
   *
   * @return number of people allowed in the Room under COVID protocols
   */
  public int getCOVIDCapacity() {
    // checking if room capacity is even or odd
    if (occupants.length % 2 == 0) {
      // if even, just divide by 2
      return occupants.length / 2;
    } else {
      // if odd, need to add 1 more to room capacity
      return (occupants.length / 2) + 1;
    }
  }

  /**
   * Get number of people allowed in Room under normal condition
   * 
   * @return number of people allowed in Room under normal condition
   */
  public int getCapacity() {
    // returning the room capacity
    return occupants.length;
  }

  /**
   * Check if provided Person is present in the Room’s occupants array
   * 
   * @param p Object of a person
   * @return true if and only if the provided Person is present in the Room’s occupants array
   */
  public boolean contains(Person p) {
    // searching through occupants array for a specific person
    for (int i = 0; i < occupants.length; i++) {
      // checking if person is in room
      if (p.equals(occupants[i])) {
        // return true, if found in room
        return true;
      }
    }
    // return false, if not found in room
    return false;
  }

  /**
   * Get current list of Room names
   * 
   * @return current list of Room names
   */
  public static String[] getNames() {
    // initializing new array to have length of room names ArrayList
    String[] roomName = new String[names.size()];
    // looping through names of Room
    for (int i = 0; i < names.size(); i++) {
      // inputing the names of room from names ArrayList into an array
      roomName[i] = names.get(i);
    }
    // returning the copied array
    return roomName;
  }

  /**
   * Check if a Person was successfully added to Room
   * 
   * @param in object of a Person
   * @return true if and only if provided Person was successfully added to Room
   */
  public boolean checkIn(Person in) {
    // checking for number of people in room to not exceed COVID capacity
    if (currentOccupancy == getCOVIDCapacity()) {
      return false;
    }

    // checking to make sure inputed person is not null or haven't already registered
    if (in == null || contains(in)) {
      // if person is null or have already registered, throws IllegalArgumentException exception
      throw new IllegalArgumentException("Incorrect input");
    }

    // placing people in one room separate from each other
    for (int i = 0; i < occupants.length; i += 2) {
      // placing in empty rooms
      if (occupants[i] == null) {
        // placing people in, incrementing number of people in room, toggling the waiting status
        occupants[i] = in;
        currentOccupancy++;
        occupants[i].toggleWaiting();
        return true;
      }
    }
    // if people aren't placed in a room return false
    return false;

  }

  /**
   * Check if a Person was successfully removed from Room
   * 
   * @param out Object of a Person
   * @return true if and only if provided Person was successfully removed from Room
   */
  public boolean checkOut(Person out) {
    // checking to make sure inputed person is not null
    if (out == null) {
      // if null, throw IllegalArgumentException
      throw new IllegalArgumentException("Incorrect input");
    }

    // checking to see a particular person is in a room
    if (contains(out)) {
      for (int i = 0; i < occupants.length; i += 2) {
        if (occupants[i] == out) {
          // if the person is found, toggle the waiting status back to true, decrement number of
          // people in room, and make the room empty
          occupants[i].toggleWaiting();
          currentOccupancy--;
          occupants[i] = null;
          return true;
        }
      }
    }
    // person isn't successfully removed from room
    return false;
  }

  /**
   * Printing out the representation of a specific Room and its occupants
   * 
   * @return representation of Room and its occupants
   */
  public String toString() {
    // printing out in the room name
    String output = getName() + "\n===\n";
    int cap = getCapacity();
    // searching through room for its occupants
    for (int i = 0; i < occupants.length; i++) {
      // checking to make sure occupants are in room 
      if (occupants[i] != null) {
        // concatenating the occupant's name if there's still capacity to iterate
        output += occupants[i].getName() + "\n";
      } else {
        // concatenating the "-" to represent no occupants 
        output += "-\n";
      }
    }
    // returning the representation of a specific Room and its occupants
    return output;
  }
}
