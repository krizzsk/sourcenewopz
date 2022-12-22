package com.didi.soda.customer.foundation.util;

import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0003*\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, mo175978d2 = {"orZero", "", "(Ljava/lang/Integer;)I", "", "(Ljava/lang/Long;)J", "updateAngle", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "Landroid/graphics/drawable/GradientDrawable;", "angleNum", "(Landroid/graphics/drawable/GradientDrawable;Ljava/lang/Integer;)Landroid/graphics/drawable/GradientDrawable$Orientation;", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: extentions.kt */
public final class ExtentionsKt {
    public static final int orZero(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static final long orZero(Long l) {
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public static final GradientDrawable.Orientation updateAngle(GradientDrawable gradientDrawable, Integer num) {
        Intrinsics.checkNotNullParameter(gradientDrawable, "<this>");
        if (num != null && num.intValue() == 0) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
        if (num != null && num.intValue() == 45) {
            return GradientDrawable.Orientation.BL_TR;
        }
        if (num != null && num.intValue() == 90) {
            return GradientDrawable.Orientation.BOTTOM_TOP;
        }
        if (num != null && num.intValue() == 135) {
            return GradientDrawable.Orientation.BR_TL;
        }
        if (num != null && num.intValue() == 180) {
            return GradientDrawable.Orientation.RIGHT_LEFT;
        }
        if (num != null && num.intValue() == 225) {
            return GradientDrawable.Orientation.TR_BL;
        }
        if (num != null && num.intValue() == 270) {
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
        if (num != null && num.intValue() == 315) {
            return GradientDrawable.Orientation.TL_BR;
        }
        return GradientDrawable.Orientation.LEFT_RIGHT;
    }
}
