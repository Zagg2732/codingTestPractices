package 온라인강의.recursion;

/*
https://www.youtube.com/watch?v=tuzf1yLPgRI

순환적으로 사고하기

Recursion은 수학함수 계산에만 유용한가??
그럴리는없고 ㅋㅋ 대표적인 예제들을 풀어보자
 */

public class Recursion002 {
    public static void main(String[] args) {
        System.out.println(lengthOfString("abcd"));
    }

    public static int lengthOfString(String str) {
        if (str.equals("")) return 0; //빈문자열일때 끝남
        else return 1 + lengthOfString(str.substring(1));
    }
}
