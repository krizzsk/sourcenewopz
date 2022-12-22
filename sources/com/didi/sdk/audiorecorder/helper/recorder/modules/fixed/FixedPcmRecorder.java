package com.didi.sdk.audiorecorder.helper.recorder.modules.fixed;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.helper.recorder.modules.MicRecorderApi28;
import com.didi.sdk.audiorecorder.utils.ByteArrayAllocator;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.Arrays;

public class FixedPcmRecorder extends MicRecorderApi28 {

    /* renamed from: a */
    private final String f35421a = "FixedPcmRecorder";

    public static native int resample(byte[] bArr, int i, byte[] bArr2, int i2);

    static {
        System.loadLibrary("gdresample");
    }

    /* access modifiers changed from: protected */
    public byte[] resample16kTo8k(byte[] bArr, int i) {
        byte[] allocate;
        boolean isDebuggable = LogUtil.isDebuggable();
        if (isDebuggable) {
            SystemUtils.log(4, "FixedPcmRecorder", "resample16kTo8k : " + bArr.length + " " + i + " " + Arrays.toString(bArr), (Throwable) null, "com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedPcmRecorder", 25);
        }
        if (i != 640 || (allocate = ByteArrayAllocator.allocate(320)) == null) {
            return null;
        }
        int resample = resample(bArr, i, allocate, 320);
        if (isDebuggable) {
            SystemUtils.log(4, "FixedPcmRecorder", "resample16kTo8k in arr:" + Arrays.toString(bArr), (Throwable) null, "com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedPcmRecorder", 32);
            SystemUtils.log(4, "FixedPcmRecorder", "resample16kTo8k out arr:" + resample + " " + Arrays.toString(allocate), (Throwable) null, "com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedPcmRecorder", 33);
        }
        return allocate;
    }
}
