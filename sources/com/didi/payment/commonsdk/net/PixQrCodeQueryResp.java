package com.didi.payment.commonsdk.net;

import com.didi.payment.commonsdk.fragment.QRDetectedDialog;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;", "getData", "()Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;", "setData", "(Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;)V", "QRCodeData", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixQrCodeQueryResp.kt */
public final class PixQrCodeQueryResp extends WBaseResp {
    @SerializedName("data")
    public QRCodeData data;

    public QRCodeData getData() {
        QRCodeData qRCodeData = this.data;
        if (qRCodeData != null) {
            return qRCodeData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public void setData(QRCodeData qRCodeData) {
        Intrinsics.checkNotNullParameter(qRCodeData, "<set-?>");
        this.data = qRCodeData;
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u0006\u0010'\u001a\u00020(R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R \u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\"\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\t¨\u0006)"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;", "Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogData;", "Ljava/io/Serializable;", "()V", "amount", "", "getAmount", "()Ljava/lang/Integer;", "setAmount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "country", "", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "currency", "getCurrency", "setCurrency", "description", "getDescription", "setDescription", "key", "getKey", "setKey", "name", "getName", "setName", "qrReferenceId", "getQrReferenceId", "setQrReferenceId", "qrType", "getQrType", "setQrType", "getConfirmBtnText", "getNegativeBtnText", "getSubtitle", "getTitle", "toBizContent", "Lorg/json/JSONObject;", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixQrCodeQueryResp.kt */
    public static class QRCodeData implements QRDetectedDialog.DialogData, Serializable {
        @SerializedName("amount")
        private Integer amount;
        @SerializedName("country")
        private String country;
        @SerializedName("currency")
        private String currency;
        @SerializedName("description")
        private String description;
        @SerializedName("key")
        private String key;
        @SerializedName("name")
        private String name;
        private String qrReferenceId;
        @SerializedName("qrType")
        private Integer qrType;

        public String getConfirmBtnText() {
            return "ok";
        }

        public String getNegativeBtnText() {
            return "not now";
        }

        public String getSubtitle() {
            return "";
        }

        public final JSONObject toBizContent() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("order_type", 0);
            jSONObject.put("key", this.key);
            jSONObject.put("qrType", this.qrType);
            jSONObject.put("qrReference", this.qrReferenceId);
            return jSONObject;
        }

        public final Integer getQrType() {
            return this.qrType;
        }

        public final void setQrType(Integer num) {
            this.qrType = num;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final Integer getAmount() {
            return this.amount;
        }

        public final void setAmount(Integer num) {
            this.amount = num;
        }

        public final String getDescription() {
            return this.description;
        }

        public final void setDescription(String str) {
            this.description = str;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final String getCountry() {
            return this.country;
        }

        public final void setCountry(String str) {
            this.country = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getQrReferenceId() {
            return this.qrReferenceId;
        }

        public final void setQrReferenceId(String str) {
            this.qrReferenceId = str;
        }

        public String getTitle() {
            return String.valueOf(this.name);
        }
    }
}
