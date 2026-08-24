// Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique element appears only once.
// Return the number of unique elements in the array.

// Example 1
// Input: nums = [0, 0, 3, 3, 5, 6]
// Output: 4
// Explanation: Resulting array = [0, 3, 5, 6, _, _] .There are 4 distinct elements in nums and the elements marked as _ can have any value.

// Bruteforce :
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            s.add(nums[i]);
        }
        int k = s.size();
        int j=0;
        for(int val :s){
            nums[j++]=val;
        }
        return k;
    }
// }
// Time Complexity: O(N * log N) + O(N), for using hashset, it will take O(N * log N) and also to traverse the array once O(N). Here N is the size of the array.
// Space Complexity: O(N) because in the worst case, all the elements of the array can be unique and it will take O(N) space. Here N represents the size of the array.


// OPTIMAL : 
// 1-Initialize 2 variables i as 0 and variable j as 1, where i will track the position of the last unique element found and j will iterate through the array to find new unique elements.
// 2-Iterate in array using j from second element to the end of the array.
// 3-If the element at position j is different from the element at position i, it means a new unique element is found. This is because the array is sorted in non-decreasing order, so any new element that is different from the previous one must be unique.
// 4-When a new unique element is found, increment i to move to the next position for storing unique elements. Copy the element at position j to the new position at i. This ensures that the first i + 1 elements of the array are all unique.


// i → where my unique elements are
// j → searching for the next unique element

class Solution {
    public int removeDuplicates(int[] nums) {
        // Initialize pointer for unique elements
        int i = 0;
        // Iterate through the array
        for (int j = 1; j < nums.length; j++) {
            /*If current element is different 
            from the previous unique element*/
            if (nums[i] != nums[j]) {
                /* Move to the next position in 
                the array for the unique element*/
                i++;
                /* Update the current position 
                   with the unique element*/
                nums[i] = nums[j];
            }
        }
        // Return the number of unique elements
        return i + 1;
    }
}




// The logic is NOT: "nums[i] != nums[j], therefore increase i." That's just the condition that tells us we found something new.
// The actual reasoning is:
// nums[i] != nums[j]
//         ↓
// We found a NEW unique value
//         ↓
// We need to store it
//         ↓
// Where?
//         ↓
// Immediately after the previous unique value
//         ↓
// i + 1
//         ↓
// So first do i++
//         ↓
// Then nums[i] = nums[j]


// Time Complexity: O(N), for single traversal of the array, where N is the size of the array.
// Space Complexity: O(1), not using any extra spac
