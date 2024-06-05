package com.streamflow.driver.protocolnet.payload;

import java.util.HashMap;

/**
 * EventMessage class is used to store the message context of the event.
 * A message context is a key-value pair that is sent alongside an event.
 * This is mainly to hold the information that will be received by the event handler.
 *
 * Written by: Rufelle Emmanuel Pactol, 2024
 */
public class EventMessage {

    protected HashMap<String, String> message;

    public EventMessage() {
        message = new HashMap<String, String>();
    }

    public void addMessageContext(String key, String value) {
        message.put(key, value);
    }

    public String getMessageContext(String key) {
        return message.get(key);
    }
}
