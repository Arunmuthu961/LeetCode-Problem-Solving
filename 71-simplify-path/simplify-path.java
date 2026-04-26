import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        // Split by one or more slashes
        String[] components = path.split("/");

        for (String directory : components) {
            // Case 1: Empty string (from //) or single dot .
            if (directory.isEmpty() || directory.equals(".")) {
                continue;
            }
            
            // Case 2: Double dot .. (move up)
            if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            // Case 3: Valid directory name
            else {
                stack.push(directory);
            }
        }

        // Build the final path
        StringBuilder result = new StringBuilder();
        // Use descendingIterator to build from bottom of stack to top
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            result.append("/").append(it.next());
        }

        // If stack was empty, return root "/"
        return result.length() == 0 ? "/" : result.toString();
    }
}
