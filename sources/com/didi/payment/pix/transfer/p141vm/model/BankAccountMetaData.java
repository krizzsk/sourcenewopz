package com.didi.payment.pix.transfer.p141vm.model;

import com.didi.sdk.util.TextUtil;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\u001a\u0010#\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001c\u0010&\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000e¨\u0006,"}, mo175978d2 = {"Lcom/didi/payment/pix/transfer/vm/model/BankAccountMetaData;", "Ljava/io/Serializable;", "()V", "accountType", "", "getAccountType", "()I", "setAccountType", "(I)V", "agency", "", "getAgency", "()Ljava/lang/String;", "setAgency", "(Ljava/lang/String;)V", "cardNo", "getCardNo", "setCardNo", "cpf", "getCpf", "setCpf", "cpf4Display", "getCpf4Display", "setCpf4Display", "isSameCpf", "", "()Z", "setSameCpf", "(Z)V", "payeeName", "getPayeeName", "setPayeeName", "pspId", "getPspId", "setPspId", "pspName", "getPspName", "setPspName", "showCardId", "getShowCardId", "setShowCardId", "toBizContent", "Lorg/json/JSONObject;", "valid", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.transfer.vm.model.BankAccountMetaData */
/* compiled from: BankAccountMetaData.kt */
public final class BankAccountMetaData implements Serializable {
    private int accountType;
    public String agency;
    public String cardNo;
    public String cpf;
    public String cpf4Display;
    private boolean isSameCpf;
    public String payeeName;
    public String pspId;
    public String pspName;
    private String showCardId;

    public final String getPayeeName() {
        String str = this.payeeName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("payeeName");
        return null;
    }

    public final void setPayeeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payeeName = str;
    }

    public final String getCpf() {
        String str = this.cpf;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cpf");
        return null;
    }

    public final void setCpf(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cpf = str;
    }

    public final String getCpf4Display() {
        String str = this.cpf4Display;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cpf4Display");
        return null;
    }

    public final void setCpf4Display(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cpf4Display = str;
    }

    public final String getPspId() {
        String str = this.pspId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pspId");
        return null;
    }

    public final void setPspId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pspId = str;
    }

    public final String getPspName() {
        String str = this.pspName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pspName");
        return null;
    }

    public final void setPspName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pspName = str;
    }

    public final String getAgency() {
        String str = this.agency;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("agency");
        return null;
    }

    public final void setAgency(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.agency = str;
    }

    public final String getCardNo() {
        String str = this.cardNo;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cardNo");
        return null;
    }

    public final void setCardNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardNo = str;
    }

    public final String getShowCardId() {
        return this.showCardId;
    }

    public final void setShowCardId(String str) {
        this.showCardId = str;
    }

    public final int getAccountType() {
        return this.accountType;
    }

    public final void setAccountType(int i) {
        this.accountType = i;
    }

    public final boolean isSameCpf() {
        return this.isSameCpf;
    }

    public final void setSameCpf(boolean z) {
        this.isSameCpf = z;
    }

    public final JSONObject toBizContent() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("order_type", 0);
        jSONObject.put("pspId", getPspId());
        jSONObject.put("pspName", getPspName());
        jSONObject.put("name", getPayeeName());
        jSONObject.put("cpf", getCpf());
        jSONObject.put("agency", getAgency());
        jSONObject.put("cardId", getCardNo());
        jSONObject.put("accountType", this.accountType);
        return jSONObject;
    }

    public final boolean valid() {
        return !TextUtil.isEmpty(getCpf());
    }
}
