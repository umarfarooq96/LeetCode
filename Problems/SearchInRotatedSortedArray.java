import java.util.Arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 0, 1, 2 }, 0));
    }

    public static int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            /*
            L to mid = left side
            mid+1 to R = right side
             */
            int mid = L + ((R - L) / 2);
            System.out.println("----------");
            System.out.println("left is : " + Arrays.toString(Arrays.copyOfRange(nums, L, mid)));
            System.out.println("right is : " + Arrays.toString(Arrays.copyOfRange(nums, mid, R)));
            if (L == R) {
                return nums[L] == target ? L : -1;
            }
            if (nums[L] <= nums[mid]) {
                //left part is sorted
                if (target >= nums[L] && target <= nums[mid]) {
                    L = L;
                    R = mid;
                } else {
                    L = mid;
                    R = R;
                }
            } else {
                //right part is sorted
                if (target >= nums[mid + 1] && target <= nums[R]) {
                    L = mid + 1;
                    R = R;
                } else {
                    L = L;
                    R = mid;
                }
            }
        }

        return -1;
    }
}
