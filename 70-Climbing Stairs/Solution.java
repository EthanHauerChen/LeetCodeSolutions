//https://leetcode.com/problems/climbing-stairs/

class Solution {
    public int climbStairs(int n) {
        /*closed form solution (fibonacci(n+1)) 
        double gRatio = (1 + Math.pow(5, .5)) / 2;
        double conjugate = (1 - Math.pow(5, .5)) / 2;
        return (int) ((Math.pow(gRatio, n + 1) - Math.pow(conjugate, n + 1)) / Math.pow(5, .5));
        */

        /*memoization method: Map<Integer, Integer> waysToClimbStairs = new HashMap<>();
        return getClimbStairs(n, waysToClimbStairs);
        */

        /*tabulation method
        int[] tabulationTable = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            switch(i) {
                case 0:
                case 1: 
                    tabulationTable[i] = 1;
                    continue;
                default:
                    break;
            }

            tabulationTable[i] = tabulationTable[i-1] + tabulationTable[i-2];
        }
        
        return tabulationTable[n];
        */

        /*tabulation with space optimization */
        int prev = 0;
        int current = 1;
        for (int i = 0; i < n + 1; i++) {
            switch(i) {
                case 0:
                case 1: 
                    prev = current = 1;
                    continue;
                default:
                    break;
            }
            
            int temp = current;
            current += prev;
            prev = temp;
        }
        
        return current;
    }

    /*memoization method 
    public int getClimbStairs(int n, Map<Integer, Integer> memo) {
        if (n < 2) return 1;
        if (n == 2) return 2;
        Integer result = memo.get(n);
        if (result != null) return result;

        result = getClimbStairs(n - 1, memo) + getClimbStairs(n - 2, memo);
        memo.put(n, result);
        return result;
    }
    */
}