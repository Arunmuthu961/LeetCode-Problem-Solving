import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        // Map sorted string (key) to list of original strings (value)
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to char array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = String.valueOf(chars);
            
            // If the key doesn't exist, create a new list
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            
            // Add the original string to the corresponding anagram group
            map.get(sortedKey).add(s);
        }
        
        // Return all the grouped lists
        return new ArrayList<>(map.values());
    }
}
