package com.didi.global.fintech.cashier.model.net.request;

import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleType;
import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.threeds.GlobalCashierThreeDSModule;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.ICashierFacade;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u00049:;<Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001bJn\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006="}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "out_trade_id", "", "user_select", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "redirect_scheme", "merchant_wsgenv", "password_token", "cvv", "third_party", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThirdParty;", "pay_tip_confirmed", "", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThirdParty;Ljava/lang/Boolean;)V", "getCvv", "()Ljava/lang/String;", "setCvv", "(Ljava/lang/String;)V", "getMerchant_wsgenv", "setMerchant_wsgenv", "getOut_trade_id", "setOut_trade_id", "getPassword_token", "setPassword_token", "getPay_tip_confirmed", "()Ljava/lang/Boolean;", "setPay_tip_confirmed", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRedirect_scheme", "setRedirect_scheme", "getThird_party", "()Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThirdParty;", "setThird_party", "(Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThirdParty;)V", "getUser_select", "()Ljava/util/List;", "setUser_select", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThirdParty;Ljava/lang/Boolean;)Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest;", "equals", "other", "", "hashCode", "", "toString", "ThirdParty", "ThreeDS", "ThreeDSV2", "ThreeDSV2Result", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrepayRequest.kt */
public final class PrepayRequest extends CashierRequestCommonParams {
    private String cvv;
    private String merchant_wsgenv;
    private String out_trade_id;
    private String password_token;
    private Boolean pay_tip_confirmed;
    private String redirect_scheme;
    private ThirdParty third_party;
    private List<BasicPayment> user_select;

