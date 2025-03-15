package Items;

public abstract class Item {
    private int id;
    private String name;
    private boolean deleted;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        this.deleted = false;
    }

    public int getId() { return id; };
    public String getName() { return name; };
    public boolean getDeleted() { return deleted; };

    public abstract String toString();
    public void delete() { deleted=false; };
}