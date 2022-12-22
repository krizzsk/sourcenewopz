package com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B{\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006\u00120\b\u0002\u0010\u0007\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0003J1\u0010\u001d\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\rHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000620\b\u0002\u0010\u0007\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R9\u0010\u0007\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/RequestOptions;", "", "url", "", "protocols", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "header", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "timeout", "", "tcpNoDelay", "", "perMessageDeflate", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;JZZ)V", "getHeader", "()Ljava/util/HashMap;", "getPerMessageDeflate", "()Z", "getProtocols", "()Ljava/util/ArrayList;", "getTcpNoDelay", "getTimeout", "()J", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RequestOptions.kt */
public final class RequestOptions {

    /* renamed from: a */
    private final String f17280a;

    /* renamed from: b */
    private final ArrayList<String> f17281b;

    /* renamed from: c */
    private final HashMap<String, String> f17282c;

    /* renamed from: d */
    private final long f17283d;

    /* renamed from: e */
    private final boolean f17284e;

    /* renamed from: f */
    private final boolean f17285f;

    public RequestOptions(String str, ArrayList<String> arrayList, long j) {
        this(str, arrayList, (HashMap) null, j, false, false, 52, (DefaultConstructorMarker) null);
    }

    public RequestOptions(String str, ArrayList<String> arrayList, HashMap<String, String> hashMap, long j) {
        this(str, arrayList, hashMap, j, false, false, 48, (DefaultConstructorMarker) null);
    }

    public RequestOptions(String str, ArrayList<String> arrayList, HashMap<String, String> hashMap, long j, boolean z) {
        this(str, arrayList, hashMap, j, z, false, 32, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RequestOptions copy$default(RequestOptions requestOptions, String str, ArrayList<String> arrayList, HashMap<String, String> hashMap, long j, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestOptions.f17280a;
        }
        if ((i & 2) != 0) {
            arrayList = requestOptions.f17281b;
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((i & 4) != 0) {
            hashMap = requestOptions.f17282c;
        }
        HashMap<String, String> hashMap2 = hashMap;
        if ((i & 8) != 0) {
            j = requestOptions.f17283d;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            z = requestOptions.f17284e;
        }
        boolean z3 = z;
        if ((i & 32) != 0) {
            z2 = requestOptions.f17285f;
        }
        return requestOptions.copy(str, arrayList2, hashMap2, j2, z3, z2);
    }

    public final String component1() {
        return this.f17280a;
    }

    public final ArrayList<String> component2() {
        return this.f17281b;
    }

    public final HashMap<String, String> component3() {
        return this.f17282c;
    }

    public final long component4() {
        return this.f17283d;
    }

    public final boolean component5() {
        return this.f17284e;
    }

    public final boolean component6() {
        return this.f17285f;
    }

    public final RequestOptions copy(String str, ArrayList<String> arrayList, HashMap<String, String> hashMap, long j, boolean z, boolean z2) {
        return new RequestOptions(str, arrayList, hashMap, j, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestOptions)) {
            return false;
        }
        RequestOptions requestOptions = (RequestOptions) obj;
        return Intrinsics.areEqual((Object) this.f17280a, (Object) requestOptions.f17280a) && Intrinsics.areEqual((Object) this.f17281b, (Object) requestOptions.f17281b) && Intrinsics.areEqual((Object) this.f17282c, (Object) requestOptions.f17282c) && this.f17283d == requestOptions.f17283d && this.f17284e == requestOptions.f17284e && this.f17285f == requestOptions.f17285f;
    }

    public int hashCode() {
        String str = this.f17280a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<String> arrayList = this.f17281b;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        HashMap<String, String> hashMap = this.f17282c;
        if (hashMap != null) {
            i = hashMap.hashCode();
        }
        long j = this.f17283d;
        int i2 = (((hashCode2 + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        boolean z = this.f17284e;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.f17285f;
        if (!z3) {
            z2 = z3;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "RequestOptions(url=" + this.f17280a + ", protocols=" + this.f17281b + ", header=" + this.f17282c + ", timeout=" + this.f17283d + ", tcpNoDelay=" + this.f17284e + ", perMessageDeflate=" + this.f17285f + ")";
    }

    public RequestOptions(String str, ArrayList<String> arrayList, HashMap<String, String> hashMap, long j, boolean z, boolean z2) {
        this.f17280a = str;
        this.f17281b = arrayList;
        this.f17282c = hashMap;
        this.f17283d = j;
        this.f17284e = z;
        this.f17285f = z2;
    }

    public final String getUrl() {
        return this.f17280a;
    }

    public final ArrayList<String> getProtocols() {
        return this.f17281b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestOptions(String str, ArrayList arrayList, HashMap hashMap, long j, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, arrayList, (i & 4) != 0 ? null : hashMap, j, (i & 16) != 0 ? true : z, (i & 32) != 0 ? true : z2);
    }

    public final HashMap<String, String> getHeader() {
        return this.f17282c;
    }

    public final long getTimeout() {
        return this.f17283d;
    }

    public final boolean getTcpNoDelay() {
        return this.f17284e;
    }

    public final boolean getPerMessageDeflate() {
        return this.f17285f;
    }
}
