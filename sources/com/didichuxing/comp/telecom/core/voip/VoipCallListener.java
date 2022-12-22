package com.didichuxing.comp.telecom.core.voip;

import androidx.core.app.NotificationCompat;
import com.didichuxing.comp.telecom.core.CallState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "", "notifyStateDes", "", "msg", "", "onAudioDeviceChange", "call", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "deviceState", "", "onMicStateChange", "voipAudioCall", "stateOn", "", "onStateChange", "state", "Lcom/didichuxing/comp/telecom/core/CallState;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipAudioCall.kt */
public interface VoipCallListener {

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 13})
    /* compiled from: VoipAudioCall.kt */
    public static final class DefaultImpls {
        public static void notifyStateDes(VoipCallListener voipCallListener, String str) {
        }

        public static void onAudioDeviceChange(VoipCallListener voipCallListener, VoipAudioCall voipAudioCall, int i) {
            Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        }

        public static void onMicStateChange(VoipCallListener voipCallListener, VoipAudioCall voipAudioCall, boolean z) {
            Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipAudioCall");
        }

        public static void onStateChange(VoipCallListener voipCallListener, VoipAudioCall voipAudioCall, CallState callState) {
            Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkParameterIsNotNull(callState, "state");
        }
    }

    void notifyStateDes(String str);

    void onAudioDeviceChange(VoipAudioCall voipAudioCall, int i);

    void onMicStateChange(VoipAudioCall voipAudioCall, boolean z);

    void onStateChange(VoipAudioCall voipAudioCall, CallState callState);
}
