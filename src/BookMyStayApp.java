import java.util.HashMap;
/**
 * MAIN CLASS UseCase4RoomSearch
 * Use Case 4: Room Search & Availability Check
 * @version 4.1
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
        return "Single Room";
    }
}
class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500);
    }
    public String getRoomType() {
        return "Double Room";
    }
}
class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000);
    }
    public String getRoomType() {
        return "Suite Room";
    }
}
class RoomInventory {
    private HashMap<String, Integer> inventory;
    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}
class RoomSearchService {
    public void searchAvailableRooms(Room[] rooms, RoomInventory inventory) {
        for (Room room : rooms) {
            int availability = inventory.getAvailability(room.getRoomType());
            if (availability > 0) {
                room.displayRoomDetails();
                System.out.println("Available Rooms: " + availability);
            }
        }
    }
}
public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Room Search ");
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();
        Room[] rooms = {single, doubleRoom, suite};
        RoomInventory inventory = new RoomInventory();
        RoomSearchService search = new RoomSearchService();
        search.searchAvailableRooms(rooms, inventory);
    }
}