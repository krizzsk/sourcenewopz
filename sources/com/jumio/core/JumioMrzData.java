package com.jumio.core;

import com.jumio.core.enums.MRZFormat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010)\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010-\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\"\u00101\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 ¨\u00064"}, mo175978d2 = {"Lcom/jumio/core/JumioMrzData;", "Ljava/io/Serializable;", "", "a", "Ljava/lang/String;", "getMrzLine1", "()Ljava/lang/String;", "setMrzLine1", "(Ljava/lang/String;)V", "mrzLine1", "b", "getMrzLine2", "setMrzLine2", "mrzLine2", "c", "getMrzLine3", "setMrzLine3", "mrzLine3", "Lcom/jumio/core/enums/MRZFormat;", "d", "Lcom/jumio/core/enums/MRZFormat;", "getFormat", "()Lcom/jumio/core/enums/MRZFormat;", "setFormat", "(Lcom/jumio/core/enums/MRZFormat;)V", "format", "", "e", "Z", "getDobValid", "()Z", "setDobValid", "(Z)V", "dobValid", "f", "getIdNumberValid", "setIdNumberValid", "idNumberValid", "g", "getExpiryDateValid", "setExpiryDateValid", "expiryDateValid", "h", "getPersonalNumberValid", "setPersonalNumberValid", "personalNumberValid", "i", "getCompositeValid", "setCompositeValid", "compositeValid", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioMrzData.kt */
public final class JumioMrzData implements Serializable {

    /* renamed from: a */
    public String f54606a;

    /* renamed from: b */
    public String f54607b;

    /* renamed from: c */
    public String f54608c;

    /* renamed from: d */
    public MRZFormat f54609d = MRZFormat.MRP;

    /* renamed from: e */
    public boolean f54610e;

    /* renamed from: f */
    public boolean f54611f;

    /* renamed from: g */
    public boolean f54612g;

    /* renamed from: h */
    public boolean f54613h = true;

    /* renamed from: i */
    public boolean f54614i;

    public final boolean getCompositeValid() {
        return this.f54614i;
    }

    public final boolean getDobValid() {
        return this.f54610e;
    }

    public final boolean getExpiryDateValid() {
        return this.f54612g;
    }

    public final MRZFormat getFormat() {
        return this.f54609d;
    }

    public final boolean getIdNumberValid() {
        return this.f54611f;
    }

    public final String getMrzLine1() {
        return this.f54606a;
    }

    public final String getMrzLine2() {
        return this.f54607b;
    }

    public final String getMrzLine3() {
        return this.f54608c;
    }

    public final boolean getPersonalNumberValid() {
        return this.f54613h;
    }

    public final void setCompositeValid(boolean z) {
        this.f54614i = z;
    }

    public final void setDobValid(boolean z) {
        this.f54610e = z;
    }

    public final void setExpiryDateValid(boolean z) {
        this.f54612g = z;
    }

    public final void setFormat(MRZFormat mRZFormat) {
        Intrinsics.checkNotNullParameter(mRZFormat, "<set-?>");
        this.f54609d = mRZFormat;
    }

    public final void setIdNumberValid(boolean z) {
        this.f54611f = z;
    }

    public final void setMrzLine1(String str) {
        this.f54606a = str;
    }

    public final void setMrzLine2(String str) {
        this.f54607b = str;
    }

    public final void setMrzLine3(String str) {
        this.f54608c = str;
    }

    public final void setPersonalNumberValid(boolean z) {
        this.f54613h = z;
    }
}
