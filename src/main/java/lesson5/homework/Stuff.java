package lesson5.homework;

public class Stuff {

    private String name;
    private int weight;
    private int price;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public Stuff(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Stuff stuff = (Stuff) obj;

        if (weight != stuff.weight) return false;
        if (price != stuff.price) return false;
        return name != null ? name.equals(stuff.name) : stuff.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + weight;
        result = 31 * result + price;
        return result;
    }
}
