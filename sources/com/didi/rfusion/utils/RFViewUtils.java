package com.didi.rfusion.utils;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/rfusion/utils/RFViewUtils;", "", "()V", "isLayoutRtl", "", "view", "Landroid/view/View;", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFViewUtils.kt */
public final class RFViewUtils {
    public static final RFViewUtils INSTANCE = new RFViewUtils();

    private RFViewUtils() {
    }

    public final boolean isLayoutRtl(View view) {
        if (view == null) {
            Intrinsics.throwNpe();
        }
        return ViewCompat.getLayoutDirection(view) == 1;
    }
}
