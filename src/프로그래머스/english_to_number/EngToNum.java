package 프로그래머스.english_to_number;

//https://programmers.co.kr/learn/courses/30/lessons/81301

//숫자가 아니라면 switch문과 조건문을 활용하여 구현
//구현은 성공했으나 효율성이 안좋았음. 느림
//다른 코드중에 효율성이 좋았던건 replaceAll 을 사용한 코드. EngToNumReplaceAll class 참조

public class EngToNum {

    public int solution(String s) {

        String answer = "";

        for(int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i);

            if(ascii > 96 && ascii < 123) { //숫자가 아닌 문자라면

                char nextChar = s.charAt(i + 1);

                switch (s.charAt(i)) {
                    case 'o' : //one
                        i += 2;
                        answer += "1";
                        break;
                    case 't' : //two, three
                        switch (nextChar) {
                            case 'w' :
                                i+=2;
                                answer += "2";
                                break;
                            case 'h' :
                                i+=4;
                                answer += "3";
                                break;
                        }
                        break;
                    case 'f' : //four, five
                        switch (nextChar) {
                            case 'o' :
                                i+=3;
                                answer += "4";
                                break;
                            case 'i' :
                                i+=3;
                                answer += "5";
                                break;
                        }
                        break;
                    case 's' : //six, seven
                        switch (nextChar) {
                            case 'i' :
                                i+=2;
                                answer +="6";
                                break;
                            case 'e' :
                                i+=4;
                                answer += "7";
                                break;
                        }
                        break;
                    case 'e' : //eight
                        i+=4;
                        answer += "8";
                        break;
                    case 'n' :  //nine
                        i+=3;
                        answer += "9";
                        break;
                    case 'z' : //zero
                        i+=3;
                        answer += "0";
                        break;
                    default:
                        System.out.println("Error! 해당하는 ASCII 코드가 없습니다");
                        break;
                }
            } else {
                answer += s.charAt(i);
            }
        }

        return Integer.parseInt(answer);
    }
}
