package com.didi.component.deeplink;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.deeplink.DeeplinkDispatcherFragment;
import com.didi.component.business.deeplink.NewActivitySchemeFilter;
import com.didi.component.business.event.ActivityDeepLinkEvent;
import com.didi.component.business.event.BaseDeepLinkEvent;
import com.didi.component.business.event.DeepLinkEvent;
import com.didi.component.business.merchant.MerchantActivityDeepLinkEvent;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor;

public class HomeDeepLinkPresenter extends AbsDeepLinkPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ForwardConfirmPage f12786a = new ForwardConfirmPage();

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<BaseDeepLinkEvent> f12787b = new BaseEventPublisher.OnEventListener<BaseDeepLinkEvent>() {
        public void onEvent(String str, BaseDeepLinkEvent baseDeepLinkEvent) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            if (baseDeepLinkEvent != null) {
                if (baseDeepLinkEvent instanceof DeepLinkEvent) {
                    DeepLinkEvent deepLinkEvent = (DeepLinkEvent) baseDeepLinkEvent;
                    if (!deepLinkEvent.isSameAddress()) {
                        HomeDeepLinkPresenter homeDeepLinkPresenter = HomeDeepLinkPresenter.this;
                        homeDeepLinkPresenter.showProgressDialog(homeDeepLinkPresenter.mContext.getString(R.string.loading_txt));
                        HomeDeepLinkPresenter.this.f12786a.setDeepLinkEvent(deepLinkEvent);
                        UiThreadHandler.postDelayed(HomeDeepLinkPresenter.this.f12786a, 300);
                    }
                } else if (baseDeepLinkEvent instanceof ActivityDeepLinkEvent) {
                    NewActivitySchemeFilter.handleScheme((Activity) HomeDeepLinkPresenter.this.mContext, ((ActivityDeepLinkEvent) baseDeepLinkEvent).uri);
                }
            }
        }
    };

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<MerchantActivityDeepLinkEvent> f12788c = new BaseEventPublisher.OnEventListener<MerchantActivityDeepLinkEvent>() {
        public void onEvent(String str, MerchantActivityDeepLinkEvent merchantActivityDeepLinkEvent) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            if (merchantActivityDeepLinkEvent != null) {
                GlobalMerchantUnifiedPayProcessor.INS.onHandleMerchantRequest((Activity) HomeDeepLinkPresenter.this.mContext, merchantActivityDeepLinkEvent.getRequest());
            }
        }
    };

    public HomeDeepLinkPresenter(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f12787b);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Service.DeepLink.EVENT_HAND_MERCHANT_DEEP_LINK, this.f12788c);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f12787b);
        unsubscribe(BaseEventKeys.Service.DeepLink.EVENT_HAND_MERCHANT_DEEP_LINK, this.f12788c);
        UiThreadHandler.removeCallbacks(this.f12786a);
        dismissProgressDialog();
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        unsubscribe(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f12787b);
        unsubscribe(BaseEventKeys.Service.DeepLink.EVENT_HAND_MERCHANT_DEEP_LINK, this.f12788c);
        UiThreadHandler.removeCallbacks(this.f12786a);
        dismissProgressDialog();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f12787b);
    }

    private class ForwardConfirmPage implements Runnable {
        private DeepLinkEvent mDeepLinkEvent;

        private ForwardConfirmPage() {
        }

        public void setDeepLinkEvent(DeepLinkEvent deepLinkEvent) {
            this.mDeepLinkEvent = deepLinkEvent;
        }

        public void run() {
            HomeDeepLinkPresenter.this.dismissProgressDialog();
            Bundle bundle = new Bundle();
            DeepLinkEvent deepLinkEvent = this.mDeepLinkEvent;
            if (deepLinkEvent != null) {
                bundle.putSerializable("deeplink_context", deepLinkEvent);
            }
            HomeDeepLinkPresenter.this.forward((Class<? extends Fragment>) DeeplinkDispatcherFragment.class, bundle);
            this.mDeepLinkEvent = null;
        }
    }
}
