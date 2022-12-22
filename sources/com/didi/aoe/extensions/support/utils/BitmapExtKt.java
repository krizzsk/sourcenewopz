package com.didi.aoe.extensions.support.utils;

import android.graphics.Bitmap;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo175978d2 = {"getCompatAllocationByteCount", "", "Landroid/graphics/Bitmap;", "support_release"}, mo175979k = 2, mo175980mv = {1, 1, 15})
/* compiled from: BitmapExt.kt */
public final class BitmapExtKt {
    public static final int getCompatAllocationByteCount(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$getCompatAllocationByteCount");
        if (Build.VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        return bitmap.getByteCount();
    }
}
