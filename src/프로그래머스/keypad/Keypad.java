package 프로그래머스.keypad;
//https://programmers.co.kr/learn/courses/30/lessons/67256

//키패드를 2차원 배열로 생각하고 거리계산, 현재 손위치를 HashMap에 저장하는 방식으로 구현.
//HashMap과 Arrays를 다룰줄알면 어떤 문제든 해결책이 보이는구나..
//어려울줄알았는데 생각보다 쉬웠다

import java.util.HashMap;
import java.util.Map;

public class Keypad {

    private String userHand = "";   //주로 사용하는 손
    private Map<String, int[]> handMap = new HashMap<>();   //손가락 위치
    private String answer = "";     //정답

    //가까운 손가락으로 누르기
    public void nearHand(int[] numberCoord) {

        //현재 왼손위치
        int[] left = handMap.get("L");
        //거리구하기
        int leftDistance = Math.abs(numberCoord[0] - left[0]) + Math.abs(numberCoord[1] - left[1]);
        //현재 오른손위치
        int[] right = handMap.get("R");
        //거리구하기
        int rightDistance = Math.abs(numberCoord[0] - right[0]) + Math.abs(numberCoord[1] - right[1]);

        //가까운 거리 손으로 클릭, 손위치도 갱신해줌
        if(leftDistance < rightDistance) {
            answer += "L";
            handMap.put("L", numberCoord);
        } else if (leftDistance > rightDistance ) {
            answer += "R";
            handMap.put("R", numberCoord);
        } else {
            answer += userHand; //거리가 같은경우 주로쓰는 손
            handMap.put(userHand, numberCoord);
        }
    }

    public String solution(int[] numbers, String hand) {

        //오른손잡이 왼손잡이 구분
        userHand = hand.equals("right") ? "R" : "L";

        //기본 손위치
        handMap.put("L", new int[] {3,0}); // *
        handMap.put("R", new int[] {3,2}); // #

        for(int i : numbers) {
            switch (i) {
                case 1 :
                    handMap.put("L", new int[] {0, 0}); answer += "L"; break;
                case 2 :
                    nearHand(new int[] {0, 1}); break;
                case 3 :
                    handMap.put("R", new int[] {0, 2}); answer += "R"; break;
                case 4 :
                    handMap.put("L", new int[] {1, 0}); answer += "L"; break;
                case 5 :
                    nearHand(new int[] {1, 1}); break;
                case 6 :
                    handMap.put("R", new int[] {1, 2}); answer += "R"; break;
                case 7 :
                    handMap.put("L", new int[] {2, 0}); answer += "L"; break;
                case 8 :
                    nearHand(new int[] {2, 1}); break;
                case 9 :
                    handMap.put("R", new int[] {2, 2}); answer += "R"; break;
                case 0 :
                    nearHand(new int[] {3, 1}); break;
            }
        }
        return answer;
    }
}
