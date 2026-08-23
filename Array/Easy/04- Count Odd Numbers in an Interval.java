class Solution {
    public int countOdds(int low, int high) {
        int count =0;
        for(int i=low ; i<=high; i++){
            if(i%2 != 0) count ++;
        }
        return count;
    }
}

// TC = O(high - low)
// SC = O(1)
// code is logically correct, but it gets TLE(Time limit exceed) because you're checking every number from low to high
// In your testcase: low  = 0, high = 1,000,000,000 . That's 1 billion iterations 😭


// The trick: Don't count every number . We can mathematically calculate how many odd numbers exist.
// For example:
// 0 1 2 3 4 5 6 7 8 9
//   ↑   ↑   ↑   ↑
//   1   3   5   7   9
// From 0 to 9, there are 5 odd numbers.
// A very useful formula is:
// number of odds from 0 to N
// = (N + 1) / 2
// Because Java integer division removes the decimal part.
// For example: N = 9 => (9 + 1) / 2 => 10 / 2 => 5


// For a range [low, high] : We want: odds from 0 to high - odds from 0 to low-1
// So: (high + 1) / 2 - low / 2

class Solution {
    public int countOdds(int low, int high) {

        return (high + 1) / 2 - low / 2;
    }
}

// Time  = O(1)
// Space = O(1)
