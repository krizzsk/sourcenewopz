package com.didi.sdk.audiorecorder.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.AudioUploader;
import com.didi.sdk.audiorecorder.model.RecordResult;
import com.didi.sdk.audiorecorder.model.UploadResponse;
import com.didi.sdk.audiorecorder.net.UploadAudioService;
import com.didi.sdk.audiorecorder.net.UploadService;
import com.didi.sdk.audiorecorder.utils.FileEncryption;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.util.AlgorithmUtil;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class AudioUploaderImpl implements AudioUploader {

    /* renamed from: a */
    private static final String f35312a = "AudioUploaderImpl -> ";

    /* renamed from: b */
    private static final Handler f35313b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private ExecutorService f35314c = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-audio-uploader");
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Map<String, AudioRecordContext> f35315d;

    /* renamed from: e */
    private final Map<String, UploadAudioService> f35316e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AudioUploader.UploadListener f35317f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f35318g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RecordResultRefresher f35319h;

    public interface RecordResultRefresher {
        void refresh(RecordResult recordResult);
    }

    public AudioUploaderImpl(Map<String, AudioRecordContext> map, String str, RecordResultRefresher recordResultRefresher) {
        this.f35315d = map;
        this.f35318g = str;
        this.f35319h = recordResultRefresher;
        this.f35316e = new HashMap(3);
    }

    public void update(String str) {
        this.f35318g = str;
    }

    public void setUploadListener(AudioUploader.UploadListener uploadListener) {
        this.f35317f = uploadListener;
    }

    public void upload(RecordResult recordResult) {
        this.f35314c.execute(new UploadTask(recordResult));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized UploadAudioService m25010a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String md5 = AlgorithmUtil.md5(str);
        UploadAudioService uploadAudioService = this.f35316e.get(md5);
        if (uploadAudioService == null) {
            try {
                UploadAudioService uploadAudioService2 = (UploadAudioService) new RpcServiceFactory(context).newRpcService(UploadAudioService.class, str);
                try {
                    this.f35316e.put(md5, uploadAudioService2);
                    uploadAudioService = uploadAudioService2;
                } catch (Exception e) {
                    e = e;
                    uploadAudioService = uploadAudioService2;
                    LogUtil.log("AudioUploaderImpl -> Failed to create uploadService for url: " + str, e);
                    return uploadAudioService;
                }
            } catch (Exception e2) {
                e = e2;
                LogUtil.log("AudioUploaderImpl -> Failed to create uploadService for url: " + str, e);
                return uploadAudioService;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25019a(final RecordResult recordResult, final int i, final Throwable th) {
        if (this.f35317f != null) {
            f35313b.post(new Runnable() {
                public void run() {
                    if (AudioUploaderImpl.this.f35317f != null) {
                        AudioUploaderImpl.this.f35317f.onFail(recordResult, i, th);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25022a(UploadAudioService uploadAudioService, RecordResult recordResult, File file, String str, String str2, String str3) {
        UploadAudioService uploadAudioService2 = uploadAudioService;
        String token = recordResult.getToken();
        String orderIds = recordResult.getOrderIds();
        int utcOffsetInMinutes = recordResult.getUtcOffsetInMinutes();
        long fileSizeInBytes = recordResult.getFileSizeInBytes();
        long voiceLenInSeconds = recordResult.getVoiceLenInSeconds();
        long startRecordTime = recordResult.getStartRecordTime();
        long finishRecordTime = recordResult.getFinishRecordTime();
        String caller = recordResult.getCaller();
        String businessId = recordResult.getBusinessId();
        String extraJson = recordResult.getExtraJson();
        C120643 r19 = r0;
        String str4 = orderIds;
        final RecordResult recordResult2 = recordResult;
        C120643 r0 = new RpcService.Callback<UploadResponse>() {
            public void onSuccess(UploadResponse uploadResponse) {
                AudioUploaderImpl.this.m25021a(uploadResponse, recordResult2);
            }

            public void onFailure(IOException iOException) {
                AudioUploaderImpl.this.m25020a(recordResult2, iOException);
            }
        };
        uploadAudioService.driverUpload(token, str4, utcOffsetInMinutes, file, fileSizeInBytes, voiceLenInSeconds, startRecordTime, finishRecordTime, str, str2, caller, businessId, extraJson, str3, r19);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25023a(UploadService uploadService, final RecordResult recordResult, File file, String str, String str2, String str3) {
        String a = m25012a(str3);
        String uploadUrl = recordResult.getUploadUrl();
        StringBuilder sb = new StringBuilder(uploadUrl);
        String str4 = "?";
        if (uploadUrl.lastIndexOf(str4) != -1) {
            str4 = ParamKeys.SIGN_AND;
        }
        sb.append(str4);
        sb.append("ticket");
        sb.append("=");
        sb.append(recordResult.getToken());
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.OIDS);
        sb.append("=");
        sb.append(recordResult.getOrderIds());
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.FILE_SIZE);
        sb.append("=");
        sb.append(recordResult.getFileSizeInBytes());
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.VOICE_LENGTH);
        sb.append("=");
        sb.append(recordResult.getVoiceLenInSeconds());
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.START_TIMESTAMP);
        sb.append("=");
        sb.append(recordResult.getStartRecordTime());
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.END_TIMESTAMP);
        sb.append("=");
        sb.append(recordResult.getFinishRecordTime());
        sb.append(ParamKeys.SIGN_AND);
        sb.append("start_time");
        sb.append("=");
        sb.append(str);
        sb.append(ParamKeys.SIGN_AND);
        sb.append("end_time");
        sb.append("=");
        sb.append(str2);
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.ENCRYPT_KEY);
        sb.append("=");
        sb.append(a);
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap(5);
        hashMap.put(AudioUploader.REQ_PARAMS.VOICE_FILE, file);
        hashMap.put("caller", recordResult.getCaller());
        hashMap.put("business_id", recordResult.getBusinessId());
        hashMap.put("extra_info", recordResult.getExtraJson());
        uploadService.post(sb2, hashMap, new UploadService.Callback() {
            public void onSuccess(UploadResponse uploadResponse) {
                AudioUploaderImpl.this.m25021a(uploadResponse, recordResult);
            }

            public void onFailed() {
                AudioUploaderImpl.this.m25020a(recordResult, (IOException) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25027b(UploadAudioService uploadAudioService, RecordResult recordResult, File file, String str, String str2, String str3) {
        UploadAudioService uploadAudioService2 = uploadAudioService;
        String token = recordResult.getToken();
        String orderIds = recordResult.getOrderIds();
        int utcOffsetInMinutes = recordResult.getUtcOffsetInMinutes();
        long fileSizeInBytes = recordResult.getFileSizeInBytes();
        long voiceLenInSeconds = recordResult.getVoiceLenInSeconds();
        long startRecordTime = recordResult.getStartRecordTime();
        long finishRecordTime = recordResult.getFinishRecordTime();
        String language = recordResult.getLanguage();
        String caller = recordResult.getCaller();
        String businessId = recordResult.getBusinessId();
        String extraJson = recordResult.getExtraJson();
        C120665 r20 = r0;
        String str4 = orderIds;
        final RecordResult recordResult2 = recordResult;
        C120665 r0 = new RpcService.Callback<UploadResponse>() {
            public void onSuccess(UploadResponse uploadResponse) {
                AudioUploaderImpl.this.m25021a(uploadResponse, recordResult2);
            }

            public void onFailure(IOException iOException) {
                AudioUploaderImpl.this.m25020a(recordResult2, iOException);
            }
        };
        uploadAudioService.passengerUpload(token, str4, utcOffsetInMinutes, file, fileSizeInBytes, voiceLenInSeconds, startRecordTime, finishRecordTime, str, str2, language, caller, businessId, extraJson, str3, r20);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25028b(UploadService uploadService, final RecordResult recordResult, File file, String str, String str2, String str3) {
        String a = m25012a(str3);
        String uploadUrl = recordResult.getUploadUrl();
        StringBuilder sb = new StringBuilder(uploadUrl);
        String str4 = "?";
        if (uploadUrl.lastIndexOf(str4) != -1) {
            str4 = ParamKeys.SIGN_AND;
        }
        sb.append(str4);
        sb.append("token");
        sb.append("=");
        sb.append(recordResult.getToken());
        sb.append(ParamKeys.SIGN_AND);
        sb.append("oid");
        sb.append("=");
        sb.append(recordResult.getOrderIds());
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.FILE_SIZE);
        sb.append("=");
        sb.append(recordResult.getFileSizeInBytes());
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.VOICE_LENGTH);
        sb.append("=");
        sb.append(recordResult.getVoiceLenInSeconds());
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.START_TIMESTAMP);
        sb.append("=");
        sb.append(recordResult.getStartRecordTime());
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.END_TIMESTAMP);
        sb.append("=");
        sb.append(recordResult.getFinishRecordTime());
        sb.append(ParamKeys.SIGN_AND);
        sb.append("start_time");
        sb.append("=");
        sb.append(str);
        sb.append(ParamKeys.SIGN_AND);
        sb.append("end_time");
        sb.append("=");
        sb.append(str2);
        sb.append(ParamKeys.SIGN_AND);
        sb.append(AudioUploader.REQ_PARAMS.ENCRYPT_KEY);
        sb.append("=");
        sb.append(a);
        sb.append(ParamKeys.SIGN_AND);
        sb.append("lang");
        sb.append("=");
        sb.append(recordResult.getLanguage());
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap(5);
        hashMap.put(AudioUploader.REQ_PARAMS.VOICE_FILE, file);
        hashMap.put("caller", recordResult.getCaller());
        hashMap.put("business_id", recordResult.getBusinessId());
        hashMap.put("extra_info", recordResult.getExtraJson());
        uploadService.post(sb2, hashMap, new UploadService.Callback() {
            public void onSuccess(UploadResponse uploadResponse) {
                AudioUploaderImpl.this.m25021a(uploadResponse, recordResult);
            }

            public void onFailed() {
                AudioUploaderImpl.this.m25020a(recordResult, (IOException) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25021a(UploadResponse uploadResponse, RecordResult recordResult) {
        if (uploadResponse == null) {
            m25019a(recordResult, 7, (Throwable) null);
        } else if (uploadResponse.errno != 0) {
            m25019a(recordResult, uploadResponse.errno + 100, (Throwable) null);
        } else {
            m25018a(recordResult);
        }
    }

    /* renamed from: a */
    private void m25018a(final RecordResult recordResult) {
        if (this.f35317f != null) {
            f35313b.post(new Runnable() {
                public void run() {
                    if (AudioUploaderImpl.this.f35317f != null) {
                        AudioUploaderImpl.this.f35317f.onSuccess(recordResult);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25020a(RecordResult recordResult, IOException iOException) {
        m25019a(recordResult, 8, (Throwable) iOException);
    }

    /* renamed from: a */
    private static String m25012a(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LogUtil.log("AudioUploaderImpl -> Failed to urlEncode audio upload params. val = " + str, e);
            return str;
        }
    }

    private class UploadTask implements Runnable {
        private static final int AMR_HEADER_LENGTH = 6;
        private static final int MAX_CREATE_AES_KEY_RETRY_COUNT = 1;
        private static final int MAX_ENCRYPT_AES_KEY_RETRY_COUNT = 1;
        private static final int MAX_ENCRYPT_FILE_RETRY_COUNT = 1;
        private static final int MAX_TEMP_FILE_RENAME_RETRY_COUNT = 1;
        private RecordResult mRecord;

        UploadTask(RecordResult recordResult) {
            this.mRecord = recordResult;
        }

        /* JADX WARNING: Removed duplicated region for block: B:119:0x0342  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r18 = this;
                r7 = r18
                com.didi.sdk.audiorecorder.model.RecordResult r15 = r7.mRecord
                java.lang.String r0 = r15.getBusinessAlias()
                boolean r0 = com.didi.sdk.audiorecorder.utils.TextUtil.isEmpty(r0)
                if (r0 != 0) goto L_0x0013
                java.lang.String r0 = r15.getBusinessAlias()
                goto L_0x0019
            L_0x0013:
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                java.lang.String r0 = r0.f35318g
            L_0x0019:
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r1 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                java.util.Map r1 = r1.f35315d
                java.lang.Object r1 = r1.get(r0)
                r8 = r1
                com.didi.sdk.audiorecorder.AudioRecordContext r8 = (com.didi.sdk.audiorecorder.AudioRecordContext) r8
                if (r8 != 0) goto L_0x0046
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r1 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r2 = 20
                java.lang.IllegalAccessException r3 = new java.lang.IllegalAccessException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Failed to load record context, which's alias is "
                r4.append(r5)
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r3.<init>(r0)
                r1.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r2, (java.lang.Throwable) r3)
                return
            L_0x0046:
                r15.resolveIfNeed()
                java.lang.String r0 = r15.getUploadUrl()
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                r9 = 0
                if (r0 == 0) goto L_0x0070
                if (r8 == 0) goto L_0x0069
                java.lang.String r0 = r8.getUploadUrl()
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x0061
                goto L_0x0069
            L_0x0061:
                java.lang.String r0 = r8.getUploadUrl()
                r15.setUploadUrl(r0)
                goto L_0x0070
            L_0x0069:
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r1 = 4
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r1, (java.lang.Throwable) r9)
                return
            L_0x0070:
                long r0 = r15.getVoiceLenInSeconds()
                r2 = 6
                r10 = 0
                int r4 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
                if (r4 != 0) goto L_0x008c
                long r0 = r15.getFileSizeInBytes()
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 > 0) goto L_0x008c
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r1 = 11
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r1, (java.lang.Throwable) r9)
                return
            L_0x008c:
                boolean r0 = r15.isTooShort()
                if (r0 == 0) goto L_0x0099
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r1 = 6
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r1, (java.lang.Throwable) r9)
                return
            L_0x0099:
                java.io.File r0 = new java.io.File
                java.lang.String r1 = r15.getAudioFilePath()
                r0.<init>(r1)
                java.io.File r12 = new java.io.File
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = r15.getAudioFilePath()
                r1.append(r4)
                java.lang.String r4 = "_encrypt"
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r12.<init>(r1)
                boolean r1 = r12.exists()
                r13 = 3
                r14 = 2
                java.lang.String r6 = "AudioUploaderImpl -> "
                r5 = 0
                r4 = 1
                if (r1 == 0) goto L_0x00d6
                long r16 = r12.length()
                int r1 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
                if (r1 > 0) goto L_0x00d1
                goto L_0x00d6
            L_0x00d1:
                r11 = r6
                r17 = 0
                goto L_0x01aa
            L_0x00d6:
                java.lang.String r1 = "encryptFile didn't exist, start encrypt..."
                java.lang.String[] r1 = new java.lang.String[]{r6, r1}
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r1)
                boolean r1 = r0.exists()
                if (r1 != 0) goto L_0x00eb
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r14, (java.lang.Throwable) r9)
                return
            L_0x00eb:
                long r16 = r0.length()
                int r1 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
                if (r1 > 0) goto L_0x00f9
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r13, (java.lang.Throwable) r9)
                return
            L_0x00f9:
                com.didi.sdk.audiorecorder.utils.FileEncryption r2 = r18.createAesFileEncryption()
                if (r2 != 0) goto L_0x0107
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r1 = 19
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r1, (java.lang.Throwable) r9)
                return
            L_0x0107:
                byte[] r1 = r7.createAesKey(r2, r5, r4)
                if (r1 != 0) goto L_0x0115
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r1 = 17
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r1, (java.lang.Throwable) r9)
                return
            L_0x0115:
                java.lang.String r3 = r7.encryptAesKey(r1, r5, r4)
                if (r3 != 0) goto L_0x0123
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r1 = 18
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r1, (java.lang.Throwable) r9)
                return
            L_0x0123:
                java.lang.String r1 = r0.getAbsolutePath()
                java.io.File r16 = r7.generateEncryptTmpFile(r1)
                java.lang.String[] r1 = new java.lang.String[r14]
                r1[r5] = r6
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r13 = "generateEncryptTmpFile: "
                r5.append(r13)
                java.lang.String r13 = r16.getName()
                r5.append(r13)
                java.lang.String r5 = r5.toString()
                r1[r4] = r5
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r1)
                r5 = 0
                r13 = 1
                r1 = r18
                r10 = r3
                r3 = r0
                r11 = 1
                r4 = r16
                r17 = 0
                r11 = r6
                r6 = r13
                boolean r1 = r1.encryptFile(r2, r3, r4, r5, r6)
                if (r1 != 0) goto L_0x0164
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r1 = 10
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r1, (java.lang.Throwable) r9)
                return
            L_0x0164:
                r5 = 0
                r6 = 1
                r1 = r18
                r2 = r0
                r3 = r12
                r4 = r16
                boolean r0 = r1.renameEncryptTempFile(r2, r3, r4, r5, r6)
                java.lang.String[] r1 = new java.lang.String[r14]
                r1[r17] = r11
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "rename encryptTempFile result: "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r3 = 1
                r1[r3] = r2
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r1)
                if (r0 != 0) goto L_0x0195
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r1 = 15
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r1, (java.lang.Throwable) r9)
                return
            L_0x0195:
                r15.setSignKey(r10)
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl$RecordResultRefresher r0 = r0.f35319h
                r0.refresh(r15)
                java.lang.String r0 = "encrypt finish."
                java.lang.String[] r0 = new java.lang.String[]{r11, r0}
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r0)
            L_0x01aa:
                boolean r0 = r12.exists()
                if (r0 != 0) goto L_0x01b3
                r5 = 12
                goto L_0x01db
            L_0x01b3:
                long r0 = r12.length()
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 != 0) goto L_0x01c0
                r5 = 13
                goto L_0x01db
            L_0x01c0:
                java.lang.String r0 = r15.getSignKey()
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x01cd
                r5 = 16
                goto L_0x01db
            L_0x01cd:
                android.content.Context r0 = r8.getAppContext()
                boolean r0 = com.didichuxing.foundation.util.NetworkUtil.isConnected(r0)
                if (r0 != 0) goto L_0x01da
                r5 = 9
                goto L_0x01db
            L_0x01da:
                r5 = 0
            L_0x01db:
                if (r5 <= 0) goto L_0x01e3
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r0 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                r0.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r5, (java.lang.Throwable) r9)
                return
            L_0x01e3:
                int r0 = r8.getClientType()
                int r1 = r15.getClientType()
                if (r0 != r1) goto L_0x0202
                java.lang.String r0 = r8.getUserId()
                java.lang.String r1 = r15.getUserId()
                boolean r0 = android.text.TextUtils.equals(r0, r1)
                if (r0 == 0) goto L_0x0202
                java.lang.String r0 = r8.getUserToken()
                r15.setToken(r0)
            L_0x0202:
                java.text.SimpleDateFormat r0 = com.didi.sdk.audiorecorder.helper.AudioUploader.DATE_FORMATTER
                long r1 = r15.getStartRecordTime()
                java.lang.Long r1 = java.lang.Long.valueOf(r1)
                java.lang.String r0 = r0.format(r1)
                java.text.SimpleDateFormat r1 = com.didi.sdk.audiorecorder.helper.AudioUploader.DATE_FORMATTER
                long r2 = r15.getFinishRecordTime()
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                java.lang.String r13 = r1.format(r2)
                r1 = 3
                java.lang.String[] r1 = new java.lang.String[r1]
                r1[r17] = r11
                java.lang.String r2 = "start upload audio: "
                r3 = 1
                r1[r3] = r2
                java.lang.String r2 = r15.toString()
                r1[r14] = r2
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r1)
                com.didi.sdk.audiorecorder.net.UploadService r9 = r8.getUploadService()
                java.lang.Class r1 = r8.getClass()
                java.lang.Class<com.didichuxing.foundation.spi.annotation.ServiceProvider> r2 = com.didichuxing.foundation.spi.annotation.ServiceProvider.class
                java.lang.annotation.Annotation r1 = r1.getAnnotation(r2)
                com.didichuxing.foundation.spi.annotation.ServiceProvider r1 = (com.didichuxing.foundation.spi.annotation.ServiceProvider) r1
                java.lang.String r1 = r1.alias()
                int r2 = r8.getClientType()
                java.lang.String r3 = r8.getBusinessId()
                java.lang.String r4 = r8.getCaller()
                java.lang.String r6 = r8.getUserId()
                java.lang.String r10 = r8.getUserPhone()
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r14 = "record context -> alias= "
                r11.append(r14)
                r11.append(r1)
                java.lang.String r1 = ", clientType= "
                r11.append(r1)
                r11.append(r2)
                java.lang.String r1 = ", businessId = "
                r11.append(r1)
                r11.append(r3)
                java.lang.String r1 = ", caller = "
                r11.append(r1)
                r11.append(r4)
                java.lang.String r1 = ", userId = "
                r11.append(r1)
                r11.append(r6)
                java.lang.String r1 = ", userPhone = "
                r11.append(r1)
                r11.append(r10)
                java.lang.String r1 = r11.toString()
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String) r1)
                r1 = 5
                int r2 = r15.getClientType()     // Catch:{ Exception -> 0x033a }
                r3 = 1
                if (r2 == r3) goto L_0x02fa
                r4 = 2
                if (r2 == r4) goto L_0x02a2
                r2 = 1
                goto L_0x02d9
            L_0x02a2:
                if (r9 == 0) goto L_0x02b7
                java.lang.String r1 = "passenger upload by business service"
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String) r1)     // Catch:{ Exception -> 0x033a }
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r8 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this     // Catch:{ Exception -> 0x033a }
                java.lang.String r14 = r15.getSignKey()     // Catch:{ Exception -> 0x033a }
                r10 = r15
                r2 = 1
                r11 = r12
                r12 = r0
                r8.m25028b((com.didi.sdk.audiorecorder.net.UploadService) r9, (com.didi.sdk.audiorecorder.model.RecordResult) r10, (java.io.File) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x02f2 }
                goto L_0x02d9
            L_0x02b7:
                r2 = 1
                java.lang.String r3 = "passenger upload by inner service"
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String) r3)     // Catch:{ Exception -> 0x02f2 }
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r3 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this     // Catch:{ Exception -> 0x02f2 }
                android.content.Context r4 = r8.getAppContext()     // Catch:{ Exception -> 0x02f2 }
                java.lang.String r6 = r15.getUploadUrl()     // Catch:{ Exception -> 0x02f2 }
                com.didi.sdk.audiorecorder.net.UploadAudioService r9 = r3.m25010a((android.content.Context) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x02f2 }
                if (r9 == 0) goto L_0x02f4
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r8 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this     // Catch:{ Exception -> 0x02f2 }
                java.lang.String r14 = r15.getSignKey()     // Catch:{ Exception -> 0x02f2 }
                r10 = r15
                r11 = r12
                r12 = r0
                r8.m25027b((com.didi.sdk.audiorecorder.net.UploadAudioService) r9, (com.didi.sdk.audiorecorder.model.RecordResult) r10, (java.io.File) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x02f2 }
            L_0x02d9:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f2 }
                r0.<init>()     // Catch:{ Exception -> 0x02f2 }
                java.lang.String r1 = "upload ignored for unknown client type : "
                r0.append(r1)     // Catch:{ Exception -> 0x02f2 }
                int r1 = r15.getClientType()     // Catch:{ Exception -> 0x02f2 }
                r0.append(r1)     // Catch:{ Exception -> 0x02f2 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02f2 }
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String) r0)     // Catch:{ Exception -> 0x02f2 }
                goto L_0x0346
            L_0x02f2:
                r0 = move-exception
                goto L_0x033c
            L_0x02f4:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0337 }
                r0.<init>()     // Catch:{ Exception -> 0x0337 }
                throw r0     // Catch:{ Exception -> 0x0337 }
            L_0x02fa:
                r2 = 1
                if (r9 == 0) goto L_0x030f
                java.lang.String r1 = "driver upload by business service"
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String) r1)     // Catch:{ Exception -> 0x02f2 }
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r8 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this     // Catch:{ Exception -> 0x02f2 }
                java.lang.String r14 = r15.getSignKey()     // Catch:{ Exception -> 0x02f2 }
                r10 = r15
                r11 = r12
                r12 = r0
                r8.m25023a((com.didi.sdk.audiorecorder.net.UploadService) r9, (com.didi.sdk.audiorecorder.model.RecordResult) r10, (java.io.File) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x02f2 }
                goto L_0x0346
            L_0x030f:
                java.lang.String r3 = "driver upload by inner service"
                com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String) r3)     // Catch:{ Exception -> 0x02f2 }
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r3 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this     // Catch:{ Exception -> 0x02f2 }
                android.content.Context r4 = r8.getAppContext()     // Catch:{ Exception -> 0x02f2 }
                java.lang.String r6 = r15.getUploadUrl()     // Catch:{ Exception -> 0x02f2 }
                com.didi.sdk.audiorecorder.net.UploadAudioService r9 = r3.m25010a((android.content.Context) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x02f2 }
                if (r9 == 0) goto L_0x0331
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r8 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this     // Catch:{ Exception -> 0x02f2 }
                java.lang.String r14 = r15.getSignKey()     // Catch:{ Exception -> 0x02f2 }
                r10 = r15
                r11 = r12
                r12 = r0
                r8.m25022a((com.didi.sdk.audiorecorder.net.UploadAudioService) r9, (com.didi.sdk.audiorecorder.model.RecordResult) r10, (java.io.File) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x02f2 }
                goto L_0x0346
            L_0x0331:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0337 }
                r0.<init>()     // Catch:{ Exception -> 0x0337 }
                throw r0     // Catch:{ Exception -> 0x0337 }
            L_0x0337:
                r0 = move-exception
                r4 = 5
                goto L_0x033d
            L_0x033a:
                r0 = move-exception
                r2 = 1
            L_0x033c:
                r4 = r5
            L_0x033d:
                com.didi.sdk.audiorecorder.helper.AudioUploaderImpl r1 = com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.this
                if (r4 == 0) goto L_0x0342
                goto L_0x0343
            L_0x0342:
                r4 = 1
            L_0x0343:
                r1.m25019a((com.didi.sdk.audiorecorder.model.RecordResult) r15, (int) r4, (java.lang.Throwable) r0)
            L_0x0346:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.helper.AudioUploaderImpl.UploadTask.run():void");
        }

        private boolean encryptFile(FileEncryption fileEncryption, File file, File file2, int i, int i2) {
            try {
                fileEncryption.encrypt(file, file2);
                return true;
            } catch (Throwable th) {
                LogUtil.log("AudioUploaderImpl -> encrypt file exception: ", th);
                if (i < i2) {
                    if (encryptFile(fileEncryption, file, file2, i + 1, i2)) {
                        return true;
                    }
                }
                return false;
            }
        }

        private FileEncryption createAesFileEncryption() {
            FileEncryption fileEncryption;
            Exception e;
            try {
                fileEncryption = new FileEncryption();
                try {
                    LogUtil.log(AudioUploaderImpl.f35312a, "createAesFileEncryption succeed. ");
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                Exception exc = e3;
                fileEncryption = null;
                e = exc;
                LogUtil.log("AudioUploaderImpl -> createAesFileEncryption fail. ", e);
                return fileEncryption;
            }
            return fileEncryption;
        }

        private byte[] createAesKey(FileEncryption fileEncryption, int i, int i2) {
            try {
                byte[] makeKey = fileEncryption.makeKey();
                if (makeKey != null && makeKey.length > 0) {
                    LogUtil.log(AudioUploaderImpl.f35312a, "createAesKey succeed. retryCount = " + i, ", maxRetryCount = " + i2);
                    return makeKey;
                }
            } catch (Exception e) {
                LogUtil.log("AudioUploaderImpl -> createAesKey fail. ", e);
            }
            if (i < i2) {
                return createAesKey(fileEncryption, i + 1, i2);
            }
            return null;
        }

        private String encryptAesKey(byte[] bArr, int i, int i2) {
            try {
                String encryptString = FileEncryption.getEncryptString(bArr);
                LogUtil.log(AudioUploaderImpl.f35312a, "encryptAesKey succeed. retryCount = " + i, ", maxRetryCount = " + i2);
                if (!TextUtils.isEmpty(encryptString)) {
                    return encryptString;
                }
            } catch (Exception e) {
                LogUtil.log("AudioUploaderImpl -> renameEncryptTempFile fail. ", e);
            }
            if (i < i2) {
                return encryptAesKey(bArr, i + 1, i2);
            }
            return null;
        }

        private boolean renameEncryptTempFile(File file, File file2, File file3, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            if (file3.renameTo(file2) && file2.exists() && file2.length() > 0) {
                LogUtil.log(AudioUploaderImpl.f35312a, "renameEncryptTempFile succeed. retryCount = " + i3, ", maxRetryCount = " + i4);
                file3.delete();
                file.delete();
                return true;
            } else if (i3 < i4) {
                return renameEncryptTempFile(file, file2, file3, i3 + 1, i2);
            } else {
                LogUtil.log(AudioUploaderImpl.f35312a, "renameEncryptTempFile fail. retryCount = " + i3, ", maxRetryCount = " + i4);
                file3.delete();
                return false;
            }
        }

        private File generateEncryptTmpFile(String str) {
            File file = new File(str + "_encrypt_temp");
            if (!file.exists() || file.delete()) {
                return file;
            }
            return new File(str + "_encrypt_temp" + new Random().nextInt());
        }
    }
}
