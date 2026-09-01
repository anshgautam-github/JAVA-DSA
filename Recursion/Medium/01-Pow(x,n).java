// Implement the power function pow(x, n) , which calculates the x raised to n i.e. xn. Note : In output print 6 digits places after decimal point.

// We want: pow(x, n) = xⁿ
// For example: x = 2, n = 5   => 2⁵ = 32
// The most obvious mathematical relationship is:  x^n = x \times x^{n-1} 
// So:  pow(x,n) = x \times pow(x,n-1)  That is already a recurrence relation.



// Way -1 :
class Solution {
    public double myPow(double x, int n) {
          //your code goes here
          if(n==0) return 1.0;
          return x*myPow(x,n-1);
    }
}
// For n = 100: 100 → 99 → 98 → ... → 1 → 0 So there are roughly n recursive calls.
// Time Complexity :O(n)
// Space Complexity Because of the recursion stack : O(n)

// The above solution is not the best approach.
// Why? Because we're decreasing n by only 1.
// For: n = 1,000,000 we would make approximately: 1,000,000 recursive calls That's too slow.
// So now we ask our second important recursion question: Can I make the problem smaller by more than just 1? This is where the real trick comes in.


// Way -2 :
// Look at powers differently
// Suppose we want:  x^8 
// Instead of: x^8 = x \times x^7 
// we can say: x^8 = x^4 \times x^4 
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) { // -ve case
            x = 1 / x;
            N = -N;
        }
        return myPowPositive(x, N);
    }

    private double myPowPositive(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n % 2 == 0) { // even
            return myPowPositive(x * x, n / 2);
        }
        return x * myPowPositive(x, n - 1); // odd 
    }
}
// Time Complexity : The time complexity is O(log N) due to the halving of n in the even case and linear reduction in the odd case.
// Space Complexity :The space complexity is O(log n) because of the recursive call stack depth.


// We are effectively halving for both even and odd cases, but the odd case takes one extra step first.
// Even n : Directly halve: n = 8 , 8 → 4 → 2 → 1
// Because: myPow(x * x, n / 2)

// Odd n : First reduce by 1: n = 7 -> 7 → 6 . Now 6 is even, so then halve: 6 → 3 → 2 → 1
// Overall: 7 → 6 → 3 → 2 → 1 So odd numbers do: odd → odd - 1 → half while even numbers do: even → half
