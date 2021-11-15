package 온라인강의.recursion;

/*
https://www.youtube.com/watch?v=ln7AfppN7mY

자기 자신을 다시 호출하는 재귀함수..
 */

public class Recursion001 {
    public static void main(String[] args) {
        //func();
        System.out.println("====func2 start====");
        func2(4);
        System.out.println("====func2 end====");
        System.out.println("====func3 start====");
        System.out.println(func3(4));
        System.out.println("====func3 end====");
        System.out.println("====func4 start====");
        System.out.println(func4(4, 4));
        System.out.println("====func4 end====");
        System.out.println("====피보나치 start====");
        System.out.println(fibonacci(10));
        System.out.println("====피보나치 end====");
        System.out.println("====test start====");
        System.out.println(testRecursion(6));
        System.out.println("====test end====");


    }

    //조건없이 자기 자신안에서 계속 자신을 호출하여 무한루프에 걸림
    public static void func() {
        System.out.println("Hello Im Recursion func");
        func();
    }
    //무한 루프에 빠지지 않는 재귀호출을 하려면 이렇게 조건이 들어가야함
    public static void func2(int n) {
        if(n <= 0) return; // Base case : 적어도 하나의 recursion에 빠지지 않는 경우가 존재하여 종료할 수 있어야함
        //Recursive base : recursion을 반복하다보면 결국 base case로 수렴해야함 (안그러면 무한루프에 걸리겠지)
        else System.out.println("Hello Im Recursion func2");
        func2(n-1);
    }

    //예제3. 1 ~ n 까지의 합
    public static int func3(int n) {
        if(n == 0) return 0;
        else return n + func3(n-1); //n이 0보다 크다면 0에서 n까지의 합은 0에서 n-1까지의 합에 n을 더한 것이다.
        //결국에 이 함수에 4를 넣었을때 return값은 4 + 3 + 2 + 1 + 0 이고, 0일때 안의 재귀함수는 return 0 을 만나서 종료된다(0을만나고).
        //만약 if(n==0) 의 return문에 다른 숫자를 넣으면 그 숫자가 더해지면서 끝난다는말
        // 0! = 1
        // n! = n x (n - 1)!  (n>0)
    }

    //x의 n승(제곱)을 계산하는 함수
    public static double func4(double x, int n) {
        if(n==0) return 1;
        else return x * func4(x, n-1); //4 * 4 * 4 * 4 * 1
    }

    public static int fibonacci(int n) {
        if(n < 2) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    static int answer = 1;

    public static int testRecursion(int n) {
        if(n==1) return answer;
        else answer *= n;
        return testRecursion(n-1);
    }





}
