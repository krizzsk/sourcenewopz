package com.global.didi.elvish.datetime.model;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, mo175978d2 = {"Lcom/global/didi/elvish/datetime/model/TimezoneOffsetModel;", "", "offset", "", "(J)V", "getOffset", "()J", "setOffset", "offsetMap", "", "", "Lcom/global/didi/elvish/datetime/model/OffsetModel;", "getOffsetMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TimezoneOffsetModel.kt */
public final class TimezoneOffsetModel {
    @SerializedName("offset")
    private long offset;
    @SerializedName("timezones")
    private final Map<String, OffsetModel> offsetMap;

    public TimezoneOffsetModel() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TimezoneOffsetModel copy$default(TimezoneOffsetModel timezoneOffsetModel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = timezoneOffsetModel.offset;
        }
        return timezoneOffsetModel.copy(j);
    }

    public final long component1() {
        return this.offset;
    }

    public final TimezoneOffsetModel copy(long j) {
        return new TimezoneOffsetModel(j);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TimezoneOffsetModel) {
                if (this.offset == ((TimezoneOffsetModel) obj).offset) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.offset;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "TimezoneOffsetModel(offset=" + this.offset + ")";
    }

    public TimezoneOffsetModel(long j) {
        this.offset = j;
        this.offsetMap = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimezoneOffsetModel(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : j);
    }

    public final long getOffset() {
        return this.offset;
    }

    public final void setOffset(long j) {
        this.offset = j;
    }

    public final Map<String, OffsetModel> getOffsetMap() {
        return this.offsetMap;
    }
}
