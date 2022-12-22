package com.didichuxing.comp.telecom.core;

import android.content.Context;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/CallUtils;", "", "()V", "getStringRes", "", "resId", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallUtils.kt */
public final class CallUtils {
    public static final CallUtils INSTANCE = new CallUtils();

    private CallUtils() {
    }

    public final String getStringRes(Integer num) {
        if (num == null) {
            return null;
        }
        num.intValue();
        Context appContext = CallManager.Companion.getInstance().getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            return appContext.getString(num.intValue());
        } catch (Exception unused) {
            return null;
        }
    }
}
