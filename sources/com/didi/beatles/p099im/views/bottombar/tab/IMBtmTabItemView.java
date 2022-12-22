package com.didi.beatles.p099im.views.bottombar.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabItemView */
public class IMBtmTabItemView extends FrameLayout {

    /* renamed from: a */
    private static final String f10128a = IMBtmTabItemView.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f10129b;

    public IMBtmTabItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBtmTabItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMBtmTabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View view = new View(context, (AttributeSet) null);
        this.f10129b = view;
        view.setBackgroundResource(R.color.im_palette_first);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(IMViewUtil.dp2px(context, 46.0f), IMViewUtil.dp2px(context, 1.0f));
        layoutParams.gravity = 81;
        this.f10129b.setLayoutParams(layoutParams);
    }

    public void addTabView(final View view) {
        removeAllViews();
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                    IMLog.m6631d(f10128a, "[addTabView] #ViewParent# removeView.");
                }
            } catch (Exception e) {
                IMTraceError.trackError("IMBtmTabItemView#addTabView", e);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            view.setLayoutParams(layoutParams);
            addView(view);
            addView(this.f10129b);
            IMViewUtil.hide(this.f10129b);
            post(new Runnable() {
                public void run() {
                    int measuredWidth;
                    try {
                        if (view != null && IMBtmTabItemView.this.f10129b != null && (measuredWidth = view.getMeasuredWidth() - IMBtmTabItemView.this.getResources().getDimensionPixelSize(R.dimen.im_10_dp)) > 0) {
                            ViewGroup.LayoutParams layoutParams = IMBtmTabItemView.this.f10129b.getLayoutParams();
                            layoutParams.width = measuredWidth;
                            IMBtmTabItemView.this.f10129b.setLayoutParams(layoutParams);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void setChecked(boolean z) {
        if (z) {
            IMViewUtil.show(this.f10129b);
        } else {
            IMViewUtil.hide(this.f10129b);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
    }
}
