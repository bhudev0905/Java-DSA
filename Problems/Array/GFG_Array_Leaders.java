/*
 * Problem: Leaders in an Array
 * Difficulty: Easy
 * Topic: Array
 * Link: https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
 *
 * Approach: Right-to-Left Traversal
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int[] maxi = new int[n-1];
        
        for(int i=n-1; i>0; i--){
            max = Math.max(max, arr[i]);
            maxi[i-1] = max;
        }
        
        for(int i=0; i<n-1; i++){
            if(arr[i] >= maxi[i]){
                list.add(arr[i]);
            }
        }
        list.add(arr[n-1]);
        return list;
    }
}
