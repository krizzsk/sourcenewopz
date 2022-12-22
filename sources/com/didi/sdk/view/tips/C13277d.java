package com.didi.sdk.view.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.sdk.util.ViewUtils;

/* renamed from: com.didi.sdk.view.tips.d */
/* compiled from: TipsWithoutLine */
class C13277d implements C13274a {

    /* renamed from: a */
    private TipsView f38302a;

    /* renamed from: b */
    private View f38303b;

    /* renamed from: c */
    private Context f38304c;

    /* renamed from: d */
    private TipsContainer f38305d;

    /* renamed from: e */
    private boolean f38306e;

    /* renamed from: f */
    private boolean f38307f = false;

    /* renamed from: g */
    private boolean f38308g = false;

    /* renamed from: h */
    private C13275b f38309h;

    /* renamed from: i */
    private int f38310i = 0;

    public C13277d(Context context, TipsContainer tipsContainer) {
        this.f38304c = context;
        this.f38305d = tipsContainer;
    }

    /* renamed from: a */
    public void mo97886a(View view, TipsView tipsView) {
        this.f38303b = view;
        this.f38302a = tipsView;
        Rect rect = new Rect();
        ((Activity) this.f38304c).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if ((((Activity) this.f38304c).getWindow().getDecorView().getSystemUiVisibility() & 1024) == 1024) {
            this.f38310i = ViewUtils.getStatusBarHeight(this.f38304c);
        }
        this.f38309h = new C13275b(this.f38303b, i);
    }

    /* renamed from: a */
    public void mo97885a(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.f38306e = false;
        TipsView tipsView = this.f38302a;
        tipsView.measure(0, 0);
        int measuredWidth = tipsView.getMeasuredWidth();
        int measuredHeight = tipsView.getMeasuredHeight();
        Point a = this.f38309h.mo97889a(i4, i5, measuredWidth, measuredHeight, 0, i, i2);
        if (a.x < 0) {
            a.x = 0;
        }
        if (a.y < 0) {
            a.y = 0;
        }
        m27085a(a.x, a.y, measuredWidth, measuredHeight);
        if (z) {
            tipsView.setPosGone();
        } else {
            int i6 = i;
            int i7 = i2;
            tipsView.setPos(i, i2);
        }
        tipsView.attachContainer(this.f38305d);
        tipsView.showEnterAnim();
    }

    /* renamed from: a */
    private void m27085a(int i, int i2, int i3, int i4) {
        TipsView tipsView = this.f38302a;
        int i5 = i2 + this.f38310i;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i + tipsView.getLeftMargin(), i5 + tipsView.getTopMargin(), tipsView.getRightMargin(), tipsView.getBottomMargin());
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.f38305d.addView((View) tipsView, (ViewGroup.LayoutParams) layoutParams);
    }

    /* renamed from: a */
    public boolean mo97887a() {
        return this.f38306e;
    }

    /* renamed from: b */
    public void mo97888b() {
        this.f38306e = true;
        TipsContainer tipsContainer = this.f38305d;
        if (tipsContainer != null) {
            tipsContainer.clear();
        }
    }
}
