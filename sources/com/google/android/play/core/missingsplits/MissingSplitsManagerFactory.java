package com.google.android.play.core.missingsplits;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public class MissingSplitsManagerFactory {

    /* renamed from: a */
    private static final AtomicReference<Boolean> f53199a = new AtomicReference<>((Object) null);

    public static MissingSplitsManager create(Context context) {
        return new C18521b(context, Runtime.getRuntime(), new C18520a(context, context.getPackageManager()), f53199a);
    }
}
