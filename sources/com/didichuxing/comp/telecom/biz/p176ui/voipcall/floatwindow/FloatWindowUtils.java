package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/FloatWindowUtils;", "", "()V", "hasFloatWindowPermission", "", "context", "Landroid/content/Context;", "jumpSettingToGrantPermission", "", "Landroid/app/Activity;", "requestCode", "", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.FloatWindowUtils */
/* compiled from: FloatWindowUtils.kt */
public final class FloatWindowUtils {
    public static final FloatWindowUtils INSTANCE = new FloatWindowUtils();

    public final boolean hasFloatWindowPermission() {
        return hasFloatWindowPermission$default(this, (Context) null, 1, (Object) null);
    }

    private FloatWindowUtils() {
    }

    public static /* synthetic */ boolean hasFloatWindowPermission$default(FloatWindowUtils floatWindowUtils, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return floatWindowUtils.hasFloatWindowPermission(context);
    }

    public final boolean hasFloatWindowPermission(Context context) {
        if (context == null) {
            context = VoipFloatManager.Companion.getInstance().getMContext();
        }
        if (context == null || Build.VERSION.SDK_INT < 23 || !Settings.canDrawOverlays(context)) {
            return false;
        }
        return true;
    }

    public final void jumpSettingToGrantPermission(Activity activity, int i) {
        if (activity != null && Build.VERSION.SDK_INT >= 23) {
            Intent intent = new Intent();
            intent.setAction("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivityForResult(intent, i);
        }
    }
}
