package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SimpleAlgos {


    public static void getMaxNoInArray(int [] arr){

        int max =0;

        for(int a = 0;a<arr.length;a++){
            if(arr[a]>max){
                max = arr[a];
            }
            isNoPrime(arr[a]);
        }
        System.out.println("\nMax In An Array: " +max);

        //
    }

    public static void isNoPrime(int num){
        boolean isPrime = true;

        //0(N)
        for(int a =2;a<num;a++){
            if( num % a ==0){
                isPrime = false;
                break;
            }
        }

        //0(Sqrt(N))
        for(int a = 2;a <= Math.sqrt(num); a++){
            if( num % a ==0){
                isPrime = false;
                break;
            }
        }


        System.out.println("Is Prime -> "+num+" -> "+isPrime);
    }



    public static void reverseAString(String strn){

        // convert String to character array
        // by using toCharArray
        char[] try1 = strn.toCharArray();

        String rev = "";
        for (int i = try1.length - 1; i >= 0; i--){
            rev += try1[i];
        }
            System.out.print("\nReversed String: " +rev);
    }

    public static int reverseAnInteger(int num){
        int reversed = 0;

        for(;num != 0; num /= 10) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
        }

        System.out.println("\nReversed Number: " + reversed);

        return reversed;
    }

    public static void isNumApalindrome(int num){
        int reversedInteger = 0, originalInteger;

        originalInteger = num;

        // reversed integer is stored in variable
        reversedInteger = reverseAnInteger(num);

        // palindrome if orignalInteger and reversedInteger are equal
        if (originalInteger == reversedInteger)
            System.out.println(originalInteger + " is a palindrome.");
        else
            System.out.println(originalInteger + " is not a palindrome.");
    }

/***
  Function to find the number of deletions
     required such that characters of the
     string can be rearranged to form a palindrome
    The problem can be solved based on the observation that, in a palindromic string, at most one character can occur odd number of times. Therefore, reduce the frequency of all odd-frequent characters except one of them.
    Follow the steps below to solve the problem:
 */
    public static int minDeletionsToMakeAStringAPalindrome(String str)
    {
        // Stores frequency of characters
        int fre[] = new int[26];

        int n = str.length();

        // Store the frequency of each
        // character in frequency array
        for (int i = 0; i < n; i++) {
            fre[str.charAt(i) - 'a'] += 1;
        }

        int count = 0;

        // Count number of characters
        // with odd frequency
        for (int i = 0; i < 26; i++) {
            if (fre[i] % 2 == 1) {
                count += 1;
            }
        }

        // If count is 1 or 0, return 0
        if (count == 0 || count == 1) {
            System.out.println("\nminDeletionsToMakeAStringAPalindrome: " + "0");
            return 0;
        }

        // Otherwise, return count - 1
        else {
            System.out.println("\nminDeletionsToMakeAStringAPalindrome: " + (count - 1));
            return count - 1;
        }

    }

    /***
     Check if a given array contains duplicate
   elements within k distance from each other

   1) Create an empty hashtable.
   2) Traverse all elements from left from right. Let the current element be ‘arr[i]’
….a) If current element ‘arr[i]’ is present in hashtable, then return true.
….b) Else add arr[i] to hash and remove arr[i-k] from hash if i is greater than or equal to k

   ***/
    public   static boolean checkDuplicatesWithinK(int arr[], int k)
    {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array
        for (int i=0; i<arr.length; i++)
        {
            // If already present n hash, then we found
            // a duplicate within k distance
            if (set.contains(arr[i])) {
                System.out.println("\ncheckDuplicatesWithinK: " + true);
                return true;
            }

            // Add this item to hashset
            set.add(arr[i]);

            // Remove the k+1 distant item
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }
        System.out.println("\ncheckDuplicatesWithinK: " + false);
        return false;
    }

/**
 *  program to find the most frequent element
    in an array
    We first sort the array, then linearly traverse the array.
 */
    public   static int mostFrequentViaSort(int arr[])
    {

        int n = arr.length;
        // Sort the array
        Arrays.sort(arr);

        // find the max frequency using linear
        // traversal
        int max_count = 1, res = arr[0];
        int curr_count = 1;

        for (int i = 1; i < n; i++)
        {
            if (arr[i] == arr[i - 1])
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                    res = arr[i - 1];
                }
                curr_count = 1;
            }
        }

        // If last element is most frequent
        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = arr[n - 1];
        }
        System.out.println("\nmostFrequentViaSort: " + res);
        return res;
    }

    /**
     *  program to find the most frequent element
     in an array
     We create a hash table and store elements and their frequency counts as key value pairs.
     Finally we traverse the hash table and print the key with maximum value.
     */
    public  static int mostFrequentViaHashTable(int arr[])
    {
        int n = arr.length;
        // Insert all elements in hash
        Map<Integer, Integer> hp =
                new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++)
        {
            int key = arr[i];
            if(hp.containsKey(key))
            {
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);
            }
            else
            {
                hp.put(key, 1);
            }
        }

        // find max frequency.
        int max_count = 0, res = -1;

        for(Map.Entry<Integer, Integer> val : hp.entrySet())
        {
            if (max_count < val.getValue())
            {
                res = val.getKey();
                max_count = val.getValue();
            }
        }
        System.out.println("\nmostFrequentViaHashTable: " + res);
        return res;
    }

    public     /* Function to print first smallest and second smallest
      elements */
    static void print2Smallest(int arr[])
    {
        int first, second, arr_size = arr.length;

        /* There should be atleast two elements */
        if (arr_size < 2)
        {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = Integer.MAX_VALUE;
        for (int i = 0; i < arr_size ; i ++)
        {
            /* If current element is smaller than first
              then update both first and second */
            if (arr[i] < first)
            {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and second
               then update second  */
            else if (arr[i] < second && arr[i] != first)
                second = arr[i];
        }
        if (second == Integer.MAX_VALUE)
            System.out.println("There is no second" +
                    "smallest element");
        else
            System.out.println("The smallest element is " +
                    first + " and second Smallest" +
                    " element is " + second);
    }
    public static void main(String[] args){
        int array[] = {1,2,33,4,1,4,45,4645,43,2,2,534,56,8,445,2,4,52,2,554,7,86,34,2422};
        getMaxNoInArray(array);
        reverseAString("reversethis string");
        reverseAnInteger(3923345);
        isNumApalindrome(434);
        minDeletionsToMakeAStringAPalindrome("reversethis");
        checkDuplicatesWithinK(array,4);
        mostFrequentViaSort(array);
        mostFrequentViaHashTable(array);
        print2Smallest(array);
    }
}
