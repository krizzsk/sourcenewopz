package com.didichuxing.comp.telecom.core.voip;

import android.os.Build;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallUtils;
import com.didichuxing.mlcp.drtc.interfaces.DrtcSDKInitializeListener;
import com.didichuxing.mlcp.drtc.interfaces.InCallingService;
import com.didichuxing.mlcp.drtc.sdk.DrtcSDK;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, mo175978d2 = {"com/didichuxing/comp/telecom/core/voip/VoipSessionImpl$mSdkInitCallback$1", "Lcom/didichuxing/mlcp/drtc/interfaces/DrtcSDKInitializeListener;", "onSDKInitializeResult", "", "p0", "", "onSDKLogMessage", "", "onSDKReleased", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipSessionImpl.kt */
public final class VoipSessionImpl$mSdkInitCallback$1 implements DrtcSDKInitializeListener {
    final /* synthetic */ VoipSessionImpl this$0;

    VoipSessionImpl$mSdkInitCallback$1(VoipSessionImpl voipSessionImpl) {
        this.this$0 = voipSessionImpl;
    }

    public void onSDKInitializeResult(int i) {
        InCallingService access$getMCallFunctionService$p;
        String str = "onSDKInitializeResult " + i;
        CallLogUtil.logI(this.this$0.f46440a, str);
        if (i != 0) {
            this.this$0.m33303a(CallUtils.INSTANCE.getStringRes(Integer.valueOf(R.string.GDriver_IBT_System_exception_uzlx)));
            this.this$0.m33305b(str);
            return;
        }
        this.this$0.f46448i = 3;
        VoipSessionImpl voipSessionImpl = this.this$0;
        DrtcSDK access$getMDrtcSDK$p = voipSessionImpl.f46444e;
        voipSessionImpl.f46445f = access$getMDrtcSDK$p != null ? access$getMDrtcSDK$p.getCallingService() : null;
        VoipSessionImpl voipSessionImpl2 = this.this$0;
        DrtcSDK access$getMDrtcSDK$p2 = voipSessionImpl2.f46444e;
        voipSessionImpl2.f46446g = access$getMDrtcSDK$p2 != null ? access$getMDrtcSDK$p2.getInCallingService() : null;
        if (Build.VERSION.SDK_INT <= 28 && (access$getMCallFunctionService$p = this.this$0.f46446g) != null) {
            BindWithTripRecorder bindWithTripRecorder = new BindWithTripRecorder();
            bindWithTripRecorder.bindWithTripRecorder(this.this$0, access$getMCallFunctionService$p);
            this.this$0.f46447h = bindWithTripRecorder;
        }
        Runnable access$getMActionDelay$p = this.this$0.f46443d;
        if (access$getMActionDelay$p != null) {
            access$getMActionDelay$p.run();
        }
        this.this$0.f46443d = null;
    }

    public void onSDKReleased() {
        CallLogUtil.logI(this.this$0.f46440a, "onSDKReleased");
    }

    public void onSDKLogMessage(String str) {
        String access$getTAG$p = this.this$0.f46440a;
        CallLogUtil.logI(access$getTAG$p, "onSDKLogMessage - " + str);
    }
}
