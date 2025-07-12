import java.util.Arrays;

class LookupMissingNumber {
    // // Approach 1: Brute Force - O(n) Time complexity
    // private static int findMissingNum(int[] inputArr){
    //     for(int i = 0; i < inputArr.length - 1; i++){
    //         if(inputArr[i] != (i + 1)){
    //             return i + 1;
    //         }
    //     }
    //     return -1;
    // }

    // Approach 2: Optimal - O(log(n)) Time complexity
    private static int findMissingNum(int[] inputArr){
        int low = 0, high = inputArr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(inputArr[mid] == mid + 1){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + 1;
    }

    public static void main(String[] args){
        int[] case1 = {1, 2, 3, 4, 6, 7, 8};
        System.out.println("Input Array: " + Arrays.toString(case1));
        System.out.println("Missing Integer: " + findMissingNum(case1) + '\n');

        int[] case2 = {1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println("Input Array: " + Arrays.toString(case2));
        System.out.println("Missing Integer: " + findMissingNum(case2));
    }
}