package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/ListData;", "", "pages", "", "refererRelationTotalVo", "Lcom/didi/component/framework/pages/invitation/model/RefererRelationTotalVo;", "total", "(Ljava/lang/Long;Lcom/didi/component/framework/pages/invitation/model/RefererRelationTotalVo;Ljava/lang/Long;)V", "getPages", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRefererRelationTotalVo", "()Lcom/didi/component/framework/pages/invitation/model/RefererRelationTotalVo;", "getTotal", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Lcom/didi/component/framework/pages/invitation/model/RefererRelationTotalVo;Ljava/lang/Long;)Lcom/didi/component/framework/pages/invitation/model/ListData;", "equals", "", "other", "hashCode", "", "toString", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InviteListModel.kt */
public final class ListData {
    private final Long pages;
    private final RefererRelationTotalVo refererRelationTotalVo;
    private final Long total;

    public static /* synthetic */ ListData copy$default(ListData listData, Long l, RefererRelationTotalVo refererRelationTotalVo2, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = listData.pages;
        }
        if ((i & 2) != 0) {
            refererRelationTotalVo2 = listData.refererRelationTotalVo;
        }
        if ((i & 4) != 0) {
            l2 = listData.total;
        }
        return listData.copy(l, refererRelationTotalVo2, l2);
    }

    public final Long component1() {
        return this.pages;
    }

    public final RefererRelationTotalVo component2() {
        return this.refererRelationTotalVo;
    }

    public final Long component3() {
        return this.total;
    }

    public final ListData copy(Long l, RefererRelationTotalVo refererRelationTotalVo2, Long l2) {
        return new ListData(l, refererRelationTotalVo2, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListData)) {
            return false;
        }
        ListData listData = (ListData) obj;
        return Intrinsics.areEqual((Object) this.pages, (Object) listData.pages) && Intrinsics.areEqual((Object) this.refererRelationTotalVo, (Object) listData.refererRelationTotalVo) && Intrinsics.areEqual((Object) this.total, (Object) listData.total);
    }

    public int hashCode() {
        Long l = this.pages;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        RefererRelationTotalVo refererRelationTotalVo2 = this.refererRelationTotalVo;
        int hashCode2 = (hashCode + (refererRelationTotalVo2 == null ? 0 : refererRelationTotalVo2.hashCode())) * 31;
        Long l2 = this.total;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ListData(pages=" + this.pages + ", refererRelationTotalVo=" + this.refererRelationTotalVo + ", total=" + this.total + VersionRange.RIGHT_OPEN;
    }

    public ListData(Long l, RefererRelationTotalVo refererRelationTotalVo2, Long l2) {
        this.pages = l;
        this.refererRelationTotalVo = refererRelationTotalVo2;
        this.total = l2;
    }

    public final Long getPages() {
        return this.pages;
    }

    public final RefererRelationTotalVo getRefererRelationTotalVo() {
        return this.refererRelationTotalVo;
    }

    public final Long getTotal() {
        return this.total;
    }
}
