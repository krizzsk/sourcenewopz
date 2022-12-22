package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMViewKt;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMViewModel$start$1", "Lcom/didiglobal/privacy/disclosure/PrivacyDisclosureBaseDialog$Callback;", "onNegativeResult", "", "onPositiveResult", "reason", "Lcom/didiglobal/privacy/disclosure/PositiveResultReason;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMViewModel.kt */
public final class BTMViewModel$start$1 implements PrivacyDisclosureBaseDialog.Callback {
    final /* synthetic */ BTMViewModel this$0;

    BTMViewModel$start$1(BTMViewModel bTMViewModel) {
        this.this$0 = bTMViewModel;
    }

    /* JADX WARNING: type inference failed for: r4v13, types: [java.lang.String] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPositiveResult(com.didiglobal.privacy.disclosure.PositiveResultReason r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0004
            java.lang.String r4 = ""
        L_0x0004:
            java.lang.String r0 = "PrivacyDisclosure onPositiveResult:"
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r4)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "bluetooth_meeting"
            com.didi.common.map.util.DLog.m7384d(r2, r4, r1)
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r4 = r3.this$0
            com.didi.map.global.flow.scene.order.bluetooth_meet.BluetoothPermissionHelper r4 = r4.f26497g
            boolean r4 = r4.checkBlueToothPermission()
            if (r4 != 0) goto L_0x0028
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r4 = r3.this$0
            com.didi.map.global.flow.scene.order.bluetooth_meet.BluetoothPermissionHelper r4 = r4.f26497g
            r4.requestBluetoothPermission()
            goto L_0x0046
        L_0x0028:
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r4 = r3.this$0
            com.didi.map.global.flow.scene.order.bluetooth_meet.BluetoothPermissionHelper r4 = r4.f26497g
            boolean r4 = r4.isEnable()
            if (r4 == 0) goto L_0x003a
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r4 = r3.this$0
            r4.m18805h()
            goto L_0x0046
        L_0x003a:
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r4 = r3.this$0
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel$start$1$onPositiveResult$1 r1 = new com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel$start$1$onPositiveResult$1
            r1.<init>(r4)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4.m18798a((boolean) r0, (kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>) r1)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel$start$1.onPositiveResult(com.didiglobal.privacy.disclosure.PositiveResultReason):void");
    }

    public void onNegativeResult() {
        DLog.m7384d(SctxBTMViewKt.BTM_TAG, "PrivacyDisclosure onNegativeResult", new Object[0]);
        this.this$0.m18802e();
    }
}
