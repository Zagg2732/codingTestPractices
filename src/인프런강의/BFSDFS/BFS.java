package 인프런강의.BFSDFS;

import java.util.*;

//BFS는 Breadth First Search . 너비우선탐색이며 가로부터 탐색하면서 내려감 ->방향
public class BFS {

    //BFS를 돌리기위해 사용되는 Queue
    private Queue<int[]> BFSQueue = new LinkedList<>();

    public int solution(int[][] grid) {

        int answer = 0; //리턴할 육지개수

        int xSize = grid.length; //2차원 배열의 x좌표 크기
        int ySize = grid[0].length; //grid의 크기가 m*n 의 직사각형 모양이라고 주어졌음
        int[][] exploredGrid = new int[xSize][ySize]; //탐험지역을 표시할 똑같은 크기의 2차원 배열, 생성시 모두 0으로 채워져있음
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //2차원배열 4방향 탐색하기위한 2차원배열


        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                // 육지가 아니고 이미 탐험한 지역(1) 이면 continue
                if (grid[x][y] == 0 || exploredGrid[x][y] == 1) {
                    continue;
                }
                //육지라면 탐험할 queue 에 넣어줌
                BFSQueue.add(new int[]{x, y});
                //육지끝날때까지 4방향 체크하면서 육지표시할 while문
                while (!BFSQueue.isEmpty()) {
                    //Queue에있던 육지를 Queue에서 빼주고 4방향 돌리기
                    int[] land = BFSQueue.poll();
                    //4방향좌표 for문
                    for (int[] dir : dirs) {
                        int x1 = land[0] + dir[0];
                        int y1 = land[1] + dir[1];
                        //좌표가 섬의 유효범위 안이면서 탐험해본적이 없고 육지면 Queue에 추가하면서 BFS돌게됨
                        if (x1 >= 0 && x1 < xSize && y1 >= 0 && y1 < ySize && exploredGrid[x1][y1] == 0 && grid[x1][y1] == 1) {
                            BFSQueue.add(new int[]{x1, y1});
                            //Queue에 추가된 지역은 탐험된 지역으로 표시
                            exploredGrid[x1][y1] = 1;
                        }
                    }
                }
                //붙어있는 육지탐험 끝나면 answer++
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        //해당 배열을 바다와 섬이라고 가정
        //0은 바다 1은 육지라고 할때
        //몇개의 섬이 이루어져있는가?
        int[][] grid1 = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };  //return 1

        System.out.println(grid1.length);

        int[][] grid2 = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };  //return 2

        int[][] grid3 = new int[][]{
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0}
        };  //return 3

        int[][] grid4 = new int[][]{
                {1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0, 0}
        };  //return 5

        BFS bfs = new BFS();

        System.out.println("bfs.solution(grid1) = " + bfs.solution(grid1));
        System.out.println("bfs.solution(grid2) = " + bfs.solution(grid2));
        System.out.println("bfs.solution(grid3) = " + bfs.solution(grid3));
        System.out.println("bfs.solution(grid4) = " + bfs.solution(grid4));

    }
}
