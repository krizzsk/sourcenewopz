package com.didi.safetoolkit.api;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J8\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/safetoolkit/api/ISFTripRecordingService;", "", "getAlias", "", "onRecordingStatusChanged", "", "isRecording", "", "openLawWebView", "showDialog", "activity", "Landroidx/fragment/app/FragmentActivity;", "title", "content", "posText", "negText", "positiveBtnListener", "Landroid/view/View$OnClickListener;", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ISFTripRecordingService.kt */
public interface ISFTripRecordingService {
    String getAlias();

    void onRecordingStatusChanged(boolean z);

    void openLawWebView();

    void showDialog(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener);
}
