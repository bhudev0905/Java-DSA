/*
 * Problem: 1. Two Sum
 * Difficulty: Easy
 * Topic: Array, Hash Table
 * Link: https://leetcode.com/problems/two-sum/description/
 *
 * Approach: Hash Table
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // One Pass
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[] { i, map.get(complement) };
            else
                map.put(nums[i], i);
        }
        return new int[]{};
    }
}