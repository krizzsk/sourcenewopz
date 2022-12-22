package com.didi.aoe.runtime.ifx;

import android.content.res.AssetManager;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public final class Interpreter {

    /* renamed from: a */
    private static final Logger f8215a = LoggerFactory.getLogger("IfxNativeInterpreter");

    /* renamed from: b */
    private NativeInterpreterWrapper f8216b;

    static {
        try {
            System.loadLibrary("aoe_ifx");
            f8215a.debug("IFX Init success", new Object[0]);
        } catch (UnsatisfiedLinkError unused) {
            f8215a.info("library not found!", new Object[0]);
        }
    }

    public Interpreter(AssetManager assetManager, String str, String str2, int i, Options options) {
        this.f8216b = new NativeInterpreterWrapper(assetManager, str, str2, i, options);
    }

    public Interpreter(String str, String str2, int i, Options options) {
        this.f8216b = new NativeInterpreterWrapper(str, str2, i, options);
    }

    public void preTreatment(byte[] bArr, int i, int i2, int i3, int i4, float[] fArr, float[] fArr2, int i5) {
        m5341a();
        this.f8216b.mo40290a(bArr, i, i2, i3, i4, fArr, fArr2, i5);
    }

    public void run(Object obj, Object obj2) {
        Object[] objArr;
        HashMap hashMap = new HashMap();
        hashMap.put(0, obj2);
        if (obj == null) {
            objArr = null;
        } else {
            objArr = new Object[]{obj};
        }
        runForMultipleInputsOutputs(objArr, hashMap);
    }

    public void runForMultipleInputsOutputs(Object[] objArr, Map<Integer, Object> map) {
        m5341a();
        this.f8216b.mo40291a(objArr, map);
    }

    public IfxTensor getOutputTensor(int i) {
        m5341a();
        return this.f8216b.mo40292b(i);
    }

    public int getInputTensorCount() {
        m5341a();
        return this.f8216b.mo40294c();
    }

    public IfxTensor getInputTensor(int i) {
        m5341a();
        return this.f8216b.mo40287a(i);
    }

    public int getOutputTensorCount() {
        m5341a();
        return this.f8216b.mo40295d();
    }

    public void close() {
        NativeInterpreterWrapper nativeInterpreterWrapper = this.f8216b;
        if (nativeInterpreterWrapper != null) {
            nativeInterpreterWrapper.mo40288a();
            this.f8216b = null;
        }
    }

    public boolean isLoadModelSuccess() {
        m5341a();
        return this.f8216b.mo40293b();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    /* renamed from: a */
    private void m5341a() {
        if (this.f8216b == null) {
            throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
        }
    }

    public static class Options {
        boolean lightMode = true;
        int numThreads = 4;

        public Options setNumberThreads(int i) {
            this.numThreads = i;
            return this;
        }

        public Options setLightMode(boolean z) {
            this.lightMode = z;
            return this;
        }
    }
}
