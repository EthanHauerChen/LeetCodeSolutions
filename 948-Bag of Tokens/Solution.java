//https://leetcode.com/problems/bag-of-tokens

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int start = 0, end = tokens.length - 1;
        Arrays.sort(tokens);
        
        // System.out.println("----------------------------" + 
        //     "\nTokens: " + Arrays.toString(Arrays.copyOfRange(tokens, start, end + 1)) + 
        //     "\nScore: " + score + 
        //     "\nPower: " + power + 
        //     "\nStart: " + start + 
        //     "\nEnd: " + end +
        //     "\n----------------------------"
        // );
        for (; start <= end;) {
            if (power >= tokens[start]) {
                power -= tokens[start];
                start++;
                score++;
            }
            else if (start == 0 || start >= end) break;
            else if (score > 0) {
                power += tokens[end];
                score--;
                end--;
            }
            
            // System.out.println("----------------------------" + 
            // "\nTokens: " + Arrays.toString(Arrays.copyOfRange(tokens, start, end + 1)) + 
            // "\nScore: " + score + 
            // "\nPower: " + power + 
            // "\nStart: " + start + 
            // "\nEnd: " + end +
            // "\n----------------------------"
            // );
        }

        return score;
    }
}