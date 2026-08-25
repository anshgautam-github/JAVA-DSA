// Given two sorted arrays, nums1 and nums2, return an array containing the intersection of these two arrays. 
// Each element in the result must appear as many times as it appears in both arrays; that is, if an element appears x times in nums1 and y times
// in nums2, it should appear min(x, y) times in the result.
// The intersection of two arrays is an array where all values are present in both arrays.

// Input: nums1 = [1, 2, 2, 3, 3, 3], nums2 = [2, 3, 3, 4, 5, 7]
// Output: [2, 3, 3]
// Explanation:
// The element 2 appears in both arrays only one time.
// The element 3 appears in both arrays two times so we add element 3 equal to its number of occurrences.


// Bruteforce : 
// We will have a loop on first arr, then we will match the element of that first arr with 2nd arr element, but at the same time, we will check
// Whether that 2nd arr element has already been taken by the first arr or not, for that, we will use visited array concept
class Solution {
    //Function to find intersection of two sorted arrays
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> ansList = new ArrayList<>();
        int[] visited = new int[nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                /*If nums1[i] is equal to nums2[j] and nums2[j] is not visited then add nums2[j] in ans.*/
                if (nums1[i] == nums2[j] && visited[j] == 0) {
                    ansList.add(nums2[j]);
                    // Mark as visited
                    visited[j] = 1;
                    break;
                } 
                 //If nums2[j] is greater than nums1[i], break out of loop
                else if (nums2[j] > nums1[i]) 
                    break; 
            }
        }
        // Convert ArrayList to int array
        int[] ans = new int[ansList.size()];
        for (int k = 0; k < ansList.size(); k++) {
            ans[k] = ansList.get(k);
        }
       //Return the final ans
        return ans;
    }
// Time Complexity: O(MxN), where M is the length of nums1 and N is the length of nums2.
// Space Complxity: O(N), where N is size of nums2, extra space to store answer is not considered.



// else if (nums2[j] > nums1[i]) :
// 
// Suppose: nums1 = [2, 5, 6] , nums2 = [1, 2, 3, 4, 7, 8]. Both arrays are sorted. We're currently checking: nums1[i] = 5
// We scan nums2:
// nums2 = [1, 2, 3, 4, 7, 8]
//                     ↑
//                     j
// At j:nums2[j] = 7
// Now:nums2[j] > nums1[i], means: 7 > 5,True. So we do: break;

// Why can we safely stop? Because nums2 is sorted:
// 1, 2, 3, 4, 7, 8
//             ↑
// Everything after 7 is going to be: 8, 9, 10, ... All of them are greater than 5.  So there is absolutely no possibility of finding: 5 later.
// Therefore: STOP SEARCHING That's what break is doing.


    


    
// // OPTIMAL :
// Declare two pointers, i for iterating through nums1 and j for iterating through nums2, and set both to 0. Initialize a vector or list to hold the intersection results.
// Use a while loop to continue the iteration as long as both pointers are within the bounds of their respective arrays.
// If the elements at nums1[i] and nums2[j] are equal, add that element to the results and increment both pointers i and j by 1.
// If nums1[i] is less than nums2[j], increment pointer i to check the next element in nums1.
// If nums2[j] is less than nums1[i], increment pointer j to check the next element in nums2.
// This process continues until either pointer exceeds the last index of its respective array.
public int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> tempList = new ArrayList<>();
        int i = 0, j = 0;
        // Traverse both arrays using two pointers approach
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } 
            // nums1[i] == nums2[j]
            else {
                tempList.add(nums1[i]);
                i++;
                j++;
            }
        }
        // Convert the list to an integer array
        int[] ans = new int[tempList.size()];
        for (int k = 0; k < tempList.size(); k++) {
            ans[k] = tempList.get(k);
        }
        // Return the intersection of two arrays
        return ans;
}
// Time Complexity: O(M+N), where M and N are the lengths of the given arrays.This is because both the arrays are traversed once.
// Space Complexity: O(min(m, n)), extra space to store answer is not considered.




// UNSORTED Array :

//     way 1 -> bruteforce code will work, remove the else if part.
//     way 2 ->
import java.util.*;
class Solution {
    public int[] intersectionArray(int[] nums1, int[] nums2) {

        // This HashMap will store:
        //
        // number → how many times it is still available
        //
        // Example:
        // nums1 = [1, 2, 2, 3, 3, 3]
        //
        // map will become:
        // 1 → 1
        // 2 → 2
        // 3 → 3
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // --------------------------------------------------
        // STEP 1: Count the frequency of every element in nums1
        // --------------------------------------------------

        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            // If the number is already in the map,
            // increase its frequency by 1.
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } 
            // If this is the first time we see the number,
            // put it in the map with frequency 1.
            else {
                map.put(num, 1);
            }
        }

        // This list will store our intersection result.
        List<Integer> result = new ArrayList<>();

        // --------------------------------------------------
        // STEP 2: Go through nums2 and look for matches
        // --------------------------------------------------

        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            // We can use this number only if:
            //
            // 1. It exists in nums1
            // 2. There is still at least one unused occurrence
            //
            // Example:
            // map.get(2) = 2
            //
            // This means we still have two 2's from nums1
            // available to match.
            if (map.containsKey(num) && map.get(num) > 0) {
                // We found a valid intersection element,
                // so add it to the result.
                result.add(num);
                // We have now used ONE occurrence of this number.
                //
                // Example:
                // Before:
                // 2 → 2
                //
                // After using one 2:
                // 2 → 1
                map.put(num, map.get(num) - 1);
            }
        }
        // --------------------------------------------------
        // STEP 3: Convert ArrayList<Integer> to int[]
        // --------------------------------------------------

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}


// Time Complexity: O(M + N) average
// We have three main loops: for (int i = 0; i < nums1.length; i++) → O(M) — build the frequency map.
// for (int i = 0; i < nums2.length; i++) → O(N) — find matching elements.
// for (int i = 0; i < result.size(); i++)→ O(min(M, N)) to convert the result.
// So: O(M) + O(N) + O(min(M,N)) which simplifies to: TC = O(M + N) average.

// Auxiliary Space: O(M)
// The main extra data structure is: HashMap<Integer, Integer> map
// In the worst case, every element in nums1 is different: nums1 = [1, 2, 3, 4, 5, ...] 
// So the map can contain M entries. Therefore: Auxiliary Space = O(M)
