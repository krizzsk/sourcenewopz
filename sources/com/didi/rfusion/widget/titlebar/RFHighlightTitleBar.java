package com.didi.rfusion.widget.titlebar;

import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.utils.RFFontUtils;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.titlebar.tools.RFCollapsingTitleBarLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J%\u0010\u001e\u001a\u00020\u00112\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010 0\u001f\"\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u000fH\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0014H\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/rfusion/widget/titlebar/RFHighlightTitleBar;", "Lcom/google/android/material/appbar/AppBarLayout;", "Lcom/didi/rfusion/widget/titlebar/RFTitleBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ctlLayout", "Lcom/didi/rfusion/widget/titlebar/tools/RFCollapsingTitleBarLayout;", "stlTitleBar", "Lcom/didi/rfusion/widget/titlebar/RFStandardTitleBar;", "viewDivider", "Landroid/view/View;", "getTitle", "", "initView", "", "setBackgroundColor", "color", "", "setFitSystemWindow", "fitable", "", "setLeftIcon", "icon", "", "listener", "Landroid/view/View$OnClickListener;", "setOnCloseListener", "setRightButton", "", "Lcom/didi/rfusion/widget/titlebar/RFMenuAttr;", "([Lcom/didi/rfusion/widget/titlebar/RFMenuAttr;)V", "setTextColor", "setTitle", "text", "strRes", "Companion", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFHighlightTitleBar.kt */
public final class RFHighlightTitleBar extends AppBarLayout implements RFTitleBar {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final String f33948d = "RFHighlightTitleBar";

    /* renamed from: a */
    private RFCollapsingTitleBarLayout f33949a;

    /* renamed from: b */
    private RFStandardTitleBar f33950b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f33951c;

    /* renamed from: e */
    private HashMap f33952e;

    public RFHighlightTitleBar(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33952e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33952e == null) {
            this.f33952e = new HashMap();
        }
        View view = (View) this.f33952e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33952e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void setFitSystemWindow(boolean z) {
    }

    public static final /* synthetic */ View access$getViewDivider$p(RFHighlightTitleBar rFHighlightTitleBar) {
        View view = rFHighlightTitleBar.f33951c;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDivider");
        }
        return view;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFHighlightTitleBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFHighlightTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        AppBarLayout.inflate(context, R.layout.rf_title_bar_highlight, this);
        setOrientation(1);
        m23966a();
        setBackgroundColor(RFResUtils.getColor(context, R.color.rf_color_white_100_FFFFFF));
        if (Build.VERSION.SDK_INT >= 21) {
            setStateListAnimator((StateListAnimator) null);
        }
        RFCollapsingTitleBarLayout rFCollapsingTitleBarLayout = this.f33949a;
        if (rFCollapsingTitleBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ctlLayout");
        }
        rFCollapsingTitleBarLayout.setCollapsedTitleTypeface(RFFontUtils.getFontTypeFace(context, 1));
        RFCollapsingTitleBarLayout rFCollapsingTitleBarLayout2 = this.f33949a;
        if (rFCollapsingTitleBarLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ctlLayout");
        }
        rFCollapsingTitleBarLayout2.setCollapsingTextSize(RFResUtils.getDimens(context, R.dimen.f_07_app_36_pad_24));
        RFCollapsingTitleBarLayout rFCollapsingTitleBarLayout3 = this.f33949a;
        if (rFCollapsingTitleBarLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ctlLayout");
        }
        rFCollapsingTitleBarLayout3.setExpandedTextSize(RFResUtils.getDimens(context, R.dimen.f_04_app_48_pad_32));
        RFCollapsingTitleBarLayout rFCollapsingTitleBarLayout4 = this.f33949a;
        if (rFCollapsingTitleBarLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ctlLayout");
        }
        rFCollapsingTitleBarLayout4.setExpandedTitleTypeface(RFFontUtils.getFontTypeFace(context, 1));
        addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener(this) {
            final /* synthetic */ RFHighlightTitleBar this$0;

            {
                this.this$0 = r1;
            }

            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                RFHighlightTitleBar.access$getViewDivider$p(this.this$0).setAlpha((((float) Math.min(Math.abs(i), this.this$0.getTotalScrollRange())) * 1.0f) / ((float) this.this$0.getTotalScrollRange()));
            }
        });
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/rfusion/widget/titlebar/RFHighlightTitleBar$Companion;", "", "()V", "TAG", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFHighlightTitleBar.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private final void m23966a() {
        View findViewById = findViewById(R.id.rf_ctl_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.rf_ctl_layout)");
        this.f33949a = (RFCollapsingTitleBarLayout) findViewById;
        View findViewById2 = findViewById(R.id.rf_stb_title_bar);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.rf_stb_title_bar)");
        this.f33950b = (RFStandardTitleBar) findViewById2;
        View findViewById3 = findViewById(R.id.rf_view_divider);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.rf_view_divider)");
        this.f33951c = findViewById3;
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        RFStandardTitleBar rFStandardTitleBar = this.f33950b;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stlTitleBar");
        }
        rFStandardTitleBar.setBackgroundColor(i);
    }

    public void setTitle(int i) {
        RFStandardTitleBar rFStandardTitleBar = this.f33950b;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stlTitleBar");
        }
        rFStandardTitleBar.setTitle(i);
    }

    public void setTitle(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        RFStandardTitleBar rFStandardTitleBar = this.f33950b;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stlTitleBar");
        }
        rFStandardTitleBar.setTitle(charSequence);
    }

    public CharSequence getTitle() {
        RFStandardTitleBar rFStandardTitleBar = this.f33950b;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stlTitleBar");
        }
        return rFStandardTitleBar.getTitle();
    }

    public void setLeftIcon(String str, View.OnClickListener onClickListener) {
        RFStandardTitleBar rFStandardTitleBar = this.f33950b;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stlTitleBar");
        }
        rFStandardTitleBar.setLeftIcon(str, onClickListener);
    }

    public void setRightButton(RFMenuAttr... rFMenuAttrArr) {
        Intrinsics.checkParameterIsNotNull(rFMenuAttrArr, RavenKey.ATTRS);
        RFStandardTitleBar rFStandardTitleBar = this.f33950b;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stlTitleBar");
        }
        rFStandardTitleBar.setRightButton((RFMenuAttr[]) Arrays.copyOf(rFMenuAttrArr, rFMenuAttrArr.length));
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        RFStandardTitleBar rFStandardTitleBar = this.f33950b;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stlTitleBar");
        }
        rFStandardTitleBar.setOnCloseListener(onClickListener);
    }

    public void setTextColor(int i) {
        RFStandardTitleBar rFStandardTitleBar = this.f33950b;
        if (rFStandardTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stlTitleBar");
        }
        rFStandardTitleBar.setTextColor(i);
    }
}
