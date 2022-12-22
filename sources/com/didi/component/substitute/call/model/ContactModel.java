package com.didi.component.substitute.call.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/component/substitute/call/model/ContactModel;", "", "()V", "countryCode", "", "getCountryCode", "()Ljava/lang/String;", "setCountryCode", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "setId", "(J)V", "name", "getName", "setName", "phone", "getPhone", "setPhone", "type", "", "getType", "()I", "setType", "(I)V", "Companion", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ContactModel.kt */
public final class ContactModel {
    public static final int ADD = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DELETE = 2;
    public static final int GET = 0;

    /* renamed from: a */
    private int f16077a;

    /* renamed from: b */
    private long f16078b;

    /* renamed from: c */
    private String f16079c;

    /* renamed from: d */
    private String f16080d;

    /* renamed from: e */
    private String f16081e;

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/component/substitute/call/model/ContactModel$Companion;", "", "()V", "ADD", "", "DELETE", "GET", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ContactModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getType() {
        return this.f16077a;
    }

    public final void setType(int i) {
        this.f16077a = i;
    }

    public final long getId() {
        return this.f16078b;
    }

    public final void setId(long j) {
        this.f16078b = j;
    }

    public final String getName() {
        return this.f16079c;
    }

    public final void setName(String str) {
        this.f16079c = str;
    }

    public final String getPhone() {
        return this.f16080d;
    }

    public final void setPhone(String str) {
        this.f16080d = str;
    }

    public final String getCountryCode() {
        return this.f16081e;
    }

    public final void setCountryCode(String str) {
        this.f16081e = str;
    }
}
