/**
Search class is the main method for Tweet class
@author Yao, Stacey
*/
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {
  //Main method gets the file path from the command line, then
  //calls readFile
  public static void main(String[] args) throws FileNotFoundException {
    if (args.length == 0 ){
      System.out.println("usage: java Search <tweets-file>");
      System.exit(1);
    }
    String path = args[0];
    Queue tweets = readFile(path);
    System.out.println("Queue size: " + tweets.length());

    //System.out.println("Queue size: " + size);
    //tweets.printAll();

    //https://www.journaldev.com/16536/java-do-while-loop#:~:text=Java%20do%2Dwhile%20loop%20is,loop%20execution%20at%20least%20once.
    //https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
    String cmd;
    Queue list = tweets;
    do {
      System.out.print("? ");
      Scanner in = new Scanner(System.in);
      cmd = in.next();

      if(!cmd.equals("!quit") && !cmd.equals("!dump") && !cmd.equals("!reset")) {
        if(cmd.charAt(0) == '-') {
          list = list.filterForNotKeyword(cmd.replace("-", ""));
        }
        else if(cmd.charAt(0) == '+') {
          list = list.filterForDate(cmd.replace("+",""));
        }
        else {
          list = list.filterForKeyword(cmd);
        }
        System.out.println("Queue size: " + list.length());

      }
      if(cmd.equals("!reset")) {
        list = tweets;
        System.out.println("Queue size: " + list.length());
      }
      if(cmd.equals("!dump")) {
        list.printAll();
        System.out.println("Queue size: " + list.length());
      }

    } while(!cmd.equals("!quit"));

    System.out.println("Goodbye!");

  }

  /**
  Class readFile opens the files, reads its lines, and fills the
  Queue
  @param path entered path file from user;
  https://www.javatpoint.com/how-to-open-a-file-in-java
  https://www.youtube.com/watch?v=lHFlAYaNfdo (youtuber Alex Lee explains how to read a text file)
  Help received from MGSP Darby in debugging
  */
  public static Queue readFile(String path) throws FileNotFoundException {
    Queue tweets = new Queue();
    File file = new File(path);
    Scanner scan = new Scanner(file);
    while(scan.hasNextLine()) {
      String[] split = (scan.nextLine()).split("\t");
      Tweet fulltweet = new Tweet(split[0], split[1], split[2]);
      tweets.enqueue(fulltweet);
    }
    scan.close();
    return tweets;
  }

}//end Search class
