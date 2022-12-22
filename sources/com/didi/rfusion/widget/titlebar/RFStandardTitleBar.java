package com.didi.rfusion.widget.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.RFSystemBarUtils;
import com.didi.rfusion.utils.ext.RFViewExtKt;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0001J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\bH\u0002J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0002J\u0015\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0000¢\u0006\u0002\b'J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0016J\u001c\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J%\u00101\u001a\u00020\u00192\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0016¢\u0006\u0002\u00104J\u0012\u00105\u001a\u00020\u00192\b\b\u0001\u00106\u001a\u00020\bH\u0016J\u0010\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020$H\u0016J\u0010\u00107\u001a\u00020\u00192\u0006\u00109\u001a\u00020\bH\u0016J\b\u0010:\u001a\u00020\u0019H\u0002J\u0012\u0010;\u001a\u00020\u00192\b\b\u0001\u00106\u001a\u00020\bH\u0002J\b\u0010<\u001a\u00020\u0019H\u0002R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000¨\u0006="}, mo175978d2 = {"Lcom/didi/rfusion/widget/titlebar/RFStandardTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/rfusion/widget/titlebar/RFTitleBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivCloseIcon", "Lcom/didi/rfusion/widget/RFIconView;", "ivLeftIcon", "llLeftIconContainer", "Landroid/widget/LinearLayout;", "llRightBtnContainer", "Landroidx/appcompat/widget/LinearLayoutCompat;", "llTitleBarContainer", "llTitleContainer", "tvTitle", "Lcom/didi/rfusion/widget/RFTextView;", "viewLeftIconSpace", "Landroid/view/View;", "viewStatusBar", "addTitleView", "", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "createIconView", "attr", "Lcom/didi/rfusion/widget/titlebar/RFIconMenuAttr;", "createTextView", "Lcom/didi/rfusion/widget/titlebar/RFTextMenuAttr;", "getTextColor", "getTitle", "", "initView", "removeTitleView", "removeTitleView$r_fusion_ninePhoneRelease", "setFitSystemWindow", "fitable", "", "setLeftIcon", "icon", "", "listener", "Landroid/view/View$OnClickListener;", "setOnCloseListener", "setRightButton", "", "Lcom/didi/rfusion/widget/titlebar/RFMenuAttr;", "([Lcom/didi/rfusion/widget/titlebar/RFMenuAttr;)V", "setTextColor", "color", "setTitle", "text", "strRes", "updateLeftContainer", "updateRightButton", "updateRightContainer", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFStandardTitleBar.kt */
public final class RFStandardTitleBar extends ConstraintLayout implements RFTitleBar {

    /* renamed from: a */
    private View f33955a;

    /* renamed from: b */
    private LinearLayout f33956b;

    /* renamed from: c */
    private LinearLayout f33957c;

    /* renamed from: d */
    private View f33958d;

    /* renamed from: e */
    private RFIconView f33959e;

    /* renamed from: f */
    private RFIconView f33960f;

    /* renamed from: g */
    private RFTextView f33961g;

    /* renamed from: h */
    private LinearLayout f33962h;

    /* renamed from: i */
    private LinearLayoutCompat f33963i;

    /* renamed from: j */
    private HashMap f33964j;

