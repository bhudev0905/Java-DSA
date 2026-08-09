/*
 * Problem: 81. Search in Rotated Sorted Array II
 * Difficulty: Medium
 * Topic: Binary Search
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * Approach: Modified Binary Search
 *
 * Time Complexity: O(log N) in average case, O(N) in worst case where N is the number of elements in the array
 * Space Complexity: O(1)
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]==nums[low] && nums[mid]==nums[high]){
                low++;
                high--;
            }

            //left sorted
            else if(nums[mid]>=nums[low]){
                if(nums[low]<=target && nums[mid]>=target){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            //right sorted
            else if(nums[mid]<=nums[high]){
                if(nums[mid]<=target && nums[high]>=target){
                    low = mid + 1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}