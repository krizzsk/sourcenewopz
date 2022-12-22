package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/InviteContactsModel;", "", "data", "Lcom/didi/component/framework/pages/invitation/model/ContactsData;", "errmsg", "", "errno", "", "(Lcom/didi/component/framework/pages/invitation/model/ContactsData;Ljava/lang/String;Ljava/lang/Integer;)V", "getData", "()Lcom/didi/component/framework/pages/invitation/model/ContactsData;", "getErrmsg", "()Ljava/lang/String;", "getErrno", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Lcom/didi/component/framework/pages/invitation/model/ContactsData;Ljava/lang/String;Ljava/lang/Integer;)Lcom/didi/component/framework/pages/invitation/model/InviteContactsModel;", "equals", "", "other", "hashCode", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InviteContactsModel.kt */
public final class InviteContactsModel {
    private final ContactsData data;
    private final String errmsg;
    private final Integer errno;

    public static /* synthetic */ InviteContactsModel copy$default(InviteContactsModel inviteContactsModel, ContactsData contactsData, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            contactsData = inviteContactsModel.data;
        }
        if ((i & 2) != 0) {
            str = inviteContactsModel.errmsg;
        }
        if ((i & 4) != 0) {
            num = inviteContactsModel.errno;
        }
        return inviteContactsModel.copy(contactsData, str, num);
    }

    public final ContactsData component1() {
        return this.data;
    }

    public final String component2() {
        return this.errmsg;
    }

    public final Integer component3() {
        return this.errno;
    }

    public final InviteContactsModel copy(ContactsData contactsData, String str, Integer num) {
        return new InviteContactsModel(contactsData, str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InviteContactsModel)) {
            return false;
        }
        InviteContactsModel inviteContactsModel = (InviteContactsModel) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) inviteContactsModel.data) && Intrinsics.areEqual((Object) this.errmsg, (Object) inviteContactsModel.errmsg) && Intrinsics.areEqual((Object) this.errno, (Object) inviteContactsModel.errno);
    }

    public int hashCode() {
        ContactsData contactsData = this.data;
        int i = 0;
        int hashCode = (contactsData == null ? 0 : contactsData.hashCode()) * 31;
        String str = this.errmsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.errno;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "InviteContactsModel(data=" + this.data + ", errmsg=" + this.errmsg + ", errno=" + this.errno + VersionRange.RIGHT_OPEN;
    }

    public InviteContactsModel(ContactsData contactsData, String str, Integer num) {
        this.data = contactsData;
        this.errmsg = str;
        this.errno = num;
    }

    public final ContactsData getData() {
        return this.data;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final Integer getErrno() {
        return this.errno;
    }
}
