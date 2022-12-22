package com.didichuxing.comp.telecom.biz.util;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.comp.telecom.biz.util.VoipPermissionHelper$checkAudioPermission$1;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.util.VoipPermissionHelper$checkAudioPermission$1$1$onPermissionDenied$2 */
/* compiled from: VoipPermissionHelper.kt */
final class C15218x8279f37d implements View.OnClickListener {
    final /* synthetic */ VoipPermissionHelper$checkAudioPermission$1.C152161 this$0;

    C15218x8279f37d(VoipPermissionHelper$checkAudioPermission$1.C152161 r1) {
        this.this$0 = r1;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        AudioGrantedCallback audioGrantedCallback = this.this$0.this$0.$callback;
        if (audioGrantedCallback != null) {
            audioGrantedCallback.onCancel();
        }
    }
}
