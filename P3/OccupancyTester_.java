///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Occupancy Tester
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
 * This class contains methods to check for methods of Person and Room class
 * 
 * @author waizin
 *
 */
class OccupancyTester​ {

  public static boolean testPerson() {
    // creating instances of Person object
    Person p1 = new Person("John");
    Person p2 = new Person(p1.getName());
    Person p3 = new Person("Winston");

    // testing for getName method
    if (p1.getName() != "John") {
      System.out.println("Error in getName method");
      return false;
    }

    // testing for getName method
    if (p3.getName() != "Winston") {
      System.out.println("Error in getName method");
      return false;
    }

    // testing for isWaiting method
    if (p1.isWaiting() != true) {
      System.out.println("Error in isWaiting method");
      return false;
    }

    // testing for toggleWaiting method - flip to false
    p1.toggleWaiting();
    if (p1.isWaiting() != false) {
      System.out.println("Error in toggleWaiting method, unable to flip to false");
      return false;
    }

    // testing for toggleWaiting method - flip to true
    p1.toggleWaiting();
    if (p1.isWaiting() != true) {
      System.out.println("Error in toggleWaiting method, unable to flip to true");
      return false;
    }

    // testing for equals method, different names
    if (p1.equals(p3)) {
      System.out.println("Error in equals method");
      return false;
    }


    // testing for equals method, same object
    if (!p1.equals(p2)) {
      System.out.println("Error in equals method");
      return false;
    }

    // testing for equals method, with String object
    if (p1.equals("John")) {
      System.out.println("Error in equals method");
      return false;
    }

    // if all of the tests above execute successfully, return true
    return true;
  }

  public static boolean testRoomConstructor() {
    Room r1 = new Room("CS 1240", 5);
    Room r2 = new Room("CS 5693", 7);

    // checking accessors give you different value
    String room1 = r1.getName();
    String room2 = r2.getName();
    if (room1.equals(room2)) {
      System.out.println("Error with Room's constructor name");
      return false;
    }

    // checking two ​Rooms ​with the same name can be created
    Room r3 = new Room("SameName", 8);
    try {
      Room r4 = new Room("SameName", 5);
    } catch (IllegalArgumentException e) {
      System.out.println("Two room with same name can't be created");
    }

    // checking if names array is in the correct order
    String[] room = {"CS 1240", "CS 5693"};
    String[] check = r2.getNames();
    for (int i = 0; i < room.length; i++) {
      if (room[i].equals(check[i])) {
        return true;
      } else {
        System.out.println("Arrays not consistent");
        return false;
      }
    }
    return true;
  }

  public static boolean testRoomAccessors() {
    Room r1 = new Room("JJJ", 8);
    Room r2 = new Room("KK", 3);

    // checking for room name
    if (!r1.getName().equals("JJJ")) {
      System.out.println("Room name not same");
      return false;
    }

    // checking for occupancy
    Person p1 = new Person("Tom");
    Person p2 = new Person("James");
    r1.checkIn(p1);
    r1.checkIn(p2);
    if (r1.getOccupancy() != 2) {
      System.out.println("Incorrect Occupancy method");
      return false;
    }

    // checking for COVID Capacity
    if (r1.getCOVIDCapacity() != 4) {
      System.out.println("Incorrect COVID Capacity");
      return false;
    }

    // checking for normal capacity
    if (r1.getCapacity() != 8) {
      System.out.println("Incorrect Capacity");
      return false;
    }

    // checking for contains method
    if (!r1.contains(p1)) {
      System.out.println("Incorrect contains method");
      return false;
    }

    return true;
  }

  public static boolean testRoomCheckIn() {
    Room r = new Room("JJ", 4);
    Person p = new Person(null);
    // checking for null
    try {
      r.checkIn(null);
    } catch (IllegalArgumentException e) {
      System.out.println("Can't input null person");
    }

    // checking for person already contain in room
    Room newR = new Room("H", 8);
    Person p1 = new Person("KK");
    Person p2 = new Person("KK");
    newR.checkIn(p1);
    try {
      newR.checkIn(p2);
    } catch (IllegalArgumentException e) {
      System.out.println("Can't input same person twice");
    }

    // checking for successfully placing person in room
    Room rt = new Room("U", 6);
    Person x = new Person("k");
    Person y = new Person("J");
    Person z = new Person("P");
    Person o = new Person("W");
    rt.checkIn(x);
    if (!rt.checkIn(y)) {
      System.out.println("Person 2 isn't checked into room");
      return false;
    }

    // checking to make sure person in a room is being incremented
    if (rt.getOccupancy() != 2) {
      System.out.println("Number of person in a room isn't incremented");
      return false;
    }
    rt.checkIn(z);
    // checking for room limit to be equal to COVIDCapacity
    if (rt.checkIn(o)) {
      System.out.println("Person 3 is checked into room despite COVIDCapacity");
    }

    // checking for toggle status (got the room)
    if (x.isWaiting() != false) {
      System.out.println("Toggle1 failed");
      return false;
    }

    // checking for toggle status (doesn't get a room)
    if (o.isWaiting() != true) {
      System.out.println("Toggle2 failed");
      return false;
    }

    return true;
  }

  public static boolean testRoomCheckOut() {
    // checking for null person
    Room rk = new Room("I", 8);
    try {
      rk.checkOut(null);
    } catch (IllegalArgumentException e) {
      System.out.println("Can't put null person");
    }

    // checking for successfully checked out
    Room newR = new Room("CJ", 8);
    Person p = new Person("John");
    Person p1 = new Person("Sammy");
    Person p2 = new Person("Mia");
    newR.checkIn(p);
    newR.checkIn(p1);
    newR.checkIn(p2);

    if (!newR.checkOut(p)) {
      System.out.println("Person isn't successfully check out");
      return false;
    }

    // checking for reduce occupancy
    if (newR.getOccupancy() != 2) {
      System.out.println("Number of person in room isn't reduced");
      return false;
    }
    return true;
  }

  public static boolean testRoomToString() {
    Room newRoom = new Room("Room", 6);
    Person k = new Person("Burman");
    Person r = new Person("Benette");
    Person p = new Person("Arthur");
    newRoom.checkIn(k);
    newRoom.checkIn(r);
    newRoom.checkIn(p);
    String g = "Room\n===\nBurman\n-\nBenette\n-\nArthur\n-\n";
    // checking for correct "\n" placements
    if (!g.equals(newRoom.toString())) {
      System.out.println("ToString method error");
      return false;
    }

    newRoom.checkOut(r);
    String v = "Room\n===\nBurman\n-\n-\n-\nArthur\n-\n";
    // checking for "-" for vacant rooms
    if (!v.equals(newRoom.toString())) {
      System.out.println("Can't make vacnats room -");
      return false;
    }

    return true;
  }

  /**
   * Call testing methods for Person and Room methods
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("testPerson()" + testPerson());
    System.out.println("testRoomConstructor()" + testRoomConstructor());
    System.out.println("testRoomAccessors()" + testRoomAccessors());
    System.out.println("testRoomCheckIn()" + testRoomCheckIn());
    System.out.println("testRoomCheckOut()" + testRoomCheckOut());
    System.out.println("testRoomToString()" + testRoomToString());
  }

}
