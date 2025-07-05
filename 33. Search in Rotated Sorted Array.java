/**
 * LeetCode Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * 💭 Thought Process:
 * - The array is sorted but rotated at some pivot point.
 * - So, at any given time, one half of the array (left or right) is always sorted.
 * - We can use that property to determine which half might contain the target.
 * - Based on the sorted half and where the target lies, we discard the irrelevant half.
 * 
 * ✅ Final Approach:
 * - Use binary search to reduce time complexity.
 * - In each step:
 *    - Check if mid is the target.
 *    - Identify the sorted half.
 *    - Narrow the search into hald space accordingly maitaing O(log n) runtime.
 * 
 * ⏱️ Time Complexity:
 * - O(log n) — binary search on a rotated array
 * 
 * 🧠 Space Complexity:
 * - O(1) — constant space, no extra data structures used
 * 
 * 🧪 Edge Cases:
 * - Target not present in array
 * - Array not rotated (normal sorted array)
 * 
 * 📌 Notes:
 * - The key trick was recognizing that one half is always sorted, which allows binary search to still work.
 */
class Solution {
    public int search(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            //Case 1: Left array sorted
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] >= target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            //Case 2: Right array sorted
            else {
                if(nums[right] >= target && nums[mid] <= target){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}