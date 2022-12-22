package com.didi.trackupload.sdk.core;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.didi.trackupload.sdk.Constants;
import com.didi.trackupload.sdk.ICommonInfoDelegate;
import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.TrackOnceClient;
import com.didi.trackupload.sdk.datachannel.DataChannel;
import com.didi.trackupload.sdk.datachannel.SendResult;
import com.didi.trackupload.sdk.datachannel.protobuf.CollectSvrCoordinateReq;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackNode;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackUploadReq;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.storage.BizNodeEntity;
import com.didi.trackupload.sdk.utils.OmegaUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdu.didi.protobuf.MapTrackExtraPointData;
import com.squareup.wire.Wire;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class UploadOnceTask implements Runnable {

    /* renamed from: a */
    private static final String f37033a = "TrackOnceTask";

    /* renamed from: b */
    private static final String f37034b = "TrackOnceTaskDetail";

    /* renamed from: c */
    private static final Handler f37035c = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final SerialExecutor f37036d = new SerialExecutor();

    /* renamed from: e */
    private static final Gson f37037e = new GsonBuilder().setPrettyPrinting().create();

    /* renamed from: f */
    private static final Wire f37038f = new Wire((Class<?>[]) new Class[0]);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TrackOnceClient f37039g;

    /* renamed from: h */
    private long f37040h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnExecuteCompletedListenser f37041i;

    /* renamed from: j */
    private Long f37042j;

    /* renamed from: k */
    private Long f37043k;

    /* renamed from: l */
    private Long f37044l;

    /* renamed from: m */
    private Long f37045m;

    /* renamed from: n */
    private Integer f37046n;

    /* renamed from: o */
    private int f37047o;

    /* renamed from: p */
    private int f37048p;

    interface OnExecuteCompletedListenser {
        void onExecuteCompleted(UploadResult uploadResult);
    }

    /* renamed from: b */
    private String m26252b(String str) {
        return str != null ? str : "";
    }

    UploadOnceTask(TrackOnceClient trackOnceClient) {
        this(trackOnceClient, 0, (OnExecuteCompletedListenser) null);
    }

    UploadOnceTask(TrackOnceClient trackOnceClient, long j) {
        this(trackOnceClient, j, (OnExecuteCompletedListenser) null);
    }

    UploadOnceTask(TrackOnceClient trackOnceClient, long j, OnExecuteCompletedListenser onExecuteCompletedListenser) {
        this.f37040h = 0;
        this.f37039g = trackOnceClient;
        this.f37040h = j;
        this.f37041i = onExecuteCompletedListenser;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26255c() {
        this.f37043k = Long.valueOf(System.currentTimeMillis());
    }

    /* renamed from: d */
    private void m26256d() {
        this.f37044l = Long.valueOf(System.currentTimeMillis());
        m26249a(m26257e());
    }

    /* renamed from: a */
    private void m26249a(UploadResult uploadResult) {
        Long valueOf = uploadResult == UploadResult.ERR_OK ? Long.valueOf(System.currentTimeMillis()) : null;
        TrackLog.m31343d(f37033a, "upload completed task=" + toHexString() + " flags=" + this.f37040h + " result=" + uploadResult.toSimpleString());
        OmegaUtils.trackUploadResult(uploadResult, this.f37042j, this.f37043k, this.f37044l, this.f37045m, valueOf, this.f37046n, true, Long.valueOf(this.f37040h), Integer.valueOf(this.f37047o), Integer.valueOf(this.f37048p));
        m26253b(uploadResult);
    }

    /* renamed from: e */
    private UploadResult m26257e() {
        if (!DataChannel.getIntance().isConnected()) {
            return UploadResult.ERR_STATE_DATA_CHANNEL_NOT_CONNECTED;
        }
        ICommonInfoDelegate commonInfoDelegate = TrackController.getIntance().getInitParams().getCommonInfoDelegate();
        if (commonInfoDelegate == null) {
            return UploadResult.ERR_PARAMS_COMMON_INFO_DELEGATE;
        }
        if (this.f37039g == null) {
            return UploadResult.ERR_PARAMS_TRACK_CLIENT;
        }
        if (f37036d.hasPendingTask(this)) {
            return UploadResult.ERR_STATE_HAS_PENDING_TASK;
        }
        TrackLocationInfo f = m26258f();
        if (f == null) {
            return UploadResult.ERR_STATE_LAST_LOCATION;
        }
        this.f37042j = f.timestamp64_loc;
        BizNodeEntity a = UploadController.m26238a(this.f37039g);
        TrackUploadReq trackUploadReq = null;
        try {
            trackUploadReq = new TrackUploadReq.Builder().phone(m26252b(commonInfoDelegate.getPhone())).user_id(Long.valueOf(m26247a(commonInfoDelegate.getUid()))).upload_time64_mobile(Long.valueOf(System.currentTimeMillis())).upload_time64_loc(f.timestamp64_loc).loc(f).loc_rectified((TrackLocationInfo) null).loc_recent((List<TrackLocationInfo>) null).track_nodes((List<TrackNode>) null).biz_info(BizNodeEntity.toPBMessages((List<BizNodeEntity>) Collections.singletonList(a))).map_extra_message_data(f.map_extra_message_data).build();
        } catch (Exception e) {
            OmegaUtils.trackWireError(202, e);
        }
        if (trackUploadReq == null) {
            return UploadResult.ERR_STATE_BUILD_UPLOAD_REQ;
        }
        if (!DataChannel.getIntance().isConnected()) {
            return UploadResult.ERR_STATE_DATA_CHANNEL_NOT_CONNECTED;
        }
        TrackLog.m31343d(f37033a, "upload task=" + toHexString() + " loc.time=" + f.timestamp64_loc);
        if (Constants.DEBUG) {
            try {
                TrackLog.m31343d(f37034b, "---------------------------------------------------");
                TrackLog.m31343d(f37034b, "upload task=" + toHexString() + " TrackUploadReq=" + f37037e.toJson((Object) trackUploadReq, (Type) TrackUploadReq.class));
                TrackLog.m31343d(f37034b, "upload biz_info task=" + toHexString() + " tag={" + a.getTag() + "} CollectSvrCoordinateReq=" + f37037e.toJson((Object) (CollectSvrCoordinateReq) f37038f.parseFrom(a.getExtra_data(), CollectSvrCoordinateReq.class), (Type) CollectSvrCoordinateReq.class));
            } catch (Exception unused) {
            }
        }
        this.f37045m = Long.valueOf(System.currentTimeMillis());
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SendResult sendMessage = DataChannel.getIntance().sendMessage(trackUploadReq, this.f37040h, String.valueOf(a.getClient_type()));
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 5000) {
            TrackLog.m31343d(f37033a, "upload sendmsg task=" + toHexString() + " timediff=" + elapsedRealtime2 + "ms");
        }
        if (sendMessage == null) {
            return UploadResult.ERR_STATE_UPLOAD_FAILED;
        }
        this.f37046n = Integer.valueOf(sendMessage.getBytesLength());
        this.f37047o = sendMessage.getSendType();
        this.f37048p = sendMessage.getDetailCode();
        if (sendMessage.getResultCode() == 0) {
            return UploadResult.ERR_OK;
        }
        if (sendMessage.getResultCode() == -1 && sendMessage.getDetailCode() == -1100) {
            return UploadResult.ERR_STATE_BUILD_UPLOAD_REQ;
        }
        return sendMessage.getResultCode() == -2 ? UploadResult.ERR_STATE_UPLOAD_TIMEOUT : UploadResult.ERR_STATE_UPLOAD_FAILED;
    }

    public void run() {
        m26256d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo95230a() {
        mo95231a(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo95231a(long j) {
        f37035c.postDelayed(new Runnable() {
            public void run() {
                UploadOnceTask.this.m26255c();
                UploadOnceTask.f37036d.execute(UploadOnceTask.this);
            }
        }, j);
    }

    /* renamed from: b */
    private void m26253b(final UploadResult uploadResult) {
        f37035c.post(new Runnable() {
            public void run() {
                if (UploadOnceTask.this.f37041i != null) {
                    UploadOnceTask.this.f37041i.onExecuteCompleted(uploadResult);
                }
            }
        });
    }

    /* renamed from: f */
    private TrackLocationInfo m26258f() {
        TrackLocationInfo lastEffectiveLocation = LocationCenter.getIntance().getLastEffectiveLocation();
        if (lastEffectiveLocation != null) {
            TrackLog.m31343d(f37033a, "upload task=" + toHexString() + " getLocFromLocCache");
            return new TrackLocationInfo.Builder(lastEffectiveLocation).map_extra_point_data((MapTrackExtraPointData) null).build();
        }
        if (UploadFlags.hasFlag(this.f37040h, 4)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            TrackLocationInfo requestLocationOnceSync = LocationCenter.getIntance().requestLocationOnceSync(10000);
            if (requestLocationOnceSync != null) {
                TrackLog.m31343d(f37033a, "upload task=" + toHexString() + " getLocFromLocOnce timediff=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                return new TrackLocationInfo.Builder(requestLocationOnceSync).map_extra_point_data((MapTrackExtraPointData) null).build();
            }
        }
        TrackLog.m31343d(f37033a, "upload task=" + toHexString() + " getLocFail");
        return null;
    }

    public String toString() {
        return "UploadOnceTask@" + Integer.toHexString(hashCode());
    }

    public String toHexString() {
        return Integer.toHexString(hashCode());
    }

    private static class SerialExecutor implements Executor {
        private Runnable mActive;
        final Map<String, Integer> mTagPendingTaskCount;
        final ArrayDeque<Runnable> mTasks;

        private SerialExecutor() {
            this.mTasks = new ArrayDeque<>();
            this.mTagPendingTaskCount = new HashMap();
        }

        public synchronized void execute(final Runnable runnable) {
            addPendingTask(runnable);
            this.mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        SerialExecutor.this.removePendingTask(runnable);
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        /* access modifiers changed from: private */
        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void addPendingTask(java.lang.Runnable r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r3 instanceof com.didi.trackupload.sdk.core.UploadOnceTask     // Catch:{ all -> 0x0032 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r2)
                return
            L_0x0007:
                com.didi.trackupload.sdk.core.UploadOnceTask r3 = (com.didi.trackupload.sdk.core.UploadOnceTask) r3     // Catch:{ all -> 0x0032 }
                com.didi.trackupload.sdk.TrackOnceClient r0 = r3.f37039g     // Catch:{ all -> 0x0032 }
                if (r0 == 0) goto L_0x0030
                com.didi.trackupload.sdk.TrackOnceClient r3 = r3.f37039g     // Catch:{ all -> 0x0032 }
                java.lang.String r3 = r3.getTrackTag()     // Catch:{ all -> 0x0032 }
                java.util.Map<java.lang.String, java.lang.Integer> r0 = r2.mTagPendingTaskCount     // Catch:{ all -> 0x0032 }
                java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0032 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0032 }
                r1 = 1
                if (r0 == 0) goto L_0x0027
                int r0 = r0.intValue()     // Catch:{ all -> 0x0032 }
                int r1 = r1 + r0
            L_0x0027:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0032 }
                java.util.Map<java.lang.String, java.lang.Integer> r1 = r2.mTagPendingTaskCount     // Catch:{ all -> 0x0032 }
                r1.put(r3, r0)     // Catch:{ all -> 0x0032 }
            L_0x0030:
                monitor-exit(r2)
                return
            L_0x0032:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.UploadOnceTask.SerialExecutor.addPendingTask(java.lang.Runnable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void removePendingTask(java.lang.Runnable r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r3 instanceof com.didi.trackupload.sdk.core.UploadOnceTask     // Catch:{ all -> 0x003a }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r2)
                return
            L_0x0007:
                com.didi.trackupload.sdk.core.UploadOnceTask r3 = (com.didi.trackupload.sdk.core.UploadOnceTask) r3     // Catch:{ all -> 0x003a }
                com.didi.trackupload.sdk.TrackOnceClient r0 = r3.f37039g     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x0038
                com.didi.trackupload.sdk.TrackOnceClient r3 = r3.f37039g     // Catch:{ all -> 0x003a }
                java.lang.String r3 = r3.getTrackTag()     // Catch:{ all -> 0x003a }
                java.util.Map<java.lang.String, java.lang.Integer> r0 = r2.mTagPendingTaskCount     // Catch:{ all -> 0x003a }
                java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x003a }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x002e
                int r1 = r0.intValue()     // Catch:{ all -> 0x003a }
                if (r1 <= 0) goto L_0x002e
                int r0 = r0.intValue()     // Catch:{ all -> 0x003a }
                int r0 = r0 + -1
                goto L_0x002f
            L_0x002e:
                r0 = 0
            L_0x002f:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x003a }
                java.util.Map<java.lang.String, java.lang.Integer> r1 = r2.mTagPendingTaskCount     // Catch:{ all -> 0x003a }
                r1.put(r3, r0)     // Catch:{ all -> 0x003a }
            L_0x0038:
                monitor-exit(r2)
                return
            L_0x003a:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.UploadOnceTask.SerialExecutor.removePendingTask(java.lang.Runnable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean hasPendingTask(java.lang.Runnable r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r4 instanceof com.didi.trackupload.sdk.core.UploadOnceTask     // Catch:{ all -> 0x002d }
                r1 = 0
                if (r0 != 0) goto L_0x0008
                monitor-exit(r3)
                return r1
            L_0x0008:
                com.didi.trackupload.sdk.core.UploadOnceTask r4 = (com.didi.trackupload.sdk.core.UploadOnceTask) r4     // Catch:{ all -> 0x002d }
                com.didi.trackupload.sdk.TrackOnceClient r0 = r4.f37039g     // Catch:{ all -> 0x002d }
                r2 = 1
                if (r0 == 0) goto L_0x002b
                com.didi.trackupload.sdk.TrackOnceClient r4 = r4.f37039g     // Catch:{ all -> 0x002d }
                java.lang.String r4 = r4.getTrackTag()     // Catch:{ all -> 0x002d }
                java.util.Map<java.lang.String, java.lang.Integer> r0 = r3.mTagPendingTaskCount     // Catch:{ all -> 0x002d }
                java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x002d }
                java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x002d }
                if (r4 == 0) goto L_0x002a
                int r4 = r4.intValue()     // Catch:{ all -> 0x002d }
                if (r4 <= 0) goto L_0x002a
                r1 = 1
            L_0x002a:
                r2 = r1
            L_0x002b:
                monitor-exit(r3)
                return r2
            L_0x002d:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.UploadOnceTask.SerialExecutor.hasPendingTask(java.lang.Runnable):boolean");
        }
    }

    /* renamed from: a */
    private long m26247a(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
