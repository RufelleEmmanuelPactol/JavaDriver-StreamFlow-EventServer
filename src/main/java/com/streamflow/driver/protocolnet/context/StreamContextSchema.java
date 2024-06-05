package com.streamflow.driver.protocolnet.context;

import java.util.HashMap;

/**
 * StreamContextSchema is a class that represents the schema of a user context.
 * A user context is an attribute that is associated with a user and a topic, which can be used to
 * filter the events that are sent to the user.
 *
 * The schema is immutable once registered to a specific event. However, it can be removed.
 */
public class StreamContextSchema {

    private final HashMap<String, ContextType> contextSchema;
    private final String contextName;


    public StreamContextSchema(String contextName) {
        this.contextSchema = new HashMap<>();
        this.contextName = contextName;
    }

    public void addContext(String contextName, ContextType contextType) {
        contextSchema.put(contextName, contextType);
    }



}
