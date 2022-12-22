package com.didiglobal.pay.paysecure.prepaidcard.resp;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp;", "Ljava/io/Serializable;", "noticePanelInfo", "Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp$NoticePanelInfo;", "(Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp$NoticePanelInfo;)V", "getNoticePanelInfo", "()Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp$NoticePanelInfo;", "setNoticePanelInfo", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "NoticePanelInfo", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: VerifyCardNoResp.kt */
public final class VerifyCardNoResp implements Serializable {
    private NoticePanelInfo noticePanelInfo;

    public static /* synthetic */ VerifyCardNoResp copy$default(VerifyCardNoResp verifyCardNoResp, NoticePanelInfo noticePanelInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            noticePanelInfo2 = verifyCardNoResp.noticePanelInfo;
        }
        return verifyCardNoResp.copy(noticePanelInfo2);
    }

    public final NoticePanelInfo component1() {
        return this.noticePanelInfo;
    }

    public final VerifyCardNoResp copy(NoticePanelInfo noticePanelInfo2) {
        return new VerifyCardNoResp(noticePanelInfo2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof VerifyCardNoResp) && Intrinsics.areEqual((Object) this.noticePanelInfo, (Object) ((VerifyCardNoResp) obj).noticePanelInfo);
        }
        return true;
    }

    public int hashCode() {
        NoticePanelInfo noticePanelInfo2 = this.noticePanelInfo;
        if (noticePanelInfo2 != null) {
            return noticePanelInfo2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "VerifyCardNoResp(noticePanelInfo=" + this.noticePanelInfo + ")";
    }

    public VerifyCardNoResp(NoticePanelInfo noticePanelInfo2) {
        this.noticePanelInfo = noticePanelInfo2;
    }

    public final NoticePanelInfo getNoticePanelInfo() {
        return this.noticePanelInfo;
    }

    public final void setNoticePanelInfo(NoticePanelInfo noticePanelInfo2) {
        this.noticePanelInfo = noticePanelInfo2;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp$NoticePanelInfo;", "Ljava/io/Serializable;", "cancelButton", "", "confirmButton", "subTitle", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCancelButton", "()Ljava/lang/String;", "setCancelButton", "(Ljava/lang/String;)V", "getConfirmButton", "setConfirmButton", "getSubTitle", "setSubTitle", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: VerifyCardNoResp.kt */
    public static final class NoticePanelInfo implements Serializable {
        private String cancelButton;
        private String confirmButton;
        private String subTitle;
        private String title;

        public static /* synthetic */ NoticePanelInfo copy$default(NoticePanelInfo noticePanelInfo, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noticePanelInfo.cancelButton;
            }
            if ((i & 2) != 0) {
                str2 = noticePanelInfo.confirmButton;
            }
            if ((i & 4) != 0) {
                str3 = noticePanelInfo.subTitle;
            }
            if ((i & 8) != 0) {
                str4 = noticePanelInfo.title;
            }
            return noticePanelInfo.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.cancelButton;
        }

        public final String component2() {
            return this.confirmButton;
        }

        public final String component3() {
            return this.subTitle;
        }

        public final String component4() {
            return this.title;
        }

        public final NoticePanelInfo copy(String str, String str2, String str3, String str4) {
            return new NoticePanelInfo(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NoticePanelInfo)) {
                return false;
            }
            NoticePanelInfo noticePanelInfo = (NoticePanelInfo) obj;
            return Intrinsics.areEqual((Object) this.cancelButton, (Object) noticePanelInfo.cancelButton) && Intrinsics.areEqual((Object) this.confirmButton, (Object) noticePanelInfo.confirmButton) && Intrinsics.areEqual((Object) this.subTitle, (Object) noticePanelInfo.subTitle) && Intrinsics.areEqual((Object) this.title, (Object) noticePanelInfo.title);
        }

        public int hashCode() {
            String str = this.cancelButton;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.confirmButton;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.subTitle;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.title;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "NoticePanelInfo(cancelButton=" + this.cancelButton + ", confirmButton=" + this.confirmButton + ", subTitle=" + this.subTitle + ", title=" + this.title + ")";
        }

        public NoticePanelInfo(String str, String str2, String str3, String str4) {
            this.cancelButton = str;
            this.confirmButton = str2;
            this.subTitle = str3;
            this.title = str4;
        }

        public final String getCancelButton() {
            return this.cancelButton;
        }

        public final void setCancelButton(String str) {
            this.cancelButton = str;
        }

        public final String getConfirmButton() {
            return this.confirmButton;
        }

        public final void setConfirmButton(String str) {
            this.confirmButton = str;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(String str) {
            this.subTitle = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }
    }
}
