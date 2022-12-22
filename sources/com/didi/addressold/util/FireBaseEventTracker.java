package com.didi.addressold.util;

import com.didi.address.FromType;
import com.didi.common.map.util.DLog;
import java.util.Map;

public class FireBaseEventTracker {

    /* renamed from: a */
    private static FireBaseEventTrackListener f7781a;

    public static void trackAddNewFavPlace(FromType fromType) {
        FireBaseEventTrackListener fireBaseEventTrackListener;
        if (f7781a != null) {
            boolean z = false;
            if (fromType == FromType.SETTING || fromType == FromType.HOME) {
                z = true;
            }
            if (z && (fireBaseEventTrackListener = f7781a) != null) {
                fireBaseEventTrackListener.trackEvent("gp_faviritePlace_addNew_ck", (Map<String, Object>) null);
            }
        }
    }

    public static FireBaseEventTrackListener getFireBaseEventTrackListener() {
        DLog.m7384d("Firebase", "getFireBaseEventTrackListener " + f7781a, new Object[0]);
        return f7781a;
    }

    public static void setFireBaseEventTrackListener(FireBaseEventTrackListener fireBaseEventTrackListener) {
        DLog.m7384d("Firebase", "setFireBaseEventTrackListener listener =" + fireBaseEventTrackListener + ",sFireBaseEventTrackListener =" + f7781a, new Object[0]);
        f7781a = fireBaseEventTrackListener;
    }
}
