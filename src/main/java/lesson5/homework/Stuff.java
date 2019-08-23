package lesson5.homework;

public class Stuff {

    private int prise;
    private int weight;

    private String name;

    public Stuff(String name,int weight, int prise) {
        this.name = name;
        this.weight = weight;
        this.prise = prise;
    }

    public int getPrise() {
        return prise;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
