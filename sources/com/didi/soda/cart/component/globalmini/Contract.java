package com.didi.soda.cart.component.globalmini;

import android.view.View;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.component.provider.ICartProvider;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.widget.abnormal.AbnormalViewModel;
import com.didi.soda.jadux.Store;
import com.didi.soda.order.component.tips.TipState;

public interface Contract {

    public static abstract class AbsEditTipsPresenter extends IPresenter<AbsEditTipsView> {
        public abstract void finish();

        public abstract void onPaymethodSelect();

        public abstract void onSelectCard(PayChannelEntity payChannelEntity);

        public abstract void onTipsInputChange(String str);

        public abstract void payTips();
    }

    public static abstract class AbsEditTipsView extends IView<AbsEditTipsPresenter> {
        public abstract void hideConfirmLoading();

        public abstract void initTipsGroupStore(Store<TipState> store);

        public abstract void initView(TipState tipState);

        public abstract boolean isLoading();

        public abstract void showConfirmLoading();

        public abstract void showLoadError(AbnormalViewModel abnormalViewModel);

        public abstract void showLoading();

        public abstract void showSuccess();

        public abstract void updateView(TipState tipState);
    }

    public static abstract class AbsGlobalMiniCartPresenter extends ICustomerPresenter<AbsGlobalMiniCartView> {
        public abstract boolean isCanShow();
    }

    public static abstract class AbsGlobalMiniCartView extends ICustomerView<AbsGlobalMiniCartPresenter> implements ICartProvider {
        public abstract void initButtonStyle();

        public abstract boolean isShow();

        public abstract void setOnClickListener(View.OnClickListener onClickListener);
    }
}
