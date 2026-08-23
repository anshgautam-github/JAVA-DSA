// Given an array arr of size n, the task is to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order.
// If the array is sorted then return True, else return False.

class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
       boolean isAsc = true;
       boolean isDesc = true;
       for (int i =0; i<n-1 ; i++){
        if(arr[i]>arr[i+1]) isAsc = false;
        if(arr[i]<arr[i+1]) isDesc = false;
       }
       return isAsc || isDesc;
        // It means: Return true if isAsc OR isDesc is true.
    }
}

// Simply remember : A || B means: "Is A true OR B true?"
// | A | B | A || B |
// |---|---|---|
// | true | true | true |
// | true | false | true |
// | false | true | true |
// | false | false | false |

// Time Complexity: O(N)
// Perform a single traversal through the array, making a constant-time comparison for each element.

// Space Complexity: O(1)
// A constant amount of extra space for variables is used, independent of the input size.
