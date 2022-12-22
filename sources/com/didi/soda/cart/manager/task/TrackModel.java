package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/TrackModel;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "item_id", "", "time", "", "", "copy_num", "", "(Ljava/lang/String;Ljava/util/List;I)V", "getCopy_num", "()I", "setCopy_num", "(I)V", "getItem_id", "()Ljava/lang/String;", "getTime", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartLoadingTrack.kt */
final class TrackModel implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -6888796634988303630L;
    private int copy_num;
    private final String item_id;
    private final List<Long> time;

    public static /* synthetic */ TrackModel copy$default(TrackModel trackModel, String str, List<Long> list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = trackModel.item_id;
        }
        if ((i2 & 2) != 0) {
            list = trackModel.time;
        }
        if ((i2 & 4) != 0) {
            i = trackModel.copy_num;
        }
        return trackModel.copy(str, list, i);
    }

    public final String component1() {
        return this.item_id;
    }

    public final List<Long> component2() {
        return this.time;
    }

    public final int component3() {
        return this.copy_num;
    }

    public final TrackModel copy(String str, List<Long> list, int i) {
        Intrinsics.checkNotNullParameter(str, "item_id");
        Intrinsics.checkNotNullParameter(list, "time");
        return new TrackModel(str, list, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackModel)) {
            return false;
        }
        TrackModel trackModel = (TrackModel) obj;
        return Intrinsics.areEqual((Object) this.item_id, (Object) trackModel.item_id) && Intrinsics.areEqual((Object) this.time, (Object) trackModel.time) && this.copy_num == trackModel.copy_num;
    }

    public int hashCode() {
        return (((this.item_id.hashCode() * 31) + this.time.hashCode()) * 31) + this.copy_num;
    }

    public String toString() {
        return "TrackModel(item_id=" + this.item_id + ", time=" + this.time + ", copy_num=" + this.copy_num + VersionRange.RIGHT_OPEN;
    }

    public TrackModel(String str, List<Long> list, int i) {
        Intrinsics.checkNotNullParameter(str, "item_id");
        Intrinsics.checkNotNullParameter(list, "time");
        this.item_id = str;
        this.time = list;
        this.copy_num = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrackModel(String str, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i2 & 4) != 0 ? 0 : i);
    }

    public final String getItem_id() {
        return this.item_id;
    }

    public final List<Long> getTime() {
        return this.time;
    }

    public final int getCopy_num() {
        return this.copy_num;
    }

    public final void setCopy_num(int i) {
        this.copy_num = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/TrackModel$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartLoadingTrack.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
