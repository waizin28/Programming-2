///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Movie Tree
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
 * This class contains isEmpty(check if MovieTree is empty), size (to get size of the MovieTree),
 * addMovie and addMovieHelper (to add new Movie to MovieTree), toString and toStringHelper (to
 * print out the MovieTree is in-order), height and heightHelper (to get height of MovieTree),
 * getBestMovie (to get the best (largest) movie (the most recent, highest rated, and having the
 * largest name)), lookup and lookupHelper (to search for movie in MovieTree that have same year and
 * rating greater than or equal to specified year and rating).
 * 
 * @author waizin
 *
 */
public class MovieTree {

  private BSTNode<Movie> root; // root of this movie BST
  private int size; // size of this movie tree

  /**
   * Checks whether this binary search tree (BST) is empty
   * 
   * @return true if this MovieTree is empty, false otherwise
   */
  public boolean isEmpty() {
    // checking the size of the tree to be 0
    if (size == 0) {
      // return true if 0, indicating that tree is empty
      return true;
    }
    // return false if not 0, indicating that tree is not empty
    return false;
  }

  /**
   * Returns the number of movies stored in this BST.
   * 
   * @return the size of this MovieTree
   */
  public int size() {
    // return the appropriate size of the tree
    return this.size;
  }


  /**
   * Adds a new movie to this MovieTree
   * 
   * @param newMovie a new movie to add to this BST.
   * @return true if the newMovie was successfully added to this BST, and returns false if there is
   *         a match with this movie already stored in this BST.
   */
  public boolean addMovie(Movie newMovie) {
    // checking if movie with same year, rating, name has been added, if so return false
    if (contains(newMovie.getYear(), newMovie.getRating(), newMovie.getName())) {
      return false;
    }

    // checking if tree is empty
    if (isEmpty()) {
      // add newMovie to root of the tree
      root = new BSTNode<Movie>(newMovie);
      // increment size of tree
      this.size++;
      return true;
    } else { // add newMovie to an non-empty MovieTree
      // increment size of tree
      this.size++;
      // return the appropriate boolean according to addMovieHelper
      return addMovieHelper(newMovie, root);
    }
  }

  /**
   * Recursive helper method to add a new movie to a MovieTree rooted at current.
   * 
   * @param current  The "root" of the subtree we are inserting new movie into.
   * @param newMovie The movie to be added to a BST rooted at current.
   * @return true if the newMovie was successfully added to this MovieTree, false otherwise
   */
  protected static boolean addMovieHelper(Movie newMovie, BSTNode<Movie> current) {
    // when have same movie, same rate, same date, return false
    if (current.getData().compareTo(newMovie) == 0) { // base case
      return false;
    } else if (newMovie.compareTo(current.getData()) > 0) {
      // Case: newMovie > current (add to right)
      // add to the right is there is a space in tree
      if (current.getRight() == null) {
        current.setRight(new BSTNode<Movie>(newMovie));
      }
      // keep updating children at right side
      addMovieHelper(newMovie, current.getRight());
    } else {
      // Case: newMovie < current (add to left)
      // add to the left is there is a space in tree
      if (current.getLeft() == null) {
        current.setLeft(new BSTNode<Movie>(newMovie));
      }
      // keep updating children at left side
      addMovieHelper(newMovie, current.getLeft());
    }

    // true if the newMovie was successfully added to this MovieTree, false otherwise
    return true;
  }

  /**
   * Returns a String representation of all the movies stored within this BST in the increasing
   * order, separating by a newline "\n". For instance
   * 
   * "[(Year: 1988) (Rate: 7.0) (Name: Light Years)]" + "\n" + "[(Year: 2015) (Rate: 6.5) (Name:
   * Cinderella)]" + "\n"
   * 
   * @return a String representation of all the movies stored within this BST sorted in an
   *         increasing order with respect to the result of Movie.compareTo() method (year, rating,
   *         name). Returns an empty string "" if this BST is empty.
   */
  @Override
  public String toString() {
    // return the appropriate String according to toStringHelper
    return toStringHelper(root);
  }

  /**
   * Recursive helper method which returns a String representation of the BST rooted at current. An
   * example of the String representation of the contents of a MovieTree is provided in the
   * description of the above toString() method.
   * 
   * @param current reference to the current movie within this BST (root of a subtree)
   * @return a String representation of all the movies stored in the sub-tree rooted at current in
   *         increasing order with respect to the result of Movie.compareTo() method (year, rating,
   *         name). Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Movie> current) {

    // checking if current is null
    if (current == null)
      // return "" if empty
      return "";

    // initializing result to be added
    String result = "";

    // returning in-order (increasing) tree

    // Base case - don't do anything, specifically have leaf node in base case so just add my own
    // data and return result
    // leaf node is a node that don't have children so both left and right would be null
    if (current.getLeft() != null) {
      // getting all the children at left
      result += toStringHelper(current.getLeft());;
    }

    // add the root after all the left side have been taken care of
    result += current.getData().toString() + "\n";

    // add right subtree's toString
    if (current.getRight() != null) {
      // getting all the children at right
      result += toStringHelper(current.getRight());
    }

    // returning the tree in increasing order
    return result;
  }

  /**
   * Computes and returns the height of this BST, counting the number of NODES from root to the
   * deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    // return the appropriate integer according to heightHelper
    return heightHelper(root);
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current counting the
   * number of nodes and NOT the number of edges from current to the deepest leaf
   * 
   * @param current pointer to the current BSTNode within a MovieTree (root of a subtree)
   * @return height of the subtree rooted at current
   */
  protected static int heightHelper(BSTNode<Movie> current) {
    // height will just return 0 if tree empty
    if (current == null) {
      return 0;
    }

    // keep track of number of children at farthest right
    int rightSide = heightHelper(current.getRight());

    // keep track of number of children at farthest left
    int leftSide = heightHelper(current.getLeft());

    // get the maximum of the number of children at right and left and add 1 (the root)
    return Math.max(rightSide, leftSide) + 1;

  }

