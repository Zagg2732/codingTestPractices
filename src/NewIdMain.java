import 프로그래머스.new_id.NewId;

public class NewIdMain {
    public static void main(String[] args) {

        NewId newId = new NewId();

        String test = "...!@bat#*..y.abcdefghijklm";
        String test2 = "z-+.^.";
        String test3 = "=.=";
        String test4 = "123_.def";
        String test5 = "abcdefghijklmn.p";
        String test6 = "still^^alive";
        String test7 = "123--456";
        String testAscii = "-._";

        newId.solution(test);
        newId.solution(test2);
        newId.solution(test3);
        newId.solution(test4);
        newId.solution(test5);
        newId.solution(test6);
        newId.solution(test7);
        newId.solution(testAscii);


    }
}
