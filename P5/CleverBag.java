///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Clever Bag
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class contains constructor of CleverBag (initialize CleverBag fields and call super
 * constructor), loadData method (to read words from file to array data reversely and increment
 * size), removeRandom method (to remove String at randomly generated index at 0 and current size)
 * 
 * @author waizin
 *
 */
public class CleverBag extends SimpleBag {

  private int size; // track the current number of initialized Strings in the parent class’ data
                    // array

  /**
   * Constructor for CleverBag class
   * 
   * @param seed user input value seed for random generator
   */
  public CleverBag(int seed) {
    // calling super class constructor
    super(seed);
    // Initializing size
    size = 0;
  }

  /**
   * Inserts the new words at the end of the array and then updates the size field accordingly.
   * 
   * Complexity: O(1)
   * 
   * @param f name of the file to import
   */
  @Override
  public void loadData(File f) {
    // creating scanner variable
    Scanner scan;
    try {
      // initializing scanner
      scan = new Scanner(f);
    } catch (FileNotFoundException e) {
      return;
    }

    // avoid reading the first integer line
    scan.nextLine();
    // checking if there are string left in text file
    while (scan.hasNext()) {
      // putting new word at end of the array
      data[size] = scan.next();
      // incrementing the size
      size++;
    }
  }

  /**
   * Removes and returns the String at randomly generated integer between 0 and the current size.
   * Fills gaps by moving the last String into the gap and decrementing size. If the bag contains no
   * strings, this method returns null.
   * 
   * Complexity: O(N)
   * 
   * @return string at randomly removed index
   */
  @Override
  public String removeRandom() {

    // initializing counter
    int count = 0;
    // checking for non-null values in data array
    for (int i = 0; i < data.length; i++) {
      // checking for not null
      if (data[i] != null) {
        // iterate data array's string is not null
        count++;
      }
    }

    // if bag contains no string, return null
    if (count == 0) {
      return null;
    }

    // creating random variable by using size
    int index = random.nextInt(size);

    // replacing randomly generated index with last String and decrementing size
    String s = data[index];
    data[index] = data[count - 1];
    data[count - 1] = null;
    size--;

    // returning randomly generated index's removed string
    return s;
  }
}
