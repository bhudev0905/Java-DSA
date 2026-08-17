/*
 * Problem: Nearest Available Drone
 * Difficulty: Easy
 * Topic: Weekly Contest 515
 * Link: https://leetcode.com/problems/nearest-available-drone/description/
 *
 * Approach: HashMap to store the distance and index of drones that can reach the target. Iterate through the drones, calculate the distance to the target, and check if it is within the drone's range. If it is, add it to the map. Finally, find the minimum distance in the map and return the corresponding index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public int nearestDrone(int[][] drones, int[] target) {

        int n = drones.length;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int d = Math.abs(drones[i][0] - target[0])
                  + Math.abs(drones[i][1] - target[1]);

            if (d <= drones[i][2]) {
                
                if (!map.containsKey(d)) {
                    map.put(d, i);
                }
            }
        }

        if (map.isEmpty())
            return -1;

        for (int key : map.keySet()) {
            if (key < min) {
                min = key;
            }
        }

        return map.get(min);
    }
}