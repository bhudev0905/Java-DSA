/*
 * Problem: 4043. Count Rotations With Exactly K Equal Adjacent Pairs
 * Difficulty: Easy
 * Topic: Weekly Contest 518
 * Link: https://leetcode.com/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/description/
 *
 * Approach: Brute force approach. For each rotation, we can check the number of equal adjacent pairs and compare it with k. If it matches, we increment the count.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
class Solution {
    public int countRotations(String s, int k) {
        // Brute
        StringBuilder str = new StringBuilder(s);
        String prefix = "";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            prefix += s.charAt(i);
            String res = str.substring(i + 1);
            res += prefix;

            int score = 0;
            for (int j = 0; j < s.length() - 1; j++) {
                if (res.charAt(j) == res.charAt(j + 1)) {
                    score++;
                }
            }

            if (score == k) {
                count++;
            }
        }
        return count;
    }
}