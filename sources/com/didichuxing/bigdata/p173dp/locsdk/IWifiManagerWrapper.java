package com.didichuxing.bigdata.p173dp.locsdk;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.IWifiManagerWrapper */
public interface IWifiManagerWrapper {
    WifiInfo getConnectionInfo();

    List<ScanResult> getScanResults();

    void init(Context context);

    boolean wifiEnabled();
}
