package com.didichuxing.comp.telecom.biz.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.util.VoipPermissionHelper$checkAudioPermission$1$1$onPermissionDenied$1 */
/* compiled from: VoipPermissionHelper.kt */
final class C15217x8279f37c implements View.OnClickListener {
    public static final C15217x8279f37c INSTANCE = new C15217x8279f37c();

    C15217x8279f37c() {
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        CallLogUtil.logI(VoipPermissionHelper.f46384a, "onPermissionGranted - click to go setting");
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Context context = view.getContext();
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        sb.append(context.getPackageName());
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
