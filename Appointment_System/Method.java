import java.util.*;

public class Method {
    private HashSet<Appointment> appointmentList = new HashSet<>();

    public void makeAppointment() {
        Scanner scanner = new Scanner(System.in);
        boolean makingAppointment = true;

        while (makingAppointment) {
            try {
                System.out.println("----------------------------");
                System.out.println("----- MAKE APPOINTMENT -----");
                System.out.println("----------------------------");
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Date: ");
                String date = scanner.nextLine();

                System.out.print("Enter Reason: ");
                String reason = scanner.nextLine();

                System.out.println("Do you want to make this appointment? (yes/no)");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    appointmentList.add(new Appointment(name, date, reason));
                    System.out.println("------------------------------");
                    System.out.println("APPOINTMENT MADE SUCCESSFULLY!");
                    System.out.println("------------------------------");
                }

                System.out.println("Do you want to make another appointment? (yes/no)");
                String again = scanner.nextLine();

                if (!again.equalsIgnoreCase("yes")) {
                    makingAppointment = false;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void viewAppointment() {
        ArrayList<Appointment> sortedList = new ArrayList<>(appointmentList);
        Collections.sort(sortedList, Comparator.comparing(Appointment::getDate));

        int appointmentCount = sortedList.size();
        
        System.out.println("-------------------------");
        System.out.println("----- APPOINTMENTS ------");
        System.out.println("-------------------------");
        System.out.println("Total Appointments: " + appointmentCount);
        System.out.println("-------------------------");
        for (Appointment appointment : sortedList) {
            System.out.println("Name: " + appointment.getName());
            System.out.println("Date: " + appointment.getDate());
            System.out.println("Reason: " + appointment.getReason());
            System.out.println("-------------------------");
        }
        
    }

    public void searchAppointment() {
        System.out.println("------------------------------");
        System.out.println("----- SEARCH APPOINTMENT -----");
        System.out.println("------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name to search for appointment: ");
        String searchName = scanner.nextLine();

        for (Appointment appointment : appointmentList) {
            if (appointment.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Appointment found:");
                System.out.println("Name: " + appointment.getName());
                System.out.println("Date: " + appointment.getDate());
                System.out.println("Reason: " + appointment.getReason());
                return;
            }
        }
        System.out.println("Appointment not found for " + searchName + "!");
    }

    public void updateAppointment() {
    System.out.println("------------------------------");
    System.out.println("----- UPDATE APPOINTMENT -----");
    System.out.println("------------------------------");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Name of the appointment to update: ");
    String updateName = scanner.nextLine();
    boolean appointmentFound = false;

    outerLoop:
    for (Appointment appointment : appointmentList) {
        if (appointment.getName().equalsIgnoreCase(updateName)) {
            appointmentFound = true;
            while (true) {
                System.out.println("What do you want to update?");
                System.out.println("1. Name");
                System.out.println("2. Date");
                System.out.println("3. Reason");
                System.out.println("4. Cancel Update");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter new Name: ");
                        String newName = scanner.nextLine();

                        System.out.println("Are you sure you want to update the name to '" + newName + "'? (yes/no)");
                        String confirmNameUpdate = scanner.nextLine();
                        if (confirmNameUpdate.equalsIgnoreCase("yes")) {
                            appointment.setName(newName);
                            System.out.println("--------------------------------------");
                            System.out.println("APPOINTMENT NAME UPDATED SUCCESSFULLY!");
                            System.out.println("--------------------------------------");
                        } else {
                            System.out.println("----------------------");
                            System.out.println("NAME UPDATED CANCELED!");
                            System.out.println("----------------------");
                        }
                        break;
                    case 2:
                        System.out.print("Enter new Date: ");
                        String newDate = scanner.nextLine();

                        System.out.println("Are you sure you want to update the date to '" + newDate + "'? (yes/no)");
                        String confirmDateUpdate = scanner.nextLine();
                        if (confirmDateUpdate.equalsIgnoreCase("yes")) {
                            appointment.setDate(newDate);
                            System.out.println("--------------------------------------");
                            System.out.println("APPOINTMENT DATE UPDATED SUCCESSFULLY!");
                            System.out.println("--------------------------------------");
                        } else {
                            System.out.println("----------------------");
                            System.out.println("DATE UPDATED CANCELED!");
                            System.out.println("----------------------");
                        }
                        break;
                    case 3:
                        System.out.print("Enter new Reason: ");
                        String newReason = scanner.nextLine();

                        System.out.println("Are you sure you want to update the reason to '" + newReason + "'? (yes/no)");
                        String confirmReasonUpdate = scanner.nextLine();
                        if (confirmReasonUpdate.equalsIgnoreCase("yes")) {
                            appointment.setReason(newReason);
                            System.out.println("----------------------------------------");
                            System.out.println("APPOINTMENT REASON UPDATED SUCCESSFULLY!");
                            System.out.println("----------------------------------------");
                        } else {
                            System.out.println("------------------------");
                            System.out.println("REASON UPDATED CANCELED!");
                            System.out.println("------------------------");
                        }
                        break;
                    case 4:
                        System.out.println("-------------------");
                        System.out.println("UPDATE CANCELED!");
                        System.out.println("-------------------");
                        break outerLoop; 
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

                System.out.println("Do you want to update another detail? (yes/no)");
                String updateAnotherDetail = scanner.nextLine();
                if (!updateAnotherDetail.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }
    }
    if (!appointmentFound) {
        System.out.println("Appointment not found for " + updateName + "!");
    }
}

    public void cancelAppointment() {
        System.out.println("------------------------------");
        System.out.println("----- CANCEL APPOINTMENT -----");
        System.out.println("------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name of the appointment to cancel: ");
        String cancelName = scanner.nextLine();

        Appointment foundAppointment = null;

        for (Appointment appointment : appointmentList) {
            if (appointment.getName().equalsIgnoreCase(cancelName)) {
                foundAppointment = appointment;
                break;
            }
        }

        if (foundAppointment != null) {
            appointmentList.remove(foundAppointment);
            System.out.println("Appointment for " + cancelName + " has been canceled.");
        } else {
            System.out.println("Appointment not found for " + cancelName);
        }
    }
}

class Appointment {
    private String name;
    private String date;
    private String reason;

    public Appointment(String name, String date, String reason) {
        this.name = name;
        this.date = date;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
