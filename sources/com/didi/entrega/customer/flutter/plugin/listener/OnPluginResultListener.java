package com.didi.entrega.customer.flutter.plugin.listener;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J\u0014\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001H&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/plugin/listener/OnPluginResultListener;", "", "onError", "", "name", "", "msg", "value", "onResult", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OnPluginResultListener.kt */
public interface OnPluginResultListener {
    void onError(String str, String str2, Object obj);

    void onResult(Object obj);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OnPluginResultListener.kt */
    public static final class DefaultImpls {
        public static void onError(OnPluginResultListener onPluginResultListener, String str, String str2, Object obj) {
            Intrinsics.checkNotNullParameter(onPluginResultListener, "this");
        }

        public static /* synthetic */ void onResult$default(OnPluginResultListener onPluginResultListener, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                onPluginResultListener.onResult(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
        }

        public static /* synthetic */ void onError$default(OnPluginResultListener onPluginResultListener, String str, String str2, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    obj = null;
                }
                onPluginResultListener.onError(str, str2, obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
        }
    }
}
