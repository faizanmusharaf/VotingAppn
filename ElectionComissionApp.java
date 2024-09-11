package VotingAppn;
import java.util.Scanner;


class ElectionCommissionApp {

        private static VoterManager voterManager = new VoterManager();

        public static void main(String[] args) {

            VoterIdApp[] voters;

            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("1. Login as Admin");
                System.out.println("2. Login as User");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter admin username: ");
                        String adminUsername = scanner.nextLine();
                        System.out.println("Enter admin password: ");
                        String adminPassword = scanner.nextLine();

                        if (adminUsername.equals("admin") && adminPassword.equals("password")) {
                            System.out.println("Admin authenticated successfully");
                            boolean adminLoggedIn = true;
                            while (adminLoggedIn) {
                                System.out.println("1. Add a New Voter");
                                System.out.println("2. Display Demographic change request");
                                System.out.println("3. Approve/Deny Demographic request");
                                System.out.println("4. View Voter List");
                                System.out.println("5. Logout");
                                int adminSelection = scanner.nextInt();
                                scanner.nextLine();

                                switch (adminSelection) {
                                    case 1:
                                            System.out.print("Enter voter EPIC number: ");
                                            String epicNo = scanner.nextLine();
                                            System.out.print("Enter voter Name: ");
                                            String name = scanner.nextLine();
                                            System.out.print("Enter voter Age: ");
                                            int age = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Enter voter Gender: ");
                                            String gender = scanner.nextLine();
                                            if (age > 18 && age < 100) {
                                                voterManager.addVoter(epicNo, name, age, gender);
                                            } else {
                                                System.out.println("Age must be greater than 18 and less than 100");
                                            }
                                        break;
                                    case 2:
                                        voterManager.viewDemographicChangeRequests();
                                        break;
                                    case 3:
                                        System.out.print("Enter the request number to process: ");
                                        int requestNumber = scanner.nextInt() - 1;
                                        System.out.print("Approve request? (yes/no): ");
                                        String decision = scanner.next();
                                        boolean approve = decision.equalsIgnoreCase("yes");
                                        voterManager.approveOrDenyRequests(requestNumber, approve);
                                        break;
                                    case 4:
                                        voterManager.displayVoters();
                                        break;
                                    case 5:
                                        adminLoggedIn = false;
                                        System.out.println("Admin logged out.");
                                        break;
                                    default:
                                        System.out.println("Invalid selection. Try again.");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Invalid admin credentials.");
                        }
                        break;

                    case 2:
                        System.out.println("Enter your EPIC No:");
                        String userEpicNo = scanner.nextLine();

                        voters = voterManager.getVoters();
                        if (VoterManager.isVoterPresent(userEpicNo, voters, voterManager.getVoterCount())) {
                            System.out.println("User Authenticated");

                            boolean userLoggedIn = true;
                            while(userLoggedIn){
                                System.out.println("1. Do you want to Change your name");
                                System.out.println("2. Check status of your Request");
                                System.out.println("3. Logout");

                                int userSelection = scanner.nextInt();
                                scanner.nextLine();

                                switch (userSelection){

                                    case 1:
                                        System.out.println("Enter your new name: ");
                                        String newName = scanner.nextLine();
                                        voterManager.submitDemographicChangeRequest(userEpicNo, newName);
                                        break;

                                    case 2:
                                        voterManager.checkRequestStatus(userEpicNo);
                                        break;

                                    case 3:
                                        userLoggedIn = false;
                                        System.out.println("You are logged out");
                                        break;

                                    default:
                                        System.out.println("Invalid Choice.");
                                        break;
                                }
                            }

                        } else {
                            System.out.println("User not found");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please select 1 for Admin, 2 for User.");
                }

                System.out.println();
            } while (true);

        }

    }
