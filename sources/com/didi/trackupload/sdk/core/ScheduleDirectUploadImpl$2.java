package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.location.TrackLocationListener;
import com.didi.trackupload.sdk.utils.LogStringUtils;
import com.didi.trackupload.sdk.utils.TrackLog;

class ScheduleDirectUploadImpl$2 implements TrackLocationListener {
    final /* synthetic */ C12918a this$0;

    ScheduleDirectUploadImpl$2(C12918a aVar) {
        this.this$0 = aVar;
    }

    public void onLocationChanged(final TrackLocationInfo trackLocationInfo) {
        TrackLog.m31343d(LocationCenter.TAG, "onDirectLoc " + LogStringUtils.parseLocationInfo(trackLocationInfo));
        CoreThread.post(new Runnable() {
            public void run() {
                ScheduleDirectUploadImpl$2.this.this$0.m26279b(trackLocationInfo);
            }
        });
    }

    public void onLocationError(int i, String str) {
        TrackLog.m31343d(LocationCenter.TAG, "onDirectLocError errCode=" + i + " errMsg=" + str);
        CoreThread.post(new Runnable() {
            public void run() {
                ScheduleDirectUploadImpl$2.this.this$0.m26279b((TrackLocationInfo) null);
            }
        });
    }
}
