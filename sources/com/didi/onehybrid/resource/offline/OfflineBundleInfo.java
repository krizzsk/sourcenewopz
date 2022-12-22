package com.didi.onehybrid.resource.offline;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.dimina.webview.resource.offline.FusionContract;
import org.json.JSONObject;

public class OfflineBundleInfo {
    private static final String DELETE_VERSION = "-20000000";
    public static final int DOWNLOAD_MODE_BEF = 1;
    public static final int DOWNLOAD_MODE_EVENT = 3;
    public static final int DOWNLOAD_MODE_WIFI = 2;
    private static final String ROLLBACK_VERSION = "10000000";
    private String bundleName;
    private String bundleVersion;
    private int downloadMode;
    private String downloadUrl;

    /* renamed from: id */
    private int f29709id;
    private String md5;
    private String originUrl;
    private int state = 0;

    public static class State {
        public static final int DOWNLOADING = 1;
        public static final int DOWNLOAD_FAIL = 3;
        public static final int DOWNLOAD_SUCCESS = 2;
        public static final int INVALID = 0;
        public static final int WAIT_WIFI = 4;
    }

    public static OfflineBundleInfo fromJson(JSONObject jSONObject) {
        OfflineBundleInfo offlineBundleInfo = new OfflineBundleInfo();
        try {
            offlineBundleInfo.bundleName = jSONObject.optString("bundle_name", "");
            offlineBundleInfo.originUrl = jSONObject.optString(FusionContract.OfflineBundle.COLUMN_NAME_ORIGIN_URL, "");
            offlineBundleInfo.downloadUrl = jSONObject.optString("download_url", "");
            offlineBundleInfo.bundleVersion = jSONObject.optString("version", "");
            offlineBundleInfo.downloadMode = jSONObject.optInt("download_mode", 0);
            offlineBundleInfo.md5 = jSONObject.optString("md5", "");
        } catch (Exception unused) {
            offlineBundleInfo = null;
        }
        if (TextUtils.isEmpty(offlineBundleInfo.bundleName)) {
            return null;
        }
        return offlineBundleInfo;
    }

    public void updateInfo(OfflineBundleInfo offlineBundleInfo) {
        this.downloadUrl = offlineBundleInfo.downloadUrl;
        this.bundleVersion = offlineBundleInfo.bundleVersion;
        this.md5 = offlineBundleInfo.md5;
        this.state = offlineBundleInfo.state;
        this.downloadMode = offlineBundleInfo.downloadMode;
    }

    public void setId(int i) {
        this.f29709id = i;
    }

    public int getId() {
        return this.f29709id;
    }

    public String getBundleName() {
        return this.bundleName;
    }

    public void setBundleName(String str) {
        this.bundleName = str;
    }

    public String getOriginUrl() {
        return this.originUrl;
    }

    public void setOriginUrl(String str) {
        this.originUrl = str;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public String getBundleVersion() {
        return this.bundleVersion;
    }

    public void setBundleVersion(String str) {
        this.bundleVersion = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }

    public boolean isRollback() {
        return ROLLBACK_VERSION.equals(this.bundleVersion);
    }

    public boolean isDelete() {
        return DELETE_VERSION.equals(this.bundleVersion);
    }

    public boolean isComplete() {
        return !TextUtils.isEmpty(this.downloadUrl) && !TextUtils.isEmpty(this.originUrl);
    }

    public String getBundleFileName() {
        return this.bundleName + "_" + this.bundleVersion + PmFileConstant.ZIP_SUFFIX;
    }

    public String getBundleDirName() {
        return this.bundleName + "_" + this.bundleVersion;
    }

    public boolean isValid() {
        return this.state == 2 && !isRollback() && !isDelete();
    }

    public int getDownloadMode() {
        return this.downloadMode;
    }

    public void setDownloadMode(int i) {
        this.downloadMode = i;
    }
}
