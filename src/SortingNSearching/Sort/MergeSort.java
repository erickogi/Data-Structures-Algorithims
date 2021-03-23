package SortingNSearching.Sort;


import java.util.Arrays;

/**
 * Divide n Conquer approach - Divide into smaller sub-problems
 * List broken down into smaller parts recursively
 * Until you get a list wit a single element (Considered sorted)
 *
 * So all sub problems are sorted list of size 1 they are then merged based on sort
 *
 * Uses recursion to reduce lines -
 * Divided into two recursively
 * Merge of two list of N/2 length
 *
 *
 * TIME COMPLEXITY - 0(N LOG N) - BETTER THAN SHELL,INSERTION,BUBBLE,SELECTION
 *
 * its a stable sort - equal entities
 *
 * Disadvantage is space complexity
 *
 * Requires addition Space - 0(N)
 *
 *
 */
public class MergeSort {


    //listFirst & second are first empty
    //Takes care of the divide in dived and conquer
    public static void split(String[] listToSort,String[] listFirstHalf,String[] listSecondHalf){

        int secondHalfStartIndex = listFirstHalf.length;

        for(int index = 0; index< listToSort.length;index++){
            if(index<secondHalfStartIndex){
                listFirstHalf[index] = listToSort[index];
            }else {
                listSecondHalf[index-secondHalfStartIndex] = listToSort[index];
            }
        }
    }

    //Takes care of the conquer in dived and conquer
    public static void merge(String[] listToSort,String[] listFirstHalf,String[] listSecondHalf) {

        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHafIndex = 0;
        //while loop to check head of the two lists we want together
        //pick small element and add to listToSort
        //So long as the two index are not out of range


        while (firstHalfIndex <listFirstHalf.length && secondHafIndex<listSecondHalf.length){
            //cHECK WHICH ELEMENT IS SMALLER (AT HED OF FIRST OR HEAD OF SECOND OF SECONF HALF
            if(listFirstHalf[firstHalfIndex].compareTo(listSecondHalf[secondHafIndex])<0){
                // MERGE IN THE ELEMENT IN FIRST HALF
                listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else if (secondHafIndex < listSecondHalf.length){
                ///HEAD ELEMENT IN SECOND LIST IS THE SMALLER SO WE MERGE ELEMEENT AT HED OF SECOND LIST INTO SORTED LIST
                listToSort[mergeIndex]  = listSecondHalf[secondHafIndex];
                secondHafIndex++;
            }
            //WE HAVE MERGED THE SMALLEST OF BOTH LIST SO WE INCREMENT MERGE INDEX
            mergeIndex++;
        }
        //We have to see which list still has elements left
        //if first half index is less than first-half length there are elements that need to be merged into final list so we run a while
        // loop so lang as merge index is less than length of final list we assign all elements from list first half to final merge list
        //for every iteration, we increment merge index and first half index
        if(firstHalfIndex< listSecondHalf.length){
            while (mergeIndex < listToSort.length){
                listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];
            }
        }

        //Same as above
        if(secondHafIndex<listSecondHalf.length){
            while (mergeIndex<listToSort.length){
                listToSort[mergeIndex++] = listSecondHalf[secondHafIndex++];
            }
        }



    }

    //Recursive method - Splits to size one and then merges
    public static void  mergeSort(String [] listToSort){
        if(listToSort.length == 1){
            return;
        }
        //Calculate middle index add o or 1 based of even or odd number of elements
        int midIndex = listToSort.length/2+listToSort.length%2;

        //Divide portion
        //Create two lists - empty at first
        String [] listFirstHalf = new String[midIndex];
        String [] listSecondHalf = new String[listToSort.length-midIndex];
        //Invoke split to fill the new list with elements
        split(listToSort,listFirstHalf,listSecondHalf);

        System.out.println("\nSplit: "+Arrays.toString(listFirstHalf)+"  "+Arrays.toString(listSecondHalf));

        //Recurse to sort the two list to Size 1 elements ie above we have listToSort length == 1 return
        mergeSort(listFirstHalf);
        mergeSort(listSecondHalf);

        merge(listToSort,listFirstHalf,listSecondHalf);

        System.out.println("\nMerged: "+Arrays.toString(listToSort));

    }




        public static void main(String[] args){
        String[] unsortedList = new String[]{"Flora","Diana","Alex","Jeff","Elsie","Irene","Gerald","Ben","Harry","Carl"};
        System.out.println(Arrays.toString(unsortedList));
        mergeSort(unsortedList);
    }

}
