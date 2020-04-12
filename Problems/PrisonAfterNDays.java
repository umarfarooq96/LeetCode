import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonAfterNDays {

    public static void main(String[] args) {
        int[] cells = { 1, 0, 0, 1, 0, 0, 1, 0 };
        System.out.println(Arrays.toString(prisonAfterNDays(cells, 140)));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {

        Map<String, Integer> arrayAfterNDays = new HashMap<>();
        int                  currentDay      = N;

        int[] prevDay = cells;
        while (currentDay > 0) {
            currentDay--;
            arrayAfterNDays.put(Arrays.toString(prevDay), currentDay);

            //calculating the next day
            int[] nextDay = new int[8];
            for (int i = 1; i < 7; ++i) {
                if (prevDay[i - 1] == prevDay[i + 1]) {
                    nextDay[i] = 1;
                } else {
                    nextDay[i] = 0;
                }
            }

            prevDay = nextDay;
            if (arrayAfterNDays.containsKey(Arrays.toString(prevDay))) {
                currentDay %= arrayAfterNDays.get(Arrays.toString(prevDay)) - currentDay;
            }
        }

        return prevDay;
    }
}
