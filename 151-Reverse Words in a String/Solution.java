//https://leetcode.com/problems/reverse-words-in-a-string/
class Solution {
    public String reverseWords(String s) {
        /**
        Solution without using String.split() and using StringBuilder
        Notes about this solution:
        Seems like using += to append a String is very slow in Java. The exact same solution 
        using "String result" instead of "StringBuilder result" and using "+=" instead of using "append"
        was extremely slow, and LeetCode's Analyze Complexity functionality (who knows if this is accurate or not)
        showed that it was O(n^2), while the solution using StringBuilder seemed to run much faster (couldn't analyze again since it's only 1 analysis per day)
         */
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i > -1; i--) {
            if (chars[i] == ' ' || i == 0) {
                int startIndex = chars[i] == ' ' ? 1 : 0;
                int counter = i + startIndex;
                while (counter < chars.length && chars[counter] != ' ') {
                    result.append(chars[counter]);
                    counter++;
                }
                if (counter > i+startIndex) result.append(" ");
                counter = 0;
            }
        }

        return result.toString().substring(0, result.length()-1);

        /**Same solution as above but not using StringBuilder and maybe using a char array as the result variable instead
        TODO
        */
    }
}