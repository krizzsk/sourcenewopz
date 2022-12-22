package com.didi.trackupload.sdk.core;

import android.support.p003v4.media.session.PlaybackStateCompat;
import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.core.UploadController;
import com.didi.trackupload.sdk.core.UploadTask;
import com.didi.trackupload.sdk.utils.ApolloUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.Map;

public class UploadCacheTask implements UploadTask.OnExecuteCompletedListenser, Runnable {

    /* renamed from: a */
    private static final String f37021a = "TrackUploadCacheTask";

    /* renamed from: b */
    private static final int f37022b = 3;

    /* renamed from: c */
    private static final long f37023c;

    /* renamed from: d */
    private static final long f37024d;

    /* renamed from: e */
    private long f37025e = 0;

    static {
        long[] requestRecoverUploadParams = ApolloUtils.requestRecoverUploadParams();
        f37023c = requestRecoverUploadParams[0];
        f37024d = requestRecoverUploadParams[1];
        TrackLog.m31343d(f37021a, "startDelay=" + f37023c + " retryDelay=" + f37024d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26236a(UploadResult uploadResult) {
        UploadTask uploadTask = new UploadTask((Map<String, UploadController.UploadClient>) null, UploadFlags.m26245a(PlaybackStateCompat.ACTION_SET_REPEAT_MODE, 2, 4), this);
        if (uploadResult == null) {
            this.f37025e = 0;
            TrackLog.m31343d(f37021a, "upload task=" + uploadTask.toHexString() + " delay=" + f37023c);
            uploadTask.mo95247a(f37023c);
        } else if (uploadResult == UploadResult.ERR_PARAMS_BIZ_NODES) {
            this.f37025e = 0;
            TrackLog.m31343d(f37021a, "upload task ignored due to empty track nodes");
        } else if (TrackController.getIntance().getRunningClientSize() != 0) {
            TrackLog.m31343d(f37021a, "upload task ignored due to client exists");
        } else if (uploadResult == UploadResult.ERR_OK) {
            this.f37025e = 0;
            TrackLog.m31343d(f37021a, "upload task=" + uploadTask.toHexString() + " delay=0");
            uploadTask.mo95247a(0);
        } else {
            long j = this.f37025e;
            if (j < 3) {
                this.f37025e = j + 1;
                TrackLog.m31343d(f37021a, "upload task=" + uploadTask.toHexString() + " delay=" + f37024d);
                uploadTask.mo95247a(f37024d);
            }
        }
    }

    public void run() {
        if (CoreThread.ensureCoreThread()) {
            m26236a((UploadResult) null);
        }
    }

    public void onExecuteCompleted(final UploadResult uploadResult) {
        CoreThread.post(new Runnable() {
            public void run() {
                UploadCacheTask.this.m26236a(uploadResult);
            }
        });
    }
}
