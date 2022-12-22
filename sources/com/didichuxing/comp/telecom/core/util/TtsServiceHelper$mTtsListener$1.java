package com.didichuxing.comp.telecom.core.util;

import android.speech.tts.UtteranceProgressListener;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, mo175978d2 = {"com/didichuxing/comp/telecom/core/util/TtsServiceHelper$mTtsListener$1", "Landroid/speech/tts/UtteranceProgressListener;", "onDone", "", "utteranceId", "", "onError", "errorCode", "", "onStart", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TtsServiceHelper.kt */
public final class TtsServiceHelper$mTtsListener$1 extends UtteranceProgressListener {
    final /* synthetic */ TtsServiceHelper this$0;

    public void onError(String str) {
    }

    public void onStart(String str) {
    }

    TtsServiceHelper$mTtsListener$1(TtsServiceHelper ttsServiceHelper) {
        this.this$0 = ttsServiceHelper;
    }

    public void onDone(String str) {
        this.this$0.m33291a();
    }

    public void onError(String str, int i) {
        super.onError(str, i);
        String access$getTAG$p = this.this$0.f46415a;
        CallLogUtil.logError$default(access$getTAG$p, "tts play onError:" + i, (Throwable) null, 4, (Object) null);
        this.this$0.m33291a();
    }
}
