//https://leetcode.com/problems/reaching-points

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        /* recursive solution seems to work but is too slow
        //all points are greater than 0, thus every operation is strictly increasing
        //while sx and sy smaller than tx and ty respectively
        //recursively do an operation on each, decision tree like structure
        return calcPossibleXY(sx, sy, tx, ty); */

        //recursive solution with DP, my solution seems to not be any better than the normal recursion
        HashSet<Tuple> tuples = new HashSet<>();
        return calcPossibleXY(sx, sy, tx, ty, tuples);
    }

    boolean calcPossibleXY(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return true;
        if (sx > tx || sy > ty) return false;
        return calcPossibleXY(sx, sy + sx, tx, ty) || calcPossibleXY(sx + sy, sy, tx, ty);
    }

     boolean calcPossibleXY(int sx, int sy, int tx, int ty, HashSet<Tuple> tuples) {
        if (sx == tx && sy == ty) return true;
        if (sx > tx || sy > ty) return false;

        Tuple opOne = new Tuple(sx, sy + sx);
        Tuple opTwo = new Tuple(sx + sy, sy);
        boolean one, two;
        if (tuples.contains(opOne)) {
            one = false;
        }
        else {
            one = calcPossibleXY(sx, sy + sx, tx, ty, tuples);
            tuples.add(opOne);
        }
        if (tuples.contains(opTwo)) {
            two = false;
        }
        else {
            two = calcPossibleXY(sx + sy, sy, tx, ty, tuples);
            tuples.add(opTwo);
        }
        
        return one || two;
    }

    class Tuple {
        int x, y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            return ((Tuple)o).x == x && ((Tuple)o).y == y;
        }
    }
}