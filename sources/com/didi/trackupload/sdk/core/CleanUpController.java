package com.didi.trackupload.sdk.core;

import android.os.Looper;
import android.os.SystemClock;
import com.didi.trackupload.sdk.storage.BizNodeEntity;
import com.didi.trackupload.sdk.storage.TrackDataStorage;
import com.didi.trackupload.sdk.storage.TrackNodeEntity;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanUpController {

    /* renamed from: a */
    private static final String f37001a = "TrackCleanUp";

    public void cleanUpAllData() {
    }

    public void cleanUpTrackNodes() {
    }

    private CleanUpController() {
    }

    private static class SingletonHolder {
        static CleanUpController INSTANCE = new CleanUpController();

        private SingletonHolder() {
        }
    }

    public static CleanUpController getIntance() {
        return SingletonHolder.INSTANCE;
    }

    public void cleanUpBizNodes() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<BizNodeEntity> allBizNodeEntities = TrackDataStorage.getInstance().getAllBizNodeEntities();
            List<TrackNodeEntity> allTrackNodeEntities = TrackDataStorage.getInstance().getAllTrackNodeEntities();
            TrackLog.m31343d(f37001a, "cleanUpBizNodes begin bizNodeSize=" + allBizNodeEntities.size() + " trackNodeSize=" + allTrackNodeEntities.size());
            HashSet hashSet = new HashSet();
            for (TrackNodeEntity tags : allTrackNodeEntities) {
                List<String> tags2 = tags.getTags();
                if (tags2 != null) {
                    hashSet.addAll(tags2);
                }
            }
            Iterator<BizNodeEntity> it = allBizNodeEntities.iterator();
            while (it.hasNext()) {
                if (hashSet.contains(it.next().getTag())) {
                    it.remove();
                }
            }
            if (allBizNodeEntities.size() > 0) {
                TrackDataStorage.getInstance().removeBizNodeEntities(allBizNodeEntities);
            }
            TrackLog.m31343d(f37001a, "cleanUpBizNodes done deleteSize=" + allBizNodeEntities.size() + " timediff=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
        }
    }
}
