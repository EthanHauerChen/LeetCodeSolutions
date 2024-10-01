//https://leetcode.com/problems/sum-of-two-integers/

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int sumNoCarry = a ^ b;
            int carry = (a & b) << 1;
            a = sumNoCarry;
            b = carry;
        }
        return a;
    }
}
