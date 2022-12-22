package com.didi.soda.customer.compose.action;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\rH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/customer/compose/action/StrategyConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "mBeginShowTime", "", "getMBeginShowTime", "()J", "setMBeginShowTime", "(J)V", "mShowCount", "", "getMShowCount", "()I", "setMShowCount", "(I)V", "mUniqueId", "", "getMUniqueId", "()Ljava/lang/String;", "setMUniqueId", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StrategyConfig.kt */
public final class StrategyConfig implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f40818a;

    /* renamed from: b */
    private long f40819b;

    /* renamed from: c */
    private int f40820c;

    public int describeContents() {
        return 0;
    }

    public StrategyConfig() {
    }

    public final String getMUniqueId() {
        return this.f40818a;
    }

    public final void setMUniqueId(String str) {
        this.f40818a = str;
    }

    public final long getMBeginShowTime() {
        return this.f40819b;
    }

    public final void setMBeginShowTime(long j) {
        this.f40819b = j;
    }

    public final int getMShowCount() {
        return this.f40820c;
    }

    public final void setMShowCount(int i) {
        this.f40820c = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StrategyConfig(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f40818a = parcel.readString();
        this.f40819b = parcel.readLong();
        this.f40820c = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.f40818a);
        parcel.writeLong(this.f40819b);
        parcel.writeInt(this.f40820c);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/customer/compose/action/StrategyConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/soda/customer/compose/action/StrategyConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/soda/customer/compose/action/StrategyConfig;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StrategyConfig.kt */
    public static final class CREATOR implements Parcelable.Creator<StrategyConfig> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public StrategyConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StrategyConfig(parcel);
        }

        public StrategyConfig[] newArray(int i) {
            return new StrategyConfig[i];
        }
    }
}
