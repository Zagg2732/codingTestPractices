package 코드잇.트리;


//트리 Node
public class Node {

    private int data;       //Node 가 가진 data
    private Node parent;    //Node 의 부모 Node
    private Node leftChild; //Node의 왼쪽 자식
    private Node rightChild;//Node의 오른쪽 자식

    //주어진 노드를 in-order로 출력해주는 함수
    public void printInOrder(Node node) {
        if(node != null) {
            System.out.println("leftChild = " + leftChild);
            System.out.println("data = " + data);
            System.out.println("rightChild = " + rightChild);
        }
    }

    //Node 생성자
    public Node(int data) {
        this.data = data;
    }

    public void setLeftChild(Node node) {
        this.leftChild = node;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node node) {
        this.rightChild = node;
    }

    public int getData() {
        return this.data;
    }

    public Node getParent() {
        return parent;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    //부모노드 여부 체크 (부모존재시 true)
    public boolean hasParent() {
        boolean bool = (parent == null) ? false : true;
        return bool;
    }

    //자식노드 여부 체크 (존재시 false)
    public boolean hasLeftChild() {
        boolean bool = (leftChild == null) ? false : true;
        return bool;
    }

    public boolean hasRightChild() {
        boolean bool = (rightChild == null) ? false : true;
        return bool;
    }

    public void deleteNode() {
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }


    //BST 노드중 특정 노드의 자식들중 가장 낮은 data를 가진 노드 찾기
    public Node findMinInBST(Node node) {
        if(node.hasLeftChild()) findMinInBST(node.getLeftChild());
        return node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", parent=" + parent.getData() +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
