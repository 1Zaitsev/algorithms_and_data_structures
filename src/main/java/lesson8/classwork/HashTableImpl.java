package lesson8.classwork;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private static class Node<K, V> implements Entry<K, V>{
        private K key;
        private V value;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;


        }

        @Override
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Node<K, V> [] data;
    private int size;
    private int maxSize;

    public HashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Node[maxSize * 2];
    }

    private int hashFunc(K key){
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        if(isFull())
            return false;

        int index = hashFunc(key);
        int count = 0;
        while(data[index] != null) {
            if(count == data.length){
                index++;
                count = 0;
            }
            Node<K, V> node = data[index];
            if(node.getKey().equals(key)) {
                node.setValue(value);
                return true;
            }

            index += getStep(key);
            index %= data.length;
            count++;
        }

        data[index] = new Node<>(key, value);
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index != -1 ? data[index].getValue() : null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if(index == -1)
            return null;

        Node<K, V> result = data[index];
        data[index] = null;
        size--;
        return result.getValue();

    }

    private int indexOf(K key){
        int index = hashFunc(key);
        int count = 0;
        while (data[index] != null && count != data.length){
            Node<K, V> node = data[index];
            if(node.getKey().equals(key)){
                return index;
            }
            index += getStep(key);
            index %= data.length;
            count++;
        }

        return -1;
    }

    protected int getStep(K key) {
        return 1;
    }

    @Override
    public void display() {
        System.out.println("________________");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]", i, data[i]);
            System.out.println();
        }
        System.out.println("________________");
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
        return size == maxSize;
    }
}
