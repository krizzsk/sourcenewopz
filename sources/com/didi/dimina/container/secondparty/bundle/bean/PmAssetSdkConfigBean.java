package com.didi.dimina.container.secondparty.bundle.bean;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.secondparty.bundle.DiminaHelper;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class PmAssetSdkConfigBean implements Serializable {
    private String appId;
    @SerializedName("channel")
    private String channel;
    @SerializedName("mode")
    private String mode;
    @SerializedName("modules")
    private List<PmAssetModuleBean> modules;
    @SerializedName("sdk_version_code")
    private String sdkVersionCode;
    @SerializedName("sdk_version_name")
    private String sdkVersionName;
    @SerializedName("version")
    private String version;

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public String getAppId(DMMina dMMina) {
        return DiminaHelper.getJsSdkId(dMMina);
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
        return getSdkVersionCode();
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getSdkVersionName() {
        return this.sdkVersionName;
    }

    public void setSdkVersionName(String str) {
        this.sdkVersionName = str;
    }

    public String getSdkVersionCode() {
        return this.sdkVersionCode;
    }

    public void setSdkVersionCode(String str) {
        this.sdkVersionCode = str;
    }

    public String toString() {
        return "PmAssetSdkConfigBean{mode='" + this.mode + '\'' + ", appId='" + this.appId + '\'' + ", modules=" + this.modules + ", version='" + this.version + '\'' + ", sdkVersionName='" + this.sdkVersionName + '\'' + ", sdkVersionCode='" + this.sdkVersionCode + '\'' + ", channel='" + this.channel + '\'' + '}';
    }
}
