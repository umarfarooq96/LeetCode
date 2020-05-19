public class SingleElementInASortedArray {

    int answer;

    public static void main(String[] args) {
        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(new int[] {
              1, 1, 2, 2, 3
        }));
    }

    public int singleNonDuplicate(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        search(nums, L, R);
        return answer;
    }

    public boolean search(int[] nums, int L, int R) {
        if (R - L + 1 == 1) {
            answer = nums[L];
            return true;
        }
        if (R - L <= 2) {
            if (nums[L] != nums[L + 1] && nums[L + 1] == nums[L + 2]) {
                this.answer = nums[L];
                return true;
            }
            if (nums[L] == nums[L + 1] && nums[L + 1] != nums[L + 2]) {
                this.answer = nums[L + 2];
                return true;
            }
        }
        int mid = L + ((R - L) / 2);
        if (nums[mid] == nums[mid + 1]) {
            mid++;
        }
        int numbersOnLeft = mid - L + 1;
        if (numbersOnLeft % 2 != 0) {
            return search(nums, L, mid);
        } else {
            return search(nums, mid + 1, R);
        }
    }
}