  /**
   * Checks whether this MovieTree contains a movie given its name, production year, and rating.
   * 
   * @param year   year of production of the movie to search
   * @param rating rating of the movie to search
   * @param name   name of the movie to search
   * @return true if there is a match with this movie in this BST, and false otherwise
   */
  public boolean contains(int year, double rating, String name) {
    // return the appropriate boolean according to containsHelper
    return containsHelper(new Movie(year, rating, name), root);
  }

  /**
   * Recursive helper method to search whether there is a match with a given movie in the subtree
   * rooted at current
   * 
   * @param target  a reference to a movie we are searching for a match in the BST rooted at
   *                current.
   * @param current "root" of the subtree we are checking whether it contains a match to target.
   * @return true if match found and false otherwise
   */
  protected boolean containsHelper(Movie target, BSTNode<Movie> current) {

    // if current is null or size is 0 (meaning tree is empty), return false
    if (current == null || isEmpty()) {
      return false;
    }

    // check if current matches the target
    if (current.getData().compareTo(target) == 0) { // base case
      return true;
    } else if (current.getData().compareTo(target) < 0) {
      // data < target, check the right subtree
      if (current.getRight() == null) { // base case
        return false;
      }
      // keep updating the right children
      return containsHelper(target, current.getRight());
    } else {
      // data > target, check the left subtree
      if (current.getLeft() == null) {
        return false;
      }
      // keep updating the left children
      return containsHelper(target, current.getLeft());
    }

  }


  /**
   * Gets the best (maximum) movie in this BST
   * 
   * @return the best (largest) movie (the most recent, highest rated, and having the largest name)
   *         in this MovieTree, and null if this tree is empty.
   */
  public Movie getBestMovie() {

    // returning null if the tree is empty
    if (isEmpty()) {
      return null;
    }

    // if only 1 node then the root will be returned
    BSTNode<Movie> max = root;

    // checking if the current max have right leaves
    while (max.getRight() != null) {
      // finding the farthest right leaf since the tree is already sorted
      max = max.getRight();
    }

    // returning the max node
    return max.getData();
  }


  /**
   * Search for movies given the year and minimum rating as lookup key.
   * 
   * @param year   production year of a movie
   * @param rating rating value of a movie
   * @return a list of movies whose year equals our lookup year key and having a rating greater or
   *         equal to a given rating.
   * @throws a NoSuchElementException with a descriptive error message if there is no Movie found in
   *           this BST having the provided year and a rating greater or equal to the provided
   *           rating
   */
  public ArrayList<Movie> lookup(int year, double rating) {

    // call lookupHelper given the year, rating, the root of this MovieTree and an empty arrayList)
    // creating an empty Array List to put in lookupHelper method
    ArrayList<Movie> list = new ArrayList<Movie>();

    // update the list Array List with searches
    lookupHelper(year, rating, root, list);

    // if no match found by the lookupHelper throw a NoSuchElementException with a descriptive error
    // message
    if (list.size() == 0) {
      // throw NoSuchElementExxception if no movie is found
      throw new NoSuchElementException("Can't find any movie");
    }

    // return a list of movies whose year equals our lookup year key and having a rating greater or
    // equal to a given rating.
    return list;
  }

  /**
   * Recursive helper method to lookup the list of movies given their year of production and a
   * minimum value of rating
   * 
   * @param year      the year we would like to search for a movie
   * @param rating    the minimum rating we would like to search for a movie
   * @param movieList an arraylist which stores the list of movies matching our search criteria
   *                  (exact year of production and having at least the provided rating) within the
   *                  subtree rooted at current
   * @param current   "root" of the subtree we are looking for a match to find within it.
   */
  protected void lookupHelper(int year, double rating, BSTNode<Movie> current,
      ArrayList<Movie> movieList) {

    // if the BST rooted at current is null, do nothing and return
    if (current == null) {
      return;
    }

    // if the BST rooted at current is not empty, perform a pre-order traversal of the subtree
    // starting from current looking for movies satisfying our search criteria, and add each of them
    // to the movieList
    else {

      // base case: add to Array List if current year is equal to given year and current rating is
      // greater than or equal to given rating
      if (current.getData().getYear() == year && current.getData().getRating() >= rating) {
        movieList.add(current.getData());
      }

      // keep checking at left side until null is encountered
      if (current.getLeft() != null) {
        // keep updating left children
        lookupHelper(year, rating, current.getLeft(), movieList);
      }

      // keep checking at right side until null is encountered
      if (current.getRight() != null) {
        // keep updating right children
        lookupHelper(year, rating, current.getRight(), movieList);
      }
    }
  }
}
