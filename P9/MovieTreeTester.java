///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Movie Tree Tester
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

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 * 
 * @author waizin
 */
public class MovieTreeTester {

  /**
   * Checks the correctness of the implementation of both addMovie() and toString() methods
   * implemented in the MovieTree class. This unit test considers at least the following scenarios.
   * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
   * string representation is an empty string "". (2) try adding one movie and then check that the
   * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
   * called on the tree returns the expected output. (3) Try adding another movie which is smaller
   * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
   * root, (5) Try adding at least two further movies such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
   * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddMovieToStringSize() {
    try {
      // creating an empty movie tree
      MovieTree m = new MovieTree();

      // empty MovieTree, thus size must be 0
      if (m.size() != 0) {
        return false;
      }

      // checking for empty string when there is no movie
      if (!m.toString().equals("")) {
        return false;
      }

      // add 1 movie
      m.addMovie(new Movie(2018, 6.5, "Airplanes"));

      // 1 movie added to MovieTree, thus size must be 1
      if (m.size() != 1) {
        return false;
      }

      // checking for first movie added (root)
      String result = "[(Year: 2018) (Rate: 6.5) (Name: Airplanes)]\n";
      if (!m.toString().equals(result)) {
        return false;
      }

      // adding an older movie (smaller than the root)
      m.addMovie(new Movie(1988, 9.5, "Best"));

      // 1 more movie added to MovieTree, thus size must be 2
      if (m.size() != 2) {
        return false;
      }

      // checking for correctness of insertion of older movie (smaller than root)
      String result1 =
          "[(Year: 1988) (Rate: 9.5) (Name: Best)]\n[(Year: 2018) (Rate: 6.5) (Name: Airplanes)]\n";
      if (!m.toString().equals(result1)) {
        return false;
      }

      // adding an newer movie (greater than root)
      m.addMovie(new Movie(2019, 9.5, "GG"));

      // 1 more movie added to MovieTree, thus size must be 3
      if (m.size() != 3) {
        return false;
      }

      // checking for correctness of insertion of newer movie (greater than root)
      String result2 =
          "[(Year: 1988) (Rate: 9.5) (Name: Best)]\n[(Year: 2018) (Rate: 6.5) (Name: Airplanes)]\n[(Year: 2019) (Rate: 9.5) (Name: GG)]\n";
      if (!m.toString().equals(result2)) {
        return false;
      }

      // adding 3 movies such that one must be added at the left subtree, and the other at the right
      // subtree
      m.addMovie(new Movie(1964, 8, "OldestOne"));
      m.addMovie(new Movie(2021, 9.3, "YoungestOne"));
      m.addMovie(new Movie(2013, 7, "Titans"));


      // 3 more movie added to MovieTree, thus size must be 6
      if (m.size() != 6) {
        return false;
      }

      // initializing the desired output with result
      String result3 = "[(Year: 1964) (Rate: 8.0) (Name: OldestOne)]\n"
          + "[(Year: 1988) (Rate: 9.5) (Name: Best)]\n"
          + "[(Year: 2013) (Rate: 7.0) (Name: Titans)]\n"
          + "[(Year: 2018) (Rate: 6.5) (Name: Airplanes)]\n"
          + "[(Year: 2019) (Rate: 9.5) (Name: GG)]\n"
          + "[(Year: 2021) (Rate: 9.3) (Name: YoungestOne)]\n";

      // checking for correctness of insertion of 3 additional movie (2 lower, 1 bigger)
      if (!m.toString().equals(result3)) {
        return false;
      }

      // adding a movie already stored in the tree
      if (m.addMovie(new Movie(1964, 8, "OldestOne")) != false) {
        return false;
      }

      // size must remain size because it's not added (6)
      if (m.size() != 6) {
        return false;
      }
      // catching any broken cases to return false
    } catch (NoSuchElementException e) {
      return false;
    }
    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for
   * the movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
    try {
      // creating an empty tree
      MovieTree k = new MovieTree();

      // creating a movie to check for empty tree
      Movie x = new Movie(1963, 7, "O");

      // testing for contain in empty tree
      if (k.contains(x.getYear(), x.getRating(), x.getName())) {
        return false;
      }

      // creating a movie list with height of 3
      k.addMovie(new Movie(2000, 6, "The root"));
      k.addMovie(new Movie(1985, 7, "The Left"));
      k.addMovie(new Movie(2012, 4, "The Right"));
      k.addMovie(new Movie(1984, 7, "The Sub"));
      k.addMovie(new Movie(2014, 7, "The Far"));

      // checking for the root
      if (!k.contains(2000, 6, "The root")) {
        return false;
      }

      // checking for movie at right (successful)
      if (!k.contains(2012, 4, "The Right")) {
        return false;
      }

      // checking for movie at left (successful)
      if (!k.contains(1985, 7, "The Left")) {
        return false;
      }

      // checking for movie at far left (successful)
      if (!k.contains(1984, 7, "The Sub")) {
        return false;
      }

      // checking for movie at far right (successful)
      if (!k.contains(2014, 7, "The Far")) {
        return false;
      }

      // checking for movie at left (unsuccessful)
      if (k.contains(1984, 7, "The Eagle")) {
        return false;
      }

      // checking for movie at right (unsuccessful)
      if (k.contains(2012, 4, "The Warrior")) {
        return false;
      }
      // catching any broken cases to return false
    } catch (NoSuchElementException e) {
      return false;
    }
    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*) (*) /
   * (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    try {
      // creating an empty tree
      MovieTree f = new MovieTree();

      // checking for height of an empty tree (must be 0)
      if (f.height() != 0) {
        return false;
      }

      // adding a root to the empty tree
      f.addMovie(new Movie(1964, 8, "OldestOne"));

      // checking for height after only adding root
      if (f.height() != 1) {
        return false;
      }

      // creating a structure given by diagram
      f.addMovie(new Movie(1963, 5, "Right"));
      f.addMovie(new Movie(2001, 4.5, "Hello"));
      f.addMovie(new Movie(1963, 7.2, "Second"));
      f.addMovie(new Movie(2000, 4.5, "Less"));
      f.addMovie(new Movie(2003, 5, "Second Right"));
      f.addMovie(new Movie(2002, 9, "Last"));

      // checking if the tree structure given by the diagram above have height 4
      if (f.height() != 4) {
        return false;
      }
      // catching any broken cases to return false
    } catch (NoSuchElementException e) {
      return false;
    }

    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
    try {
      // creating an empty movie tree
      MovieTree o = new MovieTree();

      // checking for empty tree
      if (o.getBestMovie() != null) {
        return false;
      }

      // adding movies into movie tree
      o.addMovie(new Movie(2002, 9, "Titans"));
      o.addMovie(new Movie(2021, 4, "Latest"));
      o.addMovie(new Movie(2001, 4, "Leftist"));
      Movie d = new Movie(2032, 8, "Maximus");
      o.addMovie(d);
      o.addMovie(new Movie(1999, 3, "Far Left"));

      // testing for most recent movie
      if (!o.getBestMovie().equals(d)) {
        return false;
      }

      // testing for highest rated
      MovieTree w = new MovieTree();
      w.addMovie(new Movie(2021, 9, "Godzilla VS King Kong"));
      Movie latest = new Movie(2021, 10, "Unknown");
      w.addMovie(latest);
      w.addMovie(new Movie(2021, 10, "Anonymous"));

      // getting highest rated
      if (!w.getBestMovie().equals(latest)) {
        return false;
      }

      // catching any broken cases to return false
    } catch (NoSuchElementException e) {
      return false;
    }

    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when
   * called on a non empty movie tree with one match, and two matches and more. Vary your search
   * criteria such that the lookup() method must check in left and right subtrees. (3) Ensures that
   * the MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie
   * tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    try {
      // creating an empty tree
      MovieTree r = new MovieTree();

      // checking to throw NoSuchElementException for empty tree
      try {
        // checking for a movie in empty tree
        r.lookup(2015, 9);
        // return false if exception is not caught
        return false;
      } catch (NoSuchElementException e) {
      }

      // adding a movie (root)
      r.addMovie(new Movie(2021, 9, "Godzilla VS King Kong"));

      // creating an Array List to check with result
      ArrayList<Movie> g = new ArrayList<Movie>();

      // adding the expected result to created Array List
      g.add(new Movie(2021, 9, "Godzilla VS King Kong"));

      // checking to see if root can be checked
      if (!r.lookup(2021, 9).equals(g)) {
        return false;
      }

      // adding new movie to the right of tree
      r.addMovie(new Movie(2021, 10, "Here"));
      // adding new Movie to left of the tree
      r.addMovie(new Movie(2021, 3, "Not Here"));
      r.addMovie(new Movie(2021, 2, "Can not contain"));

      // adding movie that is suppose to be in Array List
      g.add(new Movie(2021, 10, "Here"));

      // checking if it right side of the movies are contain
      if (!r.lookup(2021, 9).equals(g)) {
        return false;
      }

      // creating a new Array List to add in pre-order order
      ArrayList<Movie> y = new ArrayList<Movie>();

      // adding in pre-order order
      y.add(new Movie(2021, 9, "Godzilla VS King Kong"));
      y.add(new Movie(2021, 3, "Not Here"));
      y.add(new Movie(2021, 2, "Can not contain"));
      y.add(new Movie(2021, 10, "Here"));

      // checking to see if pre-order match
      if (!r.lookup(2021, 1).equals(y)) {
        return false;
      }

      // checking for no search found (NoSuchElementException should be thrown)
      try {
        // checking for year that is not in tree
        r.lookup(2030, 5);
        return false;
        // return false if exception is not caught
      } catch (NoSuchElementException e) {
      }

      // catching any broken cases to return false
    } catch (NoSuchElementException e) {
      return false;
    }
    // return true if and only if all test methods succeed; false otherwise
    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    // calling the tester methods
    System.out.println("testAddMovieToStringSize(): " + testAddMovieToStringSize());
    System.out.println("testContains(): " + testContains());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testGetBestMovie(): " + testGetBestMovie());
    System.out.println("testLookup(): " + testLookup());
  }

}
