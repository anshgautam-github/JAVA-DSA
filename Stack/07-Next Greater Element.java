// Given an array arr of size n containing elements, find the next greater element for each element in the array in the order of their appearance.
// The next greater element of an element in the array is the nearest element on the right that is greater than the current element.
// If there does not exist a next greater element for the current element, then the next greater element for that element is -1.


// BRTUTEFORCE : 
 public int[] nextLargerElement(int[] arr) {
        
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i = 0; i < n; i++) {
          
            int currEle = arr[i];
            for(int j = i + 1; j < n; j++) {
                if(arr[j] > currEle) {
                    ans[i] = arr[j];
                    break;
                }    
            }
        }
        return ans;
    }
// Time Complexity: O(N2) (where N is the size of given array)  Using two nested for loops to find the next greater elements.
// Space Complexity: O(N) The space required to store the answer is O(N).


//OPTIMAL :
public int[] nextLargerElement(int[] arr) {
        
        int n = arr.length; 
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            int currEle = arr[i];
            while(!st.isEmpty() && 
                  st.peek() <= currEle) {
                st.pop();
            }
            if(st.isEmpty()) 
                ans[i] = -1;
            else 
                ans[i] = st.peek();
            st.push(currEle);
        }
        return ans;
    }

// Time Complexity: O(N) (where N is the size of the array)
// Traversing the array takes O(N) time, and traversing the stack will take overall O(N) time, as all the elements are pushed into the stack once.
// Space Complexity: O(N) The answer array takes O(N) space, and the space used by the stack will be O(N) in the worst case.
