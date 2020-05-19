public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count      = 0;
        int curProduct = 1;
        int left       = 0;
        for (int right = 0; right < nums.length; right++) {
            curProduct = curProduct * nums[right];

            //move our left up if we have to
            while (curProduct >= k) {
                curProduct = curProduct / nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
