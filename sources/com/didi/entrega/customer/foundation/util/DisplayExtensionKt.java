package com.didi.entrega.customer.foundation.util;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"dip2px", "", "Landroid/content/Context;", "dpValue", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DisplayExtension.kt */
public final class DisplayExtensionKt {
    public static final int dip2px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
