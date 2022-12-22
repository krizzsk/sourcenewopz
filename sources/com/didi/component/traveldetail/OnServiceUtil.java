package com.didi.component.traveldetail;

import android.content.Context;
import com.didi.component.common.util.GLog;
import com.didi.sdk.util.SPUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/component/traveldetail/OnServiceUtil;", "", "()V", "needShowOnServiceRouteEditShow", "", "context", "Landroid/content/Context;", "onServiceRouteEditShow", "setOnServiceRouteEditShow", "", "show", "comp_travel_detail_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OnServiceUtil.kt */
public final class OnServiceUtil {
    public static final OnServiceUtil INSTANCE = new OnServiceUtil();

    private OnServiceUtil() {
    }

    /* renamed from: a */
    private final boolean m11838a(Context context) {
        Object obj = SPUtils.get(context, "onServiceRouteEditShow", false);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final boolean needShowOnServiceRouteEditShow(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean a = m11838a(context);
        GLog.m7965d("needShowOnServiceRouteEditShow", Intrinsics.stringPlus("onServiceRouteEditShow:", Boolean.valueOf(a)));
        return !a;
    }

    public final void setOnServiceRouteEditShow(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        SPUtils.put(context, "onServiceRouteEditShow", Boolean.valueOf(z));
    }
}
