package com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/SocketState;", "", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: SocketState.kt */
public @interface SocketState {
    public static final String CLOSE = "close";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";
    public static final String OPEN = "open";

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/SocketState$Companion;", "", "()V", "CLOSE", "", "ERROR", "MESSAGE", "OPEN", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: SocketState.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CLOSE = "close";
        public static final String ERROR = "error";
        public static final String MESSAGE = "message";
        public static final String OPEN = "open";

        private Companion() {
        }
    }
}
