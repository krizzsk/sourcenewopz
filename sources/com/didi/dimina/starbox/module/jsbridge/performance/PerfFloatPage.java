package com.didi.dimina.starbox.module.jsbridge.performance;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.util.PixUtil;
import com.didi.dimina.starbox.p107ui.windowpop.AsyncWindow;
import com.didi.dimina.starbox.p107ui.windowpop.AsyncWindowPop;
import com.didi.dimina.starbox.p107ui.windowpop.ClosePop;
import com.didi.dimina.starbox.util.AppCtxProvider;
import com.google.android.material.badge.BadgeDrawable;
import java.util.HashMap;

public class PerfFloatPage implements AsyncWindow, ClosePop.OnCloseCallback {
    public static final String KEY_MONITOR_IS_OPEN = "monitor_is_open_";

    /* renamed from: f */
    private static final HashMap<String, PerfFloatPage> f18068f = new HashMap<>();

    /* renamed from: a */
    private final AsyncWindowPop f18069a;

    /* renamed from: b */
    private final Context f18070b;

    /* renamed from: c */
    private final ClosePop f18071c;

    /* renamed from: d */
    private final String f18072d;

    /* renamed from: e */
    private PerfUI f18073e;

    public PerfFloatPage(Context context, String str) {
        this.f18070b = context;
        this.f18072d = str;
        this.f18069a = new AsyncWindowPop(context, this);
        this.f18071c = new ClosePop(context, (AsyncWindow) null, this);
    }

    public static void trigger(boolean z, String str) {
        if (z) {
            MMKVUtil instance = MMKVUtil.getInstance();
            instance.save(KEY_MONITOR_IS_OPEN + str, true);
            PerfFloatPage perfFloatPage = f18068f.get(str);
            if (perfFloatPage == null) {
                perfFloatPage = new PerfFloatPage(AppCtxProvider.getApp(), str);
                f18068f.put(str, perfFloatPage);
            }
            perfFloatPage.m13502a();
            return;
        }
        PerfFloatPage perfFloatPage2 = f18068f.get(str);
        if (perfFloatPage2 != null) {
            perfFloatPage2.onClose();
        }
    }

    public View provideView() {
        PerfUI perfUI = new PerfUI(this.f18070b, this.f18072d);
        this.f18073e = perfUI;
        return perfUI;
    }

    public void onLayoutParams(WindowManager.LayoutParams layoutParams) {
        layoutParams.flags = 24;
        layoutParams.width = PixUtil.dip2px(this.f18070b, 250.0f);
        layoutParams.height = PixUtil.dip2px(this.f18070b, 320.0f);
        layoutParams.gravity = BadgeDrawable.TOP_END;
    }

    /* renamed from: a */
    private void m13502a() {
        this.f18069a.pop();
        this.f18071c.pop();
    }

    public void onClose() {
        this.f18069a.cancel();
        PerfUI perfUI = this.f18073e;
        if (perfUI != null) {
            perfUI.cancel();
        }
        f18068f.remove(this.f18072d);
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(KEY_MONITOR_IS_OPEN + this.f18072d, false);
    }

    public boolean onForegroundChange(boolean z) {
        PerfUI perfUI = this.f18073e;
        if (perfUI == null) {
            return false;
        }
        perfUI.onChange(z);
        return false;
    }
}
