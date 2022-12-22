package com.didi.soda.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.taxis99.R;

public class CustomerToastView extends LinearLayout {

    /* renamed from: a */
    private static final int f41508a = 200;

    /* renamed from: b */
    private ImageView f41509b;

    /* renamed from: c */
    private TextView f41510c;

    /* renamed from: d */
    private boolean f41511d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewGroup f41512e;

    public CustomerToastView(Context context, ViewGroup viewGroup) {
        super(context);
        m29370a(context);
        this.f41512e = viewGroup;
    }

    public CustomerToastView(Context context, AttributeSet attributeSet, ViewGroup viewGroup) {
        super(context, attributeSet);
        m29370a(context);
        this.f41512e = viewGroup;
    }

    public CustomerToastView(Context context, AttributeSet attributeSet, int i, ViewGroup viewGroup) {
        super(context, attributeSet, i);
        m29370a(context);
        this.f41512e = viewGroup;
    }

    public void hide() {
        m29369a();
        this.f41511d = false;
    }

    public boolean isShow() {
        return this.f41511d;
    }

    public void show() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = CustomerSystemUtil.getImmersiveStatusBarHeight(getContext());
        setLayoutParams(layoutParams);
        measure(View.MeasureSpec.makeMeasureSpec(this.f41512e.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f41512e.getHeight(), 0));
        this.f41512e.addView(this);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-getMeasuredHeight()), 0.0f);
        translateAnimation.setDuration(200);
        startAnimation(translateAnimation);
        this.f41511d = true;
    }

    public void updateContent(ToastUtil.Type type, String str) {
        if (type == ToastUtil.Type.SUCCESS) {
            this.f41509b.setVisibility(0);
            this.f41509b.setImageResource(R.drawable.common_icon_toast_success);
        } else if (type == ToastUtil.Type.ERROR) {
            this.f41509b.setVisibility(0);
            this.f41509b.setImageResource(R.drawable.common_icon_toast_error);
        } else {
            this.f41509b.setVisibility(8);
        }
        this.f41510c.setText(str);
    }

    /* renamed from: a */
    private void m29369a() {
        if (this.f41512e.indexOfChild(this) >= 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-getMeasuredHeight()));
            translateAnimation.setDuration(200);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (CustomerToastView.this.f41512e != null) {
                        CustomerToastView.this.f41512e.removeView(this);
                    }
                }
            });
            startAnimation(translateAnimation);
        }
    }

    /* renamed from: a */
    private void m29370a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_toast_view, this, true);
        this.f41509b = (ImageView) inflate.findViewById(R.id.iv_toast_icon);
        this.f41510c = (TextView) inflate.findViewById(R.id.tv_toast_msg);
    }
}
