package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.core.ScheduleController;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.location.TrackLocationListener;
import com.didi.trackupload.sdk.utils.LogStringUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.Timer;
import java.util.TimerTask;

class ScheduleNormalImpl implements ScheduleController.ISchedule {

    /* renamed from: a */
    private static final int f37013a = 1000;

    /* renamed from: b */
    private ScheduleController.OnScheduleListenerWrapper f37014b;

    /* renamed from: c */
    private ScheduleController.OnScheduleListenerWrapper f37015c;

    /* renamed from: d */
    private Timer f37016d;

    /* renamed from: e */
    private BaseClockTask f37017e;

    /* renamed from: f */
    private long f37018f = 0;

    /* renamed from: g */
    private long f37019g = -1;

    /* renamed from: h */
    private TrackLocationListener f37020h = new TrackLocationListener() {
        public void onLocationChanged(final TrackLocationInfo trackLocationInfo) {
            TrackLog.m31343d(LocationCenter.TAG, "onNormalLoc " + LogStringUtils.parseLocationInfo(trackLocationInfo));
            CoreThread.post(new Runnable() {
                public void run() {
                    ScheduleNormalImpl.this.m26231a(trackLocationInfo);
                }
            });
        }

        public void onLocationError(int i, String str) {
            TrackLog.m31343d(LocationCenter.TAG, "onNormalLocError errCode=" + i + " errMsg=" + str);
            CoreThread.post(new Runnable() {
                public void run() {
                    ScheduleNormalImpl.this.m26231a((TrackLocationInfo) null);
                }
            });
        }
    };

    ScheduleNormalImpl() {
    }

    public int getGatherScheduleSeconds() {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f37014b;
        if (onScheduleListenerWrapper != null) {
            return onScheduleListenerWrapper.intervalSeconds;
        }
        return -1;
    }

    public void requestGatherSchedule(ScheduleController.OnScheduleListener onScheduleListener, int i) {
        if (onScheduleListener != null && i > 0) {
            this.f37014b = new ScheduleController.OnScheduleListenerWrapper(onScheduleListener, i);
            m26228a();
            m26234d();
        }
    }

    public void removeGatherSchedule() {
        this.f37014b = null;
        this.f37019g = -1;
        m26232b();
        m26234d();
    }

    public int getUploadScheduleSeconds() {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f37015c;
        if (onScheduleListenerWrapper != null) {
            return onScheduleListenerWrapper.intervalSeconds;
        }
        return -1;
    }

    public void requestUploadSchedule(ScheduleController.OnScheduleListener onScheduleListener, int i) {
        if (onScheduleListener != null && i > 0) {
            this.f37015c = new ScheduleController.OnScheduleListenerWrapper(onScheduleListener, i);
            m26228a();
            m26234d();
        }
    }

    public void removeUploadSchedule() {
        this.f37015c = null;
        m26232b();
        m26234d();
    }

    private class BaseClockTask extends TimerTask {
        private BaseClockTask() {
        }

        public void run() {
            CoreThread.post(new Runnable() {
                public void run() {
                    ScheduleNormalImpl.this.m26233c();
                }
            });
        }
    }

    /* renamed from: a */
    private void m26228a() {
        if (!(this.f37014b == null && this.f37015c == null) && this.f37016d == null && this.f37017e == null) {
            this.f37018f = 0;
            this.f37016d = new Timer();
            BaseClockTask baseClockTask = new BaseClockTask();
            this.f37017e = baseClockTask;
            this.f37016d.schedule(baseClockTask, 0, 1000);
        }
    }

    /* renamed from: b */
    private void m26232b() {
        BaseClockTask baseClockTask;
        if (this.f37014b == null && this.f37015c == null && this.f37016d != null && (baseClockTask = this.f37017e) != null) {
            baseClockTask.cancel();
            this.f37016d.cancel();
            this.f37018f = 0;
            this.f37017e = null;
            this.f37016d = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26231a(TrackLocationInfo trackLocationInfo) {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper;
        long gatherScheduleSeconds = (long) getGatherScheduleSeconds();
        if (gatherScheduleSeconds > 0) {
            long j = this.f37019g;
            if (j == -1) {
                this.f37019g = 0;
            } else {
                this.f37019g = ((j / gatherScheduleSeconds) + 1) * gatherScheduleSeconds;
            }
            if (trackLocationInfo != null && (onScheduleListenerWrapper = this.f37014b) != null && this.f37019g % ((long) onScheduleListenerWrapper.intervalSeconds) == 0) {
                this.f37014b.listener.onEventSchedule(this.f37019g, trackLocationInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26233c() {
        long j = this.f37018f + 1;
        this.f37018f = j;
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f37015c;
        if (onScheduleListenerWrapper != null && j % ((long) onScheduleListenerWrapper.intervalSeconds) == 0) {
            this.f37015c.listener.onEventSchedule(j, (TrackLocationInfo) null);
        }
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper2 = this.f37015c;
        if (onScheduleListenerWrapper2 != null) {
            onScheduleListenerWrapper2.listener.onBaseClockSchedule(j);
        }
    }

    /* renamed from: d */
    private void m26234d() {
        int gatherScheduleSeconds = getGatherScheduleSeconds() * 1000;
        int uploadScheduleSeconds = getUploadScheduleSeconds() * 1000;
        int min = gatherScheduleSeconds > 0 ? Math.min(Integer.MAX_VALUE, gatherScheduleSeconds) : Integer.MAX_VALUE;
        if (uploadScheduleSeconds > 0) {
            min = Math.min(min, uploadScheduleSeconds);
        }
        if (min != Integer.MAX_VALUE) {
            long j = (long) min;
            if (j != LocationCenter.getIntance().getNormalLocationUpdateIntervalMillis()) {
                LocationCenter.getIntance().requestNormalLocationUpdates(this.f37020h, j);
                return;
            }
            return;
        }
        LocationCenter.getIntance().removeNormalLocationUpdates();
    }
}
