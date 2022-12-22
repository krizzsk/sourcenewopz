package com.didi.map.global.flow.scene.order.bluetooth_meet;

import com.didi.map.global.component.bluetooth.client.ClientState;
import com.didi.map.global.sdk.movement.ble.BleNavGuide;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/IBTMBluetoothStateCallback;", "", "onBleArrived", "", "eda", "", "onBleNavListener", "bleNavGuide", "Lcom/didi/map/global/sdk/movement/ble/BleNavGuide;", "onConnectStateChange", "state", "Lcom/didi/map/global/component/bluetooth/client/ClientState;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMNavDataEngine.kt */
public interface IBTMBluetoothStateCallback {
    void onBleArrived(int i);

    void onBleNavListener(BleNavGuide bleNavGuide);

    void onConnectStateChange(ClientState clientState);
}
