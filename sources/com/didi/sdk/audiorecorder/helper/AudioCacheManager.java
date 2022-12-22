package com.didi.sdk.audiorecorder.helper;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.model.RecordResult;
import com.didi.sdk.audiorecorder.p147db.RecordDaoUtils;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class AudioCacheManager {

    /* renamed from: a */
    private static final String f35305a = "AudioCacheManagerImpl -> ";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final TreeSet<LoadCallback> f35306b = new TreeSet<>();

    /* renamed from: c */
    private ExecutorService f35307c = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-cache-manager");
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f35308d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AudioRecordContext f35309e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<RecordResult> f35310f;

    /* renamed from: g */
    private long f35311g;

    interface LoadCallback extends Comparable<LoadCallback> {
        int getPriority();

        void onLoadFinish(List<RecordResult> list);
    }

    public AudioCacheManager(Context context) {
        this.f35308d = context.getApplicationContext();
        loadAllRecord((LoadCallback) null);
    }

    public void update(AudioRecordContext audioRecordContext) {
        this.f35309e = audioRecordContext;
        this.f35311g = audioRecordContext.getAudioExpiredDuration() >= 0 ? audioRecordContext.getAudioExpiredDuration() : 1209600000;
        LogUtil.log(f35305a, "update mCacheExpiredTime = " + this.f35311g);
        m25001a(this.f35310f);
    }

    public void saveRecord(final RecordResult recordResult) {
        if (this.f35310f == null) {
            loadAllRecord(new CustomLoadCallback() {
                public void onLoadFinish(List<RecordResult> list) {
                    AudioCacheManager.this.saveRecord(recordResult);
                }
            });
            return;
        }
        final int a = m24997a(recordResult);
        this.f35310f.add(recordResult);
        this.f35307c.execute(new Runnable() {
            public void run() {
                if (a != -1) {
                    RecordDaoUtils.update(AudioCacheManager.this.f35308d, recordResult);
                } else {
                    RecordDaoUtils.insert(AudioCacheManager.this.f35308d, recordResult);
                }
            }
        });
    }

    /* renamed from: a */
    private int m24997a(RecordResult recordResult) {
        int indexOf = this.f35310f.indexOf(recordResult);
        if (indexOf != -1) {
            try {
                this.f35310f.remove(indexOf);
            } catch (Exception unused) {
                return m24997a(recordResult);
            }
        }
        return indexOf;
    }

    public void removeRecord(String str) {
        if (this.f35310f != null) {
            LogUtil.log(f35305a, "removeRecord by orderIds: ", str);
            ArrayList<RecordResult> arrayList = new ArrayList<>();
            for (RecordResult next : this.f35310f) {
                if (str.equals(next.getOrderIds())) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                this.f35310f.removeAll(arrayList);
                for (RecordResult b : arrayList) {
                    m25005b(b);
                }
            }
        } else if (!m25002a()) {
            loadAllRecord((LoadCallback) null);
        }
    }

    /* renamed from: b */
    private void m25005b(RecordResult recordResult) {
        final String audioFilePath = recordResult.getAudioFilePath();
        final long startRecordTime = recordResult.getStartRecordTime();
        this.f35307c.execute(new Runnable() {
            public void run() {
                if (!AudioCacheManager.this.f35309e.debugable()) {
                    File file = new File(audioFilePath);
                    if (file.exists()) {
                        file.delete();
                    }
                    File file2 = new File(audioFilePath + "_encrypt");
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
                RecordDaoUtils.del(AudioCacheManager.this.f35308d, startRecordTime);
            }
        });
    }

    public void removeRecord(RecordResult recordResult) {
        if (this.f35310f != null) {
            LogUtil.log(f35305a, "removeRecord ", recordResult.getAudioFilePath());
            int indexOf = this.f35310f.indexOf(recordResult);
            if (indexOf != -1) {
                this.f35310f.remove(indexOf);
                m25005b(recordResult);
            }
        } else if (!m25002a()) {
            loadAllRecord((LoadCallback) null);
        }
    }

    public void loadAllRecord(final LoadCallback loadCallback) {
        if (this.f35310f != null) {
            LogUtil.log(f35305a, "loadAllRecord -> callback immediately.");
            if (loadCallback != null) {
                loadCallback.onLoadFinish(Collections.unmodifiableList(this.f35310f));
                return;
            }
            return;
        }
        if (loadCallback == null) {
            loadCallback = new EmptyLoadCallback();
        } else if (!(loadCallback instanceof EmptyLoadCallback) && !(loadCallback instanceof FilterExpiredCacheCallback) && !(loadCallback instanceof CustomLoadCallback)) {
            loadCallback = new CustomLoadCallback() {
                public void onLoadFinish(List<RecordResult> list) {
                    loadCallback.onLoadFinish(list);
                }
            };
        }
        boolean a = m25002a();
        m25000a(loadCallback);
        if (a) {
            LogUtil.log(f35305a, "loadAllRecord -> blocked ~ isLoading.");
        } else {
            this.f35307c.execute(new Runnable() {
                public void run() {
                    List<RecordResult> resolveRecords = resolveRecords(RecordDaoUtils.getAll(AudioCacheManager.this.f35308d));
                    List unused = AudioCacheManager.this.f35310f = resolveRecords;
                    callbackPendings(Collections.unmodifiableList(resolveRecords));
                }

                private List<RecordResult> resolveRecords(List<RecordResult> list) {
                    AudioCacheManager.this.m25001a(list);
                    LinkedList linkedList = new LinkedList();
                    if (list != null) {
                        linkedList.addAll(list);
                    }
                    return Collections.synchronizedList(linkedList);
                }

                private void callbackPendings(List<RecordResult> list) {
                    if (!AudioCacheManager.this.f35306b.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        synchronized (AudioCacheManager.this.f35306b) {
                            arrayList.addAll(AudioCacheManager.this.f35306b);
                            AudioCacheManager.this.f35306b.clear();
                        }
                        LogUtil.log(AudioCacheManager.f35305a, "loadAllRecord finish. callbackPendings size = " + arrayList.size());
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            LoadCallback loadCallback = (LoadCallback) it.next();
                            LogUtil.log(AudioCacheManager.f35305a, "loadAllRecord finish. callbackPendings : ", loadCallback.getClass().getSimpleName());
                            if (!(loadCallback instanceof EmptyLoadCallback)) {
                                loadCallback.onLoadFinish(list);
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25001a(List<RecordResult> list) {
        if (list == null) {
            LogUtil.log(f35305a, "filterExpiredRecord cancel.(empty list)");
            return;
        }
        AudioRecordContext audioRecordContext = this.f35309e;
        if (audioRecordContext == null) {
            LogUtil.log(f35305a, "filterExpiredRecord cancel.(mContext is empty)");
            return;
        }
        LogUtil.log(f35305a, "filterExpiredRecord businessId = ", audioRecordContext.getBusinessId());
        ArrayList arrayList = new ArrayList();
        for (RecordResult next : list) {
            if (m25008d(next) && m25007c(next)) {
                arrayList.add(next);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            RecordResult recordResult = (RecordResult) arrayList.get(i);
            list.remove(recordResult);
            m25005b(recordResult);
        }
    }

    /* renamed from: c */
    private boolean m25007c(RecordResult recordResult) {
        return System.currentTimeMillis() - recordResult.getStartRecordTime() >= this.f35311g;
    }

    /* renamed from: d */
    private boolean m25008d(RecordResult recordResult) {
        return TextUtils.equals(recordResult.getBusinessId(), this.f35309e.getBusinessId()) && (recordResult.getClientType() == this.f35309e.getClientType());
    }

    /* renamed from: a */
    private void m25000a(LoadCallback loadCallback) {
        synchronized (this.f35306b) {
            TreeSet<LoadCallback> treeSet = this.f35306b;
            if (loadCallback == null) {
                loadCallback = new EmptyLoadCallback();
            }
            treeSet.add(loadCallback);
        }
    }

    /* renamed from: a */
    private synchronized boolean m25002a() {
        return !this.f35306b.isEmpty();
    }

    static abstract class AbstractLoadCallback implements LoadCallback {
        static final int PRIORITY_HIGH = 2;
        static final int PRIORITY_MIN = 0;
        static final int PRIORITY_NORMAL = 1;

        AbstractLoadCallback() {
        }

        public int compareTo(LoadCallback loadCallback) {
            return getPriority() > loadCallback.getPriority() ? 1 : -1;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof LoadCallback) && compareTo((LoadCallback) obj) == 0;
        }
    }

    class EmptyLoadCallback extends AbstractLoadCallback {
        public int getPriority() {
            return 0;
        }

        public void onLoadFinish(List<RecordResult> list) {
        }

        EmptyLoadCallback() {
        }

        public int hashCode() {
            return getPriority();
        }
    }

    abstract class FilterExpiredCacheCallback extends AbstractLoadCallback {
        public int getPriority() {
            return 2;
        }

        FilterExpiredCacheCallback() {
        }

        public int hashCode() {
            return getPriority();
        }
    }

    public static abstract class CustomLoadCallback extends AbstractLoadCallback {
        public int getPriority() {
            return 1;
        }

        public /* bridge */ /* synthetic */ int compareTo(LoadCallback loadCallback) {
            return super.compareTo(loadCallback);
        }

        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return super.equals(obj);
        }

        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }
    }
}
