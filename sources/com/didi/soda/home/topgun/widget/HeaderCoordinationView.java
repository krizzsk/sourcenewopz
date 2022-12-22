package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public class HeaderCoordinationView extends View {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f43069a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f43070b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f43071c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f43072d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f43073e = false;

    /* renamed from: f */
    private ScopeContext f43074f;

    /* renamed from: g */
    private LifeCycleObserver f43075g = new LifeCycleObserver();

    /* renamed from: h */
    private ViewTreeObserver.OnPreDrawListener f43076h = new ViewTreeObserver.OnPreDrawListener() {
        public boolean onPreDraw() {
            if (!GlobalContext.isEmbed() || !HeaderCoordinationView.this.f43073e || HeaderCoordinationView.this.f43069a == null) {
                return true;
            }
            if (HeaderCoordinationView.this.f43072d == 0) {
                HeaderCoordinationView headerCoordinationView = HeaderCoordinationView.this;
                int unused = headerCoordinationView.f43072d = headerCoordinationView.getYOnWindow();
            }
            float alpha = HeaderCoordinationView.this.f43069a.getAlpha();
            int d = HeaderCoordinationView.this.getYOnWindow();
            if (d == 0) {
                d = PckErrCode.ASSERT_COPY_ERROR;
            }
            int c = d - HeaderCoordinationView.this.f43072d;
            if (HeaderCoordinationView.this.f43070b != null) {
                HeaderCoordinationView.this.f43070b.setY((float) (c + HeaderCoordinationView.this.f43071c));
                HeaderCoordinationView.this.f43070b.setAlpha(alpha);
            } else {
                GlobalContext.getTitleAndBizBarManager().offsetTitleBar((float) c, alpha);
            }
            return true;
        }
    };

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    /* renamed from: a */
    private void m30468a() {
        if (this.f43070b == null) {
            Object object = this.f43074f.getObject(Const.HomeTags.BACK_VIEW_TAG);
            View view = null;
            if (object instanceof View) {
                view = (View) object;
            }
            if (view != null && view.isAttachedToWindow()) {
                this.f43070b = view;
                this.f43071c = CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()) + ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_2);
            }
        }
    }

    public HeaderCoordinationView(Context context) {
        super(context);
        m30472b();
    }

    public HeaderCoordinationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30472b();
    }

    public HeaderCoordinationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30472b();
    }

    public void setDependOnView(View view) {
        this.f43069a = view;
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f43074f = scopeContext;
        m30468a();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f43069a != null) {
            getViewTreeObserver().addOnPreDrawListener(this.f43076h);
            ScopeContext scopeContext = this.f43074f;
            if (scopeContext != null) {
                this.f43073e = true;
                scopeContext.addObserver(this.f43075g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f43069a != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f43076h);
            ScopeContext scopeContext = this.f43074f;
            if (scopeContext != null) {
                scopeContext.removeObserver(this.f43075g);
                this.f43073e = false;
            }
        }
    }

    /* renamed from: b */
    private void m30472b() {
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public int getYOnWindow() {
        View view = this.f43069a;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    private class LifeCycleObserver implements IScopeLifecycle {
        public void onCreate(ILive iLive) {
        }

        public void onDestroy(ILive iLive) {
        }

        public void onStart(ILive iLive) {
        }

        public void onStop(ILive iLive) {
        }

        private LifeCycleObserver() {
        }

        public void onResume(ILive iLive) {
            boolean unused = HeaderCoordinationView.this.f43073e = true;
        }

        public void onPause(ILive iLive) {
            boolean unused = HeaderCoordinationView.this.f43073e = false;
        }
    }
}
