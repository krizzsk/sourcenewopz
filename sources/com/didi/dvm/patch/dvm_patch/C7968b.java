package com.didi.dvm.patch.dvm_patch;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

/* renamed from: com.didi.dvm.patch.dvm_patch.b */
/* compiled from: EventTracker */
abstract class C7968b {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo59023a(String str, Map map);

    C7968b() {
    }

    /* renamed from: a */
    public static String m14426a(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
