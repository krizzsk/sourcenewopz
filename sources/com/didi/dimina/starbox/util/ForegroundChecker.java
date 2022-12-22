package com.didi.dimina.starbox.util;

import com.didi.dimina.starbox.p107ui.windowpop.DefaultDispatcher;
import com.didi.dimina.starbox.p107ui.windowpop.Dispatcher;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class ForegroundChecker implements Runnable {

    /* renamed from: a */
    private static volatile ForegroundChecker f18167a;

    /* renamed from: b */
    private Dispatcher f18168b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final LinkedList<OnForegroundChange> f18169c = new LinkedList<>();

    /* renamed from: d */
    private final StringBuilder f18170d = new StringBuilder();

    /* renamed from: e */
    private boolean f18171e = false;

    public interface OnForegroundChange {
        void onChange(boolean z);
    }

    public static ForegroundChecker getIns() {
        if (f18167a == null) {
            synchronized (ForegroundChecker.class) {
                if (f18167a == null) {
                    f18167a = new ForegroundChecker();
                }
            }
        }
        return f18167a;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.f18168b = dispatcher;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Dispatcher m13547a() {
        if (this.f18168b == null) {
            this.f18168b = new DefaultDispatcher();
        }
        return this.f18168b;
    }

    public synchronized void addChecker(final OnForegroundChange onForegroundChange) {
        m13547a().post(new Runnable() {
            public void run() {
                boolean isEmpty = ForegroundChecker.this.f18169c.isEmpty();
                ForegroundChecker.this.f18169c.add(onForegroundChange);
                if (isEmpty) {
                    ForegroundChecker.this.m13547a().post(ForegroundChecker.this);
                }
            }
        });
    }

    public synchronized void removeChecker(final OnForegroundChange onForegroundChange) {
        m13547a().post(new Runnable() {
            public void run() {
                ForegroundChecker.this.f18169c.remove(onForegroundChange);
            }
        });
    }

    public void run() {
        try {
            FileReader fileReader = new FileReader("/proc/self/oom_adj");
            this.f18170d.delete(0, this.f18170d.length());
            char[] cArr = new char[16];
            while (true) {
                int read = fileReader.read(cArr);
                if (read == -1) {
                    break;
                }
                this.f18170d.append(cArr, 0, read);
            }
            boolean z = Integer.parseInt(this.f18170d.toString().trim()) <= 0;
            if (this.f18171e != z) {
                Iterator it = this.f18169c.iterator();
                while (it.hasNext()) {
                    ((OnForegroundChange) it.next()).onChange(z);
                }
            }
            this.f18171e = z;
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.f18169c.isEmpty()) {
            this.f18171e = false;
        } else {
            m13547a().postDelay(this, 250);
        }
    }
}
