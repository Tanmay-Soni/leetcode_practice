/**
 * LeetCode Problem: https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * 💭 Thought Process:
 * - Each row in the matrix is sorted, and the first element of each row is greater than the last of the previous.
 * - This means I can treat the entire 2D matrix like a sorted 1D array.
 * - That lets me use regular binary search by just converting indices properly.
 * 
 * ✅ Final Approach:
 * - I flattened the 2D matrix mentally and used binary search on the range [0, m * n - 1].
 * - For any mid index:
 *    - Row index = mid / number of columns
 *    - Column index = mid % number of columns
 * - I used this to access the matrix elements as if it were a single sorted list.
 * 
 * ⏱️ Time Complexity:
 * - O(log(m * n)) since it's just binary search on a virtual array.
 * 
 * 🧠 Space Complexity:
 * - O(1), no extra space used.
 * 
 * 🧪 Edge Cases:
 * - Matrix is empty or has no rows
 * - Target is smaller than the first element or larger than the last
 * 
 * 📌 Notes:
 * - I basically imagined the matrix as one straight list and used binary search as usual.
 * - The only catch is converting the 1D index back to row and column to access the right value.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m * n) - 1;
        int mid;

        while(low <= high){
            mid = low + (high- low)/2;
            int rowMid = mid/n;
            int colMid = mid % n;

            if(matrix[rowMid][colMid] == target) {
                return true;
            } else if(matrix[rowMid][colMid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}