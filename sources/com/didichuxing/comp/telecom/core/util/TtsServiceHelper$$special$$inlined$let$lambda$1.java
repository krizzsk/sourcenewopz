package com.didichuxing.comp.telecom.core.util;

import android.speech.tts.TextToSpeech;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"<anonymous>", "", "state", "", "onInit", "com/didichuxing/comp/telecom/core/util/TtsServiceHelper$1$1"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: TtsServiceHelper.kt */
final class TtsServiceHelper$$special$$inlined$let$lambda$1 implements TextToSpeech.OnInitListener {
    final /* synthetic */ TtsServiceHelper this$0;

    TtsServiceHelper$$special$$inlined$let$lambda$1(TtsServiceHelper ttsServiceHelper) {
        this.this$0 = ttsServiceHelper;
    }

    public final void onInit(int i) {
        if (i == 0) {
            this.this$0.f46416b = true;
            TextToSpeech access$getMTts$p = this.this$0.f46417c;
            if (access$getMTts$p != null) {
                access$getMTts$p.setOnUtteranceProgressListener(this.this$0.f46418d);
            }
            this.this$0.m33291a();
        }
    }
}
