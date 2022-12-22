package com.didi.safetoolkit.business.triprecording;

import com.didi.safetoolkit.api.ISFTripRecordingService;
import com.didi.safetoolkit.util.SfLog;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/safetoolkit/business/triprecording/TripRecordingManager$mRecordListener$1", "Lcom/didi/sdk/audiorecorder/helper/recorder/AudioRecorder$RecordListener;", "onPause", "", "onResume", "onStart", "onStop", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingManager.kt */
public final class TripRecordingManager$mRecordListener$1 implements AudioRecorder.RecordListener {
    final /* synthetic */ TripRecordingManager this$0;

    TripRecordingManager$mRecordListener$1(TripRecordingManager tripRecordingManager) {
        this.this$0 = tripRecordingManager;
    }

    public void onResume() {
        this.this$0.f34491e = true;
        RecordListenerImpl access$getMOutRecordListener$p = this.this$0.f34490d;
        if (access$getMOutRecordListener$p != null) {
            access$getMOutRecordListener$p.onResume();
        }
        ISFTripRecordingService bussinessCallback = this.this$0.getBussinessCallback();
        if (bussinessCallback != null) {
            bussinessCallback.onRecordingStatusChanged(true);
        }
        SfLog.m24409i(this.this$0.f34487a, "Recording onResume callback");
    }

    public void onPause() {
        this.this$0.f34491e = false;
        RecordListenerImpl access$getMOutRecordListener$p = this.this$0.f34490d;
        if (access$getMOutRecordListener$p != null) {
            access$getMOutRecordListener$p.onPause();
        }
        ISFTripRecordingService bussinessCallback = this.this$0.getBussinessCallback();
        if (bussinessCallback != null) {
            bussinessCallback.onRecordingStatusChanged(false);
        }
        SfLog.m24409i(this.this$0.f34487a, "Recording onPause callback");
    }

    public void onStart() {
        this.this$0.f34491e = true;
        RecordListenerImpl access$getMOutRecordListener$p = this.this$0.f34490d;
        if (access$getMOutRecordListener$p != null) {
            access$getMOutRecordListener$p.onStart();
        }
        ISFTripRecordingService bussinessCallback = this.this$0.getBussinessCallback();
        if (bussinessCallback != null) {
            bussinessCallback.onRecordingStatusChanged(true);
        }
        SfLog.m24409i(this.this$0.f34487a, "Recording onStart callback");
    }

    public void onStop() {
        this.this$0.f34491e = false;
        RecordListenerImpl access$getMOutRecordListener$p = this.this$0.f34490d;
        if (access$getMOutRecordListener$p != null) {
            access$getMOutRecordListener$p.onStop();
        }
        ISFTripRecordingService bussinessCallback = this.this$0.getBussinessCallback();
        if (bussinessCallback != null) {
            bussinessCallback.onRecordingStatusChanged(false);
        }
        SfLog.m24409i(this.this$0.f34487a, "Recording onStop callback");
    }
}
