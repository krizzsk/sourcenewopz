package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ToastInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "content", "", "needRefresh", "", "(Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getNeedRefresh", "()I", "setNeedRefresh", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ToastInfoEntity.kt */
public final class ToastInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -8309845556370745141L;
    private String content;
    private int needRefresh;

    public ToastInfoEntity() {
        this((String) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ToastInfoEntity copy$default(ToastInfoEntity toastInfoEntity, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = toastInfoEntity.content;
        }
        if ((i2 & 2) != 0) {
            i = toastInfoEntity.needRefresh;
        }
        return toastInfoEntity.copy(str, i);
    }

    public final String component1() {
        return this.content;
    }

    public final int component2() {
        return this.needRefresh;
    }

    public final ToastInfoEntity copy(String str, int i) {
        return new ToastInfoEntity(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ToastInfoEntity)) {
            return false;
        }
        ToastInfoEntity toastInfoEntity = (ToastInfoEntity) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) toastInfoEntity.content) && this.needRefresh == toastInfoEntity.needRefresh;
    }

    public int hashCode() {
        String str = this.content;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.needRefresh;
    }

    public String toString() {
        return "ToastInfoEntity(content=" + this.content + ", needRefresh=" + this.needRefresh + VersionRange.RIGHT_OPEN;
    }

    public ToastInfoEntity(String str, int i) {
        this.content = str;
        this.needRefresh = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ToastInfoEntity(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final int getNeedRefresh() {
        return this.needRefresh;
    }

    public final void setNeedRefresh(int i) {
        this.needRefresh = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ToastInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ToastInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
