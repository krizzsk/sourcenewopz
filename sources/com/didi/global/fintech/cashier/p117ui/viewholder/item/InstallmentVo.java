package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u000245Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003Jt\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\u0006\u00102\u001a\u00020\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u00066"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo;", "Ljava/io/Serializable;", "support", "", "title", "", "installmentAmount", "faqUrl", "additionalInfo", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$AdditionalInfo;", "suggestPlans", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;", "plans", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAdditionalInfo", "()Ljava/util/List;", "setAdditionalInfo", "(Ljava/util/List;)V", "getFaqUrl", "()Ljava/lang/String;", "setFaqUrl", "(Ljava/lang/String;)V", "getInstallmentAmount", "setInstallmentAmount", "getPlans", "setPlans", "getSuggestPlans", "setSuggestPlans", "getSupport", "()Ljava/lang/Boolean;", "setSupport", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo;", "equals", "other", "", "hashCode", "", "isSupport", "toString", "AdditionalInfo", "PlansVo", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.InstallmentVo */
/* compiled from: GlobalCashierBaseItemViewHolder.kt */
public final class InstallmentVo implements Serializable {
    private List<AdditionalInfo> additionalInfo;
    private String faqUrl;
    private String installmentAmount;
    private List<PlansVo> plans;
    private List<PlansVo> suggestPlans;
    private Boolean support;
    private String title;

    public InstallmentVo() {
        this((Boolean) null, (String) null, (String) null, (String) null, (List) null, (List) null, (List) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InstallmentVo copy$default(InstallmentVo installmentVo, Boolean bool, String str, String str2, String str3, List<AdditionalInfo> list, List<PlansVo> list2, List<PlansVo> list3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = installmentVo.support;
        }
        if ((i & 2) != 0) {
            str = installmentVo.title;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = installmentVo.installmentAmount;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = installmentVo.faqUrl;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            list = installmentVo.additionalInfo;
        }
        List<AdditionalInfo> list4 = list;
        if ((i & 32) != 0) {
            list2 = installmentVo.suggestPlans;
        }
        List<PlansVo> list5 = list2;
        if ((i & 64) != 0) {
            list3 = installmentVo.plans;
        }
        return installmentVo.copy(bool, str4, str5, str6, list4, list5, list3);
    }

    public final Boolean component1() {
        return this.support;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.installmentAmount;
    }

    public final String component4() {
        return this.faqUrl;
    }

    public final List<AdditionalInfo> component5() {
        return this.additionalInfo;
    }

    public final List<PlansVo> component6() {
        return this.suggestPlans;
    }

    public final List<PlansVo> component7() {
        return this.plans;
    }

    public final InstallmentVo copy(Boolean bool, String str, String str2, String str3, List<AdditionalInfo> list, List<PlansVo> list2, List<PlansVo> list3) {
        return new InstallmentVo(bool, str, str2, str3, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InstallmentVo)) {
            return false;
        }
        InstallmentVo installmentVo = (InstallmentVo) obj;
        return Intrinsics.areEqual((Object) this.support, (Object) installmentVo.support) && Intrinsics.areEqual((Object) this.title, (Object) installmentVo.title) && Intrinsics.areEqual((Object) this.installmentAmount, (Object) installmentVo.installmentAmount) && Intrinsics.areEqual((Object) this.faqUrl, (Object) installmentVo.faqUrl) && Intrinsics.areEqual((Object) this.additionalInfo, (Object) installmentVo.additionalInfo) && Intrinsics.areEqual((Object) this.suggestPlans, (Object) installmentVo.suggestPlans) && Intrinsics.areEqual((Object) this.plans, (Object) installmentVo.plans);
    }

