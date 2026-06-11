/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart3;

/**
 *
 * @author Student
 */

import java.util.ArrayList;
import java.util.Random;

public final class Message {

    private final String messageID;
    private final int messageNumber;
    private final String recipient;
    private final String message;

    private static int totalMessages = 0;

    // Arrays / ArrayLists required for Part 3
    private static final ArrayList<String> sentMessages = new ArrayList<>();
    private static final ArrayList<String> disregardedMessages = new ArrayList<>();
    private static final ArrayList<String> storedMessages = new ArrayList<>();
    private static final ArrayList<String> messageHashes = new ArrayList<>();
    private static final ArrayList<String> messageIDs = new ArrayList<>();
    private static final ArrayList<String> recipients = new ArrayList<>();

    // Constructor
    public Message(int messageNumber,
                   String recipient,
                   String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        this.messageID = generateMessageID();
    }

    // Generate Message ID
    public String generateMessageID() {

        Random random = new Random();

        long number =
                1000000000L +
                (long)(random.nextDouble()
                * 9000000000L);

        return String.valueOf(number);
    }

    // Check Message ID
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Check Recipient Number
    public String checkRecipientCell() {

        if(recipient.startsWith("+27")
                && recipient.length() <= 12) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
    }

    // Check Message Length
    public String checkMessageLength() {

        if(message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int extra =
                    message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extra
                    + ", please reduce the size.";
        }
    }

    // Create Message Hash
    public String createMessageHash() {

        String[] words =
                message.split(" ");

        String firstWord =
                words[0];

        String lastWord =
                words[words.length - 1];

        return messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord.toUpperCase()
                + lastWord.toUpperCase();
    }

    // Send / Store / Disregard
    public String sentMessage(int option) {

        switch(option) {

            case 1:

                totalMessages++;

                sentMessages.add(message);
                recipients.add(recipient);
                messageHashes.add(createMessageHash());
                messageIDs.add(messageID);

                return "Message successfully sent.";

            case 2:

                disregardedMessages.add(message);

                return "Press 0 to delete the message.";

            case 3:

                storedMessages.add(message);
                recipients.add(recipient);
                messageHashes.add(createMessageHash());
                messageIDs.add(messageID);

                return "Message successfully stored.";

            default:

                return "Invalid option.";
        }
    }

    // Print Current Message
    public String printMessages() {

        return "Message ID: "
                + messageID
                + "\nMessage Hash: "
                + createMessageHash()
                + "\nRecipient: "
                + recipient
                + "\nMessage: "
                + message;
    }

    // Longest Stored Message
    public static String getLongestStoredMessage() {

        String longest = "";

        for(String msg : storedMessages) {

            if(msg.length() > longest.length()) {

                longest = msg;
            }
        }

        return longest;
    }

    // Search Message ID
    public static String searchMessageID(String id) {

        for(int i = 0;
            i < messageIDs.size();
            i++) {

            if(messageIDs.get(i)
                    .equals(id)) {

                return storedMessages.get(i);
            }
        }

        return "Message not found.";
    }

    // Search Recipient
    public static void searchRecipient(
            String recipientNumber) {

        boolean found = false;

        for(int i = 0;
            i < recipients.size();
            i++) {

            if(recipients.get(i)
                    .equals(recipientNumber)) {

                found = true;

                if(i < storedMessages.size()) {

                    System.out.println(
                            storedMessages.get(i));
                }
            }
        }

        if(!found) {

            System.out.println(
                    "No messages found.");
        }
    }

    // Delete Message Using Hash
    public static String deleteMessageHash(
            String hash) {

        for(int i = 0;
            i < messageHashes.size();
            i++) {

            if(messageHashes.get(i)
                    .equals(hash)) {

                String deletedMessage =
                        storedMessages.get(i);

                storedMessages.remove(i);
                recipients.remove(i);
                messageHashes.remove(i);
                messageIDs.remove(i);

                return "Message: \""
                        + deletedMessage
                        + "\" successfully deleted.";
            }
        }

        return "Message hash not found.";
    }

    // Display Report
    public static void displayReport() {

        System.out.println(
                "\n===== MESSAGE REPORT =====");

        for(int i = 0;
            i < storedMessages.size();
            i++) {

            System.out.println(
                    "\nMessage Hash: "
                    + messageHashes.get(i));

            System.out.println(
                    "Recipient: "
                    + recipients.get(i));

            System.out.println(
                    "Message: "
                    + storedMessages.get(i));
        }
    }

    // Get Total Messages
    public static int returnTotalMessages() {

        return totalMessages;
    }

    // Getters for Unit Tests

    public static ArrayList<String> getSentMessages() {
        return sentMessages;
    }

    public static ArrayList<String> getStoredMessages() {
        return storedMessages;
    }

    public static ArrayList<String> getDisregardedMessages() {
        return disregardedMessages;
    }

    public static ArrayList<String> getMessageHashes() {
        return messageHashes;
    }

    public static ArrayList<String> getMessageIDs() {
        return messageIDs;
    }

    public static ArrayList<String> getRecipients() {
        return recipients;
    }
}