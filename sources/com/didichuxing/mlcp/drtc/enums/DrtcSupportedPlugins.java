package com.didichuxing.mlcp.drtc.enums;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;

public enum DrtcSupportedPlugins {
    SATURN_VIDEO_ROOM(SDKConsts.getSysConfig().f48336c + ".plugin.videoroom"),
    SATURN_AUDIO_BRIDGE(SDKConsts.getSysConfig().f48336c + ".plugin.audiobridge"),
    SATURN_NONE("none");
    
    private final String plugin_name;

    private DrtcSupportedPlugins(String str) {
        this.plugin_name = str;
    }

    private boolean EqualsString(String str) {
        return this.plugin_name.equals(str);
    }

    public static DrtcSupportedPlugins fromString(String str) {
        if (SATURN_VIDEO_ROOM.EqualsString(str)) {
            return SATURN_VIDEO_ROOM;
        }
        if (SATURN_AUDIO_BRIDGE.EqualsString(str)) {
            return SATURN_AUDIO_BRIDGE;
        }
        return SATURN_NONE;
    }

    public static String pluginEventTag(DrtcSupportedPlugins drtcSupportedPlugins) {
        if (SATURN_VIDEO_ROOM == drtcSupportedPlugins) {
            return "videoroom";
        }
        return SATURN_AUDIO_BRIDGE == drtcSupportedPlugins ? "audiobridge" : "none";
    }

    public String toString() {
        return this.plugin_name;
    }
}
