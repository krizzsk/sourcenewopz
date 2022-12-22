package com.didichuxing.comp.telecom.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didichuxing/comp/telecom/core/util/AudioServiceHelper$mReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: AudioServiceHelper.kt */
public final class AudioServiceHelper$mReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ AudioServiceHelper this$0;

    AudioServiceHelper$mReceiver$1(AudioServiceHelper audioServiceHelper) {
        this.this$0 = audioServiceHelper;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            boolean z = true;
            if (hashCode != -1676458352) {
                if (hashCode == 545516589 && action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    if (intExtra == 2) {
                        this.this$0.f46402e = true;
                    } else if (intExtra == 0) {
                        this.this$0.f46402e = false;
                    }
                    String access$getTAG$p = this.this$0.f46398a;
                    CallLogUtil.logI(access$getTAG$p, "BluetoothHeadset change - isBluetoothLinked:" + this.this$0.f46402e);
                }
            } else if (action.equals("android.intent.action.HEADSET_PLUG")) {
                int intExtra2 = intent.getIntExtra("state", 0);
                AudioServiceHelper audioServiceHelper = this.this$0;
                if (intExtra2 != 1) {
                    z = false;
                }
                audioServiceHelper.f46403f = z;
                String access$getTAG$p2 = this.this$0.f46398a;
                CallLogUtil.logI(access$getTAG$p2, "HEADSET change - isHeadsetLinked:" + this.this$0.f46403f);
            }
        }
        this.this$0.m33284a();
    }
}
