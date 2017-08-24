package info.upump.mywardrobe2.model;

/**
 * Created by Сергей on 22.08.2017.
 */

public class ItemPrev {
    private int id;
    private String name;

    public ItemPrev(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemPrev() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
