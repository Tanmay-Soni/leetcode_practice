/**
 * LeetCode Problem: https://leetcode.com/problems/find-peak-element/
 * 
 * 💭 Thought Process:
 * - A peak element is defined as one that is greater than both its neighbors.
 * - Since the array is not necessarily sorted, I used binary search to find one such peak.
 * - At every step, I check if the current `mid` is a peak.
 * - If not, I determine the slope direction and move toward the side that must contain a peak.
 * 
 * ✅ Final Approach:
 * - Use binary search with `low = 0` and `high = nums.length - 1`.
 * - In each iteration:
 *    - Check if `nums[mid]` is greater than both neighbors — return `mid` if yes.
 *    - If the slope is going up (right neighbor is greater), search the right side.
 *    - If the slope is going down (left neighbor is greater), search the left side.
 * - The condition `(mid == 0 || nums[mid] > nums[mid - 1])` and `(mid == n - 1 || nums[mid] > nums[mid + 1])` 
 *   ensures safety at boundaries.
 * 
 * ⏱️ Time Complexity:
 * - O(log n) — standard binary search performance.
 * 
 * 🧠 Space Complexity:
 * - O(1) — no extra memory used.
 * 
 * 🧪 Edge Cases:
 * - Single element → it's always a peak.
 * - Peak at the beginning or end of array.
 * - Multiple peaks — the method will return any one of them.
 * 
 * 📌 Notes:
 * - This version directly checks for the peak condition using neighbors.
 * - It’s more explicit than slope-based binary search and handles edge indices safely.
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            // Case: Check if mid is peek
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            } 
            // Case: Check if slope is going up
            else if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 ||  nums[mid] < nums[mid + 1])){
                low = mid + 1;
            } 
            // Default Case: Slope is going down
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}