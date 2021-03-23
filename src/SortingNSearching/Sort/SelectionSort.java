package SortingNSearching.Sort;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
    Select first item and compare with all the other elements
    Find the smallest
    Make the smallest of the comparison with selected first item to be the new first item
    repeat
 Selection sort selects one element at a time and compares it to all other elements in the list
 The correct position for that selected elemnt is found before moving to the next element
 Time complexity -> O(N^2) - FOR EACH ELEMENT THE ENTIRE LIST NEEDS TO BE CHECKED (KINDA TWO FOR LOOP)
 Advantage is that its a very simple
 Disadvantage - Not Adaptive (No way to know list is sorted and break early)
              - Not stable does not maintain the position or order of equal items before sort & after
 Space - O(1)
 */
public class SelectionSort {

    public static void swap(int[] list,int iIndex,int jIndex){
        //Store the item to be swapped(selected element)
        int temp = list[iIndex];

        //Swap
        list[iIndex] = list[jIndex];
        list[jIndex] = temp;
    }

    public static void selectionSort(int[] listToSort){
        //two loops
        for(int i=0;i<listToSort.length;i++){
            System.out.println("\ni = "+i);
            for (int j = i+1;j<listToSort.length;j++){
                //check if item selected list[i] is larger than item on the list at current j loop index
                if(listToSort[i]>listToSort[j]){
                    //if item selected is larger, swap the positions and continue with the loop
                    swap(listToSort,i,j);
                    System.out.print("Swapping: "+i+" and "+j+" ");
                    System.out.println(Arrays.toString(listToSort));
                }
            }
        }
    }




    public static void main(String[] args){
        int[] unsortedList = new int[]{40,50,60,20,10,70,100,30,80,90};
        System.out.println(Arrays.toString(unsortedList));
        selectionSort(unsortedList);
    }

}
