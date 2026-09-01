class Solution {
    public long factorial(int n) {
        //your code goes here
        if(n <= 1) return 1;
        long sfct = factorial(n-1);
        return n * sfct;
    }
 }

// Time Complexity O(N) — The function makes N recursive calls to reach the base case, so the time complexity is proportional to the number of recursive calls
// Space Complexity O(N) — The call stack grows with each recursive call, using N stack frames, so the space complexity is proportional to the depth of recursion.
