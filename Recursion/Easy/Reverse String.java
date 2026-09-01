class Solution {
    public ArrayList<Character> reverseString(ArrayList<Character> s) {
        //your code goes here
        int left = 0;
        int right = s.size()-1;
        reverse(left,right,s);
        return s;
    }
    public void reverse(int left, int right, ArrayList<Character> s){
        if(left >= right) return;
        char temp = s.get(left);
        s.set(left,s.get(right));
        s.set(right,temp);
        reverse(left+1, right-1,s);
    }
}

// Time Complexity: O(N) - Each character in the string is processed exactly once, resulting in a linear time complexity relative to the length of the string.
// Space Complexity: O(N) - This is due to the recursion stack used in the process. In the worst case, the depth of the recursion is equal to the length of the string, 
// leading to linear space complexity.
