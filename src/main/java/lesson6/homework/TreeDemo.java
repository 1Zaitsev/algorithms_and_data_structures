package lesson6.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeDemo {
    public static void main(String[] args) {
        List<Tree<Integer>> randomTreeList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            randomTreeList.add(randomTreeInit(20, 4));
        }
        
    }

    public static TreeImpl<Integer> randomTreeInit(int valueLimit, int maxLevel){
        TreeImpl<Integer> tree = new TreeImpl<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            if(tree.getLevel() <= maxLevel)
                tree.add(random.nextInt(valueLimit * 2) - valueLimit);
        }
        return tree;
    }
}
