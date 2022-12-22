package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u0015J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0016\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartMergeModel;", "", "runMergeTimes", "", "mergeWaitTime", "", "(IJ)V", "getMergeWaitTime", "()J", "setMergeWaitTime", "(J)V", "getRunMergeTimes", "()I", "setRunMergeTimes", "(I)V", "<set-?>", "", "timeList", "getTimeList", "()Ljava/util/List;", "clearMergeRecord", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "recordMerge", "toString", "", "track", "api", "session", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartMergeModel.kt */
public final class CartMergeModel {

    /* renamed from: a */
    private int f40000a;

    /* renamed from: b */
    private long f40001b;

    /* renamed from: c */
    private List<Long> f40002c;

    public CartMergeModel() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CartMergeModel copy$default(CartMergeModel cartMergeModel, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cartMergeModel.f40000a;
        }
        if ((i2 & 2) != 0) {
            j = cartMergeModel.f40001b;
        }
        return cartMergeModel.copy(i, j);
    }

    public final int component1() {
        return this.f40000a;
    }

    public final long component2() {
        return this.f40001b;
    }

    public final CartMergeModel copy(int i, long j) {
        return new CartMergeModel(i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartMergeModel)) {
            return false;
        }
        CartMergeModel cartMergeModel = (CartMergeModel) obj;
        return this.f40000a == cartMergeModel.f40000a && this.f40001b == cartMergeModel.f40001b;
    }

    public int hashCode() {
        return (this.f40000a * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f40001b);
    }

    public String toString() {
        return "CartMergeModel(runMergeTimes=" + this.f40000a + ", mergeWaitTime=" + this.f40001b + VersionRange.RIGHT_OPEN;
    }

    public CartMergeModel(int i, long j) {
        this.f40000a = i;
        this.f40001b = j;
        this.f40002c = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartMergeModel(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? -1 : j);
    }

    public final int getRunMergeTimes() {
        return this.f40000a;
    }

    public final void setRunMergeTimes(int i) {
        this.f40000a = i;
    }

    public final long getMergeWaitTime() {
        return this.f40001b;
    }

    public final void setMergeWaitTime(long j) {
        this.f40001b = j;
    }

    public final List<Long> getTimeList() {
        return this.f40002c;
    }

    public final void track(String str, String str2) {
        List list;
        Intrinsics.checkNotNullParameter(str, "api");
        Intrinsics.checkNotNullParameter(str2, "session");
        if (this.f40001b > 0) {
            this.f40001b = System.currentTimeMillis() - this.f40001b;
        }
        if (this.f40002c.size() > 0) {
            long longValue = ((Number) CollectionsKt.first(this.f40002c)).longValue();
            Iterable<Number> iterable = this.f40002c;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Number longValue2 : iterable) {
                long longValue3 = longValue2.longValue();
                arrayList.add(Long.valueOf(longValue3 - longValue));
                longValue = longValue3;
            }
            list = (List) arrayList;
        } else {
            list = CollectionsKt.emptyList();
        }
        FloatingCartOmegaHelper.Companion.trackAddTaskBegin(str, str2, this, list);
        clearMergeRecord();
    }

    public final void recordMerge() {
        this.f40000a++;
        if (this.f40001b == -1) {
            this.f40001b = System.currentTimeMillis();
            this.f40002c.clear();
        }
    }

    public final void clearMergeRecord() {
        this.f40000a = 0;
        this.f40001b = -1;
        this.f40002c.clear();
    }
}
