package rmiserver.model;

import java.io.Serializable;

public class Room implements Serializable{
    final long serialVersionUID = 23L;
    int id;
    String name;
    String type;
    int price;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Room(int id, String name, String type, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + '}';
    }
    
    
    
}
