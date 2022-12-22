package com.didi.entrega.customer.widget;

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
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.taxis99.R;

public class CustomerToastView extends LinearLayout {

    /* renamed from: a */
    private static final int f20281a = 200;

    /* renamed from: b */
    private ImageView f20282b;

    /* renamed from: c */
    private TextView f20283c;

    /* renamed from: d */
    private boolean f20284d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewGroup f20285e;

    public CustomerToastView(Context context, ViewGroup viewGroup) {
        super(context);
        m14898a(context);
        this.f20285e = viewGroup;
    }

    public CustomerToastView(Context context, AttributeSet attributeSet, ViewGroup viewGroup) {
        super(context, attributeSet);
        m14898a(context);
        this.f20285e = viewGroup;
    }

    public CustomerToastView(Context context, AttributeSet attributeSet, int i, ViewGroup viewGroup) {
        super(context, attributeSet, i);
        m14898a(context);
        this.f20285e = viewGroup;
    }

    public void hide() {
        m14897a();
        this.f20284d = false;
    }

    public boolean isShow() {
        return this.f20284d;
    }

    public void show() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = CustomerSystemUtil.getImmersiveStatusBarHeight(getContext());
        setLayoutParams(layoutParams);
        measure(View.MeasureSpec.makeMeasureSpec(this.f20285e.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f20285e.getHeight(), 0));
        this.f20285e.addView(this);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-getMeasuredHeight()), 0.0f);
        translateAnimation.setDuration(200);
        startAnimation(translateAnimation);
        this.f20284d = true;
    }

    public void updateContent(ToastUtil.Type type, String str) {
        this.f20283c.setText(str);
    }

    /* renamed from: a */
    private void m14897a() {
        if (this.f20285e.indexOfChild(this) >= 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-getMeasuredHeight()));
            translateAnimation.setDuration(200);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (CustomerToastView.this.f20285e != null) {
                        CustomerToastView.this.f20285e.removeView(this);
                    }
                }
            });
            startAnimation(translateAnimation);
        }
    }

    /* renamed from: a */
    private void m14898a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.entrega_toast_view, this, true);
        this.f20282b = (ImageView) inflate.findViewById(R.id.iv_toast_icon);
        this.f20283c = (TextView) inflate.findViewById(R.id.tv_toast_msg);
    }
}
