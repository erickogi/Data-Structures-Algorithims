package SortingNSearching.Search;

import java.util.Arrays;

/**
 * O(SQRT(N))
 * Improvement of linear Search
 * Better than linear search
 * We jump ahead
 * Depends on best step size (sqrt(n)) is best interval
 *
 *
 *
  */

public class JumpSearch {

    /////jumpSearch SEARCH
    public static int jumpSearch(String [] list,String element, int jumpLength){
       int i = 0;
       System.out.println("\nSearching.."+element+" : ");

       while (list[i].compareTo(element)<=0){
           System.out.println("Element is greater or equal to : "+list[i]);
           i = i+jumpLength;
           if(i>=list.length){
               break;
           }
       }
       int startIndex = i-jumpLength;
       int endIndex =Math.max(i,list.length);

       System.out.println("Looking between: "+startIndex+" and : "+endIndex);
       for(int j = startIndex;j<endIndex;j++){
           if(list[j].equals(element)){
               return j;
           }
       }
       return -1;
    }



        public static void main(String[] args){
        String[] unsortedList = new String[]{"Flora","Diana","Alex","Jeff","Elsie","Irene","Gerald","Ben","Harry","Carl"};
        String[] sortedList = new String[]{"Alex","Ben","Carl","Diana","Elsie","Flora","Gerald","Harry","Irene","Jeff"};
        System.out.println(Arrays.toString(unsortedList));
        System.out.println("\n"+jumpSearch(sortedList,"Jeff",6));
    }

}
