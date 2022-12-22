package com.didi.component.payment;

import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.payment.proxy.PresenterProxy;
import com.didi.component.payment.proxy.ViewProxy;
import global.didi.pay.IGlobalPayView;

@ComponentRegister(product = "ride", type = "payment")
public class PayComponent extends AbsPayComponent {
    /* access modifiers changed from: protected */
    public void bind(ComponentParams componentParams, ViewProxy viewProxy, IPresenter iPresenter) {
        IGlobalPayView realView = viewProxy.getRealView();
        String str = componentParams.psid;
        setViewListener((PresenterProxy) iPresenter, realView);
        iPresenter.setIView(viewProxy);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: com.didi.component.payment.presenter.impl.GlobalBridgePaymentPresenter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: com.didi.component.payment.presenter.impl.GlobalPaymentPresenter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: com.didi.component.payment.presenter.impl.GlobalBridgePaymentPresenter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.didi.component.payment.presenter.impl.GlobalBridgePaymentPresenter} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.component.core.IPresenter onCreatePresenter(com.didi.component.core.ComponentParams r10) {
        /*
            r9 = this;
            com.didi.sdk.app.BusinessContext r0 = r10.bizCtx
            android.content.Context r2 = r0.getContext()
            androidx.fragment.app.Fragment r0 = r10.getFragment()
            java.lang.String r1 = "BUNDLE_KEY_SID"
            java.lang.Object r1 = r10.getExtra(r1)
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
            com.didi.component.payment.proxy.PresenterProxy r8 = new com.didi.component.payment.proxy.PresenterProxy
            r8.<init>(r2, r4)
            java.lang.String r1 = "order_id"
            java.lang.Object r1 = r10.getExtra(r1)
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r1 = "product_id"
            java.lang.Object r10 = r10.getExtra(r1)
            r5 = r10
            java.lang.String r5 = (java.lang.String) r5
            boolean r10 = android.text.TextUtils.isEmpty(r6)
            if (r10 != 0) goto L_0x003c
            com.didi.component.payment.presenter.impl.GlobalBridgePaymentPresenter r10 = new com.didi.component.payment.presenter.impl.GlobalBridgePaymentPresenter
            androidx.fragment.app.FragmentManager r3 = r0.getFragmentManager()
            r1 = r10
            r7 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0045
        L_0x003c:
            com.didi.component.payment.presenter.impl.GlobalPaymentPresenter r10 = new com.didi.component.payment.presenter.impl.GlobalPaymentPresenter
            androidx.fragment.app.FragmentManager r1 = r0.getFragmentManager()
            r10.<init>(r2, r1, r4, r8)
        L_0x0045:
            r10.setFragment(r0)
            r8.setRealPresenter(r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.payment.PayComponent.onCreatePresenter(com.didi.component.core.ComponentParams):com.didi.component.core.IPresenter");
    }

    private void setViewListener(PresenterProxy presenterProxy, IGlobalPayView iGlobalPayView) {
        iGlobalPayView.setListener(presenterProxy.getRealPresenter());
    }
}
