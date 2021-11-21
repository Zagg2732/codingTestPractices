package 코드잇.트리;

/*
heap 자료구조는 최대 or 최소를 구할때 가장 효율이 좋은 자료구조이다.
Tree 구조를 근간으로 부모 노드의 데이터가 자식 노드보다 크거나 작은것을 기준으로 삼기때문에, 최대 최소 알고리즘을 짠다면
시간복잡도 O(1) 로 해결가능해진다.

Node class를 만들어서 부모자식관계를 가지고, Data를 가져도 된다. 이 방법은 이진트리에서 이미 만들어봤고
배열로도 표현이 가능하다.
Integer[] tree =  {null, 15, 5, 12, 14, 9, 10, 6, 2, 11, 1};
위와같은 배열로 표현이 가능한데, 표현법상 인덱스 혼동을 막기위해 0번째 인덱스는 null 이 들어간다. 사용하지않음
1번째 인덱스가 root 노드이고 2번째가 left child 3번째가 right child가 된다.
트리구조 특성상 레벨이 내려갈수록 2배씩 공간이 생긴다.
따라서 특정 인덱스의 왼쪽 자식은 인덱스 * 2, 오른쪽 자식은 index * 2 + 1 이 성립된다.
3번째 인덱스의 왼쪽자식은 6, 오른쪽 자식은 7이 되는것이다.
이해가 안된다면 트리구조의 사진을 보고 오자!!

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 힙 {

    //Tree구조를 heap 정렬하는 heapify를 직접 만들어보자! 최대heap으로 만들자.
    //heapify 함수는 파라미터로 완전이진트리 list, heapify 하려는 노드의 index, 트리로 사용하는 리스트의 size를 받는다.
    public static void heapify(List<Integer> list, int index, int size) {
        //해당 index를 기준으로 heapify시키자
        //완전이진트리 특성상 left child부터 채워진다.
        //만약 해당 index가 child가 없는 경우 out of bound 예외가 발생하겠지?
        //그걸 방지하기위해 left child 가 유효 size 내에 있는지 확인부터한다.
        if(index * 2 > size) {  //left child가 size를 벗어났다면, 자식이 없는 node였던 것이므로 끝냄
            //System.out.println("index = " + index +" 는 자식이 없는 노드입니다.");
            return;
        }

        if(list.get(index) < list.get(index * 2)) { //left child 의 값이 더 높다면
            int temp = list.get(index); //부모 노드의 값을 임시저장
            list.set(index, list.get(index * 2));
            list.set(index * 2, temp);
            heapify(list, index * 2, size); //바뀐 자식도 heapify 재귀호출
        }

        if(list.get(index) < list.get(index * 2 + 1)) { //left child 의 값이 더 높다면
            int temp = list.get(index); //부모 노드의 값을 임시저장
            list.set(index, list.get(index * 2 + 1));
            list.set(index * 2 + 1, temp);
            heapify(list, index * 2 + 1, size); //바뀐 자식도 heapify 재귀호출
        }
    }

    //부모를 찾아가는 heapify. priority queue 삽입에 쓰임
    public static void reverseHeapify(List<Integer> list, int index, int size) {
        //마지막 인덱스를 기준으로 부모를 찾아가며 자리를 바꿔준다

        if(index == 1) {  //root 노드까지 도달했다면 끝냄
            return;
        }

        if(list.get(index / 2) < list.get(index)) { //부모의 값이 더 낮다면
            int temp = list.get(index); //부모 노드의 값을 임시저장
            list.set(index, list.get(index / 2));
            list.set(index / 2, temp);
            reverseHeapify(list, index / 2, size); //바뀐 자식도 reverseHeapify 재귀호출
        }
    }

    /*
    heap정렬을 해보자 (최대힙이면 오름차순, 최소힙이면 내림차순이 될것이다)
    heap 정렬의 특징
    1. 해당 배열은 heapify가 된 상태여야함
    2. root 와 끝 node를 교체함
    3. 교체된 끝 node는 더이상 교체하지않음 (없는것처럼 취급, 최대 heap 이었다면 이미 최댓값이 맨뒤로 간것과 같음)
    4. root index 에서 다시 heapify 해줌 (root부터 재귀호출로 다시 heap이됨)
    5. 2~4 반복하고 끝나면 오름차순정렬이 완료됨
    6. O(nlog n) 의 시간복잡도를 갖는다
    */
    public static void heapsort(List<Integer> heapifiedList) { //반드시 heapify가 완료된 배열이 들어와야한다
        for(int i = heapifiedList.size() - 1; i > 0; i--) {
            int temp = heapifiedList.get(1);
            heapifiedList.set(1, heapifiedList.get(i));
            heapifiedList.set(i, temp);
            heapify(heapifiedList, 1, i-2); //size는 점점 줄어들며 root node에서 heapify
        }
    }

    /*
    heap은 우선순위큐를 구현하기 쉽다는 장점이있다.
    priority queue insert 함수를 만들어서. 값을 주가해도 heap이 유지되도록 해보자.
    1.새로운 값은 끝에 삽입된다.
    2.부모와 비교해서 heap을 유지한다.
    3.부모를 계속 타고올라가면서 비교해야한다.
    */
    public static void pqinsert(List<Integer> heapifiedList, int value) {
        heapifiedList.add(value);
        reverseHeapify(heapifiedList, heapifiedList.size() - 1, heapifiedList.size());
    }

    /*
    priority queue 에서 최댓값을 추출해보자. (최소 heap이었으면 최솟값이 나옴)
    1. 첫번째 인덱스는 최댓값이므로 추출함. 그 자리를 마지막 인덱스가 채움
    2. 현재 첫번째 인덱스는 마지막 인덱스(였던 것) 이 들어가있음. 이전에 heap을 만족했었기 때문에 첫번째 인덱스 빼고는 다 heap을 만족한상태
    3. 첫번째 인덱스에 대해 heapify를 해주면 끝!
    */

    public static int extractMax(List<Integer> heapifiedList) {

        //마지막 인덱스를 첫번째 인덱스와 바꾼 후에 삭제할것임. 그것이 더 효율적이라는 개인적인 판단?
        //만약 첫번째 인덱스를 remove 하고, 마지막 인덱스의 값을 첫번째에 add한다면 시간복잡도 O(n) 이 두번실행됨.
        //get과 set으로 미리 인덱스 값들을 구해주고 set과 remove(마지막값)을 한다면 O(1) 이 되지않나?

        //첫번째 인덱스를 구해준다
        int extractedValue = heapifiedList.get(1);
        int lastValue = heapifiedList.get(heapifiedList.size()-1);

        System.out.println("lastValue = " + lastValue);
        //마지막 인덱스를 첫번째 인덱스와 맞춘후 삭제
        heapifiedList.remove(heapifiedList.get(heapifiedList.size()-1));
        heapifiedList.set(1, lastValue);

        heapify(heapifiedList,1,heapifiedList.size()-2);

        return extractedValue;
    }




    public static void main(String[] args) {

        List<Integer> tree = new ArrayList<>(Arrays.asList(null, 15, 5, 12, 14, 9, 10, 6, 2, 11, 1));
        List<Integer> tree2 = new ArrayList<>(Arrays.asList(null, 15, 5, 12, 14, 9, 10, 6, 2, 11, 1));



        heapify(tree, 1, tree.size());  // 노드 2에 heapify 호출
        heapify(tree, 2, tree.size());  // 노드 2에 heapify 호출
        heapify(tree, 3, tree.size());  // 노드 2에 heapify 호출


        heapify(tree2, 2, tree.size());  // 노드 2에 heapify 호출
        heapify(tree2, 3, tree.size());  // 노드 2에 heapify 호출
        heapify(tree2, 1, tree.size());  // 노드 2에 heapify 호출


        System.out.println("tree = " + tree.toString());
        System.out.println("heapify 후 tree2 = " + tree2.toString());
        heapsort(tree2);
        System.out.println("heapsort 후 tree2 = " + tree2.toString());

        pqinsert(tree, 33);
        pqinsert(tree, 34);
        pqinsert(tree, 35);
        pqinsert(tree, 52);
        System.out.println("priority queue inesert 후 tree = " + tree.toString());
        //heapsort(tree);
        //System.out.println("heapsort 후 tree = " + tree.toString());

        System.out.println("extractMax(tree) = " + extractMax(tree));

        System.out.println("extractMax 후 tree = " + tree);
    }

}
