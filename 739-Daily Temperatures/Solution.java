//https://leetcode.com/problems/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        HashMap<Integer, Integer> tempIndexes = new HashMap<>();
        int[] sortedTemps = temperatures.clone();
        Arrays.sort(sortedTemps);
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            tempIndexes.put(temperatures[i], i);
        }

        for (int i = 0; i < sortedTemps.length-1; i++) {
            int answerIndex = tempIndexes.get(sortedTemps[i]);
            int indexDifference = tempIndexes.get(sortedTemps[i+1]) - answerIndex;
            if (sortedTemps[i] < sortedTemps[i+1] && indexDifference > 0) answer[answerIndex] = indexDifference;
            else answer[answerIndex] = 0;
        }

        return answer;
    }
}