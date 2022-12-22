package com.didi.rfusion.widget.stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C10448R;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFStepper extends ConstraintLayout {

    /* renamed from: a */
    private static final String f33720a = "RFStepper";

    /* renamed from: b */
    private static final int f33721b = 0;

    /* renamed from: c */
    private static final int f33722c = 999;

    /* renamed from: d */
    private static final int f33723d = 1;

    /* renamed from: e */
    private static final int f33724e = 1;

    /* renamed from: f */
    private static final int f33725f = 999;

    /* renamed from: g */
    private static final int f33726g = 1;

    /* renamed from: h */
    private static final int f33727h = -1;

    /* renamed from: i */
    private RFIconView f33728i;

    /* renamed from: j */
    private RFTextView f33729j;

    /* renamed from: k */
    private RFIconView f33730k;

    /* renamed from: l */
    private FrameLayout f33731l;

    /* renamed from: m */
    private FrameLayout f33732m;

    /* renamed from: n */
    private OnStepperChangedListener f33733n;

    /* renamed from: o */
    private int f33734o;

    /* renamed from: p */
    private int f33735p;

    /* renamed from: q */
    private int f33736q;

    /* renamed from: r */
    private int f33737r;

    /* renamed from: s */
    private int f33738s;

    /* renamed from: t */
    private boolean f33739t;

    /* renamed from: u */
    private boolean f33740u;

    public static abstract class OnStepperChangedListener {
        public abstract void onStepperChanged(int i, int i2, int i3);

        public boolean onStepperIntercepted(int i, int i2, int i3) {
            return false;
        }
    }

    public RFStepper(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFStepper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFStepper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33735p = 1;
        this.f33736q = 999;
        this.f33739t = true;
        this.f33740u = true;
        m23743a();
        m23746a(attributeSet);
    }

    /* renamed from: a */
    private void m23743a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rf_stepper, this);
        this.f33728i = (RFIconView) findViewById(R.id.rf_tv_minus);
        this.f33730k = (RFIconView) findViewById(R.id.rf_tv_plus);
        this.f33729j = (RFTextView) findViewById(R.id.rf_tv_value);
        this.f33728i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFStepper.this.m23749b(view);
            }
        });
        this.f33730k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFStepper.this.m23747a(view);
            }
        });
        m23748b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23749b(View view) {
        m23745a(1, getCurValue() - getStepValue(), true, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23747a(View view) {
        m23745a(2, getCurValue() + getStepValue(), true, true);
    }

    /* renamed from: b */
    private void m23748b() {
        this.f33731l = (FrameLayout) findViewById(R.id.rf_fl_minus_hot_space);
        this.f33732m = (FrameLayout) findViewById(R.id.rf_fl_plus_hot_space);
        post(new Runnable() {
            public final void run() {
                RFStepper.this.m23751d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m23751d() {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        rect.set(0, 0, this.f33731l.getWidth(), this.f33731l.getHeight());
        rect2.set(0, 0, this.f33732m.getWidth(), this.f33732m.getHeight());
        this.f33731l.setTouchDelegate(new TouchDelegate(rect, this.f33728i));
        this.f33732m.setTouchDelegate(new TouchDelegate(rect2, this.f33730k));
    }

    /* renamed from: a */
    private void m23746a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.RFStepper);
        int i = obtainStyledAttributes.getInt(7, 1);
        int i2 = obtainStyledAttributes.getInt(5, 1);
        int i3 = obtainStyledAttributes.getInt(4, 999);
        int i4 = obtainStyledAttributes.getInt(0, -1);
        int i5 = obtainStyledAttributes.getInt(6, 1);
        boolean z = obtainStyledAttributes.getBoolean(3, true);
        boolean z2 = obtainStyledAttributes.getBoolean(1, true);
        boolean z3 = obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.recycle();
        if (i4 < 0) {
            i4 = i2;
        }
        m23744a(i);
        setStepValue(i5);
        setDefaultValue(i4);
        setMinValue(i2);
        setMaxValue(i3);
        setEnabled(z);
        setEnableMinusAction(z2);
        setEnablePlusAction(z3);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        m23750c();
    }

    public void setEnablePlusAction(boolean z) {
        this.f33739t = z;
        m23750c();
    }

    public boolean isEnablePlusAction() {
        return this.f33739t;
    }

    public void setEnableMinusAction(boolean z) {
        this.f33740u = z;
        m23750c();
    }

    public boolean isEnableMinusAction() {
        return this.f33740u;
    }

    public void setSpec(int i) {
        if (this.f33734o != i) {
            m23744a(i);
        }
    }

    public void setMinValue(int i) {
        int a = m23742a(i, true);
        this.f33735p = a;
        if (a > this.f33737r) {
            m23745a(0, a, true, false);
        }
        m23750c();
    }

    public int getMinValue() {
        return this.f33735p;
    }

    public void setMaxValue(int i) {
        int a = m23742a(i, false);
        this.f33736q = a;
        if (a < this.f33737r) {
            m23745a(0, a, true, false);
        }
        m23750c();
    }

    public int getMaxValue() {
        return this.f33736q;
    }

    public void setStepValue(int i) {
        this.f33738s = i;
        m23750c();
    }

    public int getStepValue() {
        return this.f33738s;
    }

    public void setCurValue(int i) {
        setCurValue(i, true);
    }

    public void setCurValue(int i, boolean z) {
        m23745a(0, i, z, true);
    }

    /* renamed from: a */
    private void m23745a(int i, int i2, boolean z, boolean z2) {
        OnStepperChangedListener onStepperChangedListener;
        int i3 = this.f33737r;
        if (i3 != i2) {
            int max = Math.max(this.f33735p, Math.min(this.f33736q, i2));
            if (!z || (onStepperChangedListener = this.f33733n) == null) {
                this.f33737r = max;
                RFTextView rFTextView = this.f33729j;
                rFTextView.setText("" + this.f33737r);
            } else {
                if (z2) {
                    z2 = onStepperChangedListener.onStepperIntercepted(i, i3, max);
                }
                if (!z2) {
                    this.f33737r = max;
                    RFTextView rFTextView2 = this.f33729j;
                    rFTextView2.setText("" + this.f33737r);
                    this.f33733n.onStepperChanged(i, i3, this.f33737r);
                }
            }
            m23750c();
        }
    }

    public int getCurValue() {
        return this.f33737r;
    }

    public void setOnStepperChangedListener(OnStepperChangedListener onStepperChangedListener) {
        this.f33733n = onStepperChangedListener;
    }

    /* renamed from: a */
    private void m23744a(int i) {
        int i2;
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33729j.getLayoutParams();
        ViewGroup.LayoutParams layoutParams = this.f33731l.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f33732m.getLayoutParams();
        if (i == 0) {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_operation_size_large);
            marginLayoutParams.width = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_size_large);
            marginLayoutParams.leftMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_margin_width_large);
            marginLayoutParams.rightMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_margin_width_large);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_operation_hot_space_width_large);
            this.f33729j.setTextSize(0, RFResUtils.getDimens(getContext(), R.dimen.f_04_app_48_pad_32));
        } else {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_operation_size_small);
            marginLayoutParams.width = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_size_small);
            marginLayoutParams.leftMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_margin_width_small);
            marginLayoutParams.rightMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_margin_width_small);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_operation_hot_space_width_small);
            this.f33729j.setTextSize(0, RFResUtils.getDimens(getContext(), R.dimen.f_07_app_36_pad_24));
        }
        layoutParams.width = i3;
        layoutParams.height = i2;
        this.f33731l.setLayoutParams(layoutParams);
        layoutParams2.width = i3;
        layoutParams2.height = i2;
        this.f33732m.setLayoutParams(layoutParams2);
        float f = (float) i2;
        this.f33728i.setTextSize(0, f);
        this.f33730k.setTextSize(0, f);
        this.f33734o = i;
    }

    private void setDefaultValue(int i) {
        this.f33737r = i;
        RFTextView rFTextView = this.f33729j;
        rFTextView.setText("" + this.f33737r);
    }

    /* renamed from: a */
    private int m23742a(int i, boolean z) {
        int i2;
        int max = Math.max(0, Math.min(999, i));
        if (z) {
            i2 = this.f33736q;
            if (max <= i2) {
                return max;
            }
        } else {
            i2 = this.f33735p;
            if (max >= i2) {
                return max;
            }
        }
        return i2;
    }

    /* renamed from: c */
    private void m23750c() {
        boolean z = false;
        if (!isEnabled()) {
            this.f33728i.setEnabled(false);
            this.f33730k.setEnabled(false);
            this.f33729j.setEnabled(false);
            return;
        }
        if (this.f33740u) {
            this.f33728i.setEnabled(this.f33737r - this.f33738s >= this.f33735p);
        } else {
            this.f33728i.setEnabled(false);
        }
        if (this.f33739t) {
            RFIconView rFIconView = this.f33730k;
            if (this.f33737r + this.f33738s <= this.f33736q) {
                z = true;
            }
            rFIconView.setEnabled(z);
            return;
        }
        this.f33730k.setEnabled(false);
    }
}
