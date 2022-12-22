package com.didi.global.qrscan.inter;

import android.content.Intent;
import android.view.View;

public interface QRCodeProcess {
    boolean autoTorchEnabled();

    View.OnClickListener getGuideClickListener();

    String getGuideText();

    String getNoNetworkText();

    int getPinCodeInputCount();

    String getPinCodeTipText();

    String getScanText();

    void onActivityResult(int i, int i2, Intent intent);

    void onEnter(QRScanDelegate qRScanDelegate);

    void onEnterInputCode();

    void onInputCode(String str);

    void onLeave();

    void onLeaveInputCode();

    void onScanResult(String str);

    void onScanStart();

    void onScanStop();
}
