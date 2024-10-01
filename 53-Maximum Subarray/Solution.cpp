https://leetcode.com/problems/maximum-subarray/description/

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int currentMax = 0;
        int max = nums[0];
        bool allNegative = true;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] + currentMax >= 0) {
                currentMax += nums[i];
                allNegative = false;
                max = std::max(currentMax, max);
            }
            else if (allNegative) {
                max = std::max(max, nums[i]);
                cout << max;
            }
            else 
                currentMax = 0;
            
        }
        return max;
    }
};