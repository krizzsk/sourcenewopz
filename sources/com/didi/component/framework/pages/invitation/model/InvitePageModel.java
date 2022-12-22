package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011¨\u0006$"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/InvitePageModel;", "", "data", "Lcom/didi/component/framework/pages/invitation/model/PageData;", "errmsg", "", "errno", "", "traceId", "(Lcom/didi/component/framework/pages/invitation/model/PageData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getData", "()Lcom/didi/component/framework/pages/invitation/model/PageData;", "setData", "(Lcom/didi/component/framework/pages/invitation/model/PageData;)V", "getErrmsg", "()Ljava/lang/String;", "setErrmsg", "(Ljava/lang/String;)V", "getErrno", "()Ljava/lang/Integer;", "setErrno", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTraceId", "setTraceId", "component1", "component2", "component3", "component4", "copy", "(Lcom/didi/component/framework/pages/invitation/model/PageData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/didi/component/framework/pages/invitation/model/InvitePageModel;", "equals", "", "other", "hashCode", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageModel.kt */
public final class InvitePageModel {
    private PageData data;
    private String errmsg;
    private Integer errno;
    private String traceId;

    public static /* synthetic */ InvitePageModel copy$default(InvitePageModel invitePageModel, PageData pageData, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            pageData = invitePageModel.data;
        }
        if ((i & 2) != 0) {
            str = invitePageModel.errmsg;
        }
        if ((i & 4) != 0) {
            num = invitePageModel.errno;
        }
        if ((i & 8) != 0) {
            str2 = invitePageModel.traceId;
        }
        return invitePageModel.copy(pageData, str, num, str2);
    }

    public final PageData component1() {
        return this.data;
    }

    public final String component2() {
        return this.errmsg;
    }

    public final Integer component3() {
        return this.errno;
    }

    public final String component4() {
        return this.traceId;
    }

    public final InvitePageModel copy(PageData pageData, String str, Integer num, String str2) {
        return new InvitePageModel(pageData, str, num, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InvitePageModel)) {
            return false;
        }
        InvitePageModel invitePageModel = (InvitePageModel) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) invitePageModel.data) && Intrinsics.areEqual((Object) this.errmsg, (Object) invitePageModel.errmsg) && Intrinsics.areEqual((Object) this.errno, (Object) invitePageModel.errno) && Intrinsics.areEqual((Object) this.traceId, (Object) invitePageModel.traceId);
    }

    public int hashCode() {
        PageData pageData = this.data;
        int i = 0;
        int hashCode = (pageData == null ? 0 : pageData.hashCode()) * 31;
        String str = this.errmsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.errno;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.traceId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "InvitePageModel(data=" + this.data + ", errmsg=" + this.errmsg + ", errno=" + this.errno + ", traceId=" + this.traceId + VersionRange.RIGHT_OPEN;
    }

    public InvitePageModel(PageData pageData, String str, Integer num, String str2) {
        this.data = pageData;
        this.errmsg = str;
        this.errno = num;
        this.traceId = str2;
    }

    public final PageData getData() {
        return this.data;
    }

    public final void setData(PageData pageData) {
        this.data = pageData;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final void setErrmsg(String str) {
        this.errmsg = str;
    }

    public final Integer getErrno() {
        return this.errno;
    }

    public final void setErrno(Integer num) {
        this.errno = num;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }
}
