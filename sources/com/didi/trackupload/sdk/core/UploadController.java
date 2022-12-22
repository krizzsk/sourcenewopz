package com.didi.trackupload.sdk.core;

import android.support.p003v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.didi.trackupload.sdk.ITrackDataDelegate;
import com.didi.trackupload.sdk.TrackClient;
import com.didi.trackupload.sdk.TrackOnceClient;
import com.didi.trackupload.sdk.TrackOptions;
import com.didi.trackupload.sdk.core.ScheduleController;
import com.didi.trackupload.sdk.datachannel.protobuf.ClientType;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.storage.BizNodeEntity;
import com.didi.trackupload.sdk.storage.TrackDataStorage;
import com.didi.trackupload.sdk.utils.LogStringUtils;
import com.didi.trackupload.sdk.utils.MathUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadController implements ScheduleController.OnScheduleListener {
    public static final String TAG = "TrackUpload";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Map<String, UploadClient> f37026a = new HashMap();

    class UploadClient {
        TrackClient client;
        boolean gatherActive;
        int intervalSeconds;
        boolean uploadActive = true;
        boolean uploadOnce;

        UploadClient(TrackClient trackClient, boolean z) {
            update(trackClient);
            this.uploadOnce = z;
        }

        /* access modifiers changed from: package-private */
        public void update(TrackClient trackClient) {
            this.client = trackClient;
            this.intervalSeconds = (int) (trackClient.getTrackOptions().getUploadIntervalMode().value() / 1000);
            this.gatherActive = trackClient.getTrackOptions().getGatherIntervalMode() != TrackOptions.GatherIntervalMode.NEVER;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UploadClient)) {
                return false;
            }
            return TextUtils.equals(this.client.getTrackTag(), ((UploadClient) obj).client.getTrackTag());
        }

        public int hashCode() {
            return this.client.hashCode();
        }
    }

    public void addClient(TrackClient trackClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m31343d(TAG, "addClient client=" + trackClient.toSimpleString());
            this.f37026a.put(trackClient.getTrackTag(), new UploadClient(trackClient, true));
            m26240a();
        }
    }

    public void removeClient(final TrackClient trackClient) {
        final BizNodeEntity a = m26237a(trackClient);
        TrackLog.m31343d(TAG, "removeClient client=" + trackClient.toSimpleString());
        CoreThread.post(new Runnable() {
            public void run() {
                UploadClient uploadClient = (UploadClient) UploadController.this.f37026a.get(trackClient.getTrackTag());
                if (uploadClient != null) {
                    TrackDataStorage.getInstance().saveBizNodeEntity(a);
                    uploadClient.uploadOnce = true;
                    uploadClient.uploadActive = false;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26243b(TrackClient trackClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m31343d(TAG, "removeClientInternal client=" + trackClient.toSimpleString());
            this.f37026a.remove(trackClient.getTrackTag());
            m26240a();
        }
    }

    public void updateClient(TrackClient trackClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m31343d(TAG, "updateClient client=" + trackClient.toSimpleString());
            UploadClient uploadClient = this.f37026a.get(trackClient.getTrackTag());
            if (uploadClient != null) {
                uploadClient.update(trackClient);
            }
            m26240a();
        }
    }

    public void startOnceClient(TrackOnceClient trackOnceClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m31343d(TAG, "startOnceClient client=" + trackOnceClient.toSimpleString());
            m26244b(trackOnceClient);
        }
    }

    /* renamed from: a */
    private void m26240a() {
        int d = ScheduleController.m26221a().mo95201d();
        int i = 0;
        for (Map.Entry next : this.f37026a.entrySet()) {
            if (((UploadClient) next.getValue()).intervalSeconds > 0) {
                if (i != 0) {
                    i = MathUtils.gcd(i, ((UploadClient) next.getValue()).intervalSeconds);
                } else {
                    i = ((UploadClient) next.getValue()).intervalSeconds;
                }
            }
        }
        if (i > 0) {
            if (i != d) {
                ScheduleController.m26221a().mo95199b(this, i);
            }
        } else if (d > 0) {
            ScheduleController.m26221a().mo95202e();
        }
    }

    public void onEventSchedule(long j, TrackLocationInfo trackLocationInfo) {
        if (CoreThread.ensureCoreThread()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Map.Entry<String, UploadClient> value : this.f37026a.entrySet()) {
                final UploadClient uploadClient = (UploadClient) value.getValue();
                if (uploadClient.uploadOnce || j % ((long) uploadClient.intervalSeconds) == 0) {
                    z = true;
                    hashMap.put(uploadClient.client.getTrackTag(), uploadClient);
                    if (uploadClient.gatherActive || uploadClient.uploadOnce) {
                        arrayList.add(m26237a(uploadClient.client));
                    }
                    if (uploadClient.uploadOnce) {
                        uploadClient.uploadOnce = false;
                    }
                } else {
                    hashMap.put(uploadClient.client.getTrackTag(), (Object) null);
                }
                if (!uploadClient.uploadActive && !uploadClient.uploadOnce) {
                    CoreThread.post(new Runnable() {
                        public void run() {
                            UploadController.this.m26243b(uploadClient.client);
                        }
                    });
                }
            }
            if (z) {
                m26242a((Map<String, UploadClient>) hashMap, (List<BizNodeEntity>) arrayList);
            }
        }
    }

    public void onBaseClockSchedule(long j) {
        if (CoreThread.ensureCoreThread()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Map.Entry<String, UploadClient> value : this.f37026a.entrySet()) {
                final UploadClient uploadClient = (UploadClient) value.getValue();
                if (uploadClient.uploadOnce) {
                    z = true;
                    hashMap.put(uploadClient.client.getTrackTag(), uploadClient);
                    arrayList.add(m26237a(uploadClient.client));
                    uploadClient.uploadOnce = false;
                } else {
                    hashMap.put(uploadClient.client.getTrackTag(), (Object) null);
                }
                if (!uploadClient.uploadActive && !uploadClient.uploadOnce) {
                    CoreThread.post(new Runnable() {
                        public void run() {
                            UploadController.this.m26243b(uploadClient.client);
                        }
                    });
                }
            }
            if (z) {
                m26242a((Map<String, UploadClient>) hashMap, (List<BizNodeEntity>) arrayList);
            }
        }
    }

    /* renamed from: a */
    static BizNodeEntity m26237a(TrackClient trackClient) {
        ClientType protoValue = trackClient.getClientType().getProtoValue();
        ITrackDataDelegate trackDataDelegate = trackClient.getTrackDataDelegate();
        Integer num = null;
        byte[] customData = trackDataDelegate != null ? trackDataDelegate.getCustomData() : null;
        BizNodeEntity bizNodeEntity = new BizNodeEntity();
        bizNodeEntity.setTag(trackClient.getTrackTag());
        if (protoValue != null) {
            num = Integer.valueOf(protoValue.getValue());
        }
        bizNodeEntity.setClient_type(num);
        bizNodeEntity.setExtra_data(customData);
        return bizNodeEntity;
    }

    /* renamed from: a */
    static BizNodeEntity m26238a(TrackOnceClient trackOnceClient) {
        ClientType protoValue = trackOnceClient.getClientType().getProtoValue();
        ITrackDataDelegate trackDataDelegate = trackOnceClient.getTrackDataDelegate();
        Integer num = null;
        byte[] customData = trackDataDelegate != null ? trackDataDelegate.getCustomData() : null;
        BizNodeEntity bizNodeEntity = new BizNodeEntity();
        bizNodeEntity.setTag(trackOnceClient.getTrackTag());
        if (protoValue != null) {
            num = Integer.valueOf(protoValue.getValue());
        }
        bizNodeEntity.setClient_type(num);
        bizNodeEntity.setExtra_data(customData);
        return bizNodeEntity;
    }

    /* renamed from: a */
    private void m26242a(Map<String, UploadClient> map, List<BizNodeEntity> list) {
        TrackDataStorage.getInstance().saveBizNodeEntities(list);
        UploadTask uploadTask = new UploadTask(map, UploadFlags.m26245a(65536));
        TrackLog.m31343d(TAG, "upload task=" + uploadTask.toHexString() + " tags=" + LogStringUtils.parseTags((Map<String, ?>) map));
        uploadTask.mo95246a();
    }

    /* renamed from: b */
    private void m26244b(TrackOnceClient trackOnceClient) {
        UploadOnceTask uploadOnceTask = new UploadOnceTask(trackOnceClient, UploadFlags.m26245a(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, 4));
        TrackLog.m31343d(TAG, "upload once task=" + uploadOnceTask + " tags=" + LogStringUtils.parseTags(trackOnceClient.getTrackTag()));
        uploadOnceTask.mo95230a();
    }
}
