package com.streamflow.driver.protocolnet.context;


import com.streamflow.driver.protocolnet.FlowConnection;
import com.streamflow.driver.protocolnet.FlowWireProtocol;
import com.streamflow.driver.protocolnet.exceptions.ContextSchemaIntegrityException;
import com.streamflow.driver.protocolnet.exceptions.StreamFlowException;

import java.util.HashMap;

public abstract class Context {

    protected HashMap<String, Object> context;
    protected StreamContextSchema schema;
    protected FlowConnection connection;
    protected FlowWireProtocol protocol;


    public Context(FlowConnection connection, StreamContextSchema schema, FlowWireProtocol protocol) {
        this.context = new HashMap<>();
        this.schema = schema;
        this.connection = connection;
        this.protocol = protocol;
    }

    /**
     * Get the user context value for the given key
     * @param key the key of the user context
     * @return the value of the user context

     */
    public abstract Object getUserContext(String key);

    /**
     * Get the context type for the given key
     * @param key the key of the context
     * @return the context type
     */
    public abstract ContextType getContextType(String key);

    /**
     * Set the user context value for the given key, validating the context schema.
     * This also automatically sends the updated context to the StreamFlow engine.
     * @param key the key of the user context
     * @param value the value of the user context
     * @return true if the user context was set successfully, false otherwise
     * @throws ContextSchemaIntegrityException if the context schema is not valid
     */
    public abstract boolean setUserContext(String key, Object value) throws ContextSchemaIntegrityException;

    /**
     * Validate the schema of the context
     * @param value the value to validate
     * @param type the type of the context
     * @throws ContextSchemaIntegrityException if the context schema is not valid
     */
    protected void validateSchema(Object value, ContextType type) throws ContextSchemaIntegrityException {
        if (schema == null) {
            throw new ContextSchemaIntegrityException("Context schema is not set.");
        }
       switch (type) {
           case FLOAT -> {
               if (!(value instanceof Float)) {
                   throw new ContextSchemaIntegrityException("Value is not of type Float, but instead is of type " + value.getClass().getName());
               }
           } case INTEGER -> {
               if (!(value instanceof Integer)) {
                   throw new ContextSchemaIntegrityException("Value is not of type Integer, but instead is of type " + value.getClass().getName());
               }
           } case STRING -> {
               if (!(value instanceof String)) {
                   throw new ContextSchemaIntegrityException("Value is not of type String, but instead is of type " + value.getClass().getName());
               }
           } case BOOLEAN -> {
               if (!(value instanceof Boolean)) {
                   throw new ContextSchemaIntegrityException("Value is not of type Boolean, but instead is of type " + value.getClass().getName());
               }
           }
       }
    }





}
