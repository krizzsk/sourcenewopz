package com.didi.aoe.library.core;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.api.interpreter.InterpreterInitResult;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.core.AoeClient;
import com.didi.aoe.library.core.p098io.AoeParcelImpl;
import com.didi.aoe.library.core.pojos.Message;
import com.didi.aoe.library.core.service.IAoeProcessService;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didi.aoe.library.core.g */
/* compiled from: RemoteProcessorWrapper */
final class C3609g extends C3603a {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Logger f8196b = LoggerFactory.getLogger("RemoteProcessorWrapper");

    /* renamed from: c */
    private final AoeClient.Options f8197c;

    /* renamed from: d */
    private final AoeProcessor.ParcelComponent f8198d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AtomicBoolean f8199e = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f8200f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<AoeModelOption> f8201g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IAoeProcessService f8202h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnInterpreterInitListener f8203i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f8204j = -1;

    /* renamed from: k */
    private final ServiceConnection f8205k = new RemoteProcessorWrapper$1(this);

    public C3609g(Context context, AoeClient.Options options) {
        super(context, options);
        this.f8198d = C3605c.m5310c(options.parcelerClassName);
        this.f8197c = options;
        if (!m5318a()) {
            m5321b();
        }
    }

    public void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener) {
        this.f8201g = list;
        this.f8203i = onInterpreterInitListener;
        if (m5318a()) {
            InterpreterInitResult a = m5315a(this.f8200f, this.f8201g);
            if (onInterpreterInitListener != null) {
                onInterpreterInitListener.onInitResult(a);
                return;
            }
            return;
        }
        m5321b();
        if (-1 == this.f8204j) {
            this.f8204j = 2;
        }
        if (onInterpreterInitListener != null) {
            onInterpreterInitListener.onInitResult(InterpreterInitResult.create(this.f8204j));
        }
    }

    public Object run(Object obj) {
        if (m5318a()) {
            m5315a(this.f8200f, this.f8201g);
            byte[] obj2Byte = getParcelComponent().obj2Byte(obj);
            if (obj2Byte == null || obj2Byte.length <= 0) {
                return null;
            }
            try {
                byte[] a = m5319a(obj2Byte);
                if (a == null || a.length <= 0) {
                    return null;
                }
                return getParcelComponent().byte2Obj(a);
            } catch (RemoteException e) {
                this.f8196b.error("process error: ", (Throwable) e);
                return null;
            }
        } else {
            m5321b();
            return null;
        }
    }

    /* renamed from: a */
    private byte[] m5319a(byte[] bArr) throws RemoteException {
        for (Message process : C3607e.m5311a(bArr)) {
            Message process2 = this.f8202h.process(this.f8200f, process);
            if (process2 != null) {
                return process2.getData();
            }
        }
        return new byte[0];
    }

    public void release() {
        if (m5318a()) {
            try {
                this.f8202h.release(this.f8200f);
            } catch (RemoteException e) {
                this.f8196b.error("release error: ", (Throwable) e);
            }
        }
        if (this.f8199e.getAndSet(false)) {
            m5323c();
        }
        this.f8204j = -1;
    }

    public boolean isReady() {
        return this.f8204j == 0;
    }

    public AoeProcessor.ParcelComponent getParcelComponent() {
        return this.f8198d;
    }

    /* renamed from: a */
    private boolean m5318a() {
        IAoeProcessService iAoeProcessService = this.f8202h;
        return (iAoeProcessService == null || iAoeProcessService.asBinder() == null || !this.f8202h.asBinder().isBinderAlive()) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public InterpreterInitResult m5315a(String str, List<AoeModelOption> list) {
        if (isReady()) {
            return InterpreterInitResult.create(0);
        }
        if (m5318a()) {
            try {
                RemoteOptions remoteOptions = new RemoteOptions();
                remoteOptions.setClientOptions(this.f8197c);
                remoteOptions.setModelOptions(list);
                int init = this.f8202h.init(str, new Message(C3605c.m5310c(AoeParcelImpl.class.getName()).obj2Byte(remoteOptions)));
                Logger logger = this.f8196b;
                logger.debug("tryInitIfNeeded: " + init, new Object[0]);
                this.f8204j = init;
                return InterpreterInitResult.create(init);
            } catch (RemoteException e) {
                this.f8196b.error("tryInitIfNeeded error", (Throwable) e);
            }
        }
        return InterpreterInitResult.create(2, "RemoteService not active.");
    }

    /* renamed from: b */
    private void m5321b() {
        this.f8181a.bindService(new Intent(this.f8181a, AoeProcessService.class), this.f8205k, 1);
    }

    /* renamed from: c */
    private void m5323c() {
        this.f8181a.unbindService(this.f8205k);
    }

    public void setId(String str) {
        this.f8200f = str;
    }
}
