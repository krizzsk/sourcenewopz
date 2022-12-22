package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.core.ScheduleController;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.location.TrackLocationListener;

/* renamed from: com.didi.trackupload.sdk.core.a */
/* compiled from: ScheduleDirectUploadImpl */
class C12918a implements ScheduleController.ISchedule {

    /* renamed from: a */
    private ScheduleController.OnScheduleListenerWrapper f37066a;

    /* renamed from: b */
    private ScheduleController.OnScheduleListenerWrapper f37067b;

    /* renamed from: c */
    private long f37068c = -1;

    /* renamed from: d */
    private long f37069d = -1;

    /* renamed from: e */
    private TrackLocationListener f37070e = new ScheduleDirectUploadImpl$1(this);

    /* renamed from: f */
    private TrackLocationListener f37071f = new ScheduleDirectUploadImpl$2(this);

    C12918a() {
    }

    public int getGatherScheduleSeconds() {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f37066a;
        if (onScheduleListenerWrapper != null) {
            return onScheduleListenerWrapper.intervalSeconds;
        }
        return -1;
    }

    public void requestGatherSchedule(ScheduleController.OnScheduleListener onScheduleListener, int i) {
        if (onScheduleListener != null && i > 0) {
            this.f37066a = new ScheduleController.OnScheduleListenerWrapper(onScheduleListener, i);
            m26275a();
        }
    }

    public void removeGatherSchedule() {
        this.f37066a = null;
        this.f37068c = -1;
        m26275a();
    }

    public int getUploadScheduleSeconds() {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f37067b;
        if (onScheduleListenerWrapper != null) {
            return onScheduleListenerWrapper.intervalSeconds;
        }
        return -1;
    }

    public void requestUploadSchedule(ScheduleController.OnScheduleListener onScheduleListener, int i) {
        if (onScheduleListener != null && i > 0) {
            this.f37067b = new ScheduleController.OnScheduleListenerWrapper(onScheduleListener, i);
            m26275a();
        }
    }

    public void removeUploadSchedule() {
        this.f37067b = null;
        this.f37069d = -1;
        m26275a();
        m26279b(LocationCenter.getIntance().getLastEffectiveLocation());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26277a(TrackLocationInfo trackLocationInfo) {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper;
        long gatherScheduleSeconds = (long) getGatherScheduleSeconds();
        if (gatherScheduleSeconds > 0) {
            long j = this.f37068c;
            if (j == -1) {
                this.f37068c = 0;
            } else {
                this.f37068c = ((j / gatherScheduleSeconds) + 1) * gatherScheduleSeconds;
            }
            if (trackLocationInfo != null && (onScheduleListenerWrapper = this.f37066a) != null && this.f37068c % ((long) onScheduleListenerWrapper.intervalSeconds) == 0) {
                this.f37066a.listener.onEventSchedule(this.f37068c, trackLocationInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26279b(TrackLocationInfo trackLocationInfo) {
        long uploadScheduleSeconds = (long) getUploadScheduleSeconds();
        if (uploadScheduleSeconds > 0) {
            long j = this.f37069d;
            if (j == -1) {
                this.f37069d = 0;
            } else {
                this.f37069d = ((j / uploadScheduleSeconds) + 1) * uploadScheduleSeconds;
            }
            if (trackLocationInfo != null) {
                long j2 = this.f37069d;
                ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f37067b;
                if (onScheduleListenerWrapper != null && j2 % ((long) onScheduleListenerWrapper.intervalSeconds) == 0) {
                    this.f37067b.listener.onEventSchedule(j2, trackLocationInfo);
                }
                ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper2 = this.f37067b;
                if (onScheduleListenerWrapper2 != null) {
                    onScheduleListenerWrapper2.listener.onBaseClockSchedule(j2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m26275a() {
        int gatherScheduleSeconds = getGatherScheduleSeconds() * 1000;
        int uploadScheduleSeconds = getUploadScheduleSeconds() * 1000;
        if (gatherScheduleSeconds > 0) {
            long j = (long) gatherScheduleSeconds;
            if (j != LocationCenter.getIntance().getNormalLocationUpdateIntervalMillis()) {
                LocationCenter.getIntance().requestNormalLocationUpdates(this.f37070e, j);
            }
        } else {
            LocationCenter.getIntance().removeNormalLocationUpdates();
        }
        if (uploadScheduleSeconds > 0) {
            long j2 = (long) uploadScheduleSeconds;
            if (j2 != LocationCenter.getIntance().getDirectNotifyLocationUpdateIntervalMillis()) {
                LocationCenter.getIntance().requestDirectNotifyLocationUpdates(this.f37071f, j2);
                return;
            }
            return;
        }
        LocationCenter.getIntance().removeDirectNotifyLocationUpdates();
    }
}
