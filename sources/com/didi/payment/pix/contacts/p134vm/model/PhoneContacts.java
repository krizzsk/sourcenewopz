package com.didi.payment.pix.contacts.p134vm.model;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0000H\u0002J\u0006\u0010\u001c\u001a\u00020\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/payment/pix/contacts/vm/model/PhoneContacts;", "", "name", "", "phoneNum", "(Ljava/lang/String;Ljava/lang/String;)V", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "isFirstInGroup", "", "()Z", "setFirstInGroup", "(Z)V", "getName", "setName", "getPhoneNum", "setPhoneNum", "visibility", "", "getVisibility", "()I", "setVisibility", "(I)V", "compareTo", "other", "isValid", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.contacts.vm.model.PhoneContacts */
/* compiled from: PhoneContacts.kt */
public final class PhoneContacts implements Comparable<PhoneContacts> {

    /* renamed from: a */
    private String f31055a = "";

    /* renamed from: b */
    private boolean f31056b;

    /* renamed from: c */
    private int f31057c;
    public String name;
    public String phoneNum;

    public PhoneContacts(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "phoneNum");
        setName(str);
        setPhoneNum(str2);
    }

    public final String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPhoneNum() {
        String str = this.phoneNum;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("phoneNum");
        return null;
    }

    public final void setPhoneNum(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.phoneNum = str;
    }

    public final String getIconUrl() {
        return this.f31055a;
    }

    public final void setIconUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f31055a = str;
    }

    public final boolean isFirstInGroup() {
        return this.f31056b;
    }

    public final void setFirstInGroup(boolean z) {
        this.f31056b = z;
    }

    public final int getVisibility() {
        return this.f31057c;
    }

    public final void setVisibility(int i) {
        this.f31057c = i;
    }

    public int compareTo(PhoneContacts phoneContacts) {
        Intrinsics.checkNotNullParameter(phoneContacts, "other");
        if (TextUtils.isEmpty(getName())) {
            return -1;
        }
        if (TextUtils.isEmpty(phoneContacts.getName())) {
            return 1;
        }
        return getName().compareTo(phoneContacts.getName());
    }

    public final boolean isValid() {
        return !TextUtils.isEmpty(getName()) && !TextUtils.isEmpty(getPhoneNum());
    }
}
