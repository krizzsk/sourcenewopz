package com.didi.dimina.container.secondparty.bundle.bean;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.secondparty.bundle.DiminaHelper;
import com.didi.dimina.container.util.CollectionsUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.p071io.IOUtils;

public class DMConfigBean implements Serializable, Cloneable {
    @SerializedName("app_id")
    private String appId;
    @SerializedName("app_modules")
    private List<AppModulesBean> appModules;
    @SerializedName("app_version_code")
    private String appVersionCode;
    @SerializedName("app_version_name")
    private String appVersionName;
    @SerializedName("sdk_id")
    private String sdkId;
    @SerializedName("sdk_module")
    private AppModulesBean sdkModule;
    @SerializedName("sdk_version_code")
    private String sdkVersionCode;
    @SerializedName("sdk_version_name")
    private String sdkVersionName;
    @SerializedName("update_strategy")
    private int updateStrategy;

    public void setAppVersionCode(String str) {
        this.appVersionCode = str;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    public void setAppVersionName(String str) {
        this.appVersionName = str;
    }

    public void setSdkVersionCode(String str) {
        this.sdkVersionCode = str;
    }

    public String getSdkVersionName() {
        return this.sdkVersionName;
    }

    public void setSdkVersionName(String str) {
        this.sdkVersionName = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getAppVersionCode() {
        return this.appVersionCode;
    }

    public void setAppVersion(String str, String str2) {
        this.appVersionCode = str;
        this.appVersionName = str2;
    }

    public String getSdkId(DMMina dMMina) {
        if (TextUtils.isEmpty(this.sdkId)) {
            return DiminaHelper.getJsSdkId(dMMina);
        }
        return this.sdkId;
    }

    public void setSdkId(String str) {
        this.sdkId = str;
    }

    public String getSdkVersionCode() {
        return this.sdkVersionCode;
    }

    public void setSdkVersion(String str, String str2) {
        this.sdkVersionCode = str;
        this.sdkVersionName = str2;
    }

    public List<AppModulesBean> getAppModules() {
        return this.appModules;
    }

    public void setAppModules(List<AppModulesBean> list) {
        this.appModules = list;
    }

    public AppModulesBean getSdkModule() {
        return this.sdkModule;
    }

    public void setSdkModule(AppModulesBean appModulesBean) {
        this.sdkModule = appModulesBean;
    }

    public int getUpdateStrategy() {
        return this.updateStrategy;
    }

    public void setUpdateStrategy(int i) {
        this.updateStrategy = i;
    }

    public Object clone() {
        try {
            DMConfigBean dMConfigBean = (DMConfigBean) super.clone();
            if (!CollectionsUtil.isEmpty((Collection) this.appModules)) {
                ArrayList arrayList = new ArrayList();
                for (AppModulesBean clone : this.appModules) {
                    arrayList.add((AppModulesBean) clone.clone());
                }
                dMConfigBean.setAppModules(arrayList);
            }
            if (this.sdkModule != null) {
                dMConfigBean.setSdkModule((AppModulesBean) this.sdkModule.clone());
            }
            return dMConfigBean;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        int i = this.sdkModule != null ? 1 : 0;
        int size = CollectionsUtil.getSize((Collection) this.appModules);
        return "DmConfigBean{app_id='" + this.appId + '\'' + ", sdk_id='" + this.sdkId + '\'' + ", appVersion Code/Name='" + getAppVersionCode() + IOUtils.DIR_SEPARATOR_UNIX + getAppVersionName() + ", sdkVersion Code/Name='" + getSdkVersionCode() + IOUtils.DIR_SEPARATOR_UNIX + getSdkVersionName() + ", sdkModuleCount=" + i + ", appModuleCount=" + size + ", updateStrategy=" + this.updateStrategy + '}';
    }

    public static class AppModulesBean implements Cloneable {
        @SerializedName("channel")
        private String channel;
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
        @SerializedName("url")
        private String url;
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

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public void setVersionName(String str) {
            this.versionName = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public String getVersion() {
            return this.version;
        }

        public String getChannel() {
            return this.channel;
        }

        public void setChannel(String str) {
            this.channel = str;
        }

        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
