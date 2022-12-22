package com.didi.soda.business.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.blocks.widget.image.BackgroundHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010J\u001a\u00020KJ\b\u0010L\u001a\u00020\u001fH\u0002J\u0006\u0010M\u001a\u00020KJ\u0006\u0010N\u001a\u00020KJ\b\u0010O\u001a\u00020KH\u0002J(\u0010P\u001a\u00020K2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\t2\u000e\b\u0002\u0010T\u001a\b\u0012\u0004\u0012\u00020K0UH\u0002J\u0006\u0010V\u001a\u00020KJ\b\u0010W\u001a\u00020KH\u0014J\u0006\u0010X\u001a\u00020KJ\u0012\u0010Y\u001a\u00020K2\b\u0010Z\u001a\u0004\u0018\u00010&H\u0002J\u0017\u0010[\u001a\u00020K2\b\u0010\\\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010/J\u0015\u0010]\u001a\u00020K2\b\u0010^\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010/J\u0016\u0010_\u001a\u00020K2\u000e\b\u0002\u0010`\u001a\b\u0012\u0004\u0012\u00020K0UJ\b\u0010a\u001a\u00020KH\u0002J\b\u0010b\u001a\u00020KH\u0002J\u0015\u0010c\u001a\u00020K2\b\u0010^\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010/J\u0016\u0010d\u001a\u00020K2\u000e\b\u0002\u0010e\u001a\b\u0012\u0004\u0012\u00020K0UR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u000e\u0010#\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00101\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u001c\u00104\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u001e\u00109\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\bC\u0010-\"\u0004\bD\u0010/R\u000e\u0010E\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX.¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, mo175978d2 = {"Lcom/didi/soda/business/widget/BusinessLittleStepper;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DELAY_DURATION", "", "DURATION", "TAG", "", "value", "currentNum", "getCurrentNum", "()I", "setCurrentNum", "(I)V", "downView", "Landroid/widget/TextView;", "downViewTargetWidth", "isExpend", "", "()Z", "setExpend", "(Z)V", "mCountDownTimer", "Landroid/os/CountDownTimer;", "needExpand", "getNeedExpand", "setNeedExpand", "numView", "numViewTargetWidth", "selectedBackgroundColor", "", "getSelectedBackgroundColor", "()Ljava/lang/Object;", "setSelectedBackgroundColor", "(Ljava/lang/Object;)V", "selectedBorderColor", "getSelectedBorderColor", "()Ljava/lang/Integer;", "setSelectedBorderColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "stepperBackgroundColor", "getStepperBackgroundColor", "setStepperBackgroundColor", "stepperBackgroundHelper", "Lcom/didi/soda/blocks/widget/image/BackgroundHelper;", "stepperBorderColor", "getStepperBorderColor", "setStepperBorderColor", "stepperListener", "Lcom/didi/soda/business/widget/BusinessLittleStepper$StepperListener;", "getStepperListener", "()Lcom/didi/soda/business/widget/BusinessLittleStepper$StepperListener;", "setStepperListener", "(Lcom/didi/soda/business/widget/BusinessLittleStepper$StepperListener;)V", "stepperTextColor", "getStepperTextColor", "setStepperTextColor", "tv_up_num", "upView", "Lcom/didi/rfusion/widget/RFIconView;", "viewAnim", "Landroid/animation/ValueAnimator;", "expend", "", "getCountDownTimer", "initState", "initStyle", "initView", "moveAction", "targetView", "Landroid/view/View;", "targetWidth", "onEnd", "Lkotlin/Function0;", "onDetach", "onDetachedFromWindow", "recovery", "setBg", "bg", "setBorderColor", "border", "setBtnTextColor", "color", "setDownAction", "onDownAction", "setExpendStyle", "setRecoveryStyle", "setTextColor", "setUpAction", "onAddAction", "StepperListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessLittleStepper.kt */
public final class BusinessLittleStepper extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f39851a = "BusinessLittleStepper";

    /* renamed from: b */
    private RFIconView f39852b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f39853c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f39854d;

    /* renamed from: e */
    private BackgroundHelper f39855e;

    /* renamed from: f */
    private Object f39856f;

    /* renamed from: g */
    private Object f39857g;

    /* renamed from: h */
    private Integer f39858h;

    /* renamed from: i */
    private Integer f39859i;

    /* renamed from: j */
    private Integer f39860j;

    /* renamed from: k */
    private Integer f39861k;

    /* renamed from: l */
    private StepperListener f39862l;

    /* renamed from: m */
    private boolean f39863m;

    /* renamed from: n */
    private int f39864n;

    /* renamed from: o */
    private boolean f39865o;

    /* renamed from: p */
    private final int f39866p = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_60);
    /* access modifiers changed from: private */

    /* renamed from: q */
    public TextView f39867q;

    /* renamed from: r */
    private final int f39868r = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_80);

    /* renamed from: s */
    private final long f39869s = 300;

    /* renamed from: t */
    private final long f39870t = (300 + 1000);

    /* renamed from: u */
    private CountDownTimer f39871u;

    /* renamed from: v */
    private ValueAnimator f39872v;

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/business/widget/BusinessLittleStepper$StepperListener;", "", "onRecovery", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessLittleStepper.kt */
    public interface StepperListener {
        void onRecovery();
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final Object getStepperBackgroundColor() {
        return this.f39856f;
    }

    public final void setStepperBackgroundColor(Object obj) {
        this.f39856f = obj;
    }

    public final Object getSelectedBackgroundColor() {
        return this.f39857g;
    }

    public final void setSelectedBackgroundColor(Object obj) {
        this.f39857g = obj;
    }

    public final Integer getStepperBorderColor() {
        return this.f39858h;
    }

    public final void setStepperBorderColor(Integer num) {
        this.f39858h = num;
    }

    public final Integer getSelectedBorderColor() {
        return this.f39859i;
    }

    public final void setSelectedBorderColor(Integer num) {
        this.f39859i = num;
    }

    public final Integer getStepperTextColor() {
        return this.f39860j;
    }

    public final void setStepperTextColor(Integer num) {
        this.f39860j = num;
    }

    public final Integer getSelectedTextColor() {
        return this.f39861k;
    }

    public final void setSelectedTextColor(Integer num) {
        this.f39861k = num;
    }

    public final StepperListener getStepperListener() {
        return this.f39862l;
    }

    public final void setStepperListener(StepperListener stepperListener) {
        this.f39862l = stepperListener;
    }

    public final boolean isExpend() {
        return this.f39863m;
    }

    public final void setExpend(boolean z) {
        this.f39863m = z;
    }

    public final int getCurrentNum() {
        return this.f39864n;
    }

    public final void setCurrentNum(int i) {
        TextView textView = this.f39867q;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numView");
            textView = null;
        }
        textView.setText(String.valueOf(i));
        TextView textView3 = this.f39853c;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
        } else {
            textView2 = textView3;
        }
        textView2.setText(String.valueOf(i));
        this.f39864n = i;
        initStyle();
    }

    public final boolean getNeedExpand() {
        return this.f39865o;
    }

    public final void setNeedExpand(boolean z) {
        this.f39865o = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessLittleStepper(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        m28432a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessLittleStepper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        m28432a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessLittleStepper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        m28432a();
    }

    /* renamed from: a */
    private final void m28432a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_business_little_stepper, this);
        View findViewById = findViewById(R.id.tv_up);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_up)");
        this.f39852b = (RFIconView) findViewById;
        View findViewById2 = findViewById(R.id.tv_up_num);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_up_num)");
        this.f39853c = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_down);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_down)");
        this.f39854d = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.tv_num);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_num)");
        this.f39867q = (TextView) findViewById4;
        BackgroundHelper backgroundHelper = new BackgroundHelper(getContext(), this);
        backgroundHelper.setBorderRadius((float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_18));
        Unit unit = Unit.INSTANCE;
        this.f39855e = backgroundHelper;
        if (backgroundHelper != null) {
            backgroundHelper.setBorderWidth((float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_2));
        }
        initStyle();
    }

    public final void initState() {
        TextView textView = this.f39867q;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numView");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView3 = this.f39854d;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downView");
        } else {
            textView2 = textView3;
        }
        textView2.setVisibility(8);
        setBtnTextColor(this.f39860j);
        LogUtil.m29100d(this.f39851a, Intrinsics.stringPlus("setBtnTextColor:", this.f39860j));
        m28441c();
    }

    public final void initStyle() {
        if (this.f39863m) {
            m28440b();
            TextView textView = this.f39867q;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numView");
                textView = null;
            }
            textView.setVisibility(0);
            TextView textView3 = this.f39854d;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downView");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(0);
            return;
        }
        initState();
    }

    /* access modifiers changed from: private */
    public final CountDownTimer getCountDownTimer() {
        if (this.f39871u == null) {
            long j = this.f39870t;
            this.f39871u = new BusinessLittleStepper$getCountDownTimer$1(this, j, j);
        }
        CountDownTimer countDownTimer = this.f39871u;
        if (countDownTimer != null) {
            return countDownTimer;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.CountDownTimer");
    }

    public final void expend() {
        RFIconView rFIconView = this.f39852b;
        TextView textView = null;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upView");
            rFIconView = null;
        }
        rFIconView.setVisibility(0);
        TextView textView2 = this.f39853c;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
            textView2 = null;
        }
        textView2.setVisibility(8);
        this.f39863m = true;
        TextView textView3 = this.f39854d;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downView");
            textView3 = null;
        }
        if (textView3.getVisibility() != 0) {
            TextView textView4 = this.f39867q;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numView");
                textView4 = null;
            }
            if (textView4.getVisibility() != 0) {
                TextView textView5 = this.f39854d;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downView");
                    textView5 = null;
                }
                textView5.setVisibility(4);
                TextView textView6 = this.f39867q;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("numView");
                    textView6 = null;
                }
                textView6.setVisibility(4);
                TextView textView7 = this.f39854d;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downView");
                } else {
                    textView = textView7;
                }
                textView.post(new Runnable() {
                    public final void run() {
                        BusinessLittleStepper.m28434a(BusinessLittleStepper.this);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28434a(BusinessLittleStepper businessLittleStepper) {
        Intrinsics.checkNotNullParameter(businessLittleStepper, "this$0");
        TextView textView = businessLittleStepper.f39854d;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downView");
            textView = null;
        }
        businessLittleStepper.m28433a((View) textView, businessLittleStepper.f39866p, (Function0<Unit>) new BusinessLittleStepper$expend$1$1(businessLittleStepper));
        TextView textView3 = businessLittleStepper.f39867q;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numView");
        } else {
            textView2 = textView3;
        }
        businessLittleStepper.m28433a((View) textView2, businessLittleStepper.f39868r, (Function0<Unit>) new BusinessLittleStepper$expend$1$2(businessLittleStepper));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m28440b() {
        setBg(this.f39856f);
        setBorderColor(this.f39858h);
        setTextColor(this.f39860j);
    }

    public final void recovery() {
        this.f39863m = false;
        TextView textView = this.f39854d;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downView");
            textView = null;
        }
        if (textView.getVisibility() != 8) {
            TextView textView3 = this.f39867q;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numView");
                textView3 = null;
            }
            if (textView3.getVisibility() != 8) {
                TextView textView4 = this.f39854d;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downView");
                    textView4 = null;
                }
                m28433a((View) textView4, 0, (Function0<Unit>) new BusinessLittleStepper$recovery$1(this));
                TextView textView5 = this.f39867q;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("numView");
                } else {
                    textView2 = textView5;
                }
                m28433a((View) textView2, 0, (Function0<Unit>) new BusinessLittleStepper$recovery$2(this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m28441c() {
        TextView textView = null;
        if (this.f39864n > 0) {
            setBg(this.f39857g);
            setBorderColor(this.f39859i);
            setTextColor(this.f39861k);
            RFIconView rFIconView = this.f39852b;
            if (rFIconView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("upView");
                rFIconView = null;
            }
            rFIconView.setVisibility(8);
            TextView textView2 = this.f39853c;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
                textView2 = null;
            }
            textView2.setVisibility(0);
            Integer num = this.f39861k;
            if (num != null) {
                int intValue = num.intValue();
                TextView textView3 = this.f39853c;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
                } else {
                    textView = textView3;
                }
                textView.setTextColor(intValue);
                return;
            }
            return;
        }
        setBg(this.f39856f);
        setBorderColor(this.f39858h);
        setTextColor(this.f39860j);
        RFIconView rFIconView2 = this.f39852b;
        if (rFIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upView");
            rFIconView2 = null;
        }
        rFIconView2.setVisibility(0);
        TextView textView4 = this.f39853c;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
        } else {
            textView = textView4;
        }
        textView.setVisibility(8);
    }

    /* renamed from: a */
    static /* synthetic */ void m28435a(BusinessLittleStepper businessLittleStepper, View view, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function0 = BusinessLittleStepper$moveAction$1.INSTANCE;
        }
        businessLittleStepper.m28433a(view, i, (Function0<Unit>) function0);
    }

    /* renamed from: a */
    private final void m28433a(View view, int i, Function0<Unit> function0) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{view.getMeasuredWidth(), i});
        this.f39872v = ofInt;
        if (ofInt != null) {
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(view) {
                public final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BusinessLittleStepper.m28436a(BusinessLittleStepper.this, this.f$1, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.f39872v;
        if (valueAnimator != null) {
            valueAnimator.addListener(new BusinessLittleStepper$moveAction$$inlined$addListener$default$1(this, function0));
        }
        ValueAnimator valueAnimator2 = this.f39872v;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(this.f39869s);
        }
        ValueAnimator valueAnimator3 = this.f39872v;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28436a(BusinessLittleStepper businessLittleStepper, View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(businessLittleStepper, "this$0");
        Intrinsics.checkNotNullParameter(view, "$targetView");
        LogUtil.m29100d(businessLittleStepper.f39851a, Intrinsics.stringPlus("update:", valueAnimator.getAnimatedValue()));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "targetView.layoutParams");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            layoutParams.width = ((Integer) animatedValue).intValue();
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        onDetach();
        super.onDetachedFromWindow();
    }

    public final void onDetach() {
        CountDownTimer countDownTimer = this.f39871u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f39871u = null;
    }

    private final void setBg(Object obj) {
        BackgroundHelper backgroundHelper;
        if (obj != null && (backgroundHelper = this.f39855e) != null) {
            backgroundHelper.setBackgroundColor(obj);
        }
    }

    private final void setBorderColor(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            BackgroundHelper backgroundHelper = this.f39855e;
            if (backgroundHelper != null) {
                backgroundHelper.setBorderColor(intValue);
            }
        }
    }

    public final void setTextColor(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            TextView textView = this.f39867q;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numView");
                textView = null;
            }
            textView.setTextColor(intValue);
            TextView textView3 = this.f39853c;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
            } else {
                textView2 = textView3;
            }
            textView2.setTextColor(intValue);
        }
    }

    public final void setBtnTextColor(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            RFIconView rFIconView = this.f39852b;
            TextView textView = null;
            if (rFIconView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("upView");
                rFIconView = null;
            }
            rFIconView.setTextColor(intValue);
            TextView textView2 = this.f39854d;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downView");
            } else {
                textView = textView2;
            }
            textView.setTextColor(intValue);
        }
    }

    public static /* synthetic */ void setUpAction$default(BusinessLittleStepper businessLittleStepper, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = BusinessLittleStepper$setUpAction$1.INSTANCE;
        }
        businessLittleStepper.setUpAction(function0);
    }

    public final void setUpAction(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onAddAction");
        Function0 businessLittleStepper$setUpAction$onClick$1 = new BusinessLittleStepper$setUpAction$onClick$1(this);
        TextView textView = this.f39853c;
        RFIconView rFIconView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener(this, function0) {
            public final /* synthetic */ BusinessLittleStepper f$1;
            public final /* synthetic */ Function0 f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                BusinessLittleStepper.m28438a(Function0.this, this.f$1, this.f$2, view);
            }
        });
        RFIconView rFIconView2 = this.f39852b;
        if (rFIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upView");
        } else {
            rFIconView = rFIconView2;
        }
        rFIconView.setOnClickListener(new View.OnClickListener(function0) {
            public final /* synthetic */ Function0 f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BusinessLittleStepper.m28439a(Function0.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28438a(Function0 function0, BusinessLittleStepper businessLittleStepper, Function0 function02, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        Intrinsics.checkNotNullParameter(businessLittleStepper, "this$0");
        Intrinsics.checkNotNullParameter(function02, "$onAddAction");
        function0.invoke();
        if (!businessLittleStepper.getNeedExpand()) {
            function02.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28439a(Function0 function0, Function0 function02, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        Intrinsics.checkNotNullParameter(function02, "$onAddAction");
        function0.invoke();
        function02.invoke();
    }

    public static /* synthetic */ void setDownAction$default(BusinessLittleStepper businessLittleStepper, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = BusinessLittleStepper$setDownAction$1.INSTANCE;
        }
        businessLittleStepper.setDownAction(function0);
    }

    public final void setDownAction(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onDownAction");
        TextView textView = this.f39854d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener(function0) {
            public final /* synthetic */ Function0 f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BusinessLittleStepper.m28437a(BusinessLittleStepper.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28437a(BusinessLittleStepper businessLittleStepper, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(businessLittleStepper, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$onDownAction");
        LogUtil.m29100d(businessLittleStepper.f39851a, "on down click");
        businessLittleStepper.getCountDownTimer().cancel();
        businessLittleStepper.getCountDownTimer().start();
        if (businessLittleStepper.getCurrentNum() <= 0) {
            businessLittleStepper.setCurrentNum(0);
            businessLittleStepper.recovery();
        }
        TextView textView = businessLittleStepper.f39867q;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numView");
            textView = null;
        }
        textView.setText(String.valueOf(businessLittleStepper.getCurrentNum()));
        TextView textView3 = businessLittleStepper.f39853c;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
        } else {
            textView2 = textView3;
        }
        textView2.setText(String.valueOf(businessLittleStepper.getCurrentNum()));
        function0.invoke();
    }
}
