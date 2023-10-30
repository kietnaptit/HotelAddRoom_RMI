# Hotel reservation management application - Add Room Function 

# Requirement
* Client Side: A GUI uses Java Swing that have Room ID, Room Name, Room Type (Normal, VIP), Room price, A Table to Display Search Result
* Server Side: Connect with MySQL JDBC to add information to Database. Before add new room to database, server must check is room exisited or not (Two Room must not have same ID or Room Name)
* Client and Server connect through RMI

# Room Model

```
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
```

# Method need to be implemented
* `public Boolean addRoom(Room room)`
* `public Boolean isRoomExisited(Room room)`
* `public List<Room> listRoom()`
* `public List<Room> searchRoom(String keyword)`

# Main Function
* Add a New Room
* Search Room

# DEMO Image
* Client Slide GUI

![](https://i.imgur.com/MH9bw7p.png)

# Tools
* Java IDE (Netbeans, Eclipse)
* MySQL Server & MySQL Workbench
* JDBC Driver (In /lib Folder) (mysql-connector-j-8.1.0.jar)

# CREATE TABLE Command
```
CREATE TABLE room(
	id int PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    price int

)
```

# Another Version
* [TCP Version](https://github.com/kietnaptit/HotelAddRoom_TCPIP) - But no Search & List function
* [UDP Version](https://github.com/kietnaptit/HotelAddRoom_UDP)