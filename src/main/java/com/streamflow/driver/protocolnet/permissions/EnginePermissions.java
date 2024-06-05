package com.streamflow.driver.protocolnet.permissions;

public enum EnginePermissions {
    REVOKE, GRANT, CREATE, LISTEN, DELETE, ROOT
    /*
    Base permissions: LISTEN
    CREATE: Create new streams
    DELETE: Delete streams
    GRANT: Grant permissions to other users (ergo, change their permissions)
    REVOKE: Revoke permissions from other users
    ROOT: Root permissions, can do anything
     */
}
