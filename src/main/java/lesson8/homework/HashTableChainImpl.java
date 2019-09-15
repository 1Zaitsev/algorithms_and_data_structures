package lesson8.homework;

import java.util.LinkedList;
import lesson8.classwork.HashTable;

public class HashTableChainImpl<K, V> implements HashTable<K, V> {

    private static class Node<K, V> implements Entry<K, V>{
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private int size;
    private LinkedList<Node> [] data;

    @SuppressWarnings("unchecked")
    public HashTableChainImpl(int size) {
        this.size = size;
        this.data = new LinkedList[size];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        if(data[index] == null){
            data[index] = new LinkedList<Node>();
        }
        data[index].add(new Node(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        LinkedList<Node> currentList = data[index];

        for (Node node: currentList) {
            if (node.getKey().equals(key)) {
                return (V) node.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        LinkedList<Node> currentList = data[index];

        for (Node node: currentList) {
            if (node.getKey().equals(key)) {
                Node<K, V> result = node;
                currentList.remove(node);
                size--;
                return result.getValue();
            }
        }
        if(currentList.isEmpty())
            data[index] = null;
        return null;
    }

    @Override
    public void display() {
        System.out.println("__________________");
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null)
            displayList(data[i]);
            else
                System.out.println("-------------");
        }
        System.out.println("__________________");
    }

    public void displayList(LinkedList<Node> linkedList){
        for (Node node: linkedList) {
            System.out.print(node + " \t");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;             //Elements are LinkedLists, that can't be full.
    }
}
