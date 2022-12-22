package com.didi.aoe.library.core;

import android.content.Context;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.api.interpreter.InterpreterInitResult;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.lang.AoeIOException;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class AoeClient {

    /* renamed from: a */
    private final Logger f8173a;

    /* renamed from: b */
    private final Context f8174b;

    /* renamed from: c */
    private final AoeProcessor f8175c;

    /* renamed from: d */
    private final List<AoeModelOption> f8176d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public InterpreterInitResult f8177e;

    public static class OnInitListener {
        public void onFailed(int i, String str) {
        }

        public void onSuccess() {
        }
    }

    public AoeClient(Context context, Options options, String str) {
        this(context, str, options, str, new String[0]);
    }

    public AoeClient(Context context, String str, Options options, String str2, String... strArr) {
        this.f8173a = LoggerFactory.getLogger("AoeClient");
        this.f8176d = new ArrayList();
        this.f8177e = InterpreterInitResult.create(-1);
        this.f8174b = context;
        try {
            m5299a(context, C3605c.m5307a(options.modelOptionLoaderClassName), str2, strArr);
        } catch (AoeIOException e) {
            this.f8177e = InterpreterInitResult.create(1, "ModelOption parse error: " + e.getMessage());
        }
        C3604b bVar = new C3604b(context, options);
        this.f8175c = bVar;
        bVar.setId(str);
    }

    public void init(OnInitListener onInitListener) {
        m5301a(onInitListener);
    }

    /* renamed from: a */
    private void m5299a(Context context, AoeProcessor.ModelOptionLoaderComponent modelOptionLoaderComponent, String str, String... strArr) throws AoeIOException {
        AoeModelOption load = modelOptionLoaderComponent.load(context, str);
        Logger logger = this.f8173a;
        logger.debug("[tryLoadModelOptions] ModelOption: " + load, new Object[0]);
        if (load != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(load);
            if (strArr != null) {
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    AoeModelOption load2 = modelOptionLoaderComponent.load(context, strArr[i]);
                    Logger logger2 = this.f8173a;
                    logger2.debug("Subsequent model: " + load2, new Object[0]);
                    if (load2 != null) {
                        arrayList.add(load2);
                        i++;
                    } else {
                        throw new AoeIOException("ModelOption load error, no sub model.");
                    }
                }
            }
            this.f8176d.clear();
            this.f8176d.addAll(arrayList);
            return;
        }
        throw new AoeIOException("ModelOption load error, no main model.");
    }

    /* renamed from: a */
    private void m5301a(final OnInitListener onInitListener) {
        if (-1 != this.f8177e.getCode() && 3 != this.f8177e.getCode()) {
            m5300a(this.f8177e, onInitListener);
        } else if (m5303a()) {
            this.f8175c.getInterpreterComponent().init(this.f8174b, this.f8176d, new OnInterpreterInitListener() {
                public void onInitResult(InterpreterInitResult interpreterInitResult) {
                    InterpreterInitResult unused = AoeClient.this.f8177e = interpreterInitResult;
                    AoeClient.this.m5300a(interpreterInitResult, onInitListener);
                }
            });
        } else {
            m5300a(this.f8177e, onInitListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5300a(InterpreterInitResult interpreterInitResult, OnInitListener onInitListener) {
        if (onInitListener == null) {
            return;
        }
        if (interpreterInitResult.getCode() == 0) {
            onInitListener.onSuccess();
        } else {
            onInitListener.onFailed(interpreterInitResult.getCode(), interpreterInitResult.getMsg());
        }
    }

    public boolean isRunning() {
        return this.f8175c.getInterpreterComponent().isReady();
    }

    /* renamed from: a */
    private boolean m5303a() {
        return !this.f8176d.isEmpty();
    }

    /* renamed from: b */
    private boolean m5304b() {
        return this.f8177e.getCode() == 0;
    }

    public Object process(Object obj) {
        if (m5304b()) {
            return this.f8175c.getInterpreterComponent().run(obj);
        }
        m5301a((OnInitListener) null);
        return null;
    }

    public void release() {
        this.f8175c.getInterpreterComponent().release();
    }

    public static class Options implements Serializable {
        String interpreterClassName;
        String modelOptionLoaderClassName;
        String parcelerClassName;
        int threadNum = 1;
        boolean useRemoteService = true;

        public Options setModelOptionLoader(Class<? extends AoeProcessor.ModelOptionLoaderComponent> cls) {
            this.modelOptionLoaderClassName = cls.getName();
            return this;
        }

        public Options setInterpreter(Class<? extends AoeProcessor.InterpreterComponent> cls) {
            this.interpreterClassName = cls.getName();
            return this;
        }

        public Options setParceler(Class<? extends AoeProcessor.ParcelComponent> cls) {
            this.parcelerClassName = cls.getName();
            return this;
        }

        public Options useRemoteService(boolean z) {
            this.useRemoteService = z;
            return this;
        }

        public Options setThreadNum(int i) {
            this.threadNum = i;
            return this;
        }
    }
}
