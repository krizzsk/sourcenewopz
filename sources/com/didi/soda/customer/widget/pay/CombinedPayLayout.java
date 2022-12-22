package com.didi.soda.customer.widget.pay;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\f¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/pay/CombinedPayLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderBg", "Landroid/widget/ImageView;", "getBorderBg", "()Landroid/widget/ImageView;", "borderBg$delegate", "Lkotlin/Lazy;", "bottomImg", "getBottomImg", "bottomImg$delegate", "topImg", "getTopImg", "topImg$delegate", "setData", "", "bottomUrl", "", "topUrl", "setSimpleImg", "url", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CombinedPayLayout.kt */
public final class CombinedPayLayout extends RelativeLayout {

    /* renamed from: a */
    private final Lazy f42147a;

    /* renamed from: b */
    private final Lazy f42148b;

    /* renamed from: c */
    private final Lazy f42149c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CombinedPayLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CombinedPayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombinedPayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f42147a = LazyKt.lazy(new CombinedPayLayout$topImg$2(this));
        this.f42148b = LazyKt.lazy(new CombinedPayLayout$bottomImg$2(this));
        this.f42149c = LazyKt.lazy(new CombinedPayLayout$borderBg$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CombinedPayLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final ImageView getTopImg() {
        Object value = this.f42147a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-topImg>(...)");
        return (ImageView) value;
    }

    private final ImageView getBottomImg() {
        Object value = this.f42148b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bottomImg>(...)");
        return (ImageView) value;
    }

    private final ImageView getBorderBg() {
        Object value = this.f42149c.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-borderBg>(...)");
        return (ImageView) value;
    }

    public static /* synthetic */ void setData$default(CombinedPayLayout combinedPayLayout, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        combinedPayLayout.setData(str, str2);
    }

    public final void setData(String str, String str2) {
        CharSequence charSequence = str2;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            setSimpleImg(str);
            return;
        }
        try {
            CharSequence charSequence2 = str;
            if (charSequence2 != null) {
                if (charSequence2.length() != 0) {
                    z = false;
                }
            }
            if (!z) {
                FlyImageLoader.loadImageUnspecified(getContext(), str).into(getBottomImg());
            }
            FlyImageLoader.loadImageUnspecified(getContext(), str2).into(getTopImg());
            ImageView borderBg = getBorderBg();
            if (borderBg != null) {
                borderBg.setVisibility(0);
            }
            ImageView bottomImg = getBottomImg();
            if (bottomImg != null) {
                bottomImg.setVisibility(0);
            }
            ImageView topImg = getTopImg();
            if (topImg != null) {
                topImg.setVisibility(0);
            }
            setVisibility(0);
        } catch (Exception unused) {
            setVisibility(8);
        }
    }

    public final void setSimpleImg(String str) {
        ImageView borderBg = getBorderBg();
        if (borderBg != null) {
            borderBg.setVisibility(8);
        }
        ImageView bottomImg = getBottomImg();
        if (bottomImg != null) {
            bottomImg.setVisibility(8);
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            ImageView topImg = getTopImg();
            if (topImg != null) {
                topImg.setVisibility(8);
                return;
            }
            return;
        }
        try {
            FlyImageLoader.loadImageUnspecified(getContext(), str).into(getTopImg());
        } catch (Exception unused) {
            ImageView topImg2 = getTopImg();
            if (topImg2 != null) {
                topImg2.setVisibility(8);
            }
        }
    }
}
