package com.didi.soda.customer.widget.headerview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.app.nova.support.view.pullToRefresh.IRefreshView;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class CustomerHeaderView extends FrameLayout implements IRefreshView {

    /* renamed from: a */
    private static final int f41985a = Color.parseColor("#FFFFFF");

    /* renamed from: b */
    private static final int f41986b = Color.parseColor("#F5F5F7");

    /* renamed from: c */
    private static final int f41987c = Color.parseColor("#00FFFFFF");

    /* renamed from: d */
    private static final int f41988d = Color.parseColor("#FAFAFA");

    /* renamed from: e */
    private static final int f41989e = 5;

    /* renamed from: f */
    private LottieLoadingView f41990f;

    /* renamed from: g */
    private RelativeLayout f41991g;

    /* renamed from: h */
    private HeaderStyle f41992h;

    /* renamed from: i */
    private boolean f41993i;

    public enum HeaderStyle {
        WHITE,
        GRAY,
        ORANGE,
        TRANSPARENT,
        TRANSPARENT_ORANGE_LOADING,
        HISTORY
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
        m29613a();
    }

    public void changeStyle(HeaderStyle headerStyle) {
        if (this.f41992h != headerStyle) {
            m29614a(headerStyle);
        }
    }

    public void onMove(boolean z, int i) {
        if (this.f41990f != null && !this.f41993i && Math.abs(i) > 5) {
            this.f41990f.start();
            this.f41993i = true;
        }
        if (this.f41990f != null && this.f41993i && Math.abs(i) <= 5) {
            this.f41990f.stop();
            this.f41993i = false;
        }
    }

    /* renamed from: a */
    private void m29613a() {
        this.f41991g = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_header_view, this, true).findViewById(R.id.customer_rl_header_container);
        m29614a(HeaderStyle.WHITE);
    }

    /* renamed from: a */
    private void m29614a(HeaderStyle headerStyle) {
        if (headerStyle == HeaderStyle.ORANGE) {
            setBackgroundResource(R.drawable.customer_skin_shape_home_header_default);
            if (!GlobalContext.isEmbed()) {
                this.f41991g.removeAllViews();
                LottieLoadingView lottieLoadingView = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_orange_header_view, this.f41991g, false);
                this.f41990f = lottieLoadingView;
                this.f41991g.addView(lottieLoadingView);
            }
        } else if (headerStyle == HeaderStyle.GRAY) {
            setBackgroundColor(f41986b);
            if (!GlobalContext.isEmbed()) {
                this.f41991g.removeAllViews();
                LottieLoadingView lottieLoadingView2 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f41991g, false);
                this.f41990f = lottieLoadingView2;
                this.f41991g.addView(lottieLoadingView2);
            }
        } else if (headerStyle == HeaderStyle.TRANSPARENT) {
            setBackgroundColor(f41987c);
            if (!GlobalContext.isEmbed()) {
                this.f41991g.removeAllViews();
                LottieLoadingView lottieLoadingView3 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f41991g, false);
                this.f41990f = lottieLoadingView3;
                lottieLoadingView3.setAnimation((int) R.raw.customer_white_loading);
                this.f41991g.addView(this.f41990f);
            }
        } else if (headerStyle == HeaderStyle.TRANSPARENT_ORANGE_LOADING) {
            setBackgroundColor(f41987c);
            if (!GlobalContext.isEmbed()) {
                this.f41991g.removeAllViews();
                LottieLoadingView lottieLoadingView4 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f41991g, false);
                this.f41990f = lottieLoadingView4;
                this.f41991g.addView(lottieLoadingView4);
            }
        } else if (headerStyle == HeaderStyle.HISTORY) {
            setBackgroundColor(f41988d);
            if (!GlobalContext.isEmbed()) {
                this.f41991g.removeAllViews();
                LottieLoadingView lottieLoadingView5 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f41991g, false);
                this.f41990f = lottieLoadingView5;
                this.f41991g.addView(lottieLoadingView5);
                this.f41991g.getLayoutParams().height = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_140);
                RelativeLayout relativeLayout = this.f41991g;
                relativeLayout.setPadding(relativeLayout.getPaddingLeft(), 0, this.f41991g.getPaddingRight(), this.f41991g.getPaddingBottom());
                this.f41991g.setGravity(17);
            }
        } else {
            setBackgroundColor(f41985a);
            if (!GlobalContext.isEmbed()) {
                this.f41991g.removeAllViews();
                LottieLoadingView lottieLoadingView6 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f41991g, false);
                this.f41990f = lottieLoadingView6;
                this.f41991g.addView(lottieLoadingView6);
            }
        }
        this.f41992h = headerStyle;
    }
}
