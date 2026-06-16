class Solution {
public:
    int fun(int buy, int i, int n,vector<int>&arr,vector<vector<int>>&dp) {
        if(i==n) return 0;
        if(dp[buy][i] != -1) return dp[buy][i];
        int res = 0;
        if(buy) {
            int sold = arr[i] + fun(!buy,i+1,n,arr,dp);
            int not_sold = fun(buy,i+1,n,arr,dp);
            res = max(sold,not_sold); 
        }
        else {
            int take = -arr[i] + fun(!buy,i+1,n,arr,dp);
            int not_buy = fun(buy,i+1,n,arr,dp);
            res = max(take,not_buy);
        }
        return dp[buy][i] = res;
    }
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp (2,vector<int>(n,-1));
        return fun(0,0,n,prices,dp);
    }
};