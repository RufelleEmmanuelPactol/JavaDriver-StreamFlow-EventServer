package com.streamflow.driver.protocolnet;

import com.streamflow.driver.protocolnet.context.Context;
import com.streamflow.driver.protocolnet.context.StreamContextSchema;
import com.streamflow.driver.protocolnet.events.OnEventHandler;
import com.streamflow.driver.protocolnet.exceptions.StreamFlowException;
import com.streamflow.driver.protocolnet.payload.EventMessage;
import com.streamflow.driver.protocolnet.permissions.StreamPermissions;

import java.util.HashMap;


/**
 * The Stream class is the main class that is used to interact with the StreamFlow engine.
 * The Stream class is used to send events to the StreamFlow engine and to add new contexts to the stream.
 * The Stream class, depending on the user's privileges, can be used to send events to the StreamFlow engine and to add new contexts to the stream.
 *
 * Written by: Rufelle Emmanuel Pactol, 2024
 */
public abstract class Stream {

    protected FlowConnection connectionContext;
    protected HashMap<String, Context> streamContexts;





    protected Stream(FlowConnection connectionContext, String streamName, String streamKey) {
        this.connectionContext = connectionContext;
        this.streamContexts = new HashMap<String, Context>();

    }


    /**
     * Send an event to the stream to be processed by the StreamFlow engine when the event is received.
     * @param eventName The name of the event
     * @param eventKey The key of the event
     * @param handler The handler to be called when the event is received
     * PERMISSION_REQUIRED: BASE (CONSUMER)
     */
    public abstract void onEvent(String eventName, String eventKey, OnEventHandler handler);

    /**
     * Add a new context to the stream. The context is used to filter the events that are sent to the user.
     * @param contextName The name of the context
     * @param schema The schema of the context
     * @return true if the context was added successfully, false otherwise
     * PERMISSION_REQUIRED: ROOT_LEVEL
     */
    public abstract boolean addStreamContext(String contextName, StreamContextSchema schema) throws StreamFlowException;

    /**
     * Send an event to the stream to be processed by the StreamFlow engine when the event is received.
     * @param username The username of the user
     * @param permissions The permissions to be granted to the user
     * @return true if the permissions were granted successfully, false otherwise
     * PERMISSION_REQUIRED: ROOT_LEVEL
     */
    public abstract boolean grantPermission(String username, StreamPermissions permissions) throws StreamFlowException;

    /**
     * Revoke a permission from a user.
     * @param username The username of the user
     * @param permissions The permissions to be revoked from the user
     * @return true if the permissions were revoked successfully, false otherwise
     * PERMISSION_REQUIRED: ROOT_LEVEL
     */
    public abstract boolean revokePermission(String username, StreamPermissions permissions) throws StreamFlowException;

    /**
     * Disconnect from the stream.
     * PERMISSION_REQUIRED: BASE (CONSUMER)
     */
    public abstract void disconnect() throws StreamFlowException;


    /**
     * Send an event to the stream to be processed by the StreamFlow engine when the event is received.
     * @param eventName The name of the event
     * @param messageContext The message context of the event
     * PERMISSION_REQUIRED: PRODUCER
     */
    public abstract void sendEvent(String eventName, EventMessage messageContext) throws StreamFlowException;

    /**
     * Send an event to the stream to be processed by the StreamFlow engine when the event is received.
     * @param eventName The name of the event
     * @param messageContext The message context of the event
     * @param filter The filter to be applied to the event
     * PERMISSION_REQUIRED: PRODUCER
     */
    public abstract void sendEventWithFilter(String eventName, EventMessage messageContext, String filter) throws StreamFlowException;

    /**
     * Get the Context for the given context name.
     * @param contextName The name of the context
     * @return The Context object for the given context name
     * PERMISSION_REQUIRED: ROOT_LEVEL
     */
    public abstract Context getStreamContext(String contextName) throws StreamFlowException;

}
