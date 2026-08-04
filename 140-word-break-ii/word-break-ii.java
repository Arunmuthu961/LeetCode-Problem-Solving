import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    // Memoization map to store substrings and their corresponding valid sentences
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(s, wordSet);
    }

    private List<String> backtrack(String s, Set<String> wordSet) {
        // If this substring has already been processed, return its results
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> results = new ArrayList<>();

        // Base case: if the string is empty, return a list containing an empty string
        if (s.isEmpty()) {
            results.add("");
            return results;
        }

        // Try every possible split point for the current string
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            // If the prefix is a valid dictionary word, process the suffix
            if (wordSet.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixSentences = backtrack(suffix, wordSet);

                // Combine the current prefix with all valid sentences from the suffix
                for (String sentence : suffixSentences) {
                    if (sentence.isEmpty()) {
                        results.add(prefix); // No trailing space for the last word
                    } else {
                        results.add(prefix + " " + sentence);
                    }
                }
            }
        }

        // Save the result in the memoization table before returning
        memo.put(s, results);
        return results;
    }
}
