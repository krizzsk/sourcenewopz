package com.didi.dimina.webview.resource.offline;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.dimina.webview.resource.offline.FusionContract;
import org.json.JSONObject;

public class OfflineBundleInfo {
    public static final int DOWNLOAD_MODE_BEF = 1;
    public static final int DOWNLOAD_MODE_EVENT = 3;
    public static final int DOWNLOAD_MODE_WIFI = 2;

    /* renamed from: a */
    private static final String f18357a = "10000000";

    /* renamed from: b */
    private static final String f18358b = "-20000000";

    /* renamed from: c */
    private int f18359c;

    /* renamed from: d */
    private String f18360d;

    /* renamed from: e */
    private String f18361e;

    /* renamed from: f */
    private String f18362f;

    /* renamed from: g */
    private String f18363g;

    /* renamed from: h */
    private String f18364h;

    /* renamed from: i */
    private int f18365i;

    /* renamed from: j */
    private int f18366j = 0;

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
            offlineBundleInfo.f18360d = jSONObject.optString("bundle_name", "");
            offlineBundleInfo.f18361e = jSONObject.optString(FusionContract.OfflineBundle.COLUMN_NAME_ORIGIN_URL, "");
            offlineBundleInfo.f18362f = jSONObject.optString("download_url", "");
            offlineBundleInfo.f18363g = jSONObject.optString("version", "");
            offlineBundleInfo.f18365i = jSONObject.optInt("download_mode", 0);
            offlineBundleInfo.f18364h = jSONObject.optString("md5", "");
        } catch (Exception unused) {
            offlineBundleInfo = null;
        }
        if (TextUtils.isEmpty(offlineBundleInfo.f18360d)) {
            return null;
        }
        return offlineBundleInfo;
    }

    public void updateInfo(OfflineBundleInfo offlineBundleInfo) {
        this.f18362f = offlineBundleInfo.f18362f;
        this.f18363g = offlineBundleInfo.f18363g;
        this.f18364h = offlineBundleInfo.f18364h;
        this.f18366j = offlineBundleInfo.f18366j;
        this.f18365i = offlineBundleInfo.f18365i;
    }

    public void setId(int i) {
        this.f18359c = i;
    }

    public int getId() {
        return this.f18359c;
    }

    public String getBundleName() {
        return this.f18360d;
    }

    public void setBundleName(String str) {
        this.f18360d = str;
    }

    public String getOriginUrl() {
        return this.f18361e;
    }

    public void setOriginUrl(String str) {
        this.f18361e = str;
    }

    public String getDownloadUrl() {
        return this.f18362f;
    }

    public void setDownloadUrl(String str) {
        this.f18362f = str;
    }

    public String getBundleVersion() {
        return this.f18363g;
    }

    public void setBundleVersion(String str) {
        this.f18363g = str;
    }

    public String getMd5() {
        return this.f18364h;
    }

    public void setMd5(String str) {
        this.f18364h = str;
    }

    public void setState(int i) {
        this.f18366j = i;
    }

    public int getState() {
        return this.f18366j;
    }

    public boolean isRollback() {
        return f18357a.equals(this.f18363g);
    }

    public boolean isDelete() {
        return f18358b.equals(this.f18363g);
    }

    public boolean isComplete() {
        return !TextUtils.isEmpty(this.f18362f) && !TextUtils.isEmpty(this.f18361e);
    }

    public String getBundleFileName() {
        return this.f18360d + "_" + this.f18363g + PmFileConstant.ZIP_SUFFIX;
    }

    public String getBundleDirName() {
        return this.f18360d + "_" + this.f18363g;
    }

    public boolean isValid() {
        return this.f18366j == 2 && !isRollback() && !isDelete();
    }

    public int getDownloadMode() {
        return this.f18365i;
    }

    public void setDownloadMode(int i) {
        this.f18365i = i;
    }
}
