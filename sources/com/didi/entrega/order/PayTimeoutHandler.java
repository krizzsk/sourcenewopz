package com.didi.entrega.order;

import android.os.Handler;
import com.didi.entrega.customer.foundation.storage.ServerConfigStorage;
import com.didi.entrega.customer.foundation.util.SingletonFactory;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\rR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/entrega/order/PayTimeoutHandler;", "Ljava/lang/Runnable;", "()V", "handler", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "orderId", "", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "cancel", "", "getTimeout", "", "start", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayTimeoutHandler.kt */
public abstract class PayTimeoutHandler implements Runnable {
    private final Handler handler = UIHandler.getHandler();
    private String orderId;

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void start() {
        Runnable runnable = this;
        this.handler.removeCallbacks(runnable);
        this.handler.postDelayed(runnable, getTimeout());
    }

    public final void cancel() {
        this.handler.removeCallbacks(this);
    }

    private final long getTimeout() {
        long j = ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData() != null ? ((long) ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().payTimeout) * 1000 : 0;
        if (j <= 0) {
            return 7000;
        }
        return j;
    }
}
