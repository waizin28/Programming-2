///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Memory Game
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
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class contains methods that can setup for the matching card game, register for "N" or "n"
 * key-press, restart new game, display output message, identify for mouse and mouse press, and
 * match cards
 * 
 * @author waizin
 */
public class MemoryGame {

  // Congratulations message
  private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";
  // Cards not matched message
  private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";
  // Cards matched message
  private final static String MATCHED = "CARDS MATCHED! Good Job!";
  // 2D-array which stores cards coordinates on the window display
  private final static float[][] CARDS_COORDINATES =
      new float[][] {{170, 170}, {324, 170}, {478, 170}, {632, 170}, {170, 324}, {324, 324},
          {478, 324}, {632, 324}, {170, 478}, {324, 478}, {478, 478}, {632, 478}};
  // Array that stores the card images filenames
  private final static String[] CARD_IMAGES_NAMES = new String[] {"ball.png", "redFlower.png",
      "yellowFlower.png", "apple.png", "peach.png", "shark.png"};

  private static PApplet processing; // PApplet object that represents
  // the graphic display window
  private static Card[] cards; // one dimensional array of cards
  private static PImage[] images; // array of images of the different cards
  private static Card selectedCard1; // First selected card
  private static Card selectedCard2; // Second selected card
  private static boolean winner; // boolean evaluated true if the game is won,
  // and false otherwise
  private static int matchedCardsCount; // number of cards matched so far
  // in one session of the game
  private static String message; // Displayed message to the display window

  /**
   * Defines the initial environment properties of this game as the program starts
   */
  public static void setup(PApplet processing) {
    // initializing processing
    MemoryGame.processing = processing;
    // initializing the images array to have same length as CARD_IMAGES_NAME array
    images = new PImage[CARD_IMAGES_NAMES.length];
    // loading all image file as PImage object and store its reference into images array
    for (int i = 0; i < CARD_IMAGES_NAMES.length; i++) {
      images[i] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);
    }
    // redistributing the cards
    startNewGame();
  }

  /**
   * Initializes the Game
   */
  public static void startNewGame() {
    // initializing the variables
    selectedCard1 = null;
    selectedCard2 = null;
    matchedCardsCount = 0;
    winner = false;
    message = "";
    cards = new Card[CARDS_COORDINATES.length];
    // shuffle the cards randomly
    int[] mixedUp = Utility.shuffleCards(cards.length);
    // inputting the corresponding shuffled cards from mixedUp array into corresponding location
    for (int i = 0; i < CARDS_COORDINATES.length; i++) {
      cards[i] = new Card(images[mixedUp[i]], CARDS_COORDINATES[i][0], CARDS_COORDINATES[i][1]);
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() {
    char c = processing.key;
    // checking for "N" or "n" key board press to shuffle cards again
    if (Character.valueOf(c).compareTo('N') == 0 || Character.valueOf(c).compareTo('n') == 0) {
      // reshuffling the cards again if "N" key was pressed
      startNewGame();
    }
  }

  /**
   * Callback method draws continuously this application window display
   */
  public static void draw() {
    // set the color used for the background of the Processing window
    processing.background(245, 255, 250); // Mint cream color
    // mixing up random cards
    int[] mixedUp = Utility.shuffleCards(cards.length);
    // displaying cards at corresponding position
    for (int i = 0; i < CARDS_COORDINATES.length; i++) {
      cards[i].draw();
    }
    // outputting the message
    displayMessage(message);
  }

  /**
   * Displays a given message to the display window
   * 
   * @param message to be displayed to the display window
   */
  public static void displayMessage(String message) {
    processing.fill(0);
    processing.textSize(20);
    processing.text(message, processing.width / 2, 50);
    processing.textSize(12);
  }

  /**
   * Checks whether the mouse is over a given Card
   * 
   * @return true if the mouse is over the storage list, false otherwise
   */
  public static boolean isMouseOver(Card card) {
    // checking whether mouse is over a specific card
    if (Math.abs(card.getX() - processing.mouseX) < card.getWidth() / 2
        && Math.abs(card.getY() - processing.mouseY) < card.getHeight() / 2) {
      // return true if mouse is over a specific card
      return true;
    }
    // return false if mouse is not over a specific card
    return false;
  }
  
  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    // initializing the counter
    int count = 0;

    // checking through remaining cards
    for (int j = 0; j < CARDS_COORDINATES.length; j++) {
      // checking for remaining unpaired cards
      if (cards[j].isVisible()) {
        // increment the count to be able to select second card
        // else the count will always be stuck to 0
        count++;
      }
    }

    // looking through cards array to find the card that player is choosing
    for (int i = 0; i < CARDS_COORDINATES.length; i++) {
      // confirming that the player has chosen legitimate card
      if (isMouseOver(cards[i]) && !cards[i].isMatched()) {
        // displaying the first chosen card by flipping it over
        cards[i].setVisible(true);
        cards[i].select();
        // checking whether player's card is first or second card
        if (count % 2 == 0) {
          // checking for null exception
          if (selectedCard1 != null && selectedCard2 != null) {
            // flipping the cards over if the cards aren't same
            if (!matchingCards(selectedCard1, selectedCard2)) {
              selectedCard1.setVisible(false);
              selectedCard2.setVisible(false);
              selectedCard1.deselect();
              selectedCard2.deselect();
            }
          }
          // selecting the first card
          selectedCard1 = cards[i];
          // selecting the second card
        } else if (count % 2 == 1) {
          selectedCard2 = cards[i];
        }
        // keeping track of first or second card
        count++;
      }
    }

    // if there is only 1 card chosen, make the player choose one more card
    if (count % 2 != 0) {
      return;
    }

    // checking for null exception
    if (selectedCard1 != null && selectedCard2 != null) {
      // if the cards are different, display the second picture and
      // not matched message and make player select another set of cards
      if (!matchingCards(selectedCard1, selectedCard2)) {
        message = NOT_MATCHED;
        selectedCard2.draw();
        return;
        // if the cards are same, remain faced up
      } else {
        selectedCard1.setMatched(true);
        selectedCard2.setMatched(true);
        selectedCard1.deselect();
        selectedCard2.deselect();
        // keeping track of number of matched pairs
        matchedCardsCount += 2;
        // if all cards are matched, display congrat message
        if (matchedCardsCount == CARDS_COORDINATES.length) {
          message = CONGRA_MSG;
          winner = true;
          // displaying matched message
        } else {
          message = MATCHED;
        }
      }
    }
  }

  /**
   * Checks whether two cards match or not
   * 
   * @param card1 reference to the first card
   * @param card2 reference to the second card
   * @return true if card1 and card2 image references are the same, false otherwise
   */
  public static boolean matchingCards(Card card1, Card card2) {
    // checking for both selected card's image
    if (card1.getImage().equals(card2.getImage())) {
      // return true if same card, else false
      return true;
    } else {
      return false;
    }
  }

  /**
   * Running the game
   * 
   * @param args
   */
  public static void main(String[] args) {
    Utility.startApplication(); // starts the application
  }
}