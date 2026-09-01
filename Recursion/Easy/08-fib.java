    public int fib(int n) {
        // Base cases: F(0) = 0, F(1) = 1
        if (n == 0) return 0;
        if (n == 1) return 1;
        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fib(n - 1) + fib(n - 2);
    }


// Time Complexity O(2^N) — Each function call makes two more calls (for n-1 and n-2), resulting in an exponential growth in the number of calls.

// Space Complexity O(N)— The call stack grows with each recursive call, using N stack frames, so the space complexity is proportional to the recursion depth.
