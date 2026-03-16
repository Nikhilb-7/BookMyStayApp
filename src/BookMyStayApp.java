import java.util.*;
/**
 * MAIN CLASS UseCase8BookingHistoryReport
 * Use Case 8: Booking History & Reporting
 * @version 8.1
 */
class Reservation {
    private String guestName;
    private String roomType;
    private String reservationId;

    public Reservation(String guestName, String roomType, String reservationId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.reservationId = reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getReservationId() {
        return reservationId;
    }
}
class BookingHistory {
    private List<Reservation> history;
    public BookingHistory() {
        history = new ArrayList<>();
    }
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }
    public List<Reservation> getHistory() {
        return history;
    }
}
class BookingReportService {
    public void generateReport(List<Reservation> reservations) {
        System.out.println("Booking History and Reporting\n");
        System.out.println("Booking History Report");
        for (Reservation r : reservations) {
            System.out.println(
                             "Guest: " + r.getGuestName()
                            + ", Room Type: " + r.getRoomType()
            );
        }
    }
}
public class BookMyStayApp {
    public static void main(String[] args) {
        BookingHistory history = new BookingHistory();
        history.addReservation(new Reservation("Abhi", "Single", "Single-1"));
        history.addReservation(new Reservation("Subha", "Double", "Double-1"));
        history.addReservation(new Reservation("Vanmathi", "Suite", "Suite-1"));
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history.getHistory());
    }
}