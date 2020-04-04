package ua.lviv;

import java.util.Set;

public class Cart {

    private int id;
    private int total;
    private String name;
    private Set<Item> items;

    public Cart() {
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Cart(int total, String name) {
        this.total = total;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", total=" + total +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
