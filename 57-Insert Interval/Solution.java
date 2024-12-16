//https://leetcode.com/problems/insert-interval/description/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] {newInterval};

        int index = binarySearch(newInterval[0], intervals);
        System.out.println("Index: " + index);

        //2 cases (based on the way I wrote this program)
        //newInterval fits within intervals[index]
        //newInterval end is greater than intervals[index][1] AND newInterval start is within intervals[index]
        //NOTE: newInterval start is ALWAYS within intervals[index]
        //NOTE: newInterval end may be larger than intervals[index+n] for 0 <= n <= intervals

        int endIndex = index; //determines where newInterval end should go in the new array
        while (endIndex < intervals.length-1 && newInterval[1] >= intervals[endIndex+1][0]) {
            endIndex++;
        }

        //newInterval fits within intervals[index] OR newInterval end < intervals[index+1][0]
        if (endIndex == index) {
            intervals[index] = new int[] {intervals[index][0], Math.max(newInterval[1], intervals[index][1])};
            return intervals;
        }
        
        //newInterval end >= intervals[index+n] where n == endIndex
        int[][] newArray = new int[intervals.length - (endIndex-index)][];
        int counter = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (i == index) {
                // newArray[i] = new int[] {intervals[index][0], intervals[index+1][1]};
                // counter++;
                newArray[i] = new int[] {intervals[index][0], Math.max(newInterval[1], intervals[endIndex][1])};
                counter += endIndex - index;
            }
            else newArray[i] = intervals[counter];
            counter++; 
        }
        return newArray;

        // if (newInterval[0] <= intervals[index][1]) 
        //     intervals[index] = new int[] {intervals[index][0], newInterval[1]};
        // if (index != intervals.length-1 && newInterval[1] >= intervals[index+1][0])
        //     intervals[index+1] = new int[] {newInterval[0], intervals[index+1][1]};
        // if (index != intervals.length-1 && intervals[index][1] >= intervals[index+1][0]) {
        //     int[][] newArray = new int[intervals.length-1][];
        //     int counter = 0;
        //     for (int i = 0; i < newArray.length; i++) {
        //         if (i == index) {
        //             newArray[i] = new int[] {intervals[index][0], intervals[index+1][1]};
        //             counter++;
        //         }
        //         else newArray[i] = intervals[counter];
        //         counter++; 
        //     }
        //     return newArray;
        // } //if newInterval overlaps on both ends, need to make a new array since the elements on either end
        // //of newInterval must all be combined into 1 element, making the array 1 element shorter than the original
        // else 
        //     return intervals;
    }

    /**returns index of where to insert */
    public int binarySearch(int newIntervalStart, int[][] intervals) {
        if (intervals.length == 0) return 0;
        int first = 0;
        int last = intervals.length;
        int middle = (first + last) / 2;

        while (last - first > 1) {
            if (intervals[middle][0] < newIntervalStart) first = middle;
            else if (intervals[middle][0] > newIntervalStart) last = middle;
            else return middle;
            middle = (first + last) / 2;
        }

        return middle;
    }
}