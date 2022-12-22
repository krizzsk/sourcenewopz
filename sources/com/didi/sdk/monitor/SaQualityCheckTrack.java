package com.didi.sdk.monitor;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public class SaQualityCheckTrack extends AbsQualityCheckTrack {

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SceneType {
        public static final int activity_scene_1 = 1;
        public static final int activity_scene_2 = 2;
        public static final int activity_scene_3 = 3;
        public static final int activity_scene_4 = 4;
        public static final int activity_scene_5 = 5;
        public static final int sa_mine_1 = 1;
        public static final int sa_mine_2 = 2;
        public static final int sa_mine_3 = 3;
        public static final int sa_mine_4 = 4;
        public static final int sa_tab_1 = 1;
        public static final int sa_tab_2 = 2;
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagType {
        public static final String sa_activity = "sa_activity";
        public static final String sa_mine = "sa_mine";
        public static final String sa_tab = "sa_tab";
    }

    public static void trackError(String str, int i, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("m_tag", str);
        hashMap.put("m_scene", Integer.valueOf(i));
        if (map == null || map.isEmpty()) {
            hashMap.put("m_ext", "");
        } else {
            hashMap.put("m_ext", new Gson().toJson((Object) map));
        }
        OmegaSDKAdapter.trackEvent("ibt_monitor_scene_ck", (Map<String, Object>) hashMap);
    }
}
