package com.didi.zxing.barcodescanner.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.didi.zxing.barcodescanner.trace.ScanTrace;
import com.didi.zxing.barcodescanner.trace.ScanTraceId;
import com.didi.zxing.client.camera.CameraConfigurationUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlinx.coroutines.DebugKt;

public final class AutoFocusManager {

    /* renamed from: a */
    private static final String f45326a = "AutoFocusManager";

    /* renamed from: b */
    private static final long f45327b = 1000;

    /* renamed from: k */
    private static final Collection<String> f45328k;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f45329c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f45330d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f45331e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Camera f45332f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f45333g = new Handler(this.f45338m);

    /* renamed from: h */
    private final int f45334h = 1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f45335i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f45336j;

    /* renamed from: l */
    private CameraSettings f45337l;

    /* renamed from: m */
    private final Handler.Callback f45338m = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            AutoFocusManager.this.m32551b();
            return true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Runnable f45339n = new Runnable() {
        public void run() {
            if (!AutoFocusManager.this.f45329c) {
                if (AutoFocusManager.this.f45335i > 0 && SystemClock.elapsedRealtime() - AutoFocusManager.this.f45335i > ((long) AutoFocusManager.this.f45336j)) {
                    DecodeConfig config = DecodeConfigUtil.getConfig();
                    ScanTrace.trace(ScanTraceId.SCAN_FOCUS_TIMEOUT);
                    if (config != null && config.autoSelectFocusMode() && DecodeConfigUtil.lum > config.useContinousFocusModeLum()) {
                        Camera.Parameters parameters = AutoFocusManager.this.f45332f.getParameters();
                        CameraConfigurationUtils.setFocus(parameters, CameraSettings.FocusMode.CONTINUOUS, false);
                        AutoFocusManager.this.f45332f.setParameters(parameters);
                        if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(AutoFocusManager.this.f45332f.getParameters().getFocusMode())) {
                            boolean unused = AutoFocusManager.this.f45331e = false;
                            return;
                        }
                    }
                }
                AutoFocusManager.this.f45333g.postDelayed(AutoFocusManager.this.f45339n, 1000);
            }
        }
    };

    /* renamed from: o */
    private final Camera.AutoFocusCallback f45340o = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean z, Camera camera) {
            SystemUtils.log(4, AutoFocusManager.f45326a, "onAutoFocus() called, success===" + z + ", camera=" + camera, (Throwable) null, "com.didi.zxing.barcodescanner.camera.AutoFocusManager$3", 101);
            if (!z) {
                ScanTrace.trace(ScanTraceId.SCAN_FOCUS_FAIL);
            } else {
                long unused = AutoFocusManager.this.f45335i = SystemClock.elapsedRealtime();
            }
            if (AutoFocusManager.this.f45331e) {
                AutoFocusManager.this.f45333g.post(new Runnable() {
                    public void run() {
                        boolean unused = AutoFocusManager.this.f45330d = false;
                        AutoFocusManager.this.m32548a();
                    }
                });
            }
        }
    };

    static {
        ArrayList arrayList = new ArrayList(2);
        f45328k = arrayList;
        arrayList.add(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        f45328k.add("macro");
    }

    public AutoFocusManager(Camera camera, CameraSettings cameraSettings) {
        this.f45332f = camera;
        this.f45337l = cameraSettings;
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null) {
            this.f45336j = config.autoFocusTimeout();
        }
        start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m32548a() {
        if (!this.f45329c && !this.f45333g.hasMessages(1)) {
            this.f45333g.sendMessageDelayed(this.f45333g.obtainMessage(1), 1000);
        }
    }

    public void start() {
        String focusMode = this.f45332f.getParameters().getFocusMode();
        this.f45331e = this.f45337l.isAutoFocusEnabled() && f45328k.contains(focusMode);
        SystemUtils.log(4, f45326a, "Current focus mode '" + focusMode + "'; use auto focus? " + this.f45331e, (Throwable) null, "com.didi.zxing.barcodescanner.camera.AutoFocusManager", 143);
        this.f45329c = false;
        m32551b();
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null && config.autoSelectFocusMode()) {
            this.f45333g.postDelayed(this.f45339n, 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32551b() {
        SystemUtils.log(4, f45326a, "focus() called, useAutoFocus===" + this.f45331e + ", stopped=" + this.f45329c + ", focusing=" + this.f45330d, (Throwable) null, "com.didi.zxing.barcodescanner.camera.AutoFocusManager", 154);
        if (this.f45331e && !this.f45329c && !this.f45330d) {
            try {
                this.f45332f.autoFocus(this.f45340o);
                this.f45330d = true;
            } catch (RuntimeException e) {
                SystemUtils.log(5, f45326a, "Unexpected exception while focusing", e, "com.didi.zxing.barcodescanner.camera.AutoFocusManager", 162);
                m32548a();
            }
        }
    }

    /* renamed from: c */
    private void m32555c() {
        this.f45333g.removeMessages(1);
    }

    public void stop() {
        this.f45329c = true;
        this.f45330d = false;
        this.f45333g.removeCallbacks(this.f45339n);
        m32555c();
        if (this.f45331e) {
            try {
                this.f45332f.cancelAutoFocus();
            } catch (RuntimeException e) {
                SystemUtils.log(5, f45326a, "Unexpected exception while cancelling focusing", e, "com.didi.zxing.barcodescanner.camera.AutoFocusManager", 188);
            }
        }
    }
}
