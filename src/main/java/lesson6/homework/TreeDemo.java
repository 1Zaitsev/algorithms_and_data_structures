package lesson6.homework;

import java.util.Random;

public class TreeDemo {
    public static void main(String[] args) {

        int quantityOfBalancedTree = 0;
        int quantityOfImbalancedTree = 0;

        for (int i = 0; i < 100; i++) {
            Tree<Integer> tree = randomTreeInit(20, 4);

            if(tree.isBalanced())
                quantityOfBalancedTree += 1;
            else {
                quantityOfImbalancedTree +=1;
            }
        }

        System.out.println("The percentage  of imbalanced trees is " + quantityOfImbalancedTree + "%, balanced - " + quantityOfBalancedTree + "%.");

    }

    public static TreeImpl<Integer> randomTreeInit(int valueLimit, int maxLevel){
        TreeImpl<Integer> tree = new TreeImpl<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {              // независимо от количества попыток добавления элемента в дерево, профент сбалансированных деревьев 30-40%.
            if(tree.getLevel() <= maxLevel)
                tree.add(random.nextInt(valueLimit * 2) - valueLimit);
        }
        return tree;
    }
}