    public RFStandardTitleBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFStandardTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33964j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33964j == null) {
            this.f33964j = new HashMap();
        }
        View view = (View) this.f33964j.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33964j.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFStandardTitleBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFStandardTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        ConstraintLayout.inflate(context, R.layout.rf_title_bar_standard, this);
        m23969a();
        int statusBarHeight = RFSystemBarUtils.getStatusBarHeight(context);
        View view = this.f33955a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewStatusBar");
        }
        view.getLayoutParams().height = statusBarHeight;
        setBackgroundColor(RFResUtils.getColor(context, R.color.rf_color_white_100_FFFFFF));
        setTextColor(RFResUtils.getColor(context, R.color.rf_color_gery_1_0_000000));
        m23971b();
    }

    /* renamed from: a */
    private final void m23969a() {
        View findViewById = findViewById(R.id.rf_view_status_bar);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.rf_view_status_bar)");
        this.f33955a = findViewById;
        View findViewById2 = findViewById(R.id.rf_iv_left_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.rf_iv_left_icon)");
        this.f33959e = (RFIconView) findViewById2;
        View findViewById3 = findViewById(R.id.rf_iv_close);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.rf_iv_close)");
        this.f33960f = (RFIconView) findViewById3;
        View findViewById4 = findViewById(R.id.rf_tv_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.rf_tv_title)");
        this.f33961g = (RFTextView) findViewById4;
        View findViewById5 = findViewById(R.id.rf_ll_title_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.rf_ll_title_container)");
        this.f33962h = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.rf_ll_left_icon_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.rf_ll_left_icon_container)");
        this.f33957c = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.rf_view_left_icon_space);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "findViewById(R.id.rf_view_left_icon_space)");
        this.f33958d = findViewById7;
        View findViewById8 = findViewById(R.id.rf_ll_title_bar_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "findViewById(R.id.rf_ll_title_bar_container)");
        this.f33956b = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.rf_ll_right_button_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "findViewById(R.id.rf_ll_right_button_container)");
        this.f33963i = (LinearLayoutCompat) findViewById9;
    }

    public void setTextColor(int i) {
        RFIconView rFIconView = this.f33959e;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivLeftIcon");
        }
        rFIconView.setTextColor(i);
        RFIconView rFIconView2 = this.f33960f;
        if (rFIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCloseIcon");
        }
        rFIconView2.setTextColor(i);
        RFTextView rFTextView = this.f33961g;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        rFTextView.setTextColor(i);
        m23970a(i);
    }

    private final int getTextColor() {
        RFTextView rFTextView = this.f33961g;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        return rFTextView.getCurrentTextColor();
    }

    /* renamed from: a */
    private final void m23970a(int i) {
        LinearLayoutCompat linearLayoutCompat = this.f33963i;
        if (linearLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRightBtnContainer");
        }
        int childCount = linearLayoutCompat.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            LinearLayoutCompat linearLayoutCompat2 = this.f33963i;
            if (linearLayoutCompat2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llRightBtnContainer");
            }
            View childAt = linearLayoutCompat2.getChildAt(i2);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(i);
            }
        }
    }

    public void setFitSystemWindow(boolean z) {
        View view = this.f33955a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewStatusBar");
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void setTitle(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        RFTextView rFTextView = this.f33961g;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        rFTextView.setText(charSequence);
    }

    public void setTitle(int i) {
        RFTextView rFTextView = this.f33961g;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        rFTextView.setText(RFResUtils.getString(getContext(), i));
    }

    public CharSequence getTitle() {
        RFTextView rFTextView = this.f33961g;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        return rFTextView.getText();
    }

    public void setLeftIcon(String str, View.OnClickListener onClickListener) {
        if (str != null) {
            RFIconView rFIconView = this.f33959e;
            if (rFIconView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivLeftIcon");
            }
            rFIconView.setVisibility(0);
            RFIconView rFIconView2 = this.f33959e;
            if (rFIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivLeftIcon");
            }
            rFIconView2.setText(str);
        } else {
            RFIconView rFIconView3 = this.f33959e;
            if (rFIconView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivLeftIcon");
            }
            rFIconView3.setVisibility(8);
        }
        RFIconView rFIconView4 = this.f33959e;
        if (rFIconView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivLeftIcon");
        }
        rFIconView4.setOnClickListener(onClickListener);
        m23971b();
    }

    public void setRightButton(RFMenuAttr... rFMenuAttrArr) {
        Intrinsics.checkParameterIsNotNull(rFMenuAttrArr, RavenKey.ATTRS);
        LinearLayoutCompat linearLayoutCompat = this.f33963i;
        if (linearLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRightBtnContainer");
        }
        linearLayoutCompat.removeAllViews();
        for (RFIconMenuAttr rFIconMenuAttr : rFMenuAttrArr) {
            if (rFIconMenuAttr instanceof RFIconMenuAttr) {
                LinearLayoutCompat linearLayoutCompat2 = this.f33963i;
                if (linearLayoutCompat2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llRightBtnContainer");
                }
                linearLayoutCompat2.addView(m23967a(rFIconMenuAttr));
            } else if (rFIconMenuAttr instanceof RFTextMenuAttr) {
                LinearLayoutCompat linearLayoutCompat3 = this.f33963i;
                if (linearLayoutCompat3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llRightBtnContainer");
                }
                linearLayoutCompat3.addView(m23968a((RFTextMenuAttr) rFIconMenuAttr));
            }
        }
        m23972c();
    }

    /* renamed from: a */
    private final View m23968a(RFTextMenuAttr rFTextMenuAttr) {
        RFTextView rFTextView = new RFTextView(getContext());
        rFTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        rFTextView.setGravity(17);
        rFTextView.setText(rFTextMenuAttr.getText());
        rFTextView.setTextSize(0, RFResUtils.getDimens(rFTextView.getContext(), R.dimen.f_07_app_36_pad_24));
        rFTextView.setTextColor(getTextColor());
        rFTextView.setOnClickListener(rFTextMenuAttr.getListener());
        return rFTextView;
    }

    /* renamed from: a */
    private final View m23967a(RFIconMenuAttr rFIconMenuAttr) {
        RFIconView rFIconView = new RFIconView(getContext());
        rFIconView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        rFIconView.setGravity(17);
        rFIconView.setText(rFIconMenuAttr.getIcon());
        rFIconView.setTextSize(0, RFResUtils.getDimens(rFIconView.getContext(), R.dimen.rf_dimen_48));
        rFIconView.setTextColor(getTextColor());
        rFIconView.setOnClickListener(rFIconMenuAttr.getListener());
        return rFIconView;
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        RFIconView rFIconView = this.f33960f;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCloseIcon");
        }
        rFIconView.setVisibility(onClickListener != null ? 0 : 8);
        RFIconView rFIconView2 = this.f33960f;
        if (rFIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCloseIcon");
        }
        rFIconView2.setOnClickListener(onClickListener);
        m23971b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b7  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m23971b() {
        /*
            r9 = this;
            com.didi.rfusion.widget.RFIconView r0 = r9.f33959e
            java.lang.String r1 = "ivLeftIcon"
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0009:
            android.view.View r0 = (android.view.View) r0
            boolean r0 = com.didi.rfusion.utils.ext.RFViewExtKt.isVisible(r0)
            java.lang.String r2 = "ivCloseIcon"
            java.lang.String r3 = "viewLeftIconSpace"
            r4 = 0
            java.lang.String r5 = "llLeftIconContainer"
            if (r0 == 0) goto L_0x003c
            com.didi.rfusion.widget.RFIconView r0 = r9.f33960f
            if (r0 != 0) goto L_0x001f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x001f:
            android.view.View r0 = (android.view.View) r0
            boolean r0 = com.didi.rfusion.utils.ext.RFViewExtKt.isVisible(r0)
            if (r0 == 0) goto L_0x003c
            android.widget.LinearLayout r0 = r9.f33957c
            if (r0 != 0) goto L_0x002e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x002e:
            r0.setVisibility(r4)
            android.view.View r0 = r9.f33958d
            if (r0 != 0) goto L_0x0038
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0038:
            r0.setVisibility(r4)
            goto L_0x0086
        L_0x003c:
            com.didi.rfusion.widget.RFIconView r0 = r9.f33959e
            if (r0 != 0) goto L_0x0043
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0043:
            android.view.View r0 = (android.view.View) r0
            boolean r0 = com.didi.rfusion.utils.ext.RFViewExtKt.isVisible(r0)
            r1 = 8
            if (r0 != 0) goto L_0x0072
            com.didi.rfusion.widget.RFIconView r0 = r9.f33960f
            if (r0 != 0) goto L_0x0054
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0054:
            android.view.View r0 = (android.view.View) r0
            boolean r0 = com.didi.rfusion.utils.ext.RFViewExtKt.isVisible(r0)
            if (r0 == 0) goto L_0x005d
            goto L_0x0072
        L_0x005d:
            android.widget.LinearLayout r0 = r9.f33957c
            if (r0 != 0) goto L_0x0064
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x0064:
            r0.setVisibility(r1)
            android.view.View r0 = r9.f33958d
            if (r0 != 0) goto L_0x006e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x006e:
            r0.setVisibility(r1)
            goto L_0x0086
        L_0x0072:
            android.widget.LinearLayout r0 = r9.f33957c
            if (r0 != 0) goto L_0x0079
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x0079:
            r0.setVisibility(r4)
            android.view.View r0 = r9.f33958d
            if (r0 != 0) goto L_0x0083
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0083:
            r0.setVisibility(r1)
        L_0x0086:
            android.widget.LinearLayout r0 = r9.f33957c
            if (r0 != 0) goto L_0x008d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x008d:
            android.view.View r0 = (android.view.View) r0
            boolean r0 = com.didi.rfusion.utils.ext.RFViewExtKt.isVisible(r0)
            java.lang.String r1 = "llTitleBarContainer"
            if (r0 == 0) goto L_0x00b7
            android.widget.LinearLayout r0 = r9.f33956b
            if (r0 != 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x009e:
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            r0 = 2131167534(0x7f07092e, float:1.7949344E38)
            float r0 = com.didi.rfusion.utils.RFResUtils.getDimens(r0)
            int r0 = (int) r0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 14
            r8 = 0
            com.didi.rfusion.utils.ext.RFViewExtKt.setPadding$default(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x00d6
        L_0x00b7:
            android.widget.LinearLayout r0 = r9.f33956b
            if (r0 != 0) goto L_0x00be
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00be:
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            r0 = 2131167837(0x7f070a5d, float:1.7949959E38)
            float r0 = com.didi.rfusion.utils.RFResUtils.getDimens(r0)
            int r0 = (int) r0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 14
            r8 = 0
            com.didi.rfusion.utils.ext.RFViewExtKt.setPadding$default(r2, r3, r4, r5, r6, r7, r8)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.titlebar.RFStandardTitleBar.m23971b():void");
    }

    /* renamed from: c */
    private final void m23972c() {
        LinearLayoutCompat linearLayoutCompat = this.f33963i;
        if (linearLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRightBtnContainer");
        }
        if (linearLayoutCompat.getChildCount() > 0) {
            LinearLayout linearLayout = this.f33956b;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llTitleBarContainer");
            }
            RFViewExtKt.setPadding$default(linearLayout, (Integer) null, (Integer) null, Integer.valueOf((int) RFResUtils.getDimens(R.dimen.rf_dimen_24)), (Integer) null, 11, (Object) null);
            return;
        }
        LinearLayout linearLayout2 = this.f33956b;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llTitleBarContainer");
        }
        RFViewExtKt.setPadding$default(linearLayout2, (Integer) null, (Integer) null, Integer.valueOf((int) RFResUtils.getDimens(R.dimen.rf_dimen_32)), (Integer) null, 11, (Object) null);
    }

    public final void addTitleView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(layoutParams, "params");
        LinearLayout linearLayout = this.f33962h;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llTitleContainer");
        }
        linearLayout.addView(view, layoutParams);
    }

    public final void removeTitleView$r_fusion_ninePhoneRelease(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        LinearLayout linearLayout = this.f33962h;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llTitleContainer");
        }
        linearLayout.removeView(view);
    }
}