    public int hashCode() {
        Boolean bool = this.support;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.installmentAmount;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.faqUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<AdditionalInfo> list = this.additionalInfo;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<PlansVo> list2 = this.suggestPlans;
        int hashCode6 = (hashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<PlansVo> list3 = this.plans;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "InstallmentVo(support=" + this.support + ", title=" + this.title + ", installmentAmount=" + this.installmentAmount + ", faqUrl=" + this.faqUrl + ", additionalInfo=" + this.additionalInfo + ", suggestPlans=" + this.suggestPlans + ", plans=" + this.plans + VersionRange.RIGHT_OPEN;
    }

    public InstallmentVo(Boolean bool, String str, String str2, String str3, List<AdditionalInfo> list, List<PlansVo> list2, List<PlansVo> list3) {
        this.support = bool;
        this.title = str;
        this.installmentAmount = str2;
        this.faqUrl = str3;
        this.additionalInfo = list;
        this.suggestPlans = list2;
        this.plans = list3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InstallmentVo(java.lang.Boolean r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.util.List r11, java.util.List r12, java.util.List r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.viewholder.item.InstallmentVo.<init>(java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean getSupport() {
        return this.support;
    }

    public final void setSupport(Boolean bool) {
        this.support = bool;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getInstallmentAmount() {
        return this.installmentAmount;
    }

    public final void setInstallmentAmount(String str) {
        this.installmentAmount = str;
    }

    public final String getFaqUrl() {
        return this.faqUrl;
    }

    public final void setFaqUrl(String str) {
        this.faqUrl = str;
    }

    public final List<AdditionalInfo> getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final void setAdditionalInfo(List<AdditionalInfo> list) {
        this.additionalInfo = list;
    }

    public final List<PlansVo> getSuggestPlans() {
        return this.suggestPlans;
    }

    public final void setSuggestPlans(List<PlansVo> list) {
        this.suggestPlans = list;
    }

    public final List<PlansVo> getPlans() {
        return this.plans;
    }

    public final void setPlans(List<PlansVo> list) {
        this.plans = list;
    }

    public final boolean isSupport() {
        return Intrinsics.areEqual((Object) this.support, (Object) true);
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$AdditionalInfo;", "Ljava/io/Serializable;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.InstallmentVo$AdditionalInfo */
    /* compiled from: GlobalCashierBaseItemViewHolder.kt */
    public static final class AdditionalInfo implements Serializable {
        private String message;

        public AdditionalInfo() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AdditionalInfo copy$default(AdditionalInfo additionalInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = additionalInfo.message;
            }
            return additionalInfo.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final AdditionalInfo copy(String str) {
            return new AdditionalInfo(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AdditionalInfo) && Intrinsics.areEqual((Object) this.message, (Object) ((AdditionalInfo) obj).message);
        }

        public int hashCode() {
            String str = this.message;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "AdditionalInfo(message=" + this.message + VersionRange.RIGHT_OPEN;
        }

        public AdditionalInfo(String str) {
            this.message = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AdditionalInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0006\u00100\u001a\u00020\u0007J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010¨\u00062"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;", "Ljava/io/Serializable;", "number", "", "display", "", "selected", "", "eachAmount", "totalAmount", "accessoryAmount", "tag", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessoryAmount", "()Ljava/lang/String;", "setAccessoryAmount", "(Ljava/lang/String;)V", "getDisplay", "setDisplay", "getEachAmount", "setEachAmount", "getNumber", "()Ljava/lang/Integer;", "setNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSelected", "()Ljava/lang/Boolean;", "setSelected", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTag", "setTag", "getTotalAmount", "setTotalAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;", "equals", "other", "", "hashCode", "isSelected", "toString", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.InstallmentVo$PlansVo */
    /* compiled from: GlobalCashierBaseItemViewHolder.kt */
    public static final class PlansVo implements Serializable {
        private String accessoryAmount;
        private String display;
        private String eachAmount;
        private Integer number;
        private Boolean selected;
        private String tag;
        private String totalAmount;

        public PlansVo() {
            this((Integer) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PlansVo copy$default(PlansVo plansVo, Integer num, String str, Boolean bool, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                num = plansVo.number;
            }
            if ((i & 2) != 0) {
                str = plansVo.display;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                bool = plansVo.selected;
            }
            Boolean bool2 = bool;
            if ((i & 8) != 0) {
                str2 = plansVo.eachAmount;
            }
            String str7 = str2;
            if ((i & 16) != 0) {
                str3 = plansVo.totalAmount;
            }
            String str8 = str3;
            if ((i & 32) != 0) {
                str4 = plansVo.accessoryAmount;
            }
            String str9 = str4;
            if ((i & 64) != 0) {
                str5 = plansVo.tag;
            }
            return plansVo.copy(num, str6, bool2, str7, str8, str9, str5);
        }

        public final Integer component1() {
            return this.number;
        }

        public final String component2() {
            return this.display;
        }

        public final Boolean component3() {
            return this.selected;
        }

        public final String component4() {
            return this.eachAmount;
        }

        public final String component5() {
            return this.totalAmount;
        }

        public final String component6() {
            return this.accessoryAmount;
        }

        public final String component7() {
            return this.tag;
        }

        public final PlansVo copy(Integer num, String str, Boolean bool, String str2, String str3, String str4, String str5) {
            return new PlansVo(num, str, bool, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlansVo)) {
                return false;
            }
            PlansVo plansVo = (PlansVo) obj;
            return Intrinsics.areEqual((Object) this.number, (Object) plansVo.number) && Intrinsics.areEqual((Object) this.display, (Object) plansVo.display) && Intrinsics.areEqual((Object) this.selected, (Object) plansVo.selected) && Intrinsics.areEqual((Object) this.eachAmount, (Object) plansVo.eachAmount) && Intrinsics.areEqual((Object) this.totalAmount, (Object) plansVo.totalAmount) && Intrinsics.areEqual((Object) this.accessoryAmount, (Object) plansVo.accessoryAmount) && Intrinsics.areEqual((Object) this.tag, (Object) plansVo.tag);
        }

        public int hashCode() {
            Integer num = this.number;
            int i = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.display;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.selected;
            int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str2 = this.eachAmount;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.totalAmount;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.accessoryAmount;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.tag;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return hashCode6 + i;
        }

        public String toString() {
            return "PlansVo(number=" + this.number + ", display=" + this.display + ", selected=" + this.selected + ", eachAmount=" + this.eachAmount + ", totalAmount=" + this.totalAmount + ", accessoryAmount=" + this.accessoryAmount + ", tag=" + this.tag + VersionRange.RIGHT_OPEN;
        }

        public PlansVo(Integer num, String str, Boolean bool, String str2, String str3, String str4, String str5) {
            this.number = num;
            this.display = str;
            this.selected = bool;
            this.eachAmount = str2;
            this.totalAmount = str3;
            this.accessoryAmount = str4;
            this.tag = str5;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ PlansVo(java.lang.Integer r7, java.lang.String r8, java.lang.Boolean r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
            /*
                r6 = this;
                r15 = r14 & 1
                r0 = 0
                if (r15 == 0) goto L_0x0007
                r15 = r0
                goto L_0x0008
            L_0x0007:
                r15 = r7
            L_0x0008:
                r7 = r14 & 2
                if (r7 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r8
            L_0x000f:
                r7 = r14 & 4
                if (r7 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r9
            L_0x0016:
                r7 = r14 & 8
                if (r7 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r10
            L_0x001d:
                r7 = r14 & 16
                if (r7 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r11
            L_0x0024:
                r7 = r14 & 32
                if (r7 == 0) goto L_0x002a
                r5 = r0
                goto L_0x002b
            L_0x002a:
                r5 = r12
            L_0x002b:
                r7 = r14 & 64
                if (r7 == 0) goto L_0x0031
                r14 = r0
                goto L_0x0032
            L_0x0031:
                r14 = r13
            L_0x0032:
                r7 = r6
                r8 = r15
                r9 = r1
                r10 = r2
                r11 = r3
                r12 = r4
                r13 = r5
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.viewholder.item.InstallmentVo.PlansVo.<init>(java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final Integer getNumber() {
            return this.number;
        }

        public final void setNumber(Integer num) {
            this.number = num;
        }

        public final String getDisplay() {
            return this.display;
        }

        public final void setDisplay(String str) {
            this.display = str;
        }

        public final Boolean getSelected() {
            return this.selected;
        }

        public final void setSelected(Boolean bool) {
            this.selected = bool;
        }

        public final String getEachAmount() {
            return this.eachAmount;
        }

        public final void setEachAmount(String str) {
            this.eachAmount = str;
        }

        public final String getTotalAmount() {
            return this.totalAmount;
        }

        public final void setTotalAmount(String str) {
            this.totalAmount = str;
        }

        public final String getAccessoryAmount() {
            return this.accessoryAmount;
        }

        public final void setAccessoryAmount(String str) {
            this.accessoryAmount = str;
        }

        public final String getTag() {
            return this.tag;
        }

        public final void setTag(String str) {
            this.tag = str;
        }

        public final boolean isSelected() {
            return Intrinsics.areEqual((Object) this.selected, (Object) true);
        }
    }
}
