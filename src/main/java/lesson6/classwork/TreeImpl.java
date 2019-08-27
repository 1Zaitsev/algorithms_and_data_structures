package lesson6.classwork;

import java.util.Stack;


public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;


    @Override
    public boolean find(E value) {

        return doFind(value) != null;
    }

    @Override
    public boolean add(E value) {

        Node<E> node = new Node<>(value);
        if(root == null){
            this.root = node;
            return true;
        }

        NodeAndParent nodeAndParent = doFind(value);
        if(nodeAndParent.node!=null){
            return false;
        }

        Node<E> previous = nodeAndParent.parent;

        if(previous.shouldBeLeft(value))
            previous.setLeftChild(node);
        else
            previous.setRightChild(node);
        size++;
        return true;
    }

    private NodeAndParent doFind(E value){

        Node<E> current = this.root;
        Node<E> parent = null;

        while (current != null){

            if(current.getValue().equals(value))
                return new NodeAndParent(current, parent);

            parent = current;

            if(current.shouldBeLeft(value))
                current = current.getLeftChild();

            else
                current = current.getRightChild();
        }
        return new NodeAndParent(null, parent);
    }

    @Override
    public boolean remove(E value) {

        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removedNode = nodeAndParent.node;
        Node<E> parent = nodeAndParent.parent;

        if(removedNode == null)
            return false;

        if(removedNode.isLeaf())
            removeLeafNode(parent, removedNode);
        else if(removedNode.singleChild())
            removedSingleChildNode(parent, removedNode);
        else
            removeCommonNode(parent, removedNode);

        size --;
        return true;
    }

    private void removeCommonNode(Node<E> parent, Node<E> removedNode) {

        Node<E> successor = getSuccessor(removedNode);

        if(removedNode == root)
            root = successor;
        else if (parent.getLeftChild() == removedNode)
            parent.setLeftChild(successor);
        else
            parent.setRightChild(successor);
        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {

        Node<E> successor = removedNode;
        Node<E> succesorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            succesorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if(successor != removedNode.getRightChild()){
            succesorParent.setLeftChild(succesorParent.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }
        return successor;
    }

    private void removedSingleChildNode(Node<E> parent, Node<E> removedNode) {

        Node<E> child = removedNode.getLeftChild() != null ? removedNode.getLeftChild() : removedNode.getRightChild();

        if(removedNode == root)
            root = child;
        else if (parent.getLeftChild() == removedNode)
            parent.setLeftChild(child);
        else
            parent.setRightChild(child);

    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {

        if(removedNode == root)
            root = null;
        else if (parent.getLeftChild() == removedNode)
            parent.setLeftChild(null);
        else
            parent.setRightChild(null);

    }

    @Override
    public void display() {

        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");

    }

    @Override
    public void isBalanced() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode){
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default: throw new IllegalArgumentException("Unknown mode " + mode);
        }
    }

    private void inOrder(Node<E> node) {

        if(node == null)
            return;

        inOrder(node.getLeftChild());
        System.out.println(node.getValue());
        inOrder(node.getRightChild());

    }

    private void preOrder(Node<E> node) {

        if(node == null)
            return;

        System.out.println(node.getValue());
        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());

    }

    private void postOrder(Node<E> node) {

        if(node == null)
            return;

        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
        System.out.println(node.getValue());

    }

    private class NodeAndParent{
        Node<E> node;
        Node<E> parent;

        public NodeAndParent(Node<E> node, Node<E> parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
