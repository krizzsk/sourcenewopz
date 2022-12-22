package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u00015B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003Jh\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001c¨\u00066"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo;", "Ljava/io/Serializable;", "show", "", "content", "", "acceptContent", "", "Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo$PolicyAcceptContent;", "defaultCheck", "notAgreeTip", "agreeText", "policyData", "Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;)V", "getAcceptContent", "()Ljava/util/List;", "setAcceptContent", "(Ljava/util/List;)V", "getAgreeText", "()Ljava/lang/String;", "setAgreeText", "(Ljava/lang/String;)V", "getContent", "setContent", "getDefaultCheck", "()Ljava/lang/Boolean;", "setDefaultCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNotAgreeTip", "setNotAgreeTip", "getPolicyData", "()Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;", "setPolicyData", "(Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;)V", "getShow", "setShow", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;)Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo;", "equals", "other", "", "hashCode", "", "toString", "PolicyAcceptContent", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayInfoResponse.kt */
public final class PolicyInfo implements Serializable {
    @SerializedName("accept_content")
    private List<PolicyAcceptContent> acceptContent;
    @SerializedName("agree_text")
    private String agreeText;
    @SerializedName("content")
    private String content;
    @SerializedName("default_check")
    private Boolean defaultCheck;
    @SerializedName("not_agree_tip")
    private String notAgreeTip;
    @SerializedName("policy_info")
    private PolicyData policyData;
    @SerializedName("need_show")
    private Boolean show;

    public PolicyInfo() {
        this((Boolean) null, (String) null, (List) null, (Boolean) null, (String) null, (String) null, (PolicyData) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PolicyInfo copy$default(PolicyInfo policyInfo, Boolean bool, String str, List<PolicyAcceptContent> list, Boolean bool2, String str2, String str3, PolicyData policyData2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = policyInfo.show;
        }
        if ((i & 2) != 0) {
            str = policyInfo.content;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            list = policyInfo.acceptContent;
        }
        List<PolicyAcceptContent> list2 = list;
        if ((i & 8) != 0) {
            bool2 = policyInfo.defaultCheck;
        }
        Boolean bool3 = bool2;
        if ((i & 16) != 0) {
            str2 = policyInfo.notAgreeTip;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = policyInfo.agreeText;
        }
        String str6 = str3;
        if ((i & 64) != 0) {
            policyData2 = policyInfo.policyData;
        }
        return policyInfo.copy(bool, str4, list2, bool3, str5, str6, policyData2);
    }

    public final Boolean component1() {
        return this.show;
    }

    public final String component2() {
        return this.content;
    }

    public final List<PolicyAcceptContent> component3() {
        return this.acceptContent;
    }

    public final Boolean component4() {
        return this.defaultCheck;
    }

    public final String component5() {
        return this.notAgreeTip;
    }

    public final String component6() {
        return this.agreeText;
    }

    public final PolicyData component7() {
        return this.policyData;
    }

    public final PolicyInfo copy(Boolean bool, String str, List<PolicyAcceptContent> list, Boolean bool2, String str2, String str3, PolicyData policyData2) {
        return new PolicyInfo(bool, str, list, bool2, str2, str3, policyData2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyInfo)) {
            return false;
        }
        PolicyInfo policyInfo = (PolicyInfo) obj;
        return Intrinsics.areEqual((Object) this.show, (Object) policyInfo.show) && Intrinsics.areEqual((Object) this.content, (Object) policyInfo.content) && Intrinsics.areEqual((Object) this.acceptContent, (Object) policyInfo.acceptContent) && Intrinsics.areEqual((Object) this.defaultCheck, (Object) policyInfo.defaultCheck) && Intrinsics.areEqual((Object) this.notAgreeTip, (Object) policyInfo.notAgreeTip) && Intrinsics.areEqual((Object) this.agreeText, (Object) policyInfo.agreeText) && Intrinsics.areEqual((Object) this.policyData, (Object) policyInfo.policyData);
    }

