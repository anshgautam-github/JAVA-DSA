class Solution {   
    public boolean palindromeCheck(String s) {
        //your code goes here
        int left=0;
        int right=s.length()-1;
        return check(left, right, s);
    }
    public boolean check(int left, int right, String s){
        if(left >= right) return true;
        if(s.charAt(left)!=s.charAt(right)) return false;
        return check(left+1, right-1, s);
    }
}
