package com.didichuxing.mas.sdk.quality.report;

public class MASMapConfig {
    public static IConfig config;

    public interface IConfig {
        int getAppVersionCode();

        String getAppVersionName();

        String getPackageName();

        boolean getSwitchAutoUI();

        String getUploadHost();
    }
}
