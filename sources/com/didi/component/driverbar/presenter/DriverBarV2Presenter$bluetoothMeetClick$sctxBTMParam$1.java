package com.didi.component.driverbar.presenter;

import android.content.Intent;
import android.view.ViewGroup;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.IBTMHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/component/driverbar/presenter/DriverBarV2Presenter$bluetoothMeetClick$sctxBTMParam$1", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/IBTMHandler;", "onCloseClick", "", "onMsgClick", "onStartActivityForResult", "intent", "Landroid/content/Intent;", "requestCode", "", "onTelephoneClick", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarV2Presenter.kt */
public final class DriverBarV2Presenter$bluetoothMeetClick$sctxBTMParam$1 implements IBTMHandler {
    final /* synthetic */ DriverBarV2Presenter this$0;

    DriverBarV2Presenter$bluetoothMeetClick$sctxBTMParam$1(DriverBarV2Presenter driverBarV2Presenter) {
        this.this$0 = driverBarV2Presenter;
    }

    public void onCloseClick() {
        ViewGroup access$getMContainer$p = this.this$0.f13007f;
        if (access$getMContainer$p != null) {
            access$getMContainer$p.removeView(this.this$0.f13006e);
        }
        this.this$0.f13006e = null;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_CLOSE_IM);
    }

    public void onTelephoneClick() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Phone.EVENT_PHONE_CLICK);
    }

    public void onMsgClick() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.C4621IM.EVENT_IM_ENTRANCE_CLICK);
    }

    public void onStartActivityForResult(Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.this$0.startActivityForResult(intent, i);
    }
}
