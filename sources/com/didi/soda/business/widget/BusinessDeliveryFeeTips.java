package com.didi.soda.business.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Path;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.utils.RFDisplayUtils;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;

public class BusinessDeliveryFeeTips extends FrameLayout {

    /* renamed from: a */
    private static final String f39754a = "BusinessDeliveryFeeTips";

    /* renamed from: b */
    private ViewGroup f39755b;

    /* renamed from: c */
    private TextView f39756c;

    /* renamed from: d */
    private RFIconView f39757d;

    /* renamed from: e */
    private ImageView f39758e;

    /* renamed from: f */
    private ConstraintLayout f39759f;

    /* renamed from: g */
    private C13515a f39760g;

    /* renamed from: h */
    private ObjectAnimator f39761h;

    /* renamed from: i */
    private ObjectAnimator f39762i;

    /* renamed from: j */
    private ObjectAnimator f39763j;

    /* renamed from: k */
    private int f39764k;

    /* renamed from: l */
    private boolean f39765l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f39766m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f39767n;

    /* renamed from: o */
    private int f39768o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public OnTransitionListener f39769p;

    interface OnTransitionListener {
        void onTipsHide();

        void onTipsShow();
    }

    public BusinessDeliveryFeeTips(Context context) {
        this(context, (AttributeSet) null);
    }

