package com.didichuxing.swarm.toolkit;

import java.util.List;

public interface PluginInfoService {

    public static class PluginInfo {
        public String packageName;
        public String version;
    }

    List<PluginInfo> getPluginInfo();
}
