package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/ShowList;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "type", "", "key", "", "value", "", "(ILjava/lang/String;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getType", "()I", "getValue", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class ShowList implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 1173052085774648529L;
    private final String key;
    private final int type;
    private final List<String> value;

    public ShowList() {
        this(0, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShowList copy$default(ShowList showList, int i, String str, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = showList.type;
        }
        if ((i2 & 2) != 0) {
            str = showList.key;
        }
        if ((i2 & 4) != 0) {
            list = showList.value;
        }
        return showList.copy(i, str, list);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.key;
    }

    public final List<String> component3() {
        return this.value;
    }

    public final ShowList copy(int i, String str, List<String> list) {
        return new ShowList(i, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowList)) {
            return false;
        }
        ShowList showList = (ShowList) obj;
        return this.type == showList.type && Intrinsics.areEqual((Object) this.key, (Object) showList.key) && Intrinsics.areEqual((Object) this.value, (Object) showList.value);
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.key;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.value;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ShowList(type=" + this.type + ", key=" + this.key + ", value=" + this.value + VersionRange.RIGHT_OPEN;
    }

    public ShowList(int i, String str, List<String> list) {
        this.type = i;
        this.key = str;
        this.value = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShowList(int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : list);
    }

    public final int getType() {
        return this.type;
    }

    public final String getKey() {
        return this.key;
    }

    public final List<String> getValue() {
        return this.value;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/ShowList$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
