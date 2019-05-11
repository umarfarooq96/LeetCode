import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import static java.util.Arrays.asList;
import static java.util.Collections.max;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

/**
 * <pre>
 * https://leetcode.com/problems/brick-wall/
 *
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width.
 * You want to draw a vertical line from the top to the bottom and cross the least bricks.
 *
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 *
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the
 * least bricks and return the number of crossed bricks.
 *
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 *
 * Input:
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 *
 * Output: 2
 * </pre>
 * (this problem has an image which helps a lot in understanding)
 */
public class BrickWall {

    public static int leastBricks(List<List<Integer>> wall) {
        List<List<Integer>> wallEdges = wall.stream().map(BrickWall::wallEdges).collect(toList());
        //edgeCounts is a map of an edge distance and then number of times this edge appears
        HashMap<Integer, Integer> edgeCounts = new HashMap<>();
        for (List<Integer> wallEdge : wallEdges) {
            for (Integer edge : wallEdge) {
                edgeCounts.put(edge, edgeCounts.getOrDefault(edge, 0) + 1);
            }
        }
        Integer bestEdge = edgeCounts.size() == 0 ? wall.get(0).get(0) : max(edgeCounts.entrySet(), comparingInt(Entry::getValue)).getKey();
        long    wallsHit = wallEdges.stream().filter(list -> list.contains(bestEdge)).count();
        return (int) (wallEdges.size() - wallsHit);
    }

    public static List<Integer> wallEdges(List<Integer> wall) {
        List<Integer> edges  = new ArrayList<>();
        int           curSum = 0;
        for (Integer integer : wall) {
            curSum += integer;
            edges.add(curSum);
        }
        edges.remove(edges.size() - 1);
        return edges;
    }

}

