import java.util.*;
/**
 * MAIN CLASS UseCase6RoomAllocationService
 * Use Case 6: Reservation Confirmation & Room Allocation
 * @version 6.1
 */
class Reservation {
    private String guestName;
    private String roomType;
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
    public String getGuestName() {
        return guestName;
    }
    public String getRoomType() {
        return roomType;
    }
}
class RoomInventory {
    private HashMap<String, Integer> inventory;
    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);
    }
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
    public void reduceAvailability(String roomType) {
        inventory.put(roomType, inventory.get(roomType) - 1);
    }
}
class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private HashMap<String, Set<String>> roomAllocations;
    private HashMap<String, Integer> roomCounters;
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        roomAllocations = new HashMap<>();
        roomCounters = new HashMap<>();
    }
    public String generateRoomId(String roomType) {
        int count = roomCounters.getOrDefault(roomType, 0) + 1;
        roomCounters.put(roomType, count);
        String roomId = roomType + "-" + count;
        allocatedRoomIds.add(roomId);
        return roomId;
    }
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        if (inventory.getAvailability(type) > 0) {
            String roomId = generateRoomId(type);
            roomAllocations
                    .computeIfAbsent(type, k -> new HashSet<>())
                    .add(roomId);
            inventory.reduceAvailability(type);
            System.out.println(
                    "Booking confirmed for Guest: "
                            + reservation.getGuestName()
                            + ", Room ID: "
                            + roomId
            );
        } else {
            System.out.println(
                    "No rooms available for Guest: "
                            + reservation.getGuestName()
                            + ", Room Type: "
                            + type
            );
        }
    }
}
public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing\n");
        Queue<Reservation> bookingQueue = new LinkedList<>();
        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Single"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();
        while (!bookingQueue.isEmpty()) {
            Reservation request = bookingQueue.poll();
            allocationService.allocateRoom(request, inventory);
        }
    }
}