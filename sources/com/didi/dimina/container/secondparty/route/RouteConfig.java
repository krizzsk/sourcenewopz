package com.didi.dimina.container.secondparty.route;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RouteConfig implements Serializable {
    @SerializedName("_appId")
    public String appId;
    @SerializedName("_business")
    public String business;
    @SerializedName("_debug")
    public boolean debug;
    @SerializedName("_entryPath")
    public String entryPath;
    public final Map<String, Object> extraOptions;
    @SerializedName("_extraUA")
    public String extraUA;
    @SerializedName("_forceUpdateAppVersion")
    public String forceUpdateAppVersion;
    @SerializedName("_forceUpdateJSSDKVersion")
    public String forceUpdateJSSDKVersion;
    @SerializedName("_forceUpdateTimeout")
    public long forceUpdateTimeout;
    @SerializedName("_hasCapsuleButton")
    public boolean hasCapsuleButton;
    @SerializedName("_maxPageSize")
    @Deprecated
    public int maxPageSize;
    @SerializedName("_ravenId")
    public String ravenId;
    @SerializedName("_remoteUrl")
    public String remoteUrl;

    public RouteConfig() {
        this.business = "";
        this.appId = "";
        this.entryPath = "";
        this.maxPageSize = 10;
        this.extraUA = "";
        this.ravenId = "";
        this.forceUpdateJSSDKVersion = "";
        this.forceUpdateAppVersion = "";
        this.remoteUrl = "";
        this.debug = false;
        this.extraOptions = new HashMap();
    }

    public void addExtraOptions(String str, Object obj) {
        this.extraOptions.put(str, obj);
    }

    public Uri toUri() {
        StringBuilder sb = new StringBuilder();
        joinParams(sb, RouteConstants.ROUTE_PARAMS_BUSINESS, this.business);
        joinParams(sb, RouteConstants.ROUTE_PARAMS_APP_ID, this.appId);
        joinParams(sb, RouteConstants.ROUTE_PARAMS_ENTRY_PATH, this.entryPath);
        joinParams(sb, RouteConstants.ROUTE_PARAMS_MAX_PAGE_SIZE, this.maxPageSize + "");
        joinParams(sb, RouteConstants.ROUTE_PARAMS_EXTRA_UA, this.extraUA);
        joinParams(sb, RouteConstants.ROUTE_PARAMS_RAVEN_ID, this.ravenId);
        joinParams(sb, RouteConstants.ROUTE_PARAMS_FORCE_UPDATE_JSSDK_VERSION, this.forceUpdateJSSDKVersion);
        joinParams(sb, RouteConstants.ROUTE_PARAMS_FORCE_UPDATE_APP_VERSION, this.forceUpdateAppVersion);
        joinParams(sb, RouteConstants.ROUTE_PARAMS_FORCE_UPDATE_TIME_OUT, this.forceUpdateTimeout + "");
        joinParams(sb, RouteConstants.ROUTE_PARAMS_REMOTE_URL, this.remoteUrl);
        return Uri.parse(RouteConstants.ROUTE_PATH + sb.toString());
    }

    private StringBuilder joinParams(StringBuilder sb, String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, "0") && !TextUtils.equals(str2, SDKConsts.BOOLEAN_FALSE)) {
            if (sb.length() != 0) {
                sb.append(ParamKeys.SIGN_AND);
            }
            sb.append(str);
            sb.append("=");
            sb.append(str2);
        }
        return sb;
    }

    private RouteConfig(Builder builder) {
        this.business = "";
        this.appId = "";
        this.entryPath = "";
        this.maxPageSize = 10;
        this.extraUA = "";
        this.ravenId = "";
        this.forceUpdateJSSDKVersion = "";
        this.forceUpdateAppVersion = "";
        this.remoteUrl = "";
        this.debug = false;
        this.extraOptions = new HashMap();
        this.business = builder.business;
        this.appId = builder.appId;
        this.entryPath = builder.entryPath;
        this.maxPageSize = builder.maxPageSize;
        this.extraUA = builder.extraUA;
        this.ravenId = builder.ravenId;
        this.forceUpdateJSSDKVersion = builder.forceUpdateJSSDKVersion;
        this.forceUpdateAppVersion = builder.forceUpdateAppVersion;
        this.forceUpdateTimeout = builder.forceUpdateTimeout;
        this.remoteUrl = builder.remoteUrl;
        this.hasCapsuleButton = builder.hasCapsuleButton;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String appId = "";
        /* access modifiers changed from: private */
        public String business = "";
        /* access modifiers changed from: private */
        public String entryPath = "";
        /* access modifiers changed from: private */
        public String extraUA = "";
        /* access modifiers changed from: private */
        public String forceUpdateAppVersion = "";
        /* access modifiers changed from: private */
        public String forceUpdateJSSDKVersion = "";
        /* access modifiers changed from: private */
        public long forceUpdateTimeout;
        /* access modifiers changed from: private */
        public boolean hasCapsuleButton = false;
        /* access modifiers changed from: private */
        @Deprecated
        public int maxPageSize = 9999;
        /* access modifiers changed from: private */
        public String ravenId = "";
        /* access modifiers changed from: private */
        public String remoteUrl = "";

        public RouteConfig build() {
            return new RouteConfig(this);
        }

        public Builder setBusiness(String str) {
            this.business = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setEntryPath(String str) {
            this.entryPath = str;
            return this;
        }

        public Builder setMaxPageSize(int i) {
            this.maxPageSize = i;
            return this;
        }

        public Builder setExtraUA(String str) {
            this.extraUA = str;
            return this;
        }

        public Builder setRavenId(String str) {
            this.ravenId = str;
            return this;
        }

        public Builder setForceUpdateJSSDKVersion(String str) {
            this.forceUpdateJSSDKVersion = str;
            return this;
        }

        public Builder setForceUpdateAppVersion(String str) {
            this.forceUpdateAppVersion = str;
            return this;
        }

        public Builder setForceUpdateTimeout(long j) {
            this.forceUpdateTimeout = j;
            return this;
        }

        public Builder setRemoteUrl(String str) {
            this.remoteUrl = str;
            return this;
        }

        public Builder setHasCapsuleButton(boolean z) {
            this.hasCapsuleButton = z;
            return this;
        }
    }

    public String toString() {
        return "RouteConfig{business='" + this.business + '\'' + ", appId='" + this.appId + '\'' + ", entryPath='" + this.entryPath + '\'' + ", maxPageSize=" + this.maxPageSize + ", extraUA='" + this.extraUA + '\'' + ", ravenId='" + this.ravenId + '\'' + ", forceUpdateJSSDKVersion='" + this.forceUpdateJSSDKVersion + '\'' + ", forceUpdateAppVersion='" + this.forceUpdateAppVersion + '\'' + ", forceUpdateTimeout=" + this.forceUpdateTimeout + '}';
    }
}
