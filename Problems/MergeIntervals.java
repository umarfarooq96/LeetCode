import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 4 }, { 4, 5 } };
        System.out.println(Arrays.toString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            int start_this = intervals[i][0];
            int end_this   = intervals[i][1];
            int start_next = intervals[i + 1][0];
            int end_next   = intervals[i + 1][1];

            if (end_this >= start_next) {
                int[] new_interval = new int[2];
                new_interval[0] = start_this;
                new_interval[1] = Math.max(end_this, end_next);
                intervals[i + 1] = new_interval;

                intervals[i][0] = -1;
            }
        }

        int numIntervals = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] != -1) {
                numIntervals++;
            }
        }

        int[][] result = new int[numIntervals][];
        int     j      = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] != -1) {
                result[j] = intervals[i];
                j++;
            }
        }

        return result;
    }
}
