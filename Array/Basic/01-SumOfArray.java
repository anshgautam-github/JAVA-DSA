public  int sum(int arr[], int n) {
      int sum = 0;
      for(int i =0;i<n;i++){
        sum+=arr[i];
      }
      return sum;
}

// Time Complexity : O(N), because each element in the array is processed exactly once.
// Space Complexity : O(1), because only couple of variable are used.
