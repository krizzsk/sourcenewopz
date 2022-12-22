package com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket;

import didihttp.WebSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/SocketTask;", "", "webSocket", "Ldidihttp/WebSocket;", "(Ldidihttp/WebSocket;)V", "getWebSocket", "()Ldidihttp/WebSocket;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SocketTask.kt */
public final class SocketTask {

    /* renamed from: a */
    private final WebSocket f17286a;

    public static /* synthetic */ SocketTask copy$default(SocketTask socketTask, WebSocket webSocket, int i, Object obj) {
        if ((i & 1) != 0) {
            webSocket = socketTask.f17286a;
        }
        return socketTask.copy(webSocket);
    }

    public final WebSocket component1() {
        return this.f17286a;
    }

    public final SocketTask copy(WebSocket webSocket) {
        return new SocketTask(webSocket);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SocketTask) && Intrinsics.areEqual((Object) this.f17286a, (Object) ((SocketTask) obj).f17286a);
        }
        return true;
    }

    public int hashCode() {
        WebSocket webSocket = this.f17286a;
        if (webSocket != null) {
            return webSocket.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SocketTask(webSocket=" + this.f17286a + ")";
    }

    public SocketTask(WebSocket webSocket) {
        this.f17286a = webSocket;
    }

    public final WebSocket getWebSocket() {
        return this.f17286a;
    }
}
