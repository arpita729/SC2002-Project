package items;

public abstract class Item {
    private int id;
    private boolean deleted = false;

    public int getId() { return id; };
    public boolean getDeleted() { return deleted; };

    public abstract String toString();
    public void delete() { deleted=false; };
    public void setId(int id) { this.id=id; };
}