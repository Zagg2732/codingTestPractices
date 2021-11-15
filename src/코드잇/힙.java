package 코드잇;

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

import java.util.Arrays;

public class 힙 {

    //Tree구조를 heap 정렬하는 heapify를 직접 만들어보자! 최대heap으로 만들자.
    //heapify 함수는 파라미터로 완전이진트리 list, heapify 하려는 노드의 index, 트리로 사용하는 리스트의 size를 받는다.
    public static void heapify(Integer[] list, int index, int size) {
        //해당 index를 heap정렬시키자

        //완전이진트리 특성상 left child부터 채워진다.
        //만약 해당 index가 child가 없는 경우 out of bound 예외가 발생하겠지?
        //그걸 방지하기위해 left child 가 유효 size 내에 있는지 확인부터한다.
        if(index * 2 > size) {  //left child가 size를 벗어났다면, 자식이 없는 node였던 것이므로 끝냄
            System.out.println("index = " + index +" 는 자식이 없는 노드입니다.");
            return;
        }

        if(list[index] < list[index * 2]) { //left child 의 값이 더 높다면
            int temp = list[index]; //부모 노드의 값을 임시저장
            list[index] = list[index * 2];
            list[index * 2] = temp;
            heapify(list, index * 2, size); //바뀐 자식도 heapify 재귀호출
        }

        if(list[index] < list[index * 2 + 1]) { //right child 의 값이 더 높다면
            int temp = list[index];
            list[index] = list[index * 2 + 1];
            list[index * 2 + 1] = temp;
            heapify(list, index * 2 + 1, size); //바뀐 자식도 heapify 재귀호출
        }
    }

    public static void main(String[] args) {
        Integer[] tree = {null, 15, 5, 12, 14, 9, 10, 6, 2, 11, 1};  // heapify하려고 하는 완전 이진 트리

        heapify(tree, 1, tree.length);  // 노드 2에 heapify 호출
        heapify(tree, 2, tree.length);  // 노드 2에 heapify 호출
        heapify(tree, 3, tree.length);  // 노드 2에 heapify 호출

        Integer[] tree2 = {null, 3, 5, 12, 14, 9, 10, 6, 2, 11, 1};  // heapify하려고 하는 완전 이진 트리

        heapify(tree2, 2, tree.length);  // 노드 2에 heapify 호출
        heapify(tree2, 3, tree.length);  // 노드 2에 heapify 호출
        heapify(tree2, 1, tree.length);  // 노드 2에 heapify 호출


        System.out.println("tree = " + Arrays.toString(tree));
        System.out.println("tree2 = " + Arrays.toString(tree2));

    }

}
