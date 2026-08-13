/*
 * Problem: 540. Single Element in a Sorted Array
 * Difficulty: Medium
 * Topic: Binary Search
 * Link: https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * Approach: Use a HashMap to count the occurrences of each element in the array. Then, iterate through the map to find the element that occurs only once.
 *
 * Time Complexity: O(N) where N is the number of elements in the array
 * Space Complexity: O(N)
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        for (int key : map.keySet()) {
            if (map.get(key) == 1)
                return key;
        }
        return 0;
    }
}