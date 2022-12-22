package com.didi.safetoolkit.business.triprecording;

import android.widget.Switch;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener2;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.safetoolkit.business.record.request.SfAutoRecordRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/safetoolkit/business/triprecording/TripRecordingActivity$refreshRecordingStatus$1$model$1", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener2;", "onClickInDrawer", "", "drawer", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
public final class TripRecordingActivity$refreshRecordingStatus$1$model$1 extends LEGOOnAntiShakeClickListener2 {
    final /* synthetic */ TripRecordingActivity$refreshRecordingStatus$1 this$0;

    TripRecordingActivity$refreshRecordingStatus$1$model$1(TripRecordingActivity$refreshRecordingStatus$1 tripRecordingActivity$refreshRecordingStatus$1) {
        this.this$0 = tripRecordingActivity$refreshRecordingStatus$1;
    }

    public void onClickInDrawer(LEGODrawer lEGODrawer) {
        Intrinsics.checkParameterIsNotNull(lEGODrawer, Const.DRAWER);
        SfAutoRecordRequest.autoRecordReport(1, 0);
        Switch access$getSwitchAutoRecording$p = this.this$0.this$0.f34481i;
        if (access$getSwitchAutoRecording$p != null) {
            access$getSwitchAutoRecording$p.setChecked(true);
        }
        lEGODrawer.dismiss();
        TripRecordOmageUtils.ibt_gp_safety_manualrecord_turnon_ck();
    }
}