    public BusinessDeliveryFeeTips(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BusinessDeliveryFeeTips(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39764k = 0;
        this.f39765l = false;
        this.f39766m = true;
        this.f39767n = false;
        this.f39768o = 0;
        m28330a();
        m28335b();
        m28338c();
        m28339d();
    }

    /* renamed from: a */
    private void m28330a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_business_delivery_fee_tips, this);
        this.f39755b = (ViewGroup) findViewById(R.id.customer_business_content_container);
        this.f39756c = (TextView) findViewById(R.id.customer_tv_delivery_fee_content);
        this.f39757d = (RFIconView) findViewById(R.id.customer_iv_delivery_fee_close);
        this.f39758e = (ImageView) findViewById(R.id.customer_delivery_fee_arrow);
        this.f39759f = (ConstraintLayout) findViewById(R.id.customer_business_shadow_container);
        this.f39756c.setOnClickListener((View.OnClickListener) null);
    }

    /* renamed from: b */
    private void m28335b() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, (float) (-RFDisplayUtils.dp2px(5.0f)), 0.0f})});
        this.f39761h = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setRepeatCount(-1);
        this.f39761h.setRepeatMode(2);
        Path path = new Path();
        path.quadTo(0.19f, 0.5f, 0.33f, 0.5f);
        path.cubicTo(0.5f, 0.55f, 0.5f, 1.0f, 1.0f, 1.0f);
        this.f39761h.setInterpolator(PathInterpolatorCompat.create(path));
        this.f39761h.setDuration(900);
        this.f39761h.setStartDelay(400);
    }

    /* renamed from: c */
    private void m28338c() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f}), ofFloat});
        this.f39762i = ofPropertyValuesHolder;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (BusinessDeliveryFeeTips.this.f39767n) {
                    BusinessDeliveryFeeTips.this.m28341e();
                }
                if (BusinessDeliveryFeeTips.this.f39769p != null) {
                    BusinessDeliveryFeeTips.this.f39769p.onTipsShow();
                }
            }
        });
        this.f39762i.setDuration(300);
        this.f39762i.setInterpolator(decelerateInterpolator);
    }

    /* renamed from: d */
    private void m28339d() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.0f}), ofFloat});
        this.f39763j = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(300);
        this.f39763j.setInterpolator(decelerateInterpolator);
        this.f39763j.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BusinessDeliveryFeeTips.this.m28343f();
                BusinessDeliveryFeeTips.super.setVisibility(8);
                if (BusinessDeliveryFeeTips.this.f39769p != null) {
                    BusinessDeliveryFeeTips.this.f39769p.onTipsHide();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f39765l = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                BusinessDeliveryFeeTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (BusinessDeliveryFeeTips.this.f39766m && BusinessDeliveryFeeTips.this.getVisibility() == 0) {
                    BusinessDeliveryFeeTips.this.m28347i();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f39762i.isRunning()) {
            this.f39762i.end();
        }
        if (this.f39763j.isRunning()) {
            this.f39763j.end();
        }
        m28343f();
        this.f39765l = false;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (i == 0) {
            m28346h();
        } else {
            m28345g();
        }
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            if (!this.f39765l || !this.f39766m) {
                super.setVisibility(i);
            } else if (i == 0) {
                m28347i();
            } else if (i == 8) {
                m28348j();
            } else {
                super.setVisibility(i);
            }
        }
    }

    public void setText(int i) {
        this.f39756c.setText(i);
    }

    public void setText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            setVisibility(0);
            this.f39756c.setText(charSequence);
            return;
        }
        setVisibility(8);
    }

    public void setContentMaxLine(int i) {
        TextView textView = this.f39756c;
        if (i < 1) {
            i = 1;
        }
        textView.setMaxLines(i);
    }

    public void bindAnchorView(View view) {
        if (view != null) {
            int[] a = m28334a(view, new int[]{0, 0});
            this.f39760g = new C13515a(a[0] + (view.getWidth() / 2), a[1] + view.getHeight(), view.getWidth(), view.getHeight());
        }
    }

    /* renamed from: a */
    private int[] m28334a(View view, int[] iArr) {
        iArr[0] = view.getLeft();
        iArr[1] = view.getTop();
        ViewParent parent = view.getParent();
        while (parent != null && parent != getParent()) {
            View view2 = (View) parent;
            iArr[0] = iArr[0] + view2.getLeft();
            iArr[1] = iArr[1] + view2.getTop();
            parent = parent.getParent();
        }
        return iArr;
    }

    public void setEnableTransition(boolean z) {
        this.f39766m = z;
    }

    public void startShake() {
        this.f39767n = true;
        m28341e();
    }

    public void stopShake() {
        this.f39767n = false;
        m28343f();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m28341e() {
        if (!this.f39761h.isRunning() && this.f39765l) {
            this.f39761h.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m28343f() {
        if (this.f39761h.isRunning()) {
            this.f39761h.end();
        }
    }

    /* renamed from: g */
    private void m28345g() {
        if (this.f39761h.isRunning()) {
            this.f39761h.pause();
        }
    }

    /* renamed from: h */
    private void m28346h() {
        if (this.f39761h.isPaused()) {
            this.f39761h.resume();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m28347i() {
        if (this.f39763j.isRunning()) {
            this.f39763j.end();
        }
        super.setVisibility(0);
        m28349k();
        this.f39762i.start();
    }

    /* renamed from: j */
    private void m28348j() {
        if (this.f39762i.isRunning()) {
            this.f39762i.end();
        }
        m28349k();
        this.f39763j.start();
    }

    /* renamed from: k */
    private void m28349k() {
        int i;
        int i2;
        int i3 = this.f39764k;
        int i4 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    i4 = getMeasuredWidth() / 2;
                    i = getMeasuredHeight();
                } else if (i3 == 4) {
                    i = getMeasuredHeight();
                } else if (i3 != 5) {
                    i2 = getMeasuredWidth() / 2;
                } else {
                    i4 = getMeasuredWidth();
                    i = getMeasuredHeight();
                }
                setPivotX((float) i4);
                setPivotY((float) i);
            }
            i2 = getMeasuredWidth();
            i4 = i2;
        }
        i = 0;
        setPivotX((float) i4);
        setPivotY((float) i);
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.f39757d.setOnClickListener(onClickListener);
        this.f39757d.setVisibility(onClickListener != null ? 0 : 8);
    }

    /* access modifiers changed from: package-private */
    public void setTransitionListener(OnTransitionListener onTransitionListener) {
        this.f39769p = onTransitionListener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m28331a(i, i2, i3, i4);
    }

    /* renamed from: a */
    private void m28331a(int i, int i2, int i3, int i4) {
        int i5;
        int measuredWidth;
        int i6;
        int measuredWidth2;
        if (this.f39760g != null) {
            int dip2px = DisplayUtils.dip2px(getContext(), 16.0f) - this.f39759f.getPaddingLeft();
            int dip2px2 = DisplayUtils.dip2px(getContext(), 6.0f);
            int measuredWidth3 = this.f39755b.getMeasuredWidth() / 2;
            if (this.f39760g.f39887c < this.f39759f.getPaddingLeft() + dip2px + dip2px2 + (this.f39758e.getMeasuredWidth() / 2)) {
                i5 = this.f39759f.getPaddingLeft() + dip2px2;
            } else {
                if (this.f39760g.f39887c > ((getMeasuredWidth() - dip2px) - this.f39759f.getPaddingRight()) - dip2px2) {
                    dip2px = (getMeasuredWidth() - dip2px) - this.f39755b.getMeasuredWidth();
                    measuredWidth3 = (this.f39755b.getMeasuredWidth() - this.f39759f.getPaddingRight()) - dip2px2;
                    measuredWidth = this.f39758e.getMeasuredWidth();
                } else {
                    if (measuredWidth3 >= this.f39760g.f39887c - dip2px) {
                        i6 = this.f39760g.f39887c - dip2px;
                        measuredWidth2 = this.f39758e.getMeasuredWidth() / 2;
                    } else if (measuredWidth3 > (getMeasuredWidth() - dip2px) - this.f39760g.f39887c) {
                        dip2px = (getMeasuredWidth() - dip2px) - this.f39755b.getMeasuredWidth();
                        i6 = this.f39760g.f39887c - dip2px;
                        measuredWidth2 = this.f39758e.getMeasuredWidth() / 2;
                    } else {
                        dip2px = this.f39760g.f39887c - measuredWidth3;
                        measuredWidth = this.f39758e.getMeasuredWidth() / 2;
                    }
                    i5 = i6 - measuredWidth2;
                }
                i5 = measuredWidth3 - measuredWidth;
            }
            this.f39755b.layout(dip2px, this.f39760g.f39888d, this.f39755b.getMeasuredWidth() + dip2px, this.f39760g.f39888d + this.f39755b.getMeasuredHeight());
            ImageView imageView = this.f39758e;
            imageView.layout(i5, imageView.getTop(), this.f39758e.getMeasuredWidth() + i5, this.f39758e.getTop() + this.f39758e.getMeasuredHeight());
        }
    }
}
