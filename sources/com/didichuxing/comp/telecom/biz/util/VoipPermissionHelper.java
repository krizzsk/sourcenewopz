package com.didichuxing.comp.telecom.biz.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.View;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.impl.VoipBusinessImpl;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/util/VoipPermissionHelper;", "", "()V", "TAG", "", "checkAudioPermission", "", "activity", "Landroid/app/Activity;", "callback", "Lcom/didichuxing/comp/telecom/biz/util/AudioGrantedCallback;", "getAppName", "context", "Landroid/content/Context;", "tipGoSettingForAudio", "yesCallback", "Landroid/view/View$OnClickListener;", "noCallback", "tipNeedAudioPermission", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipPermissionHelper.kt */
public final class VoipPermissionHelper {
    public static final VoipPermissionHelper INSTANCE = new VoipPermissionHelper();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f46384a = f46384a;

    private VoipPermissionHelper() {
    }

    public final void checkAudioPermission(Activity activity, AudioGrantedCallback audioGrantedCallback) {
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || activity.checkSelfPermission(Permission.RECORD_AUDIO) == 0) {
            CallLogUtil.logI(f46384a, "checkAudioPermission - has granted");
            if (audioGrantedCallback != null) {
                audioGrantedCallback.onGranted();
                return;
            }
            return;
        }
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (!(config == null || (eventTickHandler = config.getEventTickHandler()) == null)) {
            eventTickHandler.onRequestAudioShow();
        }
        m33278a(activity, new VoipPermissionHelper$checkAudioPermission$1(activity, audioGrantedCallback), new VoipPermissionHelper$checkAudioPermission$2(audioGrantedCallback));
    }

    /* renamed from: a */
    private final void m33278a(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Activity activity2 = activity;
        View.OnClickListener onClickListener3 = onClickListener;
        VoipBusinessImpl.showTipDialog(activity2, activity.getString(R.string.GDriver_IBT_Please_the_HafM), activity.getString(R.string.GDriver_IBT_To_use_NIIn, new Object[]{getAppName(activity)}), activity.getString(R.string.Global_Driver_anzhuo_10_location_Open_cWFU), onClickListener3, activity.getString(R.string.Global_Driver_anzhuo_10_location_Cancel_aqJV), onClickListener2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m33279b(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Activity activity2 = activity;
        View.OnClickListener onClickListener3 = onClickListener;
        VoipBusinessImpl.showTipDialog(activity2, activity.getString(R.string.GDriver_IBT_Permission_applications_JIrp), activity.getString(R.string.GDriver_IBT_Open_the_eFOo, new Object[]{getAppName(activity)}), activity.getString(R.string.Global_Driver_anzhuo_10_location_Open_cWFU), onClickListener3, activity.getString(R.string.Global_Driver_anzhuo_10_location_Cancel_aqJV), onClickListener2);
    }

    public final String getAppName(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        String str2 = null;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Intrinsics.checkExpressionValueIsNotNull(applicationInfo, "context.applicationInfo");
            int i = applicationInfo.labelRes;
            if (i == 0) {
                str = applicationInfo.nonLocalizedLabel.toString();
            } else {
                str = context.getString(i);
            }
            str2 = str;
        } catch (Exception unused) {
        }
        if (str2 != null) {
            return str2;
        }
        return "";
    }
}
