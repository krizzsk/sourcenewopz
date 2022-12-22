package com.didi.jacoco.p120ec;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\u000e\u0010\u001d\u001a\n \u001e*\u0004\u0018\u00010\u00030\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006 "}, mo175978d2 = {"Lcom/didi/jacoco/ec/CommitInfo;", "", "id", "", "shortMessage", "commitTime", "", "name", "emailAddress", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCommitTime", "()I", "getEmailAddress", "()Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "getName", "getShortMessage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toJson", "kotlin.jvm.PlatformType", "toString", "jacoco-store"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.jacoco.ec.CommitInfo */
/* compiled from: CommitInfo.kt */
public final class CommitInfo {
    private final int commitTime;
    private final String emailAddress;

    /* renamed from: id */
    private String f24383id;
    private final String name;
    private final String shortMessage;

    public static /* synthetic */ CommitInfo copy$default(CommitInfo commitInfo, String str, String str2, int i, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commitInfo.f24383id;
        }
        if ((i2 & 2) != 0) {
            str2 = commitInfo.shortMessage;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = commitInfo.commitTime;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = commitInfo.name;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = commitInfo.emailAddress;
        }
        return commitInfo.copy(str, str5, i3, str6, str4);
    }

    public final String component1() {
        return this.f24383id;
    }

    public final String component2() {
        return this.shortMessage;
    }

    public final int component3() {
        return this.commitTime;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.emailAddress;
    }

    public final CommitInfo copy(String str, String str2, int i, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "shortMessage");
        Intrinsics.checkParameterIsNotNull(str3, "name");
        Intrinsics.checkParameterIsNotNull(str4, "emailAddress");
        return new CommitInfo(str, str2, i, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommitInfo)) {
            return false;
        }
        CommitInfo commitInfo = (CommitInfo) obj;
        return Intrinsics.areEqual((Object) this.f24383id, (Object) commitInfo.f24383id) && Intrinsics.areEqual((Object) this.shortMessage, (Object) commitInfo.shortMessage) && this.commitTime == commitInfo.commitTime && Intrinsics.areEqual((Object) this.name, (Object) commitInfo.name) && Intrinsics.areEqual((Object) this.emailAddress, (Object) commitInfo.emailAddress);
    }

    public int hashCode() {
        String str = this.f24383id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.shortMessage;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.commitTime) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.emailAddress;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "CommitInfo(id=" + this.f24383id + ", shortMessage=" + this.shortMessage + ", commitTime=" + this.commitTime + ", name=" + this.name + ", emailAddress=" + this.emailAddress + ")";
    }

    public CommitInfo(String str, String str2, int i, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "shortMessage");
        Intrinsics.checkParameterIsNotNull(str3, "name");
        Intrinsics.checkParameterIsNotNull(str4, "emailAddress");
        this.f24383id = str;
        this.shortMessage = str2;
        this.commitTime = i;
        this.name = str3;
        this.emailAddress = str4;
    }

    public final String getId() {
        return this.f24383id;
    }

    public final void setId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f24383id = str;
    }

    public final String getShortMessage() {
        return this.shortMessage;
    }

    public final int getCommitTime() {
        return this.commitTime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEmailAddress() {
        return this.emailAddress;
    }

    public final String toJson() {
        return new Gson().toJson((Object) this);
    }
}
