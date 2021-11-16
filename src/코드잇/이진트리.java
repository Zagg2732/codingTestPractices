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
