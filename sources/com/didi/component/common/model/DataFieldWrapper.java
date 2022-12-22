package com.didi.component.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/component/common/model/DataFieldWrapper;", "T", "", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/didi/component/common/model/DataFieldWrapper;", "equals", "", "other", "hashCode", "", "toString", "", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataFieldWrapper.kt */
public final class DataFieldWrapper<T> {
    private final T data;

    public static /* synthetic */ DataFieldWrapper copy$default(DataFieldWrapper dataFieldWrapper, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            t = dataFieldWrapper.data;
        }
        return dataFieldWrapper.copy(t);
    }

    public final T component1() {
        return this.data;
    }

    public final DataFieldWrapper<T> copy(T t) {
        return new DataFieldWrapper<>(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DataFieldWrapper) && Intrinsics.areEqual((Object) this.data, (Object) ((DataFieldWrapper) obj).data);
    }

    public int hashCode() {
        T t = this.data;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "DataFieldWrapper(data=" + this.data + VersionRange.RIGHT_OPEN;
    }

    public DataFieldWrapper(T t) {
        this.data = t;
    }

    public final T getData() {
        return this.data;
    }
}
