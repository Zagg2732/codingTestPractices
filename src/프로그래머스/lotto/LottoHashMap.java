package 프로그래머스.lotto;

import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/77484
public class LottoHashMap {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 뽑은 번호를 HashMap의 Key로 저장해서 시간복잡도를 줄임
        Map<Integer, Boolean> map = new HashMap<>();

        // 0의 갯수
        int zeroCount = 0;
        // 당첨 갯수
        int winCount = 0;

        for(int num : lottos) {
            if(num == 0) {  //0이면 zeroCount증가
                zeroCount++;
            } else {    //0이 아니면 HaspMap의 Key에 넣어줌
                map.put(num, true);
            }
        }

        for(int num : win_nums) {
            //만약 당첨번호가 key에 있는 번호라면
            if(map.containsKey(num)) {
                winCount++;
            }
        }

        //6개 를 맞췄다면 Rank = 1이되며 5개는 2 이런식으로 순위가 매겨짐
        int maxRank = 7 - (zeroCount + winCount);   //0이었던 숫자들이 모두 당첨이라면 최대순위
        int minRank = 7 - winCount;

        //하나도 당첨되지 않았다면 6등
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }

}
