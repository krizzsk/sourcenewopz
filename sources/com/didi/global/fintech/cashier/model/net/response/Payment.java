package com.didi.global.fintech.cashier.model.net.response;

import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\u0018\u0000 C2\u00020\u0001:\u0005BCDEFB±\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0002\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\"\"\u0004\b/\u0010$R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(R\u001a\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001e\"\u0004\b?\u0010 R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010&\"\u0004\bA\u0010(¨\u0006G"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/Payment;", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "type", "", "name", "icon", "display", "subheadDisplay", "balanceInfo", "Lcom/didi/global/fintech/cashier/model/net/response/Payment$BalanceInfo;", "disabled", "", "selected", "isSigned", "installment", "Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo;", "tags", "", "Lcom/didi/global/fintech/cashier/model/net/response/Payment$PaymentTags;", "combineChannels", "", "selectAction", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "position", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/Payment$BalanceInfo;ZZZLcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo;Ljava/util/List;Ljava/util/List;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;I)V", "getBalanceInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/Payment$BalanceInfo;", "setBalanceInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/Payment$BalanceInfo;)V", "getCombineChannels", "()Ljava/util/List;", "setCombineChannels", "(Ljava/util/List;)V", "getDisabled", "()Z", "setDisabled", "(Z)V", "getDisplay", "()Ljava/lang/String;", "setDisplay", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getInstallment", "()Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo;", "setInstallment", "(Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo;)V", "setSigned", "getName", "setName", "getPosition", "()I", "setPosition", "(I)V", "getSelectAction", "()Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "setSelectAction", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;)V", "getSelected", "setSelected", "getSubheadDisplay", "setSubheadDisplay", "getTags", "setTags", "getType", "setType", "BalanceInfo", "Companion", "ExtraInfo", "InstallmentVo", "PaymentTags", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayInfoResponse.kt */
public final class Payment extends BasicPayment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PAYMENT_TYPE_BIND_CARD = "bind_card";
    public static final String PAYMENT_TYPE_CHANNEL = "channel";
    @SerializedName("balance_info")
    private BalanceInfo balanceInfo;
    @SerializedName("combine_channels")
    private List<Integer> combineChannels;
    @SerializedName("disabled")
    private boolean disabled;
    @SerializedName("display")
    private String display;
    @SerializedName("icon")
    private String icon;
    @SerializedName("installment")
    private InstallmentVo installment;
    @SerializedName("is_signed")
    private boolean isSigned;
    @SerializedName("name")
    private String name;
    private int position;
    @SerializedName("select_action")
    private CashierAction selectAction;
    @SerializedName("selected")
    private boolean selected;
    @SerializedName("subhead_display")
    private String subheadDisplay;
    @SerializedName("tags")
    private List<PaymentTags> tags;
    @SerializedName("type")
    private String type;

    public Payment() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (BalanceInfo) null, false, false, false, (InstallmentVo) null, (List) null, (List) null, (CashierAction) null, 0, 16383, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Payment(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.didi.global.fintech.cashier.model.net.response.Payment.BalanceInfo r22, boolean r23, boolean r24, boolean r25, com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo r26, java.util.List r27, java.util.List r28, com.didi.global.fintech.cashier.model.net.request.CashierAction r29, int r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r16 = this;
            r0 = r31
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            r9 = 1
            if (r8 == 0) goto L_0x003a
            r8 = 1
            goto L_0x003c
        L_0x003a:
            r8 = r23
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            r11 = 0
            if (r10 == 0) goto L_0x0043
            r10 = 0
            goto L_0x0045
        L_0x0043:
            r10 = r24
        L_0x0045:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r11 = r25
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = r2
            goto L_0x0054
        L_0x0052:
            r12 = r26
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = r2
            goto L_0x005c
        L_0x005a:
            r13 = r27
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = r2
            goto L_0x0064
        L_0x0062:
            r14 = r28
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r2 = r29
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r9 = r30
        L_0x0072:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r31 = r9
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.Payment.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.didi.global.fintech.cashier.model.net.response.Payment$BalanceInfo, boolean, boolean, boolean, com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo, java.util.List, java.util.List, com.didi.global.fintech.cashier.model.net.request.CashierAction, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final void setDisplay(String str) {
        this.display = str;
    }

    public final String getSubheadDisplay() {
        return this.subheadDisplay;
    }

    public final void setSubheadDisplay(String str) {
        this.subheadDisplay = str;
    }

    public final BalanceInfo getBalanceInfo() {
        return this.balanceInfo;
    }

    public final void setBalanceInfo(BalanceInfo balanceInfo2) {
        this.balanceInfo = balanceInfo2;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final void setDisabled(boolean z) {
        this.disabled = z;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final boolean isSigned() {
        return this.isSigned;
    }

    public final void setSigned(boolean z) {
        this.isSigned = z;
    }

    public final InstallmentVo getInstallment() {
        return this.installment;
    }

    public final void setInstallment(InstallmentVo installmentVo) {
        this.installment = installmentVo;
    }

    public final List<PaymentTags> getTags() {
        return this.tags;
    }

    public final void setTags(List<PaymentTags> list) {
        this.tags = list;
    }

    public final List<Integer> getCombineChannels() {
        return this.combineChannels;
    }

    public final void setCombineChannels(List<Integer> list) {
        this.combineChannels = list;
    }

    public final CashierAction getSelectAction() {
        return this.selectAction;
    }

    public final void setSelectAction(CashierAction cashierAction) {
        this.selectAction = cashierAction;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Payment(String str, String str2, String str3, String str4, String str5, BalanceInfo balanceInfo2, boolean z, boolean z2, boolean z3, InstallmentVo installmentVo, List<PaymentTags> list, List<Integer> list2, CashierAction cashierAction, int i) {
        super((Integer) null, (ExtraInfo) null, 3, (DefaultConstructorMarker) null);
        this.type = str;
        this.name = str2;
        this.icon = str3;
        this.display = str4;
        this.subheadDisplay = str5;
        this.balanceInfo = balanceInfo2;
        this.disabled = z;
        this.selected = z2;
        this.isSigned = z3;
        this.installment = installmentVo;
        this.tags = list;
        this.combineChannels = list2;
        this.selectAction = cashierAction;
        this.position = i;
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/Payment$BalanceInfo;", "Ljava/io/Serializable;", "balance", "Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "isEnough", "", "needTopUp", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBalance", "()Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "setBalance", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;)V", "()Ljava/lang/Boolean;", "setEnough", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNeedTopUp", "setNeedTopUp", "component1", "component2", "component3", "copy", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/didi/global/fintech/cashier/model/net/response/Payment$BalanceInfo;", "equals", "other", "", "hashCode", "", "toString", "", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayInfoResponse.kt */
    public static final class BalanceInfo implements Serializable {
        @SerializedName("balance")
        private PriceAmount balance;
        @SerializedName("is_enough")
        private Boolean isEnough;
        @SerializedName("need_top_up")
        private Boolean needTopUp;

        public BalanceInfo() {
            this((PriceAmount) null, (Boolean) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ BalanceInfo copy$default(BalanceInfo balanceInfo, PriceAmount priceAmount, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                priceAmount = balanceInfo.balance;
            }
            if ((i & 2) != 0) {
                bool = balanceInfo.isEnough;
            }
            if ((i & 4) != 0) {
                bool2 = balanceInfo.needTopUp;
            }
            return balanceInfo.copy(priceAmount, bool, bool2);
        }

        public final PriceAmount component1() {
            return this.balance;
        }

        public final Boolean component2() {
            return this.isEnough;
        }

        public final Boolean component3() {
            return this.needTopUp;
        }

        public final BalanceInfo copy(PriceAmount priceAmount, Boolean bool, Boolean bool2) {
            return new BalanceInfo(priceAmount, bool, bool2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BalanceInfo)) {
                return false;
            }
            BalanceInfo balanceInfo = (BalanceInfo) obj;
            return Intrinsics.areEqual((Object) this.balance, (Object) balanceInfo.balance) && Intrinsics.areEqual((Object) this.isEnough, (Object) balanceInfo.isEnough) && Intrinsics.areEqual((Object) this.needTopUp, (Object) balanceInfo.needTopUp);
        }

        public int hashCode() {
            PriceAmount priceAmount = this.balance;
            int i = 0;
            int hashCode = (priceAmount == null ? 0 : priceAmount.hashCode()) * 31;
            Boolean bool = this.isEnough;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.needTopUp;
            if (bool2 != null) {
                i = bool2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "BalanceInfo(balance=" + this.balance + ", isEnough=" + this.isEnough + ", needTopUp=" + this.needTopUp + VersionRange.RIGHT_OPEN;
        }

        public BalanceInfo(PriceAmount priceAmount, Boolean bool, Boolean bool2) {
            this.balance = priceAmount;
            this.isEnough = bool;
            this.needTopUp = bool2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BalanceInfo(PriceAmount priceAmount, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : priceAmount, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2);
        }

        public final PriceAmount getBalance() {
            return this.balance;
        }

        public final void setBalance(PriceAmount priceAmount) {
            this.balance = priceAmount;
        }

        public final Boolean isEnough() {
            return this.isEnough;
        }

        public final void setEnough(Boolean bool) {
            this.isEnough = bool;
        }

        public final Boolean getNeedTopUp() {
            return this.needTopUp;
        }

        public final void setNeedTopUp(Boolean bool) {
            this.needTopUp = bool;
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/Payment$ExtraInfo;", "Ljava/io/Serializable;", "cardIndex", "", "installmentNumber", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCardIndex", "()Ljava/lang/String;", "setCardIndex", "(Ljava/lang/String;)V", "getInstallmentNumber", "()Ljava/lang/Integer;", "setInstallmentNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/didi/global/fintech/cashier/model/net/response/Payment$ExtraInfo;", "equals", "", "other", "", "hashCode", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayInfoResponse.kt */
    public static final class ExtraInfo implements Serializable {
        @SerializedName("card_index")
        private String cardIndex;
        @SerializedName("installment_number")
        private Integer installmentNumber;

        public ExtraInfo() {
            this((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ExtraInfo copy$default(ExtraInfo extraInfo, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = extraInfo.cardIndex;
            }
            if ((i & 2) != 0) {
                num = extraInfo.installmentNumber;
            }
            return extraInfo.copy(str, num);
        }

        public final String component1() {
            return this.cardIndex;
        }

        public final Integer component2() {
            return this.installmentNumber;
        }

        public final ExtraInfo copy(String str, Integer num) {
            return new ExtraInfo(str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExtraInfo)) {
                return false;
            }
            ExtraInfo extraInfo = (ExtraInfo) obj;
            return Intrinsics.areEqual((Object) this.cardIndex, (Object) extraInfo.cardIndex) && Intrinsics.areEqual((Object) this.installmentNumber, (Object) extraInfo.installmentNumber);
        }

        public int hashCode() {
            String str = this.cardIndex;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.installmentNumber;
            if (num != null) {
                i = num.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "ExtraInfo(cardIndex=" + this.cardIndex + ", installmentNumber=" + this.installmentNumber + VersionRange.RIGHT_OPEN;
        }

        public ExtraInfo(String str, Integer num) {
            this.cardIndex = str;
            this.installmentNumber = num;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ExtraInfo(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
        }

        public final String getCardIndex() {
            return this.cardIndex;
        }

        public final void setCardIndex(String str) {
            this.cardIndex = str;
        }

        public final Integer getInstallmentNumber() {
            return this.installmentNumber;
        }

        public final void setInstallmentNumber(Integer num) {
            this.installmentNumber = num;
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/Payment$PaymentTags;", "Ljava/io/Serializable;", "type", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayInfoResponse.kt */
    public static final class PaymentTags implements Serializable {
        @SerializedName("message")
        private String message;
        @SerializedName("type")
        private String type;

        public PaymentTags() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentTags copy$default(PaymentTags paymentTags, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paymentTags.type;
            }
            if ((i & 2) != 0) {
                str2 = paymentTags.message;
            }
            return paymentTags.copy(str, str2);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.message;
        }

        public final PaymentTags copy(String str, String str2) {
            return new PaymentTags(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaymentTags)) {
                return false;
            }
            PaymentTags paymentTags = (PaymentTags) obj;
            return Intrinsics.areEqual((Object) this.type, (Object) paymentTags.type) && Intrinsics.areEqual((Object) this.message, (Object) paymentTags.message);
        }

        public int hashCode() {
            String str = this.type;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.message;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "PaymentTags(type=" + this.type + ", message=" + this.message + VersionRange.RIGHT_OPEN;
        }

        public PaymentTags(String str, String str2) {
            this.type = str;
            this.message = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PaymentTags(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            this.type = str;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u000267Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003Jt\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001R&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017¨\u00068"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo;", "Ljava/io/Serializable;", "support", "", "title", "", "installmentAmount", "Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "faqUrl", "additionalInfo", "", "Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo$AdditionalInfo;", "suggestPlans", "Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo$PlansVo;", "plans", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAdditionalInfo", "()Ljava/util/List;", "setAdditionalInfo", "(Ljava/util/List;)V", "getFaqUrl", "()Ljava/lang/String;", "setFaqUrl", "(Ljava/lang/String;)V", "getInstallmentAmount", "()Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "setInstallmentAmount", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;)V", "getPlans", "setPlans", "getSuggestPlans", "setSuggestPlans", "getSupport", "()Ljava/lang/Boolean;", "setSupport", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo;", "equals", "other", "", "hashCode", "", "toString", "AdditionalInfo", "PlansVo", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayInfoResponse.kt */
    public static final class InstallmentVo implements Serializable {
        @SerializedName("additional_info")
        private List<AdditionalInfo> additionalInfo;
        @SerializedName("faq_url")
        private String faqUrl;
        @SerializedName("installment_amount")
        private PriceAmount installmentAmount;
        @SerializedName("plans")
        private List<PlansVo> plans;
        @SerializedName("suggest_plans")
        private List<PlansVo> suggestPlans;
        @SerializedName("support")
        private Boolean support;
        @SerializedName("title")
        private String title;

        public InstallmentVo() {
            this((Boolean) null, (String) null, (PriceAmount) null, (String) null, (List) null, (List) null, (List) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ InstallmentVo copy$default(InstallmentVo installmentVo, Boolean bool, String str, PriceAmount priceAmount, String str2, List<AdditionalInfo> list, List<PlansVo> list2, List<PlansVo> list3, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = installmentVo.support;
            }
            if ((i & 2) != 0) {
                str = installmentVo.title;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                priceAmount = installmentVo.installmentAmount;
            }
            PriceAmount priceAmount2 = priceAmount;
            if ((i & 8) != 0) {
                str2 = installmentVo.faqUrl;
            }
            String str4 = str2;
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
            return installmentVo.copy(bool, str3, priceAmount2, str4, list4, list5, list3);
        }

        public final Boolean component1() {
            return this.support;
        }

        public final String component2() {
            return this.title;
        }

        public final PriceAmount component3() {
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

        public final InstallmentVo copy(Boolean bool, String str, PriceAmount priceAmount, String str2, List<AdditionalInfo> list, List<PlansVo> list2, List<PlansVo> list3) {
            return new InstallmentVo(bool, str, priceAmount, str2, list, list2, list3);
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
            PriceAmount priceAmount = this.installmentAmount;
            int hashCode3 = (hashCode2 + (priceAmount == null ? 0 : priceAmount.hashCode())) * 31;
            String str2 = this.faqUrl;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
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

        public InstallmentVo(Boolean bool, String str, PriceAmount priceAmount, String str2, List<AdditionalInfo> list, List<PlansVo> list2, List<PlansVo> list3) {
            this.support = bool;
            this.title = str;
            this.installmentAmount = priceAmount;
            this.faqUrl = str2;
            this.additionalInfo = list;
            this.suggestPlans = list2;
            this.plans = list3;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ InstallmentVo(java.lang.Boolean r7, java.lang.String r8, com.didi.global.fintech.cashier.model.net.response.PriceAmount r9, java.lang.String r10, java.util.List r11, java.util.List r12, java.util.List r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.<init>(java.lang.Boolean, java.lang.String, com.didi.global.fintech.cashier.model.net.response.PriceAmount, java.lang.String, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

        public final PriceAmount getInstallmentAmount() {
            return this.installmentAmount;
        }

        public final void setInstallmentAmount(PriceAmount priceAmount) {
            this.installmentAmount = priceAmount;
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

        @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo$AdditionalInfo;", "Ljava/io/Serializable;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: PayInfoResponse.kt */
        public static final class AdditionalInfo implements Serializable {
            @SerializedName("message")
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

        @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0006\u00103\u001a\u00020\u0007J\t\u00104\u001a\u00020\u0005HÖ\u0001R \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0011¨\u00065"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo$PlansVo;", "Ljava/io/Serializable;", "number", "", "display", "", "selected", "", "eachAmount", "Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "totalAmount", "accessoryAmount", "tag", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Ljava/lang/String;)V", "getAccessoryAmount", "()Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "setAccessoryAmount", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;)V", "getDisplay", "()Ljava/lang/String;", "setDisplay", "(Ljava/lang/String;)V", "getEachAmount", "setEachAmount", "getNumber", "()Ljava/lang/Integer;", "setNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSelected", "()Ljava/lang/Boolean;", "setSelected", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTag", "setTag", "getTotalAmount", "setTotalAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Ljava/lang/String;)Lcom/didi/global/fintech/cashier/model/net/response/Payment$InstallmentVo$PlansVo;", "equals", "other", "", "hashCode", "isSelected", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: PayInfoResponse.kt */
        public static final class PlansVo implements Serializable {
            @SerializedName("accessory_amount")
            private PriceAmount accessoryAmount;
            @SerializedName("display")
            private String display;
            @SerializedName("each_amount")
            private PriceAmount eachAmount;
            @SerializedName("number")
            private Integer number;
            @SerializedName("selected")
            private Boolean selected;
            @SerializedName("tag")
            private String tag;
            @SerializedName("total_amount")
            private PriceAmount totalAmount;

            public PlansVo() {
                this((Integer) null, (String) null, (Boolean) null, (PriceAmount) null, (PriceAmount) null, (PriceAmount) null, (String) null, 127, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ PlansVo copy$default(PlansVo plansVo, Integer num, String str, Boolean bool, PriceAmount priceAmount, PriceAmount priceAmount2, PriceAmount priceAmount3, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = plansVo.number;
                }
                if ((i & 2) != 0) {
                    str = plansVo.display;
                }
                String str3 = str;
                if ((i & 4) != 0) {
                    bool = plansVo.selected;
                }
                Boolean bool2 = bool;
                if ((i & 8) != 0) {
                    priceAmount = plansVo.eachAmount;
                }
                PriceAmount priceAmount4 = priceAmount;
                if ((i & 16) != 0) {
                    priceAmount2 = plansVo.totalAmount;
                }
                PriceAmount priceAmount5 = priceAmount2;
                if ((i & 32) != 0) {
                    priceAmount3 = plansVo.accessoryAmount;
                }
                PriceAmount priceAmount6 = priceAmount3;
                if ((i & 64) != 0) {
                    str2 = plansVo.tag;
                }
                return plansVo.copy(num, str3, bool2, priceAmount4, priceAmount5, priceAmount6, str2);
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

            public final PriceAmount component4() {
                return this.eachAmount;
            }

            public final PriceAmount component5() {
                return this.totalAmount;
            }

            public final PriceAmount component6() {
                return this.accessoryAmount;
            }

            public final String component7() {
                return this.tag;
            }

            public final PlansVo copy(Integer num, String str, Boolean bool, PriceAmount priceAmount, PriceAmount priceAmount2, PriceAmount priceAmount3, String str2) {
                return new PlansVo(num, str, bool, priceAmount, priceAmount2, priceAmount3, str2);
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
                PriceAmount priceAmount = this.eachAmount;
                int hashCode4 = (hashCode3 + (priceAmount == null ? 0 : priceAmount.hashCode())) * 31;
                PriceAmount priceAmount2 = this.totalAmount;
                int hashCode5 = (hashCode4 + (priceAmount2 == null ? 0 : priceAmount2.hashCode())) * 31;
                PriceAmount priceAmount3 = this.accessoryAmount;
                int hashCode6 = (hashCode5 + (priceAmount3 == null ? 0 : priceAmount3.hashCode())) * 31;
                String str2 = this.tag;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode6 + i;
            }

            public String toString() {
                return "PlansVo(number=" + this.number + ", display=" + this.display + ", selected=" + this.selected + ", eachAmount=" + this.eachAmount + ", totalAmount=" + this.totalAmount + ", accessoryAmount=" + this.accessoryAmount + ", tag=" + this.tag + VersionRange.RIGHT_OPEN;
            }

            public PlansVo(Integer num, String str, Boolean bool, PriceAmount priceAmount, PriceAmount priceAmount2, PriceAmount priceAmount3, String str2) {
                this.number = num;
                this.display = str;
                this.selected = bool;
                this.eachAmount = priceAmount;
                this.totalAmount = priceAmount2;
                this.accessoryAmount = priceAmount3;
                this.tag = str2;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ PlansVo(java.lang.Integer r7, java.lang.String r8, java.lang.Boolean r9, com.didi.global.fintech.cashier.model.net.response.PriceAmount r10, com.didi.global.fintech.cashier.model.net.response.PriceAmount r11, com.didi.global.fintech.cashier.model.net.response.PriceAmount r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
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
                throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo.<init>(java.lang.Integer, java.lang.String, java.lang.Boolean, com.didi.global.fintech.cashier.model.net.response.PriceAmount, com.didi.global.fintech.cashier.model.net.response.PriceAmount, com.didi.global.fintech.cashier.model.net.response.PriceAmount, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

            public final PriceAmount getEachAmount() {
                return this.eachAmount;
            }

            public final void setEachAmount(PriceAmount priceAmount) {
                this.eachAmount = priceAmount;
            }

            public final PriceAmount getTotalAmount() {
                return this.totalAmount;
            }

            public final void setTotalAmount(PriceAmount priceAmount) {
                this.totalAmount = priceAmount;
            }

            public final PriceAmount getAccessoryAmount() {
                return this.accessoryAmount;
            }

            public final void setAccessoryAmount(PriceAmount priceAmount) {
                this.accessoryAmount = priceAmount;
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

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/Payment$Companion;", "", "()V", "PAYMENT_TYPE_BIND_CARD", "", "PAYMENT_TYPE_CHANNEL", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayInfoResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
