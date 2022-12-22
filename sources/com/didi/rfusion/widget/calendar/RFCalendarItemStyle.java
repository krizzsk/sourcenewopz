package com.didi.rfusion.widget.calendar;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.didi.rfusion.material.internal.RFPreconditions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFCalendarItemStyle;", "", "backgroundColor", "Landroid/content/res/ColorStateList;", "textColor", "strokeColor", "strokeWidth", "", "cornerRadius", "", "insets", "Landroid/graphics/Rect;", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;ILjava/lang/Float;Landroid/graphics/Rect;)V", "bottomInset", "getBottomInset", "()I", "Ljava/lang/Float;", "leftInset", "getLeftInset", "rightInset", "getRightInset", "topInset", "getTopInset", "styleItem", "", "item", "Landroid/widget/TextView;", "Companion", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFCalendarItemStyle.kt */
public final class RFCalendarItemStyle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final ColorStateList f33437a;

    /* renamed from: b */
    private final ColorStateList f33438b;

    /* renamed from: c */
    private final ColorStateList f33439c;

    /* renamed from: d */
    private final int f33440d;

    /* renamed from: e */
    private final Float f33441e;

    /* renamed from: f */
    private final Rect f33442f;

    private RFCalendarItemStyle(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, Float f, Rect rect) {
        this.f33437a = colorStateList;
        this.f33438b = colorStateList2;
        this.f33439c = colorStateList3;
        this.f33440d = i;
        this.f33441e = f;
        this.f33442f = rect;
        RFPreconditions.checkArgumentNonnegative(rect.left);
        RFPreconditions.checkArgumentNonnegative(this.f33442f.top);
        RFPreconditions.checkArgumentNonnegative(this.f33442f.right);
        RFPreconditions.checkArgumentNonnegative(this.f33442f.bottom);
    }

    public /* synthetic */ RFCalendarItemStyle(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, Float f, Rect rect, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorStateList, colorStateList2, colorStateList3, i, f, rect);
    }

    public final void styleItem(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "item");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.f33437a.getDefaultColor());
        gradientDrawable.setStroke(this.f33440d, this.f33439c.getDefaultColor());
        textView.setTextColor(this.f33438b);
        Float f = this.f33441e;
        if (f != null) {
            gradientDrawable.setCornerRadius(f.floatValue());
        }
        ViewCompat.setBackground(textView, new InsetDrawable(gradientDrawable, this.f33442f.left, this.f33442f.top, this.f33442f.right, this.f33442f.bottom));
    }

    public final int getLeftInset() {
        return this.f33442f.left;
    }

    public final int getRightInset() {
        return this.f33442f.right;
    }

    public final int getTopInset() {
        return this.f33442f.top;
    }

    public final int getBottomInset() {
        return this.f33442f.bottom;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFCalendarItemStyle$Companion;", "", "()V", "create", "Lcom/didi/rfusion/widget/calendar/RFCalendarItemStyle;", "backgroundColor", "Landroid/content/res/ColorStateList;", "textColor", "strokeColor", "strokeWidth", "", "cornerRadius", "", "insets", "Landroid/graphics/Rect;", "create$r_fusion_ninePhoneRelease", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFCalendarItemStyle.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFCalendarItemStyle create$r_fusion_ninePhoneRelease(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, float f, Rect rect) {
            Intrinsics.checkParameterIsNotNull(colorStateList, "backgroundColor");
            Intrinsics.checkParameterIsNotNull(colorStateList2, "textColor");
            Intrinsics.checkParameterIsNotNull(colorStateList3, "strokeColor");
            Intrinsics.checkParameterIsNotNull(rect, "insets");
            return new RFCalendarItemStyle(colorStateList, colorStateList2, colorStateList3, i, Float.valueOf(f), rect, (DefaultConstructorMarker) null);
        }
    }
}
