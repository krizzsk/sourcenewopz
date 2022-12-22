package com.didi.hawaii.mapsdkv2;

import android.text.TextUtils;
import com.didi.map.common.ApolloHawaii;

public final class HWMapConstant {
    public static final String BUILD_VERSION = "5766";
    public static final int CIRCLE_POINT_COUNT = 128;
    public static final int DEFAULT_EGL_DEPTH_SIZE = 24;
    public static final int DEFAULT_EGL_STENCIL_SIZE = 8;
    public static final String MAP_VERSION = "0.0.4";

    public static class PATH {
        static final String CONFIG_PATH = "/map/dds/update?";
        public static final String MAP_TILE_PATH = "/mapserver/map_3d/?";
        public static final String TRAFFIC_RENDER_PATH = "/render?";
    }

    public static class HTTP {
        private static final String HOST_RELEASE = "apimap.didiglobal.com";
        public static final String HTTPS_PROTOCOL = "https";
        public static final String HTTP_PROTOCOL = "http";
        public static final String SEPARATOR = "://";
        private static final String TRAFFIC_HOST = "apimap.didiglobal.com/traffic";

        public static String getTileHost() {
            String tileHost = ApolloHawaii.getTileHost();
            return TextUtils.isEmpty(tileHost) ? "https://apimap.didiglobal.com" : tileHost;
        }

        public static String getConfigHost() {
            String configHost = ApolloHawaii.getConfigHost();
            return TextUtils.isEmpty(configHost) ? "https://apimap.didiglobal.com" : configHost;
        }

        public static String getTrafficHost() {
            String trafficHost = ApolloHawaii.getTrafficHost();
            return TextUtils.isEmpty(trafficHost) ? "https://apimap.didiglobal.com/traffic" : trafficHost;
        }
    }

    public static String getConfigUrl() {
        return HTTP.getConfigHost() + "/map/dds/update?";
    }
}
