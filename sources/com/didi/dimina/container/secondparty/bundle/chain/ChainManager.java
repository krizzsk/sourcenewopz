package com.didi.dimina.container.secondparty.bundle.chain;

public class ChainManager {
    public static final String TAG = "Dimina-PM ChainManager";

    public static IPckInterceptor getLocalIOChain() {
        PreInterceptor preInterceptor = new PreInterceptor();
        AssetInterceptor assetInterceptor = new AssetInterceptor();
        preInterceptor.setNextInterceptor(assetInterceptor);
        assetInterceptor.setNextInterceptor(new LocalCbInterceptor());
        return preInterceptor;
    }

    public static IPckInterceptor getRemoteIOChain() {
        RemoteUnzipInterceptor remoteUnzipInterceptor = new RemoteUnzipInterceptor();
        remoteUnzipInterceptor.setNextInterceptor(new RemoteCbInterceptor());
        return remoteUnzipInterceptor;
    }

    public static IPckInterceptor getConsumeHttpChain() {
        RemotePreInterceptor remotePreInterceptor = new RemotePreInterceptor();
        ConfigRequestInterceptor configRequestInterceptor = new ConfigRequestInterceptor();
        remotePreInterceptor.setNextInterceptor(configRequestInterceptor);
        configRequestInterceptor.setNextInterceptor(new DownloadInterceptor());
        return remotePreInterceptor;
    }

    public static IPckInterceptor getSubPreIOChain() {
        SubPreUnzipInterceptor subPreUnzipInterceptor = new SubPreUnzipInterceptor();
        subPreUnzipInterceptor.setNextInterceptor(new SubPreCbInterceptor());
        return subPreUnzipInterceptor;
    }
}
