package com.didi.beatles.p099im.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0000\u001a\u00020\u0002*\u00020\u0002\u001a\u000f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0005H\b¨\u0006\u0006"}, mo175978d2 = {"dp2px", "", "", "isNotNullOrEmpty", "", "", "im_library_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.beatles.im.utils.KotlinExtKt */
/* compiled from: KotlinExt.kt */
public final class KotlinExtKt {
    public static final float dp2px(float f) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return TypedValue.applyDimension(1, f, system.getDisplayMetrics());
    }

    public static final int dp2px(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return (int) TypedValue.applyDimension(1, (float) i, system.getDisplayMetrics());
    }

    public static final boolean isNotNullOrEmpty(CharSequence charSequence) {
        return !(charSequence == null || charSequence.length() == 0) && (Intrinsics.areEqual((Object) charSequence, (Object) "null") ^ true);
    }
}
