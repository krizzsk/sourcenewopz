package com.didi.app.nova.skeleton.image.glide;

import android.content.Context;
import android.os.Looper;
import com.bumptech.glide.RequestManager;
import com.didi.app.nova.skeleton.ScopeContext;

public final class SkeletonGlide {

    /* renamed from: a */
    private static final String f8457a = "KEY_SkeletonGlide_SUPPORT";

    /* renamed from: b */
    private static Context f8458b;

    public static void setup(Context context) {
        f8458b = context.getApplicationContext();
    }

    public static RequestManager with(ScopeContext scopeContext) {
        if (f8458b == null) {
            throw new IllegalStateException("Call setup(context) when application created.");
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            C3739a aVar = (C3739a) scopeContext.getObject(f8457a);
            if (aVar == null) {
                aVar = new C3739a(scopeContext, f8458b);
                scopeContext.attach(f8457a, aVar);
            }
            return aVar.mo40977a();
        } else {
            throw new IllegalStateException("Only call this method in main thread.");
        }
    }
}
