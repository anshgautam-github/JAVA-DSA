// Given an array arr of n elements. The task is to reverse the given array. The reversal of array should be inplace.

class Solution {
    public void reverse(int[] arr, int n) {
        
        int [] ans = new int[n];
        for(int i = n-1 ; i>=0 ; i--){
            ans [n-i-1] = arr[i];
        }

        for(int i = 0 ; i<n ; i++){
            arr[i] = ans[i];
        }
    }
}


// Time Complexity: O(N), A single-pass of the array with N elements is being done to reverse the array
// Space Complexity: O(1), no extra data structure is being used so no extra space.
