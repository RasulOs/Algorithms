/*
Find next greater number with same set of digits
Given a number n, find the smallest number that has same set of digits as n and is greater than n.
If n is the greatest possible number with its set of digits, then print “not possible”.

Examples:
For simplicity of implementation, we have considered input number as a string.

Input:  n = "218765"
Output: "251678"

Input:  n = "1234"
Output: "1243"

Input: n = "4321"
Output: "Not Possible"

Input: n = "534976"
Output: "536479"


Following are few observations about the next greater number.

1. If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.

2. If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.

3. For other cases, we need to process the number from rightmost side (why? because we need to find the
smallest of all greater numbers)


*/



package main.medium;

import java.util.Scanner;

public class NextGreaterNumber {

    public static int PermutationStep(int num) {

        // Convert num to array
        String numString = Integer.toString(num);
        int[] numberArray = new int[numString.length()];

        for(int i = 0; i < numString.length(); i++) {
            numberArray[i] = numString.charAt(i) - '0';
        }

        // Find the smallest possible int to change and the sort everything after it
        for(int i = numberArray.length - 1; i >= 0; i--) {
            for(int j = numberArray.length - 1; j >= i; j--) {
                if(numberArray[j] > numberArray[i]) {
                    swap(numberArray, i, j);
                    sortArrayAfterIndex(numberArray, i + 1);
                    return convertArrayToInt(numberArray);
                }
            }
        }

        // Else return false
        return -1;
    }

    // This function sorts an array after some position (index)
    // It has 2 implementations, 1 - using library, 2 - using selection sort
    public static void sortArrayAfterIndex(int[] array, int index) {

        // We can use this special function but also we can implement it ourself
        //Arrays.sort(array, index, array.length);


        // Using selection sort
        for(int i = index; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }


    }

    public static int convertArrayToInt(int[] array) {
        int result = 0;
        for(int i = 0; i < array.length; i++)
            result = result * 10 + array[i];

        return result;
    }

    public static void swap(int[] array, int a, int b) {
        int temporary = array[a];
        array[a] = array[b];
        array[b] = temporary;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(PermutationStep(s.nextInt()));



    }

}
