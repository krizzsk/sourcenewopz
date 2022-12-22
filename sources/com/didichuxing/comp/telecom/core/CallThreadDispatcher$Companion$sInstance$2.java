package com.didichuxing.comp.telecom.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "Lcom/didichuxing/comp/telecom/core/CallThreadDispatcher;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: CallUtils.kt */
final class CallThreadDispatcher$Companion$sInstance$2 extends Lambda implements Function0<CallThreadDispatcher> {
    public static final CallThreadDispatcher$Companion$sInstance$2 INSTANCE = new CallThreadDispatcher$Companion$sInstance$2();

    CallThreadDispatcher$Companion$sInstance$2() {
        super(0);
    }

    public final CallThreadDispatcher invoke() {
        return new CallThreadDispatcher();
    }
}
