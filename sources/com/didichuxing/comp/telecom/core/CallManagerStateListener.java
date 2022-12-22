package com.didichuxing.comp.telecom.core;

import com.didichuxing.comp.telecom.core.base.ICall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/CallManagerStateListener;", "", "onCallCreate", "", "newCall", "Lcom/didichuxing/comp/telecom/core/base/ICall;", "onCallDestroy", "oldCall", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallManager.kt */
public interface CallManagerStateListener {

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 13})
    /* compiled from: CallManager.kt */
    public static final class DefaultImpls {
        public static void onCallCreate(CallManagerStateListener callManagerStateListener, ICall iCall) {
            Intrinsics.checkParameterIsNotNull(iCall, "newCall");
        }

        public static void onCallDestroy(CallManagerStateListener callManagerStateListener, ICall iCall) {
        }
    }

    void onCallCreate(ICall iCall);

    void onCallDestroy(ICall iCall);
}
