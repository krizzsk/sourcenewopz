package com.didi.sdk.push.manager.tencent;

public class PushItem {
    private boolean isTLSOpen;
    private String libNameOrAddress;
    private LoadType loadType;
    private boolean supportJNIv2;
    private String version;
    private long writeBufCheckRepeat;
    private long writeTimeout;

    public enum LoadType {
        LOAD_FROM_NAME,
        LOAD__FROM_ADDRESS
    }

    public String getLibNameOrAddress() {
        return this.libNameOrAddress;
    }

    public void setLibNameOrAddress(String str) {
        this.libNameOrAddress = str;
    }

    public LoadType getLoadType() {
        return this.loadType;
    }

    public void setLoadType(LoadType loadType2) {
        this.loadType = loadType2;
    }

    public boolean supportJNIv2() {
        return this.supportJNIv2;
    }

    public void setSupportJNIv2(boolean z) {
        this.supportJNIv2 = z;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public boolean isTLSOpen() {
        return this.isTLSOpen;
    }

    public void setTLSOpen(boolean z) {
        this.isTLSOpen = z;
    }

    public long getWriteBufCheckRepeat() {
        return this.writeBufCheckRepeat;
    }

    public void setWriteBufCheckRepeat(long j) {
        this.writeBufCheckRepeat = j;
    }

    public long getWriteTimeout() {
        return this.writeTimeout;
    }

    public void setWriteTimeout(long j) {
        this.writeTimeout = j;
    }
}
