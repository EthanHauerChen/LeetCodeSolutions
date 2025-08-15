//https://leetcode.com/problems/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] temperature) {
        /** naive approach, passes all but 1 test case, where that test case is just very very large. O(n^2)
        int[] answers = new int[temperature.length];
        for (int i = 0; i < temperature.length; i++) {
            answers[i] = 0;
            for (int j = i+1; j < temperature.length; j++) {
                if (temperature[i] < temperature[j]) {
                    answers[i] = j-i;
                    break;
                }
            }
        }

        return answers; */

        //
        int[] answer = new int[temperature.length];
        answer[temperature.length-1] = 0;
        TemperatureObject[] sortedTemps = new TemperatureObject[temperature.length];
        for (int i = 0; i < temperature.length; i++) sortedTemps[i] = new TemperatureObject(i, temperature[i]);
        Arrays.sort(sortedTemps);
        
        for (int i = temperature.length-1; i > 0; i--) {
            int currentTemp = temperature[i];
            //next step: keep the first j elements in sorted structure. only alter j that are colder than i
            int j = 0;
            while (sortedTemps[j].temperature < currentTemp) {
                answer[sortedTemps[j].index] = i - sortedTemps[j].index > 0 ? Math.min(answer[sortedTemps[j].index], i - sortedTemps[j].index) : answer[sortedTemps[j].index];
                j++;
            }
        }

        return answer;
    }
}

class TemperatureObject implements Comparable<TemperatureObject> {
    int index;
    int temperature;

    public TemperatureObject(int i, int t) {
        index = i;
        temperature = t;
    }

    public int compareTo(TemperatureObject o) {
        return this.temperature - o.temperature;
    }
}