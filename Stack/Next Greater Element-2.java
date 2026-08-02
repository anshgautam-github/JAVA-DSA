// Given a circular integer array arr, return the next greater element for every element in arr.
// The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner.
// If it doesn't exist, return -1 for that element.


// BRUTEFORCE:
 public int[] nextGreaterElements(int[] arr) {
       
        int n = arr.length; 
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
       
        for(int i = 0; i < n; i++) {
            int currEle = arr[i];
            for(int j = 1; j < n; j++) {
                // Getting the hypothetical index
                int ind = (j + i) % n;
                // If the next greater element is found
                if(arr[ind] > currEle) {
                    // Store the next greater element
                    ans[i] = arr[ind];
                    // Break from the loop
                    break;
                }    
            }
        }
        return ans;
    }

// Time Complexity: O(N2) (where N is the size of given array)Using two nested for loops to find the next greater elements.
// Space Complexity: O(N) The space required to store the answer is O(N).
