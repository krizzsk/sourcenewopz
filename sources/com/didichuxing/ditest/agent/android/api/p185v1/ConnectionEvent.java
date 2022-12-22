package com.didichuxing.ditest.agent.android.api.p185v1;

import com.didichuxing.ditest.agent.android.api.common.ConnectionState;
import java.util.EventObject;

/* renamed from: com.didichuxing.ditest.agent.android.api.v1.ConnectionEvent */
public final class ConnectionEvent extends EventObject {
    private static final long serialVersionUID = 1;
    private final ConnectionState connectionState;

    public ConnectionEvent(Object obj) {
        this(obj, (ConnectionState) null);
    }

    public ConnectionEvent(Object obj, ConnectionState connectionState2) {
        super(obj);
        this.connectionState = connectionState2;
    }

    public ConnectionState getConnectionState() {
        return this.connectionState;
    }
}
