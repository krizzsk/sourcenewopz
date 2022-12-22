package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.splitcompat.C18546p;

/* renamed from: com.google.android.play.core.appupdate.w */
public final /* synthetic */ class C18287w {

    /* renamed from: a */
    private static C18289y f52686a;

    /* renamed from: a */
    static synchronized C18289y m37416a(Context context) {
        C18289y yVar;
        synchronized (C18287w.class) {
            if (f52686a == null) {
                C18288x xVar = new C18288x((byte[]) null);
                xVar.mo148839a(new C18271g(C18546p.m38075a(context)));
                f52686a = xVar.mo148838a();
            }
            yVar = f52686a;
        }
        return yVar;
    }
}
