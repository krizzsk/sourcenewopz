package com.didi.component.comp_config.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.comp_config.AbsConfigPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.BusinessContext;

public class ConfirmConfigPresenter extends AbsConfigPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f12132a;
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mPriceListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE.equals(str)) {
                boolean unused = ConfirmConfigPresenter.this.f12132a = false;
                ConfirmConfigPresenter.this.doPublish(BaseEventKeys.XEngine.EVENT_XENGINE_SCENE_HANDLE, XERequestKey.SCENE_ESTIMATE);
            }
        }
    };
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mShowConfirmEventListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS.equals(str)) {
                boolean unused = ConfirmConfigPresenter.this.f12132a = true;
                ConfirmConfigPresenter.this.doPublish(BaseEventKeys.XEngine.EVENT_XENGINE_SCENE_HANDLE, XERequestKey.SCENE_CONFIRM);
            }
        }
    };

    public ConfirmConfigPresenter(BusinessContext businessContext) {
        super(businessContext);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.mShowConfirmEventListener);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.mPriceListener);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.mShowConfirmEventListener);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.mPriceListener);
    }
}
