package 프로그래머스.AlgotithmTips;

//우선순위 큐를 기반으로 만들어진 Heap 자료구조
//완전 이진트리를 기반으로 최대, 최소를 구할때 최대효율을 보임
//Java에서 heap은 우선순위큐를 뜻하는 PriorityQueue를 활용하여 구현할 수 있다.

//TreeSet 이랑은 다르게 중복값도 허용된다!! (TreeSet 은 Set구조니까 당연한거지만)

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {

        //최소값을 뽑는 heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //최대값을 뽑는 heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //문자열도 abc, ㄱㄴㄷ 순으로 된다! 가나다순이 되는건 놀라웠다
        PriorityQueue<String> stringMinHeap = new PriorityQueue<>();
        PriorityQueue<String> stringMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //Tip
        /*
        주로 쓰는 함수
        .clear()  비움
        .peek() 값을 출력
        .poll() 값을 제거하고 제거한값을 리턴해줌
        */
        int[] arr = {5, 3, 7, 11, 4, 1 , -3, 15, 99, 5};

        for (int i : arr) {
            minHeap.add(i);
            maxHeap.add(i);
        }
        System.out.println("---최소힙---");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(minHeap.poll()); //poll()은 해당 queue에서 값을 제거하면서 제거된 값을 반환함
        }
        System.out.println("-----------");

        System.out.println("---최대힙---");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(maxHeap.poll());
        }
        System.out.println("-----------");

        String[] strArr = {"ㄱ", "c", "f", "ㄷ", "ㄴ", "a", "aa", "b", "ㄹ", "bc", "d", "김", "강"};

        for(String i : strArr) {
            stringMinHeap.add(i);
            stringMaxHeap.add(i);
        }

        System.out.println("---최소힙---");
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(stringMinHeap.poll()); //poll()은 해당 queue에서 값을 제거하면서 제거된 값을 반환함
        }
        System.out.println("-----------");

        System.out.println("---최대힙---");
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(stringMaxHeap.poll());
        }
        System.out.println("-----------");

    }
}
