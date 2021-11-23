import 프로그래머스.english_to_number.EngToNum;
import 프로그래머스.english_to_number.EngToNumReplaceAll;

public class EngToNumMain {
    public static void main(String[] args) {

        EngToNum engToNum = new EngToNum();
        EngToNumReplaceAll engToNumReplaceAll = new EngToNumReplaceAll();

        String test1 = "one4seveneight";

        System.out.println(engToNum.solution(test1));
        System.out.println(engToNumReplaceAll.solution(test1));

    }
}
