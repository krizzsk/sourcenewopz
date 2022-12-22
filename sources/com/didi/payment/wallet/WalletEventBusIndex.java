package com.didi.payment.wallet;

import com.didi.payment.base.anti.AccessBlockEvent;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.wallet.global.model.event.PagePopupStack;
import com.didi.payment.wallet.global.model.event.WalletNewBalanceLoadingEvent;
import com.didi.payment.wallet.global.model.event.WalletSignUpSuccessEvent;
import com.didi.payment.wallet.global.wallet.presenter.WalletHomePresenter;
import com.didi.payment.wallet.global.wallet.presenter.WalletNewBalancePresenter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletMainListActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpChannelActivity;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;

public class WalletEventBusIndex implements SubscriberInfoIndex {

    /* renamed from: a */
    private static final Map<Class<?>, SubscriberInfo> f31726a = new HashMap();

    static {
        m22496a(new SimpleSubscriberInfo(WalletTopUpChannelActivity.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEvent", WalletRefreshDataEvent.class)}));
        m22496a(new SimpleSubscriberInfo(WalletNewBalancePresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onSignUpSucceed", WalletNewBalanceLoadingEvent.class, ThreadMode.MAIN)}));
        m22496a(new SimpleSubscriberInfo(WalletBaseActivity.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onPopupStack", PagePopupStack.class, ThreadMode.MAIN), new SubscriberMethodInfo("onAccessBlock", AccessBlockEvent.class, ThreadMode.MAIN)}));
        m22496a(new SimpleSubscriberInfo(WalletHomePresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onSignUpSucceed", WalletSignUpSuccessEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onWalletDataRefreshed", WalletRefreshDataEvent.class, ThreadMode.MAIN)}));
        m22496a(new SimpleSubscriberInfo(WalletMainListActivity.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onShowFlowerAnimation", WalletSignUpSuccessEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onWalletDataChanged", WalletRefreshDataEvent.class, ThreadMode.MAIN)}));
    }

    /* renamed from: a */
    private static void m22496a(SubscriberInfo subscriberInfo) {
        f31726a.put(subscriberInfo.getSubscriberClass(), subscriberInfo);
    }

    public SubscriberInfo getSubscriberInfo(Class<?> cls) {
        SubscriberInfo subscriberInfo = f31726a.get(cls);
        if (subscriberInfo != null) {
            return subscriberInfo;
        }
        return null;
    }
}
