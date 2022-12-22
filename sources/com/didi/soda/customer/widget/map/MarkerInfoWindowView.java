package com.didi.soda.customer.widget.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.taxis99.R;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

public class MarkerInfoWindowView extends FrameLayout {

    /* renamed from: a */
    private TextView f42134a;

    /* renamed from: b */
    private TextView f42135b;

    /* renamed from: c */
    private View f42136c;

    /* renamed from: d */
    private ObjectAnimator f42137d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f42138e;

    /* renamed from: f */
    private int f42139f;

    /* renamed from: g */
    private int f42140g;

    /* renamed from: h */
    private int f42141h;

    public MarkerInfoWindowView(Context context) {
        super(context);
        m29708b();
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29708b();
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29708b();
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m29708b();
    }

    public void hideViewImmediately() {
        this.f42138e = 8;
        setVisibility(8);
    }

    public void hideViewWithAnim() {
        this.f42138e = 8;
        updateView((String) null, (CharSequence) null);
    }

    public void showView(String str, CharSequence charSequence) {
        if (!TextUtils.isEmpty(str)) {
            this.f42138e = 0;
            setVisibility(0);
            updateView(str, charSequence);
            m29709c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f42137d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f42137d = null;
        }
    }

    public void updateView(String str, CharSequence charSequence) {
        int i = 8;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(charSequence)) {
            this.f42138e = 0;
            setVisibility(0);
            this.f42134a.setText(str);
            this.f42134a.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            this.f42135b.setText(charSequence);
            this.f42135b.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
            View view = this.f42136c;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(charSequence)) {
                i = 0;
            }
            view.setVisibility(i);
            return;
        }
        this.f42134a.setVisibility(8);
        this.f42135b.setVisibility(8);
        this.f42136c.setVisibility(8);
        this.f42138e = 8;
        m29710d();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public void updateLocation(int i, int i2, boolean z) {
        this.f42139f = i;
        this.f42140g = i2;
        Context context = getContext();
        this.f42141h = z ? DisplayUtils.dip2px(context, 34.0f) : -DisplayUtils.dip2px(context, 30.0f);
        m29707a();
    }

    /* renamed from: a */
    private void m29707a() {
        measure(View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f42139f - (measuredWidth / 2);
        layoutParams.topMargin = (this.f42140g - measuredHeight) + this.f42141h;
        layoutParams.rightMargin = -measuredWidth;
        layoutParams.bottomMargin = -measuredHeight;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* renamed from: b */
    private void m29708b() {
        View inflate = inflate(getContext(), R.layout.customer_layout_marker_station, (ViewGroup) null);
        this.f42134a = (TextView) inflate.findViewById(R.id.customer_custom_distance_text);
        this.f42135b = (TextView) inflate.findViewById(R.id.customer_custom_eta_text);
        this.f42136c = inflate.findViewById(R.id.customer_custom_tips_divider);
        addView(inflate);
        setVisibility(8);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f}), ofFloat});
        this.f42137d = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(200);
        this.f42137d.setInterpolator(new DecelerateInterpolator());
        this.f42137d.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MarkerInfoWindowView markerInfoWindowView = MarkerInfoWindowView.this;
                markerInfoWindowView.setVisibility(markerInfoWindowView.f42138e);
            }
        });
    }

    /* renamed from: c */
    private void m29709c() {
        ObjectAnimator objectAnimator = this.f42137d;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.f42137d.end();
            }
            setScaleX(0.0f);
            setScaleX(0.0f);
            setAlpha(0.0f);
            this.f42137d.setStartDelay(1200);
            this.f42137d.start();
        }
    }

    /* renamed from: d */
    private void m29710d() {
        if (this.f42137d != null && isShown()) {
            if (this.f42137d.isRunning()) {
                this.f42137d.end();
            }
            this.f42137d.setStartDelay(0);
            this.f42137d.reverse();
        }
    }
}
