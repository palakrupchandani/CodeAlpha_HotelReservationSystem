
import java.util.Scanner;

public class HotelReservationSystem {

    static Scanner sc = new Scanner(System.in);

    static int[] roomNumbers = {101, 102, 103, 104, 105};
    static String[] customerNames = new String[5];
    static int[] days = new int[5];
    static double roomPrice = 1500;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Booking Details");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    viewBookingDetails();
                    break;

                case 4:
                    cancelBooking();
                    break;

                case 5:
                    System.out.println("Thank you for using our system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    static void viewAvailableRooms() {

        System.out.println("\nAvailable Rooms:");

        boolean available = false;

        for (int i = 0; i < roomNumbers.length; i++) {

            if (customerNames[i] == null) {
                System.out.println("Room " + roomNumbers[i]);
                available = true;
            }
        }

        if (!available) {
            System.out.println("No rooms are currently available.");
        }
    }

    static void bookRoom() {

        viewAvailableRooms();

        System.out.print("\nEnter room number to book: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();

        int index = -1;

        for (int i = 0; i < roomNumbers.length; i++) {

            if (roomNumbers[i] == roomNumber) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Invalid room number.");
            return;
        }

        if (customerNames[index] != null) {
            System.out.println("Room is already booked.");
            return;
        }

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of days: ");
        int numberOfDays = sc.nextInt();

        if (numberOfDays <= 0) {
            System.out.println("Number of days must be greater than zero.");
            return;
        }

        customerNames[index] = name;
        days[index] = numberOfDays;

        double totalAmount = roomPrice * numberOfDays;

        System.out.println("\nRoom booked successfully!");
        System.out.println("Room Number: " + roomNumbers[index]);
        System.out.println("Customer Name: " + customerNames[index]);
        System.out.println("Number of Days: " + days[index]);
        System.out.println("Total Amount: Rs. " + totalAmount);
    }

    static void viewBookingDetails() {

        System.out.println("\n BOOKING DETAILS");

        boolean bookingFound = false;

        for (int i = 0; i < roomNumbers.length; i++) {

            if (customerNames[i] != null) {

                System.out.println("Room Number: " + roomNumbers[i]);
                System.out.println("Customer Name: " + customerNames[i]);
                System.out.println("Number of Days: " + days[i]);
                System.out.println("Total Amount: Rs. " + (roomPrice * days[i]));
                System.out.println("--");

                bookingFound = true;
            }
        }

        if (!bookingFound) {
            System.out.println("No bookings found.");
        }
    }

    static void cancelBooking() {

        System.out.print("\nEnter room number to cancel: ");
        int roomNumber = sc.nextInt();

        int index = -1;

        for (int i = 0; i < roomNumbers.length; i++) {

            if (roomNumbers[i] == roomNumber) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Invalid room number.");
            return;
        }

        if (customerNames[index] == null) {
            System.out.println("This room is not booked.");
            return;
        }

        customerNames[index] = null;
        days[index] = 0;

        System.out.println("Booking cancelled successfully.");
    }
}