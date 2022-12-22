package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.p189v1;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.ConnectionState;
import java.util.EventObject;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.v1.ConnectionEvent */
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
