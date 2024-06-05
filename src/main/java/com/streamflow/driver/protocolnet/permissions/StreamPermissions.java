package com.streamflow.driver.protocolnet.permissions;

import com.streamflow.driver.protocolnet.context.StreamContextSchema;

/**
 * Used to control stream-level permissions.
 * A producer can only write and read to a stream, a consumer can only read from a stream,
 * a root user can do both and also manage StreamContexts, as well as delete the stream,
 * and revoke or grant permissions to other users.
 * The creator of the stream is automatically assigned the root permission.\
 * @see StreamContextSchema
 *
 * Written by: Rufelle Emmanuel Pactol, 2024
 */
public enum StreamPermissions {
    PRODUCER, CONSUMER, ROOT
}
