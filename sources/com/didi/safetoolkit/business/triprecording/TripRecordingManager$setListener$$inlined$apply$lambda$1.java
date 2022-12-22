package com.didi.safetoolkit.business.triprecording;

import com.didi.sdk.audiorecorder.helper.AudioUploader;
import com.didi.sdk.audiorecorder.model.RecordResult;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b¸\u0006\u0000"}, mo175978d2 = {"com/didi/safetoolkit/business/triprecording/TripRecordingManager$setListener$1$1", "Lcom/didi/sdk/audiorecorder/helper/AudioUploader$UploadListener;", "onFail", "", "record", "Lcom/didi/sdk/audiorecorder/model/RecordResult;", "errCode", "", "p2", "", "onSuccess", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingManager.kt */
public final class TripRecordingManager$setListener$$inlined$apply$lambda$1 implements AudioUploader.UploadListener {
    final /* synthetic */ TripRecordingManager this$0;

    public void onSuccess(RecordResult recordResult) {
    }

    TripRecordingManager$setListener$$inlined$apply$lambda$1(TripRecordingManager tripRecordingManager) {
        this.this$0 = tripRecordingManager;
    }

    public void onFail(RecordResult recordResult, int i, Throwable th) {
        String valueOf = String.valueOf(i);
        RecordingModel access$getMRecordingModel$p = this.this$0.f34488b;
        TripRecordOmageUtils.ibt_gd_safetyrecord_break_error_bt(valueOf, access$getMRecordingModel$p != null ? access$getMRecordingModel$p.getOid() : null);
    }
}
