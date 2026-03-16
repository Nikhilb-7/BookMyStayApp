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
public class BookMyStayApp {
    public static void main(String[] args) {
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();
        System.out.println("Hotel Room Initialization ");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailability);
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailability);
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailability);
    }
}