    public int hashCode() {
        Boolean bool = this.show;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.content;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<PolicyAcceptContent> list = this.acceptContent;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool2 = this.defaultCheck;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.notAgreeTip;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.agreeText;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        PolicyData policyData2 = this.policyData;
        if (policyData2 != null) {
            i = policyData2.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "PolicyInfo(show=" + this.show + ", content=" + this.content + ", acceptContent=" + this.acceptContent + ", defaultCheck=" + this.defaultCheck + ", notAgreeTip=" + this.notAgreeTip + ", agreeText=" + this.agreeText + ", policyData=" + this.policyData + VersionRange.RIGHT_OPEN;
    }

    public PolicyInfo(Boolean bool, String str, List<PolicyAcceptContent> list, Boolean bool2, String str2, String str3, PolicyData policyData2) {
        this.show = bool;
        this.content = str;
        this.acceptContent = list;
        this.defaultCheck = bool2;
        this.notAgreeTip = str2;
        this.agreeText = str3;
        this.policyData = policyData2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PolicyInfo(java.lang.Boolean r7, java.lang.String r8, java.util.List r9, java.lang.Boolean r10, java.lang.String r11, java.lang.String r12, com.didi.global.fintech.cashier.model.net.response.PolicyData r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            if (r15 == 0) goto L_0x000b
            r15 = r0
            goto L_0x000c
        L_0x000b:
            r15 = r7
        L_0x000c:
            r7 = r14 & 2
            r1 = 0
            if (r7 == 0) goto L_0x0013
            r2 = r1
            goto L_0x0014
        L_0x0013:
            r2 = r8
        L_0x0014:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x001a
            r3 = r1
            goto L_0x001b
        L_0x001a:
            r3 = r9
        L_0x001b:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = r10
        L_0x0021:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0027
            r4 = r1
            goto L_0x0028
        L_0x0027:
            r4 = r11
        L_0x0028:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002e
            r5 = r1
            goto L_0x002f
        L_0x002e:
            r5 = r12
        L_0x002f:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0035
            r14 = r1
            goto L_0x0036
        L_0x0035:
            r14 = r13
        L_0x0036:
            r7 = r6
            r8 = r15
            r9 = r2
            r10 = r3
            r11 = r0
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.PolicyInfo.<init>(java.lang.Boolean, java.lang.String, java.util.List, java.lang.Boolean, java.lang.String, java.lang.String, com.didi.global.fintech.cashier.model.net.response.PolicyData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean getShow() {
        return this.show;
    }

    public final void setShow(Boolean bool) {
        this.show = bool;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final List<PolicyAcceptContent> getAcceptContent() {
        return this.acceptContent;
    }

    public final void setAcceptContent(List<PolicyAcceptContent> list) {
        this.acceptContent = list;
    }

    public final Boolean getDefaultCheck() {
        return this.defaultCheck;
    }

    public final void setDefaultCheck(Boolean bool) {
        this.defaultCheck = bool;
    }

    public final String getNotAgreeTip() {
        return this.notAgreeTip;
    }

    public final void setNotAgreeTip(String str) {
        this.notAgreeTip = str;
    }

    public final String getAgreeText() {
        return this.agreeText;
    }

    public final void setAgreeText(String str) {
        this.agreeText = str;
    }

    public final PolicyData getPolicyData() {
        return this.policyData;
    }

    public final void setPolicyData(PolicyData policyData2) {
        this.policyData = policyData2;
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo$PolicyAcceptContent;", "Ljava/io/Serializable;", "message", "", "link", "(Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "getMessage", "setMessage", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayInfoResponse.kt */
    public static final class PolicyAcceptContent implements Serializable {
        @SerializedName("link")
        private String link;
        @SerializedName("message")
        private String message;

        public PolicyAcceptContent() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PolicyAcceptContent copy$default(PolicyAcceptContent policyAcceptContent, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = policyAcceptContent.message;
            }
            if ((i & 2) != 0) {
                str2 = policyAcceptContent.link;
            }
            return policyAcceptContent.copy(str, str2);
        }

        public final String component1() {
            return this.message;
        }

        public final String component2() {
            return this.link;
        }

        public final PolicyAcceptContent copy(String str, String str2) {
            return new PolicyAcceptContent(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PolicyAcceptContent)) {
                return false;
            }
            PolicyAcceptContent policyAcceptContent = (PolicyAcceptContent) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) policyAcceptContent.message) && Intrinsics.areEqual((Object) this.link, (Object) policyAcceptContent.link);
        }

        public int hashCode() {
            String str = this.message;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.link;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "PolicyAcceptContent(message=" + this.message + ", link=" + this.link + VersionRange.RIGHT_OPEN;
        }

        public PolicyAcceptContent(String str, String str2) {
            this.message = str;
            this.link = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PolicyAcceptContent(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        public final String getLink() {
            return this.link;
        }

        public final void setLink(String str) {
            this.link = str;
        }
    }
}
