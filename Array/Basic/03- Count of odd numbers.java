// Given an array of n elements. The task is to return the count of the number of odd numbers in the array.

class Solution{
    public int countOdd(int[] arr, int n) {
       int count =0;
       for(int i=0; i<n; i++){
        if(arr[i]%2!=0){
            count++;
        }
       }
       return count;
    }
}

// Time Complexity : O(N)
// SC : O(1)
