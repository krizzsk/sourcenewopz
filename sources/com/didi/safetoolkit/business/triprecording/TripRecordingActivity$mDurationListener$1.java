package com.didi.safetoolkit.business.triprecording;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/safetoolkit/business/triprecording/TripRecordingActivity$mDurationListener$1", "Lcom/didi/safetoolkit/business/triprecording/DurationListener;", "onCallback", "", "duration", "", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
public final class TripRecordingActivity$mDurationListener$1 implements DurationListener {
    final /* synthetic */ TripRecordingActivity this$0;

    TripRecordingActivity$mDurationListener$1(TripRecordingActivity tripRecordingActivity) {
        this.this$0 = tripRecordingActivity;
    }

    public void onCallback(String str) {
        Intrinsics.checkParameterIsNotNull(str, "duration");
        TextView access$getMTvDuration$p = this.this$0.f34475c;
        if (access$getMTvDuration$p != null) {
            access$getMTvDuration$p.setText(str);
        }
    }
}
