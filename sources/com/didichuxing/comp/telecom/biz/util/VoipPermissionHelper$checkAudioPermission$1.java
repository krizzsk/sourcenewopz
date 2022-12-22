package com.didichuxing.comp.telecom.biz.util;

import android.app.Activity;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.permission.DPermission;
import com.didi.permission.OnPermissionCallback;
import com.didi.raven.config.RavenKey;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.yanzhenjie.permission.runtime.Permission;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: VoipPermissionHelper.kt */
final class VoipPermissionHelper$checkAudioPermission$1 implements View.OnClickListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ AudioGrantedCallback $callback;

    VoipPermissionHelper$checkAudioPermission$1(Activity activity, AudioGrantedCallback audioGrantedCallback) {
        this.$activity = activity;
        this.$callback = audioGrantedCallback;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        DPermission.permissionRequest(this.$activity, 1001, new String[]{Permission.RECORD_AUDIO}, (OnPermissionCallback) new OnPermissionCallback(this) {
            final /* synthetic */ VoipPermissionHelper$checkAudioPermission$1 this$0;

            {
                this.this$0 = r1;
            }

            public void onPermissionGranted(int i) {
                CallManagerAssist.CallEventTickHandler eventTickHandler;
                CallLogUtil.logI(VoipPermissionHelper.f46384a, "onPermissionGranted - granted");
                AudioGrantedCallback audioGrantedCallback = this.this$0.$callback;
                if (audioGrantedCallback != null) {
                    audioGrantedCallback.onGranted();
                }
                CallManagerAssist instance = CallManagerAssist.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
                CallManagerAssist.CallManagerConfig config = instance.getConfig();
                if (config != null && (eventTickHandler = config.getEventTickHandler()) != null) {
                    eventTickHandler.onRequestAudioResult(true);
                }
            }

            public void onPermissionDenied(String str, int i, boolean z) {
                CallManagerAssist.CallEventTickHandler eventTickHandler;
                Intrinsics.checkParameterIsNotNull(str, RavenKey.STACK);
                CallManagerAssist instance = CallManagerAssist.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
                CallManagerAssist.CallManagerConfig config = instance.getConfig();
                if (!(config == null || (eventTickHandler = config.getEventTickHandler()) == null)) {
                    eventTickHandler.onRequestAudioResult(false);
                }
                if (z) {
                    CallLogUtil.logI(VoipPermissionHelper.f46384a, "onPermissionGranted - show go setting");
                    VoipPermissionHelper.INSTANCE.m33279b(this.this$0.$activity, C15217x8279f37c.INSTANCE, new C15218x8279f37d(this));
                    return;
                }
                CallLogUtil.logI(VoipPermissionHelper.f46384a, "onPermissionGranted - cancel");
                AudioGrantedCallback audioGrantedCallback = this.this$0.$callback;
                if (audioGrantedCallback != null) {
                    audioGrantedCallback.onCancel();
                }
            }
        });
    }
}
