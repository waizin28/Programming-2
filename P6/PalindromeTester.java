///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Palindrome Tester
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
 * This class check whether the execution of MirrorA (with and without step parameter) and MirrorZ
 * (with and without step) are correct or not
 * 
 * @author waizin
 *
 */
public class PalindromeTester {

  /**
   * Testing for all different cases (non-capital input and functioning of mirrorA method) of
   * mirrorA method without step parameter
   * 
   * @return true if MirrorA method pass all the test perfectly
   */
  public static boolean testMirrorA() {

    // testing for exception of non-capital letter input
    try {
      Palindrome.mirrorA('q');
      // will return false if exception is not caught
      return false;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    // testing if the given character move backward to beginning of alphabet and then move forward
    String answer = "F E D C B A B C D E F";
    String result = Palindrome.mirrorA('F');
    if (!answer.equals(result)) {
      return false;
    }

    // return true if all the test cases are executed correctly
    return true;

  }

  /**
   * Testing for all different cases (non-capital input, zero step input, negative step and the
   * execution of mirrorA with different step) of mirrorA method with step parameter
   * 
   * @return true if all MirrorA method pass all the test perfectly
   */
  public static boolean testMirrorAStep() {

    // testing for exception of non-capital letter input
    try {
      Palindrome.mirrorA('f', 6);
      // will return false if exception is not caught
      return false;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    // testing for exception of zero step input
    try {
      Palindrome.mirrorA('F', 0);
      // will return false if exception is not caught
      return false;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    // testing for exception of negative step
    try {
      Palindrome.mirrorA('F', -1);
      // will return false if exception is not caught
      return false;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }


    // testing for step 1 with alphabet E
    String answer = "E D C B A B C D E";
    String result = Palindrome.mirrorA('E', 1);
    if (!answer.equals(result)) {
      return false;
    }

    // testing for step 2 with alphabet E
    String answer2 = "E C A C E";
    String result2 = Palindrome.mirrorA('E', 2);
    if (!answer2.equals(result2)) {
      return false;
    }

    // testing for step 3 with alphabet E
    String answer3 = "E B B E";
    String result3 = Palindrome.mirrorA('E', 3);
    if (!answer3.equals(result3)) {
      return false;
    }

    // return true if all the test cases are executed correctly
    return true;

  }

  /**
   * Testing for all different cases (non-capital input and functioning of mirrorZ method) of
   * mirrorZ method without step parameter
   * 
   * @return true if MirrorZ method pass all the test perfectly
   */
  public static boolean testMirrorZ() {
    // testing for exception of non-capital letter input
    try {
      Palindrome.mirrorZ('v');
      // will return false if exception is not caught
      return false;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    // testing if the given character move backward to beginning of alphabet and then move forward
    String answer = "V W X Y Z Y X W V";
    String result = Palindrome.mirrorZ('V');
    if (!answer.equals(result)) {
      return false;
    }

    // return true if all the test cases are executed correctly
    return true;
  }

  /**
   * Testing for all different cases (non-capital input, zero step input, negative step and the
   * execution of mirrorZ with different step) of mirrorZ method with step parameter
   * 
   * @return true if all MirrorZ method pass all the test perfectly
   */
  public static boolean testMirrorZStep() {

    // testing for exception of non-capital letter input
    try {
      Palindrome.mirrorZ('v', 6);
      // will return false if exception is not caught
      return false;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    // testing for exception of zero step input
    try {
      Palindrome.mirrorZ('V', 0);
      // will return false if exception is not caught
      return false;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    // testing for exception of negative step
    try {
      Palindrome.mirrorZ('V', -2);
      // will return false if exception is not caught
      return false;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }


    // testing for step 1 with alphabet E
    String answer = "V W X Y Z Y X W V";
    String result = Palindrome.mirrorZ('V', 1);
    if (!answer.equals(result)) {
      return false;
    }

    // testing for step 2 with alphabet E
    String answer2 = "V X Z X V";
    String result2 = Palindrome.mirrorZ('V', 2);
    if (!answer2.equals(result2)) {
      return false;
    }

    // testing for step 3 with alphabet E
    String answer3 = "V Y Y V";
    String result3 = Palindrome.mirrorZ('V', 3);
    if (!answer3.equals(result3)) {
      return false;
    }

    // return true if all the test cases are executed correctly
    return true;
  }

  /**
   * Call all the testing methods to verify the correctness of all test methods
   * 
   * @return true if all test methods pass all the test perfectly
   */
  public static boolean runAllTests() {

    // calling for testing method of MirrorA without step
    if (!testMirrorA()) {
      // will return false if MirrorA method without step as its parameter is not executed correctly
      return false;
    }

    // calling for testing method of MirrorA with step
    if (!testMirrorAStep()) {
      // will return false if MirrorA method with step as its parameter is not executed correctly
      return false;
    }

    // calling for testing method of MirrorZ without step
    if (!testMirrorZ()) {
      // will return false if MirrorZ method without step as its parameter is not executed correctly
      return false;
    }

    // calling for testing method of MirrorA with step
    if (!testMirrorZStep()) {
      // will return false if MirrorZ method with step as its parameter is not executed correctly
      return false;
    }

    // return true if all the test cases are executed correctly
    return true;
  }

  /**
   * Call runAllTests method which check the correctness of Palindrome class's methods
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("runAllTests() " + runAllTests());
  }

}
