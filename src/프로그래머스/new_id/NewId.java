package 프로그래머스.new_id;

// https://programmers.co.kr/learn/courses/30/lessons/72410

//처음 생각했던 코드. 정규표현식에서 실수가 있어서 2단계를 다시했는데, 역시나 효율성이 떨어졌다
//정규표현식에 익숙해져야하겠다..

public class NewId {

    public String solution(String new_id) {

        //필터링 1단계
        new_id = new_id.toLowerCase();
        //필터링 2단계
        new_id = illegalCase(new_id);
        //필터링 3단계
        new_id = delDupDot(new_id);
        //필터링 4단계
        new_id = delStartEndDot(new_id);

        //필터링 5단계
        if(new_id == "") {
            new_id = "a";
        }

        //필터링 6단계
        if(new_id.length() > 15) {
            new_id = delOverLength(new_id);
        }

        if(new_id.length() < 3) {
            new_id = addLowestString(new_id);
        }


        System.out.println(new_id);

        return new_id;

    }

    //필터링 2단계) 예외문자처리
    public String illegalCase(String str) {

        String legalStr = "";

        for(int i = 0; i < str.length(); i++) {

            int ascii  = str.charAt(i);

            if(ascii < 123 && ascii > 96 ) {
                legalStr += str.charAt(i);
            } else if (ascii > 47 && ascii < 58) {
                legalStr += str.charAt(i);
            } else if (ascii == 45 || ascii == 46 || ascii == 95) {
                legalStr += str.charAt(i);
            }
        }

        return legalStr;
    }

    //필터링 3단계) . 뒤에 또 .이오는 중복 . 제거하는 함수
    public String delDupDot(String str) {

        boolean checkDot = false;
        String delDotStr = "";

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '.' ) {
                if(checkDot == true) {
                    continue;
                } else {
                    delDotStr += str.charAt(i);
                    checkDot = true;
                }
                checkDot = true;
            } else {
                delDotStr += str.charAt(i);
                checkDot = false;
            }
        }

        return delDotStr;
    }

    //필터링 4단계) 문자열 처음이나 끝이 . 이라면 제거
    public String delStartEndDot(String str) {

        //첫번째 char이 . 이라면 자르기
        if(str.charAt(0) == '.') str = str.substring(1);
        //마지막 char이 . 이라면 자르기

        try {
            if(str.charAt(str.length()-1) == '.') str = str.substring(0,str.length()-1);
        } catch (StringIndexOutOfBoundsException e) { //빈 문자열
            return str = "";
        }

        return str;
    }

    //필터링 6단계) 길이가 16자 이상이라면 자르기
    public String delOverLength(String str) {

        str = str.substring(0, 15);

        if (str.charAt(str.length()-1) == '.') {
            str = str.substring(0, str.length()-1);
        }

        return str;
    }

    //필터링 7단계) 길이가 2자 이하라면 길이가 3이 될 때까지 기존 문자를 넣어줌
    public String addLowestString (String str) {

        char lastChar = str.charAt(str.length() - 1);

        while (str.length() < 3) {
            str += lastChar;
        }

        return str;
    }



}