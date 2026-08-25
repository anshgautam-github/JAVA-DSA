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

