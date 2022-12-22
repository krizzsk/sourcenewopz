package p242io.flutter.embedding.engine.systemchannels;

import java.util.HashMap;
import java.util.Map;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.StandardMethodCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.RestorationChannel */
public class RestorationChannel {

    /* renamed from: a */
    private static final String f57728a = "RestorationChannel";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public byte[] f57729b;

    /* renamed from: c */
    private MethodChannel f57730c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MethodChannel.Result f57731d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f57732e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f57733f;

    /* renamed from: g */
    private final MethodChannel.MethodCallHandler f57734g;
    public final boolean waitForRestorationData;

    public RestorationChannel(DartExecutor dartExecutor, boolean z) {
        this(new MethodChannel(dartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), z);
    }

    RestorationChannel(MethodChannel methodChannel, boolean z) {
        this.f57732e = false;
        this.f57733f = false;
        C210962 r0 = new MethodChannel.MethodCallHandler() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onMethodCall(p242io.flutter.plugin.common.MethodCall r5, p242io.flutter.plugin.common.MethodChannel.Result r6) {
                /*
                    r4 = this;
                    java.lang.String r0 = r5.method
                    java.lang.Object r5 = r5.arguments
                    int r1 = r0.hashCode()
                    r2 = 102230(0x18f56, float:1.43255E-40)
                    r3 = 1
                    if (r1 == r2) goto L_0x001e
                    r2 = 111375(0x1b30f, float:1.5607E-40)
                    if (r1 == r2) goto L_0x0014
                    goto L_0x0028
                L_0x0014:
                    java.lang.String r1 = "put"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0028
                    r0 = 0
                    goto L_0x0029
                L_0x001e:
                    java.lang.String r1 = "get"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0028
                    r0 = 1
                    goto L_0x0029
                L_0x0028:
                    r0 = -1
                L_0x0029:
                    if (r0 == 0) goto L_0x0059
                    if (r0 == r3) goto L_0x0031
                    r6.notImplemented()
                    goto L_0x0064
                L_0x0031:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p242io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean unused = r5.f57733f = r3
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p242io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean r5 = r5.f57732e
                    if (r5 != 0) goto L_0x004b
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p242io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean r5 = r5.waitForRestorationData
                    if (r5 != 0) goto L_0x0045
                    goto L_0x004b
                L_0x0045:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p242io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    p242io.flutter.plugin.common.MethodChannel.Result unused = r5.f57731d = r6
                    goto L_0x0064
                L_0x004b:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p242io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    byte[] r0 = r5.f57729b
                    java.util.Map r5 = r5.m41506a((byte[]) r0)
                    r6.success(r5)
                    goto L_0x0064
                L_0x0059:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r0 = p242io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    byte[] r5 = (byte[]) r5
                    byte[] unused = r0.f57729b = r5
                    r5 = 0
                    r6.success(r5)
                L_0x0064:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.engine.systemchannels.RestorationChannel.C210962.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
            }
        };
        this.f57734g = r0;
        this.f57730c = methodChannel;
        this.waitForRestorationData = z;
        methodChannel.setMethodCallHandler(r0);
    }

    public byte[] getRestorationData() {
        return this.f57729b;
    }

    public void setRestorationData(final byte[] bArr) {
        this.f57732e = true;
        MethodChannel.Result result = this.f57731d;
        if (result != null) {
            result.success(m41506a(bArr));
            this.f57731d = null;
            this.f57729b = bArr;
        } else if (this.f57733f) {
            this.f57730c.invokeMethod("push", m41506a(bArr), new MethodChannel.Result() {
                public void notImplemented() {
                }

                public void success(Object obj) {
                    byte[] unused = RestorationChannel.this.f57729b = bArr;
                }

                public void error(String str, String str2, Object obj) {
                    Log.m41136e(RestorationChannel.f57728a, "Error " + str + " while sending restoration data to framework: " + str2);
                }
            });
        } else {
            this.f57729b = bArr;
        }
    }

    public void clearData() {
        this.f57729b = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, Object> m41506a(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", true);
        hashMap.put("data", bArr);
        return hashMap;
    }
}
