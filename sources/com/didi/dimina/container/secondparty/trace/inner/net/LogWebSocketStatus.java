package com.didi.dimina.container.secondparty.trace.inner.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/net/LogWebSocketStatus;", "", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: LogWebSocketStatus.kt */
public @interface LogWebSocketStatus {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int STATUS_CONNECTED = 2;
    public static final int STATUS_DISCONNECT = -1;
    public static final int STATUS_RECONNECTING = 1;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/net/LogWebSocketStatus$Companion;", "", "()V", "STATUS_CONNECTED", "", "STATUS_DISCONNECT", "STATUS_RECONNECTING", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: LogWebSocketStatus.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int STATUS_CONNECTED = 2;
        public static final int STATUS_DISCONNECT = -1;
        public static final int STATUS_RECONNECTING = 1;

        private Companion() {
        }
    }
}
