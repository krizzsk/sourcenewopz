package com.didi.map.global.flow.scene.order.bluetooth_meet;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.component.bluetooth.client.ClientState;
import com.didi.map.global.component.bluetooth.client.DriverInfoResult;
import com.didi.map.global.component.bluetooth.client.IBleBluetoothClientCallback;
import com.didi.map.global.component.bluetooth.client.RssiInfoResult;
import com.didi.map.global.sdk.movement.ble.BlueToothEngine;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/bluetooth_meet/BTMNavDataEngine$setConfigParam$2", "Lcom/didi/map/global/component/bluetooth/client/IBleBluetoothClientCallback;", "onDriverInfoResult", "", "bleScanResult", "Lcom/didi/map/global/component/bluetooth/client/DriverInfoResult;", "onRssiInfoResult", "p0", "Lcom/didi/map/global/component/bluetooth/client/RssiInfoResult;", "onStateChange", "state", "Lcom/didi/map/global/component/bluetooth/client/ClientState;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMNavDataEngine.kt */
public final class BTMNavDataEngine$setConfigParam$2 implements IBleBluetoothClientCallback {
    final /* synthetic */ BTMNavDataEngindParam $param;
    final /* synthetic */ BTMNavDataEngine this$0;

    BTMNavDataEngine$setConfigParam$2(BTMNavDataEngine bTMNavDataEngine, BTMNavDataEngindParam bTMNavDataEngindParam) {
        this.this$0 = bTMNavDataEngine;
        this.$param = bTMNavDataEngindParam;
    }

    public void onStateChange(ClientState clientState) {
        this.this$0.f26434j.post(new Runnable(this.this$0, this.$param) {
            public final /* synthetic */ BTMNavDataEngine f$1;
            public final /* synthetic */ BTMNavDataEngindParam f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                BTMNavDataEngine$setConfigParam$2.m46490onStateChange$lambda1(ClientState.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onStateChange$lambda-1  reason: not valid java name */
    public static final void m46490onStateChange$lambda1(ClientState clientState, BTMNavDataEngine bTMNavDataEngine, BTMNavDataEngindParam bTMNavDataEngindParam) {
        OrientationManager access$getOrientationManager$p;
        IBTMBluetoothStateCallback bluetoothStateCallback;
        Intrinsics.checkNotNullParameter(bTMNavDataEngine, "this$0");
        if (!(clientState == null || bTMNavDataEngindParam == null || (bluetoothStateCallback = bTMNavDataEngindParam.getBluetoothStateCallback()) == null)) {
            bluetoothStateCallback.onConnectStateChange(clientState);
        }
        if (clientState == ClientState.ConnectSuccess && (access$getOrientationManager$p = bTMNavDataEngine.f26429e) != null) {
            access$getOrientationManager$p.addOrientationListener(bTMNavDataEngine.f26430f);
        }
    }

    public void onRssiInfoResult(RssiInfoResult rssiInfoResult) {
        BlueToothEngine access$getBluetoothEngine$p;
        if (rssiInfoResult != null && (access$getBluetoothEngine$p = this.this$0.f26427c) != null) {
            access$getBluetoothEngine$p.onReceiveRssi(rssiInfoResult.getRssi());
        }
    }

    public void onDriverInfoResult(DriverInfoResult driverInfoResult) {
        if (driverInfoResult == null) {
            BlueToothEngine access$getBluetoothEngine$p = this.this$0.f26427c;
            if (access$getBluetoothEngine$p != null) {
                access$getBluetoothEngine$p.onReceiveDriverLocation((BlueToothEngine.LocationInfo) null);
            }
        } else {
            BlueToothEngine.LocationInfo locationInfo = new BlueToothEngine.LocationInfo();
            locationInfo.pos = driverInfoResult.getDriverPos();
            locationInfo.acc = driverInfoResult.getDriverAcc();
            BlueToothEngine access$getBluetoothEngine$p2 = this.this$0.f26427c;
            if (access$getBluetoothEngine$p2 != null) {
                access$getBluetoothEngine$p2.onReceiveDriverLocation(locationInfo);
            }
        }
        Context access$getContext$p = this.this$0.f26426b;
        if (access$getContext$p != null) {
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(access$getContext$p.getApplicationContext()).getLastKnownLocation();
            if (lastKnownLocation == null || !BTMUtilsKt.isLocationInfoTimeAvailable(lastKnownLocation.getTime())) {
                BlueToothEngine access$getBluetoothEngine$p3 = this.this$0.f26427c;
                if (access$getBluetoothEngine$p3 != null) {
                    access$getBluetoothEngine$p3.onReceivePaxLocation((BlueToothEngine.LocationInfo) null);
                    return;
                }
                return;
            }
            BlueToothEngine.LocationInfo locationInfo2 = new BlueToothEngine.LocationInfo();
            locationInfo2.pos = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            locationInfo2.acc = lastKnownLocation.getAccuracy();
            BlueToothEngine access$getBluetoothEngine$p4 = this.this$0.f26427c;
            if (access$getBluetoothEngine$p4 != null) {
                access$getBluetoothEngine$p4.onReceivePaxLocation(locationInfo2);
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        throw null;
    }
}
