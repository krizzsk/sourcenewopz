package com.didi.sdk.audiorecorder;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.audiorecorder.helper.AudioCacheManager;
import com.didi.sdk.audiorecorder.helper.AudioUploader;
import com.didi.sdk.audiorecorder.helper.AudioUploaderImpl;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.model.RecordResult;
import com.didi.sdk.audiorecorder.service.IRecordServiceConnection;
import com.didi.sdk.audiorecorder.service.RecordServiceConnectionFactory;
import com.didi.sdk.audiorecorder.speechdetect.SensitiveWordsUploadWrapper;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class RecordLifecycleHandler implements AudioRecorder {

    /* renamed from: a */
    private static final String f35282a = "RecordLifecycleHandler -> ";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final IRecordServiceConnection f35283b = RecordServiceConnectionFactory.create();

    /* renamed from: c */
    private final InternalUploadListener f35284c = new InternalUploadListener();

    /* renamed from: d */
    private final InternalFileSliceListener f35285d = new InternalFileSliceListener();

    /* renamed from: e */
    private final Internal16kPcmDispatcher f35286e = new Internal16kPcmDispatcher();

    /* renamed from: f */
    private SensitiveWordsUploadWrapper f35287f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f35288g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AudioRecordContext f35289h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AudioCacheManager f35290i;

    /* renamed from: j */
    private AudioUploader f35291j;

    /* renamed from: k */
    private Map<String, AudioRecordContext> f35292k;

    RecordLifecycleHandler(Map<String, AudioRecordContext> map) {
        this.f35292k = map;
    }

    /* renamed from: a */
    public void mo90971a(String str, AudioRecordContext audioRecordContext) {
        this.f35288g = str;
        this.f35289h = audioRecordContext;
        Context appContext = audioRecordContext.getAppContext();
        if (this.f35290i == null) {
            this.f35290i = new AudioCacheManager(appContext);
        }
        this.f35290i.update(audioRecordContext);
        AudioUploader audioUploader = this.f35291j;
        if (audioUploader == null) {
            AudioUploaderImpl audioUploaderImpl = new AudioUploaderImpl(this.f35292k, this.f35288g, new AudioUploaderImpl.RecordResultRefresher() {
                public void refresh(RecordResult recordResult) {
                    RecordLifecycleHandler.this.f35290i.saveRecord(recordResult);
                }
            });
            this.f35291j = audioUploaderImpl;
            audioUploaderImpl.setUploadListener(this.f35284c);
        } else {
            audioUploader.update(this.f35288g);
        }
        this.f35284c.update(audioRecordContext);
        if (this.f35287f == null) {
            this.f35287f = new SensitiveWordsUploadWrapper(audioRecordContext);
        }
        this.f35283b.updateRecordContext(str, audioRecordContext);
        this.f35283b.setFileSliceListener(this.f35285d);
        this.f35283b.setSpeechDetectListener(this.f35287f);
    }

    public void startRecord() {
        this.f35283b.startRecord();
    }

    public void stopRecord() {
        this.f35283b.stopRecord();
    }

    public void resumeRecord() {
        this.f35283b.resumeRecord();
    }

    public void pauseRecord() {
        this.f35283b.pauseRecord();
    }

    public boolean isRecording() {
        return this.f35283b.isRecording();
    }

    /* renamed from: a */
    public void mo90972a(JSONObject jSONObject) {
        this.f35283b.updateSpeechDetectParams(jSONObject.toString());
    }

    /* renamed from: a */
    public void mo90966a() {
        this.f35283b.sliceAudioFile();
    }

    public void setRecordListener(AudioRecorder.RecordListener recordListener) {
        this.f35283b.setRecordStateListener(recordListener);
    }

    public void setOnErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        this.f35283b.setRecordErrorListener(onErrorListener);
    }

    /* renamed from: a */
    public void mo90967a(AudioUploader.UploadListener uploadListener) {
        this.f35284c.setExtraUploadListener(uploadListener);
    }

    /* renamed from: a */
    public void mo90968a(AudioRecorder.DurationChangedListener durationChangedListener) {
        this.f35283b.setRecordDurationListener(durationChangedListener);
    }

    /* renamed from: a */
    public void mo90969a(AudioRecorder.FileSliceListener fileSliceListener) {
        this.f35285d.setListener(fileSliceListener);
    }

    /* renamed from: b */
    public void mo90973b() {
        this.f35290i.loadAllRecord(new AudioCacheManager.CustomLoadCallback() {
            public void onLoadFinish(List<RecordResult> list) {
                LogUtil.log(RecordLifecycleHandler.f35282a, "resumeUploadTasks -> onLoadFinish");
                if (list != null && !list.isEmpty()) {
                    Iterator it = new ArrayList(list).iterator();
                    while (it.hasNext()) {
                        RecordResult recordResult = (RecordResult) it.next();
                        LogUtil.log(RecordLifecycleHandler.f35282a, "resumeUploadTasks onLoadFinish: upload: " + recordResult.getStartRecordTime());
                        RecordLifecycleHandler.this.m24975a(recordResult);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24975a(RecordResult recordResult) {
        if (!recordResult.equals(this.f35285d.mCurrRecord)) {
            this.f35291j.upload(recordResult);
        }
    }

    /* renamed from: c */
    public void mo90975c() {
        this.f35283b.clearTtsDataCache();
    }

    /* renamed from: a */
    public void mo90970a(Supporter.Pcm16kConsumer pcm16kConsumer) {
        this.f35286e.register16kPcmConsumer(pcm16kConsumer);
    }

    /* renamed from: b */
    public void mo90974b(Supporter.Pcm16kConsumer pcm16kConsumer) {
        this.f35286e.unregister16kPcmConsumer(pcm16kConsumer);
    }

    private class InternalUploadListener implements AudioUploader.UploadListener {
        private AudioUploader.UploadListener mExtraUploadListener;
        private int mMaxRetryCount;
        private AudioRecordContext mRecordContext;

        private InternalUploadListener() {
        }

        /* access modifiers changed from: package-private */
        public void setExtraUploadListener(AudioUploader.UploadListener uploadListener) {
            this.mExtraUploadListener = uploadListener;
        }

        /* access modifiers changed from: package-private */
        public void update(AudioRecordContext audioRecordContext) {
            this.mRecordContext = audioRecordContext;
            int maxUploadRetryCount = audioRecordContext.getMaxUploadRetryCount() > 0 ? audioRecordContext.getMaxUploadRetryCount() : 10;
            this.mMaxRetryCount = maxUploadRetryCount;
            LogUtil.log("Internal update: newMaxRetryCount = ", String.valueOf(maxUploadRetryCount));
        }

        public void onSuccess(RecordResult recordResult) {
            LogUtil.log(RecordLifecycleHandler.f35282a, "succeed in upload audio: " + recordResult);
            recordResult.setUploadRetryCount(recordResult.getUploadRetryCount() + 1);
            RecordLifecycleHandler.this.f35290i.removeRecord(recordResult);
            AudioUploader.UploadListener uploadListener = this.mExtraUploadListener;
            if (uploadListener != null) {
                uploadListener.onSuccess(recordResult);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:44:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFail(com.didi.sdk.audiorecorder.model.RecordResult r9, int r10, java.lang.Throwable r11) {
            /*
                r8 = this;
                int r0 = r9.getUploadRetryCount()
                r1 = 1
                int r0 = r0 + r1
                r9.setUploadRetryCount(r0)
                r0 = 0
                r2 = 100
                if (r10 <= r2) goto L_0x0010
                r2 = 1
                goto L_0x0011
            L_0x0010:
                r2 = 0
            L_0x0011:
                if (r2 == 0) goto L_0x0015
                int r10 = r10 + -100
            L_0x0015:
                r3 = 7
                java.lang.String[] r4 = new java.lang.String[r3]
                java.lang.String r5 = "RecordLifecycleHandler -> "
                r4[r0] = r5
                java.lang.String r0 = "failed to upload audio: "
                r4[r1] = r0
                r0 = 2
                java.lang.String r6 = r9.toString()
                r4[r0] = r6
                r0 = 3
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = ", isServerErr = "
                r6.append(r7)
                r6.append(r2)
                java.lang.String r2 = r6.toString()
                r4[r0] = r2
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = ", errCode = "
                r0.append(r2)
                r0.append(r10)
                java.lang.String r0 = r0.toString()
                r2 = 4
                r4[r2] = r0
                java.lang.String r0 = ", exception = "
                r6 = 5
                r4[r6] = r0
                r0 = 6
                if (r11 != 0) goto L_0x005a
                java.lang.String r7 = "null"
                goto L_0x005e
            L_0x005a:
                java.lang.String r7 = r11.toString()
            L_0x005e:
                r4[r0] = r7
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r4)
                if (r10 == r1) goto L_0x00cf
                r0 = 15
                if (r10 == r0) goto L_0x00cf
                r0 = 580002(0x8d9a2, float:8.12756E-40)
                r1 = 580000(0x8d9a0, float:8.12753E-40)
                if (r10 == r1) goto L_0x0093
                if (r10 == r0) goto L_0x0093
                if (r10 == r2) goto L_0x00cf
                if (r10 == r6) goto L_0x00cf
                if (r10 == r3) goto L_0x0093
                r2 = 8
                if (r10 == r2) goto L_0x0093
                r0 = 9
                if (r10 == r0) goto L_0x00cf
                r0 = 17
                if (r10 == r0) goto L_0x00cf
                r0 = 18
                if (r10 == r0) goto L_0x00cf
                com.didi.sdk.audiorecorder.RecordLifecycleHandler r0 = com.didi.sdk.audiorecorder.RecordLifecycleHandler.this
                com.didi.sdk.audiorecorder.helper.AudioCacheManager r0 = r0.f35290i
                r0.removeRecord((com.didi.sdk.audiorecorder.model.RecordResult) r9)
                goto L_0x00d8
            L_0x0093:
                int r2 = r9.getUploadRetryCount()
                int r3 = r8.mMaxRetryCount
                if (r2 > r3) goto L_0x00c5
                if (r1 == r10) goto L_0x009f
                if (r0 != r10) goto L_0x00ac
            L_0x009f:
                boolean r0 = r8.refreshUserToken(r9)
                if (r0 != 0) goto L_0x00b6
                boolean r0 = r8.refreshBusinessId(r9)
                if (r0 == 0) goto L_0x00ac
                goto L_0x00b6
            L_0x00ac:
                com.didi.sdk.audiorecorder.RecordLifecycleHandler r0 = com.didi.sdk.audiorecorder.RecordLifecycleHandler.this
                com.didi.sdk.audiorecorder.helper.AudioCacheManager r0 = r0.f35290i
                r0.saveRecord(r9)
                goto L_0x00d8
            L_0x00b6:
                java.lang.String r10 = "token or bizId refreshed."
                java.lang.String[] r10 = new java.lang.String[]{r5, r10}
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r10)
                com.didi.sdk.audiorecorder.RecordLifecycleHandler r10 = com.didi.sdk.audiorecorder.RecordLifecycleHandler.this
                r10.m24975a((com.didi.sdk.audiorecorder.model.RecordResult) r9)
                return
            L_0x00c5:
                com.didi.sdk.audiorecorder.RecordLifecycleHandler r0 = com.didi.sdk.audiorecorder.RecordLifecycleHandler.this
                com.didi.sdk.audiorecorder.helper.AudioCacheManager r0 = r0.f35290i
                r0.removeRecord((com.didi.sdk.audiorecorder.model.RecordResult) r9)
                goto L_0x00d8
            L_0x00cf:
                com.didi.sdk.audiorecorder.RecordLifecycleHandler r0 = com.didi.sdk.audiorecorder.RecordLifecycleHandler.this
                com.didi.sdk.audiorecorder.helper.AudioCacheManager r0 = r0.f35290i
                r0.saveRecord(r9)
            L_0x00d8:
                com.didi.sdk.audiorecorder.helper.AudioUploader$UploadListener r0 = r8.mExtraUploadListener
                if (r0 == 0) goto L_0x00df
                r0.onFail(r9, r10, r11)
            L_0x00df:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.RecordLifecycleHandler.InternalUploadListener.onFail(com.didi.sdk.audiorecorder.model.RecordResult, int, java.lang.Throwable):void");
        }

        private boolean refreshBusinessId(RecordResult recordResult) {
            if (TextUtils.isEmpty(this.mRecordContext.getUserId()) || !TextUtils.equals(recordResult.getUserId(), this.mRecordContext.getUserId()) || TextUtils.isEmpty(this.mRecordContext.getBusinessId()) || TextUtils.equals(recordResult.getBusinessId(), this.mRecordContext.getBusinessId())) {
                return false;
            }
            recordResult.setBusinessId(this.mRecordContext.getBusinessId());
            return true;
        }

        private boolean refreshUserToken(RecordResult recordResult) {
            if (TextUtils.isEmpty(recordResult.getUserId()) || !TextUtils.equals(recordResult.getUserId(), this.mRecordContext.getUserId()) || TextUtils.isEmpty(this.mRecordContext.getUserToken()) || TextUtils.equals(recordResult.getToken(), this.mRecordContext.getUserToken())) {
                return false;
            }
            recordResult.setToken(this.mRecordContext.getUserToken());
            return true;
        }
    }

    private class InternalFileSliceListener implements AudioRecorder.FileSliceListener {
        /* access modifiers changed from: private */
        public RecordResult mCurrRecord;
        private AudioRecorder.FileSliceListener mListener;

        private InternalFileSliceListener() {
        }

        public void setListener(AudioRecorder.FileSliceListener fileSliceListener) {
            this.mListener = fileSliceListener;
        }

        public void onAudioFileCreated(String str) {
            LogUtil.log(RecordLifecycleHandler.f35282a, "onAudioFileCreated " + str);
            RecordResult createRecord = createRecord(str);
            this.mCurrRecord = createRecord;
            cacheRecord(createRecord);
            AudioRecorder.FileSliceListener fileSliceListener = this.mListener;
            if (fileSliceListener != null) {
                fileSliceListener.onAudioFileCreated(str);
            }
        }

        private RecordResult createRecord(String str) {
            RecordResult recordResult = new RecordResult();
            AudioRecordContext b = RecordLifecycleHandler.this.f35289h;
            recordResult.setCaller(b.getCaller());
            recordResult.setBusinessId(b.getBusinessId());
            recordResult.setBusinessAlias(RecordLifecycleHandler.this.f35288g);
            recordResult.setToken(b.getUserToken());
            recordResult.setOrderIds(b.getOrderIds());
            recordResult.setStartRecordTime(new File(str).lastModified());
            recordResult.setAudioFilePath(str);
            recordResult.setClientType(b.getClientType());
            recordResult.setLanguage(b.getLanguage());
            recordResult.setUtcOffsetInMinutes(b.getUtcOffsetInMinutes());
            recordResult.setExtraJson(b.getExtraJson());
            recordResult.setUploadUrl(b.getUploadUrl());
            recordResult.setUserId(b.getUserId());
            return recordResult;
        }

        private void cacheRecord(RecordResult recordResult) {
            RecordLifecycleHandler.this.f35290i.saveRecord(recordResult);
        }

        public void onAudioFileSliced(String str) {
            LogUtil.log(RecordLifecycleHandler.f35282a, "onAudioFileSliced " + str);
            AudioRecorder.FileSliceListener fileSliceListener = this.mListener;
            if (fileSliceListener != null) {
                fileSliceListener.onAudioFileSliced(str);
            }
            uploadAudioInternal();
        }

        private synchronized void uploadAudioInternal() {
            RecordResult recordResult = this.mCurrRecord;
            if (recordResult != null) {
                this.mCurrRecord = null;
                updateRecord(recordResult);
                cacheRecord(recordResult);
                RecordLifecycleHandler.this.m24975a(recordResult);
            }
        }

        private void updateRecord(RecordResult recordResult) {
            File file = new File(recordResult.getAudioFilePath());
            recordResult.setFileSizeInBytes(file.length());
            recordResult.setFinishRecordTime(file.lastModified());
        }
    }

    private class Internal16kPcmDispatcher implements Supporter.Pcm16kConsumer {
        private final Set<Supporter.Pcm16kConsumer> PCM16K_CONSUMERS;

        public void setPcm16kProvider(Supporter.Pcm16kProvider pcm16kProvider) {
        }

        private Internal16kPcmDispatcher() {
            this.PCM16K_CONSUMERS = Collections.newSetFromMap(new ConcurrentHashMap());
        }

        /* access modifiers changed from: package-private */
        public void register16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
            this.PCM16K_CONSUMERS.add(pcm16kConsumer);
            if (this.PCM16K_CONSUMERS.size() > 0) {
                RecordLifecycleHandler.this.f35283b.set16kPcmConsumer(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void unregister16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
            this.PCM16K_CONSUMERS.remove(pcm16kConsumer);
            if (this.PCM16K_CONSUMERS.size() == 0) {
                RecordLifecycleHandler.this.f35283b.set16kPcmConsumer((Supporter.Pcm16kConsumer) null);
            }
        }

        public void onPcm16kFeed(byte[] bArr, int i) {
            for (Supporter.Pcm16kConsumer onPcm16kFeed : this.PCM16K_CONSUMERS) {
                onPcm16kFeed.onPcm16kFeed(bArr, i);
            }
        }
    }
}
