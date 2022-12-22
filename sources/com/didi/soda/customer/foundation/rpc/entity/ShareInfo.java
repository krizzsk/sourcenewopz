package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ShareInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "type", "", "data", "Lcom/didi/soda/customer/foundation/rpc/entity/ShareData;", "(Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/ShareData;)V", "getData", "()Lcom/didi/soda/customer/foundation/rpc/entity/ShareData;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class ShareInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 8990377198617298729L;
    private final ShareData data;
    private final String type;

    public ShareInfo() {
        this((String) null, (ShareData) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShareInfo copy$default(ShareInfo shareInfo, String str, ShareData shareData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareInfo.type;
        }
        if ((i & 2) != 0) {
            shareData = shareInfo.data;
        }
        return shareInfo.copy(str, shareData);
    }

    public final String component1() {
        return this.type;
    }

    public final ShareData component2() {
        return this.data;
    }

    public final ShareInfo copy(String str, ShareData shareData) {
        return new ShareInfo(str, shareData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareInfo)) {
            return false;
        }
        ShareInfo shareInfo = (ShareInfo) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) shareInfo.type) && Intrinsics.areEqual((Object) this.data, (Object) shareInfo.data);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ShareData shareData = this.data;
        if (shareData != null) {
            i = shareData.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShareInfo(type=" + this.type + ", data=" + this.data + VersionRange.RIGHT_OPEN;
    }

    public ShareInfo(String str, ShareData shareData) {
        this.type = str;
        this.data = shareData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareInfo(String str, ShareData shareData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : shareData);
    }

    public final String getType() {
        return this.type;
    }

    public final ShareData getData() {
        return this.data;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ShareInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
