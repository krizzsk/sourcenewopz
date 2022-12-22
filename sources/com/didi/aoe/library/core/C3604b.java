package com.didi.aoe.library.core;

import android.content.Context;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.core.AoeClient;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.util.List;

/* renamed from: com.didi.aoe.library.core.b */
/* compiled from: AoeProcessorImpl */
class C3604b implements AoeProcessor, AoeProcessor.InterpreterComponent<Object, Object>, AoeProcessor.ParcelComponent {

    /* renamed from: a */
    private final Logger f8182a = LoggerFactory.getLogger("AoeProcessor");

    /* renamed from: b */
    private final C3603a f8183b;

    public C3604b(Context context, AoeClient.Options options) {
        if (options.useRemoteService) {
            this.f8183b = new C3609g(context, options);
        } else {
            this.f8183b = new C3606d(context, options);
        }
    }

    public void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener) {
        this.f8183b.init(context, list, onInterpreterInitListener);
    }

    public Object run(Object obj) {
        return this.f8183b.run(obj);
    }

    public void release() {
        this.f8182a.debug("release", new Object[0]);
        this.f8183b.release();
    }

    public void setId(String str) {
        this.f8183b.setId(str);
    }

    public AoeProcessor.InterpreterComponent getInterpreterComponent() {
        return this.f8183b;
    }

    public AoeProcessor.ParcelComponent getParcelComponent() {
        return this.f8183b;
    }

    public boolean isReady() {
        return this.f8183b.isReady();
    }

    public byte[] obj2Byte(Object obj) {
        return this.f8183b.obj2Byte(obj);
    }

    public Object byte2Obj(byte[] bArr) {
        return this.f8183b.byte2Obj(bArr);
    }
}
