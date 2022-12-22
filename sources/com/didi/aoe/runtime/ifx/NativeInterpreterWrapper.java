package com.didi.aoe.runtime.ifx;

import android.content.res.AssetManager;
import com.didi.aoe.runtime.ifx.Interpreter;
import java.util.Map;

final class NativeInterpreterWrapper {

    /* renamed from: a */
    private long f8217a;

    /* renamed from: b */
    private boolean f8218b;

    /* renamed from: c */
    private IfxTensor[] f8219c;

    /* renamed from: d */
    private IfxTensor[] f8220d;

    /* renamed from: e */
    private boolean f8221e;

    private static native long allocateTensors(long j);

    private static native long createInterpreter(boolean z, int i);

    private static native void delete(long j);

    private static native int getInputCount(long j);

    private static native int getOutputCount(long j);

    private static native boolean loadModel(String str, String str2, int i, long j);

    private static native boolean loadModelFromAssets(AssetManager assetManager, String str, String str2, int i, long j);

    private static native void preTreatment(int i, byte[] bArr, int i2, int i3, int i4, int i5, float[] fArr, float[] fArr2, long j, long j2);

    private static native int run(long j);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40289a(int i, int[] iArr) {
    }

    NativeInterpreterWrapper(AssetManager assetManager, String str, String str2, int i, Interpreter.Options options) {
        options = options == null ? new Interpreter.Options() : options;
        long createInterpreter = createInterpreter(options.lightMode, options.numThreads);
        this.f8217a = createInterpreter;
        boolean loadModelFromAssets = loadModelFromAssets(assetManager, str, str2, i, createInterpreter);
        this.f8218b = loadModelFromAssets;
        if (loadModelFromAssets) {
            m5342e();
        }
    }

    NativeInterpreterWrapper(String str, String str2, int i, Interpreter.Options options) {
        options = options == null ? new Interpreter.Options() : options;
        long createInterpreter = createInterpreter(options.lightMode, options.numThreads);
        this.f8217a = createInterpreter;
        boolean loadModel = loadModel(str, str2, i, createInterpreter);
        this.f8218b = loadModel;
        if (loadModel) {
            m5342e();
        }
    }

    /* renamed from: e */
    private void m5342e() {
        this.f8219c = new IfxTensor[getInputCount(this.f8217a)];
        this.f8220d = new IfxTensor[getOutputCount(this.f8217a)];
        allocateTensors(this.f8217a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40290a(byte[] bArr, int i, int i2, int i3, int i4, float[] fArr, float[] fArr2, int i5) {
        int i6 = i5;
        if (i6 < this.f8219c.length) {
            preTreatment(i5, bArr, i, i2, i3, i4, fArr, fArr2, this.f8217a, mo40287a(i6).mo40271c());
            this.f8221e = true;
            return;
        }
        throw new IllegalArgumentException("Input error: Inputs index should small than max.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IfxTensor mo40287a(int i) {
        if (i >= 0) {
            IfxTensor[] ifxTensorArr = this.f8219c;
            if (i < ifxTensorArr.length) {
                IfxTensor ifxTensor = ifxTensorArr[i];
                if (ifxTensor != null) {
                    return ifxTensor;
                }
                IfxTensor a = IfxTensor.m5328a(this.f8217a, i, true);
                ifxTensorArr[i] = a;
                return a;
            }
        }
        throw new IllegalArgumentException("Invalid input Tensor index: " + i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public IfxTensor mo40292b(int i) {
        if (i >= 0) {
            IfxTensor[] ifxTensorArr = this.f8220d;
            if (i < ifxTensorArr.length) {
                IfxTensor ifxTensor = ifxTensorArr[i];
                if (ifxTensor != null || !this.f8218b) {
                    return ifxTensor;
                }
                IfxTensor a = IfxTensor.m5328a(this.f8217a, i, false);
                ifxTensorArr[i] = a;
                return a;
            }
        }
        throw new IllegalArgumentException("Invalid output Tensor index: " + i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40288a() {
        int i = 0;
        this.f8218b = false;
        this.f8221e = false;
        long j = this.f8217a;
        if (j > 0) {
            delete(j);
            this.f8217a = 0;
        }
        if (this.f8219c != null) {
            int i2 = 0;
            while (true) {
                IfxTensor[] ifxTensorArr = this.f8219c;
                if (i2 >= ifxTensorArr.length) {
                    break;
                }
                if (ifxTensorArr[i2] != null) {
                    ifxTensorArr[i2].mo40267a();
                    this.f8219c[i2] = null;
                }
                i2++;
            }
        }
        if (this.f8220d != null) {
            while (true) {
                IfxTensor[] ifxTensorArr2 = this.f8220d;
                if (i < ifxTensorArr2.length) {
                    if (ifxTensorArr2[i] != null) {
                        ifxTensorArr2[i].mo40267a();
                        this.f8220d[i] = null;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40291a(Object[] objArr, Map<Integer, Object> map) {
        if (!this.f8221e && (objArr == null || objArr.length == 0)) {
            throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
        } else if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Input error: Outputs should not be null or empty.");
        } else {
            if (!(objArr == null || objArr.length == 0)) {
                for (int i = 0; i < objArr.length; i++) {
                    int[] c = mo40287a(i).mo40272c(objArr[i]);
                    if (c != null) {
                        mo40289a(i, c);
                    }
                }
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    mo40287a(i2).mo40268a(objArr[i2]);
                }
            }
            if (run(this.f8217a) == 0 && this.f8218b) {
                for (int i3 = 0; i3 < this.f8220d.length; i3++) {
                    mo40292b(i3).mo40270b();
                }
                for (Map.Entry next : map.entrySet()) {
                    mo40292b(((Integer) next.getKey()).intValue()).mo40269b(next.getValue());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo40293b() {
        return this.f8218b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo40294c() {
        return this.f8219c.length;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo40295d() {
        return this.f8220d.length;
    }
}
