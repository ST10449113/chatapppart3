package com.mycompany.chatapppart3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        // =====================
        // REGISTER
        // =====================

        System.out.println("===== REGISTER =====");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = input.nextLine();

        String registerResult =
                login.registerUser(
                        username,
                        password,
                        phoneNumber);

        System.out.println(registerResult);
        
   
        // =====================
        // LOGIN
        // =====================

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter username: ");
        String loginUsername =
                input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword =
                input.nextLine();

        boolean loginSuccess =
                login.loginUser(
                        loginUsername,
                        loginPassword);

        System.out.println(
                login.returnLoginStatus(
                        loginSuccess));

        // =====================
        // LOGIN SUCCESS
        // =====================

        if(loginSuccess) {

            System.out.println(
                    "\nWelcome to QuickChat.");

            System.out.print(
                    "How many messages would you like to send? ");

            int numMessages =
                    input.nextInt();

            input.nextLine();

            for(int i = 0;
                i < numMessages;
                i++) {

                boolean running = true;

                while(running) {

                    System.out.println(
                            "\n===== MENU =====");

                    System.out.println(
                            "1. Send Messages");

                    System.out.println(
                            "2. Show recently sent messages");

                    System.out.println(
                            "3. Quit");

                    System.out.println(
                            "4. Stored Messages");

                    System.out.print(
                            "Choose option: ");

                    int option =
                            input.nextInt();

                    input.nextLine();

                    switch(option) {

                        // =====================
                        // SEND MESSAGE
                        // =====================

                        case 1:

                            System.out.print(
                                    "Enter recipient: ");

                            String recipient =
                                    input.nextLine();

                            System.out.print(
                                    "Enter message: ");

                            String message =
                                    input.nextLine();

                            Message msg =
                                    new Message(
                                            i,
                                            recipient,
                                            message);

                            System.out.println(
                                    msg.checkRecipientCell());

                            System.out.println(
                                    msg.checkMessageLength());

                            System.out.println(
                                    "\n1. Send Message");

                            System.out.println(
                                    "2. Disregard Message");

                            System.out.println(
                                    "3. Store Message");

                            int sendChoice =
                                    input.nextInt();

                            input.nextLine();

                            System.out.println(
                                    msg.sentMessage(
                                            sendChoice));

                            System.out.println(
                                    "\n"
                                    + msg.printMessages());

                            break;

                        // =====================
                        // COMING SOON
                        // =====================

                        case 2:

                            System.out.println(
                                    "Coming Soon.");

                            break;

                        // =====================
                        // QUIT
                        // =====================

                        case 3:

                            System.out.println(
                                    "\nTotal Messages Sent: "
                                    + Message.returnTotalMessages());

                            System.exit(0);

                            break;

                        // =====================
                        // PART 3
                        // =====================

                        case 4:

                            System.out.println(
                                    "\na. Display longest stored message");

                            System.out.println(
                                    "b. Search message by ID");

                            System.out.println(
                                    "c. Search messages by recipient");

                            System.out.println(
                                    "d. Delete message using hash");

                            System.out.println(
                                    "e. Display report");

                            System.out.print(
                                    "Choose option: ");

                            char choice =
                                    input.next()
                                            .charAt(0);

                            input.nextLine();

                            switch(choice) {

                                case 'a':

                                    System.out.println(
                                            Message.getLongestStoredMessage());

                                    break;

                                case 'b':

                                    System.out.print(
                                            "Enter Message ID: ");

                                    String id =
                                            input.nextLine();

                                    System.out.println(
                                            Message.searchMessageID(id));

                                    break;

                                case 'c':

                                    System.out.print(
                                            "Enter Recipient Number: ");

                                    String searchRecipient =
                                            input.nextLine();

                                    Message.searchRecipient(
                                            searchRecipient);

                                    break;

                                case 'd':

                                    System.out.print(
                                            "Enter Message Hash: ");

                                    String hash =
                                            input.nextLine();

                                    System.out.println(
                                            Message.deleteMessageHash(hash));

                                    break;

                                case 'e':

                                    Message.displayReport();

                                    break;

                                default:

                                    System.out.println(
                                            "Invalid option.");
                            }

                            break;

                        default:

                            System.out.println(
                                    "Invalid menu option.");
                    }

                    running = false;
                }
            }

            System.out.println(
                    "\nTotal Messages Sent: "
                    + Message.returnTotalMessages());
        }
    }
}    

        