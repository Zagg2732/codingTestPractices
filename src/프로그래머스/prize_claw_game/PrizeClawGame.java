package 프로그래머스.prize_claw_game;

import java.util.ArrayList;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/64061

//간단한? 2차원 배열문제. 나중에 들어간 녀석이 중복인지 확인한후 사라지므로 stack을 활용해도 좋다.
//원래는 다 뽑은 다음에 뽑힌 녀석들에서 중복을 제거하려고 했으나 테스트케이스 1번에서 런타임 에러가 계속 발생했다.
//결국 뽑을때마다 중복을 체크해서 해결하게 되었다. 이 순서가 문제 의도에도 더 맞다고 보인다.
public class PrizeClawGame {
    public int solution(int[][] board, int[] moves) {

        if(moves.length == 1) {  //한번만 뽑았으면 종료
            return 0;
        }

        int answer = 0;

        List<Integer> pickUpList = new ArrayList<>();

        for(int i = 0; i < moves.length; i++) {
            int pickNumber = moves[i] - 1; // move 값 보정 (1 move는 0번인덱스)

            for(int j = 0; j < board.length; j++) { //게임화면 사이즈만큼 뽑기시도

                if(board[j][pickNumber] != 0) { //0이아닌 뭔가가 뽑혔다면
                    pickUpList.add(board[j][pickNumber]); //뽑은 리스트에 추가!
                    board[j][pickNumber] = 0; //뽑힌 위치는 0이됨

                    //만약 뽑은 리스트가 2개 이상이면 중복된 캐릭터가 뽑혔는지 체크
                    if(pickUpList.size() > 1 && pickUpList.get(pickUpList.size()-1) == pickUpList.get(pickUpList.size()-2) ) {
                        answer += 2;
                        //연속으로 뽑힌 캐릭터 두마리 리스트에서 제거.
                        pickUpList.remove(pickUpList.size()-1); //리스트의 마지막 인덱스를 제거하므로 stack의 pop()과 효율 차이가 없다고 생각된다.
                        pickUpList.remove(pickUpList.size()-1);
                    }
                    break; // j for문 빠져나감
                }
            }
        }
        return answer;
    }
}
