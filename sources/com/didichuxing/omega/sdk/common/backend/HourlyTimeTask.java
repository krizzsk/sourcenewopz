package com.didichuxing.omega.sdk.common.backend;

import com.didichuxing.omega.sdk.analysis.SystemTrack;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.threadpool.ScheduledTaskObject;

public class HourlyTimeTask {
    public static void startHourlyTimeTask() {
        ScheduledTaskObject.getInstance().start(new Runnable() {
            public void run() {
                SystemTrack.trackODAT();
            }
        }, 8000);
        ScheduledTaskObject.getInstance().start(new Runnable() {
            public void run() {
                SyncStrategy.sync();
                SystemTrack.trackHourly();
            }
        }, 0, (long) OmegaConfig.SYNC_REMOTE_INTERVAL);
    }
}
