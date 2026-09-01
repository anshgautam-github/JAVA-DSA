class Solution {
    public int NnumbersSum(int N) {

        if (N == 0) return 0;

        int smallerSum = NnumbersSum(N - 1);
        int totalSum = N + smallerSum;

        return totalSum;
    }
}


// Time Complexity O(N) — The function makes N recursive calls to reach the base case, so the time complexity is proportional to the number of calls made
// Space Complexity O(N) — In the worst case, the recursion stack space would be full with all the function calls waiting to get completed and that would make it an 
// O(N) recursion stack space.
