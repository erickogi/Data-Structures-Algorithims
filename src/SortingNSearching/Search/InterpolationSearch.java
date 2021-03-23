package SortingNSearching.Search;

import java.util.Arrays;

/**
 * Improvement of Binary Search
 * Elements in list are uniformly distributed with range on minimum and maximum element
 *
 * We don't always look at mid point iT DEPENDS ON WHETHER ELEMENT IS CLOSER TO LARGEST OR SMALLEST ELEMENT
 *
  */

public class InterpolationSearch {

    /////jumpSearch SEARCH
    public static int interpolationSearch(int [] list,int element){
       int low = 0;
       int high = list.length-1;
       System.out.println("\nSearching.."+element+" : ");

       while (low<=high){
           int mid = low+((element-list[low])*(high-low))/(list[high] - list[low]);
           System.out.println("Low; "+low+" High: "+high+" Mid: "+mid+" Mid element: "+list[mid]);
           if(list[mid] == element){
               return mid;
           }
           else if (list[mid]<element){
               low = mid+1;
           }else {
               high = mid-1;
           }
       }
       return -1;

    }



        public static void main(String[] args){
            int[] sortedIntList = new int[]{10,20,30,40,50,60,70,80,90,100};
        System.out.println(Arrays.toString(sortedIntList));
        System.out.println("\n"+interpolationSearch(sortedIntList,60));
    }

}
