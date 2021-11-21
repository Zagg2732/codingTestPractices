package 코드잇.그래프;

/*
Breadth first search (너비우선탐색)
시작점에서 가까운 노드 순으로 탐색한다
A
BC
DEF

가 있으면 A, BC , DEF 순으로 탐색한다.
수평적으로 탐색한다고 해서 너비우선탐색인것.

BFS 알고리즘엔 FIFO 규칙을 따르는 queue 가 사용된다
java에서는 Queue<?> queue = new LinkedList<>();
로 만들어서 쓴다.

시작점부터 BFS 단계를 풀이해보자면

1. 시작노드를 방문 표시 후, 큐에 넣는다.
2. (반복) 큐에 아무도 없을때까지 :
    큐 가장 앞 노드를 꺼낸다
    꺼낸 노드에 인접한 모든 노드들을 돈다 :
        (조건) 처음 방문한 노드일시:
            방문한 노드라고 표시한 후 해당 노드를 큐에 넣어준다

이렇게하면 수평적으로 너비우선탐색이 돌아간다.

*/

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static 코드잇.그래프.StationNode2.makeStationMap;

public class BFS {
    //노선도는 StationNode2에서 썻던것 그대로 사용하겠습니당
    private Map<String, StationNode2> stationMap = makeStationMap();

    public Map<String, StationNode2> getStationMap() {
        return stationMap;
    }

    public BFS() throws IOException {
    }

    //BFS를 구현해보자
    //특정 역 이름을 받아서 해당 역과 인접한 역은 isVisited 를 true 로 바꿔준다
    public void breadthFirstSearch(String stationName) {

        //BFS를 위한 queue
        Queue<String> queue = new LinkedList<>();

        //시작 역 방문표시 후 queue에 집어넣음
        StationNode2 init = this.stationMap.get(stationName);
        init.setVisited(); //방문 true
        queue.add(init.getName()); //역이름 queue에 삽입

        //queue가 비어있을때까지 반복
        while (!queue.isEmpty()) {
            //queue 에있던 새로운 노드
            StationNode2 node = this.stationMap.get(queue.poll());
            //해당 노드의 인접한 노드를 순회
            for(String adStationKey : node.getAdjacentStations().keySet()) {
                StationNode2 adNode = this.stationMap.get(adStationKey);

                if (adNode.isVisited()) continue; //이미 방문했다면 넘어감
                else queue.add(adStationKey); adNode.setVisited();  //첫방문 노드라면 queue에 추가후 방문체크
            }
        }

    }

    public static void main(String[] args) throws IOException {
        //FIFO 규칙을 따르는 queue 가 BFS 탐색에 사용된다.
        Queue<String> queue = new LinkedList<>();

        queue.add("A");
        queue.add("B");

        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.peek() = " + queue.peek());

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());

        //이전에 만들어준 StationNode2 클래스를 사용하여 연결된 역들을 살펴보자
        BFS bfs = new BFS();

        //역 데이터 제대로 만들어졌는지 test
        System.out.println("강남역 : " + bfs.getStationMap().get("강남"));
        System.out.println("강남역 인접한역 데이터 : " + bfs.getStationMap().get("강남").getAdjacentStations());

        bfs.breadthFirstSearch("강남");

        //강남역에서 갈아타서 역에 갈수있을까?
        System.out.println(bfs.stationMap.get("강동구청").isVisited());
        System.out.println(bfs.stationMap.get("송도").isVisited());
        System.out.println(bfs.stationMap.get("개화산").isVisited());
        System.out.println(bfs.stationMap.get("평촌").isVisited());

        //아래 역들은 대전에 있는 역들임 (인접하지않은노드)
        System.out.println(bfs.stationMap.get("반석").isVisited());
        System.out.println(bfs.stationMap.get("지족").isVisited());
        System.out.println(bfs.stationMap.get("노은").isVisited());
        System.out.println(bfs.stationMap.get("(대전)신흥").isVisited());

        //하나 의문점. BFS 는 수평방향으로 순회하는것인데 나는 List가 아닌 HashMap으로 저장했음
        //그럴경우 HashMap은 순서보장이 되지않으니 BFS가 아닌것인가?

    }
}
