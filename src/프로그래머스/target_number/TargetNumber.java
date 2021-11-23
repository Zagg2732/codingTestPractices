//https://programmers.co.kr/learn/courses/30/lessons/43165?language=java

package 프로그래머스.target_number;

public class TargetNumber {
    //팩토리얼 재귀함수
    public int getFactorial(int number) {
        if (number == 1) return number;
        else return getFactorial(number-1) * number;
    }

    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();

        System.out.println("targetNumber.getFactorial(5) = " + targetNumber.getFactorial(5));
    }

}
