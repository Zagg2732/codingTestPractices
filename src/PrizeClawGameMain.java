import 프로그래머스.prize_claw_game.PrizeClawGame;

public class PrizeClawGameMain {
    //https://programmers.co.kr/learn/courses/30/lessons/64061
    public static void main(String[] args) {

        PrizeClawGame prizeClawGame = new PrizeClawGame();

        int[][] test = {{0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}};

        int[] testMove = {1,5,3,5,1,2,1,4};


        int[][] test2 = {{0, 0, 1, 0, 0},
                         {0, 0, 1, 0, 0},
                         {0, 2, 1, 0, 0},
                         {0, 2, 1, 0, 0},
                         {0, 2, 1, 0, 0}};

        int[] testMove2  = {1, 2, 3, 3, 2, 3, 1};


        System.out.println(prizeClawGame.solution(test, testMove));
        System.out.println(prizeClawGame.solution(test2, testMove2));
    }
}
