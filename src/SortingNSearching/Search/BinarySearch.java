package SortingNSearching.Search;

import java.util.Arrays;

/**
 * BINARY SEARCH
 * Follows divide and conquer
 * Choose at mid point and check if element is what we a looking for
 * If not check if its smaller or greater than element we are looking for
 * If Larger . We sub divide the list to the before the mid point and repeat
 * If Smaller . We sub divide list to the after and repeat
 *
 *
 * Much faster
 * Can be done iteratively and recursively
 *
 * Complexity O(LOG N)
 *
 * LINEAR SEACH
 *
 * O(N) Loops through all elements
 * No Improvement when working with sorted list
 *
  */

public class BinarySearch {

    /////BINARY SEARCH
    public static int linearSearch(String [] list,String element){
        System.out.print("\n Searching ..."+element+" : ");
        for (int i=0;i<list.length;i++){
            System.out.print(i+" ");
            if(list[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    ////BINARY SEARCH O(LOG N) - ONLY FOR SORTED LIST -iteratively
    public static int binarySearchIteratively(String [] list,String element){
        int low =0;
        int high = list.length -1;

        while (low<=high){
            int mid = (low+high)/2;

            if(list[mid].equals(element)){
                return mid;
            }else if(list[mid].compareTo(element)<0){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    ////BINARY SEARCH O(LOG N) - ONLY FOR SORTED LIST -Recursively
    public static int binarySearchRecursively(String [] list,String element,int low,int high){
        if(low>high){
            return -1;
        }
        int mid = (low+high)/2;

        if(list[mid].equals(element)) {
            return mid;
        }else if(list[mid].compareTo(element)<0){
            return binarySearchRecursively(list,element,mid+1,high);
        }else {
            return binarySearchRecursively(list,element,low,mid-1);
        }
    }




        public static void main(String[] args){
        String[] unsortedList = new String[]{"Flora","Diana","Alex","Jeff","Elsie","Irene","Gerald","Ben","Harry","Carl"};
        String[] sortedList = new String[]{"Alex","Ben","Carl","Diana","Elsie","Flora","Gerald","Harry","Irene","Jeff"};
        System.out.println(Arrays.toString(unsortedList));
        System.out.println("\n"+linearSearch(unsortedList,"Diadna"));
        System.out.println("\n"+binarySearchIteratively(sortedList,"Diana"));
        System.out.println("\n"+binarySearchRecursively(sortedList,"Jeff",0,sortedList.length-1));
    }

}
