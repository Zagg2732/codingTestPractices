import 프로그래머스.lotto.Lotto;
import 프로그래머스.lotto.LottoHashMap;

import java.util.Arrays;

public class LottoMain {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        LottoHashMap lottoHashMap = new LottoHashMap();


        int[] lottos = new int[] {44, 1, 0, 0, 31, 25};
        int[] winNums = new int[] {31, 10, 45, 1, 6, 19};

        //result = [3,5]

        System.out.println(Arrays.toString(lotto.solution(lottos, winNums)));
        System.out.println(Arrays.toString(lottoHashMap.solution(lottos, winNums)));



    }
}
