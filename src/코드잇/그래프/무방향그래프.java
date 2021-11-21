package 코드잇.그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//무방향그래프 과제.png의 그림대로 2차원 배열을 만들어보자
public class 무방향그래프 {
    public static void main(String[] args) {
        int[][] graph = new int[6][6];

        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[1][0] = 1;
        graph[1][3] = 1;
        graph[1][5] = 1;
        graph[2][0] = 1;
        graph[2][5] = 1;
        graph[3][1] = 1;
        graph[3][5] = 1;
        graph[3][4] = 1;
        graph[4][3] = 1;
        graph[4][5] = 1;
        graph[5][1] = 1;
        graph[5][2] = 1;
        graph[5][3] = 1;
        graph[5][4] = 1;


        for(int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        //다차원 배열은 Arrays.deepToString 으로 출력가능
        System.out.println(Arrays.deepToString(graph));
    }
}
