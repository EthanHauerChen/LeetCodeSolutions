//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
class Solution {
    public int maxVowels(String s, int k) {
        //"naive" approach. O(n) time.
        /**
        1. count num of vowels in the first k letters of the string
        2. set 2 pointers looking at start and end of the k letter range
        3. move the range of k letters over by 1
        4. if start pointer was looking at a vowel previously, then subtract 1. if end pointer sees a vowel, add 1
        5. solution is the largest number encountered
         */
        char[] str = s.toCharArray();
        int max = 0;
        int count = 0;
        boolean start, end;
        start = isVowel(str[0]);
        end = isVowel(str[k-1]);
        for (int j = 0; j < k; j++) { //first iteration
            if (isVowel(str[j])) count++;
        }
        max = count;
        // 00 = 0
        // 01 = 0
        // 10 = -
        // 11 = -

        // 11 = +
        // 10 = 0
        // 01 = +
        // 00 = 0
        for (int i = 1; i < str.length-k+1; i++) {
            if (start) count--;
            if (start != isVowel(str[i])) start = !start;

            if (isVowel(str[i+k-1])) count++;
            if (end != isVowel(str[i+k-1])) end = !end;
            
            if (count > max) max = count;
            //System.out.println("StartIndex: " + i + ". EndIndex: " + (i+k-1) + ". Start is now [" + start + "]. End is now [" + end + "]. Count is now [" + count + "]. Max is now [" + max + "]");
        }

        return max;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}