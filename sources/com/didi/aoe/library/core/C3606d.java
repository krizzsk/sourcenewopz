package com.didi.aoe.library.core;

import android.content.Context;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.core.AoeClient;
import java.util.List;

/* renamed from: com.didi.aoe.library.core.d */
/* compiled from: NativeProcessorWrapper */
final class C3606d extends C3603a {

    /* renamed from: b */
    private final AoeProcessor.InterpreterComponent f8188b;

    /* renamed from: c */
    private final AoeProcessor.ParcelComponent f8189c;

    public C3606d(Context context, AoeClient.Options options) {
        super(context, options);
        this.f8188b = C3605c.m5309b(options.interpreterClassName);
        this.f8189c = C3605c.m5310c(options.parcelerClassName);
    }

    public void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener) {
        this.f8188b.init(context, list, onInterpreterInitListener);
    }

    public Object run(Object obj) {
        return this.f8188b.run(obj);
    }

    public void release() {
        this.f8188b.release();
    }

    public AoeProcessor.InterpreterComponent getInterpreterComponent() {
        return this.f8188b;
    }

    public AoeProcessor.ParcelComponent getParcelComponent() {
        return this.f8189c;
    }
}
