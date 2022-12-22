package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/AddressBookAuthorization;", "", "referContactText", "", "title", "text", "buttonText", "pictureUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "getPictureUrl", "setPictureUrl", "getReferContactText", "setReferContactText", "getText", "setText", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageModel.kt */
public final class AddressBookAuthorization {
    private String buttonText;
    private String pictureUrl;
    private String referContactText;
    private String text;
    private String title;

    public static /* synthetic */ AddressBookAuthorization copy$default(AddressBookAuthorization addressBookAuthorization, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addressBookAuthorization.referContactText;
        }
        if ((i & 2) != 0) {
            str2 = addressBookAuthorization.title;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = addressBookAuthorization.text;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = addressBookAuthorization.buttonText;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = addressBookAuthorization.pictureUrl;
        }
        return addressBookAuthorization.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.referContactText;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.buttonText;
    }

    public final String component5() {
        return this.pictureUrl;
    }

    public final AddressBookAuthorization copy(String str, String str2, String str3, String str4, String str5) {
        return new AddressBookAuthorization(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressBookAuthorization)) {
            return false;
        }
        AddressBookAuthorization addressBookAuthorization = (AddressBookAuthorization) obj;
        return Intrinsics.areEqual((Object) this.referContactText, (Object) addressBookAuthorization.referContactText) && Intrinsics.areEqual((Object) this.title, (Object) addressBookAuthorization.title) && Intrinsics.areEqual((Object) this.text, (Object) addressBookAuthorization.text) && Intrinsics.areEqual((Object) this.buttonText, (Object) addressBookAuthorization.buttonText) && Intrinsics.areEqual((Object) this.pictureUrl, (Object) addressBookAuthorization.pictureUrl);
    }

    public int hashCode() {
        String str = this.referContactText;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.text;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.buttonText;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.pictureUrl;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "AddressBookAuthorization(referContactText=" + this.referContactText + ", title=" + this.title + ", text=" + this.text + ", buttonText=" + this.buttonText + ", pictureUrl=" + this.pictureUrl + VersionRange.RIGHT_OPEN;
    }

    public AddressBookAuthorization(String str, String str2, String str3, String str4, String str5) {
        this.referContactText = str;
        this.title = str2;
        this.text = str3;
        this.buttonText = str4;
        this.pictureUrl = str5;
    }

    public final String getReferContactText() {
        return this.referContactText;
    }

    public final void setReferContactText(String str) {
        this.referContactText = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final String getPictureUrl() {
        return this.pictureUrl;
    }

    public final void setPictureUrl(String str) {
        this.pictureUrl = str;
    }
}
