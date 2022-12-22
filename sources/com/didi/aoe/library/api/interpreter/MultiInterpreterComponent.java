package com.didi.aoe.library.api.interpreter;

import android.content.Context;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.lang.AoeRuntimeException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MultiInterpreterComponent<TInput, TOutput> implements AoeProcessor.InterpreterComponent<TInput, TOutput> {

    /* renamed from: a */
    private List<SingleInterpreterComponent> f8171a;

    public abstract List<SingleInterpreterComponent> provideSubInterpreters();

    public final void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener) {
        List<SingleInterpreterComponent> provideSubInterpreters = provideSubInterpreters();
        this.f8171a = provideSubInterpreters;
        if (provideSubInterpreters.size() == list.size()) {
            final CountDownLatch countDownLatch = new CountDownLatch(this.f8171a.size());
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            for (SingleInterpreterComponent init : this.f8171a) {
                init.init(context, list, (OnInterpreterInitListener) new OnInterpreterInitListener() {
                    public void onInitResult(InterpreterInitResult interpreterInitResult) {
                        if (interpreterInitResult.getCode() != 0) {
                            atomicInteger.set(interpreterInitResult.getCode());
                        }
                        countDownLatch.countDown();
                    }
                });
            }
            try {
                countDownLatch.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (onInterpreterInitListener != null) {
                onInterpreterInitListener.onInitResult(InterpreterInitResult.create(atomicInteger.get()));
                return;
            }
            return;
        }
        throw new AoeRuntimeException("Size of model options no match with interpreters");
    }

    public TOutput run(TInput tinput) {
        Object obj = null;
        for (SingleInterpreterComponent run : this.f8171a) {
            TInput run2 = run.run(tinput);
            tinput = run2;
            obj = run2;
        }
        return obj;
    }

    public void release() {
        for (SingleInterpreterComponent release : this.f8171a) {
            release.release();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0007 A[LOOP:0: B:1:0x0007->B:4:0x0017, LOOP_START, PHI: r1 
      PHI: (r1v1 boolean) = (r1v0 boolean), (r1v5 boolean) binds: [B:0:0x0000, B:4:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isReady() {
        /*
            r3 = this;
            java.util.List<com.didi.aoe.library.api.interpreter.SingleInterpreterComponent> r0 = r3.f8171a
            java.util.Iterator r0 = r0.iterator()
            r1 = 1
        L_0x0007:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            java.lang.Object r1 = r0.next()
            com.didi.aoe.library.api.interpreter.SingleInterpreterComponent r1 = (com.didi.aoe.library.api.interpreter.SingleInterpreterComponent) r1
            boolean r1 = r1.isReady()
            if (r1 != 0) goto L_0x0007
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.library.api.interpreter.MultiInterpreterComponent.isReady():boolean");
    }
}
