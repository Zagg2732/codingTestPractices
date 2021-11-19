package 코드잇;


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

    @Override
    public String toString() {
        String parent = "";
        try {
            parent += getParent().getData();
        } catch (NullPointerException e) {
            parent += "null";
        }

        return "Node{" +
                "data=" + data +
                ", parent=" + parent +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
