public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {
              1
        }));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int[] lessLeft = new int[heights.length];
        //nothing lower on the left for the first element
        lessLeft[0] = -1;
        for (int i = 1; i < lessLeft.length; i++) {
            if (heights[i - 1] < heights[i]) {
                //if the one to the left is less, then we're done
                lessLeft[i] = i - 1;
            } else {
                //if it's bigger, than we need to keep searching
                //we can do a smart search here tho... what's less than heights[i-1]?
                int lessThanPrevious = lessLeft[i - 1];
                while (lessThanPrevious != -1 && heights[lessThanPrevious] >= heights[i]) {
                    lessThanPrevious = lessLeft[lessThanPrevious];
                }
                lessLeft[i] = lessThanPrevious;
            }
        }
        int[] lessRight = new int[heights.length];
        lessRight[lessRight.length - 1] = -1;
        for (int i = lessRight.length - 2; i >= 0; i--) {
            if (heights[i] > heights[i + 1]) {
                lessRight[i] = i + 1;
            } else {
                int lessThanPrevious = lessRight[i + 1];
                while (lessThanPrevious != -1 && heights[lessThanPrevious] >= heights[i]) {
                    System.out.println(lessThanPrevious);
                    lessThanPrevious = lessRight[lessThanPrevious];
                }
                lessRight[i] = lessThanPrevious;
            }
        }
        /*
        CLAIM: bounces will always be <= heights.length
        why? we won't bounce on the same element more than once ever
        if we bounce from i to some i-n, then next time we bounce from some i+k to i, we won't "rebounce" to i-n
        the proof is a bit complicated but the gist of it is that:
        a,b,c
        where b bounces to a
        c bounces to a
        it is easy to see that c will never bounce to a, thus it is linear
        */

        /*CLAIM: The global maximum will include the entire bar at some i
        proof by counter example
        */

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            //at every step, the height will at least be hte block itself
            int width = 1;

            if (lessLeft[i] == -1) {
                //there is nothing less than this on the left
                width += i;
            } else {
                //there is something less than this on the left
                //we can go from i to that something less (minus 1 so we don't double count this index itself)
                width += i - lessLeft[i] - 1;
            }
            if (lessRight[i] == -1) {
                width += heights.length - i;
            } else {
                //there is something less than this on the right
                //we can go from i to that thing on the right (minus 1 so we don't double count this index itself)
                width += lessRight[i] - i - 1;
            }
            int maximumHeightUsingThisEntireBar = heights[i] * width;
            maxArea = Math.max(maxArea, maximumHeightUsingThisEntireBar);
        }

        return maxArea;
    }
}
