import english_to_number.EngToNum;
import english_to_number.EngToNumReplaceAll;
import open_chat.OpenChat;

public class EngToNumMain {
    public static void main(String[] args) {

        EngToNum engToNum = new EngToNum();
        EngToNumReplaceAll engToNumReplaceAll = new EngToNumReplaceAll();

        String test1 = "one4seveneight";

        System.out.println(engToNum.solution(test1));
        System.out.println(engToNumReplaceAll.solution(test1));

    }
}
