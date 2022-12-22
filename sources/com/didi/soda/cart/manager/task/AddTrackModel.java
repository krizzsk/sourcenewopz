package com.didi.soda.cart.manager.task;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/AddTrackModel;", "", "api", "", "mergeTimes", "", "session", "(Ljava/lang/String;ILjava/lang/String;)V", "getApi", "()Ljava/lang/String;", "getMergeTimes", "()I", "getSession", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartLoadingTrack.kt */
public final class AddTrackModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String setItemAmount = "2";
    public static final String setItemHasMduId = "0";
    public static final String setItemNoMduId = "1";

    /* renamed from: a */
    private final String f39995a;

    /* renamed from: b */
    private final int f39996b;

    /* renamed from: c */
    private final String f39997c;

    public AddTrackModel() {
        this((String) null, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AddTrackModel copy$default(AddTrackModel addTrackModel, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = addTrackModel.f39995a;
        }
        if ((i2 & 2) != 0) {
            i = addTrackModel.f39996b;
        }
        if ((i2 & 4) != 0) {
            str2 = addTrackModel.f39997c;
        }
        return addTrackModel.copy(str, i, str2);
    }

    public final String component1() {
        return this.f39995a;
    }

    public final int component2() {
        return this.f39996b;
    }

    public final String component3() {
        return this.f39997c;
    }

    public final AddTrackModel copy(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "api");
        Intrinsics.checkNotNullParameter(str2, "session");
        return new AddTrackModel(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddTrackModel)) {
            return false;
        }
        AddTrackModel addTrackModel = (AddTrackModel) obj;
        return Intrinsics.areEqual((Object) this.f39995a, (Object) addTrackModel.f39995a) && this.f39996b == addTrackModel.f39996b && Intrinsics.areEqual((Object) this.f39997c, (Object) addTrackModel.f39997c);
    }

    public int hashCode() {
        return (((this.f39995a.hashCode() * 31) + this.f39996b) * 31) + this.f39997c.hashCode();
    }

    public String toString() {
        return "AddTrackModel(api=" + this.f39995a + ", mergeTimes=" + this.f39996b + ", session=" + this.f39997c + VersionRange.RIGHT_OPEN;
    }

    public AddTrackModel(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "api");
        Intrinsics.checkNotNullParameter(str2, "session");
        this.f39995a = str;
        this.f39996b = i;
        this.f39997c = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddTrackModel(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "0" : str2);
    }

    public final String getApi() {
        return this.f39995a;
    }

    public final int getMergeTimes() {
        return this.f39996b;
    }

    public final String getSession() {
        return this.f39997c;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/AddTrackModel$Companion;", "", "()V", "setItemAmount", "", "setItemHasMduId", "setItemNoMduId", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartLoadingTrack.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
