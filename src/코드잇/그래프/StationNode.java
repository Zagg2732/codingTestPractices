package 코드잇.그래프;

/*
지하철 역과 관련된 그래프를 만들어보자

일반적으로 그래프에서 노드는 동등하다. head노드 root노드와 같은 노드는 없다.

*/

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StationNode {
    private String name;
    private int numExits;

    //역 이름과 출구 번호를 가진 생성자를 만들어준다.
    public StationNode(String name, int numExits) {
        this.name = name;
        this.numExits = numExits;
    }

    //text에서 역이름만 가져와서 만드는 StationNode
    public StationNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StationNode{" +
                "name='" + name + '\'' +
                ", numExits=" + numExits +
                '}';
    }

    public static void main(String[] args) throws IOException {

        // 1. 배열로 그래프 만들기
        //지하철 역 노드 인스턴스 생성
        StationNode station0 = new StationNode("교대역", 14);
        StationNode station1 = new StationNode("사당역", 14);
        StationNode station2 = new StationNode("종로3가역", 16);
        StationNode station3 = new StationNode("서울역", 16);

        //노드들을 ArrayList에 저장
        List<StationNode> stationNodeList = new ArrayList<>();

        stationNodeList.add(station0);
        stationNodeList.add(station1);
        stationNodeList.add(station2);
        stationNodeList.add(station3);

        System.out.println(stationNodeList);

        //원하는 지하철역이 배열의 어느위치에 있는지 알고있으면 O(1)의 속도로 불러올 수 있다.

        //HashMap 형태로 저장하기
        Map<String, StationNode> stationNodeMap = new HashMap();

        //key 값으로 저장함으로서 더욱 직관적으로 저장가능
        //마찬가지로 key 값을 알수있다면 value는 O(1)의 속도로 불러올 수 있다.
        //key는 중복값이 들어갈수 없다는 제약을 신경써야한다. (key가 고유값을 가질수 있게끔 설계해야한다)
        //토막상식. HashMap에 중복된 key 값으로 put하면 key값에 대한 value가 덮어씌워진다.
        stationNodeMap.put("교대역", station0);
        stationNodeMap.put("사당역", station1);
        stationNodeMap.put("종로3가역", station2);
        stationNodeMap.put("서울역", station3);

        System.out.println(stationNodeMap.get("교대역"));

        //subway text 파일 읽기. 파일주소를 잘 맞춰주자
        List<String> lines = Files.readAllLines(Paths.get("C:\\codingTestPractices\\src\\코드잇\\그래프\\subway.txt"));

        //역 이름이 있는 부분을 split 해서 List에 넣음

        List<String> stationList = Arrays.asList(lines.get(1).replaceAll(" ", "").split("-"));


        //역 해시맵
        Map<String, StationNode> stationNodeMapByText = new HashMap<>();

        //List에 있는 역들을 역이름을 key, value를 Node로 해서 만들어보자
        for (String str : stationList) {
            stationNodeMapByText.put(str, new StationNode(str));
        }

        Set<String> stationKeys = stationNodeMapByText.keySet();

        Object[] keyList = stationNodeMapByText.keySet().toArray();
        Arrays.sort(keyList);

        System.out.println("----------- 1호선 역 출력 ------------");
        for (String key : stationKeys) {
            System.out.println(stationNodeMapByText.get(key));
        }

        System.out.println("----------- 1호선 역 가나다순 출력 ------------");
        for (Object key : keyList) {
            System.out.println(stationNodeMapByText.get(key));
        }

    }
}
