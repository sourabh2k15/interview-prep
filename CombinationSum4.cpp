// recursive version, to be optimized using DP

class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        if(target == 0) return 1;        
        
        return combinationSum4(nums, 0, target);
    }
    
    int combinationSum4(vector<int>& nums, int i, int target){
        if(target == 0) return 1;
        if(target < 0 || i == nums.size())  return 0;
                
        int ways = 0;
        
        for(int j = i; j < nums.size(); j++){
            ways += combinationSum4(nums, i, target - nums[j]);
        }
        
        return ways;
    }
    
    // DP version, top down approach / memoization applied
    int combinationSum4(vector<int>& nums, int i, int target){
        if(target == 0) return 1;
        if(target < 0 || i == nums.size())  return 0;
        
        if(dp[i][target] == -1){
            int ways = 0;

            for(int j = i; j < nums.size(); j++){
                ways += combinationSum4(nums, i, target - nums[j]);
            }
            
            dp[i][target] = ways;
        }
        
        return dp[i][target];
    }
};
