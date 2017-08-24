package info.upump.mywardrobe2.model;

/**
 * Created by Сергей on 17.08.2017.
 */

public class ItemMainMenu {
    private int id;
    private String Name;

    public ItemMainMenu(int id, String name) {
        this.id = id;
        Name = name;
    }

    public ItemMainMenu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemMainMenu that = (ItemMainMenu) o;

        if (id != that.id) return false;
        return Name != null ? Name.equals(that.Name) : that.Name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        return result;
    }
}
