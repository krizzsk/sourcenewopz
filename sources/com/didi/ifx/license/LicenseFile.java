package com.didi.ifx.license;

class LicenseFile {
    private String device_id;
    private long expiry_timestamp;
    private long heartbeat_bias;
    private long heartbeat_time;
    private String license_key;
    private String public_key;
    private String server_version;
    private long update_timestamp;

    LicenseFile() {
    }

    /* access modifiers changed from: package-private */
    public String getDeviceId() {
        return this.device_id;
    }

    /* access modifiers changed from: package-private */
    public long getExpiryTimestamp() {
        return this.expiry_timestamp;
    }

    /* access modifiers changed from: package-private */
    public long getHeartbeatBias() {
        return this.heartbeat_bias;
    }

    /* access modifiers changed from: package-private */
    public long getHeartbeatTime() {
        return this.heartbeat_time;
    }

    /* access modifiers changed from: package-private */
    public String getLicenseKey() {
        return this.license_key;
    }

    /* access modifiers changed from: package-private */
    public String getPublicKey() {
        return this.public_key;
    }

    /* access modifiers changed from: package-private */
    public long getUpdateTimestamp() {
        return this.update_timestamp;
    }
}
