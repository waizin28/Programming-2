///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Benchmark
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
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class contains compareLoadData which track the time spent in milliseconds to complete each
 * loadData(), compareRemove method which tracks the time spent in milliseconds to complete each
 * type of remove method, and createResultFile which writes the results of compareLoadData and
 * compareRemove into a file
 * 
 * @author waizin
 *
 */
public class Benchmark {

  /**
   * Compare the time spent in milliseconds to complete each loadData() of CleverBag and
   * SimpleBag class. Returns a formatted String with the elapsed times for each of the bag types.
   * 
   * @param f name of a File
   * @param s object of SimpleBag class
   * @param c object of CleverBag class
   * @return a formatted String with the elapsed times for each of the bag types
   */
  public static String compareLoadData(File f, SimpleBag s, CleverBag c) {
    // get start time of loadData method of SimpleBag
    long startSimple = System.currentTimeMillis();
    // calling loadData method of SimpleBag
    s.loadData(f);
    // get end time of loadData method of SimpleBag
    long endSimple = System.currentTimeMillis();

    // get start time of loadData method of CleverBag
    long startClever = System.currentTimeMillis();
    // calling loadData method of CleverBag
    c.loadData(f);
    // get end time of loadData method of CleverBag
    long endClever = System.currentTimeMillis();

    // calculating for time took to execute loadData method of SimpleBag
    long simpleBagLoadTime = endSimple - startSimple;
    // calculating for time took to execute loadData method of CleverBag
    long cleverBagLoadTime = endClever - startClever;

    // returning in a formatted String format of total time took for loadData method of SimpleBag
    // and loadData method of CleverBag
    return "load:\t" + simpleBagLoadTime + "\t" + cleverBagLoadTime + "\n";
  }

  /**
   * Compare the time spent in milliseconds to complete each removeRandom() of CleverBag
   * and SimpleBag class. Returns a formatted String with n and the elapsed times for each of the
   * bag types.
   * 
   * 
   * @param n call method n times
   * @param s object of SimpleBag class
   * @param c object of CleverBag class
   * @return a formatted string with n and the elapsed times for each of the bag types
   */
  public static String compareRemove(int n, SimpleBag s, CleverBag c) {

    // initializing quaries array
    int[] quaries = new int[n];
    // initializing simpleBagRemoveTime variable
    long simpleBagRemoveTime = 0;
    // initializing cleverBagRemoveTime variable
    long cleverBagRemoveTime = 0;

    // initializing startSimpleRemove variable
    long startSimpleRemove = 0;
    // initializing endSimpleRemove variable
    long endSimpleRemove = 0;

    // looping n time for simple class remove method
    for (int i = 0; i < n; i++) {
      // get start time of removeRandom method of SimpleBag
      startSimpleRemove = System.currentTimeMillis();
      // calling removeRandom method of SimpleBag
      s.removeRandom();
      // get end time of removeRandom method of SimpleBag
      endSimpleRemove = System.currentTimeMillis();
      // calculating for total time took to execute removeRandom method of SimpleBag
      simpleBagRemoveTime += endSimpleRemove - startSimpleRemove;
    }

    // initializing startCleverRemove variable
    long startCleverRemove = 0;
    // initializing startCleverRemove variable
    long endCleverRemove = 0;

    // looping n time for clever class remove method
    for (int i = 0; i < n; i++) {
      // get start time of removeRandom method of CleverBag
      startCleverRemove = System.currentTimeMillis();
      // calling removeRandom method of CleverBag
      c.removeRandom();
      // get end time of removeRandom method of CleverBag
      endCleverRemove = System.currentTimeMillis();
      // calculating for total time took to execute removeRandom method of CleverBag
      cleverBagRemoveTime += endCleverRemove - startCleverRemove;
    }

    // returning in a formatted String format of total time took for removeRandom method of
    // SimpleBag and removeRandom method of CleverBag
    return quaries.length + "\t" + simpleBagRemoveTime + "\t" + cleverBagRemoveTime + "\n";
  }

  /**
   * Compare compareLoadData() to the two different data loads using the in parameter. Calls
   * compareRemove() on each of the provided nValues to compare the two different remove
   * implementations. Writes the results of the data load comparison followed by the remove
   * comparisons to a file specified by the out parameter.
   * 
   * @param in      file name to read
   * @param out     file name to write
   * @param nValues total numbers of times to loop compareRemove method
   */
  public static void createResultsFile(File in, File out, int[] nValues) {
    // creating instance of SimpleBag
    SimpleBag g = new SimpleBag(100);
    CleverBag c = new CleverBag(100);

    // saving the compareLoadData into a string
    String save = compareLoadData(in, g, c);

    // calling compareRemove() on each of the provided nValues
    for (int i = 0; i < nValues.length; i++) {
      // saving the compareRemove into a string
      save += compareRemove(nValues[i], g, c);
    }

    // handling the exception of printWriter
    try {

      // creating a fileWriter
      FileWriter p = new FileWriter(out);

      // writing string of answers from string format
      p.write(save);

      // closing printWriter
      p.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * To test whether the above methods are working as intended
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    File f = new File("frank.txt");
    File r = new File("result.txt");
    int[] v = {10, 100, 1000, 10000};
    createResultsFile(f, r, v);

  }

}
