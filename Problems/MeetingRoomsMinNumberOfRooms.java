import java.util.ArrayList;
import java.util.List;

public class MeetingRoomsMinNumberOfRooms {

    public int minMeetingRooms(int[][] intervals) {
        int numOfRooms = 0;

        /*
        algorithm:
        we iterate start and end times
        if we have a start time that happens before our earliest end time, then these 2 meetings
        will happen simutaneously so we need an extra room to hold these 2 meetings

        [0,30], [5,10], [15,20]
        0, 5, 15
        10, 20, 30

        0 < 10 - we need a room
        5 < 10 - we need another room
        15 > 10 - we don't need another room

        all meetings started, we're done.
        */

        List<Integer> starts = new ArrayList<>();
        List<Integer> ends   = new ArrayList<>();

        for (int[] interval : intervals) {
            starts.add(interval[0]);
            ends.add(interval[1]);
        }

        starts.sort((i1, i2) -> Integer.compare(i1, i2));
        ends.sort((i1, i2) -> Integer.compare(i1, i2));

        int start_pointer = 0;
        int end_pointer   = 0;
        int rooms         = 0;
        while (start_pointer < intervals.length) {
            if (starts.get(start_pointer) < ends.get(end_pointer)) {
                rooms++;
            } else {
                end_pointer++;
            }
            start_pointer++;
        }

        return rooms;
    }
}
