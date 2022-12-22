package com.didi.soda.customer.widget.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.util.DisplayUtils;
import com.didi.rfusion.utils.RFDisplayUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;

public class NewCustomerGuideContainer extends ConstraintLayout {

    /* renamed from: a */
    private static final String f41971a = "NewCustomerGuideContainer";

    /* renamed from: b */
    private ImageView f41972b;

    /* renamed from: c */
    private CustomerAppCompatTextView f41973c;

    /* renamed from: d */
    private RFIconView f41974d;

    /* renamed from: e */
    private LinearLayout f41975e;

    /* renamed from: f */
    private RelativeLayout f41976f;

    /* renamed from: g */
    private ObjectAnimator f41977g;

    /* renamed from: h */
    private ObjectAnimator f41978h;

    /* renamed from: i */
    private ObjectAnimator f41979i;

    /* renamed from: j */
    private boolean f41980j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f41981k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f41982l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public OnTransitionListener f41983m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public OnDismissListener f41984n;

    public interface OnDismissListener {
        void onDismiss();
    }

    public interface OnTransitionListener {
        void onTipsHide();

        void onTipsShow();
    }

    public NewCustomerGuideContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewCustomerGuideContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewCustomerGuideContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41980j = false;
        this.f41981k = false;
        this.f41982l = true;
        m29592a();
        m29598c();
        m29599d();
        m29602e();
    }

    /* renamed from: a */
    private void m29592a() {
        setBackgroundResource(R.color.transparent);
        LayoutInflater.from(getContext()).inflate(R.layout.customer_new_guide_view, this, true);
        this.f41972b = (ImageView) findViewById(R.id.customer_iv_icon_guide);
        this.f41973c = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_content_guide);
        this.f41974d = (RFIconView) findViewById(R.id.customer_iv_close_guide);
        this.f41975e = (LinearLayout) findViewById(R.id.customer_guide_root_container);
        this.f41976f = (RelativeLayout) findViewById(R.id.customer_guider_outer_container);
        this.f41974d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewCustomerGuideContainer.this.setVisibility(8);
            }
        });
        setClipChildren(false);
        this.f41973c.post(new Runnable() {
            public final void run() {
                NewCustomerGuideContainer.this.m29612m();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        LogUtil.m29102e(f41971a, "dispatchTouchEvent-----${ev?.action}");
        OnDismissListener onDismissListener = this.f41984n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29612m() {
        ViewGroup.LayoutParams layoutParams = this.f41975e.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f41973c.getMeasuredHeight() + DisplayUtils.dp2px(getContext(), 32.0f);
            this.f41975e.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: c */
    private void m29598c() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, (float) (-RFDisplayUtils.dp2px(5.0f)), 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f41976f, new PropertyValuesHolder[]{ofFloat});
        this.f41977g = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setRepeatCount(-1);
        this.f41977g.setRepeatMode(2);
        Path path = new Path();
        path.quadTo(0.19f, 0.5f, 0.33f, 0.5f);
        path.cubicTo(0.5f, 0.55f, 0.5f, 1.0f, 1.0f, 1.0f);
        this.f41977g.setInterpolator(PathInterpolatorCompat.create(path));
        this.f41977g.setDuration(900);
        this.f41977g.setStartDelay(400);
    }

    /* renamed from: d */
    private void m29599d() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f41976f, new PropertyValuesHolder[]{ofFloat2, ofFloat3, ofFloat});
        this.f41978h = ofPropertyValuesHolder;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (NewCustomerGuideContainer.this.f41981k) {
                    NewCustomerGuideContainer.this.m29603f();
                }
                if (NewCustomerGuideContainer.this.f41983m != null) {
                    NewCustomerGuideContainer.this.f41983m.onTipsShow();
                }
            }
        });
        this.f41978h.setDuration(300);
        this.f41978h.setInterpolator(decelerateInterpolator);
    }

    /* renamed from: e */
    private void m29602e() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.0f});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f41976f, new PropertyValuesHolder[]{ofFloat2, ofFloat3, ofFloat});
        this.f41979i = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(300);
        this.f41979i.setInterpolator(decelerateInterpolator);
        this.f41979i.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                NewCustomerGuideContainer.this.m29605g();
                NewCustomerGuideContainer.super.setVisibility(8);
                if (NewCustomerGuideContainer.this.f41983m != null) {
                    NewCustomerGuideContainer.this.f41983m.onTipsHide();
                }
                if (NewCustomerGuideContainer.this.f41984n != null) {
                    NewCustomerGuideContainer.this.f41984n.onDismiss();
                }
            }
        });
    }

    public void setEnableTransition(boolean z) {
        this.f41982l = z;
    }

    public void startShake() {
        this.f41981k = true;
        m29603f();
    }

    public void stopShake() {
        this.f41981k = false;
        m29605g();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m29603f() {
        if (!this.f41977g.isRunning() && this.f41980j) {
            this.f41977g.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m29605g() {
        if (this.f41977g.isRunning()) {
            this.f41977g.end();
        }
    }

    /* renamed from: h */
    private void m29607h() {
        if (this.f41977g.isRunning()) {
            this.f41977g.pause();
        }
    }

    /* renamed from: i */
    private void m29608i() {
        if (this.f41977g.isPaused()) {
            this.f41977g.resume();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m29609j() {
        if (this.f41979i.isRunning()) {
            this.f41979i.end();
        }
        super.setVisibility(0);
        m29611l();
        this.f41978h.start();
    }

    /* renamed from: k */
    private void m29610k() {
        if (this.f41978h.isRunning()) {
            this.f41978h.end();
        }
        m29611l();
        this.f41979i.start();
    }

    /* renamed from: l */
    private void m29611l() {
        int measuredHeight = getMeasuredHeight();
        setPivotX((float) (getMeasuredWidth() / 2));
        setPivotY((float) measuredHeight);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f41980j = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                NewCustomerGuideContainer.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (NewCustomerGuideContainer.this.f41982l && NewCustomerGuideContainer.this.getVisibility() == 0) {
                    NewCustomerGuideContainer.this.m29609j();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f41978h.isRunning()) {
            this.f41978h.end();
        }
        if (this.f41979i.isRunning()) {
            this.f41979i.end();
        }
        m29605g();
        this.f41980j = false;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (i == 0) {
            m29608i();
        } else {
            m29607h();
        }
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            if (!this.f41980j || !this.f41982l) {
                super.setVisibility(i);
            } else if (i == 0) {
                m29609j();
            } else if (i == 8) {
                m29610k();
            } else {
                super.setVisibility(i);
            }
        }
    }

    public void setOnListener(View.OnClickListener onClickListener) {
        this.f41974d.setOnClickListener(onClickListener);
        this.f41974d.setVisibility(onClickListener != null ? 0 : 8);
    }

    public void setTransitionListener(OnTransitionListener onTransitionListener) {
        this.f41983m = onTransitionListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f41984n = onDismissListener;
    }
}
