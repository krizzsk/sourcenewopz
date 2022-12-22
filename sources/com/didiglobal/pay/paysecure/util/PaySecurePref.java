package com.didiglobal.pay.paysecure.util;

import android.graphics.Typeface;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/util/PaySecurePref;", "", "()V", "customFont", "Landroid/graphics/Typeface;", "getCustomFont", "()Landroid/graphics/Typeface;", "setCustomFont", "(Landroid/graphics/Typeface;)V", "pwdCount", "", "getPwdCount", "()I", "setPwdCount", "(I)V", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PaySecurePref.kt */
public final class PaySecurePref {
    public static final PaySecurePref INSTANCE = new PaySecurePref();

    /* renamed from: a */
    private static Typeface f50471a;

    /* renamed from: b */
    private static int f50472b = 4;

    private PaySecurePref() {
    }

    public final Typeface getCustomFont() {
        return f50471a;
    }

    public final void setCustomFont(Typeface typeface) {
        f50471a = typeface;
    }

    public final int getPwdCount() {
        return f50472b;
    }

    public final void setPwdCount(int i) {
        f50472b = i;
    }
}
