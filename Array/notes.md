
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

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
