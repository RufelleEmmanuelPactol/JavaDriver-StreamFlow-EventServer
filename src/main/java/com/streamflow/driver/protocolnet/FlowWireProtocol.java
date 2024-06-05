package com.streamflow.driver.protocolnet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public abstract class FlowWireProtocol {

    private Socket socket;
    private String host;
    private int port;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;





}
