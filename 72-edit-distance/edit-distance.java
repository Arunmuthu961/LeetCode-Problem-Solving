class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] will be the edit distance between the first i chars of word1 
        // and the first j chars of word2
        int[][] dp = new int[m + 1][n + 1];

        // Base Case: If word2 is empty, we must delete all chars of word1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Base Case: If word1 is empty, we must insert all chars of word2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Chars match, no extra operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Take the minimum of (Replace, Insert, Delete) + 1
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], 
                                   Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[m][n];
    }
}
