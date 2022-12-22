package com.didi.soda.pay;

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
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import java.io.Serializable;

@Route({"payMethodPage"})
public class PayMethodPage extends CustomerPage implements IPayMethodCallback {

    /* renamed from: a */
    private PayMethodComponent f43628a;
    @BindView(18186)
    RelativeLayout mContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public PayMethodPage() {
        DiRouter.registerHub("payMethodPage", this);
    }

    public static void toPayMethod(ScopeContext scopeContext, String str, int i, int i2, String str2, int i3, PayChannelEntity payChannelEntity) {
        Bundle bundle = new Bundle();
        bundle.putString("current_shop_id", str);
        bundle.putString("cart_id", str2);
        if (payChannelEntity != null) {
            bundle.putSerializable(Const.BundleKey.SELECT_PAYMENT_METHOD, payChannelEntity);
        }
        bundle.putInt("pay_method_price", i);
        bundle.putInt("pay_scene", i2);
        if (i2 == 0) {
            bundle.putString(Const.BundleKey.BIND_CARD_SCENE, GlobalContext.isEmbed() ? Const.BindCardScene.DEFAULT_EMBED : "100");
            BillOmegaHelper.Companion.paymentClick(str2, str, i3, payChannelEntity);
        } else if (i2 == 2) {
            bundle.putString(Const.BundleKey.BIND_CARD_SCENE, GlobalContext.isEmbed() ? Const.BindCardScene.ORDER_TIP_EMBED : Const.BindCardScene.ORDER_TIP_APP);
        } else if (i2 == 1) {
            bundle.putString(Const.BundleKey.BIND_CARD_SCENE, GlobalContext.isEmbed() ? Const.BindCardScene.ORDER_DEBT_EMBED : Const.BindCardScene.ORDER_DEBT_APP);
        }
        scopeContext.getNavigator().pushForResult((PayMethodPage) PageFactory.newInstance(PayMethodPage.class, bundle));
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putAll(bundle);
            bundle2.putString("current_shop_id", getScopeContext().getBundle().getString("current_shop_id"));
            this.f43628a.onPayMethodSelect((PayChannelEntity) bundle2.getSerializable(Const.BundleKey.SELECT_PAYMENT_METHOD));
            Serializable serializable = bundle2.getSerializable(Const.BundleKey.SELECT_PAYMENT_METHOD);
            if (serializable instanceof PayChannelEntity) {
                this.f43628a.trackSelectCard((PayChannelEntity) serializable);
                return;
            }
            this.f43628a.trackSelectCard((PayChannelEntity) null);
        }
    }

    public ControllerChangeHandler getPopHandler() {
        return new VerticalChangeHandler(true);
    }

    public ControllerChangeHandler getPushHandler() {
        return new VerticalChangeHandler(true);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_paymethod_container, viewGroup, false);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        PayMethodComponent payMethodComponent = new PayMethodComponent(this.mContainer);
        this.f43628a = payMethodComponent;
        addComponent(payMethodComponent);
    }
}
