package com.didi.dimina.container.bundle.bean;

import android.text.TextUtils;
import com.didi.dimina.container.util.TextUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;

public class BundleConfig implements Serializable {
    public static final BundleConfig NO_VERSION_BUNDLE_CONFIG = new BundleConfig();
    @SerializedName("app_id")
    public String appId;
    @SerializedName("extraInfo")
    public String extraInfo;
    @SerializedName("update_strategy")
    public int updateStrategy;
    @SerializedName("versionCode")
    public String versionCode;
    @SerializedName("versionName")
    public String versionName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BundleConfig bundleConfig = (BundleConfig) obj;
            return TextUtils.equals(this.appId, bundleConfig.appId) && TextUtils.equals(this.versionCode, bundleConfig.versionCode) && TextUtils.equals(this.versionName, bundleConfig.versionName);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.versionCode, this.appId, this.versionName, this.extraInfo});
    }

    public String toString() {
        return "BundleConfig{, appId='" + this.appId + '\'' + ", version Code/Name='" + this.versionCode + "/" + this.versionName + '\'' + ", extraInfo.isEmpty='" + TextUtil.isEmpty(this.extraInfo) + '\'' + ", updateStrategy='" + this.updateStrategy + '}';
    }
}
