package com.didi.soda.order.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.VerticalChangeHandler;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.order.component.tips.EditTipsComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"tipsEdit"})
public class EditTipsPage extends CustomerPage {

    /* renamed from: a */
    private EditTipsComponent f43522a;
    @BindView(18139)
    FrameLayout mCartContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public EditTipsPage() {
        DiRouter.registerHub(RoutePath.TIPS_EDIT, this);
    }

    public ControllerChangeHandler getPopHandler() {
        return new VerticalChangeHandler(true);
    }

    public ControllerChangeHandler getPushHandler() {
        return new VerticalChangeHandler(false);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        EditTipsComponent editTipsComponent = new EditTipsComponent(this.mCartContainer);
        this.f43522a = editTipsComponent;
        addComponent(editTipsComponent);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_cart_container, viewGroup, false);
    }

    public void onPageResult(Bundle bundle) {
        PayChannelEntity payChannelEntity;
        super.onPageResult(bundle);
        if (bundle != null && (payChannelEntity = (PayChannelEntity) bundle.getSerializable(Const.BundleKey.SELECT_PAYMENT_METHOD)) != null) {
            this.f43522a.onSelectPayCard(payChannelEntity);
        }
    }
}
