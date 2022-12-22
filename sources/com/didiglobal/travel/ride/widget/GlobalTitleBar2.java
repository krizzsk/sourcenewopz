package com.didiglobal.travel.ride.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didiglobal.travel.infra.view.ViewKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(J\u001a\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010'\u001a\u0004\u0018\u00010(J\u0018\u0010)\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(J\u0018\u0010-\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010.\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0007J\u0010\u0010/\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u00100\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0007J\u0018\u00100\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u00100\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u000102J\u001a\u00100\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u00103\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0007J\u000e\u00104\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0007J\u000e\u00105\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0007J\u0010\u00105\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u000102J\u000e\u00106\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0007J\u000e\u00107\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0007J?\u00108\u001a\u00020&\"\b\b\u0000\u00109*\u00020\f*\u0002H92\b\u0010'\u001a\u0004\u0018\u00010(2\u0017\u0010:\u001a\u0013\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u00020&0;¢\u0006\u0002\b<H\b¢\u0006\u0002\u0010=R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010 \u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b!\u0010\u0019¨\u0006>"}, mo175978d2 = {"Lcom/didiglobal/travel/ride/widget/GlobalTitleBar2;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "_content", "Landroid/view/View;", "contentView", "getContentView", "()Landroid/view/View;", "leftImage", "Landroid/widget/ImageView;", "getLeftImage", "()Landroid/widget/ImageView;", "leftImgView", "getLeftImgView", "leftText", "Landroid/widget/TextView;", "getLeftText", "()Landroid/widget/TextView;", "mImageLine", "getMImageLine", "middleText", "getMiddleText", "rightText", "getRightText", "rightTextView", "getRightTextView", "isValidVisibility", "", "visibility", "setLeftBackListener", "", "listener", "Landroid/view/View$OnClickListener;", "setLeftImage", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "setLeftTv", "setLeftVisible", "setRightClickListener", "setRightText", "str", "", "setRightTextColor", "setRightVisible", "setTitle", "setTitleBarLineVisible", "setTitleLineVisible", "withClick", "T", "apply", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Landroid/view/View$OnClickListener;Lkotlin/jvm/functions/Function1;)V", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalTitleBar2.kt */
public final class GlobalTitleBar2 extends FrameLayout {

    /* renamed from: a */
    private final View f51456a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlobalTitleBar2(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlobalTitleBar2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    private final boolean m36838a(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final ImageView getLeftImgView() {
        return getLeftImage();
    }

    public final TextView getRightTextView() {
        return getRightText();
    }

    public final View getContentView() {
        return ViewKt.requireViewByIdCompat(this.f51456a, R.id.v_title_bar_backplane);
    }

    private final ImageView getLeftImage() {
        return (ImageView) ViewKt.requireViewByIdCompat(this.f51456a, R.id.common_title_bar_left_img);
    }

    private final TextView getMiddleText() {
        return (TextView) ViewKt.requireViewByIdCompat(this.f51456a, R.id.common_title_bar_middle_tv);
    }

    private final TextView getRightText() {
        return (TextView) ViewKt.requireViewByIdCompat(this.f51456a, R.id.common_title_bar_right_tv);
    }

    private final ImageView getMImageLine() {
        return (ImageView) ViewKt.requireViewByIdCompat(this.f51456a, R.id.common_title_bar_line);
    }

    private final TextView getLeftText() {
        return (TextView) ViewKt.requireViewByIdCompat(this.f51456a, R.id.common_title_bar_left_tv);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalTitleBar2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(getContext(), R.layout.global_title_bar_layout2, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou…_title_bar_layout2, this)");
        this.f51456a = inflate;
        Integer valueOf = Integer.valueOf(ProductControllerStyleManager.getInstance().getProductThemeStyle().getTitleBarStyle().getCommonTitleBarTextSelecter());
        valueOf = !(valueOf.intValue() != 0) ? null : valueOf;
        if (valueOf != null) {
            ColorStateList colorStateList = ResourcesCompat.getColorStateList(getResources(), valueOf.intValue(), (Resources.Theme) null);
            getLeftText().setTextColor(colorStateList);
            getRightText().setTextColor(colorStateList);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalTitleBar2(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalTitleBar2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(getContext(), R.layout.global_title_bar_layout2, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou…_title_bar_layout2, this)");
        this.f51456a = inflate;
        Integer valueOf = Integer.valueOf(ProductControllerStyleManager.getInstance().getProductThemeStyle().getTitleBarStyle().getCommonTitleBarTextSelecter());
        valueOf = !(valueOf.intValue() != 0) ? null : valueOf;
        if (valueOf != null) {
            ColorStateList colorStateList = ResourcesCompat.getColorStateList(getResources(), valueOf.intValue(), (Resources.Theme) null);
            getLeftText().setTextColor(colorStateList);
            getRightText().setTextColor(colorStateList);
        }
    }

    public final void setTitle(int i) {
        TextView middleText = getMiddleText();
        middleText.setText(i);
        middleText.setVisibility(0);
    }

    public final void setTitle(String str) {
        TextView middleText = getMiddleText();
        middleText.setText(str);
        middleText.setVisibility(0);
    }

    public final void setRightText(int i) {
        TextView rightText = getRightText();
        rightText.setText(i);
        rightText.setVisibility(0);
    }

    public final void setRightText(String str) {
        TextView rightText = getRightText();
        rightText.setText(str);
        rightText.setVisibility(0);
    }

    public final void setRightText(int i, View.OnClickListener onClickListener) {
        View rightText = getRightText();
        if (onClickListener != null) {
            rightText.setOnClickListener(onClickListener);
        }
        TextView textView = (TextView) rightText;
        textView.setText(i);
        textView.setVisibility(0);
    }

    public final void setRightText(String str, View.OnClickListener onClickListener) {
        View rightText = getRightText();
        if (onClickListener != null) {
            rightText.setOnClickListener(onClickListener);
        }
        TextView textView = (TextView) rightText;
        textView.setText(str);
        textView.setVisibility(0);
    }

    public final void setLeftBackListener(View.OnClickListener onClickListener) {
        setLeftImage((int) R.drawable.common_title_bar_btn_back_selector, onClickListener);
    }

    public final void setLeftImage(int i, View.OnClickListener onClickListener) {
        View leftImage = getLeftImage();
        if (onClickListener != null) {
            leftImage.setOnClickListener(onClickListener);
        }
        ImageView imageView = (ImageView) leftImage;
        imageView.setImageResource(i);
        imageView.setVisibility(0);
    }

    public final void setLeftTv(int i, View.OnClickListener onClickListener) {
        View leftText = getLeftText();
        if (onClickListener != null) {
            leftText.setOnClickListener(onClickListener);
        }
        ((TextView) leftText).setVisibility(0);
        getLeftImage().setVisibility(8);
    }

    public final void setLeftImage(Drawable drawable, View.OnClickListener onClickListener) {
        View leftImage = getLeftImage();
        if (onClickListener != null) {
            leftImage.setOnClickListener(onClickListener);
        }
        ImageView imageView = (ImageView) leftImage;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        imageView.setVisibility(0);
    }

    public final void setLeftVisible(int i) {
        if (m36838a(i)) {
            getLeftImage().setVisibility(i);
        }
    }

    public final void setTitleLineVisible(int i) {
        if (m36838a(i)) {
            getMiddleText().setVisibility(i);
        }
    }

    public final void setRightVisible(int i) {
        if (m36838a(i)) {
            getRightText().setVisibility(i);
        }
    }

    public final void setTitleBarLineVisible(int i) {
        if (m36838a(i)) {
            getMImageLine().setVisibility(i);
        }
    }

    public final void setRightTextColor(int i) {
        getRightText().setTextColor(i);
    }

    public final void setRightClickListener(View.OnClickListener onClickListener) {
        getRightText().setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    private final <T extends View> void m36837a(T t, View.OnClickListener onClickListener, Function1<? super T, Unit> function1) {
        if (onClickListener != null) {
            t.setOnClickListener(onClickListener);
        }
        function1.invoke(t);
    }
}
