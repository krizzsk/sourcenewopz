package com.didi.component.framework.util;

import com.didi.component.business.util.GlobalApolloUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/component/framework/util/TripApolloUtils;", "", "()V", "isFirstGetMapPaddingTop", "", "mapPaddingTop", "", "getTripMapPaddingTop", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TripApolloUtils.kt */
public final class TripApolloUtils {
    public static final TripApolloUtils INSTANCE = new TripApolloUtils();

    /* renamed from: a */
    private static boolean f14001a = true;

    /* renamed from: b */
    private static int f14002b = 60;

    private TripApolloUtils() {
    }

    public final int getTripMapPaddingTop() {
        if (f14001a) {
            Object param = GlobalApolloUtil.getParam("APP_Revision_Trip_Map_Padding_Top", "paddingTop", Integer.valueOf(f14002b));
            Intrinsics.checkNotNullExpressionValue(param, "getParam(\n              …dingTop\n                )");
            f14002b = ((Number) param).intValue();
            f14001a = false;
        }
        return f14002b;
    }
}
