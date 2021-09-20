package lotto;

//import java.util.Arrays;
import java.util.stream.IntStream;

// https://programmers.co.kr/learn/courses/30/lessons/77484
public class Lotto {

    // 처음 생각했던 코드. Arrays.sort를 사용했었으나 어차피 당첨번호와 구매번호가 6개로 짧고,
    // 파이썬에서 활용하던 것처럼 List를 줄여가며 하지 않았기 때문에 효율성이 떨어짐
    // 또한 IntStream.of(win_nums).anyMatch(y -> y == i) 를 통해 당첨여부를 확인했기에
    // 람다식을 자주 써본건 좋았으나 효율적이지 못했음
    // rank도 rankSystem으로 숫자를 받아 switch문을 작성했으며 결과는 원하는대로 나왔지만 효율성이 떨어짐

    public int rankSystem(int number) {
        int rank = 0;
        switch (number) {
            case 6 : rank = 1;
                break;
            case 5 : rank = 2;
                break;
            case 4 : rank = 3;
                break;
            case 3 : rank = 4;
                break;
            case 2 : rank = 5;
                break;
            default: rank = 6;
                break;
        }
        return rank;
    }

    public int[] solution(int[] lottos, int[] win_nums) {

        //Arrays.sort(lottos);
        //Arrays.sort(win_nums);

        int minAnswer = 0;
        int unknown = 0;

        for(int i : lottos) {
            if(i == 0) {    //알아볼수 없는 숫자
                unknown ++;
            } else {
                if( IntStream.of(win_nums).anyMatch(y -> y == i )){
                    minAnswer++;
                }
            }
        }

        int minRank = rankSystem(minAnswer);
        int maxRank = rankSystem(minAnswer + unknown);


        int[] answer = { maxRank , minRank};
        return answer;
    }

}
