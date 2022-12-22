package com.didi.trackupload.sdk.core;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.didi.trackupload.sdk.Constants;
import com.didi.trackupload.sdk.ICommonInfoDelegate;
import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.core.UploadController;
import com.didi.trackupload.sdk.datachannel.DataChannel;
import com.didi.trackupload.sdk.datachannel.SendResult;
import com.didi.trackupload.sdk.datachannel.protobuf.CollectSvrCoordinateReq;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackNode;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackUploadReq;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.storage.BizNodeEntity;
import com.didi.trackupload.sdk.storage.TrackDataStorage;
import com.didi.trackupload.sdk.storage.TrackNodeEntity;
import com.didi.trackupload.sdk.utils.ApolloUtils;
import com.didi.trackupload.sdk.utils.LocUtils;
import com.didi.trackupload.sdk.utils.OmegaUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.wire.Wire;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class UploadTask implements Runnable {

    /* renamed from: a */
    private static final String f37049a = "TrackTask";

    /* renamed from: b */
    private static final String f37050b = "TrackTaskDetail";

    /* renamed from: c */
    private static final Handler f37051c = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final SerialExecutor f37052d = new SerialExecutor();

    /* renamed from: e */
    private static final Gson f37053e = new GsonBuilder().setPrettyPrinting().create();

    /* renamed from: f */
    private static final Wire f37054f = new Wire((Class<?>[]) new Class[0]);

    /* renamed from: g */
    private static final int f37055g = ApolloUtils.requestCountPerPatchParam();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Map<String, UploadController.UploadClient> f37056h;

    /* renamed from: i */
    private long f37057i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public OnExecuteCompletedListenser f37058j;

    /* renamed from: k */
    private Long f37059k;

    /* renamed from: l */
    private Long f37060l;

    /* renamed from: m */
    private Long f37061m;

    /* renamed from: n */
    private Long f37062n;

    /* renamed from: o */
    private Integer f37063o;

    /* renamed from: p */
    private int f37064p;

    /* renamed from: q */
    private int f37065q;

    interface OnExecuteCompletedListenser {
        void onExecuteCompleted(UploadResult uploadResult);
    }

    /* renamed from: b */
    private String m26267b(String str) {
        return str != null ? str : "";
    }

    UploadTask(Map<String, UploadController.UploadClient> map) {
        this(map, 0, (OnExecuteCompletedListenser) null);
    }

    UploadTask(Map<String, UploadController.UploadClient> map, long j) {
        this(map, j, (OnExecuteCompletedListenser) null);
    }

    UploadTask(Map<String, UploadController.UploadClient> map, long j, OnExecuteCompletedListenser onExecuteCompletedListenser) {
        this.f37057i = 0;
        this.f37056h = map;
        this.f37057i = j;
        this.f37058j = onExecuteCompletedListenser;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26270c() {
        this.f37060l = Long.valueOf(System.currentTimeMillis());
    }

    /* renamed from: d */
    private void m26271d() {
        this.f37061m = Long.valueOf(System.currentTimeMillis());
        m26263a(m26272e());
    }

    /* renamed from: a */
    private void m26263a(UploadResult uploadResult) {
        Long valueOf = uploadResult == UploadResult.ERR_OK ? Long.valueOf(System.currentTimeMillis()) : null;
        TrackLog.m31343d(f37049a, "upload completed task=" + toHexString() + " flags=" + this.f37057i + " result=" + uploadResult.toSimpleString());
        OmegaUtils.trackUploadResult(uploadResult, this.f37059k, this.f37060l, this.f37061m, this.f37062n, valueOf, this.f37063o, false, Long.valueOf(this.f37057i), Integer.valueOf(this.f37064p), Integer.valueOf(this.f37065q));
        m26268b(uploadResult);
    }

    /* renamed from: e */
    private UploadResult m26272e() {
        if (!DataChannel.getIntance().isConnected()) {
            return UploadResult.ERR_STATE_DATA_CHANNEL_NOT_CONNECTED;
        }
        ICommonInfoDelegate commonInfoDelegate = TrackController.getIntance().getInitParams().getCommonInfoDelegate();
        if (commonInfoDelegate == null) {
            return UploadResult.ERR_PARAMS_COMMON_INFO_DELEGATE;
        }
        if (f37052d.hasPendingTask(this)) {
            return UploadResult.ERR_STATE_HAS_PENDING_TASK;
        }
        TrackLocationInfo retrieveCurrentLocation = LocationCenter.getIntance().retrieveCurrentLocation(this.f37057i);
        if (retrieveCurrentLocation == null) {
            return UploadResult.ERR_STATE_LAST_LOCATION;
        }
        this.f37059k = retrieveCurrentLocation.timestamp64_loc;
        TrackUploadReq trackUploadReq = null;
        List<TrackLocationInfo> a = UploadFlags.hasFlag(this.f37057i, 2) ? m26262a(retrieveCurrentLocation) : null;
        List<TrackNodeEntity> trackNodeEntities = TrackDataStorage.getInstance().getTrackNodeEntities(f37055g);
        List<BizNodeEntity> allBizNodeEntities = TrackDataStorage.getInstance().getAllBizNodeEntities();
        HashSet hashSet = new HashSet();
        for (TrackNodeEntity tags : trackNodeEntities) {
            List<String> tags2 = tags.getTags();
            if (tags2 != null) {
                hashSet.addAll(tags2);
            }
        }
        HashMap hashMap = new HashMap();
        Map<String, UploadController.UploadClient> map = this.f37056h;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                UploadController.UploadClient uploadClient = (UploadController.UploadClient) next.getValue();
                if (uploadClient != null && !uploadClient.gatherActive && uploadClient.uploadActive) {
                    hashMap.put(next.getKey(), UploadController.m26237a(uploadClient.client));
                }
            }
        }
        for (BizNodeEntity next2 : allBizNodeEntities) {
            String tag = next2.getTag();
            if (!hashMap.containsKey(tag)) {
                Map<String, UploadController.UploadClient> map2 = this.f37056h;
                if (map2 == null || !map2.containsKey(tag)) {
                    if (hashSet.contains(tag)) {
                        hashMap.put(tag, next2);
                    }
                } else if (this.f37056h.get(tag) != null) {
                    hashMap.put(tag, next2);
                }
            }
        }
        if (hashMap.size() <= 0) {
            return UploadResult.ERR_PARAMS_BIZ_NODES;
        }
        List<TrackNode> arrayList = new ArrayList<>();
        try {
            arrayList = TrackNodeEntity.toPBMessages(trackNodeEntities);
            trackUploadReq = new TrackUploadReq.Builder().phone(m26267b(commonInfoDelegate.getPhone())).user_id(Long.valueOf(m26261a(commonInfoDelegate.getUid()))).upload_time64_mobile(Long.valueOf(System.currentTimeMillis())).upload_time64_loc(retrieveCurrentLocation.timestamp64_loc).loc(retrieveCurrentLocation).loc_rectified((TrackLocationInfo) null).loc_recent(a).track_nodes(arrayList).biz_info(BizNodeEntity.toPBMessages((Collection<BizNodeEntity>) hashMap.values())).map_extra_message_data(retrieveCurrentLocation.map_extra_message_data).build();
        } catch (Exception e) {
            OmegaUtils.trackWireError(201, e);
        }
        if (trackUploadReq == null) {
            return UploadResult.ERR_STATE_BUILD_UPLOAD_REQ;
        }
        if (!DataChannel.getIntance().isConnected()) {
            return UploadResult.ERR_STATE_DATA_CHANNEL_NOT_CONNECTED;
        }
        TrackLog.m31343d(f37049a, "upload task=" + toHexString() + " loc.time=" + retrieveCurrentLocation.timestamp64_loc + " nodes=" + arrayList.size());
        if (Constants.DEBUG) {
            try {
                TrackLog.m31343d(f37050b, "---------------------------------------------------");
                TrackLog.m31343d(f37050b, "upload task=" + toHexString() + " TrackUploadReq=" + f37053e.toJson((Object) trackUploadReq, (Type) TrackUploadReq.class));
                for (BizNodeEntity bizNodeEntity : hashMap.values()) {
                    TrackLog.m31343d(f37050b, "upload biz_info task=" + toHexString() + " tag={" + bizNodeEntity.getTag() + "} CollectSvrCoordinateReq=" + f37053e.toJson((Object) (CollectSvrCoordinateReq) f37054f.parseFrom(bizNodeEntity.getExtra_data(), CollectSvrCoordinateReq.class), (Type) CollectSvrCoordinateReq.class));
                }
            } catch (Exception unused) {
            }
        }
        String buildClientsString = BizNodeEntity.buildClientsString(hashMap);
        this.f37062n = Long.valueOf(System.currentTimeMillis());
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SendResult sendMessage = DataChannel.getIntance().sendMessage(trackUploadReq, this.f37057i, buildClientsString);
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 5000) {
            TrackLog.m31343d(f37049a, "upload sendmsg task=" + toHexString() + " timediff=" + elapsedRealtime2 + "ms");
        }
        if (sendMessage == null) {
            return UploadResult.ERR_STATE_UPLOAD_FAILED;
        }
        this.f37063o = Integer.valueOf(sendMessage.getBytesLength());
        this.f37064p = sendMessage.getSendType();
        this.f37065q = sendMessage.getDetailCode();
        if (sendMessage.getResultCode() == 0) {
            TrackDataStorage.getInstance().removeTrackNodeEntities(trackNodeEntities);
            return UploadResult.ERR_OK;
        } else if (sendMessage.getResultCode() == -1 && sendMessage.getDetailCode() == -1100) {
            return UploadResult.ERR_STATE_BUILD_UPLOAD_REQ;
        } else {
            return sendMessage.getResultCode() == -2 ? UploadResult.ERR_STATE_UPLOAD_TIMEOUT : UploadResult.ERR_STATE_UPLOAD_FAILED;
        }
    }

    public void run() {
        m26271d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo95246a() {
        mo95247a(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo95247a(long j) {
        f37051c.postDelayed(new Runnable() {
            public void run() {
                UploadTask.this.m26270c();
                UploadTask.f37052d.execute(UploadTask.this);
            }
        }, j);
    }

    /* renamed from: b */
    private void m26268b(final UploadResult uploadResult) {
        f37051c.post(new Runnable() {
            public void run() {
                if (UploadTask.this.f37058j != null) {
                    UploadTask.this.f37058j.onExecuteCompleted(uploadResult);
                }
            }
        });
    }

    /* renamed from: a */
    private List<TrackLocationInfo> m26262a(TrackLocationInfo trackLocationInfo) {
        List<TrackLocationInfo> arrayList = new ArrayList<>();
        if (arrayList.size() <= 1) {
            arrayList = LocationCenter.getIntance().getRecentLocations(5);
        }
        if (arrayList.size() <= 1) {
            arrayList = TrackDataStorage.getInstance().getRecentLocations(5);
        }
        if (arrayList != null && arrayList.size() > 0) {
            if (LocUtils.similarTrackLocationInfo(trackLocationInfo, arrayList.get(arrayList.size() - 1))) {
                arrayList.remove(arrayList.size() - 1);
            } else {
                arrayList.remove(0);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "UploadTask@" + Integer.toHexString(hashCode());
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
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void addPendingTask(java.lang.Runnable r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = r5 instanceof com.didi.trackupload.sdk.core.UploadTask     // Catch:{ all -> 0x006c }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r4)
                return
            L_0x0007:
                com.didi.trackupload.sdk.core.UploadTask r5 = (com.didi.trackupload.sdk.core.UploadTask) r5     // Catch:{ all -> 0x006c }
                java.util.Map r0 = r5.f37056h     // Catch:{ all -> 0x006c }
                r1 = 1
                if (r0 == 0) goto L_0x0051
                java.util.Map r5 = r5.f37056h     // Catch:{ all -> 0x006c }
                java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x006c }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x006c }
            L_0x001c:
                boolean r0 = r5.hasNext()     // Catch:{ all -> 0x006c }
                if (r0 == 0) goto L_0x006a
                java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x006c }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x006c }
                java.lang.Object r2 = r0.getValue()     // Catch:{ all -> 0x006c }
                if (r2 == 0) goto L_0x001c
                java.util.Map<java.lang.String, java.lang.Integer> r2 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x006c }
                java.lang.Object r3 = r0.getKey()     // Catch:{ all -> 0x006c }
                java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x006c }
                java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x006c }
                if (r2 == 0) goto L_0x0042
                int r2 = r2.intValue()     // Catch:{ all -> 0x006c }
                int r2 = r2 + r1
                goto L_0x0043
            L_0x0042:
                r2 = 1
            L_0x0043:
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x006c }
                java.util.Map<java.lang.String, java.lang.Integer> r3 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x006c }
                java.lang.Object r0 = r0.getKey()     // Catch:{ all -> 0x006c }
                r3.put(r0, r2)     // Catch:{ all -> 0x006c }
                goto L_0x001c
            L_0x0051:
                java.util.Map<java.lang.String, java.lang.Integer> r5 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x006c }
                r0 = 0
                java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x006c }
                java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x006c }
                if (r5 == 0) goto L_0x0061
                int r5 = r5.intValue()     // Catch:{ all -> 0x006c }
                int r1 = r1 + r5
            L_0x0061:
                java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x006c }
                java.util.Map<java.lang.String, java.lang.Integer> r1 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x006c }
                r1.put(r0, r5)     // Catch:{ all -> 0x006c }
            L_0x006a:
                monitor-exit(r4)
                return
            L_0x006c:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.UploadTask.SerialExecutor.addPendingTask(java.lang.Runnable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void removePendingTask(java.lang.Runnable r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = r5 instanceof com.didi.trackupload.sdk.core.UploadTask     // Catch:{ all -> 0x007a }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r4)
                return
            L_0x0007:
                com.didi.trackupload.sdk.core.UploadTask r5 = (com.didi.trackupload.sdk.core.UploadTask) r5     // Catch:{ all -> 0x007a }
                java.util.Map r0 = r5.f37056h     // Catch:{ all -> 0x007a }
                r1 = 0
                if (r0 == 0) goto L_0x0058
                java.util.Map r5 = r5.f37056h     // Catch:{ all -> 0x007a }
                java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x007a }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x007a }
            L_0x001c:
                boolean r0 = r5.hasNext()     // Catch:{ all -> 0x007a }
                if (r0 == 0) goto L_0x0078
                java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x007a }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x007a }
                java.lang.Object r2 = r0.getValue()     // Catch:{ all -> 0x007a }
                if (r2 == 0) goto L_0x001c
                java.util.Map<java.lang.String, java.lang.Integer> r2 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x007a }
                java.lang.Object r3 = r0.getKey()     // Catch:{ all -> 0x007a }
                java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x007a }
                java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x007a }
                if (r2 == 0) goto L_0x0049
                int r3 = r2.intValue()     // Catch:{ all -> 0x007a }
                if (r3 <= 0) goto L_0x0049
                int r2 = r2.intValue()     // Catch:{ all -> 0x007a }
                int r2 = r2 + -1
                goto L_0x004a
            L_0x0049:
                r2 = 0
            L_0x004a:
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x007a }
                java.util.Map<java.lang.String, java.lang.Integer> r3 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x007a }
                java.lang.Object r0 = r0.getKey()     // Catch:{ all -> 0x007a }
                r3.put(r0, r2)     // Catch:{ all -> 0x007a }
                goto L_0x001c
            L_0x0058:
                java.util.Map<java.lang.String, java.lang.Integer> r5 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x007a }
                r0 = 0
                java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x007a }
                java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x007a }
                if (r5 == 0) goto L_0x006f
                int r2 = r5.intValue()     // Catch:{ all -> 0x007a }
                if (r2 <= 0) goto L_0x006f
                int r5 = r5.intValue()     // Catch:{ all -> 0x007a }
                int r1 = r5 + -1
            L_0x006f:
                java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x007a }
                java.util.Map<java.lang.String, java.lang.Integer> r1 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x007a }
                r1.put(r0, r5)     // Catch:{ all -> 0x007a }
            L_0x0078:
                monitor-exit(r4)
                return
            L_0x007a:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.UploadTask.SerialExecutor.removePendingTask(java.lang.Runnable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
            if (r5.intValue() > 0) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean hasPendingTask(java.lang.Runnable r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = r5 instanceof com.didi.trackupload.sdk.core.UploadTask     // Catch:{ all -> 0x005a }
                r1 = 0
                if (r0 != 0) goto L_0x0008
                monitor-exit(r4)
                return r1
            L_0x0008:
                com.didi.trackupload.sdk.core.UploadTask r5 = (com.didi.trackupload.sdk.core.UploadTask) r5     // Catch:{ all -> 0x005a }
                java.util.Map r0 = r5.f37056h     // Catch:{ all -> 0x005a }
                r2 = 1
                if (r0 == 0) goto L_0x0046
                java.util.Map r5 = r5.f37056h     // Catch:{ all -> 0x005a }
                java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x005a }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x005a }
            L_0x001d:
                boolean r0 = r5.hasNext()     // Catch:{ all -> 0x005a }
                if (r0 == 0) goto L_0x0044
                java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x005a }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x005a }
                java.lang.Object r3 = r0.getValue()     // Catch:{ all -> 0x005a }
                if (r3 == 0) goto L_0x001d
                java.util.Map<java.lang.String, java.lang.Integer> r3 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x005a }
                java.lang.Object r0 = r0.getKey()     // Catch:{ all -> 0x005a }
                java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x005a }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x005a }
                if (r0 == 0) goto L_0x0058
                int r0 = r0.intValue()     // Catch:{ all -> 0x005a }
                if (r0 > 0) goto L_0x001d
                goto L_0x0058
            L_0x0044:
                r1 = 1
                goto L_0x0058
            L_0x0046:
                java.util.Map<java.lang.String, java.lang.Integer> r5 = r4.mTagPendingTaskCount     // Catch:{ all -> 0x005a }
                r0 = 0
                java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x005a }
                java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x005a }
                if (r5 == 0) goto L_0x0058
                int r5 = r5.intValue()     // Catch:{ all -> 0x005a }
                if (r5 <= 0) goto L_0x0058
                goto L_0x0044
            L_0x0058:
                monitor-exit(r4)
                return r1
            L_0x005a:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.UploadTask.SerialExecutor.hasPendingTask(java.lang.Runnable):boolean");
        }
    }

    /* renamed from: a */
    private long m26261a(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
