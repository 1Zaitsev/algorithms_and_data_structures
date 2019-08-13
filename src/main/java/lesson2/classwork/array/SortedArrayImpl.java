package lesson2.classwork.array;

public class SortedArrayImpl<E extends Object & Comparable<? super E>> extends ArrayImpl<E>{

    @Override
    public void add(E value) {
        checkGrow();
        int index;
        for (index = 0; index < size; index++) {
            if (data[index].compareTo(value)>0)
                break;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }

        data[index] = value;
        size++;
    }

    @Override
    public int indexOf(E value) {
        int low=0;
        int high = size - 1;

        while (low<= high){
            int midl = (low + high)/2;

            if(data[midl].equals(value)){
                return midl;
            }
            else if(data[midl].compareTo(value) > 0){
                high = midl - 1;
            }
            else{
                low = midl + 1;
            }
        }
        return -1;
    }
}
