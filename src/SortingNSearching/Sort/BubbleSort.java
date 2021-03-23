package SortingNSearching.Sort;


import java.util.Arrays;

/**
    Select first item and compare with its neighbor
    Find the smallest
    Swap SO THE SMALLER one is earlier in the list
    Swapping adjacent elements to be in the right order bubbles the largest element to the end

 Largest element is bubbled to correct position
 Worst case is when list is sorted in descending order


 Time complexity -> O(N^2) - ITERATIONS AS PER NO OF ELEMENTS
 Advantage    - is that its a very simple,
              - It is adaptive, we can break out of the loop early (In an iteration if no swaps needed then we break out of iterations)
              - it is a stable sort  ie maintains the position or order of equal items before sort & after

 Disadvantage - Time complexity for worst case
 Space - O(1)
 */
public class BubbleSort {

    public static void swap(int[] list,int iIndex,int jIndex){
        //Store the item to be swapped(selected element)
        int temp = list[iIndex];

        //Swap
        list[iIndex] = list[jIndex];
        list[jIndex] = temp;
    }

    public static void bubbleSort(int[] listToSort){
        //two loops

        //In Revers order so long as i > 0 and we keep decrementing i by 1
        //Decrement to mean now the portion of unsorted list is less by one (largest) with every iteration
        for(int i= listToSort.length -1 ; i>0; i--){

            System.out.println("\ni = "+i);

            //Runs over elements in the unsorted part of the array
            for (int j = 0;j<i;j++){

                //For each iteration , we compare current element with one just after it j+1 and swap if greater
                if(listToSort[j]>listToSort[j+1]){
                    //if item selected is larger, swap the positions and continue with the loop
                    swap(listToSort,j,j+1);
                    System.out.print("Swapping: "+j+" and "+(j+1)+" ");
                    System.out.println(Arrays.toString(listToSort));
                }
            }
        }
    }
    public static void bubbleSortWithEarlyBreak(int[] listToSort){
        //two loops

        //In Revers order so long as i > 0 and we keep decrementing i by 1
        //Decrement to mean now the portion of unsorted list is less by one (largest) with every iteration
        for(int i= listToSort.length -1 ; i>0; i--){

            boolean swapped = false;
            System.out.println("\ni = "+i);

            //Runs over elements in the unsorted part of the array
            for (int j = 0;j<i;j++){

                //For each iteration , we compare current element with one just after it j+1 and swap if greater
                if(listToSort[j]>listToSort[j+1]){
                    //if item selected is larger, swap the positions and continue with the loop
                    swap(listToSort,j,j+1);
                    swapped = true;
                    System.out.print("Swapping: "+j+" and "+(j+1)+" ");
                    System.out.println(Arrays.toString(listToSort));
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    


    public static void main(String[] args){
        int[] unsortedList = new int[]{40,50,60,20,10,70,100,30,80,90};
        System.out.println(Arrays.toString(unsortedList));
        bubbleSort(unsortedList);
        bubbleSortWithEarlyBreak(unsortedList);
    }

}
