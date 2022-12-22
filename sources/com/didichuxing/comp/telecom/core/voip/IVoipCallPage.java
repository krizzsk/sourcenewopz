package com.didichuxing.comp.telecom.core.voip;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/IVoipCallPage;", "Lcom/didichuxing/comp/telecom/core/voip/IVoipCallRender;", "onBackPressed", "", "onPause", "", "onResume", "onStart", "onStop", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipAudioCall.kt */
public interface IVoipCallPage extends IVoipCallRender {

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 13})
    /* compiled from: VoipAudioCall.kt */
    public static final class DefaultImpls {
        public static boolean onBackPressed(IVoipCallPage iVoipCallPage) {
            return false;
        }

        public static void onPause(IVoipCallPage iVoipCallPage) {
        }

        public static void onResume(IVoipCallPage iVoipCallPage) {
        }

        public static void onStart(IVoipCallPage iVoipCallPage) {
        }

        public static void onStop(IVoipCallPage iVoipCallPage) {
        }
    }

    boolean onBackPressed();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
