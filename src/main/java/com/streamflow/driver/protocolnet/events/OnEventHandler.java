package com.streamflow.driver.protocolnet.events;

public interface OnEventHandler {


    void onEvent(EventStreamProducer event);
}
