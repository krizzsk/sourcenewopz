package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TabsEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "tabs", "", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "(Ljava/util/List;)V", "getTabs", "()Ljava/util/List;", "setTabs", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabsEntity.kt */
public final class TabsEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -5749081394823318105L;
    private List<TabInfoEntity> tabs;

    public TabsEntity() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TabsEntity copy$default(TabsEntity tabsEntity, List<TabInfoEntity> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tabsEntity.tabs;
        }
        return tabsEntity.copy(list);
    }

    public final List<TabInfoEntity> component1() {
        return this.tabs;
    }

    public final TabsEntity copy(List<TabInfoEntity> list) {
        return new TabsEntity(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TabsEntity) && Intrinsics.areEqual((Object) this.tabs, (Object) ((TabsEntity) obj).tabs);
    }

    public int hashCode() {
        List<TabInfoEntity> list = this.tabs;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "TabsEntity(tabs=" + this.tabs + VersionRange.RIGHT_OPEN;
    }

    public TabsEntity(List<TabInfoEntity> list) {
        this.tabs = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabsEntity(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<TabInfoEntity> getTabs() {
        return this.tabs;
    }

    public final void setTabs(List<TabInfoEntity> list) {
        this.tabs = list;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TabsEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TabsEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
