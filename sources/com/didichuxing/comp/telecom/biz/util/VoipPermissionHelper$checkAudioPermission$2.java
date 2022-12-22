package com.didichuxing.comp.telecom.biz.util;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: VoipPermissionHelper.kt */
final class VoipPermissionHelper$checkAudioPermission$2 implements View.OnClickListener {
    final /* synthetic */ AudioGrantedCallback $callback;

    VoipPermissionHelper$checkAudioPermission$2(AudioGrantedCallback audioGrantedCallback) {
        this.$callback = audioGrantedCallback;
    }

    public final void onClick(View view) {
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        AutoTrackHelper.trackViewOnClick(view);
        CallLogUtil.logI(VoipPermissionHelper.f46384a, "checkAudioPermission - cancel");
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (!(config == null || (eventTickHandler = config.getEventTickHandler()) == null)) {
            eventTickHandler.onRequestAudioResult(false);
        }
        AudioGrantedCallback audioGrantedCallback = this.$callback;
        if (audioGrantedCallback != null) {
            audioGrantedCallback.onCancel();
        }
    }
}
