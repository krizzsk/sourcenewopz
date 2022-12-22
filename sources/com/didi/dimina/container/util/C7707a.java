package com.didi.dimina.container.util;

import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/dimina/container/util/CpuTemperatureResult;", "", "filePath", "", "temp", "", "(Ljava/lang/String;I)V", "getFilePath", "()Ljava/lang/String;", "getTemp", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.dimina.container.util.a */
/* compiled from: PerformanceCanaryUtil.kt */
final class C7707a {

    /* renamed from: a */
    private final String f17974a;

    /* renamed from: b */
    private final int f17975b;

    public C7707a() {
        this((String) null, 0, 3, (DefaultConstructorMarker) null);
    }

    /* renamed from: a */
    public static /* synthetic */ C7707a m13440a(C7707a aVar, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aVar.f17974a;
        }
        if ((i2 & 2) != 0) {
            i = aVar.f17975b;
        }
        return aVar.mo56953a(str, i);
    }

    /* renamed from: a */
    public final C7707a mo56953a(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, FlutterShareMethod.filePathKey);
        return new C7707a(str, i);
    }

    /* renamed from: c */
    public final String mo56956c() {
        return this.f17974a;
    }

    /* renamed from: d */
    public final int mo56957d() {
        return this.f17975b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7707a)) {
            return false;
        }
        C7707a aVar = (C7707a) obj;
        return Intrinsics.areEqual((Object) this.f17974a, (Object) aVar.f17974a) && this.f17975b == aVar.f17975b;
    }

    public int hashCode() {
        String str = this.f17974a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f17975b;
    }

    public String toString() {
        return "CpuTemperatureResult(filePath=" + this.f17974a + ", temp=" + this.f17975b + ")";
    }

    public C7707a(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, FlutterShareMethod.filePathKey);
        this.f17974a = str;
        this.f17975b = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C7707a(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    /* renamed from: a */
    public final String mo56954a() {
        return this.f17974a;
    }

    /* renamed from: b */
    public final int mo56955b() {
        return this.f17975b;
    }
}
