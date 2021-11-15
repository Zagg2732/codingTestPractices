package skill_check;

import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/12981

public class Divisor {

    public int[] solution(int n, String[] words) {

        //중복정답 체크
        Map<String , Boolean> answerMap = new HashMap<>();

        char lastChar = '0';
        int check = 1; //사람순서 체크
        int turn = 1;  //몇번째 턴인지 체크
        for(int i = 0; i < words.length; i++) {

            //이미 정답에 있는 단어가 나왔다면 종료
            if(answerMap.containsKey(words[i])) return new int[] {check, turn};

            answerMap.put(words[i], true); //정답 리스트에 넣기

            //첫번째 순서가 아니면서 끝말잇기가 틀렸다면
            if(i > 0 && words[i].charAt(0) != lastChar) return new int[] {check, turn}; //종료

            lastChar = words[i].charAt(words[i].length()-1); //마지막글자

            check++; //사람순서

            if(check > n) { //사람순서돌리기
                turn++;    //턴 증가
                check = 1; //사람은 다시 1번사람
            }

        }
        //모든순서가 다끝났는데 게임이 안끝났다면 {0, 0}
        return new int[] {0, 0};
    }

    public static void main(String[] args) {

        Divisor divisor = new Divisor();

        String[] testString = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        divisor.solution(3, testString);


    }
}
