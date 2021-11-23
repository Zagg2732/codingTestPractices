package 프로그래머스.stack_queue.프린터;

//https://programmers.co.kr/learn/courses/30/lessons/42587?language=java

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Integer> heap = new PriorityQueue<>((Collections.reverseOrder())); //최대 우선순위 순서대로 나오는 max heap
        Queue<Integer> printList = new LinkedList<>();  //프린트 대기 순서 queue

        //최대우선순위 queue와 프린트 대기순서 queue에 리스트 값 넣어줌
        for(int p : priorities) {
            heap.add(p);
            printList.add(p);
        }

        int answer = 0; //몇번째 뽑혔는지 체크하는 answer

        while (true) {  //return이 나올때까지 반복됨
            if(heap.peek() == printList.peek()) { //현재 printList의 맨앞과 최대 우선순위가 같다면
                answer++; //뽑는다
                if(location == 0) { //근데 그게 내가원하는 문서면 끝 (~˘▾˘)~
                  return answer;
                } else {
                    heap.poll();       //맨앞지워줌(뽑힘) -> 최대 우선순위가 다음으로 넘어감
                    printList.poll();  //맨앞지워줌(뽑힘)
                    location--;
                }
            } else { //최대 우선순위가 아니라면
                printList.add(printList.poll()); //맨앞을 빼서 뒤에 넣어줌
                if(location == 0) { //내가 뽑고자 하는 문서 위치 조정
                    location = printList.size() - 1;
                } else {
                    location--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("sol.solution(new int[]{2,1,3,2},2) = " + sol.solution(new int[]{2, 1, 3, 2}, 2));
        //sol.solution(new int[]{1,1,9,1,1,1},0);
    }
}
