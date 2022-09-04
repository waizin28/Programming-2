///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Palindrome
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
 * This class contain mirrorA method with no step parameter (return a string that start at the
 * provided character and move backward to the beginning of the alphabet then move forward again to
 * the provided letter), mirrorA method with step parameter (return a string that start at the
 * provided character, and move back and forth to the beginning of the alphabet by steps of size
 * ​step), mirrorZ method with no step parameter (return a string that move forward to the end of
 * the alphabet, and then backward again to the provided letter), mirrorZ with step parameter
 * (return a string that move forward and back to the end of the alphabet by steps of size ​step​)
 * 
 * @author waizin
 *
 */
public class Palindrome {

  /**
   * Start at the provided character and move backward to the beginning of the alphabet then move
   * forward again to the provided letter
   * 
   * @param start the user input character to start this method from
   * @return string that has move backward to the beginning of the alphabet then move forward again
   *         to the provided letter
   * @throws IllegalArgumentException if non-capital letter character is inputed
   */
  public static String mirrorA(char start) throws IllegalArgumentException {
    // initializing the words variable to concatenate with result of recursion
    String words = "";

    // checking for capital input character
    if (!Character.isUpperCase(start)) {
      // throw IllegalArgumentException if the inputed character is not capital letter
      throw new IllegalArgumentException("The input character must be capital letter");
    }

    // base case (when the recursive algorithm has reach letter A, it will terminate)
    if (start == 'A') {
      words += "A";
      return words;
    } else {
      // from provided character, move backward to the beginning of the alphabet then move forward
      // again to the provided letter
      words += start + " " + mirrorA((char) (start - 1)) + " " + start;
    }

    // return the string that has move backward to the beginning of the alphabet then move forward
    // again to the provided letter
    return words;

  }

  /**
   * Start at the provided character, and move back and forth to the beginning of the alphabet by
   * steps of size ​step
   * 
   * @param start the user input character to start this method from
   * @param step  differences between each recursive alphabet
   * @return string that start at the provided character, and move back and forth to the beginning
   *         of the alphabet by steps of size ​step
   * @throws IllegalArgumentException if non-capital letter character is inputed or inputed step is
   *                                  0 or negative
   */
  public static String mirrorA(char start, int step) throws IllegalArgumentException {
    // initializing the words variable to concatenate with result of recursion
    String words = "";

    // checking for capital input character and input step number to be not 0 or negative
    if (!Character.isUpperCase(start) || step <= 0) {
      // throw IllegalArgumentException if the inputed character is not capital letter or when input
      // step number is 0 or negative
      throw new IllegalArgumentException(
          "The input character must be capital letter and step must not be negative or 0");
    }

    // first base case (when the recursive algorithm has reach letter A, it will terminate)
    if (start == 'A') {
      words += 'A';
      return words;
      // second base case (when the subtraction of start and step become less than letter A's ASCII
      // value, this check will return two letter before passing that limit)
    } else if (start - step < 'A') {
      words += start + " " + start;
      return words;
      // keep recursing the character (move toward A) until it fulfill one of the base case
    } else {
      words += start + " " + mirrorA((char) (start - step), step) + " " + start;
    }
    // return a string that start at the provided character, and move back and forth to the
    // beginning of the alphabet by steps of size ​step
    return words;
  }

  /**
   * Start at the provided character, and move forward to the end of the alphabet, and then backward
   * again to the provided letter
   * 
   * @param start the user input character to start this method from
   * @return string that move forward to the end of the alphabet, and then backward again to the
   *         provided letter
   * @throws IllegalArgumentException if non-capital letter character is inputed
   */
  public static String mirrorZ(char start) throws IllegalArgumentException {
    // initializing the words variable to concatenate with result of recursion
    String words = "";

    // checking for capital input character
    if (!Character.isUpperCase(start)) {
      // throw IllegalArgumentException if the inputed character is not capital letter
      throw new IllegalArgumentException("The input character must be capital letter");
    }

    // base case (when the recursive algorithm has reach letter Z, it will terminate)
    if (start == 'Z') {
      words += "Z";
      return words;
    } else {
      // recursive case (from provided character move forward to the end of the alphabet, and then
      // backward again to the provided letter)
      words += start + " " + mirrorZ((char) (start + 1)) + " " + start;
    }
    // return a string that has been move forward to the end of the alphabet, and then backward
    // again to the provided letter
    return words;
  }

  /**
   * Start at the provided character, and move forward and back to the end of the alphabet by steps
   * of size ​step
   * 
   * @param start the user input character to start this method from
   * @param step  differences between each recursive alphabet
   * @return string that start at the provided character, and move forward and back to the end of
   *         the alphabet by steps of size ​step
   * @throws IllegalArgumentException IllegalArgumentException if non-capital letter character is
   *                                  inputed or inputed step is 0 or negative
   */
  public static String mirrorZ(char start, int step) throws IllegalArgumentException {
    // initializing the words variable to concatenate with result of recursion
    String words = "";

    // checking for capital input character and input step number to be not 0 or negative
    if (!Character.isUpperCase(start) || step <= 0) {
      // throw IllegalArgumentException if the inputed character is not capital letter or when input
      // step number is 0 or negative
      throw new IllegalArgumentException(
          "The input character must be capital letter and step must not be negative or 0");
    }

    // first base case (when the recursive algorithm has reach letter Z, it will terminate)
    if (start == 'Z') {
      words += 'Z';
      return words;
      // second base case (when the addition of start and step become more than letter Z's ASCII
      // value, this check will return two letter before passing that limit)
    } else if (start + step > 'Z') {
      words += start + " " + start;
      return words;
      // keep recursing the character (move toward Z) until it fulfill one of the base case
    } else {
      words += start + " " + mirrorZ((char) (start + step), step) + " " + start;
    }
    // return a string that start at the provided character, and move forward and back to the end of
    // the alphabet by steps of size ​step
    return words;
  }

}
