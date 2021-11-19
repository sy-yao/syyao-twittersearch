/**
Queue will have an interface that adds and removes data in
storing queues of tweets
@author Yao, Stacey
*/
import java.util.*;

public class Queue {
  private Node head;
  private Node tail;

  //Node is a nested class and a helper class for parent class Queue
  private class Node {
    public Tweet tweet;
    public Node next;

    public Node(Tweet t, Node n) {
      tweet = t;
      next = n;
    }
  }

  /**
   * adds a new tweet to the back of the queue
   */
 //enqueue is what we call a data structure
  public void enqueue(Tweet twt) {
    Node node = new Node(twt, null);
    if(this.empty()) {
      this.head = node;
      this.tail = node;
    }
    else {
      this.tail.next = node;
      this.tail = this.tail.next;
    }
  }

  /**
   * removes and returns string from the front of the queue
   */
  //remove head and return the new tweet in front
  public Tweet dequeue() {
    Node temp = this.head;
    this.head = this.head.next;

    return temp.tweet;
  }

  /**
   * method counter counts how many nodes are in the list
   */
  public int length() {
    Node cur = this.head;
    int counter = 0;
    while(cur != null) {
      cur = cur.next;
      counter++;
    }
    return counter;
  }
  /**
   * method printAll prints all nodes in list
   */
  public void printAll() {
    Node cur = this.head;
    while(cur != null) {
      System.out.println(cur.tweet);
      cur = cur.next;
    }
  }

  /**
   * method filterForKeyword returns a new queue that contains all
   * matching tweets
   * @param keyword is the keyword being put into a new queue
   */
  public Queue filterForKeyword(String keyword) {
    Queue wordlist = new Queue();
    Node cur = this.head;
    while(cur != null) {
      if(cur.tweet.containsKeyword(keyword)) {
        wordlist.enqueue(cur.tweet);
      }
      cur = cur.next;
    }
    return wordlist;
  }

  /**
   * method filterForNotKeyword returns a new queue that contains all
   * matching tweets
   * @param keyword is the keyword being put into a new queue
   */
  public Queue filterForNotKeyword(String keyword) {
    Queue wordlist = new Queue();
    Node cur = this.head;
    while(cur != null) {
      if(!cur.tweet.containsKeyword(keyword)) {
        wordlist.enqueue(cur.tweet);
      }
      cur = cur.next;
    }
    return wordlist;
  }

  public Queue filterForDate(String date) {
    Queue wordlist = new Queue();
    Node cur = this.head;
    String[] newdate = date.split("-", -2);
    while(cur != null) {
      if(Integer.parseInt(newdate[0]) == cur.tweet.getYear() &&
         Integer.parseInt(newdate[1]) == cur.tweet.getMonth() &&
         Integer.parseInt(newdate[2]) == cur.tweet.getDay()) {
           wordlist.enqueue(cur.tweet);
      }
      cur = cur.next;
    }
    return wordlist;
  }

  /**
   * returns true if the queue is empty
   */
  public boolean empty() {
    if(this.head == null) {
      return true;
    }
    else {
      return false;
    }
  }
}//end Queue class
