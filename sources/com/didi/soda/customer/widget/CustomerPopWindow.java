package com.didi.soda.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CustomerPopWindow extends FrameLayout {

    /* renamed from: a */
    private static final int f41467a = 250;

    /* renamed from: b */
    private TextView f41468b;

    /* renamed from: c */
    private TextView f41469c;

    /* renamed from: d */
    private TextView f41470d;

    /* renamed from: e */
    private PopWindowListener f41471e;

    public CustomerPopWindow(Context context) {
        super(context);
        m29347a(context);
    }

    public CustomerPopWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29347a(context);
    }

    public CustomerPopWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29347a(context);
    }

    public void dismiss() {
        if (getVisibility() == 0) {
            m29350b();
        }
    }

    public void setContent(CharSequence charSequence) {
        this.f41468b.setText(charSequence);
    }

    public void setListener(PopWindowListener popWindowListener) {
        this.f41471e = popWindowListener;
    }

    public void show() {
        if (getVisibility() == 8) {
            m29346a();
        }
    }

    /* renamed from: a */
    private void m29347a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_pop_window, this, true);
        this.f41468b = (TextView) inflate.findViewById(R.id.customer_tv_content);
        this.f41469c = (TextView) inflate.findViewById(R.id.customer_btn_negative);
        this.f41470d = (TextView) inflate.findViewById(R.id.customer_btn_positive);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41469c, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41470d, IToolsService.FontType.MEDIUM);
        this.f41469c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerPopWindow.this.m29349a(false);
            }
        });
        this.f41470d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerPopWindow.this.m29349a(true);
            }
        });
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29349a(boolean z) {
        dismiss();
        PopWindowListener popWindowListener = this.f41471e;
        if (popWindowListener == null) {
            return;
        }
        if (z) {
            popWindowListener.onPositiveButtonClick();
        } else {
            popWindowListener.onNegativeButtonClick();
        }
    }

    /* renamed from: a */
    private void m29346a() {
        measure(0, 0);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-getMeasuredHeight()), 0.0f);
        translateAnimation.setDuration(250);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                CustomerPopWindow.this.setVisibility(0);
            }
        });
        startAnimation(translateAnimation);
    }

    /* renamed from: b */
    private void m29350b() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-getHeight()));
        translateAnimation.setDuration(250);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                CustomerPopWindow.this.setVisibility(8);
                CustomerPopWindow.this.setClickable(true);
            }

            public void onAnimationStart(Animation animation) {
                CustomerPopWindow.this.setClickable(false);
            }
        });
        startAnimation(translateAnimation);
    }
}
