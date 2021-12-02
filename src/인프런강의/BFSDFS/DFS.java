package 인프런강의.BFSDFS;

import java.util.Stack;

//DFS 는 Depth First Search. 깊이우선탐색
public class DFS {

    Stack<int[]> DFSstack = new Stack<>();

    public int solution(int[][] grid) {

        int xSize = grid.length;
        int ySize = grid[0].length;
        int[][] exploredGrid = new int[xSize][ySize]; //탐험한지역 표시할 grid
        int[][] dirs = new int[][]{{0,1}, {1,0},{0, -1},{-1,0}}; //4방향 확인할 2차원배열

        for(int y = 0; y < ySize; y++) {
            for(int x = 0; x < xSize; x++) {
                if(grid[x][y] == 0 || exploredGrid[x][y] ==1) {
                    continue;
                } else {
                    DFSstack.add(new int[]{x,y});
                    //재귀호출로 끝까지가기

                }
            }
        }

        return -1;
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

        DFS dfs = new DFS();

        System.out.println("dfs.solution(grid1) = " + dfs.solution(grid1));
        System.out.println("dfs.solution(grid2) = " + dfs.solution(grid2));
        System.out.println("dfs.solution(grid3) = " + dfs.solution(grid3));
        System.out.println("dfs.solution(grid4) = " + dfs.solution(grid4));

    }
}
