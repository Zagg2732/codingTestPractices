import open_chat.OpenChat;

import java.util.Arrays;

public class OpenChatMain {
    public static void main(String[] args) {
        OpenChat openChat = new OpenChat();

        String[] testRecord = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        //System.out.println(Arrays.toString(openChat.solution(testRecord)));

        System.out.println(openChat.solution(testRecord));

        //result
        //["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    }
}
