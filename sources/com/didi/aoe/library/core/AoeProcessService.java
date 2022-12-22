package com.didi.aoe.library.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.didi.aoe.library.api.interpreter.InterpreterInitResult;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.core.p098io.AoeParcelImpl;
import com.didi.aoe.library.core.pojos.Message;
import com.didi.aoe.library.core.service.IAoeProcessService;
import com.didi.aoe.library.lang.AoeRemoteException;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AoeProcessService extends Service {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f8178a = LoggerFactory.getLogger("AoeProcessService");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<String, C3608f> f8179b = new HashMap();

    /* renamed from: c */
    private final IAoeProcessService.Stub f8180c = new IAoeProcessService.Stub() {
        public int init(String str, Message message) throws RemoteException {
            byte[] data = message.getData();
            Context applicationContext = AoeProcessService.this.getApplicationContext();
            Object byte2Obj = C3605c.m5310c(AoeParcelImpl.class.getName()).byte2Obj(data);
            if (byte2Obj instanceof RemoteOptions) {
                RemoteOptions remoteOptions = (RemoteOptions) byte2Obj;
                C3606d dVar = new C3606d(applicationContext, remoteOptions.getClientOptions());
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final AtomicInteger atomicInteger = new AtomicInteger(-2);
                dVar.init(applicationContext, remoteOptions.getModelOptions(), new OnInterpreterInitListener() {
                    public void onInitResult(InterpreterInitResult interpreterInitResult) {
                        atomicInteger.set(interpreterInitResult.getCode());
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    AoeProcessService.this.f8178a.warn("InterruptedException: ", (Throwable) e);
                }
                Logger a = AoeProcessService.this.f8178a;
                a.debug("init: " + atomicInteger.get() + ", clientId: " + str, new Object[0]);
                if (atomicInteger.get() == 0) {
                    AoeProcessService.this.f8179b.put(str, new C3608f(dVar));
                }
                return atomicInteger.get();
            }
            Logger a2 = AoeProcessService.this.f8178a;
            a2.error("parse init options " + str + ": " + byte2Obj, new Object[0]);
            throw new AoeRemoteException("parse init options " + str + ": " + byte2Obj);
        }

        public Message process(String str, Message message) throws RemoteException {
            C3608f fVar = (C3608f) AoeProcessService.this.f8179b.get(str);
            if (fVar != null) {
                byte[] a = fVar.mo40243a().mo40242a(message);
                if (a == null || a.length <= 0) {
                    return null;
                }
                if (fVar.getParcelComponent() != null) {
                    Object run = fVar.getInterpreterComponent().run(fVar.getParcelComponent().byte2Obj(a));
                    if (run != null) {
                        return new Message(1, 0, fVar.getParcelComponent().obj2Byte(run));
                    }
                    return null;
                }
                throw new AoeRemoteException("Process error, ParcelComponent is NULL");
            }
            throw new AoeRemoteException("Process error, can't found processor for client: " + str);
        }

        public void release(String str) throws RemoteException {
            C3608f fVar = (C3608f) AoeProcessService.this.f8179b.get(str);
            if (fVar != null) {
                fVar.getInterpreterComponent().release();
                AoeProcessService.this.f8179b.remove(str);
                return;
            }
            throw new AoeRemoteException("Release error, can't found processor for client: " + str);
        }
    };

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return this.f8180c;
    }
}
