package com.didichuxing.comp.telecom.core;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/CallToastUtil;", "", "()V", "makeToast", "", "resId", "", "(Ljava/lang/Integer;)V", "str", "", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallUtils.kt */
public final class CallToastUtil {
    public static final CallToastUtil INSTANCE = new CallToastUtil();

    private CallToastUtil() {
    }

    @JvmStatic
    public static /* synthetic */ void makeToast$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        makeToast(str);
    }

    @JvmStatic
    public static final void makeToast(String str) {
        if (str != null) {
            CallThreadDispatcher.Companion.getInstance().runOnUiThread(new CallToastUtil$makeToast$1(str));
        }
    }

    @JvmStatic
    public static /* synthetic */ void makeToast$default(Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        makeToast(num);
    }

    @JvmStatic
    public static final void makeToast(Integer num) {
        if (num != null) {
            num.intValue();
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            Context appContext = instance.getAppContext();
            if (appContext != null) {
                try {
                    makeToast(appContext.getString(num.intValue()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
