package com.didi.safetoolkit.business.triprecording;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "recordDuration", "", "onTimeTick"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingManager.kt */
final class TripRecordingManager$mDurationChangedListener$1 implements AudioRecorder.DurationChangedListener {
    final /* synthetic */ TripRecordingManager this$0;

    TripRecordingManager$mDurationChangedListener$1(TripRecordingManager tripRecordingManager) {
        this.this$0 = tripRecordingManager;
    }

    public final void onTimeTick(int i) {
        for (DurationListener durationListener : this.this$0.f34489c) {
            if (durationListener != null) {
                durationListener.onCallback(this.this$0.m24373a(i / 1000));
            }
        }
    }
}
