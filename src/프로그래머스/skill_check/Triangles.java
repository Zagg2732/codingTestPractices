package 프로그래머스.skill_check;

import java.util.ArrayList;
import java.util.List;

public class Triangles {

    public int[] solution(int n) {

        List<int[]> list = new ArrayList();

        //2차원배열
        for(int i = 1 ; i < n + 1; i++) {
            list.add(new int[i]);
        }

        //최종숫자
        int totalNumber = 0;
        for(int i = 0; i < n + 1; i++) {
            totalNumber += i;
        }

        for(int i = 0; i < totalNumber + 1; i++) {
            if(i < n) {

            }
        }

        return null;
    }

    public static void main(String[] args) {
        Triangles triangles = new Triangles();

        triangles.solution(4);
    }
}
