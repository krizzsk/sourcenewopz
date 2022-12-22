package com.didi.sdk.push;

class PushConfig implements Constants {
    public int channelConnectTimeout = 5;
    public int channelDnsTimeout = 5;
    public int channelHeartBeatInterval = 30;
    public int channelHeartBeatRetryCount = 3;
    public int channelHeartBeatRetryInterval = 5;
    public int channelTaskQueueCapacity = 1024;
    public int connChannelRecvbuffersize = Constants.CONN_CHANNEL_RECVBUFFERSIZE;
    public int connNtplistAdjustoffset = 128;
    public int connNtplistCapacity = 16;
    public int dnsCacheCapcity = 16;
    public int dnsCachetimeout = 120;
    public int fileChanneLdnstimeout = 5;
    public int fileChannelConnectionNumber = 1;
    public int fileChannelConnecttimeout = 5;
    public int fileChannelTaskqueueCapaicity = 1024;
    public int fileChannelTasktimeout = 15;
    public int msgQueueCapacity = 1024;
    public int taskTimeoutListcapacity = 30;

    PushConfig() {
    }

    public static PushConfig getDefaultConfig() {
        return new PushConfig();
    }
}
