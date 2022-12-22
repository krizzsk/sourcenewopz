package com.didi.dimina.starbox.p107ui.windowpop;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.didi.dimina.starbox.util.ForegroundChecker;

/* renamed from: com.didi.dimina.starbox.ui.windowpop.AsyncWindowPop */
public class AsyncWindowPop implements WindowManager, Dispatcher, ForegroundChecker.OnForegroundChange {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final WindowManager f18139a;

    /* renamed from: b */
    private final Dispatcher f18140b;

    /* renamed from: c */
    private final AsyncWindow f18141c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final WindowManager.LayoutParams f18142d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f18143e;

    public AsyncWindowPop(Context context, AsyncWindow asyncWindow) {
        this(context, asyncWindow, (Dispatcher) null);
    }

    public AsyncWindowPop(Context context, AsyncWindow asyncWindow, Dispatcher dispatcher) {
        this.f18142d = new WindowManager.LayoutParams();
        this.f18141c = asyncWindow;
        this.f18139a = (WindowManager) context.getSystemService("window");
        if (dispatcher == null) {
            this.f18140b = new DefaultDispatcher();
        } else {
            this.f18140b = dispatcher;
        }
    }

    public void pop() {
        if (this.f18143e == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f18142d.type = 2038;
            } else {
                this.f18142d.type = 2002;
            }
            this.f18142d.format = -2;
            this.f18142d.height = -1;
            this.f18142d.width = -1;
            this.f18143e = this.f18141c.provideView();
            this.f18141c.onLayoutParams(this.f18142d);
            addView(this.f18143e, this.f18142d);
            ForegroundChecker.getIns().addChecker(this);
        }
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return this.f18142d;
    }

    public View getFloatView() {
        return this.f18143e;
    }

    public void cancel() {
        View view = this.f18143e;
        if (view != null) {
            removeView(view);
            this.f18143e = null;
        }
        ForegroundChecker.getIns().removeChecker(this);
    }

    public void onChange(final boolean z) {
        if (!this.f18141c.onForegroundChange(z) && this.f18143e != null) {
            this.f18140b.post(new Runnable() {
                public void run() {
                    if (z) {
                        AsyncWindowPop asyncWindowPop = AsyncWindowPop.this;
                        asyncWindowPop.addView(asyncWindowPop.f18143e, AsyncWindowPop.this.f18142d);
                        return;
                    }
                    AsyncWindowPop asyncWindowPop2 = AsyncWindowPop.this;
                    asyncWindowPop2.removeView(asyncWindowPop2.f18143e);
                }
            });
        }
    }

    public void post(Runnable runnable) {
        this.f18140b.post(runnable);
    }

    public void postDelay(Runnable runnable, long j) {
        this.f18140b.postDelay(runnable, j);
    }

    public Display getDefaultDisplay() {
        return this.f18139a.getDefaultDisplay();
    }

    public void removeViewImmediate(final View view) {
        this.f18140b.post(new Runnable() {
            public void run() {
                AsyncWindowPop.this.f18139a.removeViewImmediate(view);
            }
        });
    }

    public void addView(final View view, final ViewGroup.LayoutParams layoutParams) {
        this.f18140b.post(new Runnable() {
            public void run() {
                if (!view.isShown()) {
                    AsyncWindowPop.this.f18139a.addView(view, layoutParams);
                }
            }
        });
    }

    public void updateViewLayout(final View view, final ViewGroup.LayoutParams layoutParams) {
        this.f18140b.post(new Runnable() {
            public void run() {
                AsyncWindowPop.this.f18139a.updateViewLayout(view, layoutParams);
            }
        });
    }

    public void removeView(final View view) {
        this.f18140b.post(new Runnable() {
            public void run() {
                if (view.isShown()) {
                    AsyncWindowPop.this.f18139a.removeView(view);
                }
            }
        });
    }
}
