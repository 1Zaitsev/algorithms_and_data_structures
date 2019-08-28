package lesson5.homework;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private int weightLimit;
    private List<Stuff> topPricedBag = null;
    private int topPrice;

    public Bag(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    private  int totalWeight(List<Stuff> stuffs) {
        int result = 0;
        for (Stuff stuff : stuffs) {
            result += stuff.getWeight();
        }
        return result;
    }

    private int totalPrice(List<Stuff> stuffs) {
        int result = 0;
        for (Stuff stuff : stuffs) {
            result += stuff.getPrice();
        }
        return result;
    }

    private void variations(List<Stuff> stuffs) {
        if (totalWeight(stuffs) <= weightLimit && totalPrice(stuffs) > topPrice) {
            topPricedBag = stuffs;
            topPrice = totalPrice(stuffs);
        }
    }

    public void findTopPricedBag(List<Stuff> stuffs) {
        if (stuffs.size() > 0) {
            variations(stuffs);
        }

        for (int i = 0; i < stuffs.size(); i++) {
            List<Stuff> temp = new ArrayList<>(stuffs);
            temp.remove(i);
            findTopPricedBag(temp);
        }
    }

    public List<Stuff> getTopPricedBag() {
        return topPricedBag;
    }

    public int getTopPrice() {
        return topPrice;
    }
}
