package com.didichuxing.comp.telecom.core.voip;

import com.didichuxing.comp.telecom.core.CallState;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/VoipSessionListener;", "", "onCallStateChange", "", "state", "Lcom/didichuxing/comp/telecom/core/CallState;", "onNetworkUnstable", "unstable", "", "onOppositeLeave", "onPersonChange", "feedCount", "", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipSessionImpl.kt */
public interface VoipSessionListener {
    void onCallStateChange(CallState callState);

    void onNetworkUnstable(boolean z);

    void onOppositeLeave();

    void onPersonChange(int i);
}
