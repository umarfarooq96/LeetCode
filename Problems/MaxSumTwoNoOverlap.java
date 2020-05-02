public class MaxSumTwoNoOverlap {

    public static void main(String[] args) {
        int[] ints = { 2, 1, 5, 6, 0, 9, 5, 0, 3, 8 };
        System.out.println(maxSumTwoNoOverlap(ints, 3, 4));
    }

    public static int maxSumTwoNoOverlap(int[] nums, int L, int M) {
        if (null == nums || nums.length == 0 || nums.length < L + M) return -1;

        return Math.max(maxSum(nums, L, M), maxSum(nums, M, L));
    }

    private static int maxSum(int[] nums, int L, int M) {

        int   max     = 0;
        int   n       = nums.length;
        int[] LPreSum = new int[n];
        int[] MPreSum = new int[n];

        int leftSum = nums[0];
        LPreSum[0] = nums[0];

        int rightSum = 0;
        MPreSum[n - 1] = 0; //right boundary as 0

        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {

            leftSum += nums[i];

            if (i >= L) {
                leftSum -= nums[i - L];
            }

            LPreSum[i] = Math.max(LPreSum[i - 1], leftSum);

            rightSum += nums[j + 1];
            if (j + M + 1 < n) //outside of M window
            {
                rightSum -= nums[j + M + 1];
            }

            MPreSum[j] = Math.max(MPreSum[j + 1], rightSum);
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, LPreSum[i] + MPreSum[i]);
        }

        return max;
    }
}
