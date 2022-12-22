package com.didi.hawaii.basic;

import android.text.TextUtils;
import com.didi.hawaii.log.HWThreadPool;
import com.didi.hawaii.utils.C9266IO;
import java.io.File;

public class NetConfig {
    private static final String CONFIG_NAME = "net_config";
    /* access modifiers changed from: private */
    public static String netConfig = "";

    public static synchronized void init() {
        synchronized (NetConfig.class) {
            if (TextUtils.isEmpty(netConfig)) {
                HWThreadPool.execute(new Runnable() {
                    public void run() {
                        String unused = NetConfig.netConfig = C9266IO.readFromFile(NetConfig.CONFIG_NAME);
                    }
                });
            }
        }
    }

    public static String getNetConfig() {
        return netConfig;
    }

    public static synchronized void setNetConfig(String str) {
        synchronized (NetConfig.class) {
            netConfig = str;
            HWThreadPool.execute(new Runnable() {
                public void run() {
                    C9266IO.writeToFile(NetConfig.CONFIG_NAME, NetConfig.netConfig);
                }
            });
        }
    }

    public static void removeConfig() {
        netConfig = "";
        File fileStreamPath = HWContextProvider.getContext().getFileStreamPath(CONFIG_NAME);
        if (fileStreamPath.exists()) {
            fileStreamPath.delete();
        }
    }
}
