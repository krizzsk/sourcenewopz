package com.didi.sdk.net;

public interface INetLibConfigService {

    public static class NetLibConfig {
        public String[] blackHosts;
        public String httpDnsApolloName;
        public String[] httpdnsBatchHosts;
        public String httpdnsUrl;
        public String terminalTag;
    }

    NetLibConfig getNetLibConfig();
}
