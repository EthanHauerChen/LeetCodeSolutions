//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
class Solution {
    public int maxVowels(String s, int k) {
        //"naive" approach
        /**
        1. count num of vowels in the first k letters of the string
        2. set 2 pointers looking at start and end of the k letter range
        3. move the range of k letters over by 1
        4. if a pointer was looking at a vowel before and then isn't in this new range, then
        subtract 1 from the num of vowels in this new range. vice versa if pointer was NOT looking
        at a vowel and now is in the new range.
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
        for (int i = 1; i < str.length-k; i++) {
            if (start && !isVowel(str[i])) {
                count--;
                start = false;
            }
            else if (!start && isVowel(str[i])) {
                count++;
                start = true;
            }
            if (end && !isVowel(str[i])) {
                count--;
                end = false;
            }
            else if (!end && isVowel(str[i])) {
                count++;
                end = true;
            }
            if (count > max) max = count;
        }
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}