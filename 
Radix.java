import java.util.*;
import java.io.*;

public class Radix{

  public static void radixsort(int[]data){
    MyLinkedList<Integer> track = new MyLinkedList<Integer>();

    for(int i = 0; i < dta.length; i++){
      
    }
  }

}

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
