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
        int max = 0;
        boolean start = end = false;
        for (int i = 0; i < s.length()-k; i++) {
            
        }
    }
}