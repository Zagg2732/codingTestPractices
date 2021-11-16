package 코드잇;

public class 완전이진트리 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(7);
        bst.insert(11);
        bst.insert(9);
        bst.insert(17);
        bst.insert(8);
        bst.insert(5);
        bst.insert(19);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(14);

        bst.printSortedTree();
    }
}
class BinarySearchTree {
    private Node root; //기준이 되는 root 노드를 가지고있는다!

    public void dataComparison(Node node, int data) {
        //node의 데이터보다 data가 작으면 왼쪽
        if(node.getData() > data) {
            try {
                dataComparison(node.getLeftChild(), data);
            } catch (NullPointerException e) { // node.getLeftChild() 가 null 이면 NullPointerException 인것을 이용해서 데이터 넣어줌
                node.setLeftChild(new Node(data));
                return;
            }
        } else {
            try {
                dataComparison(node.getRightChild(), data);
            } catch (NullPointerException e) {
                node.setRightChild(new Node(data));
                return;
            }
        }
    }

    //이진탐색트리에 insert 하는 함수
    //root노드부터 비교해가며 새로운 노드를 저장할 위치를 찾는다. 비교해서 작다면 left child 크다면 right child
    public void insert(int data) {

        //아직 트리에 노드가없다면 루트가됨
        if(this.root == null) {
            this.root = new Node(data);
            return;
        }

        //root 부터 데이터비교 들어감
        dataComparison(this.root, data);

    }

    //Tree형 자료를 In-order 방식으로 값 출력하기
    public void printInOrder(Node node) {
        if(node != null) {
            //왼쪽 get 하면서 재귀 , null을 만나면 돌아오면서 print하고, 오른쪽을 돈다. 이과정을 재귀함수로 반복
            printInOrder(node.getLeftChild());
            System.out.println(node.getData());
            printInOrder(node.getRightChild());
        }
    }

    //정렬된 Tree 호출
    public void printSortedTree() {
        printInOrder(this.root);
    }
}

