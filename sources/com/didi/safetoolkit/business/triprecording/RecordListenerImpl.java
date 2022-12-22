package com.didi.safetoolkit.business.triprecording;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/safetoolkit/business/triprecording/RecordListenerImpl;", "", "onAlreadyStart", "", "onError", "errCode", "", "onPause", "onResume", "onStart", "onStop", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingManager.kt */
public interface RecordListenerImpl {

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 15})
    /* compiled from: TripRecordingManager.kt */
    public static final class DefaultImpls {
        public static void onAlreadyStart(RecordListenerImpl recordListenerImpl) {
        }
    }

    void onAlreadyStart();

    void onError(int i);

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
