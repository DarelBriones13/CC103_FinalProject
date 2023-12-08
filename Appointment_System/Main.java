import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Method method = new Method();
        boolean running = true;

        while (running) {
            System.out.println("------------------------------");
            System.out.println("----- APPOINTMENT SYSTEM -----");
            System.out.println("------------------------------");
            System.out.println("[1] - MAKE APPOINTMENT");
            System.out.println("[2] - VIEW APPOINTMENT");
            System.out.println("[3] - SEARCH APPOINTMENT");
            System.out.println("[4] - UPDATE APPOINTMENT");
            System.out.println("[5] - CANCEL APPOINTMENT");
            System.out.println("[6] - EXIT!");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            if (!input.matches("\\d+")) {
                System.out.println("Please enter a number.");
                System.out.println("-----------------------------------");
                continue;
            }

            int choice = Integer.parseInt(input);

            if (choice < 1 || choice > 6) {
                System.out.println("Please select a number between 1-6.");
                System.out.println("-----------------------------------");
                continue;
            }

            switch (choice) {
                case 1:
                    method.makeAppointment();
                    break;
                case 2:
                    method.viewAppointment();
                    break;
                case 3:
                    method.searchAppointment();
                    break;
                case 4:
                    method.updateAppointment();
                    break;
                case 5:
                    method.cancelAppointment();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using!");
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1-6.");
                    break;
            }
        }
        scanner.close();
    }
}
