/**
Tweet class stores different information of the tweets
@author Yao, Stacey
*/
import java.util.*;
import java.io.File;
import java.util.Scanner;

public class Tweet {
//read in file, create Tweet objects, and store them into array
  private String text;
  private String user;
  private int day;
  private int month;
  private int year;
   /**
   constructor Tweet initializes the variables in each tweet
   @param newtext stores text portion
   @param newuser stores user portion
   @param newdate stores date portion
   https://www.geeksforgeeks.org/split-string-java-examples/
   */
    public Tweet(String newtext, String newuser, String newdate) {
      this.text = newtext;
      this.user = newuser;
      String[] date = newdate.split("-", -2);
      //Integer.parseInt converts a String to an int
      this.year = Integer.parseInt(date[0]);
      this.month = Integer.parseInt(date[1]);
      this.day = Integer.parseInt(date[2]);
    }
    /**
    method toString returns a single string that represents all of
    the tweet's data. It does not print anything.
    https://www.tutorialspoint.com/how-do-we-mix-two-strings-and-generate-another-in-java
    */
    public String toString() {
      String fulltweet = new String();
      fulltweet = this.text + "\t" + "[" + this.user + "]" + "\t" + this.month + "/"
                  + this.day + "/" + this.year;
      return fulltweet;
    }

    /**
     * method containsKeyword compares the keyword to words in the tweet
     * @param keyword is the keyword being compared
     */
    public boolean containsKeyword(String keyword) {
      if(this.text.toLowerCase().contains(keyword.toLowerCase())) {
        return true;
      }
      else {
        return false;
      }
    }

    //GETTER METHODS
    /**
    getText method gets the text
    */
    public String getText() {
      return this.text;
    }

    /**
    getUser method gets the user
    */
    public String getUser() {
      return this.user;
    }

    /**
    getDay gets the day
    */
    public int getDay() {
      return this.day;
    }

    /**
    getMonth gets the month
    */
    public int getMonth() {
      return this.month;
    }

    /**
    getYear gets the year
    */
    public int getYear() {
      return this.year;
    }

    //SETTER METHODS
    /**
    setText method sets the text
    */
    public void setText(String newtext) {
      this.text = newtext;
    }

    /**
    setUser method sets the user
    */
    public void setUser(String newuser) {
      this.user = newuser;
    }

    /**
    setDay method sets the user
    */
    public void setDay(int day) {
      this.day = day;
    }

    /**
    setMonth method sets the month
    */
    public void setMonth(int month) {
      this.month = month;
    }

    /**
    setYear method sets the year
    */
    public void setYear(int year) {
      this.year = year;
    }

    /**
    setDate method sets the full date
    */
    public void setDate(String newdate) {
      String[] date = newdate.split("-", -2);
      //Integer.parseInt converts a String to an int
      this.year = Integer.parseInt(date[0]);
      this.month = Integer.parseInt(date[1]);
      this.day = Integer.parseInt(date[2]);
    }

} //end Tweet class
