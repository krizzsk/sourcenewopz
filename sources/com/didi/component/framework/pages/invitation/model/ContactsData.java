package com.didi.component.framework.pages.invitation.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B9\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/ContactsData;", "", "validPhoneList", "", "", "invalidPhoneList", "amount", "", "checkStatus", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCheckStatus", "getInvalidPhoneList", "()Ljava/util/List;", "getValidPhoneList", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/didi/component/framework/pages/invitation/model/ContactsData;", "equals", "", "other", "hashCode", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InviteContactsModel.kt */
public final class ContactsData {
    private final Integer amount;
    private final Integer checkStatus;
    private final List<String> invalidPhoneList;
    private final List<String> validPhoneList;

    public static /* synthetic */ ContactsData copy$default(ContactsData contactsData, List<String> list, List<String> list2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = contactsData.validPhoneList;
        }
        if ((i & 2) != 0) {
            list2 = contactsData.invalidPhoneList;
        }
        if ((i & 4) != 0) {
            num = contactsData.amount;
        }
        if ((i & 8) != 0) {
            num2 = contactsData.checkStatus;
        }
        return contactsData.copy(list, list2, num, num2);
    }

    public final List<String> component1() {
        return this.validPhoneList;
    }

    public final List<String> component2() {
        return this.invalidPhoneList;
    }

    public final Integer component3() {
        return this.amount;
    }

    public final Integer component4() {
        return this.checkStatus;
    }

    public final ContactsData copy(List<String> list, List<String> list2, Integer num, Integer num2) {
        return new ContactsData(list, list2, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactsData)) {
            return false;
        }
        ContactsData contactsData = (ContactsData) obj;
        return Intrinsics.areEqual((Object) this.validPhoneList, (Object) contactsData.validPhoneList) && Intrinsics.areEqual((Object) this.invalidPhoneList, (Object) contactsData.invalidPhoneList) && Intrinsics.areEqual((Object) this.amount, (Object) contactsData.amount) && Intrinsics.areEqual((Object) this.checkStatus, (Object) contactsData.checkStatus);
    }

    public int hashCode() {
        List<String> list = this.validPhoneList;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.invalidPhoneList;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num = this.amount;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.checkStatus;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ContactsData(validPhoneList=" + this.validPhoneList + ", invalidPhoneList=" + this.invalidPhoneList + ", amount=" + this.amount + ", checkStatus=" + this.checkStatus + VersionRange.RIGHT_OPEN;
    }

    public ContactsData(List<String> list, List<String> list2, Integer num, Integer num2) {
        this.validPhoneList = list;
        this.invalidPhoneList = list2;
        this.amount = num;
        this.checkStatus = num2;
    }

    public final List<String> getValidPhoneList() {
        return this.validPhoneList;
    }

    public final List<String> getInvalidPhoneList() {
        return this.invalidPhoneList;
    }

    public final Integer getAmount() {
        return this.amount;
    }

    public final Integer getCheckStatus() {
        return this.checkStatus;
    }
}
