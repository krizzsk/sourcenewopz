package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.data.ResultNothing;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.NetworkUtils;
import com.didichuxing.diface.biz.bioassay.self_liveness.IUploadVideoRequester;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.FileUtils;
import com.didichuxing.sdk.alphaface.core.RendererDecorate;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class RecordHelper implements LifecycleObserver {
    public static final long VIDEO_RECORD_UPLOAD_DELAY = TimeUnit.SECONDS.toMillis(1);
    public final long VIDEO_RECORD_STOP_DELAY;

    /* renamed from: a */
    final Runnable f47322a = new Runnable() {
        public void run() {
            RecordHelper.this.onSuccess();
        }
    };

    /* renamed from: b */
    private final RendererDecorate f47323b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f47324c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f47325d;

    /* renamed from: e */
    private final Handler f47326e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f47327f;

    /* renamed from: g */
    private boolean f47328g;

    /* renamed from: h */
    private boolean f47329h;

    /* renamed from: i */
    private long f47330i;

    /* renamed from: j */
    private long f47331j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final String f47332k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f47333l = "0";
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f47334m = "";

    public RecordHelper(Context context, RendererDecorate rendererDecorate, String str, int i, long j, long j2) {
        this.f47323b = rendererDecorate;
        this.f47324c = context.getApplicationContext();
        this.f47332k = str;
        this.f47325d = DiFaceFacade.getInstance().getSessionId();
        this.VIDEO_RECORD_STOP_DELAY = TimeUnit.SECONDS.toMillis((long) i);
        this.f47330i = j;
        this.f47331j = j2;
        this.f47326e = new Handler(Looper.getMainLooper());
    }

    public void onStart() {
        if (this.f47323b != null && TextUtils.isEmpty(this.f47327f)) {
            this.f47323b.startRecord();
        }
    }

    /* renamed from: a */
    private void m33919a() {
        RendererDecorate rendererDecorate = this.f47323b;
        if (rendererDecorate != null) {
            String videoPath = rendererDecorate.getVideoPath();
            this.f47327f = videoPath;
            if (!TextUtils.isEmpty(videoPath)) {
                m33924b();
            }
        }
    }

    /* renamed from: b */
    private void m33924b() {
        DiFaceFacade.getInstance().report("201", DiFaceLogger.setBioType((HashMap<String, Object>) null, this.f47332k), (HashMap<String, Object>) null);
        this.f47326e.postDelayed(new Runnable() {
            public void run() {
                File file = new File(RecordHelper.this.f47327f);
                if (RecordHelper.this.m33921a(file)) {
                    IUploadVideoRequester.Holder.createRequest(RecordHelper.this.f47324c).upload(RecordHelper.this.f47325d, file, new AbsRpcCallback<NewBaseResult<ResultNothing>, ResultNothing>() {
                        /* access modifiers changed from: protected */
                        public void failure(int i, String str) {
                            RecordHelper recordHelper = RecordHelper.this;
                            String unused = recordHelper.f47334m = "code:" + i + "  msg:" + str;
                            FileUtils.deleteFile(RecordHelper.this.f47327f);
                        }

                        /* access modifiers changed from: protected */
                        public void success(ResultNothing resultNothing, int i, String str) {
                            String unused = RecordHelper.this.f47333l = "1";
                            FileUtils.deleteFile(RecordHelper.this.f47327f);
                        }
                    });
                } else {
                    String unused = RecordHelper.this.f47334m = "文件太大或无网络";
                    FileUtils.delete(file);
                    LogUtils.m33564d("xxxx", "ifUpload: false : ");
                }
                HashMap hashMap = new HashMap();
                hashMap.put("success", RecordHelper.this.f47333l);
                hashMap.put("errorMsg", RecordHelper.this.f47334m);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_UPLOAD_VIDEO_CALLBACK, DiFaceLogger.setBioType(hashMap, RecordHelper.this.f47332k), (HashMap<String, Object>) null);
            }
        }, VIDEO_RECORD_UPLOAD_DELAY);
    }

    public void hasFace() {
        this.f47328g = true;
    }

    public void hasAction() {
        this.f47329h = true;
    }

    public void removeTimeoutRunnable() {
        this.f47326e.removeCallbacks(this.f47322a);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        removeTimeoutRunnable();
        RendererDecorate rendererDecorate = this.f47323b;
        if (rendererDecorate != null && rendererDecorate.isRecordVideo()) {
            FileUtils.deleteFile(this.f47323b.getVideoPath());
        }
    }

    public void onFailed() {
        removeTimeoutRunnable();
        m33919a();
    }

    public void onSuccess() {
        removeTimeoutRunnable();
        RendererDecorate rendererDecorate = this.f47323b;
        if (rendererDecorate != null) {
            String videoPath = rendererDecorate.getVideoPath();
            this.f47327f = videoPath;
            if (!TextUtils.isEmpty(videoPath)) {
                m33924b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m33921a(File file) {
        long length = file.length() / 1024;
        return (NetworkUtils.isWifi(this.f47324c) && length <= this.f47330i * 1024) || (NetworkUtils.is4G(this.f47324c) && length <= this.f47331j * 1024);
    }
}
