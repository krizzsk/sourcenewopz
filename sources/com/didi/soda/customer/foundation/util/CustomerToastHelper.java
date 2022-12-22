package com.didi.soda.customer.foundation.util;

import android.view.View;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.widget.CustomerToastView;

public class CustomerToastHelper {

    /* renamed from: a */
    private static final int f41230a = 3000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FrameLayout f41231b;

    public CustomerToastHelper(FrameLayout frameLayout) {
        this.f41231b = frameLayout;
    }

    public void showCustomerToast(ScopeContext scopeContext, String str, ToastUtil.Type type) {
        if (this.f41231b != null) {
            final CustomerToastView customerToastView = new CustomerToastView(this.f41231b.getContext(), this.f41231b);
            customerToastView.updateContent(type, str);
            if (this.f41231b != null && !customerToastView.isShow()) {
                m29202a();
                customerToastView.show();
                C137681 r5 = new Runnable() {
                    public void run() {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f41231b != null && (customerToastView = customerToastView) != null) {
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
                        if (CustomerToastHelper.this.f41231b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }

                    public void onPause(ILive iLive) {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f41231b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }

                    public void onStop(ILive iLive) {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f41231b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m29202a() {
        FrameLayout frameLayout = this.f41231b;
        if (frameLayout != null && frameLayout.getChildCount() > 0) {
            for (int i = 0; i < this.f41231b.getChildCount(); i++) {
                View childAt = this.f41231b.getChildAt(i);
                if (childAt != null && (childAt instanceof CustomerToastView)) {
                    childAt.clearAnimation();
                    if (childAt.getTag() != null && (childAt.getTag() instanceof Runnable)) {
                        UiHandlerUtil.removeCallbacks((Runnable) childAt.getTag());
                    }
                    this.f41231b.removeView(childAt);
                }
            }
        }
    }
}
