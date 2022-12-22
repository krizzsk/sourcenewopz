package com.didi.component.safetoolkit.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.ISafeToolkitView;
import com.didi.sdk.app.ActivityStack;
import com.didi.travel.psnger.model.response.CarOrder;

public class OnServiceSafeToolkitPresenter extends AbsSafeToolkitPresenter {

    /* renamed from: a */
    private ActivityStack.OnStackChangedAdapter f15405a = new ActivityStack.OnStackChangedAdapter() {
        public void onAppResume() {
            super.onAppResume();
            if (OnServiceSafeToolkitPresenter.this.refreshVisibility()) {
                OnServiceSafeToolkitPresenter.this.requestSafeToolkitStatus();
            }
        }
    };

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15406b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (OnServiceSafeToolkitPresenter.this.refreshVisibility()) {
                OnServiceSafeToolkitPresenter.this.requestSafeToolkitStatus();
            }
        }
    };

    public OnServiceSafeToolkitPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (refreshVisibility()) {
            requestSafeToolkitStatus();
        }
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
    }

    /* access modifiers changed from: protected */
    public boolean refreshVisibility() {
        boolean sFIsReportingPolice = GlobalSPUtil.getSFIsReportingPolice(this.mContext);
        GLog.m7971i("refreshVisibility", "isReporting:" + sFIsReportingPolice);
        if (sFIsReportingPolice) {
            ((ISafeToolkitView) this.mView).setVisibility(true);
            BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY);
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY, false);
            return true;
        }
        boolean sFHaveRidingOrderSwitch = GlobalSPUtil.getSFHaveRidingOrderSwitch(this.mContext);
        CarOrder order = CarOrderHelper.getOrder();
        GLog.m7971i("refreshVisibility", "isHaveRidingOrder:" + sFHaveRidingOrderSwitch + " carOrder:" + order);
        if (order == null || !sFHaveRidingOrderSwitch) {
            BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY);
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY, new Boolean(true));
            return false;
        }
        ((ISafeToolkitView) this.mView).setVisibility(true);
        BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY);
        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY, new Boolean(false));
        return true;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public void register() {
        super.register();
        ActivityStack.addStackChangedListener(this.f15405a);
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f15406b);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        super.unRegister();
        ActivityStack.removeStackChangedListener(this.f15405a);
        unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f15406b);
    }
}
