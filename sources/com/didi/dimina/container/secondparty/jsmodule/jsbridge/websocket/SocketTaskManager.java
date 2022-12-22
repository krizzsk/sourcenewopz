package com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket;

import com.didi.dimina.container.secondparty.http.DidiNetworkServiceManager;
import didihttp.DidiHttpClient;
import didihttp.Request;
import didihttp.WebSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/SocketTaskManager;", "", "()V", "socketTaskMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/SocketTask;", "addWebSocket", "", "taskId", "webSocket", "Ldidihttp/WebSocket;", "createSocketTask", "requestOptions", "Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/RequestOptions;", "listener", "Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/DMWebSocketListener;", "getSocketTask", "removeWebsocket", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SocketTaskManager.kt */
public final class SocketTaskManager {
    public static final SocketTaskManager INSTANCE = new SocketTaskManager();

    /* renamed from: a */
    private static final ConcurrentHashMap<String, SocketTask> f17287a = new ConcurrentHashMap<>();

    private SocketTaskManager() {
    }

    public final void createSocketTask(RequestOptions requestOptions, DMWebSocketListener dMWebSocketListener) {
        Intrinsics.checkParameterIsNotNull(requestOptions, "requestOptions");
        Intrinsics.checkParameterIsNotNull(dMWebSocketListener, "listener");
        DidiHttpClient httpClient = DidiNetworkServiceManager.getHttpClient(requestOptions.getTimeout());
        Request.Builder url = new Request.Builder().url(requestOptions.getUrl());
        if (requestOptions.getPerMessageDeflate()) {
            url.addHeader("Sec-webSocket-Extension", "permessage-deflate");
        }
        HashMap<String, String> header = requestOptions.getHeader();
        if (header != null) {
            for (Map.Entry entry : header.entrySet()) {
                if (!(entry.getKey() == null || entry.getValue() == null)) {
                    url.addHeader((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        Request build = url.build();
        if (httpClient != null) {
            httpClient.newWebSocket(build, dMWebSocketListener);
        }
    }

    public final void removeWebsocket(String str) {
        Intrinsics.checkParameterIsNotNull(str, DMWebSocketListener.KEY_TASK_ID);
        f17287a.remove(str);
    }

    public final void addWebSocket(String str, WebSocket webSocket) {
        Intrinsics.checkParameterIsNotNull(str, DMWebSocketListener.KEY_TASK_ID);
        if (f17287a.get(str) == null) {
            f17287a.put(str, new SocketTask(webSocket));
        }
    }

    public final SocketTask getSocketTask(String str) {
        Intrinsics.checkParameterIsNotNull(str, DMWebSocketListener.KEY_TASK_ID);
        return f17287a.get(str);
    }
}
