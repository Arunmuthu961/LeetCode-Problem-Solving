class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[j] stores the number of subsequences of s seen so far that match t[0...j-1]
        int[] dp = new int[n + 1];
        
        // Base case: an empty string t is a subsequence of any prefix of s
        dp[0] = 1;
        
        for (int i = 1; i <= m; i++) {
            // Iterate backwards through the target string to avoid using the current 
            // row's updated values (simulates the 2D logic dp[i-1][j-1])
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
                // If they don't match, dp[j] remains dp[j] (the value from the previous i)
            }
        }
        
        return dp[n];
    }
}
