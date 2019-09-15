package lesson8.homework;

import lesson8.classwork.HashTable;
import lesson8.classwork.ItemDefinition;

public class HomeWork8 {
    public static void main(String[] args) {
        HashTable<ItemDefinition, Integer> hTChain= new HashTableChainImpl<>(10);

        ItemDefinition apple = new ItemDefinition(49, "Apple");
        ItemDefinition pear = new ItemDefinition(68, "Pear");
        ItemDefinition orange = new ItemDefinition(31, "Orange");
        ItemDefinition lemon = new ItemDefinition(43, "Lemon");
        ItemDefinition grapefruit = new ItemDefinition(74, "Grapefruit");
        ItemDefinition melon = new ItemDefinition(772, "Melon");
        ItemDefinition watermelon = new ItemDefinition(66, "Watermelon");
        ItemDefinition kiwi = new ItemDefinition(77, "Kiwi");
        ItemDefinition strawberry = new ItemDefinition(99, "Strawberry");
        ItemDefinition mango = new ItemDefinition(19, "Mango");
        ItemDefinition grapes = new ItemDefinition(38, "Grapes");
        ItemDefinition cherry = new ItemDefinition(197, "Cherry");
        ItemDefinition coconut = new ItemDefinition(495, "Coconut");
        ItemDefinition papaya = new ItemDefinition(499, "Papaya");

        hTChain.put(apple, 120);
        hTChain.put(pear, 150);
        hTChain.put(orange, 250);
        hTChain.put(lemon, 100);
        hTChain.put(grapefruit,500);
        hTChain.put(melon, 50);
        hTChain.put(kiwi, 75);
        hTChain.put(strawberry, 750);
        hTChain.put(mango, 175);
        hTChain.put(grapes, 215);
        hTChain.put(cherry, 75);
        hTChain.put(coconut, 450);
        hTChain.put(papaya, 400);

        System.out.println("Orange costs " + hTChain.get(orange));

//        hTChain.remove(orange);

        hTChain.display();
    }
}
