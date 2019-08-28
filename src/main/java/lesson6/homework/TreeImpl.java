package lesson6.homework;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;
    private int level;


    private NodeAndParent search(E value) {
        Node<E> current = this.root;
        Node<E> parent = null;

        while (current != null){

            level++;

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
    public boolean find(E value) {

        return search(value).node != null;

    }

    @Override
    public boolean add(E value) {
        Node<E> node = new Node<>(value);
        NodeAndParent nodeAndParent = search(value);
        Node<E> parent = nodeAndParent.parent;

        if(root == null) {
            this.root = node;
            return true;
        }

        if(nodeAndParent.node != null)
            return false;

        if(parent.shouldBeLeft(value))
            parent.setLeftChild(node);
        else
            parent.setRightChild(node);

        size++;
        return true;
    }

    @Override
    public boolean remove(E value) {

        NodeAndParent nodeAndParent = search(value);
        Node<E> node = nodeAndParent.node;
        Node<E> parent = nodeAndParent.parent;

        if(node == null)
            return false;

        else if(node.isLeaf()){
            removeLeaf(node, parent);
        }
        else if(node.hasSingleChild()){
            removeSingleChildNode(node, parent);
        }
        else removeTwoChildrenNode(node, parent);


        return false;
    }



    private void removeLeaf(Node<E> parent, Node<E> node) {

        if(node == root)
            root = null;
        else if(parent.getLeftChild() == node)
            parent.setLeftChild(null);
        else
            parent.setRightChild(null);
    }

    private void removeSingleChildNode(Node<E> node, Node<E> parent) {
        Node<E> child = node.getLeftChild() == null ? node.getLeftChild(): node.getRightChild();

        if(node == root)
            root = child;

        else if(parent.getLeftChild() == node)
            parent.setLeftChild(child);
        else
            parent.setRightChild(child);

    }

    private void removeTwoChildrenNode(Node<E> node, Node<E> parent) {

        Node<E> successor = getSuccessor(node);

        if(node == root)
            root = successor;
        else if(parent.getLeftChild() == node)
            parent.setLeftChild(successor);
        else
            parent.setRightChild(successor);
        successor.setLeftChild(node.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> node) {

        Node<E> successor = node;
        Node<E> successorParent = null;
        Node<E> current = node.getRightChild();

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if(successor!= node.getRightChild()){
            successorParent.setLeftChild(successorParent.getRightChild());
            successor.setRightChild(node.getRightChild());
        }

        return successor;

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
    public void traverse(TraverseMode mode) {

        switch (mode) {
            case IN_ORDER:
                traverseInOrder(root);
                break;
            case PRE_ORDER:
                traversePreOrder(root);
                break;
            case POST_ORDER:
                traversePostOrder(root);
                break;
        }

    }

    private void traverseInOrder(Node<E> node) {

        if(node == null)
            return;

        traverseInOrder(node.getLeftChild());
        System.out.println(node.getValue());
        traverseInOrder(node.getRightChild());
    }

    private void traversePreOrder(Node<E> node) {

        if(node == null)
            return;

        System.out.println(node.getValue());
        traverseInOrder(node.getLeftChild());
        traverseInOrder(node.getRightChild());
    }

    private void traversePostOrder(Node<E> node) {

        if(node == null)
            return;

        traverseInOrder(node.getLeftChild());
        traverseInOrder(node.getRightChild());
        System.out.println(node.getValue());
    }

    @Override
    public int size() {
        return size;
    }

    public int getLevel(){
        return level;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    private class NodeAndParent{
        Node<E> node;
        Node<E> parent;

        public NodeAndParent(Node<E> node, Node<E> parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    @Override
    public boolean isBalanced() {
        return firstBalanceIndicator(root)
        && secondBalanceIndicator();
    }


    private boolean firstBalanceIndicator(Node node) {              // Перове условие баланса (пояснение к ДЗ): длина до любого листа одинаковая или отличатеся на 1.
        return (node == null) ||
                firstBalanceIndicator(node.getLeftChild()) &&
                        firstBalanceIndicator(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    private boolean secondBalanceIndicator() {                  //Второе условие баланса (пояснения к ДЗ): расстояние до самого дальнего листа меньше натурального логорифма от кол-ва всех элементов.
        return Math.log(this.size) <= this.level;
    }

}
