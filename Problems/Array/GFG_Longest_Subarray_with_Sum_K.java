/*
 * Problem: Longest Subarray with Sum K
 * Difficulty: Medium
 * Topic: Array, Matrix
 * Link: https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
 *
 * Approach: Prefix Sum + HashMap
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
	public int longestSubarray(int[] arr, int k) {
		// code here
		// Optimal - Prefix Sum
		Map<Integer, Integer> map = new HashMap<>();
		int maxlen = 0;
		int prefixSum = 0;
		
		for (int i = 0; i<arr.length; i++) {
			prefixSum += arr[i];
			
			if (prefixSum == k) {
				maxlen = i + 1;
			}
			
			if (map.containsKey(prefixSum - k)) {
				int prevIndex = map.get(prefixSum - k);
				maxlen = Math.max(maxlen, i - prevIndex);
			}
			
			if (!map.containsKey(prefixSum)) {
				map.put(prefixSum, i);
			}
		}
		
		return maxlen;
	}
}
