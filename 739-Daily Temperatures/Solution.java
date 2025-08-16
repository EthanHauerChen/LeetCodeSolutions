//https://leetcode.com/problems/daily-temperatures/
import java.util.EmptyStackException;

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

        /* this implementation sucks even worse
        int[] answer = new int[temperature.length];
        answer[temperature.length-1] = 0;
        TemperatureObject[] sortedTemps = new TemperatureObject[temperature.length];
        for (int i = 0; i < temperature.length; i++) sortedTemps[i] = new TemperatureObject(i, temperature[i]);
        Arrays.sort(sortedTemps);
        
        for (int i = 0; i < temperature.length; i++) {
            int currentTemp = temperature[i];
            //next step: keep the first j elements in sorted structure. only alter j that are colder than i
            int j = 0;
            while (sortedTemps[j].temperature < currentTemp) {
                int sortedIndex = sortedTemps[j].index;
                int days = i - sortedIndex;
                if (days <= 0) {}
                else if (answer[sortedIndex] != 0) answer[sortedIndex] = Math.min(answer[sortedIndex], days);
                else answer[sortedIndex] = days;
                j++;
            }
        }

        return answer; */

        //use stack. if temp greater than stack.top, pop stack, else push
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperature.length];
        for (int i = 0; i < temperature.length; i++) {
            if (stack.empty() || stack.peek() >= temperature[i]) stack.push(temperature[i]);
            else {
                int count = 0;
                try {
                    while (temperature[i] > stack.peek()) {
                        count++;
                        stack.pop();
                        answer[i-count] = count;
                    }
                } catch (EmptyStackException e) {}
                stack.push(temperature[i]);
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