package com.didi.rfusion.widget.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.titlebar.RFTitleBar;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\b\b\u0001\u0010\u001e\u001a\u00020\u001fJ%\u0010 \u001a\u00020\u00112\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\"0!\"\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didi/rfusion/widget/titlebar/RFAbbreviateTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/rfusion/widget/titlebar/RFTitleBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivIcon", "Lcom/didi/rfusion/widget/RFIconView;", "stbWhole", "Lcom/didi/rfusion/widget/titlebar/RFStandardTitleBar;", "getTitle", "", "initView", "", "setBackgroundColor", "color", "setFitSystemWindow", "fitable", "", "setLeftIcon", "icon", "", "listener", "Landroid/view/View$OnClickListener;", "setOnCloseListener", "setProgress", "progress", "", "setRightButton", "", "Lcom/didi/rfusion/widget/titlebar/RFMenuAttr;", "([Lcom/didi/rfusion/widget/titlebar/RFMenuAttr;)V", "setTextColor", "setTitle", "text", "strRes", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFAbbreviateTitleBar.kt */
public final class RFAbbreviateTitleBar extends ConstraintLayout implements RFTitleBar {

    /* renamed from: a */
    private RFStandardTitleBar f33945a;

    /* renamed from: b */
    private RFIconView f33946b;

    /* renamed from: c */
    private HashMap f33947c;

    public RFAbbreviateTitleBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFAbbreviateTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33947c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33947c == null) {
            this.f33947c = new HashMap();
        }
        View view = (View) this.f33947c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33947c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFAbbreviateTitleBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFAbbreviateTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        ConstraintLayout.inflate(context, R.layout.rf_title_bar_abbreviate, this);
        m23965a();
    }

    /* renamed from: a */
    private final void m23965a() {
        View findViewById = findViewById(R.id.rf_stb_whole);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.rf_stb_whole)");
        this.f33945a = (RFStandardTitleBar) findViewById;
        View findViewById2 = findViewById(R.id.rf_iv_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.rf_iv_icon)");
        this.f33946b = (RFIconView) findViewById2;
        setBackgroundColor(RFResUtils.getColor(getContext(), R.color.rf_color_white_100_FFFFFF));
        RFTitleBar.DefaultImpls.setLeftIcon$default(this, RFResUtils.getString(getContext(), R.string.rf_icon_back), (View.OnClickListener) null, 2, (Object) null);
        setProgress(0.0f);
    }

    public void setBackgroundColor(int i) {
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        rFStandardTitleBar.setBackgroundColor(i);
    }

    public void setFitSystemWindow(boolean z) {
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        rFStandardTitleBar.setFitSystemWindow(z);
    }

    public void setTitle(int i) {
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        rFStandardTitleBar.setTitle(i);
    }

    public void setTitle(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        rFStandardTitleBar.setTitle(charSequence);
    }

    public CharSequence getTitle() {
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        return rFStandardTitleBar.getTitle();
    }

    public void setLeftIcon(String str, View.OnClickListener onClickListener) {
        if (str == null) {
            str = RFResUtils.getString(getContext(), R.string.rf_icon_back);
        }
        RFIconView rFIconView = this.f33946b;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        }
        rFIconView.setText(str);
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        RFTitleBar.DefaultImpls.setLeftIcon$default(rFStandardTitleBar, str, (View.OnClickListener) null, 2, (Object) null);
        RFIconView rFIconView2 = this.f33946b;
        if (rFIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        }
        rFIconView2.setOnClickListener(onClickListener);
    }

    public void setRightButton(RFMenuAttr... rFMenuAttrArr) {
        Intrinsics.checkParameterIsNotNull(rFMenuAttrArr, RavenKey.ATTRS);
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        rFStandardTitleBar.setRightButton((RFMenuAttr[]) Arrays.copyOf(rFMenuAttrArr, rFMenuAttrArr.length));
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        rFStandardTitleBar.setOnCloseListener(onClickListener);
    }

    public void setTextColor(int i) {
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        rFStandardTitleBar.setTextColor(i);
    }

    public final void setProgress(float f) {
        RFStandardTitleBar rFStandardTitleBar = this.f33945a;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stbWhole");
        }
        rFStandardTitleBar.setAlpha(f);
        RFIconView rFIconView = this.f33946b;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        }
        rFIconView.setAlpha(1.0f - f);
    }
}
