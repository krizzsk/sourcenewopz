package com.didi.entrega.customer.foundation.util;

import android.view.View;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.widget.CustomerToastView;

public class CustomerToastHelper {

    /* renamed from: a */
    private static final int f20129a = 3000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FrameLayout f20130b;

    public CustomerToastHelper(FrameLayout frameLayout) {
        this.f20130b = frameLayout;
    }

    public void showCustomerToast(ScopeContext scopeContext, String str, ToastUtil.Type type) {
        if (this.f20130b != null) {
            final CustomerToastView customerToastView = new CustomerToastView(this.f20130b.getContext(), this.f20130b);
            customerToastView.updateContent(type, str);
            if (this.f20130b != null && !customerToastView.isShow()) {
                m14828a();
                customerToastView.show();
                C81021 r5 = new Runnable() {
                    public void run() {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f20130b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }
                };
                customerToastView.setTag(r5);
                UiHandlerUtil.postDelayed(r5, 3000);
            }
            if (scopeContext != null) {
                scopeContext.addObserver(new IScopeLifecycle() {
                    public void onCreate(ILive iLive) {
                    }

                    public void onResume(ILive iLive) {
                    }

                    public void onStart(ILive iLive) {
                    }

                    public void onDestroy(ILive iLive) {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f20130b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }

                    public void onPause(ILive iLive) {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f20130b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }

                    public void onStop(ILive iLive) {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f20130b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m14828a() {
        FrameLayout frameLayout = this.f20130b;
        if (frameLayout != null && frameLayout.getChildCount() > 0) {
            for (int i = 0; i < this.f20130b.getChildCount(); i++) {
                View childAt = this.f20130b.getChildAt(i);
                if (childAt != null && (childAt instanceof CustomerToastView)) {
                    childAt.clearAnimation();
                    if (childAt.getTag() != null && (childAt.getTag() instanceof Runnable)) {
                        UiHandlerUtil.removeCallbacks((Runnable) childAt.getTag());
                    }
                    this.f20130b.removeView(childAt);
                }
            }
        }
    }
}
