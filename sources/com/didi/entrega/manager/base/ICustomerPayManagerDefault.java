package com.didi.entrega.manager.base;

import android.app.Activity;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.manager.base.ICustomerPayManager;

public class ICustomerPayManagerDefault implements ICustomerPayManager {
    public String getManagerName() {
        return null;
    }

    public void getPayStatus(Activity activity, ScopeContext scopeContext, ICustomerPayManager.PayParamEntity payParamEntity, ICustomerPayManager.PayCallback payCallback) {
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void pay(ScopeContext scopeContext, Activity activity, ICustomerPayManager.PayParamEntity payParamEntity, ICustomerPayManager.PayCallback payCallback) {
    }
}
