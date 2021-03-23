package SortingNSearching.Sort;


import java.util.Arrays;

/**
 *
 * Other elements will try insert into the sorted potion of the list\G
 * Grows the sorted sublist into the entire list
 * Assumed list of size 1 as sorted and insert addition elements
 * Worst case is when items already in sorted in descending order
 *
 *
    Select first item and compare with previous neighbor
    Insert it to where it belongs in the sorted (Previous sorted part)
    Compare with items in sorted part starting with immediate previous  (Swap if needed or insert at end if it is bigger than all in sorted potion)


 Time complexity -> O(N^2) - ITERATIONS AS PER NO OF ELEMENTS
 Advantage   - It is adaptive, we can break out of the loop early (In an iteration if no swaps needed then we break out of iterations)
              - it is a stable sort  ie maintains the position or order of equal items before sort & after
              - Has a very low overhead is tradition choice when comfortable with O(N^2)
              - Better than selection sort
              - Better than bubble sort in terms of actual number of operations neeed

 Disadvantage - Time complexity for worst case
 Space - O(1)
 */
public class InsertionSort {

    public static void swap(int[] list,int iIndex,int jIndex){
        //Store the item to be swapped(selected element)
        int temp = list[iIndex];

        //Swap
        list[iIndex] = list[jIndex];
        list[jIndex] = temp;
    }

    public static void insertionSort(int[] listToSort){
        //two loops

        //Goes until length of the array
        for(int i= 0 ; i<listToSort.length-1; i++){
            //i will be the last element of the sorted array
            System.out.println("\ni = "+i);


            for (int j = 1+i;j>0;j--){
                //We go back to find the right position for the element i+1

                //Swap if element j is less than element to its left other wise break and go to the next element
                if(listToSort[j]<listToSort[j-1]){
                    //if item selected is larger, swap the positions and continue with the loop
                    swap(listToSort,j,j-1);
                    System.out.print("Swapping: "+j+" and "+(j-1)+" ");
                    System.out.println(Arrays.toString(listToSort));
                }else {
                    break;
                }
            }
        }
    }

    


    public static void main(String[] args){
        int[] unsortedList = new int[]{40,50,60,20,10,70,100,30,80,90};
        System.out.println(Arrays.toString(unsortedList));
        insertionSort(unsortedList);
    }

}
