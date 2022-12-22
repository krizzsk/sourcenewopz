package com.didi.safetoolkit.business.emergency;

import android.content.Intent;
import android.view.View;
import com.android.didi.safetoolkit.presenter.IBaseView;
import com.didi.safetoolkit.model.SfLocation;

public interface ISfEmergencyAssistanceView extends IBaseView {
    void runOnUiThread(Runnable runnable);

    void showLocationLoadedFailStatus();

    void showLocationLoadedSucceedStatus(SfLocation sfLocation);

    void showLocationLoadingStatus();

    void showStopEmerAssistConfirmDialog(View.OnClickListener onClickListener);

    void startActivity(Intent intent);

    void startCallButtonAnimation();

    void stopCallButtonAnimation();

    void updateUIByCallPoliceState(boolean z);
}
