package com.didi.dimina.container.bridge.permission;

import org.json.JSONObject;

public class PermissionDescInfo {

    /* renamed from: a */
    private String f16752a;

    /* renamed from: b */
    private String f16753b = "";

    /* renamed from: c */
    private String f16754c;

    /* renamed from: d */
    private String f16755d = "";

    public PermissionDescInfo() {
    }

    public PermissionDescInfo(String str, String str2) {
        this.f16753b = str;
        this.f16755d = str2;
    }

    public String getTitle() {
        return this.f16753b;
    }

    public void setTitle(String str) {
        this.f16753b = str;
    }

    public String getContent() {
        return this.f16755d;
    }

    public void setContent(String str) {
        this.f16755d = str;
    }

    public String getIcon() {
        return this.f16752a;
    }

    public void setIcon(String str) {
        this.f16752a = str;
    }

    public String getSubTitle() {
        return this.f16754c;
    }

    public void setSubTitle(String str) {
        this.f16754c = this.f16754c;
    }

    public static PermissionDescInfo parse(JSONObject jSONObject) {
        PermissionDescInfo permissionDescInfo = new PermissionDescInfo();
        permissionDescInfo.f16753b = jSONObject.optString("title");
        permissionDescInfo.f16752a = jSONObject.optString("icon");
        permissionDescInfo.f16754c = jSONObject.optString("subTitle");
        permissionDescInfo.f16755d = jSONObject.optString("desc");
        return permissionDescInfo;
    }
}
