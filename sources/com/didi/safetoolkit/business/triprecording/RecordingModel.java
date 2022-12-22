package com.didi.safetoolkit.business.triprecording;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\bHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/safetoolkit/business/triprecording/RecordingModel;", "", "oid", "", "(Ljava/lang/String;)V", "getOid", "()Ljava/lang/String;", "recordLength", "", "getRecordLength", "()I", "setRecordLength", "(I)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingManager.kt */
public final class RecordingModel {

    /* renamed from: a */
    private int f34469a;

    /* renamed from: b */
    private final String f34470b;

    public static /* synthetic */ RecordingModel copy$default(RecordingModel recordingModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordingModel.f34470b;
        }
        return recordingModel.copy(str);
    }

    public final String component1() {
        return this.f34470b;
    }

    public final RecordingModel copy(String str) {
        Intrinsics.checkParameterIsNotNull(str, "oid");
        return new RecordingModel(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RecordingModel) && Intrinsics.areEqual((Object) this.f34470b, (Object) ((RecordingModel) obj).f34470b);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f34470b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RecordingModel(oid=" + this.f34470b + ")";
    }

    public RecordingModel(String str) {
        Intrinsics.checkParameterIsNotNull(str, "oid");
        this.f34470b = str;
    }

    public final String getOid() {
        return this.f34470b;
    }

    public final int getRecordLength() {
        return this.f34469a;
    }

    public final void setRecordLength(int i) {
        this.f34469a = i;
    }
}
