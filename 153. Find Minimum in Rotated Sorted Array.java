/**
 * LeetCode Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * 💭 Thought Process:
 * - My idea was to always move toward the unsorted side of the array, since the min has to lie there.
 * - If the right half is sorted, the minimum must be in the left half or at mid.
 * - If the left half is sorted, the minimum must be in the right half.
 * 
 * ✅ Final Approach:
 * - Initialize low = 0, high = nums.length - 1.
 * - While low < high:
 *    - Find the mid index.
 *    - If nums[mid] < nums[high], the right half is sorted → shrink to the left side (high = mid).
 *    - Else, the left half is sorted → move to the right side (low = mid + 1).
 * - When loop ends, low == high and points to the minimum element.
 * 
 * ⏱️ Time Complexity:
 * - O(log n), due to binary search.
 * 
 * 🧠 Space Complexity:
 * - O(1), no extra space used.
 * 
 * 🧪 Edge Cases:
 * - Empty array → return -1
 * - Array is already sorted → handled in loop naturally
 * - Minimum is at the end or beginning
 * 
 * 📌 Notes:
 * - Avoided guessing early; instead let binary search converge on the minimum.
 * - This version is safe and clean even for edge cases like small arrays.
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If the right half is sorted, the min must be in the left half (or at mid)
            if (nums[mid] < nums[high]) {
                high = mid;
            }
            // If the left half is sorted, the min must be in the right half
            else {
                low = mid + 1;
            }
        }

        return nums[low];
    }
}