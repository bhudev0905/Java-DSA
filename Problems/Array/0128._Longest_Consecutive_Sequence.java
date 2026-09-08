/*
 * Problem: Longest Consecutive Sequence
 * Difficulty: Medium
 * Topic: Array
 * Link: https://practice.geeksforgeeks.org/problems/longest-consecutive-sequence-1587115620/1
 *
 * Approach: Using Sorting, we can sort the array and then iterate through it to find the longest consecutive sequence. We keep track of the current count of consecutive numbers and update the result whenever we find a longer sequence.
 *
 * Time Complexity: O(nlogn) due to sorting the array
 * Space Complexity: O(1)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        // O(nlogn)
        int n = nums.length;
        if(n == 0 || n == 1){
            return n;
        }

        Arrays.sort(nums);
        int res = 1;

        int count = 1;
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1] + 1){
                count++;
            }
            else if(nums[i] == nums[i-1]){
                continue;
            }
            else{
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}