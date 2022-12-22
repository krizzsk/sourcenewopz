package com.didi.sdk.push;

public class PushItem implements Comparable<PushItem> {
    private int confVersion;
    private String fluxMsgType;
    private int heartBeatInterval;
    private int heartBeatRetryInterval;
    private boolean isDQuicOpen;
    private boolean isTLSOpen;
    private String libNameOrAddress;
    private LoadType loadType;
    private int port;
    private int priority;
    private RouteType routeType;
    private boolean supportJNIv2;
    private String version;
    private long writeBufCheckRepeat;
    private long writeTimeout;

    public String getFluxMsgType() {
        return this.fluxMsgType;
    }

    public void setFluxMsgType(String str) {
        this.fluxMsgType = str;
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

    public boolean isDQuicOpen() {
        return this.isDQuicOpen;
    }

    public void setDQuicOpen(boolean z) {
        this.isDQuicOpen = z;
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

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public RouteType getRouteType() {
        return this.routeType;
    }

    public void setRouteType(RouteType routeType2) {
        this.routeType = routeType2;
    }

    public int getHeartBeatInterval() {
        return this.heartBeatInterval;
    }

    public void setHeartBeatInterval(int i) {
        this.heartBeatInterval = i;
    }

    public int getHeartBeatRetryInterval() {
        return this.heartBeatRetryInterval;
    }

    public void setHeartBeatRetryInterval(int i) {
        this.heartBeatRetryInterval = i;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public int getConfVersion() {
        return this.confVersion;
    }

    public void setConfVersion(int i) {
        this.confVersion = i;
    }

    public int compareTo(PushItem pushItem) {
        int i = this.priority;
        int i2 = pushItem.priority;
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public enum LoadType {
        LOAD_FROM_NAME(0),
        LOAD__FROM_ADDRESS(1);
        
        private int value;

        private LoadType(int i) {
            this.value = i;
        }

        public static LoadType valueOf(int i) {
            if (i == 0) {
                return LOAD_FROM_NAME;
            }
            if (i != 1) {
                return null;
            }
            return LOAD__FROM_ADDRESS;
        }
    }
}
