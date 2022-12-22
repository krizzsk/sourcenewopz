package com.global.didi.elvish.datetime.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J8\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010 \u001a\u00020\u0006H\u0016J\t\u0010!\u001a\u00020\bHÖ\u0001R&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, mo175978d2 = {"Lcom/global/didi/elvish/datetime/model/OffsetModel;", "", "interval", "", "", "offset", "", "mapping", "", "([Ljava/lang/Long;[Ljava/lang/Integer;Ljava/lang/String;)V", "getInterval", "()[Ljava/lang/Long;", "setInterval", "([Ljava/lang/Long;)V", "[Ljava/lang/Long;", "getMapping", "()Ljava/lang/String;", "setMapping", "(Ljava/lang/String;)V", "getOffset", "()[Ljava/lang/Integer;", "setOffset", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "([Ljava/lang/Long;[Ljava/lang/Integer;Ljava/lang/String;)Lcom/global/didi/elvish/datetime/model/OffsetModel;", "equals", "", "other", "hashCode", "toString", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TimezoneOffsetModel.kt */
public final class OffsetModel {
    @SerializedName("interval")
    private Long[] interval;
    @SerializedName("mapping")
    private String mapping;
    @SerializedName("offset")
    private Integer[] offset;

    public OffsetModel() {
        this((Long[]) null, (Integer[]) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OffsetModel copy$default(OffsetModel offsetModel, Long[] lArr, Integer[] numArr, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            lArr = offsetModel.interval;
        }
        if ((i & 2) != 0) {
            numArr = offsetModel.offset;
        }
        if ((i & 4) != 0) {
            str = offsetModel.mapping;
        }
        return offsetModel.copy(lArr, numArr, str);
    }

    public final Long[] component1() {
        return this.interval;
    }

    public final Integer[] component2() {
        return this.offset;
    }

    public final String component3() {
        return this.mapping;
    }

    public final OffsetModel copy(Long[] lArr, Integer[] numArr, String str) {
        Intrinsics.checkParameterIsNotNull(lArr, "interval");
        Intrinsics.checkParameterIsNotNull(numArr, TypedValues.CycleType.S_WAVE_OFFSET);
        Intrinsics.checkParameterIsNotNull(str, "mapping");
        return new OffsetModel(lArr, numArr, str);
    }

    public String toString() {
        return "OffsetModel(interval=" + Arrays.toString(this.interval) + ", offset=" + Arrays.toString(this.offset) + ", mapping=" + this.mapping + ")";
    }

    public OffsetModel(Long[] lArr, Integer[] numArr, String str) {
        Intrinsics.checkParameterIsNotNull(lArr, "interval");
        Intrinsics.checkParameterIsNotNull(numArr, TypedValues.CycleType.S_WAVE_OFFSET);
        Intrinsics.checkParameterIsNotNull(str, "mapping");
        this.interval = lArr;
        this.offset = numArr;
        this.mapping = str;
    }

    public final Long[] getInterval() {
        return this.interval;
    }

    public final void setInterval(Long[] lArr) {
        Intrinsics.checkParameterIsNotNull(lArr, "<set-?>");
        this.interval = lArr;
    }

    public final Integer[] getOffset() {
        return this.offset;
    }

    public final void setOffset(Integer[] numArr) {
        Intrinsics.checkParameterIsNotNull(numArr, "<set-?>");
        this.offset = numArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OffsetModel(Long[] lArr, Integer[] numArr, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Long[0] : lArr, (i & 2) != 0 ? new Integer[0] : numArr, (i & 4) != 0 ? "" : str);
    }

    public final String getMapping() {
        return this.mapping;
    }

    public final void setMapping(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.mapping = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            OffsetModel offsetModel = (OffsetModel) obj;
            if (Arrays.equals(this.interval, offsetModel.interval) && Arrays.equals(this.offset, offsetModel.offset) && !(!Intrinsics.areEqual((Object) this.mapping, (Object) offsetModel.mapping))) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.global.didi.elvish.datetime.model.OffsetModel");
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.interval) * 31) + Arrays.hashCode(this.offset)) * 31) + this.mapping.hashCode();
    }
}
