class Solution {
    public int uniquePaths(int m, int n) {
        // We only need an array of size n (columns)
        int[] dp = new int[n];
        
        // Base case: There's only 1 way to reach any cell in the first row
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        // Fill the DP table row by row
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The new value of dp[j] is the old dp[j] (from above) 
                // plus the new dp[j-1] (from the left)
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}
