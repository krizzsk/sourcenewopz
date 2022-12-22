package com.didi.entrega.pay;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.repo.CustomerActivityResultRepo;

public final class PayOmegaHelper {
    public static void bindCardResult(CustomerActivityResultRepo.ActivityResult activityResult, String str) {
    }

    public static void bindPayPayFail(int i, String str) {
    }

    public static void closePay(ScopeContext scopeContext, int i) {
        if (scopeContext == null) {
        }
    }

    public static void openPayUniActivity() {
    }

    private PayOmegaHelper() {
    }

    public static void openPayView(ScopeContext scopeContext, int i, int i2, boolean z) {
        if (scopeContext == null || scopeContext.getLiveHandler().isDestroyed()) {
        }
    }
}
