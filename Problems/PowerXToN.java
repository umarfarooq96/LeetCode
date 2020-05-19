public class PowerXToN {

    public static void main(String[] args) {
        System.out.println(myPow(0.00001,
                                 2147483647));
    }

    public static double myPow(double x, int n) {
        if (n == 0) //special case
        {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) { //x^-2 = 1/x^2
            x = 1 / x;
            n = Math.abs(n);
        }
        //we simply divide our problem
        //x^4 = x^2 * x^2
        return (n % 2 == 0) ? myPow(x, n / 2) * myPow(x, n / 2) : x * myPow(x, n - 1);
    }
}
