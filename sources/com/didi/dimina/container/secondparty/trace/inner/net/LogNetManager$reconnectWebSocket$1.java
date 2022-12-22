package com.didi.dimina.container.secondparty.trace.inner.net;

import com.didi.dimina.container.mina.ITask;
import com.didi.dimina.container.util.LogUtil;
import didihttp.DidiHttpClient;
import didihttp.WebSocket;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/dimina/container/secondparty/trace/inner/net/LogNetManager$reconnectWebSocket$1", "Lcom/didi/dimina/container/mina/ITask;", "", "onComplete", "", "result", "runTaskInBackground", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LogNetManager.kt */
public final class LogNetManager$reconnectWebSocket$1 implements ITask<Object> {
    final /* synthetic */ LogWebSocketListener $listener;
    final /* synthetic */ WebSocket $webSocket;

    LogNetManager$reconnectWebSocket$1(WebSocket webSocket, LogWebSocketListener logWebSocketListener) {
        this.$webSocket = webSocket;
        this.$listener = logWebSocketListener;
    }

    public Object runTaskInBackground() {
        LogNetManager.INSTANCE.setWebSocket(new DidiHttpClient.Builder().pingInterval(9000, TimeUnit.MILLISECONDS).build().newWebSocket(this.$webSocket.request(), this.$listener));
        return null;
    }

    public void onComplete(Object obj) {
        LogUtil.iRelease(LogWebSocketListener.TAG, "reconnect function called");
    }
}
