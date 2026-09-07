/*
 * Problem: Count Good Rotations
 * Difficulty: Medium
 * Topic: Weekly Contest 518
 * Link: https://leetcode.com/problems/count-good-rotations/description/
 *
 * Approach: We can use prefix sums to calculate the sum of the first n/2 elements after each rotation. For each rotation, we check if the sum of the first half is greater than the sum of the second half. If it is, we increment the count.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int m = n / 2;

        // Prefix sum
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long totalSum = prefix[n];
        int count = 0;

        for (int k = 0; k < n; k++) {

            // Sum of first n/2 elements after rotation
            long firstHalf;

            if (k + m <= n) {
                // No wrapping
                firstHalf = prefix[k + m] - prefix[k];
            } else {
                // Wrapped part:
                // nums[k ... n-1] + nums[0 ... (k+m-n-1)]
                firstHalf =
                    (prefix[n] - prefix[k]) +
                    prefix[k + m - n];
            }

            // Last half = total - first half
            long lastHalf = totalSum - firstHalf;

            if (firstHalf > lastHalf) {
                count++;
            }
        }

        return count;
    }
}