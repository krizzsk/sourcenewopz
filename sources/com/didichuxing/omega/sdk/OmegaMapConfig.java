package com.didichuxing.omega.sdk;

public class OmegaMapConfig {
    public static IConfig config;

    public interface IConfig {
        int getAppVersionCode();

        String getAppVersionName();

        String getPackageName();

        boolean getSwitchAutoUI();

        String getUploadHost();
    }
}
