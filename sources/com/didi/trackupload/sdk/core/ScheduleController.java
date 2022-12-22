package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.utils.TrackLog;

class ScheduleController {

    /* renamed from: a */
    private static final String f37011a = "TrackSchedule";

    /* renamed from: b */
    private ISchedule f37012b;

    interface ISchedule {
        int getGatherScheduleSeconds();

        int getUploadScheduleSeconds();

        void removeGatherSchedule();

        void removeUploadSchedule();

        void requestGatherSchedule(OnScheduleListener onScheduleListener, int i);

        void requestUploadSchedule(OnScheduleListener onScheduleListener, int i);
    }

    interface OnScheduleListener {
        void onBaseClockSchedule(long j);

        void onEventSchedule(long j, TrackLocationInfo trackLocationInfo);
    }

    private ScheduleController() {
        if (TrackController.getIntance().getInitParams().isDirectUploadModeEnabled()) {
            this.f37012b = new C12918a();
        } else {
            this.f37012b = new ScheduleNormalImpl();
        }
    }

    private static class SingletonHolder {
        static ScheduleController INSTANCE = new ScheduleController();

        private SingletonHolder() {
        }
    }

    /* renamed from: a */
    static ScheduleController m26221a() {
        return SingletonHolder.INSTANCE;
    }

    static class OnScheduleListenerWrapper {
        int intervalSeconds;
        OnScheduleListener listener;

        OnScheduleListenerWrapper(OnScheduleListener onScheduleListener, int i) {
            this.listener = onScheduleListener;
            this.intervalSeconds = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo95198b() {
        if (!CoreThread.ensureCoreThread()) {
            return -1;
        }
        return this.f37012b.getGatherScheduleSeconds();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo95197a(OnScheduleListener onScheduleListener, int i) {
        TrackLog.m31343d(f37011a, "requestGatherSchedule interval=" + i);
        if (CoreThread.ensureCoreThread()) {
            this.f37012b.requestGatherSchedule(onScheduleListener, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo95200c() {
        TrackLog.m31343d(f37011a, "removeGatherSchedule");
        if (CoreThread.ensureCoreThread()) {
            this.f37012b.removeGatherSchedule();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo95201d() {
        if (!CoreThread.ensureCoreThread()) {
            return -1;
        }
        return this.f37012b.getUploadScheduleSeconds();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo95199b(OnScheduleListener onScheduleListener, int i) {
        TrackLog.m31343d(f37011a, "requestUploadSchedule interval=" + i);
        if (CoreThread.ensureCoreThread()) {
            this.f37012b.requestUploadSchedule(onScheduleListener, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo95202e() {
        TrackLog.m31343d(f37011a, "removeUploadSchedule");
        if (CoreThread.ensureCoreThread()) {
            this.f37012b.removeUploadSchedule();
        }
    }
}
