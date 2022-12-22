package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import android.content.Intent;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/ISctxBTMController;", "", "handleBluetoothPermissionRequestResult", "", "requestCode", "", "permissions", "", "", "grantedResult", "", "(I[Ljava/lang/String;[I)V", "handleBluetoothPermissionSettingBack", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "", "setNewIMMsgCome", "show", "setPassengerOnboard", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ISctxBTMController.kt */
public interface ISctxBTMController {
    void handleBluetoothPermissionRequestResult(int i, String[] strArr, int[] iArr);

    void handleBluetoothPermissionSettingBack(int i, int i2, Intent intent);

    boolean onBackPress();

    void setNewIMMsgCome(boolean z);

    void setPassengerOnboard();
}
