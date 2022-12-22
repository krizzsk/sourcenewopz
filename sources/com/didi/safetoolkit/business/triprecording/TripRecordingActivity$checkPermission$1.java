package com.didi.safetoolkit.business.triprecording;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
final class TripRecordingActivity$checkPermission$1 implements View.OnClickListener {
    final /* synthetic */ TripRecordingActivity this$0;

    TripRecordingActivity$checkPermission$1(TripRecordingActivity tripRecordingActivity) {
        this.this$0 = tripRecordingActivity;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r4) {
        /*
            r3 = this;
            com.didi.autotracker.AutoTrackHelper.trackViewOnClick(r4)
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x0023 }
            r4.<init>()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = "android.settings.APPLICATION_DETAILS_SETTINGS"
            r4.setAction(r0)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = "package"
            com.didi.safetoolkit.business.triprecording.TripRecordingActivity r1 = r3.this$0     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x0023 }
            r2 = 0
            android.net.Uri r0 = android.net.Uri.fromParts(r0, r1, r2)     // Catch:{ Exception -> 0x0023 }
            r4.setData(r0)     // Catch:{ Exception -> 0x0023 }
            com.didi.safetoolkit.business.triprecording.TripRecordingActivity r0 = r3.this$0     // Catch:{ Exception -> 0x0023 }
            r0.startActivity(r4)     // Catch:{ Exception -> 0x0023 }
            goto L_0x002f
        L_0x0023:
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x002f }
            java.lang.String r0 = "android.settings.SETTINGS"
            r4.<init>(r0)     // Catch:{ Exception -> 0x002f }
            com.didi.safetoolkit.business.triprecording.TripRecordingActivity r0 = r3.this$0     // Catch:{ Exception -> 0x002f }
            r0.startActivity(r4)     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safetoolkit.business.triprecording.TripRecordingActivity$checkPermission$1.onClick(android.view.View):void");
    }
}
