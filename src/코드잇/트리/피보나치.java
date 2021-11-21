package 코드잇.트리;

public class 피보나치 {
    public static void main(String[] args) {

        int input = 8; // 8개 출력

        for (int i = 1; i <= input; i++) {

            System.out.println(fibo(i));

        }

    }


    public static int fibo(int n) {

        if (n <= 1)
            return n;
        else
            return fibo(n - 2) + fibo(n - 1);

    }
}
