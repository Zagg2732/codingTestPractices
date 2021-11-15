import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/86051

public class SumNumbers {

    public int solution(int[] numbers) {

        //최소힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i : numbers) {
            minHeap.add(i);
        }

        int answer = 0;

        for(int i = 0; i < 10; i++) {
            if(!minHeap.isEmpty() && minHeap.peek() == i) {
                minHeap.poll();
            } else if (minHeap.isEmpty()) {
                answer += i;
            } else  {
                answer += i;
            }
        }

        return answer;
    }

    public int solution2(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }

    public static void main(String[] args) {

        SumNumbers sol = new SumNumbers();

        System.out.println(sol.solution(new int[] {1, 2, 3, 4, 6, 7, 8, 0}));

    }
}
