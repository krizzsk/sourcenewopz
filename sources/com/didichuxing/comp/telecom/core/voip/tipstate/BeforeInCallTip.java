package com.didichuxing.comp.telecom.core.voip.tipstate;

import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.util.TtsServiceHelper;
import com.didichuxing.comp.telecom.core.voip.NoticeText;
import com.didichuxing.comp.telecom.core.voip.RoomInfo;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/tipstate/BeforeInCallTip;", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/AStateTip;", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "playedTts", "", "getTipStr", "", "component", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TipStateChain.kt */
public final class BeforeInCallTip extends AStateTip {

    /* renamed from: a */
    private boolean f46455a;

    public BeforeInCallTip(VoipAudioCall voipAudioCall) {
        super(voipAudioCall);
    }

    public String getTipStr(TipStateComponent tipStateComponent) {
        Intrinsics.checkParameterIsNotNull(tipStateComponent, "component");
        VoipAudioCall mVoipCall = getMVoipCall();
        if (mVoipCall == null || mVoipCall.getState().compareTo(CallState.IN_CALL) >= 0) {
            return null;
        }
        RoomInfo roomInfo = mVoipCall.getVoipCallModel().getRoomInfo();
        NoticeText noticeText = roomInfo != null ? roomInfo.getNoticeText() : null;
        String text = noticeText != null ? noticeText.getText() : null;
        IntRange timeRange = noticeText != null ? noticeText.timeRange() : null;
        if (!(text == null || StringsKt.isBlank(text) || timeRange == null)) {
            if (RangesKt.intRangeContains((ClosedRange<Integer>) timeRange, (System.currentTimeMillis() - mVoipCall.getCallInitTime()) / ((long) 1000))) {
                if (!this.f46455a) {
                    this.f46455a = true;
                    Integer ttsNum = noticeText.getTtsNum();
                    int intValue = ttsNum != null ? ttsNum.intValue() : 0;
                    for (int i = 0; i < intValue; i++) {
                        TtsServiceHelper.Companion.getInstance().play(text, false);
                    }
                }
                return text;
            }
        }
        return null;
    }
}
