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

    public int getWeightLimit() {
        return weightLimit;
    }

    public List<Stuff> getTopPricedBag() {
        return topPricedBag;
    }

    public int getTopPrice() {
        return topPrice;
    }

    private int totalPrice(List<Stuff> stuff){
        int result = 0;
        for (Stuff o : stuff) {
            result += o.getWeight();
        }
        return result;
    }

    private int totalWeight(List<Stuff> stuff){
        int result = 0;
        for (Stuff o : stuff) {
            result += o.getPrise();
        }
        return result;
    }

    public void variations (List<Stuff> stuff){
        if(topPricedBag == null){
            if(totalWeight(stuff) <= weightLimit){
                topPricedBag = stuff;
                topPrice = totalPrice(topPricedBag);
            }
        }
        else {
            if((totalWeight(stuff) <= weightLimit) && (totalPrice(stuff) > topPrice)){
                topPricedBag = stuff;
                topPrice = totalPrice(topPricedBag);
            }
        }
    }

    public void findTopPriseVariation(List<Stuff> stuff){
        if(stuff.size() > 0){
            variations(stuff);
        }

        for(int i = 0; i < stuff.size(); i++){
            List<Stuff> temp = new ArrayList<>(stuff);
            temp.remove(i);
            findTopPriseVariation(temp);
        }
    }
}
