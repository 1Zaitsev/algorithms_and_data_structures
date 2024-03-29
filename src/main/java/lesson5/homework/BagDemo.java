package lesson5.homework;

import java.util.ArrayList;
import java.util.List;

public class BagDemo {

    public static void main(String[] args) {

        Bag bag = new Bag(7);

        List<Stuff> stuff = new ArrayList<>();
        stuff.add(new Stuff("book", 1, 600));
        stuff.add(new Stuff("binocular", 2, 5000));
        stuff.add(new Stuff("medicalKit", 4, 1500));
        stuff.add(new Stuff("laptop", 2, 40000));
        stuff.add(new Stuff("bowl", 1, 500));

        bag.findTopPricedBag(stuff);
        stuff = bag.getTopPricedBag();

        System.out.println("Top priced bag costs " + bag.getTopPrice() + ", and contains: ");
        for (Stuff o : stuff) {
            System.out.print(o.getName() + ". It's price: " + o.getPrice() + ".It's  weight: " + o.getWeight());
            System.out.println();
        }
    }
}
