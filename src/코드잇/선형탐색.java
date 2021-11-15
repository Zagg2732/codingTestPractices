package 코드잇;

public class 선형탐색 {
    //일렬로쭉탐색하는것을 선형탐색 (Linear Search) 라고한다.
    //선형탐색으로 원하는 숫자가 배열에 있는지 체크해보자

    public int linearSearch(int value ,int[] array) {

        for (int i = 0; i < array.length; i++) {
            if(value == array[i]) return i;

        }
        return -1;
    }

    public static void main(String[] args) {
        선형탐색 linear = new 선형탐색();


        System.out.println("linear.linearSearch(2, new int[] {2, 3, 5, 7, 11}) = " + linear.linearSearch(2, new int[]{2, 3, 5, 7, 11}));
        System.out.println("linear.linearSearch(0, new int[] {22, 3, 5, 7, 11}) = " + linear.linearSearch(0, new int[]{22, 3, 5, 7, 11}));
        System.out.println("linear.linearSearch(5, new int[] {22, 3, 5, 7, 11}) = " + linear.linearSearch(5, new int[]{22, 3, 5, 7, 11}));
        System.out.println("linear.linearSearch(3, new int[] {22, 3, 5, 7, 11}) = " + linear.linearSearch(3, new int[]{22, 3, 5, 7, 11}));
        System.out.println("linear.linearSearch(11, new int[] {22, 3, 5, 7, 11}) = " + linear.linearSearch(11, new int[]{22, 3, 5, 7, 11}));
    }

}
