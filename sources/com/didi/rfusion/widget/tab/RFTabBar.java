package com.didi.rfusion.widget.tab;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C10448R;
import com.didi.rfusion.widget.tab.RFScroller;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class RFTabBar extends ConstraintLayout implements C11568a {
    public static final int RF_TAB_BAR_LARGE = 1;
    public static final int RF_TAB_BAR_SMALL = 0;

    /* renamed from: a */
    private int f33762a;

    /* renamed from: b */
    private boolean f33763b;

    /* renamed from: c */
    private RFScroller f33764c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f33765d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f33766e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RFTabBarSpec {
    }

    public RFTabBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFTabBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33762a = 0;
        m23772a(context, attributeSet);
        m23771a(context);
    }

    /* renamed from: a */
    private void m23771a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.rf_tab_bar, this);
        this.f33764c = (RFScroller) findViewById(R.id.rf_tab_bar_original);
        this.f33765d = findViewById(R.id.rf_tab_bar_shade_start);
        this.f33766e = findViewById(R.id.rf_tab_bar_shade_end);
        this.f33764c.setOnScrollPositionChangeListener(new RFScroller.OnScrollPositionChangeListener() {
            /* access modifiers changed from: package-private */
            public void onScrollToLeft() {
                RFTabBar.this.f33765d.setVisibility(8);
                RFTabBar.this.f33766e.setVisibility(0);
            }

            /* access modifiers changed from: package-private */
            public void onScrollToRight() {
                RFTabBar.this.f33765d.setVisibility(0);
                RFTabBar.this.f33766e.setVisibility(8);
            }

            /* access modifiers changed from: package-private */
            public void onScrollToMiddle() {
                RFTabBar.this.f33765d.setVisibility(0);
                RFTabBar.this.f33766e.setVisibility(0);
            }
        });
        setTabBarSpec(this.f33762a);
        showDividerLine(this.f33763b);
    }

    public void setTabBarSpec(int i) {
        this.f33764c.setTabBarSpec(i);
    }

    public void setData(List<String> list) {
        this.f33764c.setData(list);
    }

    public void setTabBarAdapter(RFTabAdapter rFTabAdapter) {
        this.f33764c.setTabBarAdapter(rFTabAdapter);
    }

    public void selectTab(int i) {
        this.f33764c.selectTab(i);
    }

    public void setOnTabSelectedListener(OnRFTabSelectedListener onRFTabSelectedListener) {
        this.f33764c.setOnTabSelectedListener(onRFTabSelectedListener);
    }

    public void setOnTabFirstExposureListener(OnRFTabFirstExposureListener onRFTabFirstExposureListener) {
        this.f33764c.setOnTabFirstExposureListener(onRFTabFirstExposureListener);
    }

    public void showDividerLine(boolean z) {
        this.f33764c.showDividerLine(z);
    }

    /* renamed from: a */
    private void m23772a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFTabBar);
        this.f33762a = obtainStyledAttributes.getInt(1, 0);
        this.f33763b = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m23773a(final View view, final int i) {
        if (view.getVisibility() != i) {
            float f = 0.0f;
            float f2 = 1.0f;
            if (i != 0) {
                f = 1.0f;
                f2 = 0.0f;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{f, f2});
            ofFloat.setDuration(300);
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(i);
                }
            });
            ofFloat.start();
        }
    }
}
