package com.didichuxing.apollo.sdk.model;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.Toggle;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseObj {
    public static final int ERROR_CODE_FAIL = -1;
    public static final int ERROR_CODE_NO_CHANGE = 304;
    public static final int ERROR_CODE_OK = 0;

    /* renamed from: a */
    private transient Map<String, IToggle> f45629a;
    @SerializedName("version")
    public String appFullVersion = "";
    @SerializedName("code")
    public int code = -1;
    @SerializedName("key")
    public String key = "";
    @SerializedName("md5")
    public String md5 = "";
    @SerializedName("msg")
    public String msg = "";
    @SerializedName("data")
    public List<Toggle> toggles;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  code=" + this.code);
        sb.append("  msg=" + this.msg);
        sb.append("  md5=" + this.md5);
        sb.append("  key=" + this.key);
        sb.append("  version=" + this.appFullVersion);
        sb.append("  toggleMap=" + getToggleMap());
        return sb.toString();
    }

    public synchronized Map<String, IToggle> getToggleMap() {
        if (this.f45629a == null) {
            this.f45629a = new HashMap();
            if (this.toggles != null) {
                for (Toggle next : this.toggles) {
                    if (next != null) {
                        if (!TextUtils.isEmpty(next.getName())) {
                            this.f45629a.put(next.getName(), next);
                        }
                    }
                }
            }
        }
        return this.f45629a;
    }
}
