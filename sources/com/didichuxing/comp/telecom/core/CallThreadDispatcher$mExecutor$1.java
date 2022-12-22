package com.didichuxing.comp.telecom.core;

import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: CallUtils.kt */
final class CallThreadDispatcher$mExecutor$1 implements ThreadFactory {
    public static final CallThreadDispatcher$mExecutor$1 INSTANCE = new CallThreadDispatcher$mExecutor$1();

    CallThreadDispatcher$mExecutor$1() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable);
    }
}
