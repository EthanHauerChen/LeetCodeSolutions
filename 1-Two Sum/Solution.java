//https://leetcode.com/problems/two-sum/description/

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> differences = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            differences.put(target - nums[i], i); 
        }
        for (int i = 0; i < nums.length; i++) {
            if (differences.containsKey(nums[i]) && differences.get(nums[i]) != i) {
                return new int[] {differences.get(nums[i]), i};
            }
        }
        return new int[] {0, 0};
    }
}