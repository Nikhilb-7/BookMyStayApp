import java.util.*;
/**
 * MAIN CLASS UseCase9ErrorHandlingValidation
 * Use Case 9: Error Handling & Validation
 * @version 9.1
 */
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}
class BookingValidator {
    private static final Set<String> VALID_ROOMS =
            new HashSet<>(Arrays.asList("Single", "Double", "Suite"));
    public static void validateRoomType(String roomType) throws InvalidBookingException {
        if (!VALID_ROOMS.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}
public class BookMyStayApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Booking Validation");
            System.out.print("Enter guest name: ");
            String guestName = sc.nextLine();
            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = sc.nextLine();
            BookingValidator.validateRoomType(roomType);
            System.out.println("Booking confirmed for " + guestName + " with room type " + roomType);
        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
        sc.close();
    }
}