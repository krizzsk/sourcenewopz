package com.didichuxing.bigdata.p173dp.locsdk;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.WifiManagerWrapper */
public class WifiManagerWrapper implements IWifiManagerWrapper {

    /* renamed from: a */
    private IWifiManagerWrapper f45741a;

    private WifiManagerWrapper() {
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.WifiManagerWrapper$SingletonHolder */
    private static class SingletonHolder {
        static final WifiManagerWrapper INSTANCE = new WifiManagerWrapper();

        private SingletonHolder() {
        }
    }

    public static WifiManagerWrapper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* renamed from: a */
    private synchronized void m32753a(Context context) {
        this.f45741a = com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.WifiManagerWrapper.getInstance();
    }

    /* renamed from: a */
    private synchronized IWifiManagerWrapper m32752a() {
        return this.f45741a;
    }

    public void init(Context context) {
        m32753a(context);
        m32752a().init(context);
    }

    public WifiInfo getConnectionInfo() {
        return m32752a().getConnectionInfo();
    }

    public List<ScanResult> getScanResults() {
        return m32752a().getScanResults();
    }

    public boolean wifiEnabled() {
        return m32752a().wifiEnabled();
    }
}
