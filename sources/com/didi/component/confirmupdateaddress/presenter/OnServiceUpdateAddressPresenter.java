package com.didi.component.confirmupdateaddress.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.confirmupdateaddress.view.IUpdateAddress;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;

public class OnServiceUpdateAddressPresenter extends IPresenter<IUpdateAddress> {

    /* renamed from: a */
    private BaseEventPublisher.OnEventListener<Boolean> f12706a = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (!TextUtils.equals(str, BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA) || OnServiceUpdateAddressPresenter.this.mView == null) {
                return;
            }
            if (bool.booleanValue()) {
                ((IUpdateAddress) OnServiceUpdateAddressPresenter.this.mView).setViewVisible(8);
                return;
            }
            ((IUpdateAddress) OnServiceUpdateAddressPresenter.this.mView).setViewVisible(0);
            ((IUpdateAddress) OnServiceUpdateAddressPresenter.this.mView).updateChangeVisible();
        }
    };

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<Boolean> f12707b = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (!TextUtils.equals(str, BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_EDIT) || OnServiceUpdateAddressPresenter.this.mView == null) {
                return;
            }
            if (bool.booleanValue()) {
                ((IUpdateAddress) OnServiceUpdateAddressPresenter.this.mView).setChangeVisible(8);
            } else {
                ((IUpdateAddress) OnServiceUpdateAddressPresenter.this.mView).setChangeVisible(0);
            }
        }
    };

    /* renamed from: c */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12708c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            ((IUpdateAddress) OnServiceUpdateAddressPresenter.this.mView).updateAddress();
        }
    };

    public OnServiceUpdateAddressPresenter(Context context) {
        super(context);
    }

    /* renamed from: b */
    private void m8655b() {
        subscribe(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, this.f12706a);
        subscribe(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_EDIT, this.f12707b);
        subscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CHANGE_ADDRESS, this.f12708c);
    }

    /* renamed from: c */
    private void m8657c() {
        unsubscribe(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, this.f12706a);
        unsubscribe(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_EDIT, this.f12707b);
        unsubscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CHANGE_ADDRESS, this.f12708c);
    }

    public void onChangeClick() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        bundle.putBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE_V2, true);
        forward(1035, bundle);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m8655b();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m8657c();
    }
}
