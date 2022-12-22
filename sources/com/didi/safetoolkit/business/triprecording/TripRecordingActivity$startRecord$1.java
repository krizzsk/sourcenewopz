package com.didi.safetoolkit.business.triprecording;

import android.widget.Toast;
import com.didi.safetoolkit.dialog.DiDiLoadingDialog;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.util.SfUIThreadHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/safetoolkit/business/triprecording/TripRecordingActivity$startRecord$1", "Lcom/didi/safetoolkit/business/triprecording/RecordListenerImpl;", "onAlreadyStart", "", "onError", "errCode", "", "onPause", "onResume", "onStart", "onStop", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
public final class TripRecordingActivity$startRecord$1 implements RecordListenerImpl {
    final /* synthetic */ DiDiLoadingDialog $loadingDialog;
    final /* synthetic */ TripRecordingActivity this$0;

    TripRecordingActivity$startRecord$1(TripRecordingActivity tripRecordingActivity, DiDiLoadingDialog diDiLoadingDialog) {
        this.this$0 = tripRecordingActivity;
        this.$loadingDialog = diDiLoadingDialog;
    }

    public void onResume() {
        this.$loadingDialog.removeLoadingDialog();
        this.this$0.m24369a();
    }

    public void onPause() {
        this.$loadingDialog.removeLoadingDialog();
        this.this$0.m24369a();
    }

    public void onStart() {
        this.$loadingDialog.removeLoadingDialog();
        this.this$0.m24369a();
        SfUIThreadHelper.post(TripRecordingActivity$startRecord$1$onStart$1.INSTANCE);
    }

    public void onStop() {
        this.$loadingDialog.removeLoadingDialog();
        this.this$0.m24369a();
    }

    public void onError(int i) {
        this.$loadingDialog.removeLoadingDialog();
        SystemUtils.showToast(Toast.makeText(this.this$0, SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_V1_Try_again_Zkua), 1));
    }

    public void onAlreadyStart() {
        this.$loadingDialog.removeLoadingDialog();
    }
}
