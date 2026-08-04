class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Step 1: Skip any trailing or intermediate spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // If we reached the beginning of the string, break
            if (i < 0) {
                break;
            }

            // Step 2: Find the end index of the current word
            int end = i;

            // Find the start index of the current word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Step 3: Append a space if this is not the first word added
            if (result.length() > 0) {
                result.append(" ");
            }

            // Step 4: Extract the word and append it to our result
            result.append(s, i + 1, end + 1);
        }

        return result.toString();
    }
}
