package com.didichuxing.mlcp.drtc.utils;

import com.didi.sdk.apm.SystemUtils;
import com.koushikdutta.async.http.WebSocket;

/* renamed from: com.didichuxing.mlcp.drtc.utils.-$$Lambda$h$zPRH6DimiAN8M2eOm7gC61BCU7o  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$h$zPRH6DimiAN8M2eOm7gC61BCU7o implements WebSocket.PongCallback {
    public static final /* synthetic */ $$Lambda$h$zPRH6DimiAN8M2eOm7gC61BCU7o INSTANCE = new $$Lambda$h$zPRH6DimiAN8M2eOm7gC61BCU7o();

    private /* synthetic */ $$Lambda$h$zPRH6DimiAN8M2eOm7gC61BCU7o() {
    }

    public final void onPongReceived(String str) {
        SystemUtils.log(3, C15926h.f48466a, "Pong callback", (Throwable) null, C15926h.f48466a, 3);
    }
}
