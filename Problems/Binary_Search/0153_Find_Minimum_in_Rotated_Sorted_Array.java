/*
 * Problem: 153. Find Minimum in Rotated Sorted Array
 * Difficulty: Medium
 * Topic: Binary Search
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * Approach: Modified Binary Search
 *
 * Time Complexity: O(log N) where N is the number of elements in the array
 * Space Complexity: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        // Expected
        int low = 0, high = nums.length - 1;
        int min = 0;
    
        while (low < high) {
            int mid = (low + high) / 2;

            min = nums[mid];
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low == high){
            min = nums[low];
        }
        return min;
    }
}