    public PrepayRequest() {
        this((String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (ThirdParty) null, (Boolean) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PrepayRequest copy$default(PrepayRequest prepayRequest, String str, List list, String str2, String str3, String str4, String str5, ThirdParty thirdParty, Boolean bool, int i, Object obj) {
        PrepayRequest prepayRequest2 = prepayRequest;
        int i2 = i;
        return prepayRequest.copy((i2 & 1) != 0 ? prepayRequest2.out_trade_id : str, (i2 & 2) != 0 ? prepayRequest2.user_select : list, (i2 & 4) != 0 ? prepayRequest2.redirect_scheme : str2, (i2 & 8) != 0 ? prepayRequest2.merchant_wsgenv : str3, (i2 & 16) != 0 ? prepayRequest2.password_token : str4, (i2 & 32) != 0 ? prepayRequest2.cvv : str5, (i2 & 64) != 0 ? prepayRequest2.third_party : thirdParty, (i2 & 128) != 0 ? prepayRequest2.pay_tip_confirmed : bool);
    }

    public final String component1() {
        return this.out_trade_id;
    }

    public final List<BasicPayment> component2() {
        return this.user_select;
    }

    public final String component3() {
        return this.redirect_scheme;
    }

    public final String component4() {
        return this.merchant_wsgenv;
    }

    public final String component5() {
        return this.password_token;
    }

    public final String component6() {
        return this.cvv;
    }

    public final ThirdParty component7() {
        return this.third_party;
    }

    public final Boolean component8() {
        return this.pay_tip_confirmed;
    }

    public final PrepayRequest copy(String str, List<BasicPayment> list, String str2, String str3, String str4, String str5, ThirdParty thirdParty, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        Intrinsics.checkNotNullParameter(list, "user_select");
        ThirdParty thirdParty2 = thirdParty;
        Intrinsics.checkNotNullParameter(thirdParty2, "third_party");
        return new PrepayRequest(str, list, str2, str3, str4, str5, thirdParty2, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrepayRequest)) {
            return false;
        }
        PrepayRequest prepayRequest = (PrepayRequest) obj;
        return Intrinsics.areEqual((Object) this.out_trade_id, (Object) prepayRequest.out_trade_id) && Intrinsics.areEqual((Object) this.user_select, (Object) prepayRequest.user_select) && Intrinsics.areEqual((Object) this.redirect_scheme, (Object) prepayRequest.redirect_scheme) && Intrinsics.areEqual((Object) this.merchant_wsgenv, (Object) prepayRequest.merchant_wsgenv) && Intrinsics.areEqual((Object) this.password_token, (Object) prepayRequest.password_token) && Intrinsics.areEqual((Object) this.cvv, (Object) prepayRequest.cvv) && Intrinsics.areEqual((Object) this.third_party, (Object) prepayRequest.third_party) && Intrinsics.areEqual((Object) this.pay_tip_confirmed, (Object) prepayRequest.pay_tip_confirmed);
    }

    public int hashCode() {
        int hashCode = ((this.out_trade_id.hashCode() * 31) + this.user_select.hashCode()) * 31;
        String str = this.redirect_scheme;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.merchant_wsgenv;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.password_token;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cvv;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.third_party.hashCode()) * 31;
        Boolean bool = this.pay_tip_confirmed;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "PrepayRequest(out_trade_id=" + this.out_trade_id + ", user_select=" + this.user_select + ", redirect_scheme=" + this.redirect_scheme + ", merchant_wsgenv=" + this.merchant_wsgenv + ", password_token=" + this.password_token + ", cvv=" + this.cvv + ", third_party=" + this.third_party + ", pay_tip_confirmed=" + this.pay_tip_confirmed + VersionRange.RIGHT_OPEN;
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.out_trade_id = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PrepayRequest(java.lang.String r10, java.util.List r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, com.didi.global.fintech.cashier.model.net.request.PrepayRequest.ThirdParty r16, java.lang.Boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0016
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            goto L_0x0017
        L_0x0016:
            r2 = r11
        L_0x0017:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x001e
            r3 = r4
            goto L_0x001f
        L_0x001e:
            r3 = r12
        L_0x001f:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0025
            r5 = r4
            goto L_0x0026
        L_0x0025:
            r5 = r13
        L_0x0026:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002c
            r6 = r4
            goto L_0x002d
        L_0x002c:
            r6 = r14
        L_0x002d:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0033
            r7 = r4
            goto L_0x0034
        L_0x0033:
            r7 = r15
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003e
            com.didi.global.fintech.cashier.model.net.request.PrepayRequest$ThirdParty r8 = new com.didi.global.fintech.cashier.model.net.request.PrepayRequest$ThirdParty
            r8.<init>()
            goto L_0x0040
        L_0x003e:
            r8 = r16
        L_0x0040:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r4 = r17
        L_0x0047:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r4
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.request.PrepayRequest.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.didi.global.fintech.cashier.model.net.request.PrepayRequest$ThirdParty, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<BasicPayment> getUser_select() {
        return this.user_select;
    }

    public final void setUser_select(List<BasicPayment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.user_select = list;
    }

    public final String getRedirect_scheme() {
        return this.redirect_scheme;
    }

    public final void setRedirect_scheme(String str) {
        this.redirect_scheme = str;
    }

    public final String getMerchant_wsgenv() {
        return this.merchant_wsgenv;
    }

    public final void setMerchant_wsgenv(String str) {
        this.merchant_wsgenv = str;
    }

    public final String getPassword_token() {
        return this.password_token;
    }

    public final void setPassword_token(String str) {
        this.password_token = str;
    }

    public final String getCvv() {
        return this.cvv;
    }

    public final void setCvv(String str) {
        this.cvv = str;
    }

    public final ThirdParty getThird_party() {
        return this.third_party;
    }

    public final void setThird_party(ThirdParty thirdParty) {
        Intrinsics.checkNotNullParameter(thirdParty, "<set-?>");
        this.third_party = thirdParty;
    }

    public final Boolean getPay_tip_confirmed() {
        return this.pay_tip_confirmed;
    }

    public final void setPay_tip_confirmed(Boolean bool) {
        this.pay_tip_confirmed = bool;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThirdParty;", "", "()V", "three_ds", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDS;", "getThree_ds", "()Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDS;", "setThree_ds", "(Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDS;)V", "three_ds_v2", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "getThree_ds_v2", "()Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "setThree_ds_v2", "(Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;)V", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepayRequest.kt */
    public static final class ThirdParty {
        private ThreeDS three_ds;
        private ThreeDSV2 three_ds_v2;

        public ThirdParty() {
            ThreeDS threeDS = new ThreeDS();
            threeDS.setCallback_schema(ICashierFacade.DefaultImpls.getParamByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.ThreeDS, GlobalCashierThreeDSModule.CALLBACK_SCHEME, (String) null, 4, (Object) null));
            threeDS.setSupport_vendor(ICashierFacade.DefaultImpls.getParamListByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.ThreeDS, GlobalCashierThreeDSModule.SUPPORT_VENDOR, (String) null, 4, (Object) null));
            Unit unit = Unit.INSTANCE;
            this.three_ds = threeDS;
        }

        public final ThreeDS getThree_ds() {
            return this.three_ds;
        }

        public final void setThree_ds(ThreeDS threeDS) {
            Intrinsics.checkNotNullParameter(threeDS, "<set-?>");
            this.three_ds = threeDS;
        }

        public final ThreeDSV2 getThree_ds_v2() {
            return this.three_ds_v2;
        }

        public final void setThree_ds_v2(ThreeDSV2 threeDSV2) {
            this.three_ds_v2 = threeDSV2;
        }
    }

    public PrepayRequest(String str, List<BasicPayment> list, String str2, String str3, String str4, String str5, ThirdParty thirdParty, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        Intrinsics.checkNotNullParameter(list, "user_select");
        Intrinsics.checkNotNullParameter(thirdParty, "third_party");
        this.out_trade_id = str;
        this.user_select = list;
        this.redirect_scheme = str2;
        this.merchant_wsgenv = str3;
        this.password_token = str4;
        this.cvv = str5;
        this.third_party = thirdParty;
        this.pay_tip_confirmed = bool;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDS;", "Ljava/io/Serializable;", "()V", "callback_schema", "", "getCallback_schema", "()Ljava/lang/String;", "setCallback_schema", "(Ljava/lang/String;)V", "support_vendor", "", "getSupport_vendor", "()Ljava/util/List;", "setSupport_vendor", "(Ljava/util/List;)V", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepayRequest.kt */
    public static final class ThreeDS implements Serializable {
        private String callback_schema;
        private List<String> support_vendor;

        public final List<String> getSupport_vendor() {
            return this.support_vendor;
        }

        public final void setSupport_vendor(List<String> list) {
            this.support_vendor = list;
        }

        public final String getCallback_schema() {
            return this.callback_schema;
        }

        public final void setCallback_schema(String str) {
            this.callback_schema = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "Ljava/io/Serializable;", "()V", "channelNameOf3ds", "", "getChannelNameOf3ds", "()Ljava/lang/String;", "setChannelNameOf3ds", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "liabilityShift", "", "getLiabilityShift", "()Ljava/lang/Boolean;", "setLiabilityShift", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "resultOf3ds", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2Result;", "getResultOf3ds", "()Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2Result;", "setResultOf3ds", "(Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2Result;)V", "status", "getStatus", "setStatus", "version", "getVersion", "setVersion", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepayRequest.kt */
    public static final class ThreeDSV2 implements Serializable {
        private String channelNameOf3ds = "cybersource";
        private String description;
        private Boolean liabilityShift;
        private ThreeDSV2Result resultOf3ds = new ThreeDSV2Result((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        private String status;
        private String version;

        public final String getStatus() {
            return this.status;
        }

        public final void setStatus(String str) {
            this.status = str;
        }

        public final String getDescription() {
            return this.description;
        }

        public final void setDescription(String str) {
            this.description = str;
        }

        public final String getVersion() {
            return this.version;
        }

        public final void setVersion(String str) {
            this.version = str;
        }

        public final Boolean getLiabilityShift() {
            return this.liabilityShift;
        }

        public final void setLiabilityShift(Boolean bool) {
            this.liabilityShift = bool;
        }

        public final ThreeDSV2Result getResultOf3ds() {
            return this.resultOf3ds;
        }

        public final void setResultOf3ds(ThreeDSV2Result threeDSV2Result) {
            this.resultOf3ds = threeDSV2Result;
        }

        public final String getChannelNameOf3ds() {
            return this.channelNameOf3ds;
        }

        public final void setChannelNameOf3ds(String str) {
            this.channelNameOf3ds = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\""}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2Result;", "Ljava/io/Serializable;", "cavv", "", "eci", "xid", "transactionId", "authenResponse", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthenResponse", "()Ljava/lang/String;", "setAuthenResponse", "(Ljava/lang/String;)V", "getCavv", "setCavv", "getEci", "setEci", "getTransactionId", "setTransactionId", "getXid", "setXid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepayRequest.kt */
    public static final class ThreeDSV2Result implements Serializable {
        private String authenResponse;
        private String cavv;
        private String eci;
        private String transactionId;
        private String xid;

        public ThreeDSV2Result() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ThreeDSV2Result copy$default(ThreeDSV2Result threeDSV2Result, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = threeDSV2Result.cavv;
            }
            if ((i & 2) != 0) {
                str2 = threeDSV2Result.eci;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = threeDSV2Result.xid;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = threeDSV2Result.transactionId;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = threeDSV2Result.authenResponse;
            }
            return threeDSV2Result.copy(str, str6, str7, str8, str5);
        }

        public final String component1() {
            return this.cavv;
        }

        public final String component2() {
            return this.eci;
        }

        public final String component3() {
            return this.xid;
        }

        public final String component4() {
            return this.transactionId;
        }

        public final String component5() {
            return this.authenResponse;
        }

        public final ThreeDSV2Result copy(String str, String str2, String str3, String str4, String str5) {
            return new ThreeDSV2Result(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ThreeDSV2Result)) {
                return false;
            }
            ThreeDSV2Result threeDSV2Result = (ThreeDSV2Result) obj;
            return Intrinsics.areEqual((Object) this.cavv, (Object) threeDSV2Result.cavv) && Intrinsics.areEqual((Object) this.eci, (Object) threeDSV2Result.eci) && Intrinsics.areEqual((Object) this.xid, (Object) threeDSV2Result.xid) && Intrinsics.areEqual((Object) this.transactionId, (Object) threeDSV2Result.transactionId) && Intrinsics.areEqual((Object) this.authenResponse, (Object) threeDSV2Result.authenResponse);
        }

        public int hashCode() {
            String str = this.cavv;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.eci;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.xid;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.transactionId;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.authenResponse;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "ThreeDSV2Result(cavv=" + this.cavv + ", eci=" + this.eci + ", xid=" + this.xid + ", transactionId=" + this.transactionId + ", authenResponse=" + this.authenResponse + VersionRange.RIGHT_OPEN;
        }

        public ThreeDSV2Result(String str, String str2, String str3, String str4, String str5) {
            this.cavv = str;
            this.eci = str2;
            this.xid = str3;
            this.transactionId = str4;
            this.authenResponse = str5;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ ThreeDSV2Result(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
            /*
                r4 = this;
                r11 = r10 & 1
                r0 = 0
                if (r11 == 0) goto L_0x0007
                r11 = r0
                goto L_0x0008
            L_0x0007:
                r11 = r5
            L_0x0008:
                r5 = r10 & 2
                if (r5 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r6
            L_0x000f:
                r5 = r10 & 4
                if (r5 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r7
            L_0x0016:
                r5 = r10 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r10 & 16
                if (r5 == 0) goto L_0x0023
                r10 = r0
                goto L_0x0024
            L_0x0023:
                r10 = r9
            L_0x0024:
                r5 = r4
                r6 = r11
                r7 = r1
                r8 = r2
                r9 = r3
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.request.PrepayRequest.ThreeDSV2Result.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getCavv() {
            return this.cavv;
        }

        public final void setCavv(String str) {
            this.cavv = str;
        }

        public final String getEci() {
            return this.eci;
        }

        public final void setEci(String str) {
            this.eci = str;
        }

        public final String getXid() {
            return this.xid;
        }

        public final void setXid(String str) {
            this.xid = str;
        }

        public final String getTransactionId() {
            return this.transactionId;
        }

        public final void setTransactionId(String str) {
            this.transactionId = str;
        }

        public final String getAuthenResponse() {
            return this.authenResponse;
        }

        public final void setAuthenResponse(String str) {
            this.authenResponse = str;
        }
    }
}
