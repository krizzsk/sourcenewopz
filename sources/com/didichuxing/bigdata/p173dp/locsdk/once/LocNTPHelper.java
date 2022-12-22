package com.didichuxing.bigdata.p173dp.locsdk.once;

import android.location.Location;
import android.os.Build;
import androidx.work.PeriodicWorkRequest;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.LocData;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.bigdata.p173dp.locsdk.once.util.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.once.util.OmegaUtils;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.LocNTPHelper */
public class LocNTPHelper {

    /* renamed from: a */
    private static final boolean f46108a = (Build.VERSION.SDK_INT >= 17 && ApolloProxy.getInstance().isNTPAdjustLocTimeEnabled());

    /* renamed from: b */
    private static final boolean f46109b = ApolloProxy.getInstance().isNTPAdjustLocTimeWhenLocCreate();

    static {
        DLog.m32737d("NTP_ADJUST_LOCTIME_ENABLED=" + f46108a);
        DLog.m32737d("NTP_ADJUST_LOCTIME_WHEN_LOC_CREATE=" + f46109b);
    }

    public static void adjustLocTimestampWhenDispatch(DIDILocation dIDILocation) {
        if (dIDILocation != null && f46108a && !f46109b && TimeServiceManager.getInstance().isNTPAvailable()) {
            long nTPCurrenTimeMillis = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
            DLog.m32737d("dispatch adjust ntp_time_diff=" + (nTPCurrenTimeMillis - dIDILocation.getTime()));
            dIDILocation.setTime(nTPCurrenTimeMillis);
        }
    }

    public static void adjustSystemLocationTimestamp(Location location) {
        if (location != null && f46108a && f46109b && TimeServiceManager.getInstance().isNTPAvailable()) {
            long timeBoot = Utils.getTimeBoot() - Utils.getSystemLocationElapsedRealtime(location);
            if (timeBoot < 0 || timeBoot > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                timeBoot = 0;
            }
            long nTPCurrenTimeMillis = TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - timeBoot;
            long time = nTPCurrenTimeMillis - location.getTime();
            location.setTime(nTPCurrenTimeMillis);
            Utils.setSystemLocationNTPFlag(location, true);
            DLog.m32737d("adjust ntp_time_diff=" + time + " provider=" + location.getProvider());
            OmegaUtils.trackNTPAndLocTimeDiff(location.getProvider(), time);
        }
    }

    public static void adjustDIDINLPTimestamp(LocData locData) {
        if (locData != null && f46108a && f46109b && TimeServiceManager.getInstance().isNTPAvailable()) {
            long timeBoot = Utils.getTimeBoot() - locData.elapsedRealtime;
            if (timeBoot < 0 || timeBoot > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                timeBoot = 0;
            }
            long nTPCurrenTimeMillis = TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - timeBoot;
            locData.timestamp = nTPCurrenTimeMillis;
            DLog.m32737d("didinlp adjust ntp_time_diff=" + (nTPCurrenTimeMillis - locData.timestamp));
        }
    }
}
