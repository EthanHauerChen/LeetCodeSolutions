class Solution {
    /**
     * the given examples mislead you into thinking that you can just start with the
     * highest denomination of coin (that is still less than the sum) with a greedy algorithm 
     * but that is not the case for coin sets such as [1, 3, 4] where you are trying to get the sum of 6, for example
     */
    public int coinChange(int[] coins, int amount) {
        //my recursive algorithms compute coinChange(amount-denom), for every denom in coins. 
        //if every time the method is called and coinChange(amount-denom) is computed using the smallest denom, then it would quite inefficient,
        //so sorting helps me start from the largest denom instead of potentially a small denom
        Arrays.sort(coins);

        /*normal recursion 
        return coinChangeRecurse(coins, amount); */

        /*memoization 
        HashMap<Integer, Integer> map = new HashMap<>();
        return coinChangeMemo(coins, amount, map);
        */

        /*tabulation */
        return coinChangeTab(coins, amount);
    }

    /* normal recursion. works for the 3 small test cases, but is seemingly too slow for the other test cases 
    public int coinChangeRecurse(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int min = Integer.MAX_VALUE;
        boolean allNegative = true;

        for (int i = coins.length-1; i > -1; i--) {
            if (amount == coins[i]) return 1;
            int nextCoinChangeIter = coinChangeRecurse(coins, amount-coins[i]);

            if (nextCoinChangeIter > -1) allNegative = false;
            else continue;

            min = Math.min(min, 1+nextCoinChangeIter);
        }

        if (allNegative) return -1;
        return min;
    }
    */

    /* memoization 
    public int coinChangeMemo(int[] coins, int amount, HashMap<Integer, Integer> map) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        Integer value = map.get(amount);
        if (value != null) return value;

        int min = Integer.MAX_VALUE;
        boolean allNegative = true;

        for (int i = coins.length-1; i > -1; i--) {
            if (amount == coins[i]) return 1;
            int nextCoinChangeIter = coinChangeMemo(coins, amount-coins[i], map);

            if (nextCoinChangeIter > -1) allNegative = false;
            else continue;

            min = Math.min(min, 1+nextCoinChangeIter);
        }

        if (allNegative) {
            map.put(amount, -1);
            return -1;
        }
        map.put(amount, min);
        return min;
    } */

    /*tabulation */
    public int coinChangeTab(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] min = new int[amount+1]; 
        Arrays.fill(min, amount+1);
        min[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = coins.length-1; j > -1; j--) {
                if (i-coins[j] > -1) {
                    min[i] = Math.min(min[i-coins[j]]+1, min[i]);
                }
            }
        }

        return min[amount] > amount ? -1 : min[amount];
    }
}