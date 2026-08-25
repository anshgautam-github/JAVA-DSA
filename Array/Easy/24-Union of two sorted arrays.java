// Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in asc.
// The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.
  
// BRUTEFORCE :
// Declare a set s to store all the unique elements and a vector or list union to store the final answer.
// Iterate through nums1 and nums 2 to store the elements in the set.
// Now, iterate in the set and copy all the elements of the set to the answer vector and return it.
class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
         Set<Integer> set = new TreeSet<>();
        // Insert all elements of nums1 into the set
        for (int num : nums1) {
            set.add(num);
        }
        // Insert all elements of nums2 into the set
        for (int num : nums2) {
            set.add(num);
        }
        // Convert the set to an integer array to get the union
        int[] union = new int[set.size()];
        int index = 0;
        for (int num : set) {
            union[index++] = num;
        }
        return union;
    }
 }
// Time Complexity: O( (M+N)log(M+N) ), at max set can store M+N elements {when there are no common elements and elements in nums1 , nums2 are 
// distntict}. So Inserting M+N th element takes log(M+N) time. Upon approximation across inserting all elements in worst, 
// it would take O((M+N)log(M+N) time.
// Space Complexity: O(M+N), considering space of Union Array.



// // OPTIMAL :
// Initialize two variable i to iterate nums1 and j to iterate nums2 as 0.
// Create an empty vector for storing the union of nums1 and nums2.
// If current element of nums1 is equal to current element of nums2, this means its a common element, so insert only one element in the union & increment it by 1.
// If current element of nums1 is less than current element of nums2, insert current element of nums1 in union. Also check if last element in union vector is not equal to nums1[ i ],then insert in union else don’t insert. After checking increment i.
// If current element of nums1 is greater than current element of nums2, insert current element of nums2 in union. Similar to last point, check if the last element in the union vector is not equal to nums2[ j ], then insert in the union, else don’t insert. After checking increment j.

class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> UnionList = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;

        while (i < n && j < m) {
             // Case 1 and 2
            if (nums1[i] <= nums2[j]) {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                    UnionList.add(nums1[i]);
                }
                i++;
            } 
            // Case 3
            else {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                    UnionList.add(nums2[j]);
                }
                j++;
            }
        }
        // Add remaining elements of nums1, if any
        while (i < n) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                UnionList.add(nums1[i]);
            }
            i++;
        }
        // Add remaining elements of nums2, if any
        while (j < m) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                UnionList.add(nums2[j]);
            }
            j++;
        }
        // Convert List<Integer> to int[]
        int[] Union = new int[UnionList.size()];
        for (int k = 0; k < UnionList.size(); k++) {
            Union[k] = UnionList.get(k);
        }
        return Union;
    }

// Time Complexity: O(M+N), because both the arrays must be traversed once.
// Space Complexity: O(M+N), considering the space for returning the output, which in the worst case, can contain all the elements from both arrays.





// How would you handle unsorted input arrays?
// If the input arrays are unsorted: Sort each array first O(mlogm) and O(nlogn)). Apply the two-pointer approach or merge logic.
// This approach would have an overall time complexity of O(mlogm+nlogn+m+n). Arrays.sort(num1), Arrays.sort(num2)
// or elsee the first code works well
