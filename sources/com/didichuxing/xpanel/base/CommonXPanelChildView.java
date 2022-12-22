package com.didichuxing.xpanel.base;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.didichuxing.xpanel.util.Utils;
import com.taxis99.R;

public class CommonXPanelChildView<T> implements IXPanelChildView {

    /* renamed from: a */
    private int f49314a;

    /* renamed from: b */
    private int f49315b;

    /* renamed from: c */
    private int f49316c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float f49317d;
    protected XPanelCardLayout mCardView;
    protected View mView;

    public boolean contain(float f, float f2) {
        return false;
    }

    public void destroy() {
    }

    public int getMarginLeft() {
        return 0;
    }

    public int getMarginRight() {
        return 0;
    }

    public void initData(XPanelCardData xPanelCardData) {
    }

    public CommonXPanelChildView(View view, boolean z) {
        this.f49317d = 3.0f;
        if (z) {
            this.mView = m35568a(view, false);
        } else {
            this.mView = view;
        }
    }

    public CommonXPanelChildView(View view, boolean z, boolean z2) {
        this.f49317d = 3.0f;
        if (z) {
            this.mView = m35568a(view, z2);
        } else {
            this.mView = view;
        }
    }

    public CommonXPanelChildView(View view) {
        this(view, true);
    }

    /* renamed from: a */
    private View m35568a(View view, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        View view2 = (View) view.getParent();
        if (view2 != null && (view2 instanceof XPanelCardLayout)) {
            return view2;
        }
        final Context context = view.getContext();
        XPanelCardLayout xPanelCardLayout = new XPanelCardLayout(context);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams = new FrameLayout.LayoutParams(layoutParams2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        }
        FrameLayout.LayoutParams layoutParams3 = layoutParams;
        this.f49314a = context.getResources().getDimensionPixelSize(R.dimen._10dip);
        this.f49315b = context.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_shader_top);
        this.f49316c = context.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_shader_bottom);
        layoutParams3.leftMargin = this.f49314a;
        layoutParams3.rightMargin = this.f49314a;
        layoutParams3.topMargin = this.f49315b;
        layoutParams3.bottomMargin = this.f49316c;
        if (!z) {
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.card2);
            int i = this.f49314a;
            xPanelCardLayout.setBgDrawable(drawable, i, this.f49315b, i, this.f49316c);
        } else {
            this.mCardView = xPanelCardLayout;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) Utils.dip2px(context, CommonXPanelChildView.this.f49317d));
                    }
                }
            });
            view.setClipToOutline(true);
        }
        if (view.getBackground() == null) {
            view.setBackgroundColor(-1);
        }
        xPanelCardLayout.addView(view, layoutParams3);
        return xPanelCardLayout;
    }

    /* renamed from: a */
    private void m35569a() {
        XPanelCardLayout xPanelCardLayout = this.mCardView;
        if (xPanelCardLayout != null) {
            Drawable drawable = ContextCompat.getDrawable(xPanelCardLayout.getContext(), R.drawable.card2);
            XPanelCardLayout xPanelCardLayout2 = this.mCardView;
            int i = this.f49314a;
            xPanelCardLayout2.setBgDrawable(drawable, i, this.f49315b, i, this.f49316c);
            this.mCardView = null;
        }
    }

    public View getView() {
        return this.mView;
    }

    public int halfHeight() {
        View view = this.mView;
        if (view != null) {
            return view.getMeasuredHeight() / 2;
        }
        return 0;
    }

    public void bind(Object obj) {
        m35569a();
    }

    public void setRoundCorner(float f) {
        this.f49317d = f;
    }
}
