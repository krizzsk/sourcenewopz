package com.didi.rfusion.widget.searchbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.ext.RFViewExtKt;
import com.didi.rfusion.widget.RFEditText;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.loading.RFLottieLoadingView;
import com.didi.rfusion.widget.text.span.RFTypefaceSpan;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u0001:\u0001CB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0014\u0010*\u001a\u00020\n2\n\u0010+\u001a\u00020,\"\u00020-H\u0002J\u0006\u0010.\u001a\u00020\rJ\b\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020$H\u0002J\b\u00101\u001a\u00020$H\u0002J\u000e\u00102\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0010\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u000105J\u0010\u00103\u001a\u00020$2\b\b\u0001\u00106\u001a\u00020\u0007J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u0013J\u0010\u00109\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u000105J\u0010\u00109\u001a\u00020$2\b\b\u0001\u00106\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020\u0007J\u0010\u0010<\u001a\u00020$2\b\u0010=\u001a\u0004\u0018\u00010>J\u000e\u0010?\u001a\u00020$2\u0006\u0010=\u001a\u00020@J\u001a\u0010A\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u0001052\b\u0010=\u001a\u0004\u0018\u00010>J\b\u0010B\u001a\u00020$H\u0002R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0016R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000¨\u0006D"}, mo175978d2 = {"Lcom/didi/rfusion/widget/searchbar/RFSearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeIconInAnim", "Landroid/animation/ValueAnimator;", "closeIconOutAnim", "etContent", "Lcom/didi/rfusion/widget/RFEditText;", "flRight", "Landroid/widget/FrameLayout;", "gdBackground", "Landroid/graphics/drawable/GradientDrawable;", "value", "", "hasFocus", "setHasFocus", "(Z)V", "isLoading", "()Z", "setLoading", "ivBack", "Lcom/didi/rfusion/widget/RFIconView;", "ivClose", "llContainer", "Landroid/widget/LinearLayout;", "lvLoading", "Lcom/didi/rfusion/widget/loading/RFLottieLoadingView;", "tvAction", "Lcom/didi/rfusion/widget/RFTextView;", "addTextChangedListener", "", "watcher", "Landroid/text/TextWatcher;", "animateCloseIcon", "show", "checkState", "getAlphaAnimator", "values", "", "", "getEditText", "hideCloseIcon", "initAnimators", "initView", "removeTextChangedListener", "setContent", "text", "", "resId", "setEditable", "editable", "setHint", "setImeOption", "option", "setOnBackListener", "listener", "Landroid/view/View$OnClickListener;", "setOnEditActionListener", "Landroid/widget/TextView$OnEditorActionListener;", "setRightAction", "updateState", "Companion", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFSearchBar.kt */
public final class RFSearchBar extends ConstraintLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: m */
    private static final int f33683m = 0;

    /* renamed from: n */
    private static final int f33684n = 1;

    /* renamed from: o */
    private static final int f33685o = 2;

    /* renamed from: p */
    private static final int f33686p = 3;

    /* renamed from: q */
    private static final long f33687q = 100;

    /* renamed from: a */
    private RFIconView f33688a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RFEditText f33689b;

    /* renamed from: c */
    private LinearLayout f33690c;

    /* renamed from: d */
    private FrameLayout f33691d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public RFIconView f33692e;

    /* renamed from: f */
    private RFLottieLoadingView f33693f;

    /* renamed from: g */
    private RFTextView f33694g;

    /* renamed from: h */
    private GradientDrawable f33695h;

    /* renamed from: i */
    private ValueAnimator f33696i;

    /* renamed from: j */
    private ValueAnimator f33697j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f33698k;

    /* renamed from: l */
    private boolean f33699l;

    /* renamed from: r */
    private HashMap f33700r;

    public RFSearchBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFSearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33700r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33700r == null) {
            this.f33700r = new HashMap();
        }
        View view = (View) this.f33700r.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33700r.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ RFEditText access$getEtContent$p(RFSearchBar rFSearchBar) {
        RFEditText rFEditText = rFSearchBar.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        return rFEditText;
    }

    public static final /* synthetic */ RFIconView access$getIvClose$p(RFSearchBar rFSearchBar) {
        RFIconView rFIconView = rFSearchBar.f33692e;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClose");
        }
        return rFIconView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFSearchBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFSearchBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        ConstraintLayout.inflate(context, R.layout.rf_search_bar, this);
        m23722a();
        m23724b();
        m23726d();
    }

    /* access modifiers changed from: private */
    public final void setHasFocus(boolean z) {
        this.f33698k = z;
        m23726d();
    }

    public final boolean isLoading() {
        return this.f33699l;
    }

    public final void setLoading(boolean z) {
        this.f33699l = z;
        m23726d();
    }

    /* renamed from: a */
    private final void m23722a() {
        View findViewById = findViewById(R.id.rf_iv_back);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.rf_iv_back)");
        this.f33688a = (RFIconView) findViewById;
        View findViewById2 = findViewById(R.id.rf_et_content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.rf_et_content)");
        this.f33689b = (RFEditText) findViewById2;
        View findViewById3 = findViewById(R.id.rf_ll_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.rf_ll_container)");
        this.f33690c = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.rf_fl_right);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.rf_fl_right)");
        this.f33691d = (FrameLayout) findViewById4;
        View findViewById5 = findViewById(R.id.rf_iv_close);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.rf_iv_close)");
        this.f33692e = (RFIconView) findViewById5;
        View findViewById6 = findViewById(R.id.rf_llv_loading);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.rf_llv_loading)");
        this.f33693f = (RFLottieLoadingView) findViewById6;
        View findViewById7 = findViewById(R.id.rf_tv_action);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "findViewById(R.id.rf_tv_action)");
        this.f33694g = (RFTextView) findViewById7;
        setBackgroundColor(RFResUtils.getColor(getContext(), R.color.rf_color_white_100_FFFFFF));
        int dimens = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_24);
        setPadding(dimens, dimens, dimens, dimens);
        Drawable drawable = RFResUtils.getDrawable(getContext(), R.drawable.rf_bg_search_bar);
        if (drawable != null) {
            this.f33695h = (GradientDrawable) drawable;
            RFEditText rFEditText = this.f33689b;
            if (rFEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etContent");
            }
            rFEditText.setOnFocusChangeListener(new RFSearchBar$initView$1(this));
            RFEditText rFEditText2 = this.f33689b;
            if (rFEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etContent");
            }
            rFEditText2.addTextChangedListener(new RFSearchBar$initView$2(this));
            RFIconView rFIconView = this.f33692e;
            if (rFIconView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivClose");
            }
            rFIconView.setOnClickListener(new RFSearchBar$initView$3(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    /* renamed from: b */
    private final void m23724b() {
        ValueAnimator a = m23721a(0.0f, 1.0f);
        this.f33696i = a;
        if (a == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIconInAnim");
        }
        a.addListener(new RFSearchBar$initAnimators$1(this));
        ValueAnimator a2 = m23721a(1.0f, 0.0f);
        this.f33697j = a2;
        if (a2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIconOutAnim");
        }
        a2.addListener(new RFSearchBar$initAnimators$2(this));
    }

    /* renamed from: a */
    private final void m23723a(boolean z) {
        if (z) {
            ValueAnimator valueAnimator = this.f33696i;
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeIconInAnim");
            }
            if (!valueAnimator.isRunning()) {
                RFIconView rFIconView = this.f33692e;
                if (rFIconView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivClose");
                }
                if (!RFViewExtKt.isVisible(rFIconView)) {
                    ValueAnimator valueAnimator2 = this.f33697j;
                    if (valueAnimator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeIconOutAnim");
                    }
                    valueAnimator2.cancel();
                    ValueAnimator valueAnimator3 = this.f33696i;
                    if (valueAnimator3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeIconInAnim");
                    }
                    valueAnimator3.start();
                    return;
                }
                return;
            }
        }
        if (!z) {
            RFIconView rFIconView2 = this.f33692e;
            if (rFIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivClose");
            }
            if (RFViewExtKt.isVisible(rFIconView2)) {
                ValueAnimator valueAnimator4 = this.f33696i;
                if (valueAnimator4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("closeIconInAnim");
                }
                valueAnimator4.cancel();
                ValueAnimator valueAnimator5 = this.f33697j;
                if (valueAnimator5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("closeIconOutAnim");
                }
                valueAnimator5.start();
            }
        }
    }

    /* renamed from: c */
    private final void m23725c() {
        RFIconView rFIconView = this.f33692e;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClose");
        }
        rFIconView.setVisibility(8);
        ValueAnimator valueAnimator = this.f33696i;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIconInAnim");
        }
        valueAnimator.cancel();
        ValueAnimator valueAnimator2 = this.f33697j;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIconOutAnim");
        }
        valueAnimator2.cancel();
    }

    /* renamed from: a */
    private final ValueAnimator m23721a(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Arrays.copyOf(fArr, fArr.length));
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "animator");
        ofFloat.setInterpolator(RFAnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100);
        ofFloat.addUpdateListener(new RFSearchBar$getAlphaAnimator$1(this));
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m23726d() {
        int e = m23727e();
        int i = 8;
        if (e == 0) {
            GradientDrawable gradientDrawable = this.f33695h;
            if (gradientDrawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gdBackground");
            }
            gradientDrawable.setColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_15_0_0D000000));
            RFTextView rFTextView = this.f33694g;
            if (rFTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAction");
            }
            RFTextView rFTextView2 = this.f33694g;
            if (rFTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAction");
            }
            if (!TextUtils.isEmpty(rFTextView2.getText())) {
                i = 0;
            }
            rFTextView.setVisibility(i);
            RFLottieLoadingView rFLottieLoadingView = this.f33693f;
            if (rFLottieLoadingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lvLoading");
            }
            rFLottieLoadingView.hide();
            m23725c();
        } else if (e == 1) {
            GradientDrawable gradientDrawable2 = this.f33695h;
            if (gradientDrawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gdBackground");
            }
            gradientDrawable2.setColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_14_0_1A000000));
            RFLottieLoadingView rFLottieLoadingView2 = this.f33693f;
            if (rFLottieLoadingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lvLoading");
            }
            rFLottieLoadingView2.hide();
            RFTextView rFTextView3 = this.f33694g;
            if (rFTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAction");
            }
            rFTextView3.setVisibility(8);
            RFEditText rFEditText = this.f33689b;
            if (rFEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etContent");
            }
            Editable text = rFEditText.getText();
            m23723a(!TextUtils.isEmpty(text != null ? text.toString() : null));
        } else if (e == 2) {
            GradientDrawable gradientDrawable3 = this.f33695h;
            if (gradientDrawable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gdBackground");
            }
            gradientDrawable3.setColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_14_0_1A000000));
            RFTextView rFTextView4 = this.f33694g;
            if (rFTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAction");
            }
            rFTextView4.setVisibility(8);
            m23725c();
            RFLottieLoadingView rFLottieLoadingView3 = this.f33693f;
            if (rFLottieLoadingView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lvLoading");
            }
            rFLottieLoadingView3.show();
        } else if (e == 3) {
            GradientDrawable gradientDrawable4 = this.f33695h;
            if (gradientDrawable4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gdBackground");
            }
            gradientDrawable4.setColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_15_0_0D000000));
            RFTextView rFTextView5 = this.f33694g;
            if (rFTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAction");
            }
            rFTextView5.setVisibility(8);
            RFLottieLoadingView rFLottieLoadingView4 = this.f33693f;
            if (rFLottieLoadingView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lvLoading");
            }
            rFLottieLoadingView4.hide();
            m23725c();
        }
        LinearLayout linearLayout = this.f33690c;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContainer");
        }
        GradientDrawable gradientDrawable5 = this.f33695h;
        if (gradientDrawable5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gdBackground");
        }
        linearLayout.setBackground(gradientDrawable5);
    }

    /* renamed from: e */
    private final int m23727e() {
        if (this.f33699l) {
            return 2;
        }
        if (this.f33698k) {
            return 1;
        }
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        Editable text = rFEditText.getText();
        return !TextUtils.isEmpty(text != null ? text.toString() : null) ? 3 : 0;
    }

    public final void setOnBackListener(View.OnClickListener onClickListener) {
        RFIconView rFIconView = this.f33688a;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
        }
        rFIconView.setVisibility(onClickListener == null ? 8 : 0);
        RFIconView rFIconView2 = this.f33688a;
        if (rFIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
        }
        rFIconView2.setOnClickListener(onClickListener);
    }

    public final void setEditable(boolean z) {
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        rFEditText.setFocusableInTouchMode(z);
        RFEditText rFEditText2 = this.f33689b;
        if (rFEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        rFEditText2.setFocusable(z);
    }

    public final void setImeOption(int i) {
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        rFEditText.setImeOptions(i);
    }

    public final void setOnEditActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        Intrinsics.checkParameterIsNotNull(onEditorActionListener, "listener");
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        rFEditText.setOnEditorActionListener(onEditorActionListener);
    }

    public final void setHint(int i) {
        setHint((CharSequence) RFResUtils.getString(getContext(), i));
    }

    public final void setHint(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new RFTypefaceSpan(context, 3), 0, spannableString.length(), 17);
            charSequence = spannableString;
        }
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        rFEditText.setHint(charSequence);
    }

    public final void setContent(int i) {
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        rFEditText.setText(i);
    }

    public final void setContent(CharSequence charSequence) {
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        rFEditText.setText(charSequence, TextView.BufferType.EDITABLE);
    }

    public final void setRightAction(CharSequence charSequence, View.OnClickListener onClickListener) {
        RFTextView rFTextView = this.f33694g;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAction");
        }
        rFTextView.setText(charSequence);
        RFTextView rFTextView2 = this.f33694g;
        if (rFTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAction");
        }
        rFTextView2.setOnClickListener(onClickListener);
        m23726d();
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        Intrinsics.checkParameterIsNotNull(textWatcher, "watcher");
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        rFEditText.addTextChangedListener(textWatcher);
    }

    public final void removeTextChangedListener(TextWatcher textWatcher) {
        Intrinsics.checkParameterIsNotNull(textWatcher, "watcher");
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        rFEditText.removeTextChangedListener(textWatcher);
    }

    public final RFEditText getEditText() {
        RFEditText rFEditText = this.f33689b;
        if (rFEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etContent");
        }
        return rFEditText;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/rfusion/widget/searchbar/RFSearchBar$Companion;", "", "()V", "ANIMATION_FADE_DURATION", "", "STATE_DEFAULT", "", "STATE_FINISH", "STATE_INPUT", "STATE_LOADING", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFSearchBar.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
