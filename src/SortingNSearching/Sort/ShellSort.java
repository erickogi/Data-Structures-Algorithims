package SortingNSearching.Sort;


import java.util.Arrays;

/**
 *
 * Its is a modified version of insertion sort
 * Main difference - rather than comparing adjacent elements, elements at  certain interval are compared
 * Different variations based on interval selected
 * Ie
 *
 * Start with interval N/2 - ensure all N/2 apart elements are sorted
 * Reduce Interval to N/4 - ensure all N/4 apart are sorted
 * N/16,....
 * Last Interval is 1 - All 1 apart(adjacent to each other are sorted)
 *
 *
 * Shell sort uses insertion sort - entire list is divided and those sub-lists are sorted
 * Getting exact complexity is dependant on increment value chosen
 * Best increment sequence is N/2,N/4 ..
 * Complexity is better than insertion as final increment = 1 has to work with a nearly sorted list

 Time complexity -> Between 0(N) AND O(N^2) - Based on increment value chosen - Worst complexity <=0(N^2)

 Advantage   - It is adaptive, we can break out of the loop early (In an iteration if no swaps needed then we break out of iterations)
              - it is a stable sort  ie maintains the position or order of equal items before sort & after
              - Has a very low overhead is tradition choice when comfortable with O(N^2)
              - Better than insertion sort
              - Better than insertion sort as final increment = 1

 Disadvantage - Time complexity for worst case
 Space - O(1)
 */
public class ShellSort {

    public static void swap(int[] list,int iIndex,int jIndex){
        //Store the item to be swapped(selected element)
        int temp = list[iIndex];

        //Swap
        list[iIndex] = list[jIndex];
        list[jIndex] = temp;
    }

    public static void insertionSort(int[] listToSort,int increment){
        //two loops

        //Goes until length of the array
        for(int i= 0 ; i+increment<listToSort.length; i=i+1){
            //i will be the last element of the sorted array
            System.out.println("\ni = "+i+" Increment = "+increment);


            for (int j =i+increment;j-increment>=0;j=j-increment){
                //We go back to find the right position for the element i+1

                //Swap if element j is less than element to its left other wise break and go to the next element
                if(listToSort[j]<listToSort[j-increment]){
                    //if item selected is larger, swap the positions and continue with the loop
                    swap(listToSort,j,j-increment);
                    System.out.print("Swapping: "+j+" and "+(j-increment)+" ");
                    System.out.println(Arrays.toString(listToSort));
                }else {
                    break;
                }
            }
        }
    }


    public static void shellSort(int [] listToSort){
        int increment = listToSort.length/2;
        while (increment>=1){
            insertionSort(listToSort,increment);
            increment = increment/2;
        }
    }


    public static void main(String[] args){
        int[] unsortedList = new int[]{40,50,60,20,10,70,100,30,80,90};
        System.out.println(Arrays.toString(unsortedList));
        shellSort(unsortedList);
    }

}
