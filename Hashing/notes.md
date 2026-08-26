# HashMap / HashSet — Thinking Framework

## 1. The biggest clue: "Have I seen this value before?"

Whenever the question involves:

> "Have I already seen this element?"

think **HashSet / HashMap**.

Example:

```
nums = [1, 2, 3, 2]
```

Question:

> Does the array contain duplicates?

Your brute force thought might be:

```
For every element
    search the rest of the array
```

That's O(N²).

Then ask:

> "Can I remember the elements I've already seen?"

Yes:

```java
HashSet<Integer> set = new HashSet<>();
```

Then:

```java
if (set.contains(nums[i])) {
    // duplicate
}
set.add(nums[i]);
```

🚨 **Trigger phrase**

"already seen" / "seen before" / "duplicate" / "exists"
→ Think HashSet.

## 2. "How many times does each value occur?"

This is probably the strongest HashMap clue.

Example:

> Find the most frequent element.

You immediately think:

```
value → frequency
```

That's:

```java
HashMap<Integer, Integer>
```

Example:

```
2 → 3
5 → 2
7 → 1
```

🚨 **Trigger phrases**

- frequency
- frequency of each element
- most frequent
- least frequent
- appears k times
- count occurrences
- number of occurrences

→ Think frequency map.

## 3. "Find whether two things correspond"

Another important clue is when you need to store a relationship:

```
key → information
```

For example:

> Given numbers and their frequencies, find something based on the frequency.

or:

> Store each number and its index.

Then:

```java
HashMap<Integer, Integer>
```

For example:

```
nums = [10, 20, 30, 40]
```

You might store:

```
10 → 0
20 → 1
30 → 2
40 → 3
```

Then if you need the index of 30:

```java
map.get(30)
```

instead of scanning the array.

🚨 **Trigger idea**

"I need to remember something about a value."

Think:

```
value → information
```

## 4. "Find a pair" is a HUGE clue

Suppose:

> Find two numbers whose sum is target.

Brute force:

```
i
 j
```

Two loops → O(N²).

But ask:

> "For the current number, what number am I looking for?"

If:

```
nums[i] = 7
target = 10
```

we need:

```
10 - 7 = 3
```

So:

> "Have I already seen 3?"

That screams:

```
HashMap / HashSet
```

This gives the classic Two Sum pattern.

```
current number
      ↓
required number = target - current
      ↓
Have I seen it?
      ↓
HashMap / HashSet
```

🚨 **Trigger**

"Find a pair satisfying some condition."

Immediately ask:

> "Can I turn this into a lookup?"

If yes → HashMap/HashSet is a strong candidate.

## 5. "Find common elements" / "intersection"

Suppose:

```
nums1 = [1, 2, 3, 4]
nums2 = [3, 4, 5, 6]
```

Question:

> Which elements exist in both?

Brute force:

```
For every element in nums1
    search nums2
```

But instead:

```
Put nums2 into a HashSet
```

Then:

```java
if (set.contains(nums1[i])) {
    // common
}
```

Again the key idea is:

> Fast existence checking.

## 6. "Count something based on previous elements"

This is a slightly more advanced clue.

Suppose:

> How many pairs (i, j) have a particular property?

Instead of repeatedly searching previous elements, ask:

> "Can I store what I've already encountered?"

For example, if you're looking for pairs whose sum is k:

```
current = x
required = k - x
Have I seen required before?
HashMap/HashSet.
```

This pattern appears everywhere in pair/subarray problems.

## 7. "First/last occurrence of something"

Suppose:

> Find the first element that appears only once.

You may need:

```
value → frequency
```

So:

```java
HashMap<Integer, Integer>
```

Or:

> Find the first occurrence/index of each value.

Then:

```
value → index
```

Again:

```java
HashMap<Integer, Integer>
```

The important thing is:

> What information do I need to remember about each value?

## 8. The most important question to ask yourself

Whenever you're stuck, ask:

> "Am I repeatedly searching the array for something I've already seen?"

If the answer is yes, think HashMap/HashSet.

For example, brute force:

```
for every element
    search entire array
```

often means:

> Can I store information from the first pass?

Then:

```
Array
 ↓
HashMap / HashSet
 ↓
Fast lookup
```

## 9. HashSet vs HashMap — how to decide?

This distinction is very important.

**I only care whether something exists**

Use:

```java
HashSet<Integer>
```

Example:

- "Does 7 exist?"
- "Have I seen 7?"
- "Is this a duplicate?"

Think:

```
value → YES/NO
```

**I need information associated with the value**

Use:

```java
HashMap<Integer, Integer>
```

Example:

- value → frequency
- value → index
- value → count
- value → position
- value → some information

Think:

```
value → information
```

## 10. Your mental checklist ⭐

When solving an array problem, go through this:

```
                 ARRAY PROBLEM
                       ↓
          Am I repeatedly searching?
                       ↓
                     YES
                       ↓
          Can I remember what I've seen?
                       ↓
                ┌──────┴──────┐
                ↓             ↓
          Only existence    Need information
                ↓             ↓
             HashSet       HashMap
                              ↓
                    ┌─────────┼─────────┐
                    ↓         ↓         ↓
                 frequency   index     mapping
```

## 11. And don't forget frequency arrays

There is one more question:

> Can I use the value itself as an array index?

Suppose:

```
0 <= nums[i] <= 1000
```

Then instead of:

```java
HashMap<Integer, Integer> freq
```

you can often use:

```java
int[] freq = new int[1001];
```

So:

```
Need frequency
      ↓
Is value range small?
   /           \
 YES            NO
  ↓              ↓
freq array     HashMap
```

## 12. The biggest "HashMap smell" 🚨

If your brute-force solution looks like:

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // searching for something related to nums[i]
    }
}
```

STOP and ask:

> "Am I searching for the same information again and again?"

If yes, there is a good chance you can replace the repeated search with:

- HashSet → "Have I seen this?"
- HashMap → "What do I know about this?"

That is probably the most useful trick to develop.

## The 5 trigger words I'd memorize

When you see these in a problem, your brain should at least consider hashing:

1. **Seen** → HashSet
2. **Duplicate** → HashSet
3. **Frequency / Count** → HashMap
4. **Lookup / Exists** → HashSet/HashMap
5. **Pair / Complement** → HashMap/HashSet

And the deeper pattern behind all five is:

> "Can I trade extra space for faster lookup?"

That's really what hashing is giving you in most DSA problems: use O(N) memory to avoid repeatedly searching and bring the time down from O(N²) to roughly O(N).
