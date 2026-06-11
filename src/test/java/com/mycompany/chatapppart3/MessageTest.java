/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


package com.mycompany.chatapppart3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {

        Message msg = new Message(
                0,
                "+27834557896",
                "Did you get the cake?"
        );

        assertEquals(
                "Message ready to send.",
                msg.checkMessageLength()
        );
    }

    @Test
    public void testRecipientSuccess() {

        Message msg = new Message(
                0,
                "+27834557896",
                "Hello"
        );

        assertEquals(
                "Cell phone number successfully captured.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testMessageIDCreated() {

        Message msg = new Message(
                0,
                "+27834557896",
                "Hello"
        );

        assertTrue(
                msg.checkMessageID()
        );
    }

    @Test
    public void testSendMessage() {

        Message msg = new Message(
                0,
                "+27834557896",
                "Did you get the cake?"
        );

        assertEquals(
                "Message successfully sent.",
                msg.sentMessage(1)
        );
    }

    @Test
    public void testStoreMessage() {

        Message msg = new Message(
                1,
                "+27838884567",
                "Where are you? You are late! I have asked you to be on time."
        );

        assertEquals(
                "Message successfully stored.",
                msg.sentMessage(3)
        );
    }

    @Test
    public void testDisregardMessage() {

        Message msg = new Message(
                2,
                "+27834484567",
                "Yohoooo, I am at your gate."
        );

        assertEquals(
                "Press 0 to delete the message.",
                msg.sentMessage(2)
        );
    }

    @Test
    public void testSentMessagesArray() {

        Message msg1 = new Message(
                0,
                "+27834557896",
                "Did you get the cake?"
        );

        msg1.sentMessage(1);

        assertTrue(
                Message.getSentMessages()
                        .contains("Did you get the cake?")
        );
    }

    @Test
    public void testLongestStoredMessage() {

        Message msg1 = new Message(
                1,
                "+27838884567",
                "Where are you? You are late! I have asked you to be on time."
        );

        msg1.sentMessage(3);

        assertEquals(
                "Where are you? You are late! I have asked you to be on time.",
                Message.getLongestStoredMessage()
        );
    }

    @Test
    public void testDeleteMessageHash() {

        Message msg = new Message(
                1,
                "+27838884567",
                "Where are you? You are late! I have asked you to be on time."
        );

        msg.sentMessage(3);

        String hash = msg.createMessageHash();

        assertTrue(
                Message.deleteMessageHash(hash)
                        .contains("successfully deleted")
        );
    }

    @Test
    public void testTotalMessages() {

        Message msg = new Message(
                0,
                "+27834557896",
                "Did you get the cake?"
        );

        msg.sentMessage(1);

        assertTrue(
                Message.returnTotalMessages() >= 1
        );
    }
}