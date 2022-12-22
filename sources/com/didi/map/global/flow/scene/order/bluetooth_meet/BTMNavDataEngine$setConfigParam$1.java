package com.didi.map.global.flow.scene.order.bluetooth_meet;

import com.didi.map.global.sdk.movement.ble.BleNavGuide;
import com.didi.map.global.sdk.movement.ble.onBleNavListener;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/bluetooth_meet/BTMNavDataEngine$setConfigParam$1", "Lcom/didi/map/global/sdk/movement/ble/onBleNavListener;", "onBleNavGuide", "", "bleNavGuide", "Lcom/didi/map/global/sdk/movement/ble/BleNavGuide;", "onNavArrived", "p0", "", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMNavDataEngine.kt */
public final class BTMNavDataEngine$setConfigParam$1 implements onBleNavListener {
    final /* synthetic */ BTMNavDataEngindParam $param;
    final /* synthetic */ BTMNavDataEngine this$0;

    BTMNavDataEngine$setConfigParam$1(BTMNavDataEngine bTMNavDataEngine, BTMNavDataEngindParam bTMNavDataEngindParam) {
        this.this$0 = bTMNavDataEngine;
        this.$param = bTMNavDataEngindParam;
    }

    public void onBleNavGuide(BleNavGuide bleNavGuide) {
        if (bleNavGuide != null) {
            BTMNavDataEngine bTMNavDataEngine = this.this$0;
            bTMNavDataEngine.f26432h = bleNavGuide.direct_pax_toDriver;
            bTMNavDataEngine.f26433i = bleNavGuide.eda;
            bTMNavDataEngine.m18750a();
        }
    }

    public void onNavArrived(int i) {
        IBTMBluetoothStateCallback bluetoothStateCallback;
        BTMNavDataEngindParam bTMNavDataEngindParam = this.$param;
        if (bTMNavDataEngindParam != null && (bluetoothStateCallback = bTMNavDataEngindParam.getBluetoothStateCallback()) != null) {
            bluetoothStateCallback.onBleArrived(i);
        }
    }
}
