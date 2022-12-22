package com.didi.global.qrscan.inter;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;

public interface QRScanDelegate {
    void finish();

    Activity getActivity();

    Fragment getFragment();

    View getTitleBar();

    void goInputCode();

    void onRestart();

    void stopScan();
}
