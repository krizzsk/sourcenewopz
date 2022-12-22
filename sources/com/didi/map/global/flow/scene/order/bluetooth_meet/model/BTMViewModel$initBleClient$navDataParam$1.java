package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import com.didi.common.map.util.DLog;
import com.didi.map.global.component.bluetooth.client.ClientState;
import com.didi.map.global.flow.scene.order.bluetooth_meet.BTMNavDataEngine;
import com.didi.map.global.flow.scene.order.bluetooth_meet.IBTMBluetoothStateCallback;
import com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMViewKt;
import com.didi.map.global.sdk.movement.ble.BleNavGuide;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMViewModel$initBleClient$navDataParam$1", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/IBTMBluetoothStateCallback;", "onBleArrived", "", "eda", "", "onBleNavListener", "bleNavGuide", "Lcom/didi/map/global/sdk/movement/ble/BleNavGuide;", "onConnectStateChange", "state", "Lcom/didi/map/global/component/bluetooth/client/ClientState;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMViewModel.kt */
public final class BTMViewModel$initBleClient$navDataParam$1 implements IBTMBluetoothStateCallback {
    final /* synthetic */ BTMViewModel this$0;

    BTMViewModel$initBleClient$navDataParam$1(BTMViewModel bTMViewModel) {
        this.this$0 = bTMViewModel;
    }

    public void onConnectStateChange(ClientState clientState) {
        if (clientState != null) {
            this.this$0.m18793a(clientState);
        }
    }

    public void onBleNavListener(BleNavGuide bleNavGuide) {
        if (bleNavGuide != null) {
            this.this$0.m18796a(bleNavGuide);
        }
    }

    public void onBleArrived(int i) {
        DLog.m7384d(SctxBTMViewKt.BTM_TAG, Intrinsics.stringPlus("on ble engine called Arrived eda:", Integer.valueOf(i)), new Object[0]);
        BTMNavDataEngine access$getBtmNavEngine$p = this.this$0.f26498h;
        if (access$getBtmNavEngine$p != null) {
            access$getBtmNavEngine$p.destroy();
        }
        this.this$0.f26496f.setValue(new Pair(Double.valueOf((double) i), Double.valueOf(0.0d)));
        this.this$0.toState(BTMState.VERY_NEAR);
    }
}
