package 코드잇.그래프;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StationNode2 {
    private String name;
    private HashMap<String, StationNode2> adjacentStations = new HashMap<>();
    private boolean isVisited = false; //탐색에 사용될 방문여부 boolean, 기본은 false 방문했을시 true가된다.


    public StationNode2(String name) {
        this.name = name;
    }

    //무방향 그래프 추가
    public void addConnection(StationNode2 station) {
        this.adjacentStations.put(station.name, station);
        station.adjacentStations.put(this.name, this);
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited() {
        this.isVisited = true;
    }

    public HashMap<String, StationNode2> getAdjacentStations() {
        return adjacentStations;
    }

    public static Map<String, StationNode2> makeStationMap() throws IOException {

        //역 해시맵
        Map<String, StationNode2> stationMap = new HashMap<>();

        //subway text 파일 읽기. 파일주소를 잘 맞춰주자
        List<String> lines = Files.readAllLines(Paths.get("C:\\codingTestPractices\\src\\코드잇\\그래프\\subway.txt"));

        for (int i = 1; i < lines.size(); i++) {  //subway.txt 의 첫 번째 줄을 제외한 나머지가 노선도 (i = 1부터 시작)
            //역 이름이 있는 부분을 split 해서 List에 넣음
            List<String> stationList = Arrays.asList(lines.get(i).replaceAll(" ", "").split("-"));
            for (int y = 0; y < stationList.size(); y++) { //각자 역 이름이 순서대로 뽑힘 ex) 강남역, 역삼역

                String nowStation = stationList.get(y); //현재 역이름
                StationNode2 station;

                //이미 역 이름(key)이 이미 map에 없다면 새로운 객체 생성해서 넣어줌
                if (!stationMap.containsKey(nowStation)) {
                    stationMap.put(nowStation, new StationNode2(nowStation));
                }

                station = stationMap.get(nowStation);

                //이전 역이 있다면
                if (y - 1 >= 0) {
                    String beforeStation = stationList.get(y - 1);    //이전 역의 이름을 beforeStation으로 지정
                    if (stationMap.containsKey(beforeStation)) {  //이전 역이 이미 map에 있다면
                        station.addConnection(stationMap.get(beforeStation));    //이전 역 객체 불러와서 현재 역 인접리스트에 추가
                    } else {    //이전 역이 있고 map에도 등록되어있지 않다면 Node객체 새로만들어서 넣어줌
                        station.addConnection(new StationNode2(beforeStation));
                    }
                }
                //다음 역이 있다면
                if (y + 1 < stationList.size()) { //위와 마찬가지
                    String afterStation = stationList.get(y + 1);
                    if (stationMap.containsKey(afterStation)) {
                        station.addConnection(stationMap.get(afterStation));
                    } else {
                        station.addConnection(new StationNode2(afterStation));
                    }
                }
            }
        }

        return stationMap;
    }


    @Override
    public String toString() {
        return "StationNode2{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {

        Map<String, StationNode2> stationMap = makeStationMap();


        //인접역 HashMap
        System.out.println(stationMap.get("신당").getAdjacentStations());
        System.out.println(stationMap.get("강남").getAdjacentStations());
        System.out.println(stationMap.get("교대").getAdjacentStations());

    }
}
