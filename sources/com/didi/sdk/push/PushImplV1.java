package com.didi.sdk.push;

class PushImplV1 extends BasePush {
    PushImplV1(Push push) {
        super(push);
    }

    public void config(PushConfig pushConfig) {
        PushImplV1 pushImplV1;
        PushConfig pushConfig2;
        if (pushConfig == null) {
            pushConfig2 = PushConfig.getDefaultConfig();
            pushImplV1 = this;
        } else {
            pushImplV1 = this;
            pushConfig2 = pushConfig;
        }
        try {
            pushImplV1.push.config(pushConfig2.msgQueueCapacity, pushConfig2.channelTaskQueueCapacity, pushConfig2.channelDnsTimeout, pushConfig2.channelConnectTimeout, pushConfig2.channelHeartBeatInterval, pushConfig2.channelHeartBeatRetryCount, pushConfig2.channelHeartBeatRetryInterval, pushConfig2.connChannelRecvbuffersize, pushConfig2.fileChannelTaskqueueCapaicity, pushConfig2.fileChannelConnectionNumber, pushConfig2.fileChanneLdnstimeout, pushConfig2.fileChannelConnecttimeout, pushConfig2.fileChannelTasktimeout, pushConfig2.dnsCacheCapcity, pushConfig2.dnsCachetimeout, pushConfig2.taskTimeoutListcapacity, pushConfig2.connNtplistCapacity, pushConfig2.connNtplistAdjustoffset);
        } catch (Exception unused) {
        }
    }

    public void startConnChannel(PushConnParam pushConnParam) {
        PushLog.mLogger.info("push-debug->PushImplV1:account->%s,host->%s,port->%d,role->%d,token->%s", pushConnParam.getAccount(), pushConnParam.getHost(), Integer.valueOf(pushConnParam.getPort()), Integer.valueOf(pushConnParam.getRole()), pushConnParam.getToken());
        try {
            this.push.startConnChannel(pushConnParam.getHost(), pushConnParam.getPort(), pushConnParam.getRole(), pushConnParam.getAccount(), pushConnParam.getToken(), pushConnParam.getUserAgent().toByteArray());
        } catch (Exception unused) {
        }
    }
}
