package com.didi.sdk.push.proxy;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class AddressProxy {
    private static final String FIELD_IP = "ip";
    private static final String FIELD_PORT = "port";
    private static AddressProxy sInstance;
    private Context context;
    private SharedPreferences.Editor editor;
    private AtomicBoolean init = new AtomicBoolean(false);
    private String proxyIp;
    private int proxyPort;
    private SharedPreferences sharedPreferences;

    public void clearIp() {
    }

    public void clearPort() {
    }

    private AddressProxy(Context context2) {
        this.context = context2;
    }

    public static AddressProxy getProxy(Context context2) {
        if (sInstance == null) {
            synchronized (AddressProxy.class) {
                if (sInstance == null) {
                    sInstance = new AddressProxy(context2);
                }
            }
        }
        return sInstance;
    }

    private void initLazy() {
        if (this.init.compareAndSet(false, true)) {
            SharedPreferences sharedPreferences2 = SystemUtils.getSharedPreferences(this.context, "push_address", 0);
            this.sharedPreferences = sharedPreferences2;
            this.editor = sharedPreferences2.edit();
        }
    }

    public String getIp() {
        return this.proxyIp;
    }

    public int getPort() {
        return this.proxyPort;
    }

    public void setIp(String str) {
        this.proxyIp = str;
    }

    public void setPort(int i) {
        this.proxyPort = i;
    }
}
