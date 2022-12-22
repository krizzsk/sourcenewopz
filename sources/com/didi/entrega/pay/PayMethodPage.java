package com.didi.entrega.pay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.VerticalChangeHandler;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.base.pages.CustomerPage;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;
import java.io.Serializable;

@Route({"payMethodPage"})
public class PayMethodPage extends CustomerPage implements IPayMethodCallback {

    /* renamed from: a */
    private PayMethodComponent f21002a;
    @BindView(16324)
    RelativeLayout mContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public PayMethodPage() {
        DiRouter.registerHub("payMethodPage", this);
    }

    public static void toPayMethod(ScopeContext scopeContext, int i, int i2, String str, PayChannel payChannel) {
        Bundle bundle = new Bundle();
        bundle.putString(Const.BundleKey.CART_ID, str);
        if (payChannel != null) {
            bundle.putSerializable("payMethodPage", payChannel);
        }
        bundle.putInt("pay_method_price", i);
        bundle.putInt("pay_scene", i2);
        scopeContext.getNavigator().pushForResult((PayMethodPage) PageFactory.newInstance(PayMethodPage.class, bundle));
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putAll(bundle);
            this.f21002a.onPayMethodSelect((PayChannel) bundle2.getSerializable("payMethodPage"));
            Serializable serializable = bundle2.getSerializable("payMethodPage");
            if (serializable instanceof PayChannel) {
                this.f21002a.trackSelectCard((PayChannel) serializable);
                return;
            }
            this.f21002a.trackSelectCard((PayChannel) null);
        }
    }

    public ControllerChangeHandler getPopHandler() {
        return new VerticalChangeHandler(false);
    }

    public ControllerChangeHandler getPushHandler() {
        return new VerticalChangeHandler(false);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.entrega_page_paymethod_container, viewGroup, false);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        PayMethodComponent payMethodComponent = new PayMethodComponent(this.mContainer);
        this.f21002a = payMethodComponent;
        addComponent(payMethodComponent);
    }
}
