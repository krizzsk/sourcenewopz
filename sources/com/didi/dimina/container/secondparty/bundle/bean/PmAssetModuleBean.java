package com.didi.dimina.container.secondparty.bundle.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PmAssetModuleBean implements Serializable {
    @SerializedName("flag")
    private String flag;
    @SerializedName("key")
    private String key;
    @SerializedName("lazy_download")
    private int lazyDownload;
    @SerializedName("md5")
    private String md5;
    @SerializedName("module_id")
    private int moduleId;
    @SerializedName("module_name")
    private String moduleName;
    @SerializedName("route")
    private String route;
    @SerializedName("version")
    private String version;
    private String versionName;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String str) {
        this.route = str;
    }

    public String getVersion() {
        return this.version;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void setVersion(String str, String str2) {
        this.version = str;
        this.versionName = str2;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(int i) {
        this.moduleId = i;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public int getLazyDownload() {
        return this.lazyDownload;
    }

    public void setLazyDownload(int i) {
        this.lazyDownload = i;
    }

    public String toString() {
        return "PmAssetModuleBean{key='" + this.key + '\'' + ", md5='" + this.md5 + '\'' + ", flag='" + this.flag + '\'' + ", route='" + this.route + '\'' + ", version='" + this.version + '\'' + ", moduleId=" + this.moduleId + ", moduleName='" + this.moduleName + '\'' + ", lazyDownload=" + this.lazyDownload + '}';
    }
}
