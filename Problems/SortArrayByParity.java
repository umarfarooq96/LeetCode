import java.util.Arrays;
import java.util.List;

class SortArrayByParity {

    public static void main(String[] args) {
        int[] data = { 3, 1, 2, 4 };
        System.out.println(Arrays.toString(sortArrayByParity(data)));
    }

    public static int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int front = 0;
        int back = A.length - 1;

        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (num % 2 == 0) {
                res[front] = num;
                front++;
            } else {
                res[back] = num;
                back--;
            }
        }
        return res;
    }
}