package com.didi.soda.customer.widget.business;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u0007H\u0016J.\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/business/HomeBusinessTagView;", "Lcom/didi/soda/customer/widget/business/BaseTagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "limitMaxWidth", "getLimitMaxWidth", "()I", "setLimitMaxWidth", "(I)V", "getLimitedMaxWidth", "setData", "", "colorStr", "", "bgColorStr", "content", "res", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseTagView.kt */
public final class HomeBusinessTagView extends BaseTagView {

    /* renamed from: a */
    private int f41643a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessTagView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeBusinessTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBusinessTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f41643a = ResourceHelper.getDimensionPixelSize(R.dimen.customer_124px);
    }

    public final int getLimitMaxWidth() {
        return this.f41643a;
    }

    public final void setLimitMaxWidth(int i) {
        this.f41643a = i;
    }

    public int getLimitedMaxWidth() {
        return this.f41643a;
    }

    public final void setData(String str, String str2, String str3, int i) {
        int i2;
        Unit unit;
        int color;
        Unit unit2 = null;
        int i3 = 0;
        if (str == null) {
            unit = null;
            i2 = 0;
        } else {
            try {
                i2 = Color.parseColor(str);
            } catch (Exception unused) {
                i2 = ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            HomeBusinessTagView homeBusinessTagView = this;
            i2 = ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF);
        }
        if (str2 != null) {
            try {
                color = Color.parseColor(str2);
            } catch (Exception unused2) {
                color = ResourceHelper.getColor(R.color.rf_color_gery_18_0_66000000);
            }
            i3 = color;
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            HomeBusinessTagView homeBusinessTagView2 = this;
            i3 = ResourceHelper.getColor(R.color.rf_color_gery_18_0_66000000);
        }
        Drawable drawable = getContext().getResources().getDrawable(i);
        if (drawable != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            gradientDrawable.setColor(i3);
            bindData(Integer.valueOf(i2), gradientDrawable, str3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }
}
