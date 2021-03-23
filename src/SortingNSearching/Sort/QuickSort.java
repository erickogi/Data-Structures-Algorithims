package SortingNSearching.Sort;


import java.util.Arrays;

/**
 *
 * Highly efficient in place algorithm , Used in real world
 * Like merge sort, quick sort is a divide and conquer algorithm
 * QUICK SORT DOES NOT USE ADDITION SPACE LIKE HOW MERGE SORT DOES
 * Partition is not based on the length or an artificial index. It is based on a PIVOT (Random)
 * Select one element at random to be PIVOT
 * Perform swap operations so list is partitioned with all element smaller on one side and larger to the other side Need not be in sorted order
 * At end of one iteration , for any pivot we have found right position for the pivot. We cn then work with the sublist to right & left of pivot
 * With each sublist we apply the same pivot
 * Every iteration moves pivot to the right position in a sorted list
 *
 *
 * STEPS
 *
 * On Right of pivot find the first element smaller than pivot  search from end
 * Swap the element with pivot
 * On left of pivot find first element larger than pivot search from start
 * Swap element with pivot
 * Repeated till entire list is sorted
 *
 * You will have esteblished best position of pivot(1)
 * Choose another pivot for the two elements
 *
 *
 *
 * There are two distinct phases
 *
 * Partition -finds a pivot and moves elements to before or after pivot
 * Quicksort - does a recursive call to sort the sub-lists



 Time complexity -> O(N^2) -WORST
 Time complexity -> O(N LOG N) -AVERAGE
 Tends to be better than Merge sort

 Space - O(1)
 */
public class QuickSort {

    public static void swap(String[] list,int iIndex,int jIndex){
        //Store the item to be swapped(selected element)
        String temp = list[iIndex];

        //Swap
        list[iIndex] = list[jIndex];
        list[jIndex] = temp;
    }

    //Divided input array into sub arrays
    //Low & High - Sub range within range to operate
    public static int partition(String[] listToSort, int low, int high){
       //Choose a pivot
        String pivot = listToSort[low];

        int l = low;
        int h = high;

        System.out.println("\nPivot = "+pivot);

        while (l < h){
            while (listToSort[l].compareTo(pivot) <= 0 && l<h){
                l++;
            }
            while (listToSort[h].compareTo(pivot)>0){
                h--;
            }
            if(l<h){
                swap(listToSort,l,h);
                System.out.print("Swapping: "+l+" and "+h+" ");
                System.out.println(Arrays.toString(listToSort));
            }
        }
        swap(listToSort,low,h);
        System.out.print("Swapping: "+low+" and "+h+" ");
        System.out.println(Arrays.toString(listToSort));


        System.out.println("\nPartitioned: "+Arrays.toString(listToSort)+" Around pivot: "+pivot);
        return h;
    }


    public static void quickSort(String[] listToSort,int low,int high){
        if(low>=high){
            return;
        }
        int pivotIndex = partition(listToSort,low,high);

        quickSort(listToSort,low,pivotIndex-1);
        quickSort(listToSort,pivotIndex+1,high);
    }


    public static void main(String[] args){
        String[] unsortedList = new String[]{"Flora","Diana","Alex","Jeff","Elsie","Irene","Gerald","Ben","Harry","Carl"};
        System.out.println(Arrays.toString(unsortedList));
        quickSort(unsortedList,0,unsortedList.length-1);
    }

}
