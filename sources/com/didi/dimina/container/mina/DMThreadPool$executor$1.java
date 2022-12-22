package com.didi.dimina.container.mina;

import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "newThread"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DMThreadPool.kt */
final class DMThreadPool$executor$1 implements ThreadFactory {
    public static final DMThreadPool$executor$1 INSTANCE = new DMThreadPool$executor$1();

    DMThreadPool$executor$1() {
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append("DmThread#");
        DMThreadPool dMThreadPool = DMThreadPool.INSTANCE;
        int access$getThreadNum$p = DMThreadPool.f16945f;
        DMThreadPool.f16945f = access$getThreadNum$p + 1;
        sb.append(access$getThreadNum$p);
        return new Thread(runnable, sb.toString());
    }
}
