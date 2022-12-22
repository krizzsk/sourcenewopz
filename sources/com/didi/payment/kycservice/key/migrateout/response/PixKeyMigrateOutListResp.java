package com.didi.payment.kycservice.key.migrateout.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$Data;", "getData", "()Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$Data;", "setData", "(Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$Data;)V", "Data", "KeyItem", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyMigrateOutListResp.kt */
public final class PixKeyMigrateOutListResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR2\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$Data;", "", "()V", "cancelButton", "", "getCancelButton", "()Ljava/lang/String;", "setCancelButton", "(Ljava/lang/String;)V", "confirmButton", "getConfirmButton", "setConfirmButton", "items", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$KeyItem;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "title", "getTitle", "setTitle", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyMigrateOutListResp.kt */
    public static final class Data {
        private String cancelButton;
        private String confirmButton;
        @SerializedName("migrateOutList")
        private ArrayList<KeyItem> items;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getConfirmButton() {
            return this.confirmButton;
        }

        public final void setConfirmButton(String str) {
            this.confirmButton = str;
        }

        public final String getCancelButton() {
            return this.cancelButton;
        }

        public final void setCancelButton(String str) {
            this.cancelButton = str;
        }

        public final ArrayList<KeyItem> getItems() {
            return this.items;
        }

        public final void setItems(ArrayList<KeyItem> arrayList) {
            this.items = arrayList;
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$KeyItem;", "", "()V", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "imgUrl", "getImgUrl", "setImgUrl", "portOutTo", "getPortOutTo", "setPortOutTo", "resultData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "type", "", "getType", "()I", "setType", "(I)V", "value", "getValue", "setValue", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyMigrateOutListResp.kt */
    public static final class KeyItem {
        private String desc = "";
        private String imgUrl = "";
        private String portOutTo = "";
        @SerializedName("resultEntryFormat")
        private ResultPageData resultData;
        private int type = -100;
        private String value = "";

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setValue(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.value = str;
        }

        public final String getImgUrl() {
            return this.imgUrl;
        }

        public final void setImgUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imgUrl = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }

        public final String getPortOutTo() {
            return this.portOutTo;
        }

        public final void setPortOutTo(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.portOutTo = str;
        }

        public final ResultPageData getResultData() {
            return this.resultData;
        }

        public final void setResultData(ResultPageData resultPageData) {
            this.resultData = resultPageData;
        }
    }
}
