package 코드잇;

public class 이진트리 {
    public static void main(String[] args) {

        Node rootNode = new Node(2);
        Node nodeB = new Node(3);
        Node nodeC = new Node(5);
        Node nodeD = new Node(7);
        Node nodeE = new Node(11);

        rootNode.setLeftChild(nodeB);
        rootNode.setRightChild(nodeC);
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);

        System.out.println("rootNode.getLeftChild() = " + rootNode.getLeftChild());
        System.out.println("rootNode.getLeftChild().getData() = " + rootNode.getLeftChild().getData());

    }
}

//이진트리 Node
class Node {

    private int data;       //Node 가 가진 data
    private Node leftChild; //Node의 왼쪽 자식
    private Node rightChild;//Node의 오른쪽 자식

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

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
