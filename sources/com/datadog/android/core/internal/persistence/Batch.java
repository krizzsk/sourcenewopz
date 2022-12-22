package com.datadog.android.core.internal.persistence;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/Batch;", "", "id", "", "data", "", "(Ljava/lang/String;[B)V", "getData", "()[B", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Batch.kt */
public final class Batch {

    /* renamed from: a */
    private final String f3505a;

    /* renamed from: b */
    private final byte[] f3506b;

    public static /* synthetic */ Batch copy$default(Batch batch, String str, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = batch.f3505a;
        }
        if ((i & 2) != 0) {
            bArr = batch.f3506b;
        }
        return batch.copy(str, bArr);
    }

    public final String component1() {
        return this.f3505a;
    }

    public final byte[] component2() {
        return this.f3506b;
    }

    public final Batch copy(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(bArr, "data");
        return new Batch(str, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Batch)) {
            return false;
        }
        Batch batch = (Batch) obj;
        return Intrinsics.areEqual((Object) this.f3505a, (Object) batch.f3505a) && Intrinsics.areEqual((Object) this.f3506b, (Object) batch.f3506b);
    }

    public int hashCode() {
        return (this.f3505a.hashCode() * 31) + Arrays.hashCode(this.f3506b);
    }

    public String toString() {
        return "Batch(id=" + this.f3505a + ", data=" + Arrays.toString(this.f3506b) + VersionRange.RIGHT_OPEN;
    }

    public Batch(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.f3505a = str;
        this.f3506b = bArr;
    }

    public final String getId() {
        return this.f3505a;
    }

    public final byte[] getData() {
        return this.f3506b;
    }
}
