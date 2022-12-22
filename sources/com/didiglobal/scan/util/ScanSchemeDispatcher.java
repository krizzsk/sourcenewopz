package com.didiglobal.scan.util;

import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.scan.delegate.ScanSchemeDispatcherDelegate;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/scan/util/ScanSchemeDispatcher;", "", "()V", "dispatcher", "", "scheme", "", "actionType", "Lcom/didiglobal/scan/delegate/ScanSchemeDispatcherDelegate$ActionType;", "extraData", "Lcom/google/gson/JsonObject;", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ScanSchemeDispatcher.kt */
public final class ScanSchemeDispatcher {
    public static final ScanSchemeDispatcher INSTANCE = new ScanSchemeDispatcher();

    private ScanSchemeDispatcher() {
    }

    public final void dispatcher(String str, ScanSchemeDispatcherDelegate.ActionType actionType, JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        Intrinsics.checkParameterIsNotNull(actionType, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        Iterator<S> it = ServiceLoader.load(ScanSchemeDispatcherDelegate.class).iterator();
        Intrinsics.checkExpressionValueIsNotNull(it, "serviceLoader.iterator()");
        boolean z = false;
        while (it.hasNext() && !z) {
            z = ((ScanSchemeDispatcherDelegate) it.next()).handleScheme(str, actionType, jsonObject);
        }
    }
}
