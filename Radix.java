
import java.util.*;
import java.io.*;

public class Radix{

  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void radixsort(int[]data){
    int max = 0;
    int ind = 0;
    int trackINT = (int)Math.log10(max) + 1; //num digits in max val
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList<Integer> track = new MyLinkedList<Integer>();

    for(int i = 0; i < buckets.length; i++){
      buckets[i] = new MyLinkedList();
    }

    for(int i = 0; i < data.length; i++){
      if(data[i] > max){
        max = data[i];
      }
    }

    if(max == 0){
      trackINT = 1;
    }

    for(int j = 0; j < trackINT; j++){

      if(j == 0){

        for(int i = 0; i < data.length; i++){
          int num = data[i];
          int digit = digit(num, j);

          //neg num
          if(num < 0){
            buckets[9 - digit].add(num);
          }
          //pos num
          else{
            buckets[digit + 10].add(num);
          }
        }
      }
      else{
        while(track.size() > 0){
          int num = track.removeFront();
          int digit = digit(num, j);

          if(num < 0){
            buckets[9 - digit].add(num);
          }
          else{
            buckets[digit + 10].add(num);
          }
        }
      }

      for(int j = 0; j < buckets.length; j++){
        track.extend(buckets[j]);
      }
    }

    while(track.size() > 0){
      data[ind] = track.removeFront();
      ind++;
    }
  }




  public static String toString(int[] data){
    String res = "";

    for(int i = 0; i < data.length; i++){
      res += data[i] + ", ";
    }

    return res;
  }

    public static int digit(int num, int pos){
      int mod = 0;
      int div = 1;

      if(pos == 0){
        mod = 10;
      }
      else{
        mod = (int) Math.pow(10, (pos + 1));
      }

      if(pos == 0){
        div = 1;
      }
      else{
        div = (int) Math.pow(10, pos);
      }

      return Math.abs(num % mod / div);
    }


}

//put data array into buckets based on first digits
//merge into a linked list, track
//put track into buckets
//removeFront n times
//iterator
//[16, -15, -5, 17, -8, -3, 2, -3, 3, 10]
/*Radix sort should get faster when the arraySize : maxValue ratio increases.
(More elements and smaller max value)
Negative values can be done as per the discussion in class (today) Make sure
you take notes!
Though we are sorting ints, this sort could be modified to work on an array of
objects that have some kind of int value that can be obtained by a common method,
i.e. "public int getValue()" Since the <E> would then have to be more complex,
and that is beyond what we want to discuss now.
The radix sort is a non-comparative sort! We never compare two values to eachother.
If we were to use a stable sort on each digit of the numbers in a list:
-Start with the least significant digit and sort by that
-Move to the next significant digit and sort by that (repeat until no more digits in any of the numbers)
Note: Since the sort is stable, we retain the order of the less significant digits each time.
[picture]
-After each pass, look to the left of the current digit, and notice that if that were the entire number the list would be sorted.
Some simpler examples:
If we had  [5xx, 4xx, 2xx, 3xx, 7xx]
Since there are no duplicates in the most significant digit, the list would be ultimately sorted by the hundreds digits:
[2xx, 3xx, 4xx, 5xx, 7xx]
If we had duplicates they would use the order of the highest different value:
eg  [133, 123]
When sorting by the one's place would remain in the same order.
When sorting by the ten's place they would flip to   [123, 133]
When sorting by the hundreds place, they woudld remain in the same order. (the tens place determines the order)
end result : [123, 133]
*/
