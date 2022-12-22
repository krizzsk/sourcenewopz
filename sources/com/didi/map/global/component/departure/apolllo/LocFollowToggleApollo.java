package com.didi.map.global.component.departure.apolllo;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.sdk.push.ServerParam;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class LocFollowToggleApollo {
    public static int accuracy;
    public static int distance;
    public static boolean enable;
    public static int frequency;

    public static void initFollowApolloParam() {
        IExperiment experiment;
        String a = m17704a();
        IToggle toggle = !TextUtils.isEmpty(a) ? Apollo.getToggle(a) : null;
        if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
            boolean z = false;
            if (((Integer) experiment.getParam("is_enable", 0)).intValue() != 0) {
                z = true;
            }
            enable = z;
            accuracy = ((Integer) experiment.getParam(ServerParam.PARAM_ACCURACY, 30)).intValue();
            distance = ((Integer) experiment.getParam("distance", 30)).intValue();
            frequency = ((Integer) experiment.getParam("frequency", 6)).intValue();
        }
    }

    /* renamed from: a */
    private static String m17704a() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_caiman_parameter");
            if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
                return null;
            }
            String str = (String) experiment.getParam("global_passenger_user_location_follow_ab", "");
            DLog.m7384d("LocFollowToggleApollo", "" + str, new Object[0]);
            return str;
        } catch (Exception e) {
            DLog.m7384d("LocFollowToggleApollo", "" + e.toString(), new Object[0]);
            e.printStackTrace();
            return null;
        }
    }
}
