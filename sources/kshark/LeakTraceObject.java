package kshark;

import java.io.Serializable;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kshark.internal.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002+,B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003JK\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000f¨\u0006-"}, mo175978d2 = {"Lkshark/LeakTraceObject;", "Ljava/io/Serializable;", "objectId", "", "type", "Lkshark/LeakTraceObject$ObjectType;", "className", "", "labels", "", "leakingStatus", "Lkshark/LeakTraceObject$LeakingStatus;", "leakingStatusReason", "(JLkshark/LeakTraceObject$ObjectType;Ljava/lang/String;Ljava/util/Set;Lkshark/LeakTraceObject$LeakingStatus;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "classSimpleName", "getClassSimpleName", "getLabels", "()Ljava/util/Set;", "getLeakingStatus", "()Lkshark/LeakTraceObject$LeakingStatus;", "getLeakingStatusReason", "getObjectId", "()J", "getType", "()Lkshark/LeakTraceObject$ObjectType;", "typeName", "getTypeName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "LeakingStatus", "ObjectType", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LeakTraceObject.kt */
public final class LeakTraceObject implements Serializable {
    private final String className;
    private final Set<String> labels;
    private final LeakingStatus leakingStatus;
    private final String leakingStatusReason;
    private final long objectId;
    private final ObjectType type;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"Lkshark/LeakTraceObject$LeakingStatus;", "", "(Ljava/lang/String;I)V", "NOT_LEAKING", "LEAKING", "UNKNOWN", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: LeakTraceObject.kt */
    public enum LeakingStatus {
        NOT_LEAKING,
        LEAKING,
        UNKNOWN
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"Lkshark/LeakTraceObject$ObjectType;", "", "(Ljava/lang/String;I)V", "CLASS", "ARRAY", "INSTANCE", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: LeakTraceObject.kt */
    public enum ObjectType {
        CLASS,
        ARRAY,
        INSTANCE
    }

    public static /* synthetic */ LeakTraceObject copy$default(LeakTraceObject leakTraceObject, long j, ObjectType objectType, String str, Set set, LeakingStatus leakingStatus2, String str2, int i, Object obj) {
        LeakTraceObject leakTraceObject2 = leakTraceObject;
        return leakTraceObject.copy((i & 1) != 0 ? leakTraceObject2.objectId : j, (i & 2) != 0 ? leakTraceObject2.type : objectType, (i & 4) != 0 ? leakTraceObject2.className : str, (i & 8) != 0 ? leakTraceObject2.labels : set, (i & 16) != 0 ? leakTraceObject2.leakingStatus : leakingStatus2, (i & 32) != 0 ? leakTraceObject2.leakingStatusReason : str2);
    }

    public final long component1() {
        return this.objectId;
    }

    public final ObjectType component2() {
        return this.type;
    }

    public final String component3() {
        return this.className;
    }

    public final Set<String> component4() {
        return this.labels;
    }

    public final LeakingStatus component5() {
        return this.leakingStatus;
    }

    public final String component6() {
        return this.leakingStatusReason;
    }

    public final LeakTraceObject copy(long j, ObjectType objectType, String str, Set<String> set, LeakingStatus leakingStatus2, String str2) {
        Intrinsics.checkParameterIsNotNull(objectType, "type");
        Intrinsics.checkParameterIsNotNull(str, "className");
        Intrinsics.checkParameterIsNotNull(set, "labels");
        Intrinsics.checkParameterIsNotNull(leakingStatus2, "leakingStatus");
        String str3 = str2;
        Intrinsics.checkParameterIsNotNull(str3, "leakingStatusReason");
        return new LeakTraceObject(j, objectType, str, set, leakingStatus2, str3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LeakTraceObject) {
                LeakTraceObject leakTraceObject = (LeakTraceObject) obj;
                if (!(this.objectId == leakTraceObject.objectId) || !Intrinsics.areEqual((Object) this.type, (Object) leakTraceObject.type) || !Intrinsics.areEqual((Object) this.className, (Object) leakTraceObject.className) || !Intrinsics.areEqual((Object) this.labels, (Object) leakTraceObject.labels) || !Intrinsics.areEqual((Object) this.leakingStatus, (Object) leakTraceObject.leakingStatus) || !Intrinsics.areEqual((Object) this.leakingStatusReason, (Object) leakTraceObject.leakingStatusReason)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.objectId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        ObjectType objectType = this.type;
        int i2 = 0;
        int hashCode = (i + (objectType != null ? objectType.hashCode() : 0)) * 31;
        String str = this.className;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Set<String> set = this.labels;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        LeakingStatus leakingStatus2 = this.leakingStatus;
        int hashCode4 = (hashCode3 + (leakingStatus2 != null ? leakingStatus2.hashCode() : 0)) * 31;
        String str2 = this.leakingStatusReason;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return "LeakTraceObject(objectId=" + this.objectId + ", type=" + this.type + ", className=" + this.className + ", labels=" + this.labels + ", leakingStatus=" + this.leakingStatus + ", leakingStatusReason=" + this.leakingStatusReason + ")";
    }

    public LeakTraceObject(long j, ObjectType objectType, String str, Set<String> set, LeakingStatus leakingStatus2, String str2) {
        Intrinsics.checkParameterIsNotNull(objectType, "type");
        Intrinsics.checkParameterIsNotNull(str, "className");
        Intrinsics.checkParameterIsNotNull(set, "labels");
        Intrinsics.checkParameterIsNotNull(leakingStatus2, "leakingStatus");
        Intrinsics.checkParameterIsNotNull(str2, "leakingStatusReason");
        this.objectId = j;
        this.type = objectType;
        this.className = str;
        this.labels = set;
        this.leakingStatus = leakingStatus2;
        this.leakingStatusReason = str2;
    }

    public final long getObjectId() {
        return this.objectId;
    }

    public final ObjectType getType() {
        return this.type;
    }

    public final String getClassName() {
        return this.className;
    }

    public final Set<String> getLabels() {
        return this.labels;
    }

    public final LeakingStatus getLeakingStatus() {
        return this.leakingStatus;
    }

    public final String getLeakingStatusReason() {
        return this.leakingStatusReason;
    }

    public final String getClassSimpleName() {
        return StringsKt.lastSegment(this.className, '.');
    }

    public final String getTypeName() {
        String name = this.type.name();
        Locale locale = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
        if (name != null) {
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
