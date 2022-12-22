package com.google.android.play.core.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.IllegalFormatException;
import java.util.Locale;

/* renamed from: com.google.android.play.core.internal.ag */
public final class C18432ag {

    /* renamed from: a */
    private final String f53129a;

    public C18432ag(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        String valueOf2 = String.valueOf(str);
        this.f53129a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: a */
    private final int m37752a(int i, String str, Object[] objArr) {
        if (Log.isLoggable("PlayCore", i)) {
            return SystemUtils.log(4, "PlayCore", m37753a(this.f53129a, str, objArr), (Throwable) null, "com.google.android.play.core.internal.ag", -1);
        }
        return 0;
    }

    /* renamed from: a */
    private static String m37753a(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                IllegalFormatException illegalFormatException = e;
                String valueOf = String.valueOf(str2);
                SystemUtils.log(6, "PlayCore", valueOf.length() != 0 ? "Unable to format ".concat(valueOf) : new String("Unable to format "), illegalFormatException, "com.google.android.play.core.internal.ag", -1);
                String join = TextUtils.join(", ", objArr);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(join).length());
                sb.append(str2);
                sb.append(" [");
                sb.append(join);
                sb.append(Const.jaRight);
                str2 = sb.toString();
            }
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(" : ");
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: a */
    public final void mo149081a(String str, Object... objArr) {
        m37752a(3, str, objArr);
    }

    /* renamed from: a */
    public final void mo149082a(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            SystemUtils.log(6, "PlayCore", m37753a(this.f53129a, str, objArr), th, "com.google.android.play.core.internal.ag", -1);
        }
    }

    /* renamed from: b */
    public final void mo149083b(String str, Object... objArr) {
        m37752a(6, str, objArr);
    }

    /* renamed from: c */
    public final void mo149084c(String str, Object... objArr) {
        m37752a(4, str, objArr);
    }

    /* renamed from: d */
    public final void mo149085d(String str, Object... objArr) {
        m37752a(5, str, objArr);
    }
}
