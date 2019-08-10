package grokking_algorithms.chapter3;

import java.util.Random;

public class Item {
    boolean isKey = false;
    boolean isBox = false;

    public Item(){
        Random random = new Random();
        if(random.nextInt(5) == 0) // ключи только в каждом 5
            isKey = true;
        else
            isBox = true;
    }

    public boolean isKey() {
        return isKey;
    }

    public boolean isBox() {
        return isBox;
    }

    public void setKey(boolean key) {
        isKey = key;
    }

    public void setBox(boolean box) {
        isBox = box;
    }
}
