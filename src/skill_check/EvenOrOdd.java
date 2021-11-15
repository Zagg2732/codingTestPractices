package skill_check;

//https://programmers.co.kr/skill_checks/316352?challenge_id=951

//num이 짝수냐 홀수냐 리턴하는 문제;;
public class EvenOrOdd {
    public String solution(int num) {

        String answer =  num % 2 == 0 ? "Even" : "Odd";

        return answer;
    }
}
