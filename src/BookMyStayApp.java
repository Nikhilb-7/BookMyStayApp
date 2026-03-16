import java.util.*;
/**
 * MAIN CLASS UseCase7AddOnServiceSelection
 * Use Case 7: Add-On Service Selection
 * @version 7.1
 */
class AddOnService {
    private String serviceName;
    private double cost;
    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }
    public double getCost() {
        return cost;
    }
}
class AddOnServiceManager {
    private Map<String, List<AddOnService>> reservationServices;
    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }
    public void addService(String reservationId, AddOnService service) {
        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }
    public double calculateTotalCost(String reservationId) {
        List<AddOnService> services = reservationServices.get(reservationId);
        double total = 0;
        if (services != null) {
            for (AddOnService s : services) {
                total += s.getCost();
            }
        }
        return total;
    }
}
public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection");
        String reservationId = "Single-1";
        AddOnServiceManager manager = new AddOnServiceManager();
        manager.addService(reservationId, new AddOnService("Breakfast", 500));
        manager.addService(reservationId, new AddOnService("Spa", 1000));
        double totalCost = manager.calculateTotalCost(reservationId);
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}