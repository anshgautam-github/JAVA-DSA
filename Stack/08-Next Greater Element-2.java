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
            for(int j = i+1; j <= i+n-1; j++) {
                // Getting the hypothetical index
                int ind = (j % n);
                // If the next greater element is found
                if(arr[ind] > currEle) {
                    // Store the next greater element
                    ans[i] = arr[ind];
                    break;
                }    
            }
        }
        return ans;
    }

// Time Complexity: O(N2) (where N is the size of given array)Using two nested for loops to find the next greater elements.
// Space Complexity: O(N) The space required to store the answer is O(N).


//OPTIMIZED:
    public int[] nextGreaterElements(int[] arr) {
        
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        // Start traversing from the back
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Get the actual index
            int ind = i % n;
            // Get the current element
            int currEle = arr[ind];
            /* Pop the elements in the stack until the stack is not empty and the top element is not the greater element */
            while (!st.isEmpty() && st.peek() <= currEle) {
                st.pop();
            }
            
            // Store the answer for the second half
            if (i < n) {
                /* If the greater element is not found, stack will be empty */
                if (st.isEmpty()) 
                    ans[i] = -1;
                // Else store the answer
                else 
                    ans[i] = st.peek();
            }
            /* Push the current element in the stack  maintaining the decreasing order */
            st.push(currEle);
        }
        return ans;
    }

// Time Complexity: O(N) (where N is the size of the array)
// Traversing the hypothetical array takes O(2N) time, and traversing the stack will take overall O(2N) time, as all the elements are pushed into the stack once.

// Space Complexity: O(N)
// The answer array takes O(N) space, and the space used by the stack will be O(N) in the worst case.
