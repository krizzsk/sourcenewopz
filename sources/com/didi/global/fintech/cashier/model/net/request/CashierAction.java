package com.didi.global.fintech.cashier.model.net.request;

import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0010J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0006\u0010 \u001a\u00020\u0010R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\""}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "Ljava/io/Serializable;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "actionData", "Lcom/didi/global/fintech/cashier/model/net/request/CashierActionData;", "getActionData", "()Lcom/didi/global/fintech/cashier/model/net/request/CashierActionData;", "setActionData", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierActionData;)V", "closeCashier", "", "confirmPay", "openUrl", "password", "pix", "pixCode", "randomVerify", "showLoadingView", "threeDS", "threeDSData", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "threeDSResult", "", "()Ljava/lang/Integer;", "threeDSV2", "toString", "updateCardInfo", "Companion", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierAction.kt */
public class CashierAction implements Serializable {
    public static final String ACTION_ADD_CARD = "add_card";
    public static final String ACTION_CLOSE_CASHIER = "close_cashier";
    public static final String ACTION_CONFIRM_PAY = "confirm_pay";
    public static final String ACTION_OPEN_URL = "open_url";
    public static final String ACTION_PASSWORD = "password";
    public static final String ACTION_PIX_CODE = "pix_code";
    public static final String ACTION_RANDOM_VERIFY = "random_verify";
    public static final String ACTION_SIGN_UP = "sign_up";
    public static final String ACTION_THREE_DS = "three_ds";
    public static final String ACTION_THREE_DS_V2 = "three_ds_v2";
    public static final String ACTION_TOP_UP = "top_up";
    public static final String ACTION_UPDATE_CARD_INFO = "update_card_info";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("action")
    private String action;
    @SerializedName("action_data")
    private CashierActionData actionData;

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        this.action = str;
    }

    public final CashierActionData getActionData() {
        return this.actionData;
    }

    public final void setActionData(CashierActionData cashierActionData) {
        this.actionData = cashierActionData;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0018\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/CashierAction$Companion;", "", "()V", "ACTION_ADD_CARD", "", "ACTION_CLOSE_CASHIER", "ACTION_CONFIRM_PAY", "ACTION_OPEN_URL", "ACTION_PASSWORD", "ACTION_PIX_CODE", "ACTION_RANDOM_VERIFY", "ACTION_SIGN_UP", "ACTION_THREE_DS", "ACTION_THREE_DS_V2", "ACTION_TOP_UP", "ACTION_UPDATE_CARD_INFO", "insAddCard", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "productId", "appId", "insCloseCashier", "status", "insOpenUrl", "url", "insSignUp", "insTopUp", "pubSource", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CashierAction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CashierAction insAddCard(String str, String str2) {
            CashierAction cashierAction = new CashierAction();
            cashierAction.setAction("add_card");
            CashierActionData cashierActionData = r0;
            CashierActionData cashierActionData2 = new CashierActionData((String) null, (Integer) null, (String) null, (String) null, (String) null, (Map) null, (String) null, (String) null, (CVVCardInfo) null, (String) null, (String) null, str, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, str2, "8", (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, 267646975, (DefaultConstructorMarker) null);
            CashierAction cashierAction2 = cashierAction;
            cashierAction2.setActionData(cashierActionData);
            return cashierAction2;
        }

        public final CashierAction insTopUp(String str) {
            CashierAction cashierAction = new CashierAction();
            cashierAction.setAction(CashierAction.ACTION_TOP_UP);
            CashierActionData cashierActionData = r0;
            CashierActionData cashierActionData2 = new CashierActionData((String) null, (Integer) null, (String) null, (String) null, (String) null, (Map) null, (String) null, (String) null, (CVVCardInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, 267386879, (DefaultConstructorMarker) null);
            CashierAction cashierAction2 = cashierAction;
            cashierAction2.setActionData(cashierActionData);
            return cashierAction2;
        }

        public final CashierAction insSignUp() {
            CashierAction cashierAction = new CashierAction();
            cashierAction.setAction("sign_up");
            cashierAction.setActionData(new CashierActionData((String) null, (Integer) null, (String) null, (String) null, (String) null, (Map) null, (String) null, (String) null, (CVVCardInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, 268435455, (DefaultConstructorMarker) null));
            return cashierAction;
        }

        public final CashierAction insOpenUrl(String str) {
            CashierAction cashierAction = new CashierAction();
            cashierAction.setAction(CashierAction.ACTION_OPEN_URL);
            CashierActionData cashierActionData = r0;
            CashierActionData cashierActionData2 = new CashierActionData((String) null, (Integer) null, (String) null, (String) null, (String) null, (Map) null, (String) null, (String) null, (CVVCardInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, str, (String) null, 201326591, (DefaultConstructorMarker) null);
            CashierAction cashierAction2 = cashierAction;
            cashierAction2.setActionData(cashierActionData);
            return cashierAction2;
        }

        public final CashierAction insCloseCashier(String str) {
            CashierAction cashierAction = new CashierAction();
            cashierAction.setAction(CashierAction.ACTION_CLOSE_CASHIER);
            CashierActionData cashierActionData = r0;
            CashierActionData cashierActionData2 = new CashierActionData((String) null, (Integer) null, (String) null, (String) null, (String) null, (Map) null, (String) null, (String) null, (CVVCardInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, str, 134217727, (DefaultConstructorMarker) null);
            CashierAction cashierAction2 = cashierAction;
            cashierAction2.setActionData(cashierActionData);
            return cashierAction2;
        }
    }

    public final boolean showLoadingView() {
        return threeDSV2();
    }

    public final boolean pix() {
        String str = this.action;
        return str != null && str.equals(ACTION_PIX_CODE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getQr_code_data();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String pixCode() {
        /*
            r2 = this;
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r0 = r2.actionData
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            goto L_0x000f
        L_0x0007:
            java.lang.String r0 = r0.getQr_code_data()
            if (r0 != 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.request.CashierAction.pixCode():java.lang.String");
    }

    public final boolean threeDS() {
        String str = this.action;
        return str != null && str.equals(ACTION_THREE_DS);
    }

    public final GlobalCashierAdyen3DSModel threeDSData() {
        Map<?, ?> map = null;
        GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel = new GlobalCashierAdyen3DSModel((String) null, (String) null, (String) null, (Integer) null, (Map) null, (String) null, 63, (DefaultConstructorMarker) null);
        CashierActionData actionData2 = getActionData();
        globalCashierAdyen3DSModel.setReference(actionData2 == null ? null : actionData2.getReference());
        CashierActionData actionData3 = getActionData();
        globalCashierAdyen3DSModel.setVendor(actionData3 == null ? null : actionData3.getVendor());
        CashierActionData actionData4 = getActionData();
        globalCashierAdyen3DSModel.setShopper(actionData4 == null ? null : actionData4.getShopper());
        CashierActionData actionData5 = getActionData();
        if (actionData5 != null) {
            map = actionData5.getAction();
        }
        globalCashierAdyen3DSModel.setAction(map);
        return globalCashierAdyen3DSModel;
    }

    public final Integer threeDSResult() {
        CashierActionData cashierActionData = this.actionData;
        if (cashierActionData == null) {
            return null;
        }
        return cashierActionData.getThreeDSResult();
    }

    public final boolean threeDSV2() {
        String str = this.action;
        return str != null && str.equals(ACTION_THREE_DS_V2);
    }

    public final boolean randomVerify() {
        String str = this.action;
        return str != null && str.equals(ACTION_RANDOM_VERIFY);
    }

    public final boolean updateCardInfo() {
        String str = this.action;
        return str != null && str.equals(ACTION_UPDATE_CARD_INFO);
    }

    public final boolean password() {
        String str = this.action;
        return str != null && str.equals(ACTION_PASSWORD);
    }

    public final boolean confirmPay() {
        String str = this.action;
        return str != null && str.equals(ACTION_CONFIRM_PAY);
    }

    public final boolean openUrl() {
        String str = this.action;
        return str != null && str.equals(ACTION_OPEN_URL);
    }

    public final boolean closeCashier() {
        String str = this.action;
        return str != null && str.equals(ACTION_CLOSE_CASHIER);
    }

    public String toString() {
        return "CashierAction(action=" + this.action + ", actionData=" + this.actionData + VersionRange.RIGHT_OPEN;
    }
}
