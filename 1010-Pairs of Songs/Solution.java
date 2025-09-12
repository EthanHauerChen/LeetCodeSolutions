https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
import java.util.HashMap;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        /* n^2, too slow to pass all test cases
        int numPairs = 0;
        for (int i = 0; i < time.length-1; i++) {
            for (int j = i+1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) numPairs++;
            }
        }
        return numPairs; */

        /* working with just the remainders of the songs
        int numPairs = 0;
        HashMap<Integer, Integer> nonZeroRemainders = new HashMap<>();
        int zeroRemainders = 0;
        for (int i = 0; i < time.length; i++) {
            int remainder = time[i] % 60;
            if (remainder == 0 && nonZeroRemainders.containsKey(remainder)) numPairs += nonZeroRemainders.get(remainder);
            else if (nonZeroRemainders.containsKey(60 - remainder)) numPairs += nonZeroRemainders.get(60 - remainder);

            if (nonZeroRemainders.containsKey(remainder)) nonZeroRemainders.replace(remainder, nonZeroRemainders.get(remainder)+1);
            else nonZeroRemainders.put(remainder, 1);
        }
        return numPairs; */
        
        // same solution using an array instead of hashmap
        int[] remainders = new int[60];
        int numPairs = 0;
        for (int i : time) {
            int remainder = i % 60;
            if (remainder == 0) numPairs += remainders[0];
            else numPairs += remainders[60 - remainder];
            remainders[remainder]++;
        }
        return numPairs;
    }
}