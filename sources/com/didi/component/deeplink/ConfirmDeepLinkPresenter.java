package com.didi.component.deeplink;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.deeplink.DeeplinkDispatcherFragment;
import com.didi.component.business.event.DeepLinkEvent;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;

public class ConfirmDeepLinkPresenter extends AbsDeepLinkPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ForwardConfirmPage f12760a = new ForwardConfirmPage();

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<DeepLinkEvent> f12761b = new BaseEventPublisher.OnEventListener<DeepLinkEvent>() {
        public void onEvent(String str, DeepLinkEvent deepLinkEvent) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            if (deepLinkEvent != null) {
                if (deepLinkEvent.isSameAddress()) {
                    ConfirmDeepLinkPresenter.this.m8717b();
                    return;
                }
                ConfirmDeepLinkPresenter confirmDeepLinkPresenter = ConfirmDeepLinkPresenter.this;
                confirmDeepLinkPresenter.showProgressDialog(confirmDeepLinkPresenter.mContext.getString(R.string.loading_txt));
                ConfirmDeepLinkPresenter.this.f12760a.setDeepLinkEvent(deepLinkEvent);
                UiThreadHandler.postDelayed(ConfirmDeepLinkPresenter.this.f12760a, 300);
            }
        }
    };

    public ConfirmDeepLinkPresenter(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f12761b);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f12761b);
        UiThreadHandler.removeCallbacks(this.f12760a);
        dismissProgressDialog();
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        unsubscribe(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f12761b);
        UiThreadHandler.removeCallbacks(this.f12760a);
        dismissProgressDialog();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f12761b);
    }

    private class ForwardConfirmPage implements Runnable {
        private DeepLinkEvent mDeepLinkEvent;

        private ForwardConfirmPage() {
        }

        public void setDeepLinkEvent(DeepLinkEvent deepLinkEvent) {
            this.mDeepLinkEvent = deepLinkEvent;
        }

        public void run() {
            ConfirmDeepLinkPresenter.this.dismissProgressDialog();
            Bundle bundle = new Bundle();
            DeepLinkEvent deepLinkEvent = this.mDeepLinkEvent;
            if (deepLinkEvent != null) {
                bundle.putSerializable("deeplink_context", deepLinkEvent);
            }
            ConfirmDeepLinkPresenter.this.forward((Class<? extends Fragment>) DeeplinkDispatcherFragment.class, bundle);
            this.mDeepLinkEvent = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8717b() {
        goBackRoot(new Bundle());
    }
}
