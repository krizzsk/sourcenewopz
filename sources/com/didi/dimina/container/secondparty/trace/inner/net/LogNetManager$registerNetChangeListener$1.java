package com.didi.dimina.container.secondparty.trace.inner.net;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.didi.dimina.container.secondparty.trace.inner.LogManager;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.webview.util.NetworkUtil;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/dimina/container/secondparty/trace/inner/net/LogNetManager$registerNetChangeListener$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LogNetManager.kt */
public final class LogNetManager$registerNetChangeListener$1 extends BroadcastReceiver {
    final /* synthetic */ Application $app;

    LogNetManager$registerNetChangeListener$1(Application application) {
        this.$app = application;
    }

    public void onReceive(Context context, Intent intent) {
        if (NetworkUtil.isAvailable(this.$app) && LogManager.INSTANCE.getMWebsocketStatus() == -1) {
            LogUtil.iRelease(LogNetManager.TAG, "netWork isAvailable recreate websocket");
            LogNetManager.INSTANCE.createWebSocket();
        }
    }
}
