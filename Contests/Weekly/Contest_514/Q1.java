/*
 * Problem: 4041. Minimum Price
 * Difficulty: Medium
 * Topic: Weekly Contest 514
 * Link: https://leetcode.com/problems/minimum-price/description/
 *
 * Approach: Sort both arrays and apply discounts to the most expensive items
 *
 * Time Complexity: O(nlogn + mlogm)
 * Space Complexity: O(1)
 */
class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int n = prices.length;
        int m = discounts.length;

        int i = n-1, j = m-1;
        double sum = 0;
        while(j>=0 && i>=0){
            double final_price = ( prices[i] * ( 100 - discounts[j] ) ) / 100.0;
            sum += final_price;
            i--;
            j--;
        }
        while(i>=0){
            sum += prices[i];
            i--;
        }
        
        return sum;
    }
}