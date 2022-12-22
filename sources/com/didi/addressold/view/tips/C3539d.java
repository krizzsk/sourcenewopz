package com.didi.addressold.view.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.didi.sdk.util.ViewUtils;

/* renamed from: com.didi.addressold.view.tips.d */
/* compiled from: TipsWithoutLine */
class C3539d implements C3536a {

    /* renamed from: a */
    private TipsView f8045a;

    /* renamed from: b */
    private View f8046b;

    /* renamed from: c */
    private Context f8047c;

    /* renamed from: d */
    private TipsContainer f8048d;

    /* renamed from: e */
    private boolean f8049e;

    /* renamed from: f */
    private boolean f8050f = false;

    /* renamed from: g */
    private boolean f8051g = false;

    /* renamed from: h */
    private C3537b f8052h;

    /* renamed from: i */
    private int f8053i = 0;

    public C3539d(Context context, TipsContainer tipsContainer) {
        this.f8047c = context;
        this.f8048d = tipsContainer;
    }

    /* renamed from: a */
    public void mo39979a(View view, TipsView tipsView) {
        this.f8046b = view;
        this.f8045a = tipsView;
        Rect rect = new Rect();
        ((Activity) this.f8047c).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if ((((Activity) this.f8047c).getWindow().getDecorView().getSystemUiVisibility() & 1024) == 1024) {
            this.f8053i = ViewUtils.getStatusBarHeight(this.f8047c);
        }
        this.f8052h = new C3537b(this.f8046b, i);
    }

    /* renamed from: a */
    public void mo39978a(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.f8049e = false;
        TipsView tipsView = this.f8045a;
        tipsView.measure(0, 0);
        int measuredWidth = tipsView.getMeasuredWidth();
        int measuredHeight = tipsView.getMeasuredHeight();
        Point a = this.f8052h.mo39982a(i4, i5, measuredWidth, measuredHeight, 0, i, i2);
        if (a.x < 0) {
            a.x = 0;
        }
        if (a.y < 0) {
            a.y = 0;
        }
        m5221a(a.x, a.y, measuredWidth, measuredHeight);
        if (z) {
            tipsView.setPosGone();
        } else {
            int i6 = i;
            int i7 = i2;
            tipsView.setPos(i, i2);
        }
        tipsView.attachContainer(this.f8048d);
        tipsView.showEnterAnim();
    }

    /* renamed from: a */
    private void m5221a(int i, int i2, int i3, int i4) {
        TipsView tipsView = this.f8045a;
        int i5 = i2 + this.f8053i;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(i + tipsView.getLeftMargin());
        layoutParams.setMarginEnd(tipsView.getRightMargin());
        layoutParams.topMargin = i5 + tipsView.getTopMargin();
        layoutParams.bottomMargin = tipsView.getBottomMargin();
        if (com.didi.addressold.util.ViewUtils.isRTL()) {
            layoutParams.gravity = GravityCompat.END;
        } else {
            layoutParams.gravity = GravityCompat.START;
        }
        this.f8048d.addView((View) tipsView, layoutParams);
    }

    /* renamed from: a */
    public boolean mo39980a() {
        return this.f8049e;
    }

    /* renamed from: b */
    public void mo39981b() {
        this.f8049e = true;
        TipsContainer tipsContainer = this.f8048d;
        if (tipsContainer != null) {
            tipsContainer.clear();
        }
    }
}
