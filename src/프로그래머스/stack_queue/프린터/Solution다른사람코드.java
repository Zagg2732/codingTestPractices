package 프로그래머스.stack_queue.프린터;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*

이사람코드가 내 코드보다 빠름
로직은 똑같은데 왜일까?
이유는 최대 우선순위를 Arrays.sort(priorities) 해준다음
priorities[끝] 으로 불러왔기때문
최대우선순위와 일치하는 녀석이 나오면 Answer++ 가 되고, 최대우선순위의 위치는 -- 가 되는점을 이용했음

내가 짠 최대우선순위는 PriorityQueue를 사용함. 이것은 Heap 자료구조로서 최대 우선순위를 뽑아오는건 O(1)이었음
근데 뽑는순간 PriorityQueue 에서는 최대 힙을 유지하기위해 Heapify 가 될것임.
Heapify의 시간복잡도는 O(log n) 임. 반면에 아래 코드는 불러오는 인덱스 위치만 바꾸기 때문에 늘 O(1)을 유지함 !!
거기서 효율차이가 났다..
*/
public class Solution다른사람코드 {

    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            int l = location;

            Queue<Integer> que = new LinkedList<Integer>();
            for(int i : priorities){
                que.add(i);
            }

            Arrays.sort(priorities);
            int size = priorities.length-1;



            while(!que.isEmpty()){
                Integer i = que.poll();
                if(i == priorities[size - answer]){
                    answer++;
                    l--;
                    if(l <0)
                        break;
                }else{
                    que.add(i);
                    l--;
                    if(l<0)
                        l=que.size()-1;
                }
            }

            return answer;
        }

    }
}
