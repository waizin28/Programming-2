///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Simple Bag
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
import java.util.Random;
import java.util.Scanner;

/**
 * This class contains constructor of SimpleBag (initialize SimpleBag fields), loadData method (to
 * read words from file to array data by shifting N+1), removeRandom method (to remove String at
 * randomly generated index at 0 and number of Strings stored in this bag)
 * 
 * @author waizin
 *
 */
public class SimpleBag {

  protected String[] data; // creating an array to store string
  protected Random random; // creating random generator object

  /**
   * Constructor for SimpleBag class
   * 
   * @param seed user input value seed for random generator
   */
  public SimpleBag(int seed) {
    // initializing data array capacity with 80000
    data = new String[80000];
    // initializing random object with provided seed
    random = new Random(seed);
  }

  /**
   * Reads in the text contents of the provided file, inserting each new space-separated word at the
   * beginning of the data array. All strings currently in the array should be shifted to the right
   * by one index to make room, the string at index N should be moved to index N+1.
   * 
   * Complexity: O(N)
   * 
   * @param f name of the file to import
   */
  public void loadData(File f) {
    // creating scanner variable
    Scanner scan;
    // handling exception for reading file
    try {
      // initializing for scanner
      scan = new Scanner(f);
      // avoid reading the first integer line
      scan.nextLine();
      // checking if there are string left in text file
      while (scan.hasNext()) {
        for (int i = data.length - 1; i > 0; i--) {
          // moving the string to index N+1
          data[i] = data[i - 1];
        }
        // placing new string at beginning of array
        data[0] = scan.next();
      }
      // checking for FileNotFoundException
    } catch (FileNotFoundException e) {
      // return if encounter exception while reading
      return;
    }
  }

  /**
   * Remove a string from data array using random random index between 0 and the number of Strings
   * stored in this bag (exclusive). This method also fill fills gaps by moving all following
   * strings to the left by one index. N -> N-1, etc.
   * 
   * Complexity: O(N^2)
   * 
   * @return string at randomly removed index
   */
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
    // using random generator to get random index based on count to remove
    int index = random.nextInt(count);
    // get string at that index
    String s = data[index];

    // filling gap by moving string to left by one index
    for (int i = index; i < data.length - 1; i++) {
      data[i] = data[i + 1];
    }
    // returning the string that has been removed
    return s;
  }

}
