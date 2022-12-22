package com.didichuxing.alpha.lag;

import android.content.Context;
import com.didichuxing.alpha.lag.internal.BlockInfo;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class BlockCanaryContext implements BlockInterceptor {
    private static Context sApplicationContext;
    private static BlockCanaryContext sInstance;

    public List<String> concernPackages() {
        return null;
    }

    public boolean deleteFilesInWhiteList() {
        return true;
    }

    public boolean displayNotification() {
        return true;
    }

    public boolean filterNonConcernStack() {
        return false;
    }

    public void onBlock(Context context, BlockInfo blockInfo) {
    }

    public int provideMonitorDuration() {
        return -1;
    }

    public String provideNetworkType() {
        return "unknown";
    }

    public String providePath() {
        return "/blockcanary/";
    }

    public String provideQualifier() {
        return "unknown";
    }

    public String provideUid() {
        return "uid";
    }

    public boolean stopWhenDebugging() {
        return true;
    }

    public boolean zip(File[] fileArr, File file) {
        return false;
    }

    static void init(Context context, BlockCanaryContext blockCanaryContext) {
        sApplicationContext = context;
        sInstance = blockCanaryContext;
    }

    public static BlockCanaryContext get() {
        BlockCanaryContext blockCanaryContext = sInstance;
        if (blockCanaryContext != null) {
            return blockCanaryContext;
        }
        throw new RuntimeException("BlockCanaryContext null");
    }

    public Context provideContext() {
        return sApplicationContext;
    }

    public long provideBlockThreshold() {
        return OmegaConfig.LAG_TIME;
    }

    public long provideDumpInterval() {
        return provideBlockThreshold();
    }

    public void upload(File file) {
        throw new UnsupportedOperationException();
    }

    public List<String> provideWhiteList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("org.chromium");
        return linkedList;
    }
}
