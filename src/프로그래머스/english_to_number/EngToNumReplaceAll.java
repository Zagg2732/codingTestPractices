package 프로그래머스.english_to_number;

//replaceAll을 사용하니 무지빠르다

public class EngToNumReplaceAll {

    public int solution(String s) {

        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < digits.length; i++) {
            s = s.replaceAll(alphabets[i], digits[i]);
        }

        return Integer.parseInt(s);
    }
}
