package com.rider.rlab_im_map_plugin.channel;

import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public final class ErrorTracker {

    /* renamed from: a */
    private String f55843a = "";

    /* renamed from: b */
    private String f55844b;

    /* renamed from: c */
    private String f55845c = "";

    /* renamed from: d */
    private String f55846d = "";

    /* renamed from: e */
    private HashMap<String, Object> f55847e = new HashMap<>();

    private ErrorTracker(String str) {
        this.f55844b = str;
    }

    public static ErrorTracker create(String str) {
        return new ErrorTracker(str);
    }

    public ErrorTracker setModuleName(String str) {
        this.f55843a = str;
        return this;
    }

    public ErrorTracker setErrorType(String str) {
        this.f55845c = str;
        return this;
    }

    public ErrorTracker setErrorMessage(String str) {
        this.f55846d = str;
        return this;
    }

    public ErrorTracker setExtraParams(Map<String, Object> map) {
        this.f55847e.putAll(map);
        return this;
    }

    public ErrorTracker addExtraParam(String str, Object obj) {
        this.f55847e.put(str, obj);
        return this;
    }

    public void trackError() {
        OmegaSDK.trackError(this.f55843a, this.f55844b, this.f55845c, this.f55846d, this.f55847e);
    }
}
