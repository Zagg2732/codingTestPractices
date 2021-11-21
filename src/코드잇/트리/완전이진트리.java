package 코드잇.트리;


//이진탐색트리(BinarySearchTree) 는 이진트리로 이루어져 있다.
//특정 노드의 모든 왼쪽 노드는 그 노드보다 작아야한다. 모든 오른쪽 노드는 그 노드보다 작아야한다.
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

        System.out.println("bst.searchNode(100) = " + bst.searchNode(bst.getRoot(),100));

        System.out.println("bst.deleteNode(bst.getRoot(), 3) = " + bst.deleteNode(bst.getRoot(), 3));
        bst.printSortedTree();
    }
}

class BinarySearchTree {
    private Node root; //기준이 되는 root 노드를 가지고있는다!

    public Node getRoot() {
        return root;
    }

    //node 데이터를 비교해서 왼쪽 혹은 오른쪽 자식으로 추가함
    public void dataComparison(Node node, int data) {
        //node의 데이터보다 data가 작으면 왼쪽
        if (node.getData() > data) {
            try {
                dataComparison(node.getLeftChild(), data);
            } catch (NullPointerException e) { // node.getLeftChild() 가 null 이면 NullPointerException 인것을 이용해서 데이터 넣어줌
                Node newChild = new Node(data);
                node.setLeftChild(newChild);
                newChild.setParent(node);
                return;
            }
        } else {
            try {
                dataComparison(node.getRightChild(), data);
            } catch (NullPointerException e) {
                Node newChild = new Node(data);
                node.setRightChild(newChild);
                newChild.setParent(node);
                return;
            }
        }
    }

    //이진탐색트리에 insert 하는 함수
    //root노드부터 비교해가며 새로운 노드를 저장할 위치를 찾는다. 비교해서 작다면 left child 크다면 right child
    public void insert(int data) {

        //아직 트리에 노드가없다면 루트가됨
        if (this.root == null) {
            this.root = new Node(data);
            return;
        }

        //root 부터 데이터비교 들어감
        dataComparison(this.root, data);

    }

    //Tree형 자료를 In-order 방식으로 값 출력하기
    public void printInOrder(Node node) {
        if (node != null) {
            //왼쪽 get 하면서 재귀 , null을 만나면 돌아오면서 print하고, 오른쪽을 돈다. 이과정을 재귀함수로 반복
            printInOrder(node.getLeftChild());
            System.out.println(node.getData());
            printInOrder(node.getRightChild());
        }
        return;
    }

    //정렬된 Tree 호출
    public void printSortedTree() {
        printInOrder(this.root);
    }

    //특정 노드 찾기
    public Node searchNode(Node node, int data) {

        //node 가 null 이면 재귀종료
        if (node == null) return null;

        //data 를 찾았으면 return data
        if (node.getData() == data) return node;

        //null 이 리턴됐을경우를 체크하는 returnValue
        Node returnNode;

        if (node.getData() > data) {
            returnNode = searchNode(node.getLeftChild(), data);
        } else {
            returnNode =searchNode(node.getRightChild(), data);
        }

        //node 가 null이었으면
        if(returnNode == null) {
            return null;
        }
        return returnNode;
    }

    //특정 노드 삭제
    //특정 노드의 위치를 찾아서 삭제해야한다.
    //이진 탐색 트리에서 삭제하는 조건이 몇가지 발생한다.
    //1. 삭제하려는 노드가 자식이 없는 leaf 노드일경우. 그냥 삭제하면 된다.
    //2. 삭제하려는 노드가 왼쪽 자식이 있을경우
    //3. 삭제하려는 노드가 왼쪽/오른쪽 자식이 모두 있을경우

    public boolean deleteNode(Node rootNode,int value) {
        //노드를 탐색
        Node searchedNode = searchNode(rootNode, value);

        //탐색된 노드가 없다면(null) false 리턴
        if(searchedNode == null) {
            return false;
        }

        if(searchedNode.getLeftChild() == null && searchedNode.getRightChild() == null) { //자식이 없는 leaf 노드

            //부모 노드
            Node parentNode;

            try {
                parentNode = searchedNode.getParent();
                if(parentNode.getLeftChild() == searchedNode) parentNode.setLeftChild(null);
                else parentNode.setRightChild(null);
            } catch (NullPointerException e) {
                //부모가 없는 rootNode
            }

            searchedNode = null;
        } else if (searchedNode.getLeftChild() != null && searchedNode.getRightChild() == null) { //왼쪽 자식만 있을때

            Node parentNode;

            try {
                //원래 부모 노드
                parentNode = searchedNode.getParent();
                //왼쪽 자식 노드
                Node childNode = searchedNode.getLeftChild();
                //왼쪽 자식에게 새로운 부모를 설정해줌
                childNode.setParent(parentNode);

                if(parentNode.getLeftChild() == searchedNode) parentNode.setLeftChild(childNode);
                else parentNode.setRightChild(childNode);
            } catch (NullPointerException e) {
                //부모가 없는 rootNode
            }
            searchedNode = null;
        } else if (searchedNode.getLeftChild() == null && searchedNode.getRightChild() != null) { //오른쪽 자식만 있을때
            Node parentNode;

            try {
                //원래 부모 노드
                parentNode = searchedNode.getParent();
                //오른쪽 자식 노드
                Node childNode = searchedNode.getRightChild();
                //오른쪽 자식에게 새로운 부모를 설정해줌
                childNode.setParent(parentNode);

                if(parentNode.getLeftChild() == searchedNode) parentNode.setLeftChild(childNode);
                else parentNode.setRightChild(childNode);

            } catch (NullPointerException e) {
                //부모가 없는 rootNode
            }
            searchedNode = null;
        } else { //자식이 둘다 있을때
            //자식이 둘다 있을경우 오른쪽 노드에서 제일 낮은값으로 Data를 대체하고 삭제한다.
            //그러면 이진탐색트리의 조건을 만족하면서 삭제가 완료된다.
            //오른쪽 자식의 node기준으로 min Node 값 구함

            Node minNode;

            System.out.println(searchedNode.findMinInBST(searchedNode.getRightChild()));

            minNode = searchedNode.findMinInBST(searchedNode.getRightChild());
            int minData = minNode.getData();

            //searchedNode를 오른쪽자식기준 최솟값으로 변경함 (BST 성질 유지하면서 기존 Data는 사라짐)
            searchedNode.setData(minData);

            //minNode 삭제
            System.out.println(minNode);
            minNode = null;
        }

        return true;
    }

}

