package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/NoMoreLoginEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "url", "", "title", "btnDesc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBtnDesc", "()Ljava/lang/String;", "getTitle", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NoMoreLoginEntity.kt */
public final class NoMoreLoginEntity implements IEntity {
    private final String btnDesc;
    private final String title;
    private final String url;

    public static /* synthetic */ NoMoreLoginEntity copy$default(NoMoreLoginEntity noMoreLoginEntity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = noMoreLoginEntity.url;
        }
        if ((i & 2) != 0) {
            str2 = noMoreLoginEntity.title;
        }
        if ((i & 4) != 0) {
            str3 = noMoreLoginEntity.btnDesc;
        }
        return noMoreLoginEntity.copy(str, str2, str3);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.btnDesc;
    }

    public final NoMoreLoginEntity copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "btnDesc");
        return new NoMoreLoginEntity(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoMoreLoginEntity)) {
            return false;
        }
        NoMoreLoginEntity noMoreLoginEntity = (NoMoreLoginEntity) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) noMoreLoginEntity.url) && Intrinsics.areEqual((Object) this.title, (Object) noMoreLoginEntity.title) && Intrinsics.areEqual((Object) this.btnDesc, (Object) noMoreLoginEntity.btnDesc);
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.title.hashCode()) * 31) + this.btnDesc.hashCode();
    }

    public String toString() {
        return "NoMoreLoginEntity(url=" + this.url + ", title=" + this.title + ", btnDesc=" + this.btnDesc + VersionRange.RIGHT_OPEN;
    }

    public NoMoreLoginEntity(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "btnDesc");
        this.url = str;
        this.title = str2;
        this.btnDesc = str3;
    }

    public final String getBtnDesc() {
        return this.btnDesc;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }
}
