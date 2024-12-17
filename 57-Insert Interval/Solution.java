//https://leetcode.com/problems/insert-interval/description/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] {newInterval};

        int index = binarySearch(newInterval, intervals);
        System.out.println("Index: " + index);

        //binarySearch function should always return the index where newInterval should go. However:
        //if newInterval belongs before the 0th element of intervals, then binarySearch should return -1
        //if newInterval belongs after the last element of intervals, then binarySearch should return intervals.length (which is out of bounds)
        if (index == -1) {
            int[][] newArray = new int[intervals.length+1][];
            newArray[0] = newInterval;
            for (int i = 0; i < intervals.length; i++)
                newArray[i+1] = intervals[i];
            return newArray;
        }
        else if (index == intervals.length) {
            int[][] newArray = new int[intervals.length+1][];
            newArray[intervals.length] = newInterval;
            for (int i = 0; i < intervals.length; i++)
                newArray[i] = intervals[i];
            return newArray;
        }

        int endIndex = index; //determines where newInterval end should go in the new array
        while (endIndex < intervals.length-1 && newInterval[1] >= intervals[endIndex+1][0]) {
            endIndex++;
        } //could probably do binarySearch for the end index too but i dont wanna right now. consider for the future

        //newInterval merges with intervals[index] OR newInterval end < intervals[index+1][0] and newInterval is inserted instead
        if (endIndex == index) {
            if (newInterval[0] > intervals[Math.max(index-1, 0)][1] && newInterval[1] < intervals[index][0]) {
                int[][] newArray = new int[intervals.length+1][];
                int counter = 0;
                newArray[index] = newInterval;
                for (int i = 0; i < intervals.length; i++) {
                    if (i == index) {
                        newArray[++counter] = intervals[i];
                    }
                    else newArray[counter] = intervals[i];
                    counter++;
                }
                return newArray;
            }

            intervals[index] = new int[] {Math.min(newInterval[0], intervals[index][0]), Math.max(newInterval[1], intervals[index][1])};
            return intervals;
        }
        
        //newInterval end >= intervals[index+n] where n == endIndex
        int[][] newArray = new int[intervals.length - (endIndex-index)][];
        int counter = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (i == index) {
                // newArray[i] = new int[] {intervals[index][0], intervals[index+1][1]};
                // counter++;
                newArray[i] = new int[] {Math.min(newInterval[0], intervals[index][0]), Math.max(newInterval[1], intervals[endIndex][1])};
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
    public int binarySearch(int newInterval[], int[][] intervals) {
        if (intervals.length == 0) return 0;

        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];
        int first = 0;
        int last = intervals.length;
        int middle = (first + last) / 2;

        while (last - first > 1) {
            if (intervals[middle][0] < newIntervalStart) first = middle;
            else if (intervals[middle][0] > newIntervalStart) last = middle;
            else return middle;
            middle = (first + last) / 2;
        }

        if (intervals[middle][1] < newIntervalStart) return middle + 1;
        else if (intervals[middle][0] > newIntervalEnd) return middle - 1;
        return middle;
    }
}