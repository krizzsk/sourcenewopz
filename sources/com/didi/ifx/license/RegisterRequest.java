package com.didi.ifx.license;

class RegisterRequest {
    private String cpu_name;
    private String device_brand;
    private String device_id;
    private String device_name;
    private long device_time;
    private String license_key;

    /* renamed from: os */
    private String f24373os;
    private String os_version;
    private String sdk_version;

    RegisterRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8) {
        this.license_key = str;
        this.device_id = str2;
        this.f24373os = str3;
        this.os_version = str4;
        this.device_name = str5;
        this.device_brand = str6;
        this.cpu_name = str7;
        this.device_time = j;
        this.sdk_version = str8;
    }

    /* access modifiers changed from: package-private */
    public String get_cpu_name() {
        return this.cpu_name;
    }

    /* access modifiers changed from: package-private */
    public String get_device_brand() {
        return this.device_brand;
    }

    /* access modifiers changed from: package-private */
    public String get_device_id() {
        return this.device_id;
    }

    /* access modifiers changed from: package-private */
    public String get_device_name() {
        return this.device_name;
    }

    /* access modifiers changed from: package-private */
    public long get_device_time() {
        return this.device_time;
    }

    /* access modifiers changed from: package-private */
    public String get_license_key() {
        return this.license_key;
    }

    /* access modifiers changed from: package-private */
    public String get_os() {
        return this.f24373os;
    }

    /* access modifiers changed from: package-private */
    public String get_os_version() {
        return this.os_version;
    }

    /* access modifiers changed from: package-private */
    public String get_sdk_version() {
        return this.sdk_version;
    }
}
