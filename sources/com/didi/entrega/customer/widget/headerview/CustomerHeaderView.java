package com.didi.entrega.customer.widget.headerview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.app.nova.support.view.pullToRefresh.IRefreshView;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class CustomerHeaderView extends FrameLayout implements IRefreshView {

    /* renamed from: a */
    private static final int f20460a = Color.parseColor("#FFFFFF");

    /* renamed from: b */
    private static final int f20461b = Color.parseColor("#F5F5F7");

    /* renamed from: c */
    private static final int f20462c = 5;

    /* renamed from: d */
    private LottieLoadingView f20463d;

    /* renamed from: e */
    private RelativeLayout f20464e;

    /* renamed from: f */
    private HeaderStyle f20465f;

    /* renamed from: g */
    private boolean f20466g;

    public enum HeaderStyle {
        WHITE,
        GRAY,
        ORANGE
    }

    public void onComplete() {
    }

    public void onPullToRefresh() {
    }

    public void onRelease(boolean z) {
    }

    public void onReset() {
    }

    public CustomerHeaderView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomerHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomerHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14970a();
    }

    public void changeStyle(HeaderStyle headerStyle) {
        if (this.f20465f != headerStyle) {
            m14971a(headerStyle);
        }
    }

    public void onMove(boolean z, int i) {
        if (this.f20463d != null && !this.f20466g && Math.abs(i) > 5) {
            this.f20463d.start();
            this.f20466g = true;
        }
        if (this.f20463d != null && this.f20466g && Math.abs(i) <= 5) {
            this.f20463d.stop();
            this.f20466g = false;
        }
    }

    /* renamed from: a */
    private void m14970a() {
        this.f20464e = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.entrega_customer_widget_header_view, this, true).findViewById(R.id.customer_rl_header_container);
        m14971a(HeaderStyle.WHITE);
    }

    /* renamed from: a */
    private void m14971a(HeaderStyle headerStyle) {
        if (headerStyle == HeaderStyle.ORANGE) {
            setBackgroundResource(R.drawable.entrega_skin_shape_home_header_default);
            LottieLoadingView lottieLoadingView = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.entrega_widget_orange_header_view, this.f20464e, false);
            this.f20463d = lottieLoadingView;
            this.f20464e.addView(lottieLoadingView);
        } else if (headerStyle == HeaderStyle.GRAY) {
            setBackgroundColor(f20461b);
            this.f20464e.removeAllViews();
            LottieLoadingView lottieLoadingView2 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.entrega_widget_white_header_view, this.f20464e, false);
            this.f20463d = lottieLoadingView2;
            this.f20464e.addView(lottieLoadingView2);
        } else {
            setBackgroundColor(f20460a);
            this.f20464e.removeAllViews();
            LottieLoadingView lottieLoadingView3 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.entrega_widget_white_header_view, this.f20464e, false);
            this.f20463d = lottieLoadingView3;
            this.f20464e.addView(lottieLoadingView3);
        }
        this.f20465f = headerStyle;
    }
}
