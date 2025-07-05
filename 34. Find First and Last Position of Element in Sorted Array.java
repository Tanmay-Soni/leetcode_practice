/**
 * LeetCode Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * 💭 Thought Process:
 * - Since the array is sorted, I knew binary search would be the most efficient approach.
 * - But finding the target once was not enough in this case as I needed the first and last occurence of the target.
 * - So I used two separate binary searches: one to find the first occurrence, one to find the last.
 * 
 * ✅ Final Approach:
 * - In `findFirst()`:
 *    - When I find the target, I check if it's the first index or the previous element is smaller.
 *    - If yes, I return that index. If not, I move left to keep searching.
 * - In `findLast()`:
 *    - When I find the target, I check if it's the last index or the next element is greater.
 *    - If yes, I return that index. If not, I move right to keep searching.
 * 
 * ⏱️ Time Complexity:
 * - O(log n) for both searches, so total is O(log n)
 * 
 * 🧠 Space Complexity:
 * - O(1), since I’m not using any extra space.
 * 
 * 🧪 Edge Cases:
 * - Empty array
 * - Target not in array
 * - Target at the very beginning or end
 * - Array with all elements equal to target
 * 
 * 📌 Notes:
 * - I avoided doing a linear search for finding the first or last occurence from the middle to prevent O(n) worst-case.
 * - Used Binary search to narrow down the exact first and last positions helped keeping O(log n) total time complexity.
 */
 class Solution {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[] {-1,-1};
        }

        int left = findFirst(nums, target);
        int right = findLast(nums, target);
        return new int[] {left, right};
    }

    private int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                // Check if this is the first occurrence
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findLast(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid + 1] > target){
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}