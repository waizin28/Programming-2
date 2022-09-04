///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Order Priority Queue
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

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A max-heap implementation of a priority queue for Orders, where the Order with the LONGEST prep
 * time is returned first instead of the strict first-in-first-out queue as in P08.
 * 
 * TODO: Make sure Order implements Comparable<Order> so that this class can implement the
 * PriorityQueueADT without error!
 * 
 * @author waizin
 */
public class OrderPriorityQueue implements PriorityQueueADT<Order> {

  // Data fields; do not modify
  private Order[] queueHeap; // queueHeap to store the orders
  private int size; // size of this queueHeap

  /**
   * Constructs a PriorityQueue for Orders with the given capacity
   * 
   * @param capacity the initial capacity for the queue
   * @throws IllegalArgumentException if the given capacity is 0 or negative
   */
  public OrderPriorityQueue(int capacity) {
    // throw IllegalArgumentException if capacity is invalid (0 or negative)
    if (capacity <= 0) {
      throw new IllegalArgumentException("input capacity cannot be 0 or negative");
    }
    // initializing data fields appropriately
    queueHeap = new Order[capacity];
    this.size = 0;
  }

  /**
   * Inserts a new Order into the queue in the appropriate position using a heap's add logic.
   * 
   * @param newOrder the Order to be added to the queue
   */
  @Override
  public void insert(Order newOrder) {
    // if the queue is empty, insert the new order at the root of the heap
    if (size == 0) {
      // adding to the root
      queueHeap[0] = newOrder;
      // incrementing the size
      size++;
    } else {
      // If the queue is FULL, create a new Order array of double the current heap's size,
      // copy all elements of the current heap over and update the queueHeap reference
      // -> HINT: use Arrays.copyOf(), copying arrays is not the point of this assignment
      if (size == queueHeap.length) {
        // making shadow array when there is no more room to add
        Order[] copy = Arrays.copyOf(queueHeap, size * 2);
        // updating queueHeap reference
        queueHeap = copy;
      }
      // add the newOrder to the end of the heap and percolate up to ensure a valid heap, where
      // the Order with the LONGEST prep time is at the root of the heap
      queueHeap[size] = newOrder;
      // percolate the queue
      percolateUp(queueHeap, size);
      // increment the size
      size++;
    }

  }

  /**
   * A utility method to percolate Order values UP through the heap; see figure 13.3.1 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap       an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated up
   */
  protected static void percolateUp(Order[] heap, int orderIndex) {
    // when are there more than at least one element in the queue, proceed to percolate
    while (orderIndex > 0) {
      // finding the parent index of that leaf
      int parentIndex = (orderIndex - 1) / 2;

      // making sure parents order's prep time are greater than the children
      if (heap[parentIndex].compareTo(heap[orderIndex]) == 1) {
        return;
      } else {
        // swapping order with parent and child if child is greater
        Order temp = heap[orderIndex];
        heap[orderIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
        // child take the place of parent index
        orderIndex = parentIndex;
      }
    }
  }

  /**
   * Return the Order with the longest prep time from the queue and adjust the queue accordingly
   * 
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order removeBest() {
    // if the queue is empty, throw a NoSuchElementException
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from empty Queue");
    }
    // when there is only 1 element in the queue
    if (size == 1) {
      // get the root
      Order max = queueHeap[0];
      // empty the root
      queueHeap[0] = null;
      // decrement the size
      size--;
      // return the longest prep time order from queue
      return max;
    } else {
      // get the original root, which is the max of the queue
      Order max = queueHeap[0];
      // get the last element in the queueHeap array
      Order last = queueHeap[size - 1];
      // making the latest element in the array to take place of root
      queueHeap[0] = last;
      // perlocate the new root down the queue
      percolateDown(queueHeap, 0, size);
      // decrement the size
      size--;
      // return the longest prep time order from queue
      return max;
    }

  }

  /**
   * A utility method to percolate Order values DOWN through the heap; see figure 13.3.2 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap       an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated down
   * @param size       the number of initialized elements in the heap
   */
  protected static void percolateDown(Order[] heap, int orderIndex, int size) {
    // getting the left children of the root
    int childIndex = 2 * orderIndex + 1;
    // getting the order at the root
    Order order = heap[orderIndex];
    // going through all of the indexes of the leaves
    while (childIndex < size) {
      // initializing the maxOrder to with root
      Order maxOrder = order;
      // initializing the maxIndex with -1
      int maxIndex = -1;
      // checking for appropriate prep time within array
      for (int i = 0; i < 2 && i + childIndex < size; i++) {
        // if children prep time is greater than the root, swap
        if (heap[i + childIndex].compareTo(maxOrder) == 1) {
          // maxOrder become element of the children
          maxOrder = heap[i + childIndex];
          // maxOrder index is updated to the children index
          maxIndex = i + childIndex;
        }
      }
      // if updated maxOrder is equal to root return
      if (maxOrder == order) {
        return;
      } else {
        // get the element at the root
        Order temp = heap[orderIndex];
        // switch the element at root with max
        heap[orderIndex] = heap[maxIndex];
        // current maxIndex get the root value
        heap[maxIndex] = temp;
        // the root index updated to be max
        orderIndex = maxIndex;
        // check the left side of current child
        childIndex = 2 * orderIndex + 1;
      }
    }
  }

  /**
   * Return the Order with the highest prep time from the queue without altering the queue
   * 
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order peekBest() {

    // if the queue is empty, throw a NoSuchElementException
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot peek empty Queue");
    }

    // returning the Order with the longest prep time currently in the queue
    return queueHeap[0];
  }

  /**
   * Returns true if the queue contains no Orders, false otherwise
   * 
   * @return true if the queue contains no Orders, false otherwise
   */
  @Override
  public boolean isEmpty() {
    // checking the size of OrderPriorityQueue is 0 or not, will return true if 0, false if not
    return this.size == 0;
  }

  /**
   * Returns the number of elements currently in the queue
   * 
   * @return the number of elements currently in the queue
   */
  public int size() {
    // getting the size of this OrderPriorityQueue
    return this.size;
  }

  /**
   * Creates a String representation of this PriorityQueue. Do not modify this implementation; this
   * is the version that will be used by all provided OrderPriorityQueue implementations that your
   * tester code will be run against.
   * 
   * @return the String representation of this PriorityQueue, primarily for testing purposes
   */
  public String toString() {
    // initializing the string
    String toReturn = "";
    // getting the orders in the queue
    for (int i = 0; i < this.size; i++) {
      toReturn += queueHeap[i].getID() + "(" + queueHeap[i].getPrepTime() + ")";
      // separating with commas except for the last
      if (i < this.size - 1)
        toReturn += ", ";
    }
    // returning the formatted string
    return toReturn;
  }

}
