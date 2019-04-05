import java.util.*;
import java.io.*;

public class MyLinkedList<E>{
  private int len;
  private Node start;
  private Node end;

  public String toString(){
    String res = "[";
    Node track = start;

    while(track != null){
      res += track.getData() + ", ";
      track = track.next();
    }

    res += "]";
    return res;
  }

  public MyLinkedList(){
    len = 0;
  }
  //construct an empty list

  public int size(){
    return len;
  }

  public void clear(){
    len = 0;
    start = null;
    end = null;
  }
  //reset the list to an empty state. Very similar to the constructor.

  public boolean add(E value){
    Node add = new Node(value);

    //empty list
    if(len == 0){
      start = add;
      end = add;
    }

    else{
      end.setNext(add);
      add.setPrev(end);
      end = add;
    }

    len ++;
    return true;
  }
  //add an element to the end of the list (the boolean would be true all the time if you want to conform to list standards)

  public void extend(MyLinkedList<E> other){
    if(size() == 0){
      start = other.start;
      end = other.end;
    }

    else if(other.size() > 0){
      end.setNext(other.start);
      other.start.setPrev(end);
      end = other.end;
    }

      len += other.len;
      other.clear();
  }
  //in O(1) time, connect the other list to the end of this list.
  //The other list is then reset to size 0 (do not wipe out the nodes, just disconnect them.)
  //This is how you will merge lists together for your radix sort.
  @SuppressWarnings({"unchecked", "rawtypes"})
  public E removeFront(){
    if(len == 0){throw new NoSuchElementException();}

    E track = (E)start.getData();

    if(len == 1){
      clear();
    }

    else{
      start = start.next();
      start.setPrev(null);
      len --;
    }

    return track;
  }
  //remove the 1st element of the list, and return that value.
  //A working iterator would be faster than remove front for traversing the list.

}
