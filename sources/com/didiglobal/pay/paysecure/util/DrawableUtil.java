package com.didiglobal.pay.paysecure.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import com.didi.dcrypto.util.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0012"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/util/DrawableUtil;", "", "()V", "dpToPx", "", "context", "Landroid/content/Context;", "dp", "", "getGradientDrawable", "Landroid/graphics/drawable/Drawable;", "radius", "color", "", "getNegativeDrawable", "getPositiveDrawable", "getSelectorDrawable", "Landroid/graphics/drawable/StateListDrawable;", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DrawableUtil.kt */
public final class DrawableUtil {
    public static final DrawableUtil INSTANCE = new DrawableUtil();

    private DrawableUtil() {
    }

    public final StateListDrawable getSelectorDrawable(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        int parseColor = Color.parseColor(ColorUtils.DIDI_GREEN_LATOUR);
        if (parseColor == 0) {
            parseColor = Color.parseColor(ColorUtils.DIDI_GREEN_LATOUR);
        }
        int parseColor2 = Color.parseColor(ColorUtils.DIDI_GREY);
        float a = m36284a(context, 16.0d);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910}, m36285a(context, a, parseColor));
        stateListDrawable.addState(new int[0], m36285a(context, a, parseColor2));
        return stateListDrawable;
    }

    public final Drawable getPositiveDrawable(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        int parseColor = Color.parseColor(ColorUtils.DIDI_GREEN_LATOUR);
        if (parseColor == 0) {
            parseColor = Color.parseColor(ColorUtils.DIDI_GREEN_LATOUR);
        }
        return m36285a(context, m36284a(context, 16.0d), parseColor);
    }

    public final Drawable getNegativeDrawable(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        int parseColor = Color.parseColor(ColorUtils.DIDI_GREY);
        if (parseColor == 0) {
            parseColor = Color.parseColor(ColorUtils.DIDI_GREY);
        }
        return m36285a(context, m36284a(context, 16.0d), parseColor);
    }

    /* renamed from: a */
    private final Drawable m36285a(Context context, float f, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* renamed from: a */
    private final float m36284a(Context context, double d) {
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (float) (((double) resources.getDisplayMetrics().density) * d);
    }
}
