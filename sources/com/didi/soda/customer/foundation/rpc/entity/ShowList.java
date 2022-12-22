package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ShowList;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "type", "", "key", "", "value", "", "bottomLink", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderShowListBottomLink;", "(ILjava/lang/String;Ljava/util/List;Lcom/didi/soda/customer/foundation/rpc/entity/OrderShowListBottomLink;)V", "getBottomLink", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderShowListBottomLink;", "getKey", "()Ljava/lang/String;", "getType", "()I", "getValue", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class ShowList implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 6362552671484350844L;
    private final OrderShowListBottomLink bottomLink;
    private final String key;
    private final int type;
    private final List<String> value;

    public ShowList() {
        this(0, (String) null, (List) null, (OrderShowListBottomLink) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShowList copy$default(ShowList showList, int i, String str, List<String> list, OrderShowListBottomLink orderShowListBottomLink, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = showList.type;
        }
        if ((i2 & 2) != 0) {
            str = showList.key;
        }
        if ((i2 & 4) != 0) {
            list = showList.value;
        }
        if ((i2 & 8) != 0) {
            orderShowListBottomLink = showList.bottomLink;
        }
        return showList.copy(i, str, list, orderShowListBottomLink);
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

    public final OrderShowListBottomLink component4() {
        return this.bottomLink;
    }

    public final ShowList copy(int i, String str, List<String> list, OrderShowListBottomLink orderShowListBottomLink) {
        return new ShowList(i, str, list, orderShowListBottomLink);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowList)) {
            return false;
        }
        ShowList showList = (ShowList) obj;
        return this.type == showList.type && Intrinsics.areEqual((Object) this.key, (Object) showList.key) && Intrinsics.areEqual((Object) this.value, (Object) showList.value) && Intrinsics.areEqual((Object) this.bottomLink, (Object) showList.bottomLink);
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.key;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.value;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        OrderShowListBottomLink orderShowListBottomLink = this.bottomLink;
        if (orderShowListBottomLink != null) {
            i2 = orderShowListBottomLink.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "ShowList(type=" + this.type + ", key=" + this.key + ", value=" + this.value + ", bottomLink=" + this.bottomLink + VersionRange.RIGHT_OPEN;
    }

    public ShowList(int i, String str, List<String> list, OrderShowListBottomLink orderShowListBottomLink) {
        this.type = i;
        this.key = str;
        this.value = list;
        this.bottomLink = orderShowListBottomLink;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShowList(int i, String str, List list, OrderShowListBottomLink orderShowListBottomLink, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : orderShowListBottomLink);
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

    public final OrderShowListBottomLink getBottomLink() {
        return this.bottomLink;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ShowList$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
