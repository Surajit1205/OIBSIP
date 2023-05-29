import java.util.ArrayList;
import java.util.Scanner;
class Online_Reservation_System_demo{
    public static ArrayList<String> pas = new ArrayList<String>();
    static Scanner scanner = new Scanner(System.in);
    //pas.add(3,null);
    //Login
     static int Login(String inputUsername,String inputPassword) {
        int i=0;
        String username = "surajit1205";
        String password = "abc_123";
                if (inputUsername.equals(username) && inputPassword.equals(password)) {
                    //pas.add(3,null);
                    i = 1;
                }
        return i;
    }
    //Reservation
    static void ReservationSystem() {
        // Prompt user to enter their details
        System.out.print("Enter your Train Number: ");
        String  trainNumber= scanner.nextLine();
        //pas.set(0,null);
        pas.add(trainNumber);
        System.out.print("Enter Your Name: ");
        String name = scanner.nextLine();
        //scanner.nextLine();
        pas.add(name);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        String age1=String.valueOf(age); //int to String.
        pas.add(age1);
        scanner.nextLine();
        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();
        pas.add(contactNumber);
        //scanner.nextLine();
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        pas.add(classType);
        System.out.print("Enter date of journey (dd/mm/yyyy): ");
        String dateOfJourney = scanner.nextLine();
        pas.add(dateOfJourney);
        System.out.print("Enter departure station: ");
        String departureStation = scanner.nextLine();
        pas.add(departureStation);
        System.out.print("Enter destination station: ");
        String destinationStation = scanner.nextLine();
        pas.add(destinationStation);
                                                    // Display reservation details
        System.out.println("Reservation Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("Departure Station: " + departureStation);
        System.out.println("Destination Station: " + destinationStation);
        System.out.println("Hello "+name+"\nYour Reservation of Train no. "+trainNumber+" from "+departureStation+" to "+destinationStation+" is Confirmed!");
    }
    static void  CancellationForm() {
        // Prompt user to enter their PNR number

        System.out.print("Enter your PNR number: ");
        String pnrNumber = scanner.nextLine();
        //pas.set(0,null);
        // Retrieve reservation details based on PNR number

        ArrayList<String> reservationDetails = retrieveReservationDetails(pnrNumber);

        // If reservation details are found, display them and prompt user to confirm cancellation
        if (reservationDetails != null) {
            System.out.println("Reservation Details:");
            System.out.println("TRAIN Number: " + reservationDetails.get(0));
            System.out.println("Name: " + reservationDetails.get(1));
            System.out.println("Age: " + reservationDetails.get(2));
            System.out.println("Contact Number: " + reservationDetails.get(3));
            System.out.println("Class Type: " + reservationDetails.get(4));
            System.out.println("Date of Journey: " + reservationDetails.get(5));
            System.out.println("Departure Station: " + reservationDetails.get(6));
            System.out.println("Destination Station: " + reservationDetails.get(7));

            System.out.print("Are you sure you want to cancel this reservation? (Y/N): ");
            String confirmation = scanner.nextLine();

            // If user confirms cancellation, display cancellation message
            if (confirmation.equalsIgnoreCase("Y")) {
                System.out.println("Reservation cancelled successfully. of train no. "+reservationDetails.get(0));
                reservationDetails.set(0,null);
            } else {
                System.out.println("Cancellation cancelled.");
            }

        }
        else
        {
            System.out.println("No reservation found with the given PNR number.");
        }
    }

        // This method retrieves reservation details from a database based on the given PNR number
        private static ArrayList<String> retrieveReservationDetails(String pnrNumber) {
            // Code to retrieve reservation details from database goes here
            // For the purpose of this example, we are returning hardcoded values
            ArrayList<String> reservationDetails = new ArrayList<>();
            reservationDetails=pas;
            if (pnrNumber.equals(reservationDetails.get(0))) {
                return reservationDetails;
            }
            else {
                return null;
            }
        }

        }
class Online_Reservation_System{
    public static void main(String[] args) {
        int logStatus;
        Scanner scanner = new Scanner(System.in);
        System.out.println("****WELCOME TO ONLINE RESERVATION SYSTEM****");
        System.out.print("Enter your username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String inputPassword = scanner.nextLine();
        logStatus=Online_Reservation_System_demo.Login(inputUsername,inputPassword);
        if(logStatus==1) {
            System.out.println("Login Successful! Welcome " + inputUsername);
            while(true) {
                System.out.println("1. Ticket Booking.\n2. Cancel a Ticket.");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        Online_Reservation_System_demo.ReservationSystem();
                        break;
                    case 2:
                        //System.out.println("Cancel Done.");
                        try {
                            Online_Reservation_System_demo.CancellationForm();
                        }
                        catch (Exception e){
                            System.out.println("Plese Book a ticket First.");
                        }
                        break;
                    default:
                        System.out.println("INVALID OPTION. TRY AGAIN....");
                }
            }

        }
        else{
            System.out.println("Invalid username or password");
        }
    }
}

