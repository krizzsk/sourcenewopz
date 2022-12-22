package com.didi.component.confirmupdateaddress.util;

import android.content.Context;
import com.didi.sdk.util.SPUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, mo175978d2 = {"Lcom/didi/component/confirmupdateaddress/util/OnServiceGuideUtil;", "", "()V", "isShowEditGuideOnService", "", "context", "Landroid/content/Context;", "setShowEditGuideOnService", "", "show", "comp-confirmupdateaddress_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OnServiceGuideUtil.kt */
public final class OnServiceGuideUtil {
    public static final OnServiceGuideUtil INSTANCE = new OnServiceGuideUtil();

    private OnServiceGuideUtil() {
    }

    public final boolean isShowEditGuideOnService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object obj = SPUtils.get(context, "isShowEditGuideOnService", false);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final void setShowEditGuideOnService(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        SPUtils.put(context, "isShowEditGuideOnService", Boolean.valueOf(z));
    }
}
