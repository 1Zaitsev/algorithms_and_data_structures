package lesson8.classwork;

import java.util.Objects;

public class ItemDefinition {

    private final String title;
    private final int id;

    public ItemDefinition(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDefinition that = (ItemDefinition) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
