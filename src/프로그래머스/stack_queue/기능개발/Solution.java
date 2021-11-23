package 프로그래머스.stack_queue.기능개발;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/42586
public class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {

        Queue<Integer> progressQueue = new LinkedList<>();  //진행상황 queue
        Queue<Integer> speedQueue = new LinkedList<>();     //진행속도 queue
        List<Integer> answer = new ArrayList<>();           //정답

        //우선 각자 queue에 넣어줌
        for (int p : progresses) progressQueue.add(p);
        for (int s : speeds) speedQueue.add(s);

        int days = 0; //일한 날들
        int done = 0; //우선순위 작업이 완료된 날에 배포될 작업수

        while (!progressQueue.isEmpty()) {
            int working = progressQueue.peek();
            int speed = speedQueue.peek();

            if (working + speed * days >= 100) { //작업이 100%가 넘었을때
                done++;                 //작업완료 ++
                progressQueue.poll();   //다음작업
                speedQueue.poll();      //다음시간 으로 갱신
            } else {    //작업이 100%가 안됐으면
                if (done != 0) { //이전에 작업수가 하나이상 있으면 정답에 add
                    answer.add(done);
                }
                done = 0;   //작업수 초기화
                days++;     //다음날로 넘어감
            }
        }

        //Queue가 비기전에 완료된 작업들 넣어줌
        if(done > 0) answer.add(done);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Solution sol = new Solution();
        sol.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }
}
