package 프로그래머스.open_chat;

// https://programmers.co.kr/learn/courses/30/lessons/42888


//처음 테스트 통과한 코드
//통과하나 돌려봤는데 통과해버림

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChat {
    public List<String> solution(String[] record) {

        Map<String , String> nickNameMap = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for(String msg : record) {

            String[] msgStr = msg.split(" ");

            //Enter나 Change일경우만 닉네임을 알수있음
            //Leave의 경우 저장할 닉네임은 없음

            if(!msgStr[0].equals("Leave")) {
                //Leave가 아니라면 uid(key) : nickName(value) 저장
                nickNameMap.put(msgStr[1], msgStr[2]);
            }

        }

        for(String msg : record) {

            //출력될 메세지들
            String situationMsg = "";

            String[] msgStr = msg.split(" ");

            switch (msgStr[0]) {
                case "Change" : //Change의 경우 메세지 출력이 되지않는다.
                    continue;
                case "Enter" :
                    situationMsg = "들어왔습니다.";
                    break;
                case "Leave" :
                    situationMsg = "나갔습니다.";
                    break;
            }

            answer.add( nickNameMap.get(msgStr[1]) + "님이 " + situationMsg );

        }

        return answer;
    }
}
