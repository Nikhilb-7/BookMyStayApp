import java.util.HashMap;
import java.util.Map;
/**
 * MAIN CLASS BookMyStayApp
 * Use Case 3: Centralized Room Inventory Management
 * @version 3.1
 */
abstract class Room {
    private int beds;
    private int size;
    private double price;
    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }
    public int getBeds() {
        return beds;
    }
    public int getSize() {
        return size;
    }
    public double getPrice() {
        return price;
    }
    public abstract String getRoomType();
    public void displayRoomDetails() {
        System.out.println("\n" + getRoomType());
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500);
    }
    public String getRoomType() {
        return "Single Room:";
    }
}
class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500);
    }
    public String getRoomType() {
        return "Double Room:";
    }
}
class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000);
    }
    public String getRoomType() {
        return "Suite Room:";
    }
}
class RoomInventory {
    private HashMap<String, Integer> inventory;
    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room:", 5);
        inventory.put("Double Room:", 3);
        inventory.put("Suite Room:", 2);
    }
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
    public void displayInventory() {
        System.out.println("\nCurrent Inventory Status:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Available Rooms: " + entry.getValue());
        }
    }
}
public class BookMyStayApp {
    public static void main(String[] args) {
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();
        RoomInventory inventory = new RoomInventory();
        System.out.println("Hotel Room Inventory Status");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getAvailability(single.getRoomType()));
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getAvailability(doubleRoom.getRoomType()));
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getAvailability(suite.getRoomType()));
    }
}