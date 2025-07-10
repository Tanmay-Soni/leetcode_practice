/**
 * LeetCode Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * 💭 Thought Process:
 * - Since the array is sorted and rotated, I knew binary search would be the most efficient approach.
 * - I needed to find the pivot point — the only element smaller than both its neighbors — which is the minimum.
 * - If the subarray from low to high is already sorted, then the leftmost value is the minimum.
 * 
 * ✅ Final Approach:
 * - Start with low = 0 and high = nums.length - 1.
 * - In each iteration:
 *    - If nums[low] < nums[high], return nums[low] since it's already sorted.
 *    - Calculate mid and check if it is the minimum by comparing with neighbors.
 *    - If left part is sorted, move to the right half.
 *    - Else, move to the left half.
 * 
 * ⏱️ Time Complexity:
 * - O(log n), since binary search is applied.
 * 
 * 🧠 Space Complexity:
 * - O(1), since it’s done in-place without extra memory.
 * 
 * 🧪 Edge Cases:
 * - Empty array
 * - Array is not rotated (already sorted)
 * - Minimum is at the beginning or end
 * 
 * 📌 Notes:
 * - The `(mid == 0 || nums[mid - 1] > nums[mid]) && (mid == n - 1 || nums[mid + 1] > nums[mid])` condition helps detect the pivot safely.
 * - Using Binary search to narrow down the pivot point kept the solution O(log n) and robust against edge cases.
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