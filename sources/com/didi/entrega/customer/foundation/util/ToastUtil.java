package com.didi.entrega.customer.foundation.util;

import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ScopeContext;

public final class ToastUtil {

    /* renamed from: a */
    private static FrameLayout f20157a;

    public enum Type {
        SUCCESS,
        ERROR,
        NORMAL
    }

    private ToastUtil() {
    }

    public static void showCustomerToast(ScopeContext scopeContext, String str) {
        m14849a(scopeContext, str, Type.NORMAL);
    }

    public static void showCustomerSuccessToast(ScopeContext scopeContext, String str) {
        m14849a(scopeContext, str, Type.SUCCESS);
    }

    public static void showCustomerErrorToast(ScopeContext scopeContext, String str) {
        m14849a(scopeContext, str, Type.ERROR);
    }

    public static void bindToastContainer(FrameLayout frameLayout) {
        f20157a = frameLayout;
    }

    /* renamed from: a */
    private static void m14849a(ScopeContext scopeContext, String str, Type type) {
        new CustomerToastHelper(f20157a).showCustomerToast(scopeContext, str, type);
    }

    @Deprecated
    public static void makeText(String str) {
        showCustomerToast((ScopeContext) null, str);
    }
}
