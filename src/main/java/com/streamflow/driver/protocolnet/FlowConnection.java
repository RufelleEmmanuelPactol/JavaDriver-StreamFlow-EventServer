package com.streamflow.driver.protocolnet;

import com.streamflow.driver.protocolnet.exceptions.StreamFlowException;
import com.streamflow.driver.protocolnet.permissions.EnginePermissions;

/**
 * This class represents a connection to a StreamFlow server.
 * An instance of this class is created by the FlowDriverManager class.
 * On a single connection instance, only one user is allowed to be logged in.
 * Connections are stateful, meaning that they keep track of the user that is currently logged in,
 * but by themselves, they do not keep track of the streams that are being accessed.
 *
 * Per connection, only one TCP connection is established to the server.
 *
 * Written by Rufelle Emmanuel Pactol, 2024.
 */
public abstract class FlowConnection {

    protected final String host;
    protected final int port;
    protected final String username;
    protected final String password;
    protected boolean isRoot;
    protected FlowWireProtocol wireProtocol;




    protected FlowConnection(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }



    public abstract boolean heartbeat();

    public abstract double ping();

    public abstract Stream createEventStream(String streamName, String streamKey) throws StreamFlowException;

    public abstract Stream tapToEventStream (String streamName, String streamKey) throws StreamFlowException;

    public abstract FlowConnection createUser(String username,String password, EnginePermissions... permissionLevel)
            throws StreamFlowException;

    public abstract boolean changePassword(String currentPassword, String newPassword) throws StreamFlowException;

    public abstract boolean deleteUser(String username) throws StreamFlowException;

    protected abstract FlowWireProtocol getWireProtocol();








}
