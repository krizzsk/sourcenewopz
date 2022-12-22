package com.didi.dimina.container.secondparty.bundle.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class PmAssetAppConfigBean implements Serializable {
    @SerializedName("app_id")
    private String appId;
    @SerializedName("app_version_code")
    private String appVersionCode;
    @SerializedName("app_version_name")
    private String appVersionName;
    @SerializedName("channel")
    private String channel;
    @SerializedName("min_version")
    private String minVersion;
    @SerializedName("modules")
    private List<PmAssetModuleBean> modules;
    @SerializedName("version")
    private String version;

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public List<PmAssetModuleBean> getModules() {
        return this.modules;
    }

    public void setModules(List<PmAssetModuleBean> list) {
        this.modules = list;
    }

    public String getVersion() {
        return getAppVersionCode();
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getMinVersion() {
        return this.minVersion;
    }

    public void setMinVersion(String str) {
        this.minVersion = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    public void setAppVersionName(String str) {
        this.appVersionName = str;
    }

    public String getAppVersionCode() {
        return this.appVersionCode;
    }

    public void setAppVersionCode(String str) {
        this.appVersionCode = str;
    }

    public String toString() {
        return "PmAssetAppConfigBean{appId='" + this.appId + '\'' + ", modules=" + this.modules + ", version='" + this.version + '\'' + ", appVersionName='" + this.appVersionName + '\'' + ", appVersionCode='" + this.appVersionCode + '\'' + ", minVersion='" + this.minVersion + '\'' + ", channel='" + this.channel + '\'' + '}';
    }
}
