package prize_claw_game;

import java.util.Stack;

//다른 사람의 풀이
//자료 처리순서의 특성상 stack형 자료구조가 떠오르긴 했었다.
//근데 왜 ArrayList를 쓴 내 코드보다 느리지..?
//아마 이사람이 조건문을 비효율적으로 작성했고
//기존에 내가썻던 ArrayList의 .remove(index)의 index 가 size-1 즉 맨 뒤를 항상 가르키게 되는 구조였어서
//stack의 pop()과 시간복잡도가 같았다고 생각된다.

public class PrizaClawGameStack {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            for (int move : moves) {
                for (int j = 0; j < board.length; j++) {
                    if (board[j][move - 1] != 0) {
                        if (stack.isEmpty()) {
                            stack.push(board[j][move - 1]);
                            board[j][move - 1] = 0;
                            break;
                        }
                        if (board[j][move - 1] == stack.peek()) {
                            stack.pop();
                            answer += 2;
                        } else
                            stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                }
            }
            return answer;
        }
}
