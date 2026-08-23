public class Main {

    public static int sum(int arr[], int n) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int result = sum(arr, arr.length);
        System.out.println(result);
    }
}
// Time Complexity : O(N), because each element in the array is processed exactly once.
// Space Complexity : O(1), because only couple of variable are used.
