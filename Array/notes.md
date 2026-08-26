
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
When you see a rearrangement problem, don't immediately think of sorting, swapping, or nested loops.

Ask these questions in order:

Question 1: What must the final positions look like?
Here: 
+ - + - + -
That immediately gives: even indices → + , odd indices → -

Question 2: Does relative order matter? Yes.
The problem says the order among same-sign elements must be preserved.
So: positives: 3 → 1 → 2 , must stay: 3 → 1 → 2 Therefore, don't sort them.
  
Question 3: Do I need to search for a position? No!
The sign itself tells us exactly where the element goes: positive → next even position , negative → next odd position
That eliminates searching. And once you eliminate searching, you get: ONE PASS → O(n).

------------------------------------------------------------------------------------------------------------------------------------------------When you see: "For every element, calculate something involving all the other elements."

Your first thought can be: For each i scan everything else
That's your brute force: O(N²)

Then ask: "Am I repeatedly calculating the same information?"
Here, yes.
Then look for prefix/suffix information: LEFT of i  ×  RIGHT of i

That gives:
Brute force
    ↓
Notice repeated multiplication
    ↓
Split into left + right
    ↓
Prefix/suffix products
    ↓
Reuse answer array
    ↓
O(N) time, O(1) auxiliary space

------------------------------------------------------------------------------------------------------------------------------------------------


The general lesson is not:
"Whenever something excludes the current element, use prefix/suffix."
Rather, think:
When the answer for each index depends on the elements around it, and repeatedly calculating those elements would be expensive, look for prefix/suffix information.

"If I need information from both sides of every index, think prefix/suffix. Then ask whether I can calculate those values on the fly instead of storing entire arrays."


The straightforward prefix/suffix approach is:
prefix array
suffix array
     ↓
multiply them
     ↓
answer
That takes:
O(N) extra space
Then we realized:
We don't actually need to store both arrays.
We can:
First pass:
    calculate prefix products
    store them directly in answer[]

Second pass:
    calculate suffix product on the fly
    multiply it into answer[]
So:
Prefix → stored in answer[]
Suffix → stored temporarily in one variable
giving:
Time = O(N)
Auxiliary Space = O(1